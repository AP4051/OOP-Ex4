public class InsufficientBalanceException extends Exception {
    public static final long serialVersionUID = 1L;
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
