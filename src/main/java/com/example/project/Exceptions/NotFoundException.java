package com.example.project.Exceptions;



public class NotFoundException extends RuntimeException  {

	
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public NotFoundException(int id, String className) {
		super(className+ " with id: "+ id + " Not Found !");
	}

	
	
	
}
