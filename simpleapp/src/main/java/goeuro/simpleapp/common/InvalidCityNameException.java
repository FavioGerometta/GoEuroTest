package goeuro.simpleapp.common;

public final class InvalidCityNameException extends Exception {

	private static final long serialVersionUID = 7309094991826444645L;
	public static final String ERR_MSG = "City name is invalid!";
	
	public InvalidCityNameException() {
		super(ERR_MSG);
	}

	public InvalidCityNameException(String message) {
		super(ERR_MSG);
	}

	public InvalidCityNameException(Throwable cause) {
		super(cause);
	}

	public InvalidCityNameException(String message, Throwable cause) {
		super(ERR_MSG, cause);
	}
}
