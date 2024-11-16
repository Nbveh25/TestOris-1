package dao;

import Utils.DataBaseUtil;
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
            throw new RuntimeException("Ошибка при сохранении пользователя", e);
        }
    }

    public boolean existUser(String login, String password) {
        String sql = "SELECT * FROM users WHERE login = ? AND password = ?";
        try (Connection connection = DataBaseUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, login);
                preparedStatement.setString(2, password);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return true;
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

}