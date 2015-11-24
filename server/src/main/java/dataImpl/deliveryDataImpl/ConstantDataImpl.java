package dataImpl.deliveryDataImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import constant.PackageType;
import dataService.deliveryDataService.ConstantDataService;
import po.deliveryPO.DistanceConstant;
import po.deliveryPO.PackPrice;
import po.deliveryPO.TransitPrice;

public class ConstantDataImpl implements ConstantDataService{
	
	/**
	 * 存储包装价格的格式为：5:10:1:2, 分别表示纸箱（5元）、木箱（10元）、快递袋（1元）、其它
	 */
	private static Map<PackageType, Double> table = new HashMap<PackageType, Double>();
	
	static {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("data/price.txt")));
			String line = reader.readLine();
			String[] price = line.split(":");
			table.put(PackageType.CARTON, Double.parseDouble(price[0]));
			table.put(PackageType.WOODEN, Double.parseDouble(price[1]));
			table.put(PackageType.COURIER_BAG, Double.parseDouble(price[2]));
			table.put(PackageType.OTHER, Double.parseDouble(price[3]));
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
			table.put(PackageType.CARTON, 5.0);
			table.put(PackageType.WOODEN, 10.0);
			table.put(PackageType.COURIER_BAG, 1.0);
			table.put(PackageType.OTHER, 2.0);
		}
	}
	
	public boolean savePackPrice(PackPrice price) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("data/price.txt")));
			writer.write(price.getCarton() + ":" + price.getWooden() + ":"
					+ price.getCourierBag() + ":" + price.getOther() + "\n");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public PackPrice getPackPrice() throws RemoteException {
		return new PackPrice(table.get(PackageType.CARTON), table.get(PackageType.WOODEN),
				table.get(PackageType.COURIER_BAG), table.get(PackageType.OTHER));
	}

	public DistanceConstant getDistantceConstant() throws RemoteException {
		return null;
	}
	
	public boolean saveDistanceConstant(DistanceConstant distance) throws RemoteException {
		return false;
	}

	public TransitPrice getTransitPrice() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveTransitPrice(TransitPrice price) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
}
