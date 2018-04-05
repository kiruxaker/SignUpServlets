package servlet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servlet.dao.Dao;
import servlet.exception.AppException;
import servlet.model.User;
import servlet.validator.Validator;

import java.util.List;

@Service(value = "service")
public class UserServiceImpl implements UserService {

    @Autowired
    private Dao<User> userDao;
    @Autowired
    private Validator validator;


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

    @Override
    @Transactional
    public User addUser(User user) throws AppException {
        if (user != null && validator.checkUser(user) == false) throw new AppException("Invalid email or pass");
        return userDao.save(user);
    }

    @Override
    @Transactional
    public List<User> allUsers() {
        return userDao.findAll();
    }
}
