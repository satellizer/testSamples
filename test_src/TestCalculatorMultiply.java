/**
 * ����Calculator.multiply()����
 * @author XSQ
 */

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestCalculatorMultiply {
	
	//˽�����ݳ�Ա
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


	//����Calculator.multiply()�˷�����
	@Test
	public void testMultiply() {
		//������ * ������
		first = "12";
		second = "2";
		expected = "24";
		result = Calculator.multiply(first, second);
		//����expected��result���
		assertEquals(new BigDecimal(result).compareTo(
				new BigDecimal(expected)), 0);
		
		//������ * ����
		first = "11";
		second = "-0.010000";
		expected = "-0.11";
		result = Calculator.multiply(first, second);
		//����expected��result���
		assertEquals(new BigDecimal(result).compareTo(
				new BigDecimal(expected)), 0);
		
		//������ * ������
		first = "-12";
		second = "12";
		expected = "-144";
		result = Calculator.multiply(first, second);
		//����expected��result���
		assertEquals(new BigDecimal(result).compareTo(
				new BigDecimal(expected)), 0);
		
		//���� * ����
		first = "-12.33";
		second = "12.34";
		expected = "-152.1522";
		result = Calculator.multiply(first, second);
		//����expected��result���
		assertEquals(new BigDecimal(result).compareTo(
				new BigDecimal(expected)), 0);
		
		//�Ƿ�����
		first = "12";
		second = "12kj";
		expected = "";
		result = Calculator.multiply(first, second);
		//����resultΪ��
		assertTrue(result.equals(expected));
		
		//���ַ��� * ������
		first = "";
		second = "12";
		expected = "";
		result = Calculator.multiply(first, second);
		//����resultΪ��
		assertTrue(result.equals(expected));
		
		//�հ��ַ��� * ������
		first = "   ";
		second = "12";
		expected = "";
		result = Calculator.multiply(first, second);
		//����resultΪ��
		assertTrue(result.equals(expected));
		
		//null * ������
		first = null;
		second = "12";
		expected = "";
		result = Calculator.multiply(first, second);
		//����resultΪ��
		assertTrue(result.equals(expected));
		
		//������ֵ����
		first = "99999999997777.0023";
		second = "8888864444.000023";
		expected = "888886444380242374785376.1700710529";	
		result = Calculator.multiply(first, second);
		//����expected��result���
		assertEquals(new BigDecimal(result).compareTo(
				new BigDecimal(expected)), 0);
		
	}

}
