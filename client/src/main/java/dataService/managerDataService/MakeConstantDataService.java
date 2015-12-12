package dataService.managerDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

import po.constant.DistanceTable;
import po.constant.PackPrice;
import po.constant.TransitPrice;

/**
 * description:数据服务层为制定城市距离和价格常量逻辑处理提供的服务
 * @author 张仁知
 */
public interface MakeConstantDataService extends Remote{

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
	 * 保存运费价格常量
	 */
	public boolean saveTransitPrice(TransitPrice price) throws RemoteException;
	
	/**
	 * 获得距离常量(城市之间路线的距离)
	 */
	public DistanceTable getDistantceConstant() throws RemoteException;
	
	/**
	 * 保存距离常量
	 */
	public boolean saveDistanceConstant(DistanceTable distance) throws RemoteException;
	
	/**
	 * 获取城市与城市编号的表
	 */
	public  HashMap<String, String> getIDTable() throws RemoteException;
}
