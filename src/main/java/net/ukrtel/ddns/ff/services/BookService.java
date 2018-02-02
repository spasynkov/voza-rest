package net.ukrtel.ddns.ff.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.ukrtel.ddns.ff.entities.Book;

@Service
public class BookService {
	private final List<Book> books = new ArrayList<>();
}
