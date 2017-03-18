

import java.time.LocalDate;

import library.Library;
import library.Reader;
import reading_matter.Book;
import reading_matter.Magazine;
import reading_matter.Textbook;
import reading_matter.Book.GenreTypeBook;
import reading_matter.Magazine.CategoryTypeMagazine;
import reading_matter.Textbook.ThemeTypeTextbook;

public class Demo {

	public static void main(String[] args) {
		
		Library library = new Library();
		
		Book hp1 = new Book("Harry Potter 1", "Siela", "J.K", LocalDate.of(2000, 03, 17), GenreTypeBook.FANTASY);
		Book hp2 = new Book("Harry Potter 2", "Siela", "J.K", LocalDate.of(2002, 05, 20), GenreTypeBook.FANTASY);
		Book bg = new Book("History of Bulgaria", "Siela", "Dimo Kyorchev", LocalDate.of(1991, 05, 18), GenreTypeBook.HISTORY);
		
		Magazine natGeo = new Magazine("National Geographic", "FP", CategoryTypeMagazine.SCIENCE, 3, LocalDate.of(2017, 3, 18));
		Magazine natGeo1 = new Magazine("National Geographic", "FP", CategoryTypeMagazine.SCIENCE, 2, LocalDate.of(2017, 2, 18));
		
		Textbook math = new Textbook("Math for begginers", "Prosveta", ThemeTypeTextbook.MATH, "Mihail Raichev");
		Textbook math1 = new Textbook("Advanced math", "Prosveta", ThemeTypeTextbook.MATH, "Mihail Raichev");
		Textbook biology = new Textbook("Biology for begginers", "Prosveta", ThemeTypeTextbook.BIOLOGY, "Stoqnka Gacheva");
		
		library.addReadingMatterToLibrary(hp1);
		library.addReadingMatterToLibrary(hp2);
		library.addReadingMatterToLibrary(bg);
		library.addReadingMatterToLibrary(natGeo);
		library.addReadingMatterToLibrary(natGeo1);
		library.addReadingMatterToLibrary(math);
		library.addReadingMatterToLibrary(math1);
		library.addReadingMatterToLibrary(biology);
		
		library.printCatalogue();
		
		Reader pencho = new Reader("Pencho", hp1);
		Reader minka = new Reader("Minka", natGeo);
		Reader gosho = new Reader("Gosho", math);
		pencho.start();
		minka.start();
		gosho.start();
	}
}
