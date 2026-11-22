public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        Court basketball = new Court("Basketball");
        Court tennis = new Court("Tennis");
        try {
            admin.addCourt(basketball);
            admin.addCourt(tennis);
        }
        catch (InvalidBookingException e) {
            System.out.println("Admin error: " + e.getMessage());
        }



        Player parsa= new Player("Parsa");
        Player amir = new Player("Amir");
        try {
            parsa.bookCourt(basketball);
            amir.bookCourt(basketball); // Must throw CourtNotAvailableException.
        }
        catch (InvalidBookingException | CourtNotAvailableException e) {
            System.out.println("Booking error: " + e.getMessage());
        }
        finally {
            System.out.println("Booking session status: booking attempt finished.");
        }



        try {
            parsa.cancelBooking(tennis);
        } // Tennis was never booked.
        catch (InvalidBookingException e) {
            System.out.println("Cancellation error: " + e.getMessage());
        }
        finally {
            System.out.println("Booking session status: release attempt finished.");
        }



        try {
            admin.findCourt("Swimming");
        }
        catch (CourtNotFoundException e) {
            System.out.println("Search error: " + e.getMessage());
        }
        finally {
            System.out.println("Booking session status: search attempt finished.");
        }



        try {
            parsa.cancelBooking(basketball);
        }
        catch (InvalidBookingException e) {
            System.out.println("Cancellation error: " + e.getMessage());
        }
        finally {
            System.out.println("Booking session closed.");
        }
    }
}
