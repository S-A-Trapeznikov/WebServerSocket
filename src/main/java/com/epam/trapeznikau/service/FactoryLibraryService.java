package com.epam.trapeznikau.service;

public class FactoryLibraryService {
	private static final FactoryLibraryService instance = new FactoryLibraryService();
	
	private final LibraryService libraryService = new LibraryServiceImpl();
	
	private FactoryLibraryService(){};
	
	public static FactoryLibraryService getInstance(){
		return instance;
	}
	
	public LibraryService getLibraryService(){
		return libraryService;
	}
	

}
