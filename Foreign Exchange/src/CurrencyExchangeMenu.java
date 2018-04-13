
public class CurrencyExchangeMenu {
	
	/**
	 * Method outputs the currency exchange menu, user is to choose 1-4
	 * This is an instance method.
	 * Invoked by getChoice(KeyboardInput) in CurrencyExchangeMenu.
	 * Takes no parameters.
	 */
	private void showMenu() {
		System.out.println("***Welcome to the currency exchange calculator***");
		System.out.println();
		System.out.println("1) List available currencies");
		System.out.println("2) Add a currency");
		System.out.println("3) Show an exchange rate");
		System.out.println("4) Convert an amount");
		System.out.println();
		System.out.print("Enter your choice: ");		
	}
	
	/**
	 * Method retrieves user's input and parses into integer
	 * This is an instance method.
	 * Invoked by run() in CurrencyExchangeProgram.
	 * 
	 * @param k
	 * @return the number of choice between 1 and 4 inclusive
	 */
	private int getInput(KeyboardInput k) {
        String choiceStr = k.getLine();     
        return Integer.parseInt(choiceStr);
	}
	
	/**
	 * Method retrieves user's choice before integer parse.
	 * This is an instance method.
	 * Invoked by run() in CurrencyExchangeProgram.
	 * 
	 * @param k
	 * @return choice of number between 1 and 4 inclusive 
	 */
	public int getChoice(KeyboardInput k) {
		showMenu();
		int choice = getInput(k);
		while ((choice < 1) || (choice > 4)) {
			System.out.print("Invalid input. Please enter your choice: ");
			choice = getInput(k);
		}
		return choice;		
	}	
}
