package net.webservicex;

public class TestWS {

	public static void main(String[] args) {
		CurrencyConvertor c = new CurrencyConvertor();
		CurrencyConvertorSoap cs = c.getCurrencyConvertorSoap();
		double rate = cs.conversionRate(Currency.USD, Currency.INR);
		System.out.println(rate);

	}

}
