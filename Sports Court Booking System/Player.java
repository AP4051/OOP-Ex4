public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    // TODO: Update to declare or handle CourtNotAvailableException and InvalidBookingException
    public void bookCourt(Court court) throws CourtNotAvailableException, InvalidBookingException {
        if( court ==null){
            throw new InvalidBookingException("court cant be null!");
        }
        court.bookCourt();
        System.out.println( name + "succesfully booked a" + court.getSportType() +"court");
    }

    // TODO: Add cancelBooking(Court court) that releases the court and handles exceptions
    public void cancelBooking(Court court) throws InvalidBookingException{
        if( court ==null){
            throw new InvalidBookingException("court cant be null!");
        }
        court.releaseCourt();
        System.out.println(name + " cancelled the " + court.getSportType() + " court booking.");
    }
}