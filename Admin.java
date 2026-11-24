import java.util.*;
public class Admin {
 private List<Court> courts=new ArrayList<>();
 public void addCourt(Court court)throws InvalidBookingException{if(court==null||court.getSportType()==null||court.getSportType().trim().isEmpty())throw new InvalidBookingException("Invalid court");courts.add(court);}
 public Court findCourt(String type)throws CourtNotFoundException{for(Court c:courts)if(c.getSportType().equalsIgnoreCase(type))return c;throw new CourtNotFoundException("Court not found: "+type);}
 public List<Court> getCourts(){return courts;}
}
