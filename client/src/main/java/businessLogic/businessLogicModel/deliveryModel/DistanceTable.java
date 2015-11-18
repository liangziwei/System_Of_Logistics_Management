package businessLogic.businessLogicModel.deliveryModel;

import java.util.HashMap;
import java.util.Map;

import constant.City;

public class DistanceTable {
	
	private static Map<City, HashMap<City, Double>> DISTANCE_TABLE = new HashMap<City, HashMap<City, Double>>();

	//建立城市距离表
	static {
		HashMap<City, Double> nan_jing = new HashMap<City, Double>();
		nan_jing.put(City.BEI_JING, 900.0);
		nan_jing.put(City.SHANG_HAI, 266.0);
		nan_jing.put(City.GUANG_ZHOU, 1132.0);
		nan_jing.put(City.NAN_JING, 30.0);
		DISTANCE_TABLE.put(City.NAN_JING, nan_jing);

		HashMap<City, Double> bei_jing = new HashMap<City, Double>();
		bei_jing.put(City.NAN_JING, 900.0);
		bei_jing.put(City.SHANG_HAI, 1064.7);
		bei_jing.put(City.GUANG_ZHOU, 1888.8);
		bei_jing.put(City.BEI_JING, 30.0);
		DISTANCE_TABLE.put(City.BEI_JING, bei_jing);

		HashMap<City, Double> shang_hai = new HashMap<City, Double>();
		shang_hai.put(City.BEI_JING, 1064.7);
		shang_hai.put(City.NAN_JING, 266.0);
		shang_hai.put(City.GUANG_ZHOU, 1213.0);
		shang_hai.put(City.SHANG_HAI, 30.0);
		DISTANCE_TABLE.put(City.SHANG_HAI, shang_hai);

		HashMap<City, Double> guang_zhou = new HashMap<City, Double>();
		guang_zhou.put(City.NAN_JING, 1132.0);
		guang_zhou.put(City.SHANG_HAI, 1213.0);
		guang_zhou.put(City.BEI_JING, 1888.8);
		guang_zhou.put(City.GUANG_ZHOU, 30.0);
		DISTANCE_TABLE.put(City.GUANG_ZHOU, guang_zhou);
	}
	
	public static double getDistance(City source, City destination) {
		return DISTANCE_TABLE.get(source).get(destination);
	}
}
