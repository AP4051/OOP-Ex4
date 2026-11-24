public class Player {
 private String name;
 public Player(String name){this.name=name;}
 public void bookCourt(Court court)throws InvalidBookingException,CourtNotAvailableException{if(court==null)throw new InvalidBookingException("Null court");court.bookCourt();System.out.println(name+" booked "+court.getSportType());}
 public void cancelBooking(Court court)throws InvalidBookingException{if(court==null)throw new InvalidBookingException("Null court");court.releaseCourt();System.out.println(name+" canceled booking");}
}
