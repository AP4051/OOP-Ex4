public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist("Workout Mix");

        playlist.addSong(new Song("Sky", "Ali", 200));
        playlist.addSong(new Song("Moon", "Sara", 180));
        playlist.addSong(new Song("Rain", "Ali", 215));
        playlist.addSong(new Song("Sun", "Reza", 150));
        playlist.addSong(new Song("Wind", "Sara", 240));
        playlist.addSong(new Song("Sky", "Ali", 200)); // Duplicate: not added

        playlist.insertSongAt(0, new Song("Start", "Ali", 90));
        System.out.println("Songs by Ali: " + playlist.findSongsByArtist("Ali"));
        playlist.replaceSong(1, new Song("Star", "Nima", 210));
        playlist.removeSongByTitle("Moon");
        playlist.displayPlaylist();
    }
}
