import java.util.ArrayList;

public class Playlist {
    private String name;
    private ArrayList<Song> songs = new ArrayList<>();

    public Playlist(String name) {
        this.name = name;
    }

    public void addSong(Song song) {
        if (!songs.contains(song)) songs.add(song);
    }

    public void insertSongAt(int index, Song song) {
        if (index >= 0 && index <= songs.size() && !songs.contains(song))
            songs.add(index, song);
    }

    public void removeSongByTitle(String title) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getTitle().equalsIgnoreCase(title)) {
                songs.remove(i);
                return;
            }
        }
    }

    public void replaceSong(int index, Song newSong) {
        if (index >= 0 && index < songs.size() &&
            (!songs.contains(newSong) || songs.get(index).equals(newSong)))
            songs.set(index, newSong);
    }

    public ArrayList<Song> findSongsByArtist(String artist) {
        ArrayList<Song> result = new ArrayList<>();
        for (Song song : songs)
            if (song.getArtist().equalsIgnoreCase(artist)) result.add(song);
        return result;
    }

    public int getTotalDuration() {
        int total = 0;
        for (Song song : songs) total += song.getDurationInSeconds();
        return total;
    }

    public void displayPlaylist() {
        System.out.println("Playlist: " + name);
        if (songs.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }
        for (int i = 0; i < songs.size(); i++)
            System.out.println((i + 1) + ". " + songs.get(i));
        int total = getTotalDuration();
        System.out.printf("Total duration: %02d:%02d%n", total / 60, total % 60);
    }
}
