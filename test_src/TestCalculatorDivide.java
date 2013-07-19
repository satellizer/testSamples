/**
 * ����Calculator.divide()����
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
	//˽�����ݳ�Ա
	private String first;
	private String second;
	private String expected;
	private String result;
	/**
	 * ���������Ա���Ĺ������캯��
	 * @param first �������ݣ���Ӧ������
	 * @param second �������ݣ���Ӧ����
	 * @param expected �����Ĳ��Խ������Ӧ��
	 * @param result ������н��
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
	
	//��β������쳣������testDivideNormal��������
	@Ignore("��������������ˣ�")@Test
	public void testDivideNormal() {
		
		//�������������
		first = "12";
		second = "3";
		expected = "4";	
		result = Calculator.divide(first, second).toString();
		assertTrue(expected.equals(result));
		
		//���Ը������������
		first = "12";
		second = "-3";
		expected = "-4";	
		result = Calculator.divide(first, second).toString();
		assertTrue(expected.equals(result));

		//����С�����
		first = "1.2000000";
		second = "3";
		expected = "0.4";	
		String result = Calculator.divide(first, second).toString();
		assertTrue(expected.equals(result));
		
	}
	
	//���Գ����������	
	@Test
	public void testDivideInfinite()
	{
		//�����������������
		final String errorAccepted = "0.00000000000001";
		
		/**
		 * ���Գ����������
		 */
		first = "1";
		second = "3";
		expected = "0.333333333333333";	
		result = Calculator.divide(first, second).toString();
		
		BigDecimal exp = new BigDecimal(expected);
		BigDecimal res = new BigDecimal(result);
		
		//������������ֵ�Ĳ�һ��С�� ��������
		assertTrue(exp.subtract(res).abs().compareTo(
				new BigDecimal(errorAccepted)) == -1);
	}
	
	//���ԷǷ���������,�׳�NumberFormatException���쳣
	@Test(expected = NumberFormatException.class)
	public void testDivideInvalidInput()
		{
			first = "1.2";
			second = "215jk";	
			
			result = Calculator.divide(first, second).toString();

		}
	
	//����null�����������׳�NullPointerException���쳣
	@Test(expected = NullPointerException.class)
	public void testDivideNullInput()
		{
			first = null;
			second = "12";
			
			result = Calculator.divide(first, second).toString();

		}
	
	//���Գ���Ϊ0�����,�׳�ArithmeticException���쳣
	@Test(expected = ArithmeticException.class)
	public void testDivideZero()
	{
		first = "1.2";
		second = "0";
			
		result = Calculator.divide(first, second).toString();
		
	}

}
