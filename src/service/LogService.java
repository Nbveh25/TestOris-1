package service;

import dao.LogDAO;
import dto.LogDTO;
import model.Log;

public class LogService {

    private final LogDAO logDAO = new LogDAO();

    public void saveLog(LogDTO logDTO) {
        logDAO.save(new Log(logDTO.getLogin()));
    }
}
