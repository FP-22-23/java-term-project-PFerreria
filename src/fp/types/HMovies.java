package fp.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HMovies {
	
		private List<HMovie> hmovies;
	
		//Empty constructor
		public HMovies() {
			hmovies = new ArrayList<HMovie>();
		}
		
		//Constructor from collection
		public HMovies(Collection<HMovie> sw) {
			hmovies = new ArrayList<HMovie>(sw);
		}
		
		//Constructor from a stream
		public HMovies(Stream<HMovie> sw) {
			hmovies = sw.collect(Collectors.toList());
		}
		
		//toString and equality criteria
		@Override
		public String toString() {
			return "Horror movie repertoire: " + hmovies;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(hmovies);
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;}
			if (obj == null) {
				return false;}
			if (getClass() != obj.getClass()) {
				return false;}
			HMovies other = (HMovies) obj;
			return Objects.equals(hmovies, other.hmovies);
		}
		
		//Methods
		public Integer getNumberHMovies() {
			return hmovies.size();
		}
		
		public List<HMovie> getHMovies() {
			return hmovies;
		}
		
		public void addHMovie(HMovie hm) {
			hmovies.add(hm);
		}
		
		public void addHMovies(Collection<HMovie> hms) {
			hmovies.addAll(hms);
		}
		
		public void removeHMovie(HMovie hm) {
			hmovies.remove(hm);
		}
		
		public void removeHMovieFromPosition(int pos) {
			hmovies.remove(pos);
		}
		
		//Implementation with loops 
		//Exists: Check if there is a movie with a certain actor 
		public Boolean containsMoviewithActor(String actor) {
			Boolean res = false;
			for(HMovie hm: hmovies) {
				if(hm.getCast().contains(actor)) {
					res = true;
					break;}}
			return res;
		}
		//for Any: Checks if any titles contain the parameter
		public Boolean doMoviesContain(String a) {
			Boolean res = false;
			for(HMovie hm:hmovies) {
				if(hm.getTitle().contains(a)) {
					res = true;
					break;}}
			return res;
		}
		
		// for All: Checks if movies have a higher score than
		public Boolean areMoviesGreaterThanScore(Double score) {
			Boolean res = true;
			for(HMovie hm:hmovies) {
				if(hm.getScore()<score) {
					res = false;
					break;}}
			return res;
		}
		
		//Counter: Count movies from a certain country
		public Integer countHMoviesFromCountry(String country) {
			Integer res = 0;
			for(HMovie hm:hmovies) {
				if(hm.getCountry().equals(country)) {
					res++;}}
			return res;
		}
		
		//Sum: Sum the budget of movies of certain genre
		public Integer sumBudgetMovies(String genre) {
			Integer res = 0;
			for(HMovie hm: hmovies) {
				if(hm.getGenres().contains(genre)) {
					res+=hm.getBudget();}}
			return res;
		}
		
		//Average: Average movie budget
		public Double computeAverageScore() {
			Double res = 0.;
			for(HMovie hm: hmovies) {
				res+= hm.getScore();}
			return res/getNumberHMovies();
			
		}
		
		// Selection with filter
		public List<String> getHMoviesOfGenre(String genre){
			List<String> res = new ArrayList<>();
			for(HMovie hm: hmovies) {
				if(hm.getGenres().contains(genre)) {
					res.add(hm.getTitle());}}
			return res;
		}
		
		public Map<HMLanguage, Set<String>> getCountriesByLanguage(){
			Map<HMLanguage, Set<String>> res = new HashMap<>();
			for(HMovie hm: hmovies) {
				if(res.containsKey(hm.getLanguage())) {
					res.get(hm.getLanguage()).add(hm.getCountry());
				}
				else {
					Set<String> lhm = new TreeSet<>();
					lhm.add(hm.getCountry());
					res.put(hm.getLanguage(), lhm);}}
			return res;
			}
		
		public Map<String, Integer> getNMoviesByCountry(){
			Map<String, Integer> res = new HashMap<>();
			for(HMovie hm: hmovies) {
				if(res.containsKey(hm.getCountry())) {
					res.put(hm.getCountry(), res.get(hm.getCountry()) +1);
				}
				else {
					res.put(hm.getCountry(), 1);
				}
			}
			return res;
		}
		
		//Implementation with streams
		//Total filter: extra function (similar to the Exists one), thought this program didn't have any example of a switch and case, and I wanted to study it
		public List<HMovie> filterByVar(String variable, String value) {
			
			switch(variable) {
			
				case "year":
					try {
						return hmovies.stream().filter(m -> m.getRelDate().getYear()==(Integer.valueOf(value))).toList();
					}
					catch(NumberFormatException e) {
						return new ArrayList<>(); 
					}
				
				case "month":
					try {
						return hmovies.stream().filter(m -> m.getRelDate().getMonthValue()==(Integer.valueOf(value))).toList();
					}
					catch(NumberFormatException e) {
						return new ArrayList<>(); 
					}
					
				case "day":
					try {
						return hmovies.stream().filter(m -> m.getRelDate().getDayOfMonth()==(Integer.valueOf(value))).toList();
					}
					catch(NumberFormatException e) {
						return new ArrayList<>(); 
					}
				
				case "country":
					try {
						return hmovies.stream().filter(m -> m.getCountry().equals(value)).toList();
					}
					catch(NumberFormatException e) {
						return new ArrayList<>(); 
					}
					
				case "language":
					try {
						return hmovies.stream().filter(m -> m.getLanguage().equals(HMLanguage.valueOf(value))).toList();
					}
					catch(NumberFormatException e) {
						return new ArrayList<>(); 
					}
					
				case "actor":
					try {
						return hmovies.stream().filter(m -> m.getCast().contains(value)).toList();
					}
					catch(NumberFormatException e) {
						return new ArrayList<>();
					}
				 
				case "genre":
					try {
						return hmovies.stream().filter(m -> m.getGenres().contains(value)).toList();
					}
					catch(NumberFormatException e) {
						return new ArrayList<>();
					}
				default:
					return new ArrayList<>();
			}
		}
		//Exists: Check if there is a movie with a certain actor
		public Boolean containsMoviewithActorST(String actor) {
			return hmovies.stream().anyMatch(hm->hm.getCast().contains(actor));
		}
		
		//for Any: Checks if all titles contain a variable
		public Boolean doMoviesContainST(String a) {
			return hmovies.stream().anyMatch(hm->hm.getTitle().contains(a));
		}
		
		// for Any: Checks if movies have a higher score than
		public Boolean areMoviesGreaterThanScoreST(Double score) {
			return hmovies.stream().allMatch(hm->hm.getScore() > score);
		}
		
		//Counter: Count movies from a certain country
		public Integer countHMoviesFromCountryST(String country) {
			return (int) hmovies.stream().filter(hm->hm.getCountry().equals(country)).count();
		}
		
		//Sum: Sum the budget of movies of certain genre
		public Integer sumBudgetMoviesST(String genre) {
			return hmovies.stream().filter(hm->hm.getGenres().contains(genre)).mapToInt(hm->hm.getBudget()).sum();
		}
		
		//Average: Average movie budget
		public Double computeAverageScoreST() {
			return hmovies.stream().mapToDouble(hm->hm.getScore()).average().orElse(0.0);
		}
		
		// Selection with filter
		public List<String> getHMoviesOfGenreST(String genre){
			return hmovies.stream().filter(hm->hm.getGenres().contains(genre)).map(HMovie::getTitle).collect(Collectors.toList());
		}
		
		// Maximum with filtering: Returns the most expensive movie of a given country
		public String getTitleOfMostExpensiveMovieOfCountry (String country){
			return hmovies.stream().filter(hm->hm.getCountry().equals(country)).max(Comparator.comparing(HMovie::getBudget)).map(HMovie::getTitle).orElse(null);
		}
		
		//A selection, with filtering and sorting
		public List<HMovie> bestMoviesFromActorInAYear(String actor, Integer year) {
			return hmovies.stream().filter(hm->hm.getCast().contains(actor) && hm.getRelDate().getYear()==year).sorted(Comparator.comparing(HMovie::getScore)).toList();
		}
		
		public Map<HMLanguage, Set<String>> getCountriesByLanguageST() {
		    return hmovies.stream().collect(Collectors.groupingBy(HMovie::getLanguage, Collectors.mapping(HMovie::getCountry, Collectors.toSet())));
		}
		
		public Map<String, Long> getNMoviesByCountryST(){
			return hmovies.stream().collect(Collectors.groupingBy(HMovie::getCountry, Collectors.counting()));
		}
		
		//A method whose implementation is used, either the Collector collectingAndThen, or the Collector mapping: Gives the movie of every main genre ordered
		public Map<String, List<String>> getMovieOfEveryMainGenreOrdered() {
		    return hmovies.stream().collect(Collectors.groupingBy(HMovie::getMainGenre,Collectors.mapping(HMovie::getTitle,Collectors.collectingAndThen(Collectors.toList(), this::aux)))).entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		}

		private List<String> aux(List<String> titles) {
		    return titles.stream().sorted().collect(Collectors.toList());
		}

		// Map with attribute with key attribute and maximum of an attribute as value: Gives the best movie of each language
		public Map<HMLanguage, String> getBestMoviesForLanguages (){
			return hmovies.stream().collect(Collectors.groupingBy(HMovie::getLanguage, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(HMovie::getScore)),hm -> hm.map(HMovie::getTitle).orElse(null))));
		}

		//A method that returns a SortedMap in which the keys are an attribute or a function over an attribute, and the values are lists with the n best or worst elements that share the value of that attribute (or function over the attribute)
		public SortedMap<Integer, List<HMovie>> getMoviesByYearOrderedByScore(Integer n) {
		    SortedMap<Integer, List<HMovie>> auxiliar = hmovies.stream().collect(Collectors.groupingBy(h -> h.getRelDate().getYear(), TreeMap::new, Collectors.toList()));
		    return auxiliar.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,e -> e.getValue().stream().sorted(Comparator.comparing(HMovie::getScore).reversed()).limit(n).toList(),(v1, v2) -> v1, TreeMap::new));
		}
		
		//A method that calculates a Map and returns the key with the associated value (largest or smallest) of the entire Map: : Gives the language with the highest scored movie
		public HMLanguage languageWithBestMovie (){
			return getBestMoviesForLanguages().entrySet().stream().max(Comparator.comparing(hm->hm.getValue())).get().getKey();
		}
	}
