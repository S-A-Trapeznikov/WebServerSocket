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
	public boolean delete(String uri, String delBook) {
		List<Book> books =new  ArrayList<>();
		books = bookDAO.readBooks(uri);
		Book comBook = null;
		boolean status = false;
		try {
			comBook = BooksParser.parseStrToBook(delBook);
		} catch (ParserConfigurationException | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		status = books.remove(comBook);		
		if (status){
			return bookDAO.updateBooks(books);
		} else {
			return status;
		}				
	}

	@Override
	public boolean update(String uri, String upBook) {
		List<Book> books =new  ArrayList<>();
		books = bookDAO.readBooks(uri);
		Book comBook = null;
		boolean status = false;
		try {
			comBook = BooksParser.parseStrToBook(upBook);
		} catch (ParserConfigurationException | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer id = comBook.getId();
		ListIterator<Book> itr =books.listIterator();
		while(itr.hasNext()){
			Book curBook = itr.next();
			if (curBook.getId()==id){
				curBook.setTitle(comBook.getTitle());
				curBook.setPrice(comBook.getPrice());
				curBook.setAuthor(comBook.getAuthor());
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
	public boolean create(String uri, String newBook) {
		List<Book> books =new  ArrayList<>();
		books = bookDAO.readBooks(uri);
		Book comBook = null;
		boolean status = false;
		try {
			comBook = BooksParser.parseStrToBook(newBook);
		} catch (ParserConfigurationException | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		status =books.add(comBook);
		if (status){
			return bookDAO.updateBooks(books);
		} else {
			return status;
		}
	}
}