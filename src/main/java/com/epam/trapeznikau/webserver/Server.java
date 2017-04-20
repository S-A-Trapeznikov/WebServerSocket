package com.epam.trapeznikau.webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.epam.trapeznikau.handler.Controller;
import com.epam.trapeznikau.httpmethod.Request;
import com.epam.trapeznikau.httpmethod.Response;
import com.epam.trapeznikau.utility.RpOperation;
import com.epam.trapeznikau.utility.RqOperation;

public class Server {

	Socket socket;
	ServerSocket server;
	int portNumber;
	int clientNumber;
	int curNumberClients;
	
	public Server(){};

	public Server(int portNumber, int clientNumber) throws IOException {

		server = new ServerSocket(portNumber);
		this.portNumber = portNumber;
		this.clientNumber = clientNumber;
		curNumberClients = 0;

	}

	public void start() {
		System.out.println("Listening for connection on port 8020 ....");
	
			while (true) {
				if (clientNumber <= curNumberClients) {
					System.out.println("Server achive max numbers of clients!!! ");
					break;
				} else {
					try {
						socket = server.accept();
						curNumberClients++;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("New client "+curNumberClients+" connect");
					new Thread(new Session()).start();
				}
			}
	}

	class Session implements Runnable {

		public void run() {

			Response rp = new Response();
			Request rq = new Request();
			
			BufferedReader in = null;
			OutputStream out = null;
			
			Controller controller = new Controller();

			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out =socket.getOutputStream();
											
				
				rq = RqOperation.parseRq(in, rq);
				rp = controller.executeRequest(rq, rp);
							
				String response = RpOperation.response(rp);					
				out.write(response.getBytes("UTF-8"));
								
				in.close();
				out.flush();
				out.close();
				socket.close();
				curNumberClients--;
					

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}




