import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Playlist p = new Playlist("Workout Mix");

        p.addSong(new Song("Bohemian Rhapsody", "Queen", 355));
        p.addSong(new Song("Don't Stop Me Now", "Queen", 209));
        p.addSong(new Song("Eye of the Tiger", "Survivor", 246));
        p.addSong(new Song("Lose Yourself", "Eminem", 326));
        p.addSong(new Song("Stronger", "Kanye West", 312));

        p.addSong(new Song("Bohemian Rhapsody", "Queen", 355));

        p.displayPlaylist();

        p.insertSongAt(0, new Song("Till I Collapse", "Eminem", 297));
        p.displayPlaylist();


        ArrayList<Song> result = p.findSongsByArtist("Queen");
        System.out.println("Songs by Queen:");
        for (Song s : result) {
            System.out.println(s);
        }

        p.replaceSong(3, new Song("Power", "Kanye West", 292));
        p.removeSongByTitle("Stronger");

        p.displayPlaylist();
    }
}