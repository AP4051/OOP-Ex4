public class Court {

    private String sportType;
    private boolean isAvailable;

    public Court(String sportType) {
        this.sportType = sportType;
        isAvailable = true;
    }

    public void bookCourt() throws CourtNotAvailableException {
        if (!isAvailable)
            throw new CourtNotAvailableException(sportType + " court is already booked!");
        isAvailable = false;
    }

    public void releaseCourt() throws InvalidBookingException {
        if (isAvailable)
            throw new InvalidBookingException("This court is not booked.");
        isAvailable = true;
    }

    public String getSportType() {
        return sportType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

}