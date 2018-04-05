package servlet.dao;

import org.springframework.stereotype.Component;
import servlet.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component(value = "userDaoDean")
public class UserDaoImpl implements Dao<User> {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<User> findAll() {
        return manager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User save(User obj) {
        manager.persist(obj);
        return obj;
    }

    @Override
    public User findByEmail(String email) {
       return manager.createQuery("select u from User u where u.email = :email", User.class).setParameter("email", email).getSingleResult();
    }

}
