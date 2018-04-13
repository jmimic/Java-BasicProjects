
public class LatitudeOutOfBoundsException extends CoordinateOutOfBoundsException {

	public LatitudeOutOfBoundsException(double erroneousLatitude) {
		super("Out of bounds longitude: " + erroneousLatitude);
		
	}

}
