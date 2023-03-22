package Subset;

public class Song implements Comparable<Song>{

    private String title;
    private String artist;
    private int durationInSeconds;

    public Song(String title, String artist, int durationInSeconds) {
        setTitle(title);
        setArtist(artist);
        setDurationInSeconds(durationInSeconds);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title == null || title.isEmpty()){
            throw new IllegalArgumentException("Title must not be blank or empty");
        }
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        if(artist == null || artist.isEmpty()){
            throw new IllegalArgumentException("artist must not be blank or empty");
        }
        this.artist = artist;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    @Override
    public int compareTo(Song o) {
        return Integer.compare(this.durationInSeconds, o.durationInSeconds);
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", durationInSeconds=" + durationInSeconds +
                '}';
    }
}
