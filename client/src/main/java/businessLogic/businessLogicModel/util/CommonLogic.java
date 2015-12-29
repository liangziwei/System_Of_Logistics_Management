package businessLogic.businessLogicModel.util;

import java.text.SimpleDateFormat;

public class CommonLogic {

	public static boolean isNull(String s) {
		return s == null || s.equals("");
	}
	
	public static boolean isNumber(String s) {
		return s.matches("[0-9]+");
	}
	
	public static boolean isDouble(String s) {
		if(isNull(s)) return false;
		try {
			Double.parseDouble(s);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public static boolean isStaffType(char c) {
		return c >= 'B' && c <= 'H';
	}
	
	public static boolean isDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			sdf.setLenient(false);
			sdf.parse(date);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 *默认年份为四位数字 
	 */
	public static boolean isYear(String year) {
		return !isNull(year) && isNumber(year) && year.length() == 4;
	}
	
	public static boolean isMonth(String month) {
		if(isNull(month) || !isNumber(month)) return false;
		int m = Integer.parseInt(month);
		return m >= 1 && m <= 12;
	}
	
}
