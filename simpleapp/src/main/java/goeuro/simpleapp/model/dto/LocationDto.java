package goeuro.simpleapp.model.dto;

import goeuro.simpleapp.model.Location;

public class LocationDto {

	private String longitude;
	private String latitude;
	private String id;
	private String name;
	private String type;

	public LocationDto(Location location) {
		this.id = location.getId();
		this.name = location.getName();
		this.type = location.getType();
		this.latitude = location.getGeoPosition().getLatitude();
		this.longitude = location.getGeoPosition().getLongitude();
	}

	public LocationDto(String id, String name, String type, String latitude, String longitude) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	// Empty constructor needed to read CSV file
	public LocationDto() {
	}

	public String getLongitude() {
		return longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	// Setters needed to read CSV file

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "LocationDto [id = " + id + ", name =" + name + ", type=" + type + ", longitude = " + longitude
				+ ", latitude = " + latitude + "]";
	}
}
