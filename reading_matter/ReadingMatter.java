package reading_matter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

import library.Library;

public abstract class ReadingMatter {

	private String name;
	private String publisher;
	private boolean isAvailable;
	private double tax;
	private ArrayList<LocalDateTime> rentDates;
	private ArrayList<LocalDateTime> returnDates;
	
	public ReadingMatter(String name, String publisher, double tax) {
		if(validateText(name) || validateText(publisher)) {
			try {
				throw new InvalidDataForReadingMatterException();
			} catch (InvalidDataForReadingMatterException e) {
				System.out.println(e.getMessage());
			}
		}
		this.name = name;
		this.publisher = publisher;
		this.isAvailable = true;
		this.tax = tax;
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
	
	public LocalDateTime getRentDate() {
		return this.rentDates.get(rentDates.size() - 1);
	}
	
	public abstract int getMAX_RENT_TIME();
	
	public boolean getIsAvailable() {
		return this.isAvailable;
	}
	
	public double getTax() {
		return tax;
	}
	
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public synchronized void rent() {
		this.isAvailable = false;
		this.addRentDate(LocalDateTime.now());
		
		if(this instanceof Book || this instanceof Textbook) {
			Library.monitorReturnDate(this);
		}
		
		if(this instanceof Magazine) {
			System.out.println("Sorry, you can't rent magazines.");
		}
	}
	
}
