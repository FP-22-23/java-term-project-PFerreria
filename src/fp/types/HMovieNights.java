package fp.types;

import java.time.LocalDate;

public record HMovieNights(LocalDate relDate, String country, HMLanguage language) {
		
		public String getShortFormat() {
			return "Date= " + relDate() + ", country= " + country() + ", language= " + language();
		}
}
