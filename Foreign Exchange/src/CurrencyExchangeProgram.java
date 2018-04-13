import java.io.File;
import java.util.Scanner;

public class CurrencyExchangeProgram {
	private Currencies currencies; // this private instance variable holds an object of class Currencies
	private KeyboardInput keyboardInput; // this private instance variable holds an object of class keyboardInput 
	
	private boolean verifyInput(String currencyCode){
		if (currencyCode.length() != 3) {
        	System.out.println("\"" + currencyCode + "\" is not a THREE letter code. Returning to menu.\n");
        	return false;
        }
		return true;
	}
	
	private Scanner i; // x variable for Scanner
	private void fileExchangeRates(){ // Method itself that Files Exchange rates and their Country Code into system
		try{ // Using try/catch as there is a possibility of not being able to locate the file forex.txt in the root folder
			i = new Scanner(new File("forex.txt")); // Uses the Java Package Scanner and File to Read and Access File
			if (currencies == null) { // If there are no currencies in system then
	        	currencies = new Currencies(); // Initialize new Currencies array 
	        } // End If statement
			while(i.hasNext()){ // While loop to retrieve next string of characters
				String a = i.next(); // First string or string after the next (b) is assigned/replaced to a
				String b = i.next(); // Every second string or string after the next (a) is assigned/replaced to b
				double bValue = Double.parseDouble(b); // Converts Exchange rate as retrieved as String, to Double
				currencies.addCurrency(a, bValue); // Invokes the addCurrency method in currencies Class to append to array
				} // End of while loop function
			} // End of try block
		catch(Exception e){ // Catches any exception and follows through the nested which is "could not find file"
			System.out.println("Could not find file, forex.txt\n"); // Prints into console "could not find file" if there's an exception
			} // End of catch block
	} // End of fileExchangeRates method
	
	/**
	 * This instance method is the central method of our program. It sets
	 * up all we need for keyboard input later, and contains the central
	 * loop to which execution returns. It takes no parameters. 
	 */
	public void run() {
		fileExchangeRates(); //Files Exchange rates and Country Code into system
		keyboardInput = new KeyboardInput(); // we will use this object to obtain keyboard input
		while (true) { // endless while-loop
			// display the menu and get the user's choice
			CurrencyExchangeMenu menu = new CurrencyExchangeMenu(); // ...using the 
			int menuChoice = menu.getChoice(keyboardInput);

			// now process
			switch (menuChoice) {
			case 1:
				listCurrencies(); // output a list of all currencies added to the system
				break;
			case 2: 
				addCurrency(); // add a currency to the system
				break;
			case 3:
				showRate(); // show the exchange rate for a given currency
				break;
			case 4:
				convertAmount(); // convert an amount between two currencies
				break;
			}
		}
	}
	
	/**
	 * This private instance method outputs a list of all currencies stored in the
	 * private instance variable currencies. The method takes no parameters. 
	 */
	private void listCurrencies() {
		// Test whether we already have currencies
		if (currencies == null) {
			// No, so complain and return
			System.out.println("There are currently no currencies in the system.");
			System.out.println("Please add at least one currency.");
			System.out.println();
			return;
		}
		// Reset the index into the currencies list
		currencies.reset();
		Currency currency;
		// Output all currencies
		while ((currency = currencies.next()) != null) {
			System.out.println(currency.getCode());			
		}
		System.out.println();
	}
	
