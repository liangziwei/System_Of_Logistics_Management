package dataService.managerDataService;

import constant.City;
import constant.TransitType;

/**
 * description:数据服务层为制定城市距离和价格常量逻辑处理提供的服务
 * @author 张仁知
 */
public interface MakeConstantDataService {

	/**
	 * description:更新不同的运输方式的价格
	 * 前置条件：无
	 * 后置条件：在数据库中更新价格常量
	 * @param  price ,价格常量
	 * @param  transType ,运输方式
	 * @return boolean, 更新价格常量是否成功
	 */
	public boolean updatePrice(double price,TransitType transType);
	
	/**
	 * description:更新不同的城市之间的距离
	 * 前置条件：无
	 * 后置条件：在数据库中更新城市距离
	 * @param  distance ,城市距离
	 * @param  source ,出发地
	 * @param  destination ,目的地
	 * @return boolean, 更新城市距离是否成功
	 */
	public boolean updateDistance(double distance,City source,City destination);
}
