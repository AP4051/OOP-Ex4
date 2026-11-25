public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist("Workout Mix");

        Song song1 = new Song("Believer", "Imagine Dragons", 204);
        Song song2 = new Song("Shape of You", "Ed Sheeran", 234);
        Song song3 = new Song("Thunder", "Imagine Dragons", 187);
        Song song4 = new Song("Perfect", "Ed Sheeran", 263);
        Song song5 = new Song("Counting Stars", "OneRepublic", 257);

        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);
        playlist.addSong(song4);
        playlist.addSong(song5);
        playlist.addSong(song1); // Duplicate test

        playlist.insertSongAt(0, new Song("Numb", "Linkin Park", 186));

        System.out.println("Songs by Imagine Dragons:");
        System.out.println(playlist.findSongsByArtist("Imagine Dragons"));

        playlist.replaceSong(1, new Song("Radioactive", "Imagine Dragons", 186));
        playlist.removeSongByTitle("Perfect");
        playlist.displayPlaylist();
    }
}
