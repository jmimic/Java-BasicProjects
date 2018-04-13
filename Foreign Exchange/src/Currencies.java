
public class Currencies {
	private int currencyIndex;
	private Currency[] currencies;
	
	/**
	 * Constructor Method sets Currencies array to null and is initialized  
	 * This is an instance method.
	 * Invoked by addCurrency() in CurrencyExchangeProgram
	 * Takes no parameters.
	 */
	public Currencies() {
		currencies = null;
		currencyIndex = 0;
	}
	
	/**
	 * Method adds a new currency object.
	 * This is an instance method.
	 * Invoked by run() in CurrencyExchangeProgram.
	 * 
	 * @param newCurrency: 
	 */
	public void addCurrency(Currency newCurrency) {
		if (currencies == null) {
			currencies = new Currency[1];
			currencies[0] = newCurrency;
		}
		else
		{
			Currency[] tmpCurrencies = new Currency[currencies.length + 1];
			for (int i=0; i < currencies.length; i++) {
				tmpCurrencies[i] = currencies[i];
			}
			tmpCurrencies[currencies.length] = newCurrency;
			currencies = tmpCurrencies;
		}
	}
	
	/**
	 * Method adds a new currency object.
	 * This is an instance method.
	 * Invoked by run() in CurrencyExchangeProgram.
	 * 
	 * @param code:
	 * @param exchangeRate:
	 */
	public void addCurrency(String code, double exchangeRate) {
		Currency newCurrency = new Currency(code,exchangeRate);
		addCurrency(newCurrency);
	}
	
	/**
	 * Method returns currency object by currency code.
	 * This is an instance method.
	 * Invoked by showRate() in CurrencyExchangeProgram.
	 * 
	 * @param code: the currency code of the Currency object to retrieve
	 * @return the Currency object retrieved, or null if it is not found
	 */
	public Currency getCurrencyByCode(String code) {
		for (int i=0; i < currencies.length; i++) {
			if (currencies[i].getCode().equals(code)) return currencies[i];
		}
		return null;
	}
	
	/**
	 * Method removes currency object by code from currencies instance variable.
	 * This is an instance method.
	 * 
	 * @param code
	 */
	public void deleteCurrencyByCode(String code) {
		if (currencies == null) return;
		for (int i=0; i < currencies.length; i++) {
			if (currencies[i].getCode().equals(code)) {
				if (currencies.length == 1) {
					currencies = null;
					return;
				}
				else
				{
					Currency[] tmpCurrencies = new Currency[currencies.length-1];
					for (int j=0; j<i; j++) {
						tmpCurrencies[j] = currencies[j];
					}
					for (int j=i; j<tmpCurrencies.length; j++) {
						tmpCurrencies[j] = currencies[j+1];
					}
					currencies = tmpCurrencies;
				}
			}
		}
	}
	
	/**
	 * Method sets currency index to 0
	 * This is an instance method.
	 * Invoked by listCurrencies() in CurrencyExchangeProgram.
	 * Takes no parameters.
	 */
	public void reset() {
		currencyIndex = 0;
	}
	
	/**
	 * Method returns currency object or if null iterates pointer to next element
	 * This is an instance method.
	 * Invoked by listCurrencies() in CurrencyExchangeProgram.
	 * Takes no parameters.
	 * 
	 * @return the Currency object retrieved, or null if it is not found
	 */
	public Currency next() {
		if (currencyIndex == currencies.length) return null;
		Currency c = currencies[currencyIndex];
		currencyIndex++;
		return c;
	}
	
}
