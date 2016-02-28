package goeuro.simpleapp.util;

import goeuro.simpleapp.common.InvalidCityNameException;


public final class ValidationUtils {

	/**
	 * Validates the cityName
	 *
	 * @param cityName
	 *            the name of the city
	 * 
	 */
	public static void validateCityName(String cityName) throws InvalidCityNameException {
		if(cityName==null || cityName.isEmpty()){
			throw new InvalidCityNameException();
		}
		
	}
	
}
