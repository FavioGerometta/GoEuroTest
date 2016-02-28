package goeuro.simpleapp.common;



public final class CsvWriterException extends Exception {

	private static final long serialVersionUID = 987035195020709438L;

	public CsvWriterException() {

	}

	public CsvWriterException(String message) {
		super(message);
	}

	public CsvWriterException(Throwable cause) {
		super(cause);
	}

	public CsvWriterException(String message, Throwable cause) {
		super(message, cause);
	}
}
