package com.epam.trapeznikau.logic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.epam.trapeznikau.bean.Book;
import com.epam.trapeznikau.httpmethod.Request;

public class BookOperation{
	
	private BookOperation(){}
	
	public final static String URI_BOOKS = "D:\\Siarhei_Trapeznikau\\Java Automation\\Web service\\Tasks\\Tasks 01 BookWebService\\Data\\book\\Books.xml";
	public final static String GET_BOOKS = "/book";
	public final static String GET_ALL = "/";

	public static String create(Request rq) {
		FileOutputStream output = null;
		String statusCode = "400";
		if (rq.getUri().equals(GET_BOOKS)) {

			try {
				output = new FileOutputStream(URI_BOOKS);
				output.write(rq.getBody().getBytes());
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			statusCode = "200";
			return statusCode;
		}
		return statusCode;
	}

	public static InputStreamReader read(String uri)  {
		InputStreamReader input = null;
		if (uri.trim().equals(GET_BOOKS)) {
			try {
				input = new InputStreamReader(new FileInputStream(URI_BOOKS));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
			}
		}
		return input;
	}

	public static String update(Request rq) {
		FileOutputStream output = null;
		String statusCode = "400";
		if (rq.getUri().equals("/book")) {

			try {
				output = new FileOutputStream(URI_BOOKS);
				output.write(rq.getBody().getBytes());
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			statusCode = "200";
			return statusCode;
		}
		return statusCode;
	}

	public static boolean delete(Request rq) {
		
		return false;
	}
	
	

}
