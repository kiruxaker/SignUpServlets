package servlet.validator;

import org.springframework.stereotype.Component;
import servlet.model.User;

import java.util.regex.Pattern;

/**
 * @author kirillparolys
 * @version 1.1
 */
@Component(value = "validator")
public class Validator {

    private final String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private final String passPattern ="^.{3,10}$";

    /**
     * Checks if user's credentials are valid
     *
     * @param email email of the user
     * @param pass email of the user
     * @return checked user
     */
    public boolean checkUser(String email, String pass) {
        if (pass == null || email == null) return false;
        else {
            return Pattern.compile(passPattern).matcher(pass).matches() &&
                    Pattern.compile(emailPattern).matcher(email).matches();
        }
    }

    /**
     * Checks if user's credentials are valid
     *
     * @param user user to check
     * @return checked user
     */
    public boolean checkUser(User user){
        return checkUser(user.getEmail(), user.getPass());
    }

}
