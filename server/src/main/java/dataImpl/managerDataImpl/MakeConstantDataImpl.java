package dataImpl.managerDataImpl;

import constant.City;
import constant.TransitType;
import dataService.managerDataService.MakeConstantDataService;

/**
 * description:数据服务层为制定城市距离和价格常量提供服务的具体实现
 * @author 张仁知
 */
public class MakeConstantDataImpl implements MakeConstantDataService{

	public boolean updatePrice(double price,TransitType transType) {
		return false;
	}
	
	public boolean updateDistance(double distance,City source	,City destination) {
		return false;
	}
}