	/**
	 * This private instance method adds a currency to the private instance variable currencies. 
	 * The method takes no parameters. 
	 */
	private void addCurrency() {
		System.out.print("Enter a three letter currency code (e.g., AUD, JPY, USD, EUR): ");
		String currencyCode = keyboardInput.getLine();
        if (verifyInput(currencyCode) == false){
        	return;
        }
        System.out.println();
        System.out.print("Enter the exchange rate (value of 1 " +currencyCode+ " in NZD): ");
        String exchangeRateStr = keyboardInput.getLine();
        double exchangeRate = Double.parseDouble(exchangeRateStr);
        if (exchangeRate <= 0) {
        	System.out.println("Negative exchange rates not permitted. Returning to menu.");
        	System.out.println();
        	return;
        }
        System.out.println();
        if (currencies == null) {
        	currencies = new Currencies();
        }
        currencies.addCurrency(currencyCode, exchangeRate);
        System.out.println("Currency " +currencyCode+ " with exchange rate " + exchangeRate + " added");
        System.out.println();
	}
	
	/**
	 * Method asks for currency code in return outputs its exchange rate. 
	 * This is an instance method.
	 * Invoked by run() in CurrencyExchangeProgram.
	 * Takes no parameters.
	 */
	private void showRate() {
		/**
		 * Below checks if there are any currencies in the array before continuing
		 * NullPointer problem
		 */
		if (currencies == null){
        	System.out.println("There are currently no currencies in the system.");
			System.out.println("Please add at least one currency.");
			System.out.println();
        	return;
        }
		System.out.print("Enter a three letter currency code (e.g., AUD, JPY, USD, EUR): ");
        String currencyCode = keyboardInput.getLine();
        if (verifyInput(currencyCode) == false){
        	return;
        }
        /**
         * Uses the obtained currency code and verifies if it is in the system/array.
         * The fault occurs when unable to find corresponding currency code in system/array.
         * To fix the problem implemented an if statement for verification.
         */
        Currency currency = currencies.getCurrencyByCode(currencyCode);
        if (currency == null) {
      		System.out.println("\"" + currencyCode + "\" is not on the system. Returning to menu.");
      		System.out.println();
            return;
            }
        System.out.println("Currency " +currencyCode+ " has exchange rate " + currency.getExchangeRate() + ".");
        System.out.println();
        return;
	}
	
	/**
	 * Method asks for currency object to convert from and to, followed by amount to convert
	 * This is an instance method
	 * Invoked by run() in CurrencyExchangeProgram.
	 * Takes no parameters. 
	 */
	private void convertAmount() {
		if (currencies == null){
        	System.out.println("There are currently no currencies in the system.");
			System.out.println("Please add at least one currency.");
			System.out.println();
        	return;
		}
		System.out.println("Select the currency to convert FROM.");
		System.out.print("Enter a three letter currency code (e.g., AUD, JPY, USD, EUR): ");
		String currencyCodeFrom = keyboardInput.getLine();
		if (verifyInput(currencyCodeFrom) == false){
        	return;
        }
		Currency currencyFrom = currencies.getCurrencyByCode(currencyCodeFrom);
        if (currencyFrom == null) {
        	System.out.println("\"" + currencyCodeFrom + "\" is not on the system. Returning to menu.\n");
        	return;
        }
		System.out.println("Select the currency to convert TO.");
		System.out.print("Enter a three letter currency code (e.g., AUD, JPY, USD, EUR): ");
		String currencyCodeTo = keyboardInput.getLine();
		if (verifyInput(currencyCodeTo) == false){
        	return;
        }
        System.out.println();
        Currency currencyTo = currencies.getCurrencyByCode(currencyCodeTo);
        if (currencyTo == null) {
        	System.out.println("\"" + currencyCodeTo + "\" is not on the system. Returning to menu.\n");
        	return;
        }
        System.out.println();
        System.out.print("How many " + currencyCodeFrom + " would you like to convert to " + currencyCodeTo + "? Amount: ");
        String amountStr = keyboardInput.getLine();
        Amount amount = new Amount(currencyFrom, Double.parseDouble(amountStr));
        System.out.println();
        System.out.printf("%.2f %s = %.2f %s",  amount.getAmount(), amount.getCurrency().getCode(), 
            amount.getAmountIn(currencyTo), currencyTo.getCode());
        System.out.println(); 
        System.out.println(); 
	}
}
