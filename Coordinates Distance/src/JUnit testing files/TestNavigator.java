import static org.junit.Assert.*;

import org.junit.Test;

public class TestNavigator {
	
	/**
	 * Tests whether getOrigin retrieve the values stored in Origin correctly
	 * when initialisation of new Navigator object, also tests Navigator initialisation
	 */
	@Test
	public void testgetOrigin1() {
		try{
			Navigator n = new Navigator();
			n.setOrigin(180, 90);
			assertEquals("180,90", n.getOrigin(), 0);
		}
		catch(CoordinateOutOfBoundsException e){
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown by getOrigin");
		}
	}
	
	/**
	 * Tests whether getOriginLongitude retrieve the values stored in Origin correctly
	 * when initialisation of new Navigator object
	 */
	@Test
	public void testgetOriginLongitude1() {
		try{
			Navigator n = new Navigator();
			assertEquals(0, n.getOriginLongitude(), 0);
		}
		catch(CoordinateOutOfBoundsException e){
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown by getOriginLongitude");
		}
	}
	
	/**
	 * Tests whether getOriginLatitude
	 * retrieve the values stored in Origin correctly
	 * when initialisation of new Navigator object
	 * Also tests Navigator initialisation
	 */
	@Test
	public void testgetOriginLatitude1() {
		try{
			Navigator n = new Navigator();
			assertEquals(0, n.getOriginLatitude(), 0);
		}
		catch(CoordinateOutOfBoundsException e){
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown by getOriginLatitude");
		}
	}
	
	/**
	 * Tests whether setOrigin correctly sets values
	 * if the origin is at max +ve bounds
	 */
	@Test
	public void testsetOrigin1() {
		try{
			CoordinatePoint p = new CoordinatePoint(180,90);
			Navigator n = new Navigator();
			n.setOrigin(p);
			assertEquals(180, n.getOriginLongitude(), 0);
			assertEquals(90, n.getOriginLatitude(), 0);
		}
		catch(CoordinateOutOfBoundsException e){
			fail("Setting origin to 180,90 resulted in CoorindateOutOfBoundsException");
		}
	}
	
	/**
	 * Tests whether setOrigin correctly sets values
	 * if the origin is at max -ve bounds
	 */
	@Test
	public void testsetOrigin2() {
		try{
			CoordinatePoint p = new CoordinatePoint(-180,-90);
			Navigator n = new Navigator();
			n.setOrigin(p);
			assertEquals(-180, n.getOriginLongitude(), 0);
			assertEquals(-90, n.getOriginLatitude(), 0);
		}
		catch(CoordinateOutOfBoundsException e){
			fail("Setting origin to -180,-90 resulted in CoorindateOutOfBoundsException");
		}
	}
	
	/**
	 * Tests whether setOrigin correctly sets values
	 * if the origin is at max +ve bounds
	 */
	@Test
	public void testsetOrigin3() {
		try{
			Navigator n = new Navigator();
			n.setOrigin(180,90);
			assertEquals(180, n.getOriginLongitude(), 0);
			assertEquals(90, n.getOriginLatitude(), 0);
		}
		catch(CoordinateOutOfBoundsException e){
			fail("Setting origin to 180,90 resulted in CoorindateOutOfBoundsException");
		}
	}
	
	/**
	 * Tests whether setOrigin correctly sets values
	 * if the origin is at max -ve bounds
	 */
	@Test
	public void testsetOrigin4() {
		try{
			Navigator n = new Navigator();
			n.setOrigin(-180,-90);
			assertEquals(-180, n.getOriginLongitude(), 0);
			assertEquals(-90, n.getOriginLatitude(), 0);
		}
		catch(CoordinateOutOfBoundsException e){
			fail("Setting origin to -180,-90 resulted in CoorindateOutOfBoundsException");
		}
	}
	
	/**
	 * Tests whether setOrigin throws CoordinateOutOfBoundsException
	 * if the origin is just +ve out of bounds for its longitude 
	 * while latitude is at bound, 180.1,90
	 */
	@Test
	public void testsetOrigin5() {
		try{
			Navigator n = new Navigator();
			n.setOrigin(180.1,90);
			assertEquals(180.1, n.getOriginLongitude(), 0);
			assertEquals(90, n.getOriginLatitude(), 0);
			fail("Should trigger a CoordinateOutOfBoundsException");
		}
		catch(CoordinateOutOfBoundsException e){
			assertEquals("Out of bounds longitude: 180.1", e.getMessage());
		}
	}
	
	/**
	 * Tests whether setOrigin throws CoordinateOutOfBoundsException
	 * if the origin is just -ve out of bounds for its longitude
	 * while latitude is at bound, -180.1,90
	 */
	@Test
	public void testsetOrigin6() {
		try{
			Navigator n = new Navigator();
			n.setOrigin(-180.1,90);
			assertEquals(-180.1, n.getOriginLongitude(), 0);
			assertEquals(90, n.getOriginLatitude(), 0);
			fail("Should trigger a CoordinateOutOfBoundsException");
		}
		catch(CoordinateOutOfBoundsException e){
			assertEquals("Out of bounds longitude: -180.1", e.getMessage());
		}
	}
	
	/**
	 * Tests whether setOrigin throws CoordinateOutOfBoundsException
	 * if the origin is just +ve out of bounds for its latitude
	 * while longitude at bound, 180,90.1
	 */
	@Test
	public void testsetOrigin7() {
		try{
			Navigator n = new Navigator();
			n.setOrigin(180,90.1);
			assertEquals(180, n.getOriginLongitude(), 0);
			assertEquals(90.1, n.getOriginLatitude(), 0);
			fail("Should trigger a CoordinateOutOfBoundsException");
		}
		catch(CoordinateOutOfBoundsException e){
			assertEquals("Out of bounds latitude: 90.1", e.getMessage());
		}
	}
	
	/**
	 * Tests whether setOrigin throws CoordinateOutOfBoundsException
	 * if the origin is just +ve out of bounds for its latitude
	 * while longitude at bound, 180,-90.1
	 */
	@Test
	public void testsetOrigin8() {
		try{
			Navigator n = new Navigator();
			n.setOrigin(180,-90.1);
			assertEquals(180, n.getOriginLongitude(), 0);
			assertEquals(-90.1, n.getOriginLatitude(), 0);
			fail("Should trigger a CoordinateOutOfBoundsException");
		}
		catch(CoordinateOutOfBoundsException e){
			assertEquals("Out of bounds latitude: -90.1", e.getMessage());
		}
	}
	
	/**
	 * Tests whether setOrigin throws CoordinateOutOfBoundsException
	 * if the exception message given is of correct syntax
	 * when setOrigin longitude coordinate is set to 999
	 * while setOrigin latitude coordinate is set to 0
	 */
	@Test
	public void testsetOrigin9() {
		try{
			Navigator n = new Navigator();
			n.setOrigin(999,0);
			fail("Should throw CooridinateOutOfBoundsException");
		}
		catch(CoordinateOutOfBoundsException e){
			assertEquals("Out of bounds longitude: 999.0", e.getMessage());
		}
	}
	
	/**
	 * Tests whether setOrigin throws CoordinateOutOfBoundsException
	 * if the exception message given is of correct syntax
	 * when setOrigin longitude coordinate is set to 0
	 * while setOrigin latitude coordinate is set to 999
	 */
	@Test
	public void testsetOrigin10() {
		try{
			Navigator n = new Navigator();
			n.setOrigin(0,999);
			fail("Should throw CooridinateOutOfBoundsException");
		}
		catch(CoordinateOutOfBoundsException e){
			assertEquals("Out of bounds latitude: 999.0", e.getMessage());
		}
	}
	
	/**
	 * Tests whether setOriginLongitude correctly sets values
	 * when longitude is set to max +ve bound, 180
	 */
	@Test
	public void testsetOriginLongitude1() {
		try{
			Navigator n = new Navigator();
			n.setOriginLongitude(180);
			assertEquals(180, n.getOriginLongitude(), 0);
		}
		catch(CoordinateOutOfBoundsException e){
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown by setLongitude");
		}
	}
	
	/**
	 * Tests whether setOriginLongitude throws CoordinateOutOfBoundsException
	 * when setting longitude just over +ve max bound, 180.1 degrees
	 */
	@Test
	public void testsetOriginLongitude2() {
		try{
			Navigator n = new Navigator();
			n.setOriginLongitude(180.1);
			fail("Should throw CooridinateOutOfBoundsException");
		}
		catch(CoordinateOutOfBoundsException e){
			assertEquals("Out of bounds longitude: 180.1", e.getMessage());
		}
	}
	
	/**
	 * Tests whether setOriginLongitude correctly sets values
	 * when setting longitude at -ve, -180 degrees
	 */
	@Test
	public void testsetOriginLongitude3() {
		try{
			Navigator n = new Navigator();
			n.setOriginLongitude(-180);
			assertEquals(-180,n.getOriginLongitude(),0);
		}
		catch(CoordinateOutOfBoundsException e){
			fail("Setting longitude to -180 resulted in CoorindateOutOfBoundsException");
		}
	}
	
	/**
	 * Tests whether setOriginLongitude throws CoordinateOutOfBoundsException
	 * when setting longitude just over -ve max bound, -180.1 degrees
	 */
	@Test
	public void testsetOriginLongitude4() {
		try{
			Navigator n = new Navigator();
			n.setOriginLongitude(-180.1);
			fail("Should throw CooridinateOutOfBoundsException");
		}
		catch(CoordinateOutOfBoundsException e){
			assertEquals("Out of bounds longitude: -180.1", e.getMessage());
		}
	}
	
	/**
	 * Tests whether setOriginLongitude throws CoordinateOutOfBoundsException
	 * if the exception message given is of correct syntax
	 */
	@Test
	public void testsetOriginLongitude5() {
		try{
			Navigator n = new Navigator();
			n.setOriginLongitude(999);
			fail("Should throw CooridinateOutOfBoundsException");
		}
		catch(CoordinateOutOfBoundsException e){
			assertEquals("Out of bounds longitude: 999.0", e.getMessage());
		}
	}
	
	/**
	 * Tests whether setOriginLatitude correctly sets values
	 * when setting latitude to max +ve bound, 90
	 */
	@Test
	public void testsetOriginLatitude1() {
		try{
			Navigator n = new Navigator();
			n.setOriginLatitude(90);
			assertEquals(90, n.getOriginLatitude(), 0);
		}
		catch(CoordinateOutOfBoundsException e){
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown by setLatitude");
		}
	}
	
	/**
	 * Tests whether setOriginLatitude throws CoordinateOutOfBoundsException
	 * when setting latitude just over +ve max bound, 90.1 degrees
	 */
	@Test
	public void testsetOriginLatitude2() {
		try{
			Navigator n = new Navigator();
			n.setOriginLatitude(90.1);
			fail("Should throw CooridinateOutOfBoundsException");
		}
		catch(CoordinateOutOfBoundsException e){
			assertEquals("Out of bounds latitude: 90.1", e.getMessage());
		}
	}
	
	/**
	 * Tests whether setOriginLatitude correctly sets values
	 * when setting latitude at -ve, -90 degrees
	 */
	@Test
	public void testsetOriginLatitude3() {
		try{
			Navigator n = new Navigator();
			n.setOriginLatitude(-90);
			assertEquals(-90,n.getOriginLatitude(),0);
		}
		catch(CoordinateOutOfBoundsException e){
			fail("Setting latitude to -90 resulted in CoorindateOutOfBoundsException");
		}
	}
	
	/**
	 * Tests whether setOriginLatitude throws CoordinateOutOfBoundsException
	 * when setting latitude just over -ve max bound, -90.1 degrees
	 */
	@Test
	public void testsetOriginLatitude4() {
		try{
			Navigator n = new Navigator();
			n.setOriginLatitude(-90.1);
			fail("Should throw CooridinateOutOfBoundsException");
		}
		catch(CoordinateOutOfBoundsException e){
			assertEquals("Out of bounds latitude: -90.1", e.getMessage());
		}
	}
	
	/**
	 * Tests whether setOriginLatitude throws CoordinateOutOfBoundsException
	 * if the exception message given is of correct syntax
	 */
	@Test
	public void testsetOriginLatitude5() {
		try{
			Navigator n = new Navigator();
			n.setOriginLatitude(999);
			fail("Should throw CooridinateOutOfBoundsException");
		}
		catch(CoordinateOutOfBoundsException e){
			assertEquals("Out of bounds latitude: 999.0", e.getMessage());
		}
	}
	
	/**
	 * Tests whether getDestination retrieve the values stored in Destination correctly
	 * when initialisation of new Navigator object
	 */
	@Test
	public void testgetDestination1() {
		try{
			Navigator n = new Navigator();
			n.setDestination(180, 90);
			assertEquals("180,90", n.getDestination(), 0);
		}
		catch(CoordinateOutOfBoundsException e){
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown by getDestination");
		}
	}
	
	/**
	 * Tests whether getDestinationLongitude & getDestinationLatitude
	 * are able to retrieve values stored in destination correctly
	 * when initialisation of new Navigator object
	 */
	@Test
	public void testgetDestinationLongitude1() {
		try{
			Navigator n = new Navigator();
			assertEquals(0, n.getDestinationLongitude(), 0);
			assertEquals(0, n.getDestinationLatitude(), 0);
		}
		catch(CoordinateOutOfBoundsException e){
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown by getDestination");
		}
	}
	
	/**
	 * Tests whether getDestinationLongitude & getDestinationLatitude
	 * are able to retrieve values stored in destination correctly
	 * when initialisation of new Navigator object
	 */
	@Test
	public void testgetDestinationLatitude1() {
		try{
			Navigator n = new Navigator();
			assertEquals(0, n.getDestinationLatitude(), 0);
		}
		catch(CoordinateOutOfBoundsException e){
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown by getDestination");
		}
	}
	
	/**
	 * Tests whether setDestination correctly sets values
	 * if the Destination is at max +ve bounds
	 */
	@Test
	public void testsetDestination1() {
		try{
			CoordinatePoint p = new CoordinatePoint(180,90);
			Navigator n = new Navigator();
			n.setDestination(p);
			assertEquals(180, n.getDestinationLongitude(), 0);
			assertEquals(90, n.getDestinationLatitude(), 0);
		}
		catch(CoordinateOutOfBoundsException e){
			fail("Setting Destination to 180,90 resulted in CoorindateOutOfBoundsException");
		}
	}
	
	/**
	 * Tests whether setDestination correctly sets values
	 * if the Destination is at max -ve bounds
	 */
	@Test
	public void testsetDestination2() {
		try{
			CoordinatePoint p = new CoordinatePoint(-180,-90);
			Navigator n = new Navigator();
			n.setDestination(p);
			assertEquals(-180, n.getDestinationLongitude(), 0);
			assertEquals(-90, n.getDestinationLatitude(), 0);
		}
		catch(CoordinateOutOfBoundsException e){
			fail("Setting Destination to -180,-90 resulted in CoorindateOutOfBoundsException");
		}
	}
	
	/**
	 * Tests whether setDestination correctly sets values
	 * if the Destination is at max +ve bounds
	 */
	@Test
	public void testsetDestination3() {
		try{
			Navigator n = new Navigator();
			n.setDestination(180,90);
			assertEquals(180, n.getDestinationLongitude(), 0);
			assertEquals(90, n.getDestinationLatitude(), 0);
		}
		catch(CoordinateOutOfBoundsException e){
			fail("Setting destination to 180,90 resulted in CoorindateOutOfBoundsException");
		}
	}
	
	/**
	 * Tests whether setDestination correctly sets values
	 * if the Destination is at max -ve bounds
	 */
	@Test
	public void testsetDestination4() {
		try{
			Navigator n = new Navigator();
			n.setDestination(-180,-90);
			assertEquals(-180, n.getDestinationLongitude(), 0);
			assertEquals(-90, n.getDestinationLatitude(), 0);
		}
		catch(CoordinateOutOfBoundsException e){
			fail("Setting destination to -180,-90 resulted in CoorindateOutOfBoundsException");
		}
	}
	
	/**
	 * Tests whether setDestination throws CoordinateOutOfBoundsException
	 * if the Destination is just +ve out of bounds for its longitude 
	 * while latitude is at bound, 180.1,90
	 */
	@Test
	public void testsetDestination5() {
		try{
			Navigator n = new Navigator();
			n.setDestination(180.1,90);
			assertEquals(180.1, n.getDestinationLongitude(), 0);
			assertEquals(90, n.getDestinationLatitude(), 0);
			fail("Should trigger a CoordinateOutOfBoundsException");
		}
		catch(CoordinateOutOfBoundsException e){
			assertEquals("Out of bounds longitude: 180.1", e.getMessage());
		}
	}
	
	/**
	 * Tests whether setDestination throws CoordinateOutOfBoundsException
	 * if the Destination is just -ve out of bounds for its longitude
	 * while latitude is at bound, -180.1,90
	 */
	@Test
	public void testsetDestination6() {
		try{
			Navigator n = new Navigator();
			n.setDestination(-180.1,90);
			assertEquals(-180.1, n.getDestinationLongitude(), 0);
			assertEquals(90, n.getDestinationLatitude(), 0);
			fail("Should trigger a CoordinateOutOfBoundsException");
		}
		catch(CoordinateOutOfBoundsException e){
			assertEquals("Out of bounds longitude: -180.1", e.getMessage());
		}
	}
	
