package library;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map.Entry;
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
	
}
