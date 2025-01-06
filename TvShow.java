public class TvShow extends genericAttributes {
    private String creator;
    private String country;
    private int year;
    private String rating;
    private String seasons;
    private String description;

    // Constructor
    public TvShow(int id, String type, String title, String creator, String country, int year, String rating, String seasons, String description) {
        super(id, type, title, year); 
        this.creator = creator;
        this.country = country;
        this.year = year;
        this.rating = rating;
        this.seasons = seasons;
        this.description = description;
    }

    // Getters
    public String getCreator() {
        return creator;
    }

    public String getCountry() {
        return country;
    }

    public int getYear() {
        return year;
    }

    public String getRating() {
        return rating;
    }

    public String getSeasons(String seasons) {
        return seasons;
    }

    public String getDescription() {
        return description;
    }

    //Don't need any toString()
}
