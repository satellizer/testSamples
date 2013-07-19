/**
 * 测试Calculator.multiply()方法
 * @author XSQ
 */

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestCalculatorMultiply {
	
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


	//测试Calculator.multiply()乘法函数
	@Test
	public void testMultiply() {
		//正整数 * 正整数
		first = "12";
		second = "2";
		expected = "24";
		result = Calculator.multiply(first, second);
		//断言expected与result相等
		assertEquals(new BigDecimal(result).compareTo(
				new BigDecimal(expected)), 0);
		
		//负整数 * 负数
		first = "11";
		second = "-0.010000";
		expected = "-0.11";
		result = Calculator.multiply(first, second);
		//断言expected与result相等
		assertEquals(new BigDecimal(result).compareTo(
				new BigDecimal(expected)), 0);
		
		//负整数 * 正整数
		first = "-12";
		second = "12";
		expected = "-144";
		result = Calculator.multiply(first, second);
		//断言expected与result相等
		assertEquals(new BigDecimal(result).compareTo(
				new BigDecimal(expected)), 0);
		
		//负数 * 正数
		first = "-12.33";
		second = "12.34";
		expected = "-152.1522";
		result = Calculator.multiply(first, second);
		//断言expected与result相等
		assertEquals(new BigDecimal(result).compareTo(
				new BigDecimal(expected)), 0);
		
		//非法数字
		first = "12";
		second = "12kj";
		expected = "";
		result = Calculator.multiply(first, second);
		//断言result为空
		assertTrue(result.equals(expected));
		
		//空字符串 * 正整数
		first = "";
		second = "12";
		expected = "";
		result = Calculator.multiply(first, second);
		//断言result为空
		assertTrue(result.equals(expected));
		
		//空白字符串 * 正整数
		first = "   ";
		second = "12";
		expected = "";
		result = Calculator.multiply(first, second);
		//断言result为空
		assertTrue(result.equals(expected));
		
		//null * 正整数
		first = null;
		second = "12";
		expected = "";
		result = Calculator.multiply(first, second);
		//断言result为空
		assertTrue(result.equals(expected));
		
		//超长数值运算
		first = "99999999997777.0023";
		second = "8888864444.000023";
		expected = "888886444380242374785376.1700710529";	
		result = Calculator.multiply(first, second);
		//断言expected与result相等
		assertEquals(new BigDecimal(result).compareTo(
				new BigDecimal(expected)), 0);
		
	}

}
