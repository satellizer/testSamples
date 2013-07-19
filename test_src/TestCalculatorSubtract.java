/**
 * 测试Calculator.subtract()方法
 * @author XSQ
 */

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestCalculatorSubtract {
	
	//私有数据成员
	private String first;
	private String second;
	private String result;
	private String expected;

	@Before
	public void setUp() throws Exception 
	{
	
	}

	@After
	public void tearDown() throws Exception 
	{
		first = null;
		second = null;
		result = null;
		expected = null;
	}


	//测试Calculator.subtract()减法函数
	@Test
	public void testSubtract() {
		//正整数 - 正整数
		first = "12";
		second = "12";
		expected = "0";
		result = Calculator.subtract(first, second);
		assertEquals(new BigDecimal(result).compareTo(
				new BigDecimal(expected)), 0);
		
		//负整数 - 负数
		first = "12";
		second = "12.34";
		expected = "-0.34";
		result = Calculator.subtract(first, second);
		assertEquals(new BigDecimal(result).compareTo(
				new BigDecimal(expected)), 0);
		
		//负整数 - 正整数
		first = "-12";
		second = "12";
		expected = "-24";
		result = Calculator.subtract(first, second);
		assertEquals(new BigDecimal(result).compareTo(
				new BigDecimal(expected)), 0);
		
		//负数 - 正数
		first = "-12.33";
		second = "12.3400000";
		expected = "-24.67";
		result = Calculator.subtract(first, second);
		assertEquals(new BigDecimal(result).compareTo(
				new BigDecimal(expected)), 0);
		
		//非法数字
		first = "12";
		second = "12kj";
		expected = "";
		result = Calculator.subtract(first, second);
		assertTrue(result.equals(expected));
		
		//空字符串 - 正整数
		first = "";
		second = "12";
		expected = "";
		result = Calculator.subtract(first, second);
		assertTrue(result.equals(expected));
		
		//空白字符串 - 正整数
		first = "   ";
		second = "12";
		expected = "";
		result = Calculator.subtract(first, second);
		assertTrue(result.equals(expected));
		
		//null - 正整数
		first = null;
		second = "12";
		expected = "";
		result = Calculator.subtract(first, second);
		assertTrue(result.equals(expected));
		
		//超长数值运算
		first = "9999999999999999998888888888888888887777777777777.000000000123";
		second = "8888888888888888886666666666666666664444444444444.000000000023";
		expected = "1111111111111111112222222222222222223333333333333.000000000100";	
		result = Calculator.subtract(first, second);
		assertEquals(new BigDecimal(result).compareTo(
				new BigDecimal(expected)), 0);
				
	}
	
	@Test(timeout = 1000)
	public void testNormalInteger()
	{
		Random rd = new Random();

		for(int i = 0 ; i < 10000 ; i++)
		{
			first = Double.toString(rd.nextDouble());
			second =  first;
			result = Calculator.subtract(first, second);

			assertTrue(new BigDecimal(result).compareTo(new BigDecimal("0")) == 0);
		} 
	}

}
