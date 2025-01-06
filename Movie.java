public class Movie extends genericAttributes {
    private String director;
    private String country;
    private String rating;
    private int duration; 
    private String description;

    public Movie(int id, String type, String title, String director, String country, int releaseYear, String rating, int duration, String description) {
        super(id, type, title, releaseYear);
        this.director = director;
        this.country = country;
        this.rating = rating;
        this.duration = duration;
        this.description = description;
    }

    
    public String toString() {
        return getTitle() + " | Director: " + director + " | Country: " + country + " | Year: " + getReleaseYear() + " | Rating: " + rating  + " | Duration: " + duration + " (minutes) | Description: " + description;
    }
    
    // Getters
    public String getDirector() {
        return director;
    }

    public String getCountry() {
        return country;
    }

    public String getRating() {
        return rating;
    }

    public int getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }
    
    //Don't need setters
}