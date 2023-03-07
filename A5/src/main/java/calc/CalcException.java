package calc;

/**
 * Exception to be thrown by the Calculator.
 */
public class CalcException extends Exception {

    public CalcException(String message, Throwable cause) {
        super(message, cause);
    }

    public CalcException(String message) {
        super(message);
    }
}
