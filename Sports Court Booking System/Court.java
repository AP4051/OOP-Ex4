public class Court {
    private String sportType;
    private boolean available;

    public Court(String sportType) {
        this.sportType = sportType;
        available = true;
    }
    public void bookCourt() throws CourtNotAvailableException {
        if (!available)
            throw new CourtNotAvailableException(sportType + " court is already booked!");
        available = false;
    }
    public void releaseCourt() throws InvalidBookingException {
        if (available)
            throw new InvalidBookingException("This court is not booked.");
        available = true;
    }
    public String getSportType() { return sportType; }
    public boolean isAvailable() { return available; }
}
