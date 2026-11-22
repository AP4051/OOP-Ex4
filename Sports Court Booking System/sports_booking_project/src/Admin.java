import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Court> courts;

    public Admin() {
        courts = new ArrayList<>();
    }

    public void addCourt(Court court) throws InvalidBookingException {
        if (court == null || court.getSportType() == null || court.getSportType().isBlank()) {
            throw new InvalidBookingException("Court and its sport type must be valid.");
        }
        courts.add(court);
        System.out.println("Added " + court.getSportType() + " court.");
    }

    public Court findCourt(String sportType) throws CourtNotFoundException {
        if (sportType != null){
            for (Court court : courts) {
                if (court.getSportType().equalsIgnoreCase(sportType)) {
                    return court;
                }

            }
        }
        throw new CourtNotFoundException("No court found for sport type: " + sportType);
    }
    public List<Court> getCourts() {
        return courts;
    }
}
