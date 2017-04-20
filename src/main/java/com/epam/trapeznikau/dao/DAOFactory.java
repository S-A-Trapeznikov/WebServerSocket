package com.epam.trapeznikau.dao;

public class DAOFactory {
	
	private static final DAOFactory instance = new DAOFactory();
	
	private final BookDAO xmlBookImpl = new XMLBookDAO();
	
	private DAOFactory(){};
	
	public static DAOFactory getInstance(){
		return instance;
	}
	
	public BookDAO getBookDAO(){
		return xmlBookImpl;
	}

}
