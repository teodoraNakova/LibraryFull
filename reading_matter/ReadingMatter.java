package reading_matter;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class ReadingMatter {

	private String name;
	private String publisher;
	private ArrayList<LocalDateTime> rentDates;
	private ArrayList<LocalDateTime> returnDates;
	
	public ReadingMatter(String name, String publisher) {
		if(validateText(name) || validateText(publisher)) {
			try {
				throw new InvalidDataForReadingMatterException();
			} catch (InvalidDataForReadingMatterException e) {
				System.out.println(e.getMessage());
			}
		}
		this.name = name;
		this.publisher = publisher;
		this.rentDates = new ArrayList<LocalDateTime>();
		this.returnDates = new ArrayList<LocalDateTime>();
	}
	
	protected boolean validateText(String text) {
		return text == null || text.isEmpty();
	}
	
	public String getName() {
		return name;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void addRentDate(LocalDateTime rentDate) {
		this.rentDates.add(rentDate);
	}
	
	public void addReturnDate(LocalDateTime returnDate) {
		this.returnDates.add(returnDate);
	}
	
}
