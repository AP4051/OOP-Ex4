public class Player {
    private String name;

    public Player(String name) { this.name = name; }

    public void bookCourt(Court court)
            throws InvalidBookingException, CourtNotAvailableException {
        if (court == null) throw new InvalidBookingException("Court cannot be null.");
        court.bookCourt();
        System.out.println(name + " successfully booked a " + court.getSportType() + " court.");
    }
    public void cancelBooking(Court court) throws InvalidBookingException {
        if (court == null) throw new InvalidBookingException("Court cannot be null.");
        court.releaseCourt();
        System.out.println(name + " cancelled the booking.");
    }
}
