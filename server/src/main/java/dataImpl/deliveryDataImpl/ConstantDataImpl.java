package dataImpl.deliveryDataImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import constant.City;
import dataService.deliveryDataService.ConstantDataService;
import po.deliveryPO.DistanceConstant;
import po.deliveryPO.PackPrice;
import po.deliveryPO.TransitPrice;

public class ConstantDataImpl implements ConstantDataService{
	
	public boolean savePackPrice(PackPrice price) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("data/pack_price.txt")));
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
		String[] price = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("data/pack_price.txt")));
			String line = reader.readLine();
			price = line.split(":");
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
			price = new String[] {
					"5.0", "10.0", "1.0", "2.0"
			};
		}
		return new PackPrice(Double.parseDouble(price[0]), Double.parseDouble(price[1]),
				Double.parseDouble(price[2]), Double.parseDouble(price[3]));
	}

	/**
	 *城市距离表在文件中的存储格式为(900.0:266.0:1132.0:1064.7:1888.8:1213.0:30.0) 
	 *分别表示南京-北京、南京-上海、南京-广州、北京-上海、北京-广州、上海-广州、同城的距离
	 */
	public DistanceConstant getDistantceConstant() throws RemoteException {
		double nb = 900.0;
		double ns = 266.0;
		double ng = 1132.0;
		double bs = 1064.7;
		double bg = 1888.8;
		double sg = 1213.0;
		double local = 30.0;
		String[] d = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("data/distance.txt")));
			String line = reader.readLine();
		    d = line.split(":");
		    nb = Double.parseDouble(d[0]); 
		    ns = Double.parseDouble(d[1]);
		    ng = Double.parseDouble(d[2]);
		    bs = Double.parseDouble(d[3]);
		    bg = Double.parseDouble(d[4]);
		    sg = Double.parseDouble(d[5]);
		    local = Double.parseDouble(d[6]);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HashMap<City, Double> nan_jing = new HashMap<City, Double>();
		nan_jing.put(City.NAN_JING, local);
		nan_jing.put(City.BEI_JING, nb);
		nan_jing.put(City.SHANG_HAI, ns);
		nan_jing.put(City.GUANG_ZHOU, ng);
		HashMap<City, Double> bei_jing = new HashMap<City, Double>();
		bei_jing.put(City.NAN_JING, nb);
		bei_jing.put(City.BEI_JING, local);
		bei_jing.put(City.SHANG_HAI, bs);
		bei_jing.put(City.GUANG_ZHOU, bg);
		HashMap<City, Double> shang_hai = new HashMap<City, Double>();
		shang_hai.put(City.NAN_JING, ns);
		shang_hai.put(City.BEI_JING, bs);
		shang_hai.put(City.SHANG_HAI, local);
		shang_hai.put(City.GUANG_ZHOU, sg);
		HashMap<City, Double> guang_zhou = new HashMap<City, Double>();
		guang_zhou.put(City.NAN_JING, ng);
		guang_zhou.put(City.BEI_JING, bg);
		guang_zhou.put(City.SHANG_HAI, sg);
		guang_zhou.put(City.GUANG_ZHOU, local);
		Map<City, HashMap<City, Double>> table = new HashMap<City, HashMap<City, Double>>();
		table.put(City.NAN_JING, nan_jing);
		table.put(City.BEI_JING, bei_jing);
		table.put(City.SHANG_HAI, shang_hai);
		table.put(City.GUANG_ZHOU, guang_zhou);
		
		return new DistanceConstant(table);
	}
	
	/**
	 *城市距离表在文件中的存储格式为(900.0:266.0:1132.0:1064.7:1888.8:1213.0:30.0) 
	 *分别表示南京-北京、南京-上海、南京-广州、北京-上海、北京-广州、上海-广州、同城的距离
	 */
	public boolean saveDistanceConstant(DistanceConstant distance) throws RemoteException {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("data/distance.txt")));
		    Map<City, HashMap<City, Double>> table = distance.getDistance();
		    String data = "";
		    data += table.get(City.NAN_JING).get(City.BEI_JING) + ":";
		    data += table.get(City.NAN_JING).get(City.SHANG_HAI) + ":";
		    data += table.get(City.NAN_JING).get(City.GUANG_ZHOU) + ":";
		    data += table.get(City.BEI_JING).get(City.SHANG_HAI) + ":";
		    data += table.get(City.BEI_JING).get(City.GUANG_ZHOU) + ":";
		    data += table.get(City.SHANG_HAI).get(City.GUANG_ZHOU) + ":";
		    data += table.get(City.GUANG_ZHOU).get(City.GUANG_ZHOU) + "\n";
		    writer.write(data);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 *运输方式每公里 每吨价钱（元）存储方式：20:0.2:2.0
	 *分别表示空运：火车：汽车
	 */
	public TransitPrice getTransitPrice() throws RemoteException {
		TransitPrice price = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("data/transit_price.txt")));
			String line = reader.readLine();
			String[] temp = line.split(":");
			price = new TransitPrice(Double.parseDouble(temp[0]),
					Double.parseDouble(temp[1]), Double.parseDouble(temp[2]));
			reader.close();
		} catch (Exception e) {
			price = new TransitPrice(20.0, 0.2, 2.0);
			e.printStackTrace();
		}
		return price;
	}

	public void saveTransitPrice(TransitPrice price) throws RemoteException {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("data/transit_price.txt")));
			writer.write(price.getAir() + ":" + price.getRailway() + ":" + price.getRoad() + "\n");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
