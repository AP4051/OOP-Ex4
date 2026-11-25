public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist("Workout Mix");
        Song song1 = new Song("Believer", "Imagine Dragons", 204);
        playlist.addSong(song1);
        playlist.addSong(new Song("Blinding Lights", "The Weeknd", 200));
        playlist.addSong(new Song("Levitating", "Dua Lipa", 203));
        playlist.addSong(new Song("Radioactive", "Imagine Dragons", 186));
        playlist.addSong(new Song("Shape of You", "Ed Sheeran", 234));
        System.out.println("Duplicate added? " + playlist.addSong(new Song("believer", "IMAGINE DRAGONS", 204)));

        playlist.insertSongAt(0, new Song("Don't Start Now", "Dua Lipa", 183));
        System.out.println("Songs by Imagine Dragons: " + playlist.findSongsByArtist("Imagine Dragons"));
        playlist.replaceSong(2, new Song("Thunder", "Imagine Dragons", 187));
        playlist.removeSongByTitle("Shape of You");
        playlist.displayPlaylist();
    }
}
