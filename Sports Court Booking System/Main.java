public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        Court basketballCourt = new Court("Basketball");
        Court tennisCourt = new Court("Tennis");

        try {
            admin.addCourt(basketballCourt);
            admin.addCourt(tennisCourt);
        } catch (InvalidBookingException e) {
            System.out.println("Court registration failed: " + e.getMessage());
            return;
        }

        Player john = new Player("John");
        Player alice = new Player("Alice");

        try {
            john.bookCourt(basketballCourt);
        } catch (InvalidBookingException | CourtNotAvailableException e) {
            System.out.println("Booking failed: " + e.getMessage());
        } finally {
            System.out.println("Booking session completed.");
        }

        try {
            alice.bookCourt(basketballCourt);
        } catch (InvalidBookingException | CourtNotAvailableException e) {
            System.out.println("Booking failed: " + e.getMessage());
        } finally {
            System.out.println("Booking session completed.");
        }

        try {
            john.cancelBooking(tennisCourt);
        } catch (InvalidBookingException e) {
            System.out.println("Cancellation failed: " + e.getMessage());
        } finally {
            System.out.println("Booking session completed.");
        }

        try {
            admin.findCourt("Swimming");
        } catch (CourtNotFoundException e) {
            System.out.println("Search failed: " + e.getMessage());
        } finally {
            System.out.println("Booking session completed.");
        }

        try {
            Court courtById = admin.findCourtById(basketballCourt.getCourtId());
            alice.cancelBooking(courtById);
        } catch (CourtNotFoundException | InvalidBookingException e) {
            System.out.println("Cancellation failed: " + e.getMessage());
        } finally {
            System.out.println("Booking session completed.");
        }
    }
}
