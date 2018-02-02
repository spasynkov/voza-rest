package net.ukrtel.ddns.ff.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.ukrtel.ddns.ff.entities.Book;
import net.ukrtel.ddns.ff.services.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	private BookService service;

	@Autowired
	public BookController(BookService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Book> getAllBooks() {
		return service.getBooks();
	}

	@RequestMapping(value = "/{id}", method = GET)
	public Object getBook(@PathVariable int id) {
		Book book = service.getById(id);
		return book != null ? book : new Error("No book with id=" + id + " found!");
	}

	@RequestMapping(method = POST)
	public Object addBook(@RequestParam(required = false) long id,
	                      @RequestParam(required = false) String title,
	                      @RequestParam(required = false) String descripton,
	                      @RequestParam(required = false) String author,
	                      @RequestParam(required = false) int year) {
		Book book = new Book(id, title, descripton, author, year);
		return service.create(book) ? book : new Error("Failed to create new " + book);
	}

	@RequestMapping(method = PUT)
	public Object addOrUpdateBook(@RequestParam(required = false) long id,
	                              @RequestParam(required = false) String title,
	                              @RequestParam(required = false) String descripton,
	                              @RequestParam(required = false) String author,
	                              @RequestParam(required = false) int year) {
		return addBook(id, title, descripton, author, year);
	}

	@RequestMapping(method = PATCH)
	public Book updateBook(@RequestParam(required = false) long id,
	                       @RequestParam(required = false) String title,
	                       @RequestParam(required = false) String description,
	                       @RequestParam(required = false) String author,
	                       @RequestParam(required = false) int year) {
		Book book = new Book(id, title, description, author, year);
		return service.update(book) ? book : null;
	}

	@RequestMapping(value = "/{id}", method = DELETE)
	public Object deleteBook(@PathVariable int id) {
		Book removedBook = service.delete(id);
		return removedBook != null ? removedBook : new Error("Failed to remove book with id=" + id + "!");
	}

	public static class Error {
		private String errorMessage;

		public Error() {
		}

		public Error(String errorMessage) {
			this.errorMessage = errorMessage;
		}

		public String getErrorMessage() {
			return errorMessage;
		}

		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}
	}
}
