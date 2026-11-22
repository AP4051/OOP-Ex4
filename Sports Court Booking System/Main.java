public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        Court basketballCourt = new Court("Basketball");
        Court tennisCourt = new Court("Tennis");

        Player player1 = new Player("John");
        Player player2 = new Player("Alice");

        try {
            admin.addCourt(basketballCourt);
            admin.addCourt(tennisCourt);

            player1.bookCourt(basketballCourt);
            player2.bookCourt(basketballCourt);
        } catch (InvalidBookingException | CourtNotAvailableException e) {
            System.out.println("Booking Error: " + e.getMessage());
        } finally {
            System.out.println("First booking attempt finished.\n");
        }

        try {
            player1.cancelBooking(tennisCourt);
        } catch (InvalidBookingException e) {
            System.out.println("Cancellation Error: " + e.getMessage());
        } finally {
            System.out.println("Cancellation attempt finished.\n");
        }

        try {
            admin.findCourt("Swimming");
        } catch (CourtNotFoundException e) {
            System.out.println("Search Error: " + e.getMessage());
        } finally {
            System.out.println("Booking session closed.");
        }
    }
}