public class AccountNotFoundException extends Exception {
    public static final long serialVersionUID = 1L;
    public AccountNotFoundException(String message) {
        super(message);
    }
}
