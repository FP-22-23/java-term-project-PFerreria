package fp.types.test;

import fp.types.HMovies;
import fp.types.HMovieFactory;

public class TestHMovies {

    public static void main(String[] args) {
        HMovies hmovies = HMovieFactory.readHMovies("./data/IMDB Horror movies.csv");

        System.out.println("Number of HMovies: " + hmovies.getNumberHMovies());

        System.out.println("\n--- Sublist of HMovies ---");
        System.out.println(hmovies.getHMovies().subList(0, 4));

        System.out.println("\n--- Contains Movie with Actor ---");
        System.out.println(hmovies.containsMoviewithActor("Adrian Voo"));

        System.out.println("\n--- Do Movies Contain ---");
        System.out.println(hmovies.doMoviesContain("jdfef"));
        
        System.out.println("\n--- Are Movies Greater Than Score ---");
        System.out.println(hmovies.areMoviesGreaterThanScore(4.0));

        System.out.println("\n--- Count HMovies from Country ---");
        System.out.println(hmovies.countHMoviesFromCountry("Spain"));

        System.out.println("\n--- Sum Budget of Movies ---");
        System.out.println(hmovies.sumBudgetMovies("Horror"));

        System.out.println("\n--- Compute Average Score ---");
        System.out.println(hmovies.computeAverageScore());

        System.out.println("\n--- HMovies of Genre ---");
        System.out.println(hmovies.getHMoviesOfGenre("Action"));

        System.out.println("\n--- Countries by Language ---");
        System.out.println(hmovies.getCountriesByLanguage());

        System.out.println("\n--- Number of Movies by Country ---");
        System.out.println(hmovies.getNMoviesByCountry());
        
        System.out.println("\n--- Filter by Variable ---");
        System.out.println(hmovies.filterByVar("year", "2017").subList(0, 4));
        
        System.out.println("\n--- Contains Movie with Actor (Stream) ---");
        System.out.println(hmovies.containsMoviewithActorST("Adrian Voo"));

        System.out.println("\n--- Do Movies Contain (Stream) ---");
        System.out.println(hmovies.doMoviesContainST("jdfef"));
        
        System.out.println("\n--- Are Movies Greater Than Score (Stream) ---");
        System.out.println(hmovies.areMoviesGreaterThanScoreST(4.0));

        System.out.println("\n--- Count HMovies from Country (Stream) ---");
        System.out.println(hmovies.countHMoviesFromCountryST("Spain"));

        System.out.println("\n--- Sum Budget of Movies (Stream) ---");
        System.out.println(hmovies.sumBudgetMoviesST("Horror"));

        System.out.println("\n--- Compute Average Score (Stream) ---");
        System.out.println(hmovies.computeAverageScoreST());

        System.out.println("\n--- Title of Most Expensive Movie of Country ---");
        System.out.println(hmovies.getTitleOfMostExpensiveMovieOfCountry("Spain"));

        System.out.println("\n--- Best Movies from Actor in a Year ---");
        System.out.println(hmovies.bestMoviesFromActorInAYear("Adrian Voo", 2017));

        System.out.println("\n--- Countries by Language (Stream) ---");
        System.out.println(hmovies.getCountriesByLanguageST());

        System.out.println("\n--- Number of Movies by Country (Stream) ---");
        System.out.println(hmovies.getNMoviesByCountryST());
        
        System.out.println("\n--- HMovies of Genre (Stream) ---");
        System.out.println(hmovies.getHMoviesOfGenreST("Action"));

        System.out.println("\n--- Best Movies for Languages ---");
        System.out.println(hmovies.getBestMoviesForLanguages());

        System.out.println("\n--- Movies by Year (Ordered by Score) ---");
        System.out.println(hmovies.getMoviesByYearOrderedByScore(1));

        System.out.println("\n--- Language with Best Movie ---");
        System.out.println(hmovies.languageWithBestMovie());

        System.out.println("\n--- Movie of Every Main Genre Ordered ---");
        System.out.println(hmovies.getMovieOfEveryMainGenreOrdered());
        
    }
}