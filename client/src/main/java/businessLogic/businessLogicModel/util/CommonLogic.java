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
	
}
