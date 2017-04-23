package com.epam.trapeznikau.handler;

import java.util.HashMap;
import java.util.Map;

import com.epam.trapeznikau.handler.implcommand.AddBook;
import com.epam.trapeznikau.handler.implcommand.DeleteBook;
import com.epam.trapeznikau.handler.implcommand.ReadBooks;
import com.epam.trapeznikau.handler.implcommand.UpdateBook;
import com.epam.trapeznikau.httpmethod.Request;
import com.epam.trapeznikau.methodname.Method;

public class Handler {
	private final Map<Method, Command> listCommand = new HashMap<>();
	
	public Handler (){
		listCommand.put(Method.GET, new ReadBooks());
		listCommand.put(Method.POST, new UpdateBook());
		listCommand.put(Method.PUT, new AddBook());
		listCommand.put(Method.DELETE, new DeleteBook());
	}
			
	public Command getHandler(Request rq){
		Command command;		
		command = listCommand.get(Method.valueOf(rq.getMethod().toUpperCase()));
		return command;
		
		
	} 
	
	

}
