/**
 * �����׼�CalculatorTestSuite
 * ��CalculatorTestAdd��CalculatorTestSubtract��
 * CalculatorTestMultiply һ�����У�
 * @author XSQ
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;;

@RunWith(Suite.class)
@SuiteClasses({TestCalculatorAdd.class,TestCalculatorSubtract.class,
				TestCalculatorMultiply.class})
public class TestCalculatorSuite {

}
