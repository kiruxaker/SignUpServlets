package servlet.servlet.servlets;

import org.apache.log4j.Logger;
import servlet.exception.AppException;
import servlet.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * This is servlet class for login page
 *
 * @author kirillparolys
 * @version 1.1
 */
@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends InitServlet {

    private static final Logger LOG = Logger.getLogger(LoginServlet.class);
    User user = new User();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("email", user.getEmail());
        req.setAttribute("password", user.getPass());

        req.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        user.setEmail(req.getParameter("email"));
        user.setPass(req.getParameter("password"));

        try {
            LOG.info("Checking user parameters");
            User user1 = getService().login(user.getEmail(), user.getPass());

            LOG.info("Creating user session");
            HttpSession session = req.getSession(true);
            session.setAttribute("inSystem", true);
            session.setAttribute("currentUserName", user1.getName());

            LOG.info("Redirecting to the main page");
            resp.sendRedirect("index.jsp");

            LOG.info("Login successful");
        } catch (AppException e) {
            LOG.error(e);
            req.setAttribute("errorTitle", AppException.class.getCanonicalName());
            req.setAttribute("errorMassege", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(req, resp);
        }



    }
}


