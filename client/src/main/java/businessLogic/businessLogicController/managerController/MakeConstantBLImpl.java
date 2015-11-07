package businessLogic.businessLogicController.managerController;

import businessLogicService.managerBLService.MakeConstantBLService;
import constant.City;
import constant.TransitType;
/**
 * description:为制定城市距离和价格常量界面提供服务的具体实现
 * @author 张仁知
 *
 */

public class MakeConstantBLImpl implements MakeConstantBLService{
	
	public boolean setPrice(double price,TransitType transType) {
		return false;
	}
	
	public boolean setDistance(double distance,City source,City destination) {
		return false;
	}

}

	