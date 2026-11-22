import java.util.ArrayList;
import java.util.List;

public class Admin {
    private final List<Court> courts = new ArrayList<>();

    public void addCourt(Court court) throws InvalidBookingException {
        if (court == null) {
            throw new InvalidBookingException("Cannot add a null court.");
        }

        if (court.getSportType() == null || court.getSportType().isBlank()) {
            throw new InvalidBookingException(
                "Court sport type cannot be null or blank."
            );
        }

        for (Court existing : courts) {
            if (existing.getCourtId().equals(court.getCourtId())) {
                throw new InvalidBookingException(
                    "Court ID " + court.getCourtId() + " is already registered."
                );
            }
        }

        courts.add(court);
        System.out.println("Added " + court.getSportType() + " court.");
    }

    public Court findCourt(String sportType) throws CourtNotFoundException {
        for (Court court : courts) {
            if (court.getSportType().equalsIgnoreCase(sportType)) {
                return court;
            }
        }

        throw new CourtNotFoundException(
            "No court found for sport: " + sportType
        );
    }

    public Court findCourtById(String courtId) throws CourtNotFoundException {
        for (Court court : courts) {
            if (court.getCourtId().equals(courtId)) {
                return court;
            }
        }

        throw new CourtNotFoundException("No court found with ID: " + courtId);
    }

    public void removeCourt(String courtId) throws CourtNotFoundException {
        for (int i = 0; i < courts.size(); i++) {
            if (courts.get(i).getCourtId().equals(courtId)) {
                courts.remove(i);
                return;
            }
        }

        throw new CourtNotFoundException("No court found with ID: " + courtId);
    }

    public List<Court> getCourts() {
        return new ArrayList<>(courts);
    }
}
