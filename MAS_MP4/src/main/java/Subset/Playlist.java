package Subset;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
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
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Playlist name must not be null or Empty");
        }
        this.name = name;
    }

    public Set<Song> getSongs() {
        return songs.stream()
                .sorted(Comparator.comparingInt(Song::getDurationInSeconds))
                .collect(Collectors.toSet());
    }

    public void addSong(Song song){
        if(song == null)
            throw new IllegalArgumentException("Song must not be null");

        if(songs.contains(song)){
            throw new IllegalArgumentException("So is already present");
        }
        songs.add(song);
    }

    public void removeSong(Song song){
        if(song == null)
            throw new IllegalArgumentException("Song must not be null");

        if(!songs.contains(song)){
            throw new IllegalArgumentException("So is not present");
        }
        songs.remove(song);
    }
}