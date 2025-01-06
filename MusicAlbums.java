public class MusicAlbums extends genericAttributes {
    private String artist;
    private long globalSales;
    private int tracks;
    private double duration; 
    private String genre;

    public MusicAlbums(int id, String type, int releaseYear, String artist, String title, long globalSales, int tracks, double duration, String genre) {
        super(id, type, title, releaseYear);
        this.artist = artist;
        this.globalSales = globalSales;
        this.tracks = tracks;
        this.duration = duration;
        this.genre = genre;
    }

    // Getters 
    public String getArtist() {
        return artist;
    }

    public long getGlobalSales() {
        return globalSales;
    }

    public int getTracks() {
        return tracks;
    }

    public double getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }


    public String toString() {
        return getTitle() + " | Artist: " + artist + " | Year: " + getReleaseYear() + " | Global Sales: " + globalSales + " million" + " | Tracks: " + tracks + " | Duration: " + duration + " minutes" + " | Genre: " + genre;
    }

}
