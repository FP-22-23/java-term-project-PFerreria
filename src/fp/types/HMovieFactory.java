import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;
import utils.Checkers;

public class HMovieFactory {
	
	public static HMovies readHMovies(String fileName) {
		HMovies movies = null;
		try {
			Stream<HMovie> st = Files.lines(Paths.get(fileName)).skip(1).map(HMovieFactory::parseLine);
			movies = new HMovies(m);
		}catch(IOException e) {
			System.out.println("Error with the file " + fileName);
			e.printStackTrace();
		}
		return movies;
	}
	
	public static HMovie parseLine(String line) {
		String[] values = line.split(",");
		Checkers.check("Error in line", values.length == 4);
		String title = values[0].trim();
		List<String> genres = parseGenres(values[1].trim());
		LocalDate relDate = LocalDate.parse(values[2].trim(), DateTimeFormatter.ofPattern("dd/MM/YY"));
		String country  = values[3].trim();
		Boolean rated  = Boolean.valueOf(values[4].trim());
		Double score  = Integer.valueOf(values[5].trim());
		Integer duration = Integer.valueOf(values[6].trim());
		List<String> cast = parseCast(values[7].trim());
		HMLanguage language = HMLanguage.valueOf(values[8].trim());
		Integer budget = Integer.valueOf(fields[9].trim());
		return new HMovie(title,genres,relDate,country,rated,score,duration,cast,language,budget);
	}
	
	private static List<String> parseCast(String cast){
		String[] values = cast.split("|");
		Checkers.check("The size can't be null", values.length>0);
		List<String> castList = new ArrayList<>();
		for(String actor:values) {
	    	castList.add(actor);}
		return castList;
	}
	
	private static List<String> parseGenres(String genres){
		String[] values = cast.split("|");
		Checkers.check("The size can't be null", values.length>0);
		List<String> genresList = new ArrayList<>();
		for(String genre:values) {
	    	genresList.add(genres);}
		return genresList;
	}
}	