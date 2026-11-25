public class Court {
    private final String sportType;
    private boolean isAvailable;

    public Court(String sportType) {
        if (sportType == null || sportType.isBlank()) throw new IllegalArgumentException("Sport type is required.");
        this.sportType = sportType;
        this.isAvailable = true;
    }

    public void bookCourt() throws CourtNotAvailableException {
        if (!isAvailable) throw new CourtNotAvailableException(sportType + " court is already booked!");
        isAvailable = false;
    }

    public void releaseCourt() throws InvalidBookingException {
        if (isAvailable) throw new InvalidBookingException("Cannot release a court that is not booked.");
        isAvailable = true;
    }

    public String getSportType() { return sportType; }
    public boolean isAvailable() { return isAvailable; }
}
