package servlet.servlet.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SpringContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContext context = new AnnotationConfigApplicationContext("servlet");
        sce.getServletContext().setAttribute("spring-context", context);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        GenericApplicationContext applicationContext = (GenericApplicationContext) sce.getServletContext().getAttribute("spring-context");
        applicationContext.close();
    }

}
