
public class Amount {
	private Currency currency;
	private double amount;
	/**
	 * Method stores both currency and amount of money.
	 * This is an instance method.
	 * Invoked by convertAmount() in CurrencyExchangeProgram.
	 * 
	 * @param currency: The currency of the amount of money
	 * @param amount: The amount of money
	 */
	public Amount(Currency currency, double amount) {
		this.setCurrency(currency);
		this.setAmount(amount);
	}
	/**
	 * 
	 */
	
	/**
	 * Method retrieves currency
	 * This is an instance method.
	 * Invoked by convertAmount() in CurrencyExchangeProgram.
	 * Takes no parameters.
	 * 
	 * @return currency stored
	 */
	public Currency getCurrency() {
		return currency;
	}
	
	/**
	 * Method sets stored currency to currency of parameter.
	 * This is an instance method.
	 * Invoked by Amount() in Amount.
	 * 
	 * @param currency: currency to be stored.
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	/**
	 * Method retrieves amount of money stored.
	 * This is an instance method.
	 * Invoked by convertAmount() in CurrencyExchangeProgram
	 * Takes no parameters.
	 * 
	 * @return amount of money stored. 
	 */
	public double getAmount() {
		return amount;
	}
	
	/**
	 * Method sets stored amount of money to amount of money of parameter.
	 * This is an instance method.
	 * Invoked by Amount() in Amount.
	 * 
	 * @param amount: amount of money to be stored.
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	/**
	 * Method retrieves both amount of money and currency and returns money value of currency
	 * This is an instance method.
	 * Invoked by convertAmount() in CurrencyExchangeProgram.
	 * 
	 * @param otherCurrency
	 * @return money value of a currency
	 */
	public double getAmountIn(Currency otherCurrency) {
		System.out.println(otherCurrency);
		return amount * currency.getExchangeRate() / otherCurrency.getExchangeRate();
	}
	
	/**
	 * Overloaded Method
	 * Changed number of parameters
	 * 
	 * @param otherCurrency
	 * @param currencyObject
	 * @return money value of a currency
	 */
	public double getAmountIn(Currency otherCurrency, double currencyObject) {
		System.out.println("Yes");
		currencyObject = amount * currency.getExchangeRate() / otherCurrency.getExchangeRate();
		return currencyObject;
	}
	
}
