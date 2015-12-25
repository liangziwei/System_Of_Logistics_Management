package businessLogic.businessLogicController.managerController;

import java.util.HashMap;
import java.util.Map;

import businessLogic.businessLogicModel.managerModel.MakeConstant;
import businessLogicService.managerBLService.MakeConstantBLService;
import constant.City;
import po.constant.DistanceTable;
import po.constant.PackPrice;
import po.constant.TransitPrice;
/**
 * description:为制定城市距离和价格常量界面提供服务的具体实现
 * @author 张仁知
 *
 */

public class MakeConstantController implements MakeConstantBLService{
	
	private MakeConstant makeconstant = new MakeConstant();
	
	@Override
	public boolean setDistance(DistanceTable distance) {
		return this.makeconstant.setDistance(distance);
	}

	@Override
	public Map<City, HashMap<City, Double>> getDistance() {
		return this.makeconstant.getDistance();
	}

	@Override
	public PackPrice getPackPrice() {
		return this.makeconstant.getPackPrice();
	}

	public boolean setPackPrice(PackPrice price) {
		return this.makeconstant.setPackPrice(price);
	}

	@Override
	public boolean setTransitPrice(TransitPrice price) {
		return this.makeconstant.setTransitPrice(price);
	}

	@Override
	public TransitPrice getTransitPrice() {
		return this.makeconstant.getTransitPrice();
	}
}

	