package com.epam.trapeznikau.handler;

import java.io.IOException;
import java.io.InputStream;

import com.epam.trapeznikau.httpmethod.Request;
import com.epam.trapeznikau.httpmethod.Response;
import com.epam.trapeznikau.logic.BookOperation;
import com.epam.trapeznikau.utility.RpOperation;
import com.epam.trapeznikau.utility.RqOperation;

public class HandlerRequest {
	
	private HandlerRequest(){}
	
	public static Response getResponse(Request rq, Response rp){
		
		String method = rq.getMethod();
		String uri = rq.getUri();
		String body = "";
		
		switch (method){
		case "GET": body = RqOperation.getString(BookOperation.read(uri));
					rp.setBody(body);	
					rp = RpOperation.fillResponse(rq,rp);
					break;
		case "POST": break;
		case "PUT": break;
		case "DELETE": break;
		}
		
		return rp;
	}
	
	

}
