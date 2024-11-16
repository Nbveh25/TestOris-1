package service;

import Utils.PasswordUtil;
import dao.UserDAO;
import dto.UserDTO;
import model.User;

public class UserService {

    private final UserDAO userDAO = new UserDAO();

    public void register(UserDTO userDTO) {

        boolean equalsPass = userDTO.getPassword().equals(userDTO.getConfirmPassword());
        boolean isExist = !userDAO.existUser(userDTO.getLogin(), PasswordUtil.hashPassword(userDTO.getPassword()));

        if (equalsPass && isExist) {
            userDAO.save(
                    new User(
                            userDTO.getLogin(),
                            userDTO.getEmail(),
                            PasswordUtil.hashPassword(userDTO.getPassword())
                    )
            );
        }
    }

    public boolean login(UserDTO userDTO) {
        return userDAO.existUser(userDTO.getLogin(), PasswordUtil.hashPassword(userDTO.getPassword()));
    }

}