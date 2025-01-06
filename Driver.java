
public class Driver {

	
	public static void main(String[] args) {
	Manager manager = new Manager();
	
	manager.parsingMedia();
	
	 System.out.println("Total number of products: " + manager.getProductTotal());
     System.out.println("Total number of Movies: " + manager.getMovies());
     System.out.println("Total number of TV Shows: " + manager.getTVShows());
     System.out.println("Total number of Video Games: " + manager.getVideoGames());
     System.out.println("Total number of Music Albums: " + manager.getMusicAlbums());
     System.out.println("Oldest product: " + manager.oldestProduct());
     System.out.println("Most popular Music Album: " + manager.popularMusic());
     System.out.println("Most popular Video Game: " + manager.popularVideoGame());
     System.out.println("Most common age rating for films: " + manager.commonRating());
     System.out.println("Shortest Movie: " + manager.shortestMovie());
     System.out.println("Shortest Music Album: " + manager.shortestMusicAlbum());
	
	}
}
