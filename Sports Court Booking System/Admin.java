import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Court> courts;

    public Admin() {
        this.courts = new ArrayList<>();
    }

    public void addCourt(Court court) throws InvalidBookingException {
        if (court == null || court.getSportType() == null || court.getSportType().trim().isEmpty()) {
            throw new InvalidBookingException("Cannot add a null or unnamed court!");
        }
        courts.add(court);
        System.out.println("Added " + court.getSportType() + " court.");
    }

    public Court findCourt(String sportType) throws CourtNotFoundException {
        for (int i = 0; i < courts.size(); i++) {
            Court current = courts.get(i);
            if (current.getSportType().equalsIgnoreCase(sportType)) {
                return current;
            }
        }
        throw new CourtNotFoundException("No court found for sport: " + sportType);
    }

    public List<Court> getCourts() {
        return courts;
    }
}