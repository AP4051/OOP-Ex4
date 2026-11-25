
public class Main {
    public static void main(String[] args) {

        // Create first playlist
        Playlist workout = new Playlist("Workout Mix");

        Song song1 = new Song("Believer", "Imagine Dragons", 204);
        Song song2 = new Song("Shape of You", "Ed Sheeran", 233);
        Song song3 = new Song("Thunder", "Imagine Dragons", 187);
        Song song4 = new Song("Blinding Lights", "The Weeknd", 200);
        Song song5 = new Song("Perfect", "Ed Sheeran", 263);

        workout.addSong(song1);
        workout.addSong(song2);
        workout.addSong(song3);
        workout.addSong(song4);
        workout.addSong(song5);

        // Duplicate test
        workout.addSong(song1);

        // Insert at index 0
        Song firstSong = new Song("Numb", "Linkin Park", 185);
        workout.insertSongAt(0, firstSong);

        // Search by artist
        System.out.println("\nSongs by Imagine Dragons:");

        for (Song song : workout.findSongsByArtist("Imagine Dragons")) {
            System.out.println(song);
        }

        // Replace a song
        Song newSong = new Song("Starboy", "The Weeknd", 230);
        workout.replaceSong(2, newSong);

        // Remove a song
        workout.removeSongByTitle("Perfect");

        // Display playlist
        workout.displayPlaylist();

        // BONUS 1: Move song
        System.out.println("\n--- Move Song ---");
        workout.moveSong(0, 2);
        workout.displayPlaylist();

        // BONUS 2: Shuffle playlist
        System.out.println("\n--- Shuffle Playlist ---");
        workout.shuffle();
        workout.displayPlaylist();

        // BONUS 3: Create Music Library
        System.out.println("\n--- Music Library ---");

        MusicLibrary library = new MusicLibrary();

        Playlist relaxing = new Playlist("Relaxing Music");
        relaxing.addSong(new Song("Imagine", "John Lennon", 183));
        relaxing.addSong(new Song("Yellow", "Coldplay", 266));

        library.addPlaylist(workout);
        library.addPlaylist(relaxing);

        library.displayAllPlaylists();

        System.out.println("\nTotal Playlists: "
                + library.getPlaylistCount());
    }
}
