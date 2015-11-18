package businessLogic.businessLogicModel.util;

public class CommonLogic {

	public static boolean isNull(String s) {
		return s == null || s.equals("");
	}
	
	public static boolean isNumber(String s) {
		if(isNull(s)) return false;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) > '9' || s.charAt(i) < '0') return false;
		}
		return true;
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
}
