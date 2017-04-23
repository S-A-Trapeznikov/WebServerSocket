package com.epam.trapeznikau.handler.implcommand;



import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import com.epam.trapeznikau.bean.Book;
import com.epam.trapeznikau.handler.Command;
import com.epam.trapeznikau.httpmethod.Request;
import com.epam.trapeznikau.httpmethod.Response;
import com.epam.trapeznikau.service.FactoryLibraryService;
import com.epam.trapeznikau.utility.BooksParser;
import com.epam.trapeznikau.utility.ParserJSON;
import com.epam.trapeznikau.utility.RpOperation;

public class UpdateBook implements Command{

	@Override
	public Response execute(Request rq, Response rp) {
		FactoryLibraryService ls =FactoryLibraryService.getInstance();
		Book book =null;
		if (rq.getContentType().toLowerCase().startsWith("application/json")){
			book= ParserJSON.parseerJSONToBook(rq.getBody());
		}else{try {
			book= BooksParser.parseStrToBook(rq.getBody());
		} catch (ParserConfigurationException | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		boolean status = ls.getLibraryService().update(rq.getUri(),book);
		if (status){
			rp.setStatusCode("200");
			rp.setPhrase("OK");			
		}else{ 
			rp.setStatusCode("400");
			rp.setPhrase("BadRequest");
		}
		rp = RpOperation.fillResponse(rq, rp);
		return rp;
	}
		
}

