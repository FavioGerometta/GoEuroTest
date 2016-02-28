package goeuro.simpleapp.model;

public class GeoPosition {
	
	private String longitude;
	private String latitude;

	public GeoPosition(){}
	
	public GeoPosition(String latitude, String longitude){
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "GeoPosition [longitude = " + longitude + ", latitude = " + latitude + "]";
	}
}
