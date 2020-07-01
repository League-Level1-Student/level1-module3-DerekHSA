package _05_netflix;

public class Flixnet {
public static void main(String[] args) {
	Movie RTS = new Movie("Revenge of the Sith",4);
	Movie ANH = new Movie("A New Hope",5);
	Movie ESB = new Movie("The Empire Strikes Back",5);
	Movie AE = new Movie("Avengers:Endgame", 4);
	Movie AIW = new Movie("Avengers: Infinity War",4);
	
	NetflixQueue nq = new NetflixQueue();
	
	System.out.println(RTS.getTicketPrice());
	System.out.println(ANH.getTicketPrice());
	System.out.println(ESB.getTicketPrice());
	System.out.println(AE.getTicketPrice());
	System.out.println(AIW.getTicketPrice());
	
	nq.addMovie(RTS);
	nq.addMovie(ANH);
	nq.addMovie(ESB);
	nq.addMovie(AE);
	nq.addMovie(AIW);
	
	nq.printMovies();
	nq.sortMoviesByRating();
	System.out.println(nq.getBestMovie());
	System.out.println(nq.getMovie(2));
	
}
}
