# Sports Court Booking System (Exception Handling Edition) 🏀

## Features
- Different types of courts (e.g., basketball, tennis, football).
- Players can book and release courts, with proper exception handling when a court is already booked or not found.
- Admins can add, remove, and look up courts by sport type or ID, throwing exceptions on invalid operations.

## Classes & Structure
```plaintext
SportsBookingSystem
 ├── CourtNotAvailableException (To Be Created)
 ├── CourtNotFoundException (To Be Created)
 ├── InvalidBookingException (To Be Created)
 ├── Court
 ├── Player
 ├── Admin
 └── Main (Runner)
```

## Starter Implementation

### `Court.java`
```java
public class Court {
    private String sportType;
    private boolean isAvailable;

    public Court(String sportType) {
        this.sportType = sportType;
        this.isAvailable = true;
    }

    // TODO: Refactor to throw CourtNotAvailableException instead of returning false
    public boolean bookCourt() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    // TODO: Throw InvalidBookingException if the court is already available (cannot release an unbooked court)
    public void releaseCourt() {
        isAvailable = true;
    }

    public String getSportType() {
        return sportType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
```

### `Player.java`
```java
public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    // TODO: Update to declare or handle CourtNotAvailableException and InvalidBookingException
    public boolean bookCourt(Court court) {
        if (court.bookCourt()) {
            System.out.println(name + " successfully booked a " + court.getSportType() + " court.");
            return true;
        }
        System.out.println("Court is already booked!");
        return false;
    }

    // TODO: Add cancelBooking(Court court) that releases the court and handles exceptions
}
```

### `Admin.java`
```java
import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Court> courts;

    public Admin() {
        this.courts = new ArrayList<>();
    }

    // TODO: Throw IllegalArgumentException or InvalidBookingException if court is null or sportType is empty
    public void addCourt(Court court) {
        courts.add(court);
        System.out.println("Added " + court.getSportType() + " court.");
    }

    // TODO: Implement findCourt(String sportType) that throws CourtNotFoundException if no matching court exists

    public List<Court> getCourts() {
        return courts;
    }
}
```

### `Main.java`
```java
public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        Court basketballCourt = new Court("Basketball");
        Court tennisCourt = new Court("Tennis");
        
        admin.addCourt(basketballCourt);
        admin.addCourt(tennisCourt);
        
        Player player1 = new Player("John");
        Player player2 = new Player("Alice");
        
        // TODO: Wrap booking, releasing, and searching calls in try-catch-finally blocks
        player1.bookCourt(basketballCourt);
        player2.bookCourt(basketballCourt); // Should trigger CourtNotAvailableException!
    }
}
```

## Assignment Tasks (Exception Handling)
1. **Create Custom Exception Classes** (extending `Exception`):
   - `CourtNotAvailableException`: Thrown when a player tries to book a court that is already occupied.
   - `CourtNotFoundException`: Thrown when `Admin.findCourt(String sportType)` cannot find a matching court.
   - `InvalidBookingException`: Thrown when a player passes a `null` court, tries to release a court that is not currently booked, or an admin tries to add a court with an empty/null `sportType`.
2. **Refactor `Court.java`**:
   - Change `bookCourt()` to `void bookCourt() throws CourtNotAvailableException`. If `!isAvailable`, throw `CourtNotAvailableException` with a clear message (e.g., `"Basketball court is already booked!"`).
   - Update `releaseCourt()` to `throws InvalidBookingException` if the court is already available.
3. **Refactor `Player.java`**:
   - Update `bookCourt(Court court)` to validate that `court != null` (throwing `InvalidBookingException`), call `court.bookCourt()`, and propagate or handle `CourtNotAvailableException`.
   - Implement `cancelBooking(Court court)` to release a booked court and handle/propagate `InvalidBookingException`.
4. **Extend `Admin.java`**:
   - Validate `court` in `addCourt(Court court)` and throw `InvalidBookingException` if `court == null` or `court.getSportType().isBlank()`.
   - Implement `findCourt(String sportType) throws CourtNotFoundException` to return the first matching court or throw `CourtNotFoundException`.
5. **Update `Main.java`**:
   - Use `try-catch-finally` blocks to test:
     - Double-booking the same court (`CourtNotAvailableException`).
     - Releasing an unbooked court (`InvalidBookingException`).
     - Searching for a `"Swimming"` court that was never added (`CourtNotFoundException`).
   - Ensure a `finally` block prints a closing status message after the booking session.

## How to Run
1. Compile all Java files:
   ```bash
   javac *.java
   ```
2. Run the `Main` class:
   ```bash
   java Main
   ```

## Future Enhancements
- Track which `Player` booked each `Court` and throw an `UnauthorizedCancellationException` if a different player tries to cancel it.
- Introduce booking time slots and throw a `BookingConflictException` for overlapping reservations.

---
🏆 **Reserve your favorite court—and handle every foul with exceptions!** 🎾
