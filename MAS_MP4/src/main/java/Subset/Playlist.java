package Subset;

import java.util.*;
import java.util.stream.Collectors;


public class Playlist {

    private String name;
    private final Set<Song> songs = new HashSet<>();

    public Playlist(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Playlist name must not be null or Empty");
        }
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs.stream()
                .sorted(Comparator.comparingInt(Song::getDurationInSeconds))
                .collect(Collectors.toList());
    }

    public void addSong(Song song){
        if(song == null)
            throw new IllegalArgumentException("Song must not be null");

        if(songs.contains(song)){
            throw new IllegalArgumentException("Song is already present");
        }
        songs.add(song);
    }

    public void removeSong(Song song){
        if(song == null)
            throw new IllegalArgumentException("Song must not be null");

        if(!songs.contains(song)){
            throw new IllegalArgumentException("Song is not present");
        }
        songs.remove(song);
    }
}
