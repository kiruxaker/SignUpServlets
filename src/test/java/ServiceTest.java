import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import servlet.exception.AppException;
import servlet.model.User;
import servlet.service.UserService;
import servlet.service.UserServiceImpl;

import javax.persistence.EntityManagerFactory;
import java.util.List;

import static org.junit.Assert.*;

public class ServiceTest {

    private UserService service;
    private ApplicationContext context;

    @Before
    public void upClass() throws AppException {
        context = new AnnotationConfigApplicationContext("servlet");
        service = context.getBean(UserServiceImpl.class);
        User user1 = new User();
        user1.setEmail("ivan@g.com");
        user1.setPass("1234");
        user1.setName("ivan");
        User user2 = new User();
        user2.setEmail("kolia@g.com");
        user2.setPass("12345");
        user2.setName("kolia");
        service.addUser(user1);
        service.addUser(user2);

    }

    @After
    public void dropTables() {
        EntityManagerFactory factory = (EntityManagerFactory) context.getBean("entityManagerFactoryBean");
        factory.close();
    }

    @Test
    public void loginTest() throws AppException {
        User user = service.login("ivan@g.com", "1234");
        assertNotNull(user);
        assertEquals(user.getName(), "ivan");
        assertEquals(user.getEmail(), "ivan@g.com");
    }

    @Test
    public void findAllTest() throws AppException {
        User user3 = new User();
        user3.setEmail("max@g.com");
        user3.setPass("12345");
        user3.setName("max");
        service.addUser(user3);
        List<User> users = service.allUsers();
        assertEquals(users.size() , 3);
        assertTrue(users.contains(user3));
    }

    @Test(expected = AppException.class)
    public void negativeLoginTest() throws AppException {
        service.addUser(new User());
    }

}
