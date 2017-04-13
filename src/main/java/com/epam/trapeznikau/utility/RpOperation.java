package com.epam.trapeznikau.utility;

import com.epam.trapeznikau.httpmethod.Request;
import com.epam.trapeznikau.httpmethod.Response;

public class RpOperation {
	
	private RpOperation(){}

	public static Response fillResponse(Request rq, Response rp) {
		
		rp.setVersion(rq.getVersion());
		if ((rp.getBody()!="")&&(rp.getBody()!=null)){
			rp.setStatusCode("200");
			rp.setPhrase("OK");
		}else {rp.setStatusCode("400");
			   rp.setPhrase("Bad request");
			   }
		rp.setContentEncoding(rq.getAcceptEncoding());
		rp.setContentLanguage(rq.getAcceptLanguage());
		rp.setContentLength(rp.getBody().getBytes().length);
		rp.setContentType(rq.getContentType());
		rp.setServer("//LocalHost:8020");
		
		return rp;
		
		}
	
	public static String response(Response rp){
		StringBuilder response = new StringBuilder();
		response.append(rp.getVersion()+" ");
		response.append(rp.getStatusCode()+" ");
		response.append(rp.getPhrase()+"\r\n");
		response.append("Server: "+ rp.getServer()+"\r\n");
		response.append("Content-Type: "+rp.getContentType()+"\r\n");
		response.append("Content-Language: "+rp.getContentLanguage()+"\r\n");
		response.append("Content-Encoding: "+rp.getContentEncoding()+" ");
		response.append("Content-Length: "+rp.getContentLength()+" ");
		response.append(rp.getBody());		
		
		return response.toString();
	}
	
	
		
		
}
