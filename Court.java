public class Court {
 private String sportType;private boolean available=true;
 public Court(String type){sportType=type;}
 public String getSportType(){return sportType;}
 public boolean isAvailable(){return available;}
 public void bookCourt()throws CourtNotAvailableException{if(!available)throw new CourtNotAvailableException(sportType+" court already booked");available=false;}
 public void releaseCourt()throws InvalidBookingException{if(available)throw new InvalidBookingException("Court is not booked");available=true;}
}
