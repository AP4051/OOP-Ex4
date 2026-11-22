public class DuplicateAccountException extends Exception {
    public static final long serialVersionUID = 1L;
    public DuplicateAccountException(String message) {
        super(message);
    }
}
