package servlet.servlet.servlets;

import org.apache.log4j.Logger;
import servlet.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author kirillparolys
 * @version 1.1
 *
 * @see InitServlet
 */
@WebServlet({"/all-users"})
public class AllUsersServlet extends InitServlet {

    private static final Logger LOGGER = Logger.getLogger(AllUsersServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Searching for all users in db...");

        List<User> usersList = getService().allUsers();
        req.setAttribute("users", usersList);

        req.getRequestDispatcher("/WEB-INF/pages/all-users.jsp").forward(req,resp);
    }
}
