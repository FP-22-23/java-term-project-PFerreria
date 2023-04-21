package fp.types.test;

import fp.types.*;

public class TestHMovies {
	
	private static HMovies hmovies = HMovieFactory.readHMovies("./data/IMDB Horror movies.csv");

	public static void main(String[] args) {

	    System.out.println(hmovies.getNumberHMovies());
	    
	    System.out.println(hmovies.getHMovies().subList(0,9));
	
		System.out.println(hmovies.containsMoviewithActor("Adrian Voo));
	
		System.out.println(hmovies.areMoviesGreaterThanScore(4.0));
	
		System.out.println(hmovies.countHMoviesFromCountry("Spain"));
	
		System.out.println(hmovies.sumBudgetMovies());
	
		System.out.println(hmovies.computeAverageScore());
	
		System.out.println(hmovies.getHMoviesOfGenre("Action"));
	
		System.out.println(hmovies.getMoviesbyLanguage());
		
		System.out.println(hmovies.getMoviesbyCountry());
	}
	}