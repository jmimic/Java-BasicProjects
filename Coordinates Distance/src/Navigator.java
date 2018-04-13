/**
 * 
 * @Coder: Jacky Shew
 *
 * This class is intended for use in navigation systems. It stores two coordinate
 * points (origin and destination) and computes the distance between them in 
 * kilometres or nautical miles using the Haversine formula.
 * 
 */



public class Navigator {
	
	private CoordinatePoint origin;
	private CoordinatePoint destination;

	/**
	 * This is the default constructor for the Navigator class. It takes no parameters.
	 * Origin and destination are both initialised to 0 degrees longitude and latitude.
	 */
	public Navigator() throws CoordinateOutOfBoundsException {
		origin = new CoordinatePoint();
		destination = new CoordinatePoint();
	}

	/**
	 * Getter for the origin
	 * 
	 * @return the origin CoordinatePoint
	 */
	public CoordinatePoint getOrigin() {
		return origin;
	}

	/**
	 * Getter for the origin longitude
	 * 
	 * @return the longitude of the origin between -180 and +180 degrees
	 */
	public double getOriginLongitude() {
		return origin.getLongitude();
	}

	/**
	 * Getter for the origin latitude
	 * 
	 * @return the latitude of the origin between -90 and +90 degrees
	 */
	public double getOriginLatitude() {
		return origin.getLatitude();
	}

	/**
	 * Setter for the origin
	 * 
	 * @param origin the origin to set
	 */
	public void setOrigin(CoordinatePoint origin) {
		this.origin = origin;
	}
	
	/**
	 * Setter for the origin
	 * 
	 * @param longitude: the origin longitude to set as a double value between -180 (180 deg West) and +180 (180 deg East)
	 * @param latitude: the origin latitude to set as a double value between -90 (90 deg South) and +90 (90 deg North)
	 */
	public void setOrigin(double longitude, double latitude) throws CoordinateOutOfBoundsException {
		this.origin.setLongitude(longitude);
		this.origin.setLatitude(latitude);
	}
	
	/**
	 * Setter for the origin longitude
	 * 
	 * @param longitude: the origin longitude to set as a double value between -180 (180 deg West) and +180 (180 deg East)
	 */
	public void setOriginLongitude(double longitude) throws CoordinateOutOfBoundsException {
		this.origin.setLongitude(longitude);
		
	}
	

	/**
	 * Setter for the origin latitude
	 * 
	 * @param latitude: the origin latitude to set as a double value between -90 (90 deg South) and +90 (90 deg North)
	 */
	public void setOriginLatitude(double latitude) throws CoordinateOutOfBoundsException {
		this.origin.setLatitude(latitude);
	}
	

	/**
	 * Getter for the destination
	 * 
	 * @return the destination CoordinatePoint
	 */
	public CoordinatePoint getDestination() {
		return destination;
	}

	/**
	 * Getter for the destination longitude 
	 * 
	 * @return the longitude of the destination between -180 and +180 degrees
	 */
	public double getDestinationLongitude() {
		return destination.getLongitude();
	}

	/**
	 * Getter for the destination latitude
	 * 
	 * @return the latitude of the destination between -90 and +90 degrees
	 */
	public double getDestinationLatitude() {
		return destination.getLatitude();
	}

	/**
	 * Setter for the destination
	 * 
	 * @param destination the destination to set
	 */
	public void setDestination(CoordinatePoint destination) {
		this.destination = destination;
	}
	
	/**
	 * Setter for the destination
	 * 
	 * @param longitude: the destination longitude to set as a double value between -180 (180 deg West) and +180 (180 deg East)
	 * @param latitude: the destination latitude to set as a double value between -90 (90 deg South) and +90 (90 deg North)
	 */
	public void setDestination(double longitude, double latitude) throws CoordinateOutOfBoundsException {
		this.destination.setLongitude(longitude);
		this.destination.setLatitude(latitude);
	}
	
	/**
	 * Setter for the destination longitude
	 * 
	 * @param longitude: the destination longitude to set as a double value between -180 (180 deg West) and +180 (180 deg East)
	 */
	public void setDestinationLongitude(double longitude) throws CoordinateOutOfBoundsException {
		this.destination.setLongitude(longitude);
	}
	

	/** 
	 * Setter for the destination latitude
	 * 
	 * @param latitude: the destination latitude to set as a double value between -90 (90 deg South) and +90 (90 deg North)
	 */
	public void setDestinationLatitude(double latitude) throws CoordinateOutOfBoundsException {
		this.destination.setLatitude(latitude);
	}
	
	/**
	 * This method returns the distance between origin and destination in km
	 * 
	 * @return a double value of the distance between origin and destination in km
	 */
	public double distanceInKm() {
		double lo1 = Math.PI*origin.getLongitude()/180;
		double lo2 = Math.PI*destination.getLongitude()/180;
		double la1 = Math.PI*origin.getLatitude()/180;
		double la2 = Math.PI*destination.getLatitude()/180;
		double difflo2 = (lo2-lo1)/2;
		double diffla2 = (la2-la1)/2;
				
		return 2*6371 * Math.asin(
				Math.sqrt(
					Math.sin(diffla2) * Math.sin(diffla2)
					+ Math.cos(la1)*Math.cos(la2) 
					* Math.sin(difflo2) * Math.sin(difflo2)
						)
				);
	}
	
	/**
	 * This method returns the distance between origin and destination in nautical
	 * miles (NM)
	 * 
	 * @return a double value of the distance between origin and destination in NM 
	 */
	public double distanceInNM() {
		return distanceInKm()/1.852;
	}
}
