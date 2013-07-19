/**
 * 测试Calculator.divide()方法
 * @author XSQ
 */
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

public class TestCalculatorDivide {
	//私有数据成员
	private String first;
	private String second;
	private String expected;
	private String result;
	/**
	 * 参数化测试必须的公共构造函数
	 * @param first 测试数据，对应被除数
	 * @param second 测试数据，对应除数
	 * @param expected 期望的测试结果，对应商
	 * @param result 存放运行结果
	 */
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception 
	{
		first = null;
		second = null;
		expected = null;
	}
	
	//多次测试无异常，忽略testDivideNormal（）方法
	@Ignore("正常情况，不测了！")@Test
	public void testDivideNormal() {
		
		//测试正整数情况
		first = "12";
		second = "3";
		expected = "4";	
		result = Calculator.divide(first, second).toString();
		assertTrue(expected.equals(result));
		
		//测试负整数整数情况
		first = "12";
		second = "-3";
		expected = "-4";	
		result = Calculator.divide(first, second).toString();
		assertTrue(expected.equals(result));

		//测试小数情况
		first = "1.2000000";
		second = "3";
		expected = "0.4";	
		String result = Calculator.divide(first, second).toString();
		assertTrue(expected.equals(result));
		
	}
	
	//测试除不尽的情况	
	@Test
	public void testDivideInfinite()
	{
		//舍入运算的允许的误差
		final String errorAccepted = "0.00000000000001";
		
		/**
		 * 测试除不尽的情况
		 */
		first = "1";
		second = "3";
		expected = "0.333333333333333";	
		result = Calculator.divide(first, second).toString();
		
		BigDecimal exp = new BigDecimal(expected);
		BigDecimal res = new BigDecimal(result);
		
		//运算结果与期望值的差一定小于 允许的误差
		assertTrue(exp.subtract(res).abs().compareTo(
				new BigDecimal(errorAccepted)) == -1);
	}
	
	//测试非法输入的情况,抛出NumberFormatException的异常
	@Test(expected = NumberFormatException.class)
	public void testDivideInvalidInput()
		{
			first = "1.2";
			second = "215jk";	
			
			result = Calculator.divide(first, second).toString();

		}
	
	//测试null输入的情况，抛出NullPointerException的异常
	@Test(expected = NullPointerException.class)
	public void testDivideNullInput()
		{
			first = null;
			second = "12";
			
			result = Calculator.divide(first, second).toString();

		}
	
	//测试除数为0的情况,抛出ArithmeticException的异常
	@Test(expected = ArithmeticException.class)
	public void testDivideZero()
	{
		first = "1.2";
		second = "0";
			
		result = Calculator.divide(first, second).toString();
		
	}

}
