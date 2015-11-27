package businessLogic.businessLogicModel.deliveryModel;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import constant.PackageType;
import dataService.deliveryDataService.ConstantDataService;
import network.RMI;
import po.deliveryPO.PackPrice;

public class PackagePriceIO {

	private static Map<PackageType, Double> table = new HashMap<PackageType, Double>();
	
	private static ConstantDataService constant = RMI.<ConstantDataService>getDataService("constant");
	
	static {
		PackPrice price = null;
		try {
			price = constant.getPackPrice();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		table.put(PackageType.CARTON, price.getCarton());
		table.put(PackageType.WOODEN, price.getWooden());
		table.put(PackageType.COURIER_BAG, price.getCourierBag());
		table.put(PackageType.OTHER, price.getOther());
	}

	public static double getPackPrice(PackageType type) {
		return table.get(type);
	}
	
	public static void storePackPrice(PackPrice price) {
		try {
			constant.savePackPrice(price);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
