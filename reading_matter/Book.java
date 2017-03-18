package reading_matter;

import java.time.LocalDate;

public class Book extends ReadingMatter{
	
	public enum GenreTypeBook {FANTASY, HISTORY, ROMANCE, SCI_FI};

	private String author;
	private LocalDate publishDate;
	private GenreTypeBook genre;
	
	public Book(String name, String publisher, String author, LocalDate publishDate, GenreTypeBook genre) {
		super(name, publisher);
		if(validateText(author)) {
			try {
				throw new InvalidDataForReadingMatterException();
			} catch (InvalidDataForReadingMatterException e) {
				System.out.println(e.getMessage());
			}
		}
		this.author = author;
		this.publishDate = publishDate;
		this.genre = genre;
	}

	public GenreTypeBook getGenre() {
		return this.genre;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	@Override
	public String toString() {
		return this.getName() + " - " + this.author + " - " + this.publishDate + " - " + this.genre + " - " + this.getPublisher();
	}
	
	
	
	
}
