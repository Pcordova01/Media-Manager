import java.io.BufferedReader; 
import java.io.FileReader; 
import java.util.ArrayList; 

public class Manager { 
    // List for everything!!
    private ArrayList<genericAttributes> List = new ArrayList<>(); 

    // Method for checking the data
    public void parsingMedia() { 
        try (BufferedReader br = new BufferedReader(new FileReader("project1dataset.csv"))) { 
            String s; 
            while ((s = br.readLine()) != null) { 
                String[] temp = s.split(","); 
                try { 
                    // Checks the type of media and number of elements
                    if (temp[1].equals("Movie") && temp.length >= 9) { 
                        Movie movie = new Movie(Integer.parseInt(temp[0]),"Movie",temp[2],temp[3],temp[4],Integer.parseInt(temp[5]),temp[6],Integer.parseInt(temp[7]),temp[8]); 
                        List.add(movie); 
                    } 
                    else if (temp[1].equals("Video Game") && temp.length >= 8) { 
                        VideoGames videoGame = new VideoGames(Integer.parseInt(temp[0]),"Video Game",temp[2],temp[3],Integer.parseInt(temp[4]),temp[5],temp[6],Double.parseDouble(temp[7])); 
                        List.add(videoGame); 
                    } 
                    else if (temp[1].equals("Music Album") && temp.length >= 9) { 
                        MusicAlbums musicAlbum = new MusicAlbums(Integer.parseInt(temp[0]),"Music Album",Integer.parseInt(temp[2]),temp[3],temp[4],Long.parseLong(temp[5]),Integer.parseInt(temp[6]),Double.parseDouble(temp[7]),temp[8]); 
                        List.add(musicAlbum); 
                    } 
                    else if (temp[1].equals("TV Show") && temp.length >= 9) { 
                        TvShow tvShow = new TvShow(Integer.parseInt(temp[0]),"TV Show",temp[2],temp[3],temp[4],Integer.parseInt(temp[5]),temp[6],temp[7],temp[8]); 
                        List.add(tvShow); 
                    } 
                } 
                catch (Exception e) { 
                	
                } 
            } 
        } 
        catch (Exception e) {
        	
        } 
    } 

    // Count the total number of products 
    public int getProductTotal() { 
        return List.size(); 
    } 

    // Count the total number of movies 
    public int getMovies() { 
        // The count of movies starts at 0 
        int movies = 0; 

        // Cycle through the list 
        for(genericAttributes media : List) { 
            if (media instanceof Movie) { 
                movies++; // Counting the movie 
            } 
        } 
        return movies; 
    } 

    // Count the total number of TV Shows 
    public int getTVShows() { 
        // The count of TV Shows starts at 0 
        int tv = 0; 

        // Cycle through the list 
        for(genericAttributes media : List) { 
            if (media instanceof TvShow) { 
                tv++; // Counting the TV Show 
            } 
        } 
        return tv; 
    } 

    // Count the total number of Video Games 
    public int getVideoGames() { 
        // The count of Video Games starts at 0 
        int videogames = 0; 

        // Cycle through the list 
        for(genericAttributes media : List) { 
            if (media instanceof VideoGames) { 
                videogames++; // Counting the Video Game 
            } 
        } 
        return videogames; 
    } 

    // Count the total number of Music Albums 
    public int getMusicAlbums() { 
        // The count of Music Albums starts at 0 
        int musicAlbums = 0; 

        // Cycle through the list
        for(genericAttributes media : List) {  
            if (media instanceof MusicAlbums) {  
                musicAlbums++; // Counting the Music Albums  
            }  
        }  
        return musicAlbums;  
    }  

    // Find the oldest product by release year  
    public genericAttributes oldestProduct() {  
        genericAttributes oldie = null;  

        // Run through the list  
        for(genericAttributes media : List) {  
            // If new release year is older than current oldest release year  
            if (oldie == null || media.getReleaseYear() < oldie.getReleaseYear()) {  
                oldie = media;  
            }  
        }  
        return oldie;  
    }  

    // Find the most popular music album  
    public MusicAlbums popularMusic() {  
        MusicAlbums popularMusic = null;  

        for(genericAttributes media : List) {  
            if (media instanceof MusicAlbums) {  
                // Only music albums  
                MusicAlbums album = (MusicAlbums) media;  

                if(popularMusic == null || album.getGlobalSales() > popularMusic.getGlobalSales()) {  
                    popularMusic = album;  
                }  
            }  
        }  
        return popularMusic;  
    }  

    // Find the most popular Video Game  
    public VideoGames popularVideoGame() {  
        VideoGames popularGame = null;  

        for(genericAttributes media : List) {  
            if (media instanceof VideoGames) {  
                // Only music albums  
                VideoGames album = (VideoGames) media;  
                if(popularGame == null || album.getCopiesSold() > popularGame.getCopiesSold()) {
                    popularGame = album;  
                }
            }
        }
        return popularGame;
    }

    // Find the most common age rating among all film products
    public String commonRating() {
        // Track all of the ratings
        String[] trackRatings = new String[List.size()];
        
        // Tracks count of the ratings
        int[] countRatings = new int[List.size()];
        
        // Tracks number of different ratings
        int diffRatings = 0;
        
        // Sift through all the media
        for(genericAttributes media : List) {
            // If media is tv show or a movie
            if(media instanceof TvShow || media instanceof Movie) {
                // Track the current rating
                String rating;
                
                // If its a movie, get movie rating, if its a tv show, get tv show rating
                if (media instanceof Movie) {
                    rating = ((Movie) media).getRating();
                } else {
                    rating = ((TvShow) media).getRating();
                }
                
                // We assume that rating hasn't been found yet
                boolean foundRating = false;
                
                // Sift through the ratings we already have in our array
                for (int i = 0; i < diffRatings; i++) {
                    // If the ratings are the same, we add to the count and record a rating found
                    if(trackRatings[i].equals(rating)) {
                        countRatings[i]++;
                        foundRating = true;
                        break;
                    }
                }
                
                // If we haven't found the rating, add it to the list of different ratings
                if(!foundRating) {
                    trackRatings[diffRatings] = rating;
                    countRatings[diffRatings] = 1;
                    diffRatings++;
                }
            }
        }
        
        // Initialize the most common rating to null, because we don't know it yet
        String commonRating = null;
        
        // Track the highest count of ratings
        int highestCount = 0;
        
        // Sift through all the different ratings we have so far
        for (int i = 0; i < diffRatings; i++) {
            // If rating's current rating count is greater than highest count so far
            if(countRatings[i] > highestCount) {
                highestCount = countRatings[i];   // Highest count is now a higher number       
                commonRating = trackRatings[i];   // Now the most common rating is current rating
            }
        }
       return commonRating;
   }

   // Find the shortest Movie
   public Movie shortestMovie() {
       Movie shortest = null;
       for(genericAttributes media : List) {
           if (media instanceof Movie) {
               Movie movie = (Movie) media;
               if (shortest == null || movie.getDuration() < shortest.getDuration()) {
                   shortest = movie;
               }
           }
       }
       return shortest;
   }

   // Find the shortest Music Album
   public MusicAlbums shortestMusicAlbum() {
       MusicAlbums shortest = null;
       for(genericAttributes media : List) {
           if (media instanceof MusicAlbums) {
               MusicAlbums album = (MusicAlbums) media;
               if (shortest == null || album.getDuration() < shortest.getDuration()) {
                   shortest = album;
               }
           }
       }
       return shortest;
   }
}