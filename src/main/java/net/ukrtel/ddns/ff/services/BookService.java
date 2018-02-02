package net.ukrtel.ddns.ff.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import net.ukrtel.ddns.ff.entities.Book;

@Service
public class BookService {
	private static final Comparator<Book> COMPARATOR = (a, b) -> (int) (a.getId() - b.getId());

	private final List<Book> books = new ArrayList<>();

	public BookService() {
		books.add(new Book(1,
				"Head First Java, 2nd Edition",
				"Learning a complex new language is no easy task especially when it s an object-oriented computer programming language like Java. You might think the problem is your brain. It seems to have a mind of its own, a mind that doesn't always want to take in the dry, technical stuff you're forced to study...",
				"Bert Bates, Kathy Sierra",
				2009));
		books.add(new Book(2,
				"Head First Servlets and JSP, 2nd Edition",
				"Looking to study up for the new J2EE 1.5 Sun Certified Web Component Developer (SCWCD) exam?",
				"Bert Bates, Kathy Sierra, Bryan Basham",
				2009));
		books.add(new Book(3,
				"The Old Man and The Sea",
				"The Old Man and the Sea is one of Hemingway's most enduring works. Told in language of great simplicity and power, it is the story of an old Cuban fisherman, down on his luck, and his supreme ordeal -- a relentless, agonizing battle with a giant marlin far out in the Gulf Stream. \n" +
						"\n" +
						"Here Hemingway recasts, in strikingly contemporary style, the classic theme of courage in the face of defeat, of personal triumph won from loss. Written in 1952, this hugely successful novella confirmed his power and presence in the literary world and played a large part in his winning the 1954 Nobel Prize for Literature.",
				"Ernest Hemingway",
				1995));
	}

	public List<Book> getBooks() {
		return books;
	}

	public Book getById(long id) {
		return books.stream()
				.filter(book -> book.getId() == id)
				.findFirst()
				.orElse(null);
	}

	public boolean create(Book newBook) {
		for (Book book : books) {
			if (book.getId() == newBook.getId()) return false;
		}

		synchronized (books) {
			books.add(newBook);
			books.sort(COMPARATOR);
		}
		return true;
	}

	public boolean update(Book newBook) {
		for (Book book : books) {
			if (book.getId() == newBook.getId()) {
				book.setTitle(newBook.getTitle());
				book.setDescription(newBook.getDescription());
				book.setAuthor(newBook.getAuthor());
				book.setPrintYear(newBook.getPrintYear());
				return true;
			}
		}
		return false;
	}

	public Book delete(long id) {
		for (Book book : books) {
			if (book.getId() == id) {
				books.remove(book);
				return book;
			}
		}

		return null;
	}
}
