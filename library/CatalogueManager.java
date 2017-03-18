package library;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.Map.Entry;

import reading_matter.Book;
import reading_matter.Magazine;
import reading_matter.Textbook;
import reading_matter.Book.GenreTypeBook;
import reading_matter.Magazine.CategoryTypeMagazine;
import reading_matter.Textbook.ThemeTypeTextbook;

public class CatalogueManager {

	private Library library;
	
	CatalogueManager(Library library) {
		this.library = library;
	}
	
	void printCatalogue() {
		printBooksInCatalogue();
		printMagazinesInCatalogue();
		printTextbooksInCatalogue();
	}
	
	private void printBooksInCatalogue() {
		TreeMap<GenreTypeBook, ArrayList<Book>> catalogueBooks = new TreeMap<Book.GenreTypeBook, ArrayList<Book>>();
		catalogueBooks.putAll(library.getBooks());
		for(Entry<GenreTypeBook, ArrayList<Book>> e : catalogueBooks.entrySet()) {
			System.out.println(e.getKey());
			ArrayList<Book> sortedBooks = new ArrayList<Book>();
			sortedBooks.addAll(e.getValue());
			sortedBooks.sort(new Comparator<Book>() {
				@Override
				public int compare(Book book1, Book book2) {
					return book2.getPublishDate().compareTo(book1.getPublishDate());
				}			
			});
			for(Book b : sortedBooks) {
				System.out.println(b);
			}
		}
	}
	
	private void printMagazinesInCatalogue() {
		TreeMap<CategoryTypeMagazine, ArrayList<Magazine>> catalogueMagazines = new TreeMap<Magazine.CategoryTypeMagazine, ArrayList<Magazine>>();
		catalogueMagazines.putAll(library.getMagazines());
		for(Entry<CategoryTypeMagazine, ArrayList<Magazine>> e : catalogueMagazines.entrySet()) {
			System.out.println(e.getKey());
			ArrayList<Magazine> sortedMagazines = new ArrayList<Magazine>();
			sortedMagazines.addAll(e.getValue());
			sortedMagazines.sort(new Comparator<Magazine>() {
				@Override
				public int compare(Magazine magazine1, Magazine magazine2) {
					if(magazine1.getName().compareTo(magazine2.getName()) != 0) {
						return magazine1.getName().compareTo(magazine2.getName());
					} else {
						return magazine1.getNumber() - magazine2.getNumber();
					}
				}
			});
				
			for(Magazine m : sortedMagazines) {
				System.out.println(m);
			}
		}
	}
	
	private void printTextbooksInCatalogue() {
		TreeMap<ThemeTypeTextbook, ArrayList<Textbook>> catalogueTextbooks = new TreeMap<ThemeTypeTextbook, ArrayList<Textbook>>();
		catalogueTextbooks.putAll(library.getTextbooks());
		for(Entry<ThemeTypeTextbook, ArrayList<Textbook>> e : catalogueTextbooks.entrySet()) {
			System.out.println(e.getKey());
			ArrayList<Textbook> sortedTextbooks = new ArrayList<Textbook>();
			sortedTextbooks.addAll(e.getValue());
			sortedTextbooks.sort(new Comparator<Textbook>() {
				@Override
				public int compare(Textbook textbook1, Textbook textbook2) {
					return textbook1.getName().compareTo(textbook2.getName());
				}
			});
				
			for(Textbook t : sortedTextbooks) {
				System.out.println(t);
			}
		}
	}
}
