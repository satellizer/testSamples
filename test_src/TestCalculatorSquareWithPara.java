/**
 * 使用参数化测试，测试Calcul.Square（）方法
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
	 * 参数化测试必须的公共构造函数
	 * @param testData 测试数据，对应第一个参数
	 * @param expectedData 期望的测试结果，对应第二个参数
	 */
	public TestCalculatorSquareWithPara(String testData,
			String expectedData)
	{
		this.testData = testData;
		this.expectedData = expectedData;
	}
	
	//设置参数
	@Parameters
	public static Collection words()
	{
		return Arrays.asList(new Object[][]{
				{"12","144"},		//测试整数一般情况
				{"-12","144"},		//测试负数一般情况
				{"1.1","1.21"},		//测试小数一般情况
				{"1.0000","1"},		//测试小数一般情况
				{"-1.1","1.21"},	//测试负小数一般情况
				{"0.00","0"},		//测试0
				{null,""},			//测试null时的处理情况
				{"",""},			//测试空字符串的情况
				{"  ",""},			//测试空白字符串
				{"d",""},			//测试错误输入的处理情况
				{"4568er",""},		//测试错误输入的处理情况

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
	 * 测试Square（）方法的正确性
	 */
	@Test
	public void testSquare() 
	{
		//断言测试值跟期望值一定相等
		if(expectedData.equals(""))
			assertEquals(expectedData,Calculator.square(testData));
		else
		{
			//断言结果与期望值相等
			assertEquals(new BigDecimal(
					Calculator.square(testData)
					).compareTo(
							new BigDecimal(expectedData)
							) , 0
					);
		}
	}

}
