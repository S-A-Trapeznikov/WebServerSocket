package com.epam.trapeznikau.handler;

import com.epam.trapeznikau.httpmethod.Request;
import com.epam.trapeznikau.httpmethod.Response;

public interface Command {
	
	Response execute(Request rq, Response rp);

}
