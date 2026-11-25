public class Court {
    private String sportType;
    private boolean isAvailable;

    public Court(String sportType) {
        this.sportType = sportType;
        this.isAvailable = true;
    }

    public void bookCourt() throws CourtNotAvailableException {
        if (!isAvailable) {
            throw new CourtNotAvailableException(sportType + " court is already booked!");
        }
        isAvailable = false;
    }

    public void releaseCourt() throws InvalidBookingException {
        if (isAvailable) {
            throw new InvalidBookingException(sportType + " court is not booked, so it cannot be released.");
        }
        isAvailable = true;
    }

    public String getSportType() { return sportType; }

    public boolean isAvailable() { return isAvailable; }
}
