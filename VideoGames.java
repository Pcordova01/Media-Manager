public class VideoGames extends genericAttributes {
    private String platform;
    private String genre;
    private String publisher;
    private double copiesSold;

    public VideoGames(int id, String type, String title, String platform, int releaseYear, String genre, String publisher, double copiesSold) {
        super(id, type, title, releaseYear);
        this.platform = platform;
        this.genre = genre;
        this.publisher = publisher;
        this.copiesSold = copiesSold;
    }

    
    
    public String toString() {
        return getTitle() + " | Platform: " + getPlatform() + " | Release Year: " + getReleaseYear() + " | Genre: " + getGenre() + " | Publisher: " + getPublisher() + " | Copies Sold: " + getCopiesSold(); 
    }
    
    // Getters 
    public String getPlatform() {
        return platform;
    }

    public String getGenre() {
        return genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public double getCopiesSold() {
        return copiesSold;
    }

    

}