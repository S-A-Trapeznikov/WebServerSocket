package com.epam.trapeznikau.handler.implcommand;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import com.epam.trapeznikau.handler.Command;
import com.epam.trapeznikau.httpmethod.Request;
import com.epam.trapeznikau.httpmethod.Response;
import com.epam.trapeznikau.service.FactoryLibraryService;
import com.epam.trapeznikau.utility.BooksParser;
import com.epam.trapeznikau.utility.ParserJSON;
import com.epam.trapeznikau.utility.RpOperation;

public class ReadBooks implements Command{

	@Override
	public Response execute(Request rq,Response rp) {	
		FactoryLibraryService ls =FactoryLibraryService.getInstance();
		
		try {			
			if (rq.getAccept().equals("application/json")){
			rp.setBody(ParserJSON.parseListToJSON(ls.getLibraryService().read(rq.getUri())));
			}else{
				rp.setBody(BooksParser.parseListToXML(ls.getLibraryService().read(rq.getUri())));
			}
		} catch (ParserConfigurationException | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if ((rp.getBody()!="")&&(rp.getBody()!=null)){
			rp.setStatusCode("200");
			rp.setPhrase("OK");
			rp.setContentLength(rp.getBody().getBytes().length);
		}else{rp.setStatusCode("400");
			  rp.setPhrase("Bad request");			
		}		
		rp = RpOperation.fillResponse(rq, rp);
		return rp;
	}
}
