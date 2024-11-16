package servlet;

import dao.LogDAO;
import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Log;

import java.io.IOException;

@WebServlet(name = "AuthServlet", urlPatterns = "/auth-servlet")
public class AuthServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserDAO userDAO = new UserDAO();
        LogDAO logDAO = new LogDAO();

        logDAO.save(new Log(login));

        if (userDAO.existsByLogin(login) && !userDAO.existsByPassword(password)) {
            resp.sendRedirect("html/success.html");
        }
    }
}
