package businessLogic.businessLogicModel.deliveryModel;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import constant.City;
import dataService.deliveryDataService.ConstantDataService;
import network.RMI;
import po.deliveryPO.DistanceConstant;

public class DistanceIO {

	private static ConstantDataService constant = RMI.<ConstantDataService>getDataService("constant");
	
	private static Map<City, HashMap<City, Double>> table = new HashMap<City, HashMap<City, Double>>();
	
	static {
		try {
			DistanceConstant distance = constant.getDistantceConstant();
			table = distance.getDistance();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static double getDistance(City source, City destination) {
		return table.get(source).get(destination);
	}
	
	public static boolean saveDistance(DistanceConstant distance) {
		try {
			return constant.saveDistanceConstant(distance);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
}
