package servlet.servlet.servlets;

import org.apache.log4j.Logger;
import servlet.exception.AppException;
import servlet.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends InitServlet {

    private static final Logger LOGGER = Logger.getLogger(RegisterServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Registering new user...");
        User user = new User(req.getParameter("name"), req.getParameter("email"), req.getParameter("password"));

        try {
            User user1 = getService().addUser(user);
            req.setAttribute("user", user1);
            LOGGER.info("Register successful");
            req.getRequestDispatcher("/WEB-INF/pages/user-info.jsp").forward(req, resp);
        } catch (AppException e) {
            LOGGER.error(e);
            req.setAttribute("errorTitle", AppException.class.getCanonicalName());
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("WEB-INF/pages/error.jsp").forward(req, resp);
        }

    }
}

