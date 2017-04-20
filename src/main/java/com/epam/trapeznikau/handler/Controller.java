package com.epam.trapeznikau.handler;

import com.epam.trapeznikau.httpmethod.Request;
import com.epam.trapeznikau.httpmethod.Response;

public class Controller {
	
	private final Handler handler = new Handler();
	
	public Response executeRequest(Request rq,Response rp){
		Command command = handler.getHandler(rq);
		rp = command.execute(rq,rp);
		return rp;
		
	}

}