	/**
	 * Tests whether setDestination throws CoordinateOutOfBoundsException
	 * if the Destination is just +ve out of bounds for its latitude
	 * while longitude at bound, 180,90.1
	 */
	@Test
	public void testsetDestination7() {
		try{
			Navigator n = new Navigator();
			n.setDestination(180,90.1);
			assertEquals(180, n.getDestinationLongitude(), 0);
			assertEquals(90.1, n.getDestinationLatitude(), 0);
			fail("Should trigger a CoordinateOutOfBoundsException");
		}
		catch(CoordinateOutOfBoundsException e){
			assertEquals("Out of bounds latitude: 90.1", e.getMessage());
		}
	}
	
	/**
	 * Tests whether setDestination throws CoordinateOutOfBoundsException
	 * if the Destination is just +ve out of bounds for its latitude
	 * while longitude at bound, 180,-90.1
	 */
	@Test
	public void testsetDestination8() {
		try{
			Navigator n = new Navigator();
			n.setDestination(180,-90.1);
			assertEquals(180, n.getDestinationLongitude(), 0);
			assertEquals(-90.1, n.getDestinationLatitude(), 0);
			fail("Should trigger a CoordinateOutOfBoundsException");
		}
		catch(CoordinateOutOfBoundsException e){
			assertEquals("Out of bounds latitude: -90.1", e.getMessage());
		}
	}
	
	/**
	 * Tests whether setDestination throws CoordinateOutOfBoundsException
	 * if the exception message given is of correct syntax
	 * when setDestination longitude coordinate is set to 999
	 * while setDestination latitude coordinate is set to 0
	 */
	@Test
	public void testsetDestination9() {
		try{
			Navigator n = new Navigator();
			n.setDestination(999,0);
			fail("Should throw CooridinateOutOfBoundsException");
		}
		catch(CoordinateOutOfBoundsException e){
			assertEquals("Out of bounds longitude: 999.0", e.getMessage());
		}
	}
	
	/**
	 * Tests whether setDestination throws CoordinateOutOfBoundsException
	 * if the exception message given is of correct syntax
	 * when setDestination longitude coordinate is set to 0
	 * while setDestinationn latitude coordinate is set to 999
	 */
	@Test
	public void testsetDestination10() {
		try{
			Navigator n = new Navigator();
			n.setDestination(0,999);
			fail("Should throw CooridinateOutOfBoundsException");
		}
		catch(CoordinateOutOfBoundsException e){
			assertEquals("Out of bounds latitude: 999.0", e.getMessage());
		}
	}
	
	/**
	 * Tests whether setDestinationLongitude correctly sets values
	 * when longitude is set to max +ve bound, 180
	 */
	@Test
	public void testsetDestinationLongitude1() {
		try{
			Navigator n = new Navigator();
			n.setDestinationLongitude(180);
			assertEquals(180, n.getDestinationLongitude(), 0);
		}
		catch(CoordinateOutOfBoundsException e){
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown by setLongitude");
		}
	}
	
	/**
	 * Tests whether setDestinationLongitude throws CoordinateOutOfBoundsException
	 * when setting longitude just over +ve max bound, 180.1 degrees
	 */
	@Test
	public void testsetDestinationLongitude2() {
		try{
			Navigator n = new Navigator();
			n.setDestinationLongitude(180.1);
			fail("Should throw CooridinateOutOfBoundsException");
		}
		catch(CoordinateOutOfBoundsException e){
			assertEquals("Out of bounds longitude: 180.1", e.getMessage());
		}
	}
	
	/**
	 * Tests whether setDestinationLongitude correctly sets values
	 * when setting longitude at -ve, -180 degrees
	 */
	@Test
	public void testsetDestinationLongitude3() {
		try{
			Navigator n = new Navigator();
			n.setDestinationLongitude(-180);
			assertEquals(-180,n.getDestinationLongitude(),0);
		}
		catch(CoordinateOutOfBoundsException e){
			fail("Setting longitude to -180 resulted in CoorindateOutOfBoundsException");
		}
	}
	
	/**
	 * Tests whether setDestinationLongitude throws CoordinateOutOfBoundsException
	 * when setting longitude just over -ve max bound, -180.1 degrees
	 */
	@Test
	public void testsetDestinationLongitude4() {
		try{
			Navigator n = new Navigator();
			n.setDestinationLongitude(-180.1);
			fail("Should throw CooridinateOutOfBoundsException");
		}
		catch(CoordinateOutOfBoundsException e){
			assertEquals("Out of bounds longitude: -180.1", e.getMessage());
		}
	}
	
