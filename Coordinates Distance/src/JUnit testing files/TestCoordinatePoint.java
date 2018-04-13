import static org.junit.Assert.*;

import org.junit.Test;

public class TestCoordinatePoint {

	/**
	 * Tests whether a CoordinatePoint created by default
	 * constructor has the correct coordinates.
	 */
	@Test
	public void testDefault() {
		try {
			CoordinatePoint p = new CoordinatePoint();
			assertEquals(0, p.getLongitude(), 0);
			assertEquals(0, p.getLatitude(), 0);
		} catch (CoordinateOutOfBoundsException e) {
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown by default constructor");
		}
	}
	
	
	/**
	 * Tests whether a LongitudeOutOfBoundsException is thrown
	 * if the longitude goes just out of bounds, with latitude
	 * at the bound.
	 */
	@Test
	public void testOOB1() {
		try {
			CoordinatePoint p = new CoordinatePoint(180.1,90);
			fail("Should trigger a LongitudeOutOfBoundsException");
		} catch (CoordinateOutOfBoundsException e) {
			assertEquals("Out of bounds longitude: 180.1", e.getMessage());
		}
	}

	/**
	 * Tests whether a LatitudeOutOfBoundsException is thrown
	 * if the latitude goes just out of bounds, with longitude
	 * at the bound. 
	 */
	@Test
	public void testOOB2() {
		try {
			CoordinatePoint p = new CoordinatePoint(180,90.1);
			fail("Should trigger a LatitudeOutOfBoundsException");
		} catch (CoordinateOutOfBoundsException e) {
			assertEquals("Out of bounds latitude: 90.1", e.getMessage());
		}
	}

	/**
	 * Tests whether a LongitudeOutOfBoundsException is thrown
	 * if the longitude goes just out of bounds, with latitude
	 * at the bound.
	 */
	@Test
	public void testOOB3() {
		try {
			CoordinatePoint p = new CoordinatePoint(-180.1,90);
			fail("Should trigger a LongitudeOutOfBoundsException");
		} catch (CoordinateOutOfBoundsException e) {
			assertEquals("Out of bounds longitude: -180.1", e.getMessage());
		}
	}

	/**
	 * Tests whether a LatitudeOutOfBoundsException is thrown
	 * if the latitude goes just out of bounds, with longitude
	 * at the bound. 
	 */
	@Test
	public void testOOB4() {
		try {
			CoordinatePoint p = new CoordinatePoint(180,-90.1);
			fail("Should trigger a LatitudeOutOfBoundsException");
		} catch (CoordinateOutOfBoundsException e) {
			assertEquals("Out of bounds latitude: -90.1", e.getMessage());
		}
	}

	/**
	 * Tests whether we can create a CoordinatePoint at maximum
	 * positive latitude and longitude. 
	 */
	@Test
	public void testOOB5() {
		try {
			CoordinatePoint p = new CoordinatePoint(180,90);
			assertEquals(180, p.getLongitude(), 0);
			assertEquals(90, p.getLatitude(), 0);
		} catch (CoordinateOutOfBoundsException e) {
			fail("Creating coordinate point to (180,90) resulted in CoordinateOutOfBoundsException");
		}
	}

	/**
	 * Tests whether we can create a CoordinatePoint at maximum
	 * negative latitude and longitude. 
	 */
	@Test
	public void testOOB6() {
		try {
			CoordinatePoint p = new CoordinatePoint(-180,-90);
			assertEquals(-180, p.getLongitude(), 0);
			assertEquals(-90, p.getLatitude(), 0);
		} catch (CoordinateOutOfBoundsException e) {
			fail("Creating coordinate point to (-180,-90) resulted in CoordinateOutOfBoundsException");
		}
	}
	
	/**
	 * Tests whether getLongitude and getLatitude 
	 * are getting the correct values and not set to max bound by default
	 * constructor has the correct coordinates.
	 */
	@Test
	public void testgetLongitude1_testgetLatitude1() {
		try {
			CoordinatePoint p = new CoordinatePoint(25,65);
			assertEquals(25, p.getLongitude(), 0);
			assertEquals(65, p.getLatitude(), 0);
		} catch (CoordinateOutOfBoundsException e) {
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown by default constructor");
		}
	}
	
	/**
	 * Tests whether setLongitude sets values
	 * as given when invoking its method by setting value to 75
	 */
	@Test
	public void testsetLongitude1() {
		try {
			CoordinatePoint p = new CoordinatePoint();
			p.setLongitude(75);
			assertEquals(75, p.getLongitude(), 0);
		}catch (LongitudeOutOfBoundsException e) {
			fail("Setting longitude to 75 resulted in LongitudeOutOfBoundsException");
		}catch (CoordinateOutOfBoundsException e) {
			fail("Setting longitude to 75 resulted in CoorindateOutOfBoundsException");
		}
	}
	
