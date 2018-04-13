
public class Currency {
	private String code;
	private double exchangeRate;
	
	/**
	 * Constructor Method receives stored currency code and exchange rate.
	 * This is a instance method.
	 * Invoked by addCurrency() in Currencies.
	 * 
	 * @param code: Currency Code to be stored
	 * @param exchangeRate: Exchange Rate to be stored
	 */
	public Currency(String code, double exchangeRate) {
		this.code = code;
		this.exchangeRate = exchangeRate;
	}
	
	/**
	 * Method retrieves Currency Code
	 * This is an instance method.
	 * Invoked by deleteCurrencyByCode() in Currencies.
	 * Takes no parameters.
	 * 
	 * @return Currency Code stored
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * Method retrieves Exchange Rate
	 * This is an instance method.
	 * Invoked by getAmountIn() in Amount.
	 * Takes no parameters.
	 * 
	 * @return Exchange Rate stored
	 */
	public double getExchangeRate() {
		return exchangeRate;
	}
	
	/**
	 * Method sets stored Exchange Rate to Exchange Rate of the parameter.
	 * This is an instance method.
	 * Invoked by getAmountIn() in Amount.
	 * 
	 * @param Exchange Rate to be stored
	 */
	public void setExchangeRate(double newExchangeRate) {
		exchangeRate = newExchangeRate;
	}
}
