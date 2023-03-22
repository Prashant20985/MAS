package Subset;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SubsetTest {

    @Test
    public void test(){
        Song song1 = new Song("Song 1", "Artist 1", 180);
        Song song2 = new Song("Song 2", "Artist 2", 160);

        Playlist playlist = new Playlist("Playlist 1");
        playlist.addSong(song1);
        playlist.addSong(song2);
        assertEquals(2, playlist.getSongs().size());
        assertTrue(playlist.getSongs().contains(song1));
        assertTrue(playlist.getSongs().contains(song2));

        playlist.removeSong(song1);
        assertEquals(1, playlist.getSongs().size());
        assertTrue(!playlist.getSongs().contains(song1));

        playlist.removeSong(song2);
        assertEquals(0, playlist.getSongs().size());
        assertTrue(!playlist.getSongs().contains(song2));
    }

    @Test
    public void testCompareTo(){
        Song song1 = new Song("Song 1", "Artist 1", 200);
        Song song2 = new Song("Song 2", "Artist 1", 300);
        Song song3 = new Song("Song 3", "Artist 2", 400);
        Song song4 = new Song("Song 4", "Artist 2", 200);

        List<Song> songs = Arrays.asList(song1, song2, song3, song4);
        Collections.sort(songs);

        assertEquals(song1, songs.get(0));
        assertEquals(song4, songs.get(1));
        assertEquals(song2, songs.get(2));
        assertEquals(song3, songs.get(3));
    }
}