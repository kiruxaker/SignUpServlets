package servlet.service;

import servlet.exception.AppException;
import servlet.model.User;

import java.util.List;

/**
 * @author kirillparolys
 * @version 1.1
 */
public interface UserService {

    /**
     * Logs into the system, previously checking his email and pass by validator
     *
     * @param email email of the user
     * @param pass pass of the user
     *
     * @return logged in user
     *
     * @throws AppException
     */
    User login(String email, String pass) throws AppException;

    /**
     * Adds user to the database, actually just uses save method from Dao
     *
     * @param user user which will be saved
     * @return saved user
     * @throws AppException
     * @see servlet.dao.UserDaoImpl
     */
    User addUser(User user) throws AppException;

    /**
     * Lists all users
     * @return list of users
     */
    List<User> allUsers();
}
