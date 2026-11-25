import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Court> courts;

    public Admin() { courts = new ArrayList<Court>(); }

    public void addCourt(Court court) throws InvalidBookingException {
        if (court == null || court.getSportType() == null ||
                court.getSportType().trim().isEmpty())
            throw new InvalidBookingException("Court and sport type must be valid.");
        courts.add(court);
        System.out.println("Added " + court.getSportType() + " court.");
    }
    public Court findCourt(String sportType) throws CourtNotFoundException {
        for (Court court : courts) {
            if (court.getSportType().equalsIgnoreCase(sportType)) return court;
        }
        throw new CourtNotFoundException(sportType + " court was not found.");
    }
    public List<Court> getCourts() { return courts; }
}
