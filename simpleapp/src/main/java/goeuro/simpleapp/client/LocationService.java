package goeuro.simpleapp.client;

import java.util.List;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import goeuro.simpleapp.model.Location;

public final class LocationService implements Service {

	/**
	 * Fetches the locations by city name
	 *
	 * @param cityName
	 *            name of the city
	 * 
	 * @return the list of the locations being fetched
	 */
	public List<Location> getLocationsByCityName(String cityName) {

		final WebTarget webTarget = CLIENT.target(Controller.URI).path(cityName);
		final Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		return invocationBuilder.get(new GenericType<List<Location>>() {
		});
	}

	private static LocationService locationService = null;


	public static LocationService getInstance() {
		if (locationService == null) {
			locationService = new LocationService();
		}
		return locationService;
	}
	
	private LocationService() {}

}
