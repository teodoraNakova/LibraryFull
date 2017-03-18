package library;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

import reading_matter.Book;
import reading_matter.Book.GenreTypeBook;
import reading_matter.Magazine;
import reading_matter.Magazine.CategoryTypeMagazine;
import reading_matter.ReadingMatter;
import reading_matter.Textbook;
import reading_matter.Textbook.ThemeTypeTextbook;

public class Library {

	private TreeMap<GenreTypeBook, ArrayList<Book>> books;
	private TreeMap<CategoryTypeMagazine, ArrayList<Magazine>> magazines;
	private TreeMap<ThemeTypeTextbook, ArrayList<Textbook>> textbooks;
	private LibraryManager libraryManager;
	private CatalogueManager catalogueManager;
	
	public Library() {
		this.books = new TreeMap<Book.GenreTypeBook, ArrayList<Book>>();
		this.magazines = new TreeMap<Magazine.CategoryTypeMagazine, ArrayList<Magazine>>();
		this.textbooks = new TreeMap<Textbook.ThemeTypeTextbook, ArrayList<Textbook>>();
	    this.libraryManager = new LibraryManager(this);
	    this.catalogueManager = new CatalogueManager(this);
	}
	
	TreeMap<GenreTypeBook, ArrayList<Book>> getBooks() {
		return books;
	}
	
	TreeMap<CategoryTypeMagazine, ArrayList<Magazine>> getMagazines() {
		return magazines;
	}
	
	TreeMap<ThemeTypeTextbook, ArrayList<Textbook>> getTextbooks() {
		return textbooks;
	}
	
	public void addReadingMatterToLibrary(ReadingMatter readingMatter) {
		if(readingMatter instanceof Book) {
			Book book = (Book) readingMatter;
			libraryManager.addBookToLibrary(book);
		}
		if(readingMatter instanceof Magazine) {
			Magazine magazine = (Magazine) readingMatter;
			libraryManager.addMagazineToLibrary(magazine);
		}
		if(readingMatter instanceof Textbook) {
			Textbook textbook = (Textbook) readingMatter;
			libraryManager.addTextbookToLibrary(textbook);
		}
	}
	
	public void printCatalogue() {
		catalogueManager.printCatalogue();
	}
	
	public synchronized static void monitorReturnDate(ReadingMatter readingMatter) {
		int sleepTime = 0;
		if(readingMatter instanceof Book) {
			try {	
				sleepTime = new Random().nextInt(500);
				Thread.sleep(sleepTime); // max is 3 seconds
			} catch (InterruptedException e) {
				System.out.println("Interrupted reading book.");
			} 
		}
		
		if(readingMatter instanceof Textbook) {
			try {
				sleepTime = new Random().nextInt(500);
				Thread.sleep(sleepTime); // max is 2 seconds
			} catch (InterruptedException e) {
				System.out.println("Interrupted reading textbook.");
			} 
		}
		if(sleepTime <= readingMatter.getMAX_RENT_TIME()) {
			System.out.println("You need to pay " + readingMatter.getTax());
			readingMatter.addReturnDate(LocalDateTime.now());
			readingMatter.setAvailable(true);
			return;
		} 
		double tax = readingMatter.getTax();
		if(sleepTime > readingMatter.getMAX_RENT_TIME()) {
			tax+= tax*0.01;
		}
		System.out.println("You need to pay " + tax);
		readingMatter.addReturnDate(LocalDateTime.now());
		readingMatter.setAvailable(true);
	}
	
}
