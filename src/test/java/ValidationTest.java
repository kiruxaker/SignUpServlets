import org.junit.Test;
import servlet.model.User;
import servlet.validator.Validator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Validator test case
 *
 * @author kirillparolys
 * @version 1.1
 */
public class ValidationTest {

    private Validator validator = new Validator();

    @Test
    public void userCheckParamTest() {
        assertThat(validator.checkUser("1234@12345.123", "1234"), is(false));
    }

    @Test
    public void userCheckObjTest() {
        assertThat(validator.checkUser(new User("Kirill", "1234@12345.123", "1234")), is(false));

    }
}
