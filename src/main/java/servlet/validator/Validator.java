package servlet.validator;

import org.springframework.stereotype.Component;
import servlet.model.User;

import java.util.regex.Pattern;

@Component(value = "validator")
public class Validator {

    private final String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private final String passPattern ="^.{3,10}$";

    public boolean checkUser(String email, String pass) {
        if (pass == null || email == null) return false;
        else {
            return Pattern.compile(passPattern).matcher(pass).matches() &&
                    Pattern.compile(emailPattern).matcher(email).matches();
        }
    }

    public boolean checkUser(User user){
        return checkUser(user.getEmail(), user.getPass());
    }

}
