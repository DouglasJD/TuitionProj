package org.jd.json;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	private static String regex = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" +
	        "(?<mastercard>5[1-5][0-9]{14})|" +
	        "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|" +
	        "(?<amex>3[47][0-9]{13})|" +
	        "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" +
	        "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";
    public static String maskCardPanByRegex (String msg){
    	Pattern cardPanRegex = Pattern.compile(regex);
    	Matcher m = cardPanRegex.matcher(msg);
    	return m.replaceAll("XXXXXXXXXXXXXXXX");
    }
    
    
    public final static void main (String[] args){
    	String inputString = "PaymentRequest{Id=123456, type=CREDIT_CARD, creditCardDetails=CreditCardDetails{type=VISA, name=Some Name, number=1234567890123456, expiry=0316, CCV=000}, directDebitDetails=null}";
    			String result = inputString.replaceAll("(?=number=\\d{1,16},)(number=\\d*?)\\d{1,4},", "$1--XXXX--,");
    			result = inputString.replaceAll("(?=number=\\d{1,16},)(number=\\d*?)\\d{1,4},", "XXXX$1XXXX");

    			System.out.println(result);
    }

}
