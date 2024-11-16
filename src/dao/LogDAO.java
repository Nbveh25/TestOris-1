package dao;

import Utils.DataBaseUtil;
import model.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LogDAO {

    public void save(Log log) {
        String sql = "INSERT INTO log (login) VALUES (?)";

        try (Connection connection = DataBaseUtil.getConnection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, log.getLogin());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка при сохранении записи в лог", e);
        }
    }
}