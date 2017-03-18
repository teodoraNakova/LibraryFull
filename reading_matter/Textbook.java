package reading_matter;

public class Textbook extends ReadingMatter {

	public enum ThemeTypeTextbook {BIOLOGY, LITERATURE, MATH};
	
	private ThemeTypeTextbook theme;
	private String author;
	
	public Textbook(String name, String publisher, ThemeTypeTextbook theme, String author) {
		super(name, publisher);
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
	
	@Override
	public String toString() {
		return this.getName() + " - " + this.author + " - " + this.theme + " - " + this.getPublisher();
	}
}
