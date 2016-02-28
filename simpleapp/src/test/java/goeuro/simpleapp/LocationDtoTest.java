package goeuro.simpleapp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import goeuro.simpleapp.model.GeoPosition;
import goeuro.simpleapp.model.Location;
import goeuro.simpleapp.model.dto.LocationDto;


public class LocationDtoTest {
	@Test
	public void testLocationDtoFieldValues() {
		LocationDto locationDto = new LocationDto(new Location("10", "München Main Station", "station", new GeoPosition("-10", "10")));
		assertThat(locationDto).isEqualToComparingFieldByField(new LocationDto("10", "München Main Station", "station","-10", "10"));
	}
}
