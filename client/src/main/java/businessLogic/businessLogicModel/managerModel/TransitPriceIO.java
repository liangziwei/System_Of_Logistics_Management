package businessLogic.businessLogicModel.managerModel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import constant.TransitType;
import dataService.deliveryDataService.ConstantDataService;
import network.RMI;
import po.deliveryPO.TransitPrice;

public class TransitPriceIO {

	private static ConstantDataService constant = RMI.<ConstantDataService>getDataService("constant");
	
	private static Map<TransitType, Double> table = new HashMap<TransitType, Double>();
	
	static {
		try {
			TransitPrice transit = constant.getTransitPrice();
			table.put(TransitType.AIR, transit.getAir());
			table.put(TransitType.RAILWAY, transit.getRailway());
			table.put(TransitType.ROAD, transit.getRoad());
		} catch (RemoteException e) {
			e.printStackTrace();
			table.put(TransitType.AIR, 20.0);
			table.put(TransitType.RAILWAY, 0.2);
			table.put(TransitType.ROAD, 2.0);
		}
	}
	
	public static double getTransitPrice(TransitType type) {
		return table.get(type);
	}
	
	public static boolean saveTransitPrice(TransitPrice price) {
		try {
			constant.saveTransitPrice(price);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
}
