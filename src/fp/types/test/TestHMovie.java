package fp.types.test;

import java.time.LocalDate;

import fp.types.HMLanguage;
import fp.types.HMovie;

public class TestHMovie {
	public static void main(String[] args) {
		LocalDate date1 =  LocalDate.of(2012, 10, 26);
		LocalDate date2 =  LocalDate.of(2017, 1, 13);
		HMovie m = new HMovie("Gut (2012)", "Drama| Horror| Thriller", date1, "USA", 3.9, 91, 
				HMLanguage.ENGLISH, 261);
		HMovie m2 = new HMovie("The Haunting of Mia Moss (2017)", date2, "USA", 90, 881);
		HMovie m1 = new HMovie("Gut (2012)", date1, "USA", 91, 261);
		System.out.println(m.toString());
		System.out.println(m.getTitle());
		System.out.println(m.getGenres());
		System.out.println(m.getRelDate());
		System.out.println(m.getCountry());
		System.out.println(m.getScore());
		System.out.println(m.getDuration());
		System.out.println(m.getCast());
		System.out.println(m.getLanguage());
		System.out.println(m.getBudget());
		//System.out.println(m.getNumberActors());
		System.out.println(m.getExpensePerMinute());
		System.out.println(m2.compareTo(m1));
		System.out.println(m1.compareTo(m));
		System.out.println(m2.equals(m1));
		System.out.println(m1.equals(m));
		
		m.setTitle("");
		m.setDuration(-1);
		m.setBudget(-1);
	}
}
