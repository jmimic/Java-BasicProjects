
public class KeyboardInput {
	private java.util.Scanner s;
	
	KeyboardInput() {
	    s = new java.util.Scanner(System.in);
	}
	
	public String getLine() {
        return s.nextLine();
	}
	
	public void close() {
		s.close();
	}
}
