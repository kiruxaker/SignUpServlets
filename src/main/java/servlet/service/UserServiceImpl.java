package servlet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servlet.dao.Dao;
import servlet.exception.AppException;
import servlet.model.User;
import servlet.validator.Validator;

import java.util.List;

/**
 * @author kirillparolys
 * @version 1.1
 */
@Service(value = "service")
public class UserServiceImpl implements UserService {

    @Autowired
    private Dao<User> userDao;
    @Autowired
    private Validator validator;


    /**
     * Logs into the system, previously checking his email and pass by validator
     *
     * @param email email of the user
     * @param pass pass of the user
     *
     * @see Validator
     * @see servlet.dao.UserDaoImpl
     *
     * @return saved instance of user
     * @throws AppException
     */
    @Override
    @Transactional
    public User login(String email, String pass) throws AppException {
        if (validator.checkUser(email, pass) == false){
            throw new AppException("invalid email or pass");
        }
        User find = userDao.findByEmail(email);
        if (find != null && find.getPass().equals(pass)) {
            return find;
        }
        throw new AppException("wrong email or pass");
    }

    /**
     * Adds user to the database
     *
     * @param user user which will be saved
     * @return saved user
     *
     * @see User
     * @see servlet.dao.UserDaoImpl
     *
     * @throws AppException
     */
    @Override
    @Transactional
    public User addUser(User user) throws AppException {
        if (user != null && validator.checkUser(user) == false) throw new AppException("Invalid email or pass");
        return userDao.save(user);
    }

    /**
     * @return all users in database
     */
    @Override
    @Transactional
    public List<User> allUsers() {
        return userDao.findAll();
    }
}
