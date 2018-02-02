package net.ukrtel.ddns.ff.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
	private long id;
	private String title;
	private String description;
	private String author;
	private int printYear;
}
