package com.epam.trapeznikau.handler.implcommand;

import com.epam.trapeznikau.handler.Command;
import com.epam.trapeznikau.httpmethod.Request;
import com.epam.trapeznikau.httpmethod.Response;
import com.epam.trapeznikau.service.FactoryLibraryService;
import com.epam.trapeznikau.utility.RpOperation;

public class DeleteBook implements Command{

	@Override
	public Response execute(Request rq,Response rp) {
		FactoryLibraryService ls =FactoryLibraryService.getInstance();
		boolean status = ls.getLibraryService().delete(rq.getUri(),rq.getBody());
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
