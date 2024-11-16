package service;

import Utils.PasswordUtil;
import dto.UserRegistrationDTO;
import dao.UserDAO;
import model.User;

public class UserService {

    private static final UserDAO userDao = new UserDAO();

    public void register(UserRegistrationDTO user) {
        if (userDao.existsByLogin(user.getLogin())) {
            throw new IllegalArgumentException("Пользователь с таким логином уже существует.");
        } else {
            userDao.save(new User(
                    user.getLogin(),
                    user.getEmail(),
                    PasswordUtil.hashPassword(user.getPassword())
            ));
        }
    }
}