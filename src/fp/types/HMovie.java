package fp.types;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import fp.utils.Checkers;

public class HMovie {
	private String title;
	private List<String> genres;
	private LocalDate relDate;
	private String country;
	private Boolean rated;
	private Double score;
	private Integer duration;
	private List<String> cast;
	private HMLanguage language;
	private Integer budget;
	
	public HMovie (String title, List<String> genres, LocalDate relDate, String country, Double score, Integer duration, List<String> cast, HMLanguage language, Integer budget) {
		Checkers.check("Error in title", title != null && title != "");
		Checkers.check("Error in duration", duration > 0);
		Checkers.check("Error in country", country != null);
		this.title = title;
		this.genres = new ArrayList<>();
		this.relDate = relDate;
		this.country = country;
		this.score = score;
		this.duration = duration;
		this.cast = new ArrayList<>();
		this.language = language;
		this.budget = budget;
	}
	
	public HMovie (String title, LocalDate relDate, String country, Integer duration) {
		Checkers.check("Error in title", title != null && title != "");
		Checkers.check("Error in duration", duration > 0);
		Checkers.check("Error in country", country != null);
		this.title = title;
		this.relDate = relDate;
		this.country = country;
		this.duration = duration;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		Checkers.check("Error in title", title != null && title != "");
		this.title = title;
	}
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
	}
	public LocalDate getRelDate() {
		return relDate;
	}
	public void setRelDate(LocalDate relDate) {
		this.relDate = relDate;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		Checkers.check("Error in country", country != null);
		this.country = country;
	}
	public Boolean getRated() {
		return rated;
	}
	
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		Checkers.check("Error in duration", duration > 0);
		this.duration = duration;
	}
	public List<String> getCast() {
		return cast;
	}
	public void setCast(List<String> cast) {
		this.cast = cast;
	}
	public HMLanguage getLanguage() {
		return language;
	}
	public void setLanguage(HMLanguage language) {
		this.language = language;
	}
	public Integer getBudget() {
		return budget;
	}
	public void setBudget(Integer budget) {
		Checkers.check("Error in budget", budget > 0);
		this.budget = budget;
	}
	public void addActor(String actor) {
		cast.add(actor);
	}
	public void addActors(List<String> actors) {
		cast.addAll(actors);
	}
	public void addGenre(String genre) {
		genres.add(genre);
	}
	public void addGenres(List<String> genres) {
		genres.addAll(genres);
	}
	public Integer getNumberActors() {
		return getCast().size();
	}
	public Double getExpensePerMinute() {
		return (double) (getBudget()/getDuration());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HMovie other = (HMovie) obj;
		return Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Movie: " + title + ", straight from " + country + " (Starring " + getCast() + ", length: " + 
				duration + ") OUT ON THE " + relDate + "for all the "+ getGenres() +" fans!";
	}
	
	public int compareTo(HMovie m) {
		int res = 0;
		if(getScore() != null && m.getScore() != null) {
			res = getScore().compareTo(m.getScore());
		}
		if(res==0) {
			res = getBudget().compareTo(m.getBudget());
		}
		return res;
	}
}
