package com.epam.trapeznikau.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.epam.trapeznikau.httpmethod.Request;

public class RqOperation {
	
	private RqOperation(){}
	
	public static Request parseRq(BufferedReader in, Request rq){
		List<String> strRq =new ArrayList<String>();
		try {
			String str = in.readLine();
			while (in.ready()) {
				strRq.add(str);
				str = in.readLine();
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rq = parseListRq(strRq,rq);
				
		return rq;
	}
		
	public static String getString(InputStreamReader in){
		
		String body ="";
		int i;
		try {
			while ((i=in.read())!=-1){
				body += (char) i;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return body;
	}

	private static Request parseListRq(List<String> strRq, Request rq) {
		String str;
		String body = "";		
		String arrStr[];
		int count = 0;
		ListIterator<String> iterator = strRq.listIterator();
		
		while (iterator.hasNext()) {
			str = iterator.next();
			
			if (count == 0) {
				arrStr = str.split(" ");
				rq.setMethod(arrStr[0]);
				rq.setUri(arrStr[1]);
				if (arrStr[2] != null) {
					rq.setVersion(arrStr[2]);
					count = 1;
				}
			} else {
				arrStr = str.split(": ");				
				int l = arrStr.length;
				if (l == 2) {
					switch (arrStr[0].toLowerCase()) {
					case "accept":
						rq.setAccept(getLeftChars(arrStr, 1, l));
						break;
					case "accept-charset":
						rq.setAcceptCharset(getLeftChars(arrStr, 1, l));
						break;
					case "accept-encoding":
						rq.setAcceptEncoding(getLeftChars(arrStr, 1, l));
						break;
					case "content-length":
						rq.setContentLength(Integer.valueOf(getLeftChars(arrStr, 1, l).trim()));
						break;
					case "content-type":
						rq.setContentType(getLeftChars(arrStr, 1, l));
						break;
					case "user-agent":
						rq.setUserAgent(getLeftChars(arrStr, 1, l));
						break;
					case "host":
						rq.setHost(getLeftChars(arrStr, 1, l));
						break;
					case "accept-language":
						rq.setAcceptLanguage(getLeftChars(arrStr, 1, l));
						break;
					}
				} else {
					body += (arrStr[0] + "\n");
				}
			}
			rq.setBody(body);
	}
		return rq;
	}

	private static String getLeftChars(String arrStr[],int curPos,int qtyEl){
		String info = "";
		for (int j=curPos; j<qtyEl; j++){
				info += arrStr[j];
					}
		return info;
	}
	
	
}
