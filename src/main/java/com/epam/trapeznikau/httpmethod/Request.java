package com.epam.trapeznikau.httpmethod;

public class Request {
	
	
	private String method;
	private String uri;
	private String version;
	private String host;
	private String accept;
	private String acceptCharset;
	private String acceptEncoding;
	private String acceptLanguage;
	private String contentType;
	private int contentLength;
	private String userAgent;
	private String body;
	
	public Request(){};
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getAccept() {
		return accept;
	}
	public void setAccept(String accept) {
		this.accept = accept;
	}
	public String getAcceptCharset() {
		return acceptCharset;
	}
	public void setAcceptCharset(String acceptCharset) {
		this.acceptCharset = acceptCharset;
	}
	public String getAcceptEncoding() {
		return acceptEncoding;
	}
	public void setAcceptEncoding(String acceptEncoding) {
		this.acceptEncoding = acceptEncoding;
	}
	public String getAcceptLanguage() {
		return acceptLanguage;
	}
	public void setAcceptLanguage(String acceptLanguage) {
		this.acceptLanguage = acceptLanguage;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public int getContentLength() {
		return contentLength;
	}
	public void setContentLength(int contentLength) {
		this.contentLength = contentLength;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	@Override
	public String toString() {
		return 	""+method+" "+uri+" "+version+"\n"
				+"Host: "+host+"\n"
				+"Accept: "+accept+"\n"
				+"Accept-Charset: "+acceptCharset+"\n"
				+"Accept-Encoding: "+acceptEncoding+"\n"
				+"Accept-Language: "+acceptLanguage+"\n"
				+"Content-Type: "+contentType+"\n"
				+"Content-Length: "+contentLength+"\n"
				+"User-Agent: "+userAgent+"\n"
				+body+"";
	}

}
