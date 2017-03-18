package library;

import java.util.ArrayList;

import reading_matter.Book;
import reading_matter.Magazine;
import reading_matter.Textbook;
import reading_matter.Book.GenreTypeBook;
import reading_matter.Magazine.CategoryTypeMagazine;
import reading_matter.Textbook.ThemeTypeTextbook;

class LibraryManager {
	
	private Library library;
	
	LibraryManager(Library library) {
		this.library = library;
	}

	void addBookToLibrary(Book book) {
		GenreTypeBook genre = book.getGenre();
		if(!library.getBooks().containsKey(genre)) {
			library.getBooks().put(genre, new ArrayList<Book>());
		}
		library.getBooks().get(genre).add(book);
	}
	
	void addMagazineToLibrary(Magazine magazine) {
		CategoryTypeMagazine category = magazine.getCategory();
		if(!library.getMagazines().containsKey(category)) {
			library.getMagazines().put(category, new ArrayList<Magazine>());
		}
		library.getMagazines().get(category).add(magazine);
	}
	
	void addTextbookToLibrary(Textbook textbook) {
		ThemeTypeTextbook theme = textbook.getTheme();
		if(!library.getTextbooks().containsKey(theme)) {
			library.getTextbooks().put(theme, new ArrayList<Textbook>());
		}
		library.getTextbooks().get(theme).add(textbook);
	}
	
	
	
}
