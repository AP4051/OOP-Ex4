# Music Playlist Manager (ArrayList OOP Exercise) 🎵

## Learning Objectives
- Understand how `ArrayList<T>` works as a dynamic, ordered collection.
- Practice core `ArrayList` methods: `add()`, `add(index, element)`, `get()`, `set()`, `remove()`, `contains()`, `indexOf()`, `size()`, and `isEmpty()`.
- Iterate through lists using enhanced `for-each` loops and standard `for` loops.
- Apply encapsulation and clean OOP design across multiple interacting classes.

## Features
- Represent songs with title, artist, and duration (in seconds).
- Add songs to the end of a playlist or insert them at a specific position (e.g., "Play Next").
- Remove songs by title or index, and replace a song at a given index.
- Search for all songs by a specific artist.
- Calculate the total duration of a playlist in `MM:SS` format.
- Prevent duplicate songs from being added to the same playlist.

## Classes & Structure
```plaintext
MusicPlaylistManager
 ├── Song
 ├── Playlist
 └── Main (Runner)
```

## Class-by-Class Requirements

### 1. `Song`
- **Fields:**
  - `title` (`String`)
  - `artist` (`String`)
  - `durationInSeconds` (`int`)
- **Constructor:**
  - `Song(String title, String artist, int durationInSeconds)`
- **Methods:**
  - Getters for all fields (`getTitle()`, `getArtist()`, `getDurationInSeconds()`).
  - `getFormattedDuration()`: Returns the duration formatted as `"MM:SS"` (e.g., `215` seconds → `"03:35"`).
  - `toString()`: Returns a readable string such as `"Bohemian Rhapsody - Queen (05:55)"`.
  - `equals(Object obj)` *(recommended)*: Two songs are considered equal if they have the same `title` and `artist` (case-insensitive), enabling `ArrayList.contains()` to detect duplicates.

### 2. `Playlist`
- **Fields:**
  - `name` (`String`): Name of the playlist.
  - `songs` (`ArrayList<Song>`): Ordered list of songs in the playlist.
- **Constructor:**
  - `Playlist(String name)`: Initializes the playlist name and an empty `ArrayList<>`.
- **Methods:**
  - `addSong(Song song)`: Adds the song to the end of the list if it is not already in `songs` (use `contains()`).
  - `insertSongAt(int index, Song song)`: Inserts a song at a specific index if the index is valid (`0 <= index <= songs.size()`) and not a duplicate.
  - `removeSongByTitle(String title)`: Searches for a song by title and removes it from the list.
  - `replaceSong(int index, Song newSong)`: Replaces the song at `index` using `set(index, newSong)`.
  - `findSongsByArtist(String artist)`: Returns a new `ArrayList<Song>` containing all songs by the given artist.
  - `getTotalDuration()`: Sums `durationInSeconds` across all songs and returns the total.
  - `displayPlaylist()`: Prints the playlist name, numbered tracklist, and total duration (or `"Playlist is empty."` if `isEmpty()`).

### 3. `Main` (Runner)
- Create a `Playlist` (e.g., `"Workout Mix"`).
- Add at least 5 `Song` objects, including an attempt to add a duplicate song.
- Insert a song at index `0` to make it the first track.
- Search for songs by a specific artist and print the matching list.
- Replace one song, remove another by title, and display the updated playlist.

## How to Run
1. Compile all Java files:
   ```bash
   javac *.java
   ```
2. Run the `Main` class:
   ```bash
   java Main
   ```

## Bonus Challenges
- Implement a `moveSong(int fromIndex, int toIndex)` method to reorder tracks in the playlist.
- Implement a `shuffle()` method using `Collections.shuffle(songs)`.
- Create a `MusicLibrary` class that manages multiple `Playlist` objects in an `ArrayList<Playlist>`.

---
🎧 **Code your own music player with ArrayList!** 🎶
