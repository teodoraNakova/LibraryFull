package reading_matter;

import java.time.LocalDate;

public class Magazine extends ReadingMatter {

	public enum CategoryTypeMagazine {BEAUTY_AND_STYLE, PROGRAMMING, SCIENCE};
	
	private CategoryTypeMagazine category;
	private int number;
	private LocalDate publishDate;
	
	public Magazine(String name, String publisher, CategoryTypeMagazine category, int number, LocalDate publishDate) {
		super(name, publisher);
		this.category = category;
		this.number = number;
		this.publishDate = publishDate;
	}
	
    public CategoryTypeMagazine getCategory() {
		return category;
	}
	
	public int getNumber() {
		return number;
	}
	
	@Override
	public String toString() {
		return this.getName() + " - " + this.number + " - " + this.publishDate + " - " + this.category + " - " + this.getPublisher();
	}
}
