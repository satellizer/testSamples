/**
 * ʹ�ò��������ԣ�����Calcul.Square��������
 * @author XSQ
 */
import static org.junit.Assert.*;

import org.junit.runners.Parameterized;  
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Arrays;

@RunWith(Parameterized.class)
public class TestCalculatorSquareWithPara {

	private String testData;
	private String expectedData;
	/**
	 * ���������Ա���Ĺ������캯��
	 * @param testData �������ݣ���Ӧ��һ������
	 * @param expectedData �����Ĳ��Խ������Ӧ�ڶ�������
	 */
	public TestCalculatorSquareWithPara(String testData,
			String expectedData)
	{
		this.testData = testData;
		this.expectedData = expectedData;
	}
	
	//���ò���
	@Parameters
	public static Collection words()
	{
		return Arrays.asList(new Object[][]{
				{"12","144"},		//��������һ�����
				{"-12","144"},		//���Ը���һ�����
				{"1.1","1.21"},		//����С��һ�����
				{"1.0000","1"},		//����С��һ�����
				{"-1.1","1.21"},	//���Ը�С��һ�����
				{"0.00","0"},		//����0
				{null,""},			//����nullʱ�Ĵ������
				{"",""},			//���Կ��ַ��������
				{"  ",""},			//���Կհ��ַ���
				{"d",""},			//���Դ�������Ĵ������
				{"4568er",""},		//���Դ�������Ĵ������

		});
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception 
	{
		testData = null;
		expectedData = null;
	}

	/**
	 * ����Square������������ȷ��
	 */
	@Test
	public void testSquare() 
	{
		//���Բ���ֵ������ֵһ�����
		if(expectedData.equals(""))
			assertEquals(expectedData,Calculator.square(testData));
		else
		{
			//���Խ��������ֵ���
			assertEquals(new BigDecimal(
					Calculator.square(testData)
					).compareTo(
							new BigDecimal(expectedData)
							) , 0
					);
		}
	}

}
