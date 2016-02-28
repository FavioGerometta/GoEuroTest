package goeuro.simpleapp;

import goeuro.simpleapp.common.CsvWriterException;
import goeuro.simpleapp.common.InvalidCityNameException;

public final class App {

	public static void main(String[] args) throws InvalidCityNameException, CsvWriterException {

		if (args.length > 1 || args.length == 0) {
			throw new IllegalArgumentException("Only one argument is allowed to run this program!");
		}
		final GoEuroInterview goEuro = new GoEuroInterview();
		goEuro.writeLocationsToCsv(args[0]);

	}




}
