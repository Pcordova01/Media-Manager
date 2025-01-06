public abstract class genericAttributes {
    private int id;
    private String type;
    private String title;
    private int releaseYear;

    public genericAttributes(int id, String type, String title, int releaseYear) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.releaseYear = releaseYear;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
    
}