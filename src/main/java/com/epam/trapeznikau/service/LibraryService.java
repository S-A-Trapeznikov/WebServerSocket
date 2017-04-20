package com.epam.trapeznikau.service;


import java.util.List;

import com.epam.trapeznikau.bean.Book;

public interface LibraryService {
	
	List<Book> read(String uri);
	boolean delete(String uri,String book);
	boolean update(String uri,String book);
	boolean create(String uri,String book);

}
