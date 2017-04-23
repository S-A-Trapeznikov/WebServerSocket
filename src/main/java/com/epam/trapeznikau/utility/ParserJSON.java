package com.epam.trapeznikau.utility;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import org.codehaus.jackson.map.ObjectMapper;

import com.epam.trapeznikau.bean.Book;

public class ParserJSON {
	
	public static String parseListToJSON(List<Book> books){ 
		String body="";
		ObjectMapper mapper = new ObjectMapper();
		try {
			body = mapper.writeValueAsString(books);
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return body;
	}
	
	public static Book parseerJSONToBook(String strBook){
		Book book = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			book = (Book) mapper.readValue(strBook, Book.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return book;
	}

}
