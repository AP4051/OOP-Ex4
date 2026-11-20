public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        Court basketballCourt = new Court("Basketball");
        Court tennisCourt = new Court("Tennis");
        try {
            admin.addCourt(basketballCourt);
            admin.addCourt(tennisCourt);
        } catch (InvalidBookingException e) {
            System.out.println("adminError" + e.getMessage());
        }

        Player player1 = new Player("John");
        Player player2 = new Player("Alice");

        // TODO: Wrap booking, releasing, and searching calls in try-catch-finally blocks
        try {
            player1.bookCourt(basketballCourt);
            player2.bookCourt(basketballCourt);
        } catch (CourtNotAvailableException e){
            System.out.println("Booling Error"+ e.getMessage() );
        }
        catch(InvalidBookingException e){
            System.out.println("invalid Booking" + e.getMessage());
        }
        try{
            player1.cancelBooking(tennisCourt);
        }
        catch(InvalidBookingException e){
            System.out.println("release Error" + e.getMessage());
        }
        try{
            admin.findCourt("Swimming");
        }
        catch(CourtNotFoundException e){
            System.out.println("Search Error" + e.getMessage());
        }
        finally {
            System.out.println("class tested");
        }


    }
}