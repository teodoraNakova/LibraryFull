

import java.time.LocalDate;

import library.Library;
import reading_matter.Book;
import reading_matter.Magazine;
import reading_matter.Book.GenreTypeBook;
import reading_matter.Magazine.CategoryTypeMagazine;

public class Demo {

	public static void main(String[] args) {
		
		Library library = new Library();
		Book book1 = new Book("name", "a", "a", LocalDate.of(1998, 3, 13), GenreTypeBook.FANTASY);
		Book book2 = new Book("name", "a", "a", LocalDate.of(1991, 3, 13), GenreTypeBook.FANTASY);
		Magazine magazine = new Magazine("a", "a", CategoryTypeMagazine.PROGRAMMING, 1, LocalDate.of(1991, 3, 13));
		library.addReadingMatterToLibrary(book1);
		library.addReadingMatterToLibrary(book2);
		library.addReadingMatterToLibrary(magazine);
		library.printCatalogue();
	}
}
