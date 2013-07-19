/**
 * @author XSQ
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Calculator {

	private static Logger logger = Logger.getLogger("WindX");

	public static String add(String first, String second) {
		try {
			BigDecimal f = new BigDecimal(first);
			BigDecimal s = new BigDecimal(second);

			return f.add(s).compareTo(new BigDecimal("0")) == 0 ? "0" : f
					.add(s).toString();

		} catch (NumberFormatException nfe) {

			return "";
		} catch (NullPointerException npe) {

			return "";
		}
	}

	public static String subtract(String first, String second) {
		try {
			BigDecimal f = new BigDecimal(first);
			BigDecimal s = new BigDecimal(second);

			return f.subtract(s).compareTo(new BigDecimal("0")) == 0 ? "0" : f
					.subtract(s).toString();

		} catch (NumberFormatException nfe) {

			return "";
		} catch (NullPointerException npe) {
			return "";
		}
	}

	public static String multiply(String first, String second) {
		try {
			BigDecimal f = new BigDecimal(first);
			BigDecimal s = new BigDecimal(second);

			return f.multiply(s).compareTo(new BigDecimal("0")) == 0 ? "0" : f
					.multiply(s).toString();

		} catch (NumberFormatException nfe) {
			return "";
		} catch (NullPointerException npe) {
			return "";
		}
	}

	public static String divide(String first, String second) {
		BigDecimal f = null;
		BigDecimal s = null;

		try {
			f = new BigDecimal(first);
			s = new BigDecimal(second);

			return f.divide(s).compareTo(new BigDecimal("0")) == 0 ? "0" : f
					.divide(s).toString();

		} catch (ArithmeticException ae) {
			if (s.intValue() == 0) {
				throw ae;
			} else {
				return f.divide(s, 15, RoundingMode.HALF_UP).compareTo(
						new BigDecimal("0")) == 0 ? "0" : f.divide(s, 15,
						RoundingMode.HALF_UP).toString();

			}

		} catch (NumberFormatException nfe) {
			throw nfe;

		} catch (NullPointerException npe) {
			throw npe;
		}
	}

	public static String square(String first) {
		try {
			BigDecimal f = new BigDecimal(first);

			return f.multiply(f).compareTo(new BigDecimal("0")) == 0 ? "0" : f
					.multiply(f).toString();

		} catch (NumberFormatException nfe) {

			return "";
		} catch (NullPointerException npe) {
			return "";
		}

	}

	public static void main(String[] arg) {

	}
}
