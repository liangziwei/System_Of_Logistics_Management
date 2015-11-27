package dataService.deliveryDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.deliveryPO.DistanceConstant;
import po.deliveryPO.PackPrice;
import po.deliveryPO.TransitPrice;

public interface ConstantDataService extends Remote{

	/**
	 * 获得包装价格常量(包装费用：纸箱、木箱、快递袋、其他)
	 */
	public PackPrice getPackPrice() throws RemoteException;
	
	/**
	 * 保存包装价格常量
	 */
	public boolean savePackPrice(PackPrice price) throws RemoteException;
	
	/**
	 *获得运费价格常量 
	 */
	public TransitPrice getTransitPrice() throws RemoteException;
	
	/**
	 *保存运费价格常量 
	 */
	public void saveTransitPrice(TransitPrice price) throws RemoteException;
	
	/**
	 * 获得距离常量(城市之间路线的距离)
	 */
	public DistanceConstant getDistantceConstant() throws RemoteException;
	
	/**
	 * 保存距离常量
	 */
	public boolean saveDistanceConstant(DistanceConstant distance) throws RemoteException;
	
}
