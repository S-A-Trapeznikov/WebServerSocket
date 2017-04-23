package com.epam.trapeznikau.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.epam.trapeznikau.bean.Book;
import com.epam.trapeznikau.utility.BooksParser;

public class XMLBookDAO implements BookDAO{
	
	public final static String URI_BOOKS = "d:\\JOB\\EPAM\\TAT\\Webservice\\Tasks\\WebServerSocket\\resources\\Books.xml";
	public final static String GET_BOOKS = "/book";
	
	@Override
	public boolean updateBooks(List<Book> books) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document document = builder.newDocument();
		ListIterator<Book> iterator = books.listIterator();
		Element bookStore = document.createElement("bookstore");
		while (iterator.hasNext()){
			Book bookIt = iterator.next();
			Element book = document.createElement("book");
			book.setAttribute("id",String.valueOf(bookIt.getId()));
			Element title = document.createElement("title");
			title.setTextContent(bookIt.getTitle());
			Element author = document.createElement("author");
			author.setTextContent(bookIt.getAuthor());
			Element price = document.createElement("price");
			price.setTextContent(bookIt.getPrice());
			book.appendChild(title);
			book.appendChild(author);
			book.appendChild(price);
			bookStore.appendChild(book);
		}
		document.appendChild(bookStore);		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer;
		try {
			transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);		
			StreamResult result = new StreamResult(new FileWriter(URI_BOOKS));
			transformer.transform(source, result);
		} catch (IOException | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}


	@Override
	public List<Book> readBooks(String uri) {
		List<Book> books = new ArrayList<Book>();
		if (uri.trim().equals(GET_BOOKS)) {
			books = BooksParser.parseToList(URI_BOOKS);
			return books;
			}else return books=null;		
	}	
		
}