import java.util.ArrayList;

public class Playlist {
    private String name;
    private ArrayList<Song> songs;

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        if (songs.contains(song)) {
            System.out.println("Song already exists: " + song);
        } else {
            songs.add(song);
        }
    }

    public void insertSongAt(int index, Song song) {
        if (songs.size() < index || index < 0) {
            System.out.println("operation not possible!");
        } else if (songs.contains(song)) {
            System.out.println("song alreaady exsits!");
        } else {
            songs.set(index, song);
        }
    }

    public void removeSongByTitle(String title) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getTitle().equalsIgnoreCase(title)) {
                songs.remove(i);
                return;
            } else {
                System.out.println(title + "not found");
            }
        }
    }

    public void replaceSong(int index, Song newSong) {
        if (index < 0 || index >= songs.size()) {
            System.out.println("Invalid index");
        } else {
            songs.set(index, newSong);
        }
    }

    public ArrayList<Song> findSongsByArtist(String artist) {
        ArrayList<Song> result = new ArrayList<>();
        for (Song s : songs) {
            if (s.getArtist().equalsIgnoreCase(artist)) {
                result.add(s);
            }
        }
        return result;
    }

    public int getTotalDuration(){
        int sum = 0;
        for(Song s : songs){
            sum =+ s.getDurationInSeconds();
        }
        return sum;
    }

    public void displayPlaylist(){
        if(songs.isEmpty()){
            System.out.println("empty playlist!");
        }
        System.out.println("Playlist: " + name);
        for(int i= 1 ; i<= songs.size();i++){
            System.out.println(i + "-"+songs.get(i));
        }
        int total = getTotalDuration();
        System.out.printf("Total duration: %02d:%02d%n", total / 60, total % 60);
    }



}
