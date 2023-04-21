package fp.types;

import java.time.LocalDate;

public record MovieNights(LocalDate relDate, String country, HMLanguage language) {
		
		public String getShortFormat() {
			return "Date= " + relDate() + ", country= " + country() + ", language= " + language();
		}
}
