package goeuro.simpleapp;

import java.util.List;

import goeuro.simpleapp.client.LocationController;
import goeuro.simpleapp.common.CsvWriterException;
import goeuro.simpleapp.common.InvalidCityNameException;
import goeuro.simpleapp.model.Location;

public final class GoEuroInterview {
	// this class exists only to detach from main entry point
	public GoEuroInterview(){}
	
	/**
	 * Fetches the locations by city name and writes only the specified content of the results in a Csv file
	 *
	 * @param cityName
	 *            name of the city
	 */
	public void writeLocationsToCsv(String cityName) throws InvalidCityNameException, CsvWriterException {
		final List<Location> locations = LocationController.getInstance().getLocationsByCityName(cityName);
		LocationController.getInstance().writeLocationsToCsv(locations);
	}
}
