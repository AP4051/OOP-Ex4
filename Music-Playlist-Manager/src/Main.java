import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist("Workout Mix");
        Song s1 = new Song("Dawsh","Mersad",204);
        Song s2 = new Song("Love Sick","Gucciflame",185);
        Song s3 = new Song("Marg","Amin Tijay",231);
        Song s4 = new Song("Teshne","Farzad Ghadimi",176);
        Song s5 = new Song("Tariki","Sajad Shahi",201);

        playlist.addSong(s1);
        playlist.addSong(s2);
        playlist.addSong(s3);
        playlist.addSong(s4);
        playlist.addSong(s5);
        playlist.addSong(new Song("Dawsh","Mersad",204));
        playlist.insertSongAt(0,new Song("Shookhi","Farzad Ghadimi",247));

        System.out.println("\nSongs by Mersad :");
        ArrayList<Song> found = playlist.findSongsByArtist("Mersad");
        for (Song song : found) {
            System.out.println(song);
        }

        playlist.replaceSong(1,new Song("Nefrat","Gucciflame",162));
        playlist.removeSongByTitle("Marg");
        playlist.displayPlaylist();
    }
}