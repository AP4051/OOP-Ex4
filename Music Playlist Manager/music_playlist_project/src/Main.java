public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist("Workout Mix");
        Song s1 = new Song("Eye of the Tiger", "Survivor", 245);
        Song s2 = new Song("Believer", "Imagine Dragons", 204);
        Song s3 = new Song("Stronger", "Kanye West", 312);
        Song s4 = new Song("Lose Yourself", "Eminem", 326);
        Song s5 = new Song("Thunder", "Imagine Dragons", 187);

        playlist.addSong(s1);
        playlist.addSong(s2);
        playlist.addSong(s3);
        playlist.addSong(s4);
        playlist.addSong(s5);

        System.out.println("Duplicate added? " + playlist.addSong(new Song("believer", "IMAGINE DRAGONS", 204)));
        playlist.insertSongAt(0, new Song("Remember the Name", "Fort Minor", 230));
        System.out.println("Songs by Imagine Dragons: " + playlist.findSongsByArtist("Imagine Dragons"));
        playlist.replaceSong(2, new Song("Hall of Fame", "The Script", 202));
        playlist.removeSongByTitle("Stronger");
        playlist.displayPlaylist();
    }
}
