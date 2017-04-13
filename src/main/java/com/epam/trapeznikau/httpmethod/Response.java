package com.epam.trapeznikau.httpmethod;

public class Response {
	
	private String version;
	private String statusCode;
	private String server;	
	private String phrase;
	private String contentEncoding;
	private String contentLanguage;
	private int contentLength;
	private String contentType;
	private String body;
	
	public Response(){};	
	
	@Override
	public String toString() {
		return ""+version+" "+statusCode+" "+phrase+"\r\n"
				+"Server: "+server+"\r\n"
				+"Content-Encoding: " + contentEncoding +"\r\n"
				+"Content-Language: " + contentLanguage+"\r\n"
				+"Content-Length: " + contentLength+"\r\n"
				+"Content-Type: " + contentType +"\r\n"
				+body+"";
	}

	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getPhrase() {
		return phrase;
	}
	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}
	public String getContentEncoding() {
		return contentEncoding;
	}
	public void setContentEncoding(String contentEncoding) {
		this.contentEncoding = contentEncoding;
	}
	public String getContentLanguage() {
		return contentLanguage;
	}
	public void setContentLanguage(String contentLanguage) {
		this.contentLanguage = contentLanguage;
	}
	public int getContentLength() {
		return contentLength;
	}
	public void setContentLength(int contentLength) {
		this.contentLength = contentLength;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}

}
