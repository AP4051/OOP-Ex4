import java.util.ArrayList;

public class Playlist {
    private String name;
    private ArrayList<Song> songs;

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(Song song) {
        if (songs.contains(song)) {
            return false;
        }

        songs.add(song);
        return true;
    }

    public boolean insertSongAt(int index, Song song) {
        if (index < 0 || index > songs.size() || songs.contains(song)) {
            return false;
        }

        songs.add(index, song);
        return true;
    }

    public boolean removeSongByTitle(String title) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getTitle().equalsIgnoreCase(title)) {
                songs.remove(i);
                return true;
            }
        }

        return false;
    }

    public boolean removeSongAt(int index) {
        if (index < 0 || index >= songs.size()) {
            return false;
        }

        songs.remove(index);
        return true;
    }

    public boolean replaceSong(int index, Song newSong) {
        if (index < 0 || index >= songs.size()) {
            return false;
        }

        int existingIndex = songs.indexOf(newSong);

        if (existingIndex != -1 && existingIndex != index) {
            return false;
        }

        songs.set(index, newSong);
        return true;
    }

    public ArrayList<Song> findSongsByArtist(String artist) {
        ArrayList<Song> results = new ArrayList<>();

        for (Song song : songs) {
            if (song.getArtist().equalsIgnoreCase(artist)) {
                results.add(song);
            }
        }

        return results;
    }

    public int getTotalDuration() {
        int total = 0;

        for (Song song : songs) {
            total += song.getDurationInSeconds();
        }

        return total;
    }

    public void displayPlaylist() {
        System.out.println("Playlist: " + name);

        if (songs.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        for (int i = 0; i < songs.size(); i++) {
            System.out.println((i + 1) + ". " + songs.get(i));
        }

        int total = getTotalDuration();

        System.out.printf("Total duration: %02d:%02d%n",
                total / 60,
                total % 60);
    }
}

