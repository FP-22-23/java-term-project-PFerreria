package fp.types;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import fp.utils.*;

public class HMovieFactory {
	
	/*DIRECT METHOD
	public static HMovies readHMovies(String fileName) {
		HMovies movies = null;
		try {
			Stream<HMovie> m = Files.lines(Paths.get(fileName)).skip(1).map(HMovieFactory::parseLine);
			movies = new HMovies(m);
		}catch(IOException e) {
			System.out.println("Error with the file " + fileName);
			e.printStackTrace();
		}
		return movies;
	}
	*/
	
	public static List<HMovie> readHMovieList(String fileName) {
		List<HMovie> movies = null;
		try {
			Stream<HMovie> m = Files.lines(Paths.get(fileName)).skip(1).map(HMovieFactory::parseLine);
			movies = new ArrayList<>(m.collect(Collectors.toList()));
		}catch(IOException e) {
			System.out.println("Error with the file " + fileName);
			e.printStackTrace();
		}
		return movies;
	}
	
	public static HMovies readHMovies(String fileName) {
		return new HMovies(readHMovieList(fileName));
	}
	
	public static HMovie parseLine(String line) {
		String[] values = line.split(",");
		Checkers.check("Error in line", values.length == 10);
		String title = values[0].trim();
		List<String> genres = parseCastGen(values[1].trim());
		LocalDate relDate = parseDate(values[2].trim());
		String country  = values[3].trim();
		Boolean rated  = Boolean.valueOf(values[4].trim());
		Double score  = Double.valueOf(values[5].trim());
		Integer duration = Integer.valueOf(values[6].trim());
		List<String> cast = parseCastGen(values[7].trim());
		HMLanguage language = getUpperCaseName(values[8].trim());
		Integer budget = Integer.valueOf(values[9].trim());
		return new HMovie(title,genres,relDate,country,rated,score,duration,cast,language,budget);
	}
	
	private static LocalDate parseDate(String date){
		return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	private static List<String> parseCastGen(String castgen){
		String[] values = castgen.split("\\|");
		Checkers.check("The size can't be null", values.length>0);
		List<String> castList = new ArrayList<>();
		for(String actor:values) {
	    	castList.add(actor.trim());}
		return castList;
	}
	
	public static HMLanguage getUpperCaseName(String lang) {
	    if (lang == null || lang.isEmpty()) {
	        return null;
	    }
	    return HMLanguage.valueOf(lang.toUpperCase());
	}
	
}	