package businessLogic.businessLogicModel.deliveryModel;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import constant.DeliveryType;

/**
 *快递方式价格比例表 
 */
public class DeliveryPriceTable {

	private static Map<DeliveryType, Integer> PRICE_TABLE = new HashMap<DeliveryType, Integer>();
	
	static {
		PRICE_TABLE.put(DeliveryType.ECONOMIC, 18);
		PRICE_TABLE.put(DeliveryType.NORMAL, 23);
		PRICE_TABLE.put(DeliveryType.FAST, 25);
	}
	
	public static double calculatePrice(DeliveryType type, double distance, double weight) {
		DecimalFormat format = new DecimalFormat(".##");
		double price = distance / 1000 * PRICE_TABLE.get(type) * weight;
		return Double.parseDouble(format.format(price));
	}
}
