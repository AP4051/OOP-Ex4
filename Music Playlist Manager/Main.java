import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist("Workout Mix");

        playlist.addSong(new Song("Dynamite", "BTS", 199));
        playlist.addSong(new Song("Butter", "BTS", 164));
        playlist.addSong(new Song("Pink Venom", "BLACKPINK", 187));
        playlist.addSong(new Song("Super", "SEVENTEEN", 200));
        playlist.addSong(new Song("God's Menu", "Stray Kids", 167));

        boolean duplicateAdded =
                playlist.addSong(new Song("dynamite", "bts", 199));

        System.out.println("Duplicate added? " + duplicateAdded);

        playlist.insertSongAt(
                0,
                new Song("How You Like That", "BLACKPINK", 181)
        );

        System.out.println("\nSongs by BTS:");

        ArrayList<Song> btsSongs = playlist.findSongsByArtist("BTS");

        for (Song song : btsSongs) {
            System.out.println(song);
        }

        playlist.replaceSong(
                3,
                new Song("LALISA", "LISA", 207)
        );

        playlist.removeSongByTitle("Super");

        System.out.println("\nUpdated playlist:");
        playlist.displayPlaylist();
    }
}

