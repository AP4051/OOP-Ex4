public class Main {
    public static void main(String[] args) {

        Admin admin = new Admin();
        Court basketballCourt = new Court("Basketball");
        Court tennisCourt = new Court("Tennis");

        try {
            admin.addCourt(basketballCourt);
            admin.addCourt(tennisCourt);
            admin.addCourt(null);
        } catch (InvalidBookingException e) {
            System.out.println("Admin error : " + e.getMessage());
        } finally {
            System.out.println("Court setup attempt completed.");
        }

        Player john = new Player("John");
        Player alice = new Player("Alice");

        try {
            john.bookCourt(basketballCourt);
            alice.bookCourt(basketballCourt);
        } catch (CourtNotAvailableException | InvalidBookingException e) {
            System.out.println("Booking error : " + e.getMessage());
        } finally {
            System.out.println("Booking session finished.");
        }

        try {
            alice.cancelBooking(tennisCourt);
        } catch (InvalidBookingException e) {
            System.out.println("Cancel error : " + e.getMessage());
        } finally {
            System.out.println("Cancellation attempt finished.");
        }

        try {
            admin.findCourt("Swimming");
        } catch (CourtNotFoundException e) {
            System.out.println("Search error : " + e.getMessage());
        } finally {
            System.out.println("Court search finished.");
        }

        try {
            john.cancelBooking(basketballCourt);
            basketballCourt.bookCourt();
        } catch (InvalidBookingException | CourtNotAvailableException e) {
            System.out.println("Error : " + e.getMessage());
        } finally {
            System.out.println("Final court status test completed.");
        }
        
    }
}