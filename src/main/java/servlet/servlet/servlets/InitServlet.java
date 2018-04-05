package servlet.servlet.servlets;

import org.springframework.context.ApplicationContext;
import servlet.service.UserService;
import servlet.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public abstract class InitServlet extends HttpServlet {

    private UserService service;

    @Override
    public void init() throws ServletException {
        ApplicationContext context = (ApplicationContext) getServletContext().getAttribute("spring-context");
        service = context.getBean(UserServiceImpl.class);
    }

    public UserService getService() {
        return service;
    }
}
