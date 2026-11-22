public class InvalidBookingException extends Exception {
    private final static long serialVersionUID = 1L;
    public InvalidBookingException(String message) {
        super(message);
    }
}
