package it.simonelambiase.www.springAcademy.springAcademy.model.data.exception;

public class DataException extends Exception {
	/*
	 * Creiamo una eccezione di nome DataException per mascherare la SQLException
	 * 
	 */
	public DataException(String message, Exception e) {
		super(message,e);
		// TODO Auto-generated constructor stub
	}

	
	
}
