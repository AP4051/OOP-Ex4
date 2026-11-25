import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Court> courts;

    public Admin() {
        this.courts = new ArrayList<>();
    }

    public void addCourt(Court court) throws InvalidBookingException {
        if (court == null) {
            throw new InvalidBookingException("Cannot add a null court.");
        }
        if (court.getSportType() == null || court.getSportType().isBlank()) {
            throw new InvalidBookingException("Court sport type cannot be empty.");
        }
        courts.add(court);
        System.out.println("Added " + court.getSportType() + " court.");
    }

    public Court findCourt(String sportType) throws CourtNotFoundException {
        for (Court c : courts) {
            if (c.getSportType().equalsIgnoreCase(sportType)) {
                return c;
            }
        }
        throw new CourtNotFoundException("No court found for sport: " + sportType);
    }

    public List<Court> getCourts() { return courts; }
}
