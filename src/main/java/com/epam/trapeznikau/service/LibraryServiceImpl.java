package com.epam.trapeznikau.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import com.epam.trapeznikau.bean.Book;
import com.epam.trapeznikau.dao.BookDAO;
import com.epam.trapeznikau.dao.DAOFactory;
import com.epam.trapeznikau.utility.BooksParser;



public class LibraryServiceImpl implements LibraryService{
	private final BookDAO bookDAO =  DAOFactory.getInstance().getBookDAO();
	
	@Override
	public List<Book> read(String uri) {
		
		List<Book> books =new  ArrayList<>();
		books = bookDAO.readBooks(uri);
		
		return books;
	}

	@Override
	public boolean delete(String uri, Book delBook) {
		List<Book> books =new  ArrayList<>();
		books = bookDAO.readBooks(uri);
		boolean status = false;
		status = books.remove(delBook);		
		if (status){
			return bookDAO.updateBooks(books);
		} else {
			return status;
		}				
	}

	@Override
	public boolean update(String uri, Book upBook) {
		List<Book> books =new  ArrayList<>();
		books = bookDAO.readBooks(uri);
		boolean status = false;
		Integer id = upBook.getId();
		ListIterator<Book> itr =books.listIterator();
		while(itr.hasNext()){
			Book curBook = itr.next();
			if (curBook.getId()==id){
				curBook.setTitle(upBook.getTitle());
				curBook.setPrice(upBook.getPrice());
				curBook.setAuthor(upBook.getAuthor());
				status =true;
			}
		}
		if (status){
			return bookDAO.updateBooks(books);
		} else {
			return status;
		}						
	}

	@Override
	public boolean create(String uri, Book newBook) {
		List<Book> books =new  ArrayList<>();
		books = bookDAO.readBooks(uri);
		boolean status = false;
				status =books.add(newBook);
		if (status){
			return bookDAO.updateBooks(books);
		} else {
			return status;
		}
	}
}