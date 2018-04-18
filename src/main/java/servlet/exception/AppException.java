package servlet.exception;

/**
 * @author kirillparolys
 * @version 1.1
 *
 * @see java.lang.Throwable
 */
public class AppException extends Throwable {
    public AppException(String message) {
        super(message);
    }
}