	/**
	 * Tests whether setDestinationLongitude throws CoordinateOutOfBoundsException
	 * if the exception message given is of correct syntax
	 */
	@Test
	public void testsetDestinationLongitude5() {
		try{
			Navigator n = new Navigator();
			n.setDestinationLongitude(999);
			fail("Should throw CooridinateOutOfBoundsException");
		}
		catch(CoordinateOutOfBoundsException e){
			assertEquals("Out of bounds longitude: 999.0", e.getMessage());
		}
	}
	
	/**
	 * Tests whether setDestinationnLatitude correctly sets values
	 * when setting latitude to max +ve bound, 90
	 */
	@Test
	public void testsetDestinationLatitude1() {
		try{
			Navigator n = new Navigator();
			n.setDestinationLatitude(90);
			assertEquals(90, n.getDestinationLatitude(), 0);
		}
		catch(CoordinateOutOfBoundsException e){
			fail("CoordinateOutOfBoundsException (" + e.getMessage() + ") thrown by setLatitude");
		}
	}
	
	/**
	 * Tests whether setDestinationLatitude throws CoordinateOutOfBoundsException
	 * when setting latitude just over +ve max bound, 90.1 degrees
	 */
	@Test
	public void testsetDestinationLatitude2() {
		try{
			Navigator n = new Navigator();
			n.setDestinationLatitude(90.1);
			fail("Should throw CooridinateOutOfBoundsException");
		}
		catch(CoordinateOutOfBoundsException e){
			assertEquals("Out of bounds latitude: 90.1", e.getMessage());
		}
	}
	
	/**
	 * Tests whether setDestinationLatitude correctly sets values
	 * when setting latitude at -ve, -90 degrees
	 */
	@Test
	public void testsetDestinationLatitude3() {
		try{
			Navigator n = new Navigator();
			n.setDestinationLatitude(-90);
			assertEquals(-90,n.getDestinationLatitude(),0);
		}
		catch(CoordinateOutOfBoundsException e){
			fail("Setting latitude to -90 resulted in CoorindateOutOfBoundsException");
		}
	}
	
	/**
	 * Tests whether setDestinationLatitude throws CoordinateOutOfBoundsException
	 * when setting latitude just over -ve max bound, -90.1 degrees
	 */
	@Test
	public void testsetDestinationLatitude4() {
		try{
			Navigator n = new Navigator();
			n.setDestinationLatitude(-90.1);
			fail("Should throw CooridinateOutOfBoundsException");
		}
		catch(CoordinateOutOfBoundsException e){
			assertEquals("Out of bounds latitude: -90.1", e.getMessage());
		}
	}
	
	/**
	 * Tests whether setDestinationLatitude throws CoordinateOutOfBoundsException
	 * if the exception message given is of correct syntax
	 */
	@Test
	public void testsetDestinationLatitude5() {
		try{
			Navigator n = new Navigator();
			n.setDestinationLatitude(999);
			fail("Should throw CooridinateOutOfBoundsException");
		}
		catch(CoordinateOutOfBoundsException e){
			assertEquals("Out of bounds latitude: 999.0", e.getMessage());
		}
	}
	
	/**
	 * Tests whether distanceInKm provides the correct distance value
	 * between 2 coordinates provided by origin and destination
	 * in kilometres unit
	 *
	 */
	@Test
	public void testdistanceInKm(){
		try{
			Navigator n = new Navigator();
			n.setOrigin(174.77095, -36.85292);
			n.setDestination(-73.98513,40.75889);
			assertEquals(14197,Math.round(n.distanceInKm()),0);
		}
		catch(CoordinateOutOfBoundsException e){
			fail("Calculating distanceInKm resulted in CoorindateOutOfBoundsException");
		}
	}
	
	/**
	 * Tests whether distanceInNM provides the correct distance value
	 * between 2 coordinates provided by origin and destination
	 * in nautical miles unit
	 */
	@Test
	public void testdistanceInNM(){
		try{
			Navigator n = new Navigator();
			n.setOrigin(174.77095, -36.85292);
			n.setDestination(-73.98513,40.75889);
			assertEquals(7666,Math.round(n.distanceInNM()),0);
		}
		catch(CoordinateOutOfBoundsException e){
			fail("Calculating distanceInKm resulted in CoorindateOutOfBoundsException");
		}
	}
}
