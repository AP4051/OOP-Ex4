public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public boolean bookCourt(Court court) throws CourtNotAvailableException, InvalidBookingException {
        if (court == null) {
            throw new InvalidBookingException("Cannot book a null court.");
        }
        court.bookCourt();
        System.out.println(name + " successfully booked a " + court.getSportType() + " court.");
        return true;
    }

    public void cancelBooking(Court court) throws InvalidBookingException {
        if (court == null) {
            throw new InvalidBookingException("Cannot cancel a booking for a null court.");
        }
        court.releaseCourt();
        System.out.println(name + " cancelled the " + court.getSportType() + " court booking.");
    }

    public String getName() { return name; }
}
