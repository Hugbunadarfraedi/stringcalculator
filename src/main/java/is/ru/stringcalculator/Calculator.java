package is.ru.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else{
			negativeMessage(text);
			return sum(splitNumbers(text));
		}
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    if(numbers.startsWith("//")){
	    	Matcher m = Pattern.compile("//(.)\n(.*)").matcher(numbers);
	    	m.matches();
	    	String delimiter = m.group(1);
	    	String number = m.group(2);
	    	return number.split(delimiter);
	    }
	    else{
	    	return numbers.split(",|\n");
	    }
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }

	private static String negative = "";

    private static void negativeMessage(String s){
    	if(s.contains("-1")){
    		throw new RuntimeException("Negatives not allowed: -1");
    	}
    	if(negative.contains("-")){
    		throw new RuntimeException("Negatives not allowed: " + negative);
    	}
    }
}