package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void testNewLineBetweenNumbers(){
    	assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test
    public void testDifferentDelimiter(){
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }

    @Test(expected = RuntimeException.class)
    public void testThrowException(){
    	Calculator.add("-1,2");
    }

    @Test
    public void testNegativeNumber(){
    	try{
    		Calculator.add("-1,2");
    	}
    	catch (RuntimeException e){
    		assertEquals("Negatives not allowed: -1", e.getMessage());
    	}
    }

    @Test
    public void testMultipleNegativeNumbers(){
    	try{
    		Calculator.add("2,-4,3,-5");
    	}
    	catch (RuntimeException e){
    		assertEquals("Negatives not allowed: -4, -5", e.getMessage());
    	}
    }

    @Test
	public void testIgnoreBiggerThanThousand(){
		assertEquals(2, Calculator.add("1001,2"));
		assertEquals(1001, Calculator.add("1,1000"));
	}
}