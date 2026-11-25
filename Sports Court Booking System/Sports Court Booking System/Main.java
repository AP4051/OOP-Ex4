public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        Player player1 = new Player("John");
        Player player2 = new Player("Alice");
        Court basketballCourt = new Court("Basketball");
        Court tennisCourt = new Court("Tennis");

        try {
            admin.addCourt(basketballCourt);
            admin.addCourt(tennisCourt);
            admin.addCourt(new Court(" "));   // invalid sport type
        } catch (InvalidBookingException e) {
            System.out.println("InvalidBookingException: " + e.getMessage());
        }

        try {
            // Normal booking
            player1.bookCourt(basketballCourt);

            // 1. Double booking
            player2.bookCourt(basketballCourt);
        } catch (CourtNotAvailableException e) {
            System.out.println("CourtNotAvailableException: " + e.getMessage());
        } catch (InvalidBookingException e) {
            System.out.println("InvalidBookingException: " + e.getMessage());
        } finally {
            System.out.println("Booking attempt finished.\n");
        }

        try {
            // 2. Releasing an unbooked court
            player1.cancelBooking(tennisCourt);
        } catch (InvalidBookingException e) {
            System.out.println("InvalidBookingException: " + e.getMessage());
        } finally {
            System.out.println("Cancellation attempt finished.\n");
        }

        try {
            // 3. Searching for a court that was never added
            admin.findCourt("Swimming");
        } catch (CourtNotFoundException e) {
            System.out.println("CourtNotFoundException: " + e.getMessage());
        } finally {
            System.out.println("Search attempt finished.\n");
        }

        try {
            // Valid cancel and null court
            player1.cancelBooking(basketballCourt);
            player1.bookCourt(null);
        } catch (CourtNotAvailableException | InvalidBookingException e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        } finally {
            System.out.println("Booking session closed.");
        }
    }
}
