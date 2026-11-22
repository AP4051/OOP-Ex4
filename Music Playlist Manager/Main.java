import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Playlist myPlaylist = new Playlist("Workout Mix");

        myPlaylist.addSong(new Song("Bohemian Rhapsody", "Queen", 355));
        myPlaylist.addSong(new Song("Blinding Lights", "The Weeknd", 200));
        myPlaylist.addSong(new Song("Don't Stop Me Now", "Queen", 209));
        myPlaylist.addSong(new Song("Shape of You", "Ed Sheeran", 233));
        myPlaylist.addSong(new Song("Believer", "Imagine Dragons", 204));

        myPlaylist.addSong(new Song("Blinding Lights", "The Weeknd", 200));

        myPlaylist.insertSongAt(0, new Song("Eye of the Tiger", "Survivor", 245));

        myPlaylist.displayPlaylist();

        System.out.println("\n--- Queen Songs ---");
        ArrayList<Song> queenList = myPlaylist.findSongsByArtist("Queen");
        for (int i = 0; i < queenList.size(); i++) {
            System.out.println(queenList.get(i));
        }

        myPlaylist.replaceSong(1, new Song("Starboy", "The Weeknd", 230));
        myPlaylist.removeSongByTitle("Shape of You");

        System.out.println("\n--- Updated Playlist ---");
        myPlaylist.displayPlaylist();
    }
}
