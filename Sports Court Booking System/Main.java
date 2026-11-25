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
            john.bookCourt(basketball);
        } catch (InvalidBookingException | CourtNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Booking attempt completed.");
        }

        try {
            alice.bookCourt(basketball); // Court is already booked
        } catch (InvalidBookingException | CourtNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Booking attempt completed.");
        }

        try {
            alice.cancelBooking(tennis); // Tennis was not booked
        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Booking attempt completed.");
        }

        try {
            admin.findCourt("Swimming");
        } catch (CourtNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Booking session closed.");
        }

        try {
            alice.cancelBooking(basketball);
        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
