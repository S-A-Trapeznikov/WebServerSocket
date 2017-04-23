package com.epam.trapeznikau.utility;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
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

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.epam.trapeznikau.bean.Book;

public class BooksParser {
	
	private BooksParser(){}
	
	public static List<Book> parseToList(String pathFile){
		DOMParser parser = new DOMParser();
		try {
			parser.parse(pathFile);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document document = parser.getDocument();
		Element root = document.getDocumentElement();
		List<Book> books = new ArrayList<>();
		
		NodeList booksNodes = root.getElementsByTagName("book");
		Book book = null;
		for (int i=0;i<booksNodes.getLength();i++){
			book =new Book();
			Element bookElement = (Element) booksNodes.item(i);
			book.setId(Integer.parseInt(bookElement.getAttribute("id")));
			book.setAuthor(getSingleChild(bookElement,"author").getTextContent().trim());
			book.setTitle(getSingleChild(bookElement,"title").getTextContent().trim());
			book.setPrice(getSingleChild(bookElement,"price").getTextContent().trim());
			books.add(book);
		}		
		return books;
	}
	
	public static String parseListToXML(List<Book> books) throws ParserConfigurationException, TransformerException{
		if (books!=null){
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
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
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);		
		StringWriter body = new StringWriter();
		StreamResult result = new StreamResult(body);
		transformer.transform(source, result);		
		return body.toString();
		} else return null;
	}
	
	public static Book parseStrToBook(String strBook) throws ParserConfigurationException, TransformerException{
		if (strBook!=null){
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = null;
			try {
				document = builder.parse(new InputSource(new StringReader(strBook.trim())));				
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Book book = null;
			Element root = document.getDocumentElement();
			NodeList booksNodes = root.getElementsByTagName("book");
			if (booksNodes.getLength()!=0){
			book = new Book();
				Element bookElement = (Element) booksNodes.item(0);
				book.setId(Integer.parseInt(bookElement.getAttribute("id")));
				book.setAuthor(getSingleChild(bookElement,"author").getTextContent().trim());
				book.setTitle(getSingleChild(bookElement,"title").getTextContent().trim());
				book.setPrice(getSingleChild(bookElement,"price").getTextContent().trim());		
			return book;
			} else return book;
		}else return null;
	}
		
	public static Element getSingleChild(Element element, String childName){
		NodeList nl = element.getElementsByTagName(childName);
		Element child = (Element) nl.item(0);
		return child;
	}
	
}
