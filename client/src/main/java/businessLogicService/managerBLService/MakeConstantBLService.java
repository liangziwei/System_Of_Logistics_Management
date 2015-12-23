package businessLogicService.managerBLService;

import java.util.HashMap;
import java.util.Map;

import constant.City;
import po.constant.DistanceTable;
import po.constant.PackPrice;
import po.constant.TransitPrice;

/**
 * description:业务逻辑层为制定城市距离和价格常量界面提供的服务
 * @author 张仁知
 */

public interface MakeConstantBLService {
	
	/**
	 * description:为不同的城市之间分别制定距离
	 * 前置条件：启动制定城市距离和价格常量
	 * 后置条件：在数据库中更新城市距离
	 * 需接口：MakeConstantDataService.updateDistance(double distance,String source	,String destination)
	 * @param  distance ,城市距离表，具体参见DistanceConstant的定义
	 * @return boolean, 制定新的城市距离是否成功
	 */
	public boolean setDistance(DistanceTable distance);
	
	/**
	 * 获得城市距离表数据
	 */
	public Map<City, HashMap<City, Double>> getDistance();
	
	/**
	 *设置快递包装费价格常量 
	 */
	public boolean setPackPrice(PackPrice price);
	
	/**
	 *获得快递包装费价格常量 
	 */
	public PackPrice getPackPrice();
	
	/**
	 *保存运输费用常量 
	 */
	public boolean setTransitPrice(TransitPrice price);
	
	/**
	 *获得运输费用常量 
	 */
	public TransitPrice getTransitPrice();
	
}
