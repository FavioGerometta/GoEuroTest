package goeuro.simpleapp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Location{
	
	private String coreCountry;

	private GeoPosition geoPosition;

	private Object distance;

	private String id;

	private boolean inEurope;

	private String name;

	private String countryCode;

	private Object iata_airport_code;

	private String fullName;

	private String type;

	private Object key;

	private String location_id;

	private String country;
	
	public Location(String id, String name, String type, GeoPosition geoPosition){
		this.id = id;
		this.name = name;
		this.type = type;
		this.geoPosition = geoPosition;
	}

	public Location(){}

	public String getCoreCountry() {
		return coreCountry;
	}

	public void setCoreCountry(String coreCountry) {
		this.coreCountry = coreCountry;
	}

	@XmlElement(name="geo_position")
	public GeoPosition getGeoPosition() {
		return geoPosition;
	}

	public void setGeoPosition(GeoPosition geoPosition) {
		this.geoPosition = geoPosition;
	}

	public Object getDistance ()
    {
        return distance;
    }

	public void setDistance (Object distance)
    {
        this.distance = distance;
    }

	@XmlElement(name="_id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean getInEurope() {
		return inEurope;
	}

	public void setInEurope(boolean inEurope) {
		this.inEurope = inEurope;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Object getIata_airport_code ()
    {
        return iata_airport_code;
    }

	public void setIata_airport_code (Object iata_airport_code)
    {
        this.iata_airport_code = iata_airport_code;
    }

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object getKey ()
    {
        return key;
    }

	public void setKey (Object key)
    {
        this.key = key;
    }

	public String getLocation_id() {
		return location_id;
	}

	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Location [coreCountry = " + coreCountry + ", geo_position = " + geoPosition + ", distance = "
				+ distance + ", _id = " + id + ", inEurope = " + inEurope + ", name = " + name + ", countryCode = "
				+ countryCode + ", iata_airport_code = " + iata_airport_code + ", fullName = " + fullName + ", type = "
				+ type + ", key = " + key + ", location_id = " + location_id + ", country = " + country + "]";
	}
}
