package businessLogicService.managerBLService;

import constant.City;
import constant.TransitType;

/**
 * description:业务逻辑层为制定城市距离和价格常量界面提供的服务
 * @author 张仁知
 */

public interface MakeConstantBLService {
	
	/**
	 * description:为不同的运输方式分别制定价格
	 * 前置条件：启动制定城市距离和价格常量
	 * 后置条件：在数据库中更新价格常量
	 * 需接口：MakeConstantDataService.updatePrice(double price,String transType)
	 * @param  price ,价格常量
	 * @param  transType ,运输方式
	 * @return boolean, 制定新的价格常量是否成功
	 */
	public boolean setPrice(double price,TransitType transType);
	
	/**
	 * description:为不同的城市之间分别制定距离
	 * 前置条件：启动制定城市距离和价格常量
	 * 后置条件：在数据库中更新城市距离
	 * 需接口：MakeConstantDataService.updateDistance(double distance,String source	,String destination)
	 * @param  distance ,城市距离
	 * @param  source ,出发地
	 * @param  destination ,目的地
	 * @return boolean, 制定新的城市距离是否成功
	 */
	public boolean setDistance(double distance,City source,City destination);

}
