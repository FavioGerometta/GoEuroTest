package goeuro.simpleapp.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;

import goeuro.simpleapp.model.Location;

public interface Service {
	static final Client CLIENT = ClientBuilder.newClient(new ClientConfig().register(LoggingFilter.class));
	public List<Location> getLocationsByCityName(String cityName);
}
