public class Court {
    private String sportType;
    private boolean isAvailable;

    public Court(String sportType) {
        this.sportType = sportType;
        this.isAvailable = true;
    }

    // TODO: Refactor to throw CourtNotAvailableException instead of returning false
    public void bookCourt() throws CourtNotAvailableException {
        if (isAvailable) {
            throw new CourtNotAvailableException(sportType + "Court is occupued!");
        }
        isAvailable =  false;
    }

    // TODO: Throw InvalidBookingException if the court is already available (cannot release an unbooked court)
    public void releaseCourt() throws InvalidBookingException {
        if(isAvailable){
            throw new InvalidBookingException("Cannot release a " + sportType + " court that is not booked!");
        }
        isAvailable = true;
    }

    public String getSportType() {
        return sportType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}