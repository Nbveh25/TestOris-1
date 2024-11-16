package servlet;

import Utils.PasswordUtil;
import dao.LogDAO;
import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Log;
import model.User;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register-servlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirm-password");

        UserDAO userDAO = new UserDAO();
        LogDAO logDAO = new LogDAO();

        if (password.equals(confirmPassword)) {
            if (!userDAO.existsByLogin(login)) {
                userDAO.save(new User(login, email, PasswordUtil.hashPassword(password)));
                logDAO.save(new Log(login));
            }
        }
    }
}