package servlet.service;

import servlet.exception.AppException;
import servlet.model.User;

import java.util.List;

public interface UserService {

    User login(String email, String pass) throws AppException;
    User addUser(User user) throws AppException;
    List<User> allUsers();
}
