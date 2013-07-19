/**
 * ����Calculator.add()����
 * @author XSQ
 */

import static org.junit.Assert.*;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestCalculatorAdd {

	private String first;
	private String second;
	private String result;
	private String expected;

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
		first = null;
		second = null;
		result = null;
		expected = null;
	}

	@Test
	public void testAdd() {

		first = "12";
		second = "12";
		expected = "24";
		result = Calculator.add(first, second);
		assertEquals(
				new BigDecimal(result).compareTo(new BigDecimal(expected)), 0);

		first = "12";
		second = "12.34";
		expected = "24.34";
		result = Calculator.add(first, second);
		assertEquals(
				new BigDecimal(result).compareTo(new BigDecimal(expected)), 0);

		first = "-12";
		second = "12";
		expected = "0";
		result = Calculator.add(first, second);
		assertEquals(
				new BigDecimal(result).compareTo(new BigDecimal(expected)), 0);

		first = "-12.330000";
		second = "12.34";
		expected = "0.01";
		result = Calculator.add(first, second);
		assertEquals(
				new BigDecimal(result).compareTo(new BigDecimal(expected)), 0);

		first = "12";
		second = "12kj";
		expected = "";
		result = Calculator.add(first, second);
		assertTrue(result.equals(expected));

		first = "";
		second = "12";
		expected = "";
		result = Calculator.add(first, second);
		assertTrue(result.equals(expected));

		first = "   ";
		second = "12";
		expected = "";
		result = Calculator.add(first, second);
		assertTrue(result.equals(expected));

		first = null;
		second = "12";
		expected = "";
		result = Calculator.add(first, second);
		assertTrue(result.equals(expected));

		first = "11111111111111111122222222222223333333333333333.000000000123";
		second = "33333333333333333311111111111110000000000000000.000000000321";
		expected = "44444444444444444433333333333333333333333333333.000000000444";
		result = Calculator.add(first, second);
		assertEquals(
				new BigDecimal(result).compareTo(new BigDecimal(expected)), 0);

	}

	// @Ignore@Test(timeout = 1100)
	// public void testNormalInteger()
	// {
	//
	// }

}
