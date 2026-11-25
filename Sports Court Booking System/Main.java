
public class Main {
    public static void main(String[] args) {

        Admin admin = new Admin();

        Court basketballCourt = new Court("Basketball");
        Court tennisCourt = new Court("Tennis");

        // 1. Add courts
        try {
            admin.addCourt(basketballCourt);
            admin.addCourt(tennisCourt);
        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Court registration completed.\n");
        }

        Player player1 = new Player("John");
        Player player2 = new Player("Alice");

        // 2. First booking
        try {
            player1.bookCourt(basketballCourt);
        } catch (CourtNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Booking attempt completed.\n");
        }

        // 3. Double booking
        try {
            player2.bookCourt(basketballCourt);
        } catch (CourtNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Booking attempt completed.\n");
        }

        // 4. Release an unbooked court
        try {
            player1.cancelBooking(tennisCourt);
        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Cancellation attempt completed.\n");
        }

        // 5. Search for a court
        try {
            Court foundCourt = admin.findCourt("Swimming");
            System.out.println("Found: " + foundCourt.getSportType());
        } catch (CourtNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Search attempt completed.\n");
        }

        // 6. Successful cancellation
        try {
            player1.cancelBooking(basketballCourt);
        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Cancellation attempt completed.\n");
        }

        // 7. Final status
        System.out.println("Basketball available: "
                + basketballCourt.isAvailable());

        System.out.println("Tennis available: "
                + tennisCourt.isAvailable());

        System.out.println("\nBooking session closed.");
    }
}
