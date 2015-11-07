package businessLogic.businessLogicController.managerController;

import businessLogic.businessLogicModel.managerModel.MakeConstant;
import businessLogicService.managerBLService.MakeConstantBLService;
import constant.City;
import constant.TransitType;
/**
 * description:为制定城市距离和价格常量界面提供服务的具体实现
 * @author 张仁知
 *
 */

public class MakeConstantController implements MakeConstantBLService{
	
	private MakeConstant makeconstant = new MakeConstant();
	
	public boolean setPrice(double price,TransitType transType) {
		return makeconstant.setPrice(price, transType);
	}
	
	public boolean setDistance(double distance,City source,City destination) {
		return makeconstant.setDistance(distance, source, destination);
	}

}

	