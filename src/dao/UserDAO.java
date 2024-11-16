package dao;

import Utils.DataBaseUtil;
import Utils.PasswordUtil;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public void save(User user) {
        String sql = "INSERT INTO users_test (login, email, password) VALUES (?, ?, ?)";

        try (Connection connection = DataBaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Ошибка при сохранении пользователя: " + e.getMessage());
            throw new RuntimeException("Ошибка при сохранении пользователя", e);
        }
    }

    public boolean existsByLogin(String login) {
        String sql = "SELECT COUNT(*) FROM users_test WHERE login = ?";
        try (Connection connection = DataBaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при проверке логина: " + e.getMessage());
            throw new RuntimeException("Ошибка при проверке логина", e);
        }
        return false;
    }

    public boolean existsByPassword(String password) {
        String sql = "SELECT COUNT(*) FROM users_test WHERE password = ?";
        try (Connection connection = DataBaseUtil.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}