package businessLogic.businessLogicModel.managerModel;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import constant.City;
import constant.PackageType;
import constant.TransitType;
import dataService.managerDataService.MakeConstantDataService;
import network.RMI;
import po.constant.DistanceTable;
import po.constant.PackPrice;
import po.constant.TransitPrice;

public class MakeConstant {
	
	private MakeConstantDataService makeConstant = RMI.<MakeConstantDataService>getDataService("makeConstant");
	
	/**
	 *城市距离表 
	 */
	private DistanceTable distance;
	
	/**
	 *快递包装价格常量 
	 */
	private PackPrice pack;
	
	/**
	 *运输价格常量 
	 */
	private TransitPrice transit;
	
	/**
	 *运输类型与运输价格的映射表 
	 */
	private Map<TransitType, Double> transitPriceMap = new HashMap<TransitType, Double>();
	
	/**
	 *快递包装类型与包装价格的映射表 
	 */
	private Map<PackageType, Double> packPriceMap = new HashMap<PackageType, Double>();
	
	public MakeConstant() {
		try {
			this.distance = this.makeConstant.getDistantceConstant();
			this.pack = this.makeConstant.getPackPrice();
			this.transit = this.makeConstant.getTransitPrice();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		//初始化运输费用的映射表
		this.transitPriceMap.put(TransitType.AIR, this.transit.getAir());
		this.transitPriceMap.put(TransitType.RAILWAY, this.transit.getRailway());
		this.transitPriceMap.put(TransitType.ROAD, this.transit.getRoad());
		//初始化快递包装价格的映射表
		this.packPriceMap.put(PackageType.CARTON, this.pack.getCarton());
		this.packPriceMap.put(PackageType.WOODEN, this.pack.getWooden());
		this.packPriceMap.put(PackageType.COURIER_BAG, this.pack.getCourierBag());
		this.packPriceMap.put(PackageType.OTHER, this.pack.getOther());
	}
	
	/**
	 *将城市距离常量设置到服务端 
	 */
	public boolean setDistance(DistanceTable distance) {
		try{
			return this.makeConstant.saveDistanceConstant(distance);
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 *获得城市距离表 
	 */
	public Map<City, HashMap<City, Double>> getDistance() {
		return this.distance.getDistanceTable();
	}
	
	/**
	 *根据出发地和目的地获得两地的距离 
	 */
	public double getDistance(City source, City dest) {
		return this.distance.getDistanceTable().get(source).get(dest);
	}
	
	/**
	 *从服务端获得快递包装费价格常量 
	 */
	public PackPrice getPackPrice() {
		return this.pack;
	}

	/**
	 *将快递包装费常量存储到服务端 
	 */
	public boolean setPackPrice(PackPrice price) {
		try {
			return this.makeConstant.savePackPrice(price);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 *根据快递包装类型获得包装的价格 
	 */
	public double getPackPrice(PackageType type) {
		return this.packPriceMap.get(type);
	}

	/**
	 *将运输价格常量保存到服务端 
	 */
	public boolean setTransitPrice(TransitPrice price) {
		try {
			return this.makeConstant.saveTransitPrice(price);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 *从服务端获得运输价格常量 
	 */
	public TransitPrice getTransitPrice() {
		return this.transit;
	}
	
	/**
	 *根据运输类型获得相应运输费用常量 
	 */
	public double getTransitPrice(TransitType type) {
		return this.transitPriceMap.get(type);
	}

}
