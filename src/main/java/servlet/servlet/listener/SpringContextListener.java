package servlet.servlet.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * The class which initializes and destroys Spring context
 *
 * @author kirillparolys
 * @version 1.1
 */
@WebListener
public class SpringContextListener implements ServletContextListener {

//    initializes spring context
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContext context = new AnnotationConfigApplicationContext("servlet");
        sce.getServletContext().setAttribute("spring-context", context);
    }

//    destroys spring context
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        GenericApplicationContext applicationContext = (GenericApplicationContext) sce.getServletContext().getAttribute("spring-context");
        applicationContext.close();
    }

}
