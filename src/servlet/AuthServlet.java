package servlet;

import dao.LogDAO;
import dao.UserDAO;
import dto.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Log;
import service.UserService;

import java.io.IOException;

@WebServlet(name = "AuthServlet", urlPatterns = "/auth-servlet")
public class AuthServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserService userService = new UserService();

        if(userService.login(new UserDTO(login, password))) {
            resp.sendRedirect("html/success.html");
        }

    }
}
