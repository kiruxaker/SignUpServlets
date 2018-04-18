package servlet.servlet.servlets;

import org.springframework.context.ApplicationContext;
import servlet.service.UserService;
import servlet.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * @author kirillparolys
 * @version 1.1
 */
public abstract class InitServlet extends HttpServlet {

    private UserService service;

    /**
     * Initiates servlet context
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        ApplicationContext context = (ApplicationContext) getServletContext().getAttribute("spring-context");
        service = context.getBean(UserServiceImpl.class);
    }

    /**
     * @return instance of UserService
     *
     * @see UserService
     */
    public UserService getService() {
        return service;
    }
}
