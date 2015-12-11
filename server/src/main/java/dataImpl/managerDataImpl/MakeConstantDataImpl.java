package dataImpl.managerDataImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import constant.City;
import dataService.managerDataService.MakeConstantDataService;
import po.constant.DistanceItem;
import po.constant.DistanceTable;
import po.constant.PackPrice;
import po.constant.TransitPrice;

/**
 * description:数据服务层为制定城市距离和价格常量提供服务的具体实现
 * @author 张仁知
 */
public class MakeConstantDataImpl implements MakeConstantDataService{

	/**
	 *保存快递包装费常量，以：隔开(纸箱：木箱：快递袋：其他) 
	 */
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

	/**
	 *从文件中读取快递包装费价格常量,传递个客户端端 
	 */
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
	public DistanceTable getDistantceConstant() throws RemoteException {
		double nb = 900.0, ns = 266.0, ng = 1132.0;
		double bs = 1064.7, bg = 1888.8, sg = 1213.0, local = 30.0;
		String[] d = null;
		//从文件中读取城市距离信息
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
		//创建城市距离表
		DistanceTable table = new DistanceTable();
		table.setCityItem(new DistanceItem(City.NAN_JING, City.BEI_JING, nb));
		table.setCityItem(new DistanceItem(City.NAN_JING, City.SHANG_HAI, ns));
		table.setCityItem(new DistanceItem(City.NAN_JING, City.GUANG_ZHOU, ng));
		table.setCityItem(new DistanceItem(City.BEI_JING, City.SHANG_HAI, bs));
		table.setCityItem(new DistanceItem(City.BEI_JING, City.GUANG_ZHOU, bg));
		table.setCityItem(new DistanceItem(City.SHANG_HAI, City.GUANG_ZHOU, sg));
		table.setCityItem(new DistanceItem(City.NAN_JING, City.NAN_JING, local));
		
		return table;
	}
	
	/**
	 *城市距离表在文件中的存储格式为(900.0:266.0:1132.0:1064.7:1888.8:1213.0:30.0) 
	 *分别表示南京-北京、南京-上海、南京-广州、北京-上海、北京-广州、上海-广州、同城的距离
	 */
	public boolean saveDistanceConstant(DistanceTable distance) throws RemoteException {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("data/distance.txt")));
		    Map<City, HashMap<City, Double>> table = distance.getDistanceTable();
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

	/**
	 *存储运输价格常量,用：隔开(空运：铁路：公路) 
	 */
	public boolean saveTransitPrice(TransitPrice price) throws RemoteException {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("data/transit_price.txt")));
			writer.write(price.getAir() + ":" + price.getRailway() + ":" + price.getRoad() + "\n");
			writer.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public  HashMap<String, String> getIDTable(){
		HashMap<String, String> map =new HashMap<String, String>();
		
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("data/idTable.txt"));
			String data;
			while((data=br.readLine())!=null){
				String[] s=data.split(" ");
				map.put(s[0], s[1]);
			}
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return map;
	}
}
