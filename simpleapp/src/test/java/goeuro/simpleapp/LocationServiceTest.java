package goeuro.simpleapp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.ws.rs.InternalServerErrorException;

import org.junit.Test;

import goeuro.simpleapp.client.LocationService;
import goeuro.simpleapp.common.ThrowableCaptor;
import goeuro.simpleapp.model.Location;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public final class LocationServiceTest extends TestCase {

	public LocationServiceTest(String testName) {
		super(testName);
	}

	public static TestSuite suite() {
		return new TestSuite(LocationServiceTest.class);
	}

	@Test
	public void testLocationsServiceCallHappyPath() {
		final List<Location> locationsByCityName = LocationService.getInstance().getLocationsByCityName("London");
		assertThat(locationsByCityName).
		isNotNull().
		hasAtLeastOneElementOfType(Location.class);
	}
	
	@Test
	public void testLocationsServiceCallWithNoResults() {
		final List<Location> locationsByCityName = LocationService.getInstance().getLocationsByCityName("London2");
		assertThat(locationsByCityName).
		isNotNull().
		isEmpty();
	}
	
	@Test
	public void testLocationsServiceCallWithAdmittedSpecialChars() {
		final List<Location> locationsByCityName = LocationService.getInstance().getLocationsByCityName("//%20/London/");
		assertThat(locationsByCityName).
		isNotNull().
		hasAtLeastOneElementOfType(Location.class);
	}
	
	@Test
	public void testLocationsServiceCallWithNonAdmittedSpecialChars() {
		final Throwable throwable = ThrowableCaptor.captureThrowable(() ->LocationService.getInstance().getLocationsByCityName("*/London"));
		assertThat(throwable).isNotNull().isInstanceOf(InternalServerErrorException.class);
	}
}
