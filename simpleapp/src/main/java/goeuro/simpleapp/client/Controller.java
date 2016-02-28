package goeuro.simpleapp.client;

import java.util.List;

import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

import goeuro.simpleapp.common.InvalidCityNameException;
import goeuro.simpleapp.model.Location;

public interface Controller {

	public static String URI = "http://api.goeuro.com/api/v2/position/suggest/en/";
	public static String OUTPUT = "output.csv";
	public static final String[] HEADERS = { "id", "name", "type", "latitude", "longitude" };
	public static CellProcessor[] PROCESSORS = new CellProcessor[] { 
			new NotNull(), // id
			new NotNull(), // name
			new NotNull(), // type
			new NotNull(), // lat TODO: would be better if the library supported unsigned parsing here though
			new NotNull() // long
	};
	public List<Location> getLocationsByCityName(String cityName) throws InvalidCityNameException;
}
