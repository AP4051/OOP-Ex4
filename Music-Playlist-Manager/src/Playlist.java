import java.util.ArrayList;

public class Playlist {

    private String name;
    private ArrayList<Song> songs;

    public Playlist(String name) {
        this.name = name;
        songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        if (songs.contains(song))
            System.out.println("This song is already in the playlist.");
        else {
            songs.add(song);
            System.out.println("The song was added successfully.");
        }
    }

    public void insertSongAt(int index,Song song) {
        if (index < 0 || index > songs.size())
            System.out.println("Error : Invalid index.");
        else if (songs.contains(song))
            System.out.println("This song is already in the playlist.");
        else {
            songs.add(index,song);
            System.out.println("Song was inserted successfully.");
        }
    }

    public void removeSongByTitle(String title) {
        for (int i = 0 ; i < songs.size() ; i++) {
            if (songs.get(i).getTitle().equalsIgnoreCase(title)) {
                songs.remove(i);
                System.out.println("Song was removed successfully.");
                break;
            }
        }
        System.out.println("Song was not found.");
    }

    public void replaceSong(int index,Song newSong) {
        if (index < 0 || index >= songs.size())
            System.out.println("Invalid index.");
        else if (songs.contains(newSong) && !songs.get(index).equals(newSong))
            System.out.println("This song is already in the playlist.");
        else {
            songs.set(index,newSong);
            System.out.println("Song was replaced successfully.");
        }
    }

    public ArrayList<Song> findSongsByArtist(String artist) {
        ArrayList<Song> result = new ArrayList<>();
        for (Song song : songs) {
            if (song.getArtist().equalsIgnoreCase(artist))
                result.add(song);
        }
        return result;
    }

    public int getTotalDuration() {
        int total = 0;
        for (Song song : songs) {
            total += song.getDurationInSeconds();
        }
        return total;
    }

    private String formatDuration(int totalSeconds) {
        return String.format("%02d:%02d",totalSeconds / 60,totalSeconds % 60);
    }

    public void displayPlaylist() {
        System.out.println("\nPlaylist : " + name);
        if (songs.isEmpty())
            System.out.println("Playlist is empty.");
        for (int i = 0 ; i < songs.size() ; i++) {
            System.out.println((i + 1) + ". " + songs.get(i));
        }
        System.out.println("Total duration : " + formatDuration(getTotalDuration()));
    }
}