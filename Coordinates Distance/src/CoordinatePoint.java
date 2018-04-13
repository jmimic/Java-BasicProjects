
public class CoordinatePoint {

	private double latitude;
	private double longitude;
	
	/**
	 * This constructor sets the coordinates of the points.
	 * 
	 * @param longitude: the longitude as a double value between -180 (180 deg West) and +180 (180 deg East)
	 * @param latitude: the latitude as a double value between -90 (90 deg South) and +90 (90 deg North)
	 * 
	 */
	public CoordinatePoint(double longitude, double latitude) throws CoordinateOutOfBoundsException {
		setLatitude(latitude);
		setLongitude(longitude);
	}
	
	/**
	 * This convenience constructor sets the coordinates of the points to 0 (Greenwich meridian and equator).
	 * 
	 */
	public CoordinatePoint() throws CoordinateOutOfBoundsException {
		setLatitude(0);
		setLongitude(0);		
	}
	
	/**
	 * Getter for the latitude
	 * 
	 * @return the latitude as a double value between -90 (90 deg South) and +90 (90 deg North)
	 */
	public double getLatitude() {
		return latitude;
	}
	
	/**
	 * Setter for the latitude
	 * 
	 * @param latitude: the latitude as a double value between -90 (90 deg South) and +90 (90 deg North) 
	 * @throws LatitudeOutOfBoundsException
	 */
	public void setLatitude(double latitude) throws LatitudeOutOfBoundsException {
		if (Math.abs(latitude)<=180) {
    		this.latitude = latitude;
		}
		else 
		{
			throw new LatitudeOutOfBoundsException(latitude);
		}	
	}
	
	/**
	 * Getter for the longitude
	 * 
	 * @return the longitude as a double value between -180 (180 deg West) and +180 (180 deg East)
	 */
	public double getLongitude() {
		return longitude;
	}
	
	/**
	 * Setter for the longitude
	 * 
	 * @param longitude: the longitude as a double value between -180 (180 deg West) and +180 (180 deg East)
	 * @throws LongitudeOutOfBoundsException
	 */
	public void setLongitude(double longitude) throws LongitudeOutOfBoundsException {
		if (Math.abs(longitude)<=180) {
			this.longitude = longitude;
		}
		else
			throw new LongitudeOutOfBoundsException(longitude);
	}

	
}
