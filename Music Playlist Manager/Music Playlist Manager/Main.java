import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist("Workout Mix");

        playlist.addSong(new Song("Eye of the Tiger", "Survivor", 246));
        playlist.addSong(new Song("Lose Yourself", "Eminem", 326));
        playlist.addSong(new Song("Stronger", "Kanye West", 312));
        playlist.addSong(new Song("Till I Collapse", "Eminem", 297));
        playlist.addSong(new Song("Don't Stop Me Now", "Queen", 209));
        playlist.addSong(new Song("eye of the tiger", "SURVIVOR", 246)); // duplicate

        playlist.insertSongAt(0, new Song("Thunderstruck", "AC/DC", 292));
        playlist.displayPlaylist();

        System.out.println("\nSongs by Eminem:");
        ArrayList<Song> eminem = playlist.findSongsByArtist("Eminem");
        for (Song s : eminem) {
            System.out.println("  " + s);
        }

        playlist.replaceSong(3, new Song("Can't Hold Us", "Macklemore", 258));
        playlist.removeSongByTitle("Stronger");

        System.out.println("\nUpdated playlist:");
        playlist.displayPlaylist();
    }
}
