package com.epam.trapeznikau.dao;

import java.util.List;

import com.epam.trapeznikau.bean.Book;

public interface BookDAO {
	
	boolean updateBooks(List<Book> books);
	List<Book> readBooks(String uri);

}
