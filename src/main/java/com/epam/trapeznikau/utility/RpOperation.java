 package com.epam.trapeznikau.utility;

import com.epam.trapeznikau.httpmethod.Request;
import com.epam.trapeznikau.httpmethod.Response;

public class RpOperation {
	
	private RpOperation(){}

	public static Response fillResponse(Request rq, Response rp) {
		
		rp.setVersion(rq.getVersion());
	    rp.setContentEncoding(rq.getAcceptEncoding());
		rp.setContentLanguage(rq.getAcceptLanguage());
		rp.setContentType(rq.getAccept());
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
		response.append("Content-Length: "+rp.getContentLength()+"\r\n");
		response.append("Content-Encoding: UTF-8 \r\n");		
		response.append("\r\n");	
		response.append(rp.getBody());		
		
		return response.toString();
	}
	
	
		
		
}
