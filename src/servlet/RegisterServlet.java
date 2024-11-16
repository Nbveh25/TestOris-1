package servlet;

import Utils.PasswordUtil;
import dao.LogDAO;
import dao.UserDAO;
import dto.LogDTO;
import dto.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Log;
import model.User;
import service.LogService;
import service.UserService;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register-servlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirm-password");

        UserService userService = new UserService();
        LogService logService = new LogService();

        userService.register(new UserDTO(login, email, password, confirmPassword));
        logService.saveLog(new LogDTO(login));
    }
}