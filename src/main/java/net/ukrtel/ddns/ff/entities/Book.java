package net.ukrtel.ddns.ff.entities;

import lombok.Data;

@Data
public class Book {
	private String isbn;
	private String title;
	private String description;
	private String author;
	private int printYear;
}
