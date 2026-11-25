
import java.util.ArrayList;

public class MusicLibrary {
    private ArrayList<Playlist> playlists;

    public MusicLibrary() {
        playlists = new ArrayList<>();
    }

    public void addPlaylist(Playlist playlist) {
        playlists.add(playlist);
        System.out.println("Playlist added to library.");
    }

    public void displayAllPlaylists() {
        if (playlists.isEmpty()) {
            System.out.println("Music library is empty.");
            return;
        }

        for (Playlist playlist : playlists) {
            playlist.displayPlaylist();
        }
    }

    public Playlist getPlaylist(int index) {
        if (index >= 0 && index < playlists.size()) {
            return playlists.get(index);
        }

        return null;
    }

    public void removePlaylist(int index) {
        if (index >= 0 && index < playlists.size()) {
            playlists.remove(index);
            System.out.println("Playlist removed.");
        } else {
            System.out.println("Invalid index!");
        }
    }

    public int getPlaylistCount() {
        return playlists.size();
    }
}
