public class Court {
    private static int nextId = 1;
    private final String courtId;
    private final String sportType;
    private boolean isAvailable;

    public Court(String sportType) {
        this.courtId = "C" + nextId++;
        this.sportType = sportType;
        this.isAvailable = true;
    }

    public String getCourtId() {
        return courtId;
    }

    public String getSportType() {
        return sportType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void bookCourt() throws CourtNotAvailableException {
        if (!isAvailable) {
            throw new CourtNotAvailableException(
                sportType + " court is already booked!"
            );
        }
        isAvailable = false;
    }

    public void releaseCourt() throws InvalidBookingException {
        if (isAvailable) {
            throw new InvalidBookingException(
                sportType + " court is not currently booked."
            );
        }
        isAvailable = true;
    }
}
