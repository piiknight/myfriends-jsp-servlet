package util;

public class LengthNumberValidator {
	public static boolean RangeValue(int start, int end, long number) {
		int count = 0;
		while (number % 10 != 0) {
			count++;
			number /= 10;
		}
		if (count < start || count > end) {
			return false;
		}
		return true;
	}
}
