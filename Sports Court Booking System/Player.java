public class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public void bookCourt(Court court)
            throws InvalidBookingException, CourtNotAvailableException {
        if (court == null) {
            throw new InvalidBookingException("Cannot book a null court.");
        }

        court.bookCourt();
        System.out.println(
            name + " successfully booked a " + court.getSportType() + " court."
        );
    }

    public void cancelBooking(Court court) throws InvalidBookingException {
        if (court == null) {
            throw new InvalidBookingException(
                "Cannot cancel a booking for a null court."
            );
        }

        court.releaseCourt();
        System.out.println(
            name + " successfully cancelled the "
                + court.getSportType() + " court booking."
        );
    }
}
