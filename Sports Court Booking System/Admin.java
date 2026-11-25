import java.util.ArrayList;
import java.util.List;

public class Admin {
    private final List<Court> courts = new ArrayList<>();

    public void addCourt(Court court) throws InvalidBookingException {
        if (court == null || court.getSportType() == null || court.getSportType().isBlank()) throw new InvalidBookingException("A valid court and sport type are required.");
        courts.add(court);
        System.out.println("Added " + court.getSportType() + " court.");
    }

    public Court findCourt(String sportType) throws CourtNotFoundException {
        if (sportType != null) {
            for (Court court : courts) if (court.getSportType().equalsIgnoreCase(sportType)) return court;
        }
        throw new CourtNotFoundException("No court found for sport: " + sportType);
    }

    public List<Court> getCourts() { return new ArrayList<>(courts); }
}
