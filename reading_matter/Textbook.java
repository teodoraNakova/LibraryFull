package reading_matter;

public class Textbook extends ReadingMatter {

	public enum ThemeTypeTextbook {BIOLOGY, LITERATURE, MATH};
	private static double TEXTBOOK_TAX = 3;
	private static int MAX_RENT_TIME = 200;
	
	private ThemeTypeTextbook theme;
	private String author;
	private double tax = TEXTBOOK_TAX;
	
	public Textbook(String name, String publisher, ThemeTypeTextbook theme, String author) {
		super(name, publisher, TEXTBOOK_TAX);
		if(validateText(author)) {
			try {
				throw new InvalidDataForReadingMatterException();
			} catch (InvalidDataForReadingMatterException e) {
				System.out.println(e.getMessage());
			}
		}
		this.theme = theme;
		this.author = author;
	}
	
	public ThemeTypeTextbook getTheme() {
		return theme;
	}
	
	public double getTax() {
		return this.tax;
	}
	
	@Override
	public String toString() {
		return this.getName() + " - " + this.author + " - " + this.theme + " - " + this.getPublisher();
	}

	@Override
	public int getMAX_RENT_TIME() {
		return MAX_RENT_TIME;
	}
}
