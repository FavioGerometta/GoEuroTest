package goeuro.simpleapp.client;

import java.util.ArrayList;
import java.util.List;

import goeuro.simpleapp.common.CsvWriterException;
import goeuro.simpleapp.common.InvalidCityNameException;
import goeuro.simpleapp.model.Location;
import goeuro.simpleapp.model.dto.LocationDto;
import goeuro.simpleapp.util.CsvHelper;
import goeuro.simpleapp.util.ValidationUtils;

public final class LocationController implements Controller {

	/**
	 * Fetches the locations by city name and writes only the specified content
	 * of the results in a Csv file
	 *
	 * @param cityName
	 *            name of the city
	 * 
	 * @return the list of the locations being fetched
	 */
	public List<Location> getLocationsByCityName(String cityName) throws InvalidCityNameException {
		ValidationUtils.validateCityName(cityName);
		return LocationService.getInstance().getLocationsByCityName(cityName);
	}

	private static LocationController locationController = null;

	public static LocationController getInstance() {
		if (locationController == null) {
			locationController = new LocationController();
		}
		return locationController;
	}

	private LocationController() {
	}

	/**
	 * Writes only the specified content of the results in a Csv file
	 *
	 * @param locations
	 *            the locations to write in the csv file
	 * 
	 */
	public void writeLocationsToCsv(List<Location> locations) throws CsvWriterException {
		List<LocationDto> locationsDto = new ArrayList<>();
		locations.forEach(location -> locationsDto.add(new LocationDto(location)));
		CsvHelper.writeListToCSVFile(OUTPUT, locationsDto, HEADERS, PROCESSORS);

	}

}
