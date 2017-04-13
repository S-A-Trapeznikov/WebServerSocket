package com.epam.trapeznikau.bean;

import java.util.Date;

public class Book {
	private String author;
	private String title;
	private String price;
	
	public Book(){}
	
	public Book(String author,String title, String price ){
		this.author = author;
		this.title = title;
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setYearPublish(Date yearPrice) {
		this.price = price;
	}
	
	

}
