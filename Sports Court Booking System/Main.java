public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        Player john = new Player("John");
        Player alice = new Player("Alice");
        Court basketball = new Court("Basketball");
        Court tennis = new Court("Tennis");

        try {
            admin.addCourt(basketball);
            admin.addCourt(tennis);
            try {
                john.bookCourt(basketball);
                alice.bookCourt(basketball); // Expected: CourtNotAvailableException.
            } catch (CourtNotAvailableException e) {
                System.out.println("Booking rejected: " + e.getMessage());
            }

            john.cancelBooking(basketball);
            try { john.cancelBooking(basketball); }
            catch (InvalidBookingException e) { System.out.println("Cancellation rejected: " + e.getMessage()); }

            try { admin.findCourt("Swimming"); }
            catch (CourtNotFoundException e) { System.out.println("Search failed: " + e.getMessage()); }
        } catch (InvalidBookingException e) {
            System.out.println("Booking error: " + e.getMessage());
        } finally {
            System.out.println("Booking session closed.");
        }
    }
}
