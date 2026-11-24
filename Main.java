public class Main {
 public static void main(String[] args){
  Admin admin=new Admin();Court basketball=new Court("Basketball"),tennis=new Court("Tennis");Player john=new Player("John"),alice=new Player("Alice");
  try{
   admin.addCourt(basketball);admin.addCourt(tennis);john.bookCourt(basketball);
   try{alice.bookCourt(basketball);}catch(CourtNotAvailableException e){System.out.println(e.getMessage());}
   john.cancelBooking(basketball);
   try{john.cancelBooking(basketball);}catch(InvalidBookingException e){System.out.println(e.getMessage());}
   try{admin.findCourt("Swimming");}catch(CourtNotFoundException e){System.out.println(e.getMessage());}
  }catch(Exception e){System.out.println(e.getMessage());}
  finally{System.out.println("Booking session completed.");}
 }
}