	/**
	 * Tests whether a LongitudeOutOfBoundsException is thrown
	 * if the longitude just goes over max +ve bounds, 180.1
	 * whilst latitude is at max bound, 90
	 */
	@Test
	public void testsetLongitude2() {
		try {
			CoordinatePoint p = new CoordinatePoint(0,90);
			p.setLongitude(180.1);
			fail("Should trigger a LongitudeOutOfBoundsException");
		} catch (LongitudeOutOfBoundsException e) {
			assertEquals("Out of bounds longitude: 180.1", e.getMessage());
		} catch (CoordinateOutOfBoundsException e) {
			fail("Setting longitude to 180.1 resulted in CoorindateOutOfBoundsException");
		}
	}
	
	/**
	 * Tests whether a LongitudeOutOfBoundsException is thrown
	 * if the longitude just goes over max -ve bounds, -180.1
	 * whilst latitude is at max bound, 90
	 */
	@Test
	public void testsetLongitude3() {
		try {
			CoordinatePoint p = new CoordinatePoint(0,90);
			p.setLongitude(-180.1);
			fail("Should trigger a LongitudeOutOfBoundsException");
		} catch (LongitudeOutOfBoundsException e) {
			assertEquals("Out of bounds longitude: -180.1", e.getMessage());
		} catch (CoordinateOutOfBoundsException e) {
			fail("Setting longitude to -180.1 resulted in CoorindateOutOfBoundsException");
		}
	}
	
	/**
	 * Tests whether a LongitudeOutOfBoundsException is thrown
	 * if the exception message given is of correct syntax
	 */
	@Test
	public void testsetLongitude4() {
		try {
			CoordinatePoint p = new CoordinatePoint(0,0);
			p.setLongitude(999);
			fail("Should trigger a LongitudeOutOfBoundsException");
		} catch (LongitudeOutOfBoundsException e) {
			assertEquals("Out of bounds longitude: 999.0", e.getMessage());
		} catch (CoordinateOutOfBoundsException e) {
			fail("Setting longitude to 999.0 resulted in CoorindateOutOfBoundsException");
		}
	}
	
	/**
	 * Tests whether setLongitude sets values
	 * as given when invoking its method by setting value to 75
	 */
	@Test
	public void testsetLatitude1() {
		try {
			CoordinatePoint p = new CoordinatePoint();
			p.setLatitude(75);
			assertEquals(75, p.getLatitude(), 0);
		}catch (LatitudeOutOfBoundsException e) {
			fail("Setting latitude to 75 resulted in LatitudeOutOfBoundsException");
		}catch (CoordinateOutOfBoundsException e) {
			fail("Setting latitude to 75 resulted in CoorindateOutOfBoundsException");
		}
	}
	
	/**
	 * Tests whether a LatitudeOutOfBoundsException is thrown
	 * if the latitude just goes over max +ve bounds, 90.1
	 * whilst longitude is at max bound, 180
	 */
	@Test
	public void testsetLatitude2() {
		try {
			CoordinatePoint p = new CoordinatePoint(180,0);
			p.setLatitude(90.1);
			fail("Should trigger a LatitudeOutOfBoundsException");
		} catch (LatitudeOutOfBoundsException e) {
			assertEquals("Out of bounds latitude: 90.1", e.getMessage());
		} catch (CoordinateOutOfBoundsException e) {
			fail("Setting latitude to 90.1 resulted in CoorindateOutOfBoundsException");
		}
	}
	
	/**
	 * Tests whether a LatitudeOutOfBoundsException is thrown
	 * if the latitude just goes over max -ve bounds, -90.1
	 * whilst longitude is at max bound, 180
	 */
	@Test
	public void testsetLatitude3() {
		try {
			CoordinatePoint p = new CoordinatePoint(180,0);
			p.setLatitude(-90.1);
			fail("Should trigger a LatitudeOutOfBoundsException");
		} catch (LatitudeOutOfBoundsException e) {
			assertEquals("Out of bounds latitude: -90.1", e.getMessage());
		} catch (CoordinateOutOfBoundsException e) {
			fail("Setting latitude to -90.1 resulted in CoorindateOutOfBoundsException");
		}
	}
	
	/**
	 * Tests whether a LatitudeOutOfBoundsException is thrown
	 * if the exception message given is of correct syntax
	 */
	@Test
	public void testsetLatitude4() {
		try {
			CoordinatePoint p = new CoordinatePoint(0,0);
			p.setLatitude(999);
			fail("Should trigger a LatitudeOutOfBoundsException");
		} catch (LatitudeOutOfBoundsException e) {
			assertEquals("Out of bounds latitude: 999.0", e.getMessage());
		} catch (CoordinateOutOfBoundsException e) {
			fail("Setting latitude to 999.0 resulted in CoorindateOutOfBoundsException");
		}
	}
}
