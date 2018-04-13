/**
 * 
 * @Coder: Jacky Shew
 *
 * Change the Longitude & Latitude values using preferred source to destination locations
 * Uses Haversine formula to calculate the great-circle distance between two points
 * 
 */
 
import java.util.Scanner;
import java.util.InputMismatchException;

public class NavigatorApp {

	public static void main(String[] args) {
		try {
		     Navigator n = new Navigator();
		     Scanner scan = new Scanner(System.in);
		     String x = "";
		     
		     System.out.print("Origin location Name: ");
		     String originLocName = scan.nextLine();
		     
		     while(true){
		     	try{
		    	 System.out.print("Origin location's Longitude (between -180 and +180): ");
			     double originLongitude = scan.nextDouble();
			     n.setOriginLongitude(originLongitude);
			     break;
		     }catch(InputMismatchException | LongitudeOutOfBoundsException e){
		    	 System.out.println("\nIncorrect syntax. Please try again.");
		    	 scan.nextLine();
		    	 continue;
		     	}
		     }
		     
		     while(true){
		    	 try{
		    		 System.out.print("Origin location's Latitude (between -90 and +90): ");
				     double originLatitude = scan.nextDouble();
				     n.setOriginLatitude(originLatitude);
				     break;
		    	 }catch(InputMismatchException | LatitudeOutOfBoundsException e){
			    	 System.out.println("\nIncorrect syntax. Please try again.");
			    	 scan.nextLine();
			    	 continue;
			     }
			 }
		     
		     scan.nextLine();
		     System.out.print("Destination location Name: ");
		     String destLocName = scan.nextLine();
		     
		     while(true){
		    	 try{
		    		 System.out.print("Destination location's Longitude (between -180 and +180): ");
				     Double destLongitude = scan.nextDouble();
				     n.setDestinationLongitude(destLongitude);
				     break;
		    	 }catch(InputMismatchException | LongitudeOutOfBoundsException e){
			    	 System.out.println("\nIncorrect syntax. Please try again.");
			    	 scan.nextLine();
			    	 continue;
		    	 }
		     }
		     
		     while(true){
		    	 try{
		    		 System.out.print("Destination location's Latitude (between -90 and +90): ");
				     Double destLatitude = scan.nextDouble();
				     n.setDestinationLatitude(destLatitude);
				     break;
		    	 }catch(InputMismatchException | LatitudeOutOfBoundsException e){
			    	 System.out.println("\nIncorrect syntax. Please try again.");
			    	 scan.nextLine();
			    	 continue;
		    	 }
		     }
		     System.out.println("");
		     
		     System.out.print("The distance between ");
		     System.out.print(originLocName + " and " + destLocName + " is ");
		     System.out.println(n.distanceInKm() + " km");
		     System.out.println("or " + n.distanceInNM() + " nautical miles.");
		     System.out.println("");
		     
		     while(true){
		    	 try{	 
		    		 System.out.println("Press Enter to exit");
		    		 scan.nextLine();
		    		 scan.nextLine();
				     break;
		    	 }catch(InputMismatchException e){
		    		 
		    	 }
		     }
		     
		}catch (Exception e) {
			
		}
	}
}
