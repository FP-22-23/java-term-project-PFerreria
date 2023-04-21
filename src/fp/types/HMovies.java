package fp.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class HMovies {
	
		private List<HMovie> hmovies;
	
		public HMovies() {
			hmovies = new ArrayList<HMovie>();
		}
		
		public HMovies(Stream<HMovie> sw) {
			hmovies = sw.collect(Collectors.toList());
		}
		
		public Integer getNumberHMovies() {
			return hmovies.size();
		}

		public List<HMovie> getHMovies() {
			return hmovies;
		}
		
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
		public void addHMovie(HMovie hm) {
			hmovies.add(hm);
		}
		
		public void addHMovie(Collection<HMovie> hms) {
			hmovies.addAll(hms);
		}
		
		public void removeHMovie(HMovie hm) {
			hmovies.remove(hm);
		}
		
		//Exists: Check if there is a movie with a certain actor
		public Boolean containsMoviewithActor(String actor) {
			Boolean res = false;
			for(HMovie hm: hmovies) {
				if(hm.getCast().contains(actor)) {
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
		public Integer sumBudgetMovies() {
			Integer res = 0;
			for(HMovie hm: hmovies) {
				if(hm.getGenres()) {
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
			for(HMovies hm: hmovies) {
				if(hm.getGenres().contains(genre)) {
					res.add(hm.getTitle());}}
			return res;
		}
		
		public Map<String, List<String>> getMoviesbyLanguage(){
			Map<String, List<String>> res = new HashMap<>();
			for(HMovie hm: hmovies) {
				if(res.keySet().contains(hm.getLanguage())) {
					res.get(hm.getLanguage()).add(hm.getTitle());
				}
				else {
					List<String> lhm = new ArrayList<>();
					lhm.add(hm.getTitle());
					res.put(hm.getLanguage(), lhm);}}
			return res;
			}
		
		public Map<String, Integer> getMoviesbyCountry(){
			Map<String, Integer> res = new HashMap<>();
			for(HMovie hm: hmovies) {
				if(res.keySet().contains(hm.getCountry())) {
					res.put(hm.getCountry(), res.get(hm.getCountry()) +1);
				}
				else {
					res.put(hm.getCountry(), 1);
				}
			}
			return res;
		}
			
}
