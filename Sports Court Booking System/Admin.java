import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Court> courts;

    public Admin() {
        this.courts = new ArrayList<>();
    }

    // TODO: Throw IllegalArgumentException or InvalidBookingException if court is null or sportType is empty
    public void addCourt(Court court) throws InvalidBookingException {
        if (court == null || court.getSportType() == null || court.getSportType().isBlank()) {
            throw new InvalidBookingException("Invalid court!");
        }
        courts.add(court);
        System.out.println("added" + court.getSportType() + "courts");

    }

    // TODO: Implement findCourt(String sportType) that throws CourtNotFoundException if no matching court exists

   public Court findCourt(String sportType) throws CourtNotFoundException{
        for(int i = 0; i<courts.size();i++) {
            if (courts.get(i).getSportType().equalsIgnoreCase(sportType)) {
                return courts.get(i);
            }
        }
       throw new CourtNotFoundException("Court not found!");
    }
    public List<Court> getCourts() {
        return courts;
    }
}