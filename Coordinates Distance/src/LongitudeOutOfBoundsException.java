
public class LongitudeOutOfBoundsException extends CoordinateOutOfBoundsException {

	public LongitudeOutOfBoundsException(double erroneousLongitude) {
		super("Out of bounds longitude: " + erroneousLongitude);
		
	}

}
