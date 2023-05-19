package fp.types.test;

import java.time.LocalDate;
import java.util.List;

import fp.types.HMLanguage;
import fp.types.HMovie;

public class TestHMovie {
    public static void main(String[] args) {
        testMovieDetails();
        testGettersAndSetters();
        testComparisons();
        testInvalidInputs();
    }
    
    public static void testMovieDetails() {
    	LocalDate date1 = LocalDate.of(2012, 10, 26);
        HMovie m = new HMovie("Gut (2012)", List.of("Drama", "Romance"), date1, "USA", true, 3.9, 91, List.of("Paco Sanchez", "Pepe Lopez"), HMLanguage.ENGLISH, 261);
        
        System.out.println("Movie Details:");
        System.out.println(m.toString());
    }
    
    public static void testGettersAndSetters() {
        LocalDate date1 = LocalDate.of(2012, 10, 26);
        
        HMovie m = new HMovie("Gut (2012)", List.of("Drama", "Romance"), date1, "USA", true, 3.9, 91, List.of("Paco Sanchez", "Pepe Lopez"), HMLanguage.ENGLISH, 261);
        
        System.out.println("\nGetters and Setters:");
        System.out.println("Title of the movie: " + m.getTitle());
        m.addGenre("Horror");
        System.out.println("Genres: " + m.getGenres());
        System.out.println("Release Date: " + m.getRelDate());
        System.out.println("Country: " + m.getCountry());
        System.out.println("Rated: " + m.getRated());
        System.out.println("Score: " + m.getScore());
        System.out.println("Duration: " + m.getDuration());
        m.addActor("Roberto Lopez");
        System.out.println("Cast: " + m.getCast());
        System.out.println("Language: " + m.getLanguage());
        System.out.println("Budget: " + m.getBudget());
        System.out.println("Number of Actors: " + m.getNumberActors());
        System.out.println("Expense per Minute: " + m.getExpensePerMinute());
        System.out.println("Main Character: " + m.getMainCharacter());
        System.out.println("Main Genre: " + m.getMainGenre());
    }
    
    public static void testComparisons() {
        LocalDate date1 = LocalDate.of(2012, 10, 26);
        LocalDate date2 = LocalDate.of(2017, 1, 13);
        
        HMovie m = new HMovie("Gut (2012)", date1, "USA", 91, 261);
        HMovie m1 = new HMovie("Gut (2012)", date1, "USA", 91, 261);
        HMovie m2 = new HMovie("The Haunting of Mia Moss (2017)", date2, "USA", 90, 881);
        
        System.out.println("\nComparisons:");
        System.out.println("Comparison 1: " + m2.compareTo(m1));
        System.out.println("Comparison 2: " + m1.compareTo(m));
        System.out.println("Equality 1: " + m2.equals(m1));
        System.out.println("Equality 2: " + m1.equals(m));
    }
    
    public static void testInvalidInputs() {
        HMovie m = new HMovie("Gut (2012)", LocalDate.of(2012, 10, 26), "USA", 91, 261);
        
        System.out.println("\nInvalid Inputs:");
        m.setTitle("");
        m.setDuration(-1);
        m.setBudget(-1);
    }
}