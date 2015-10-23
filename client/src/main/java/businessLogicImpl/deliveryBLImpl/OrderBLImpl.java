package businessLogicImpl.deliveryBLImpl;

import businessLogicService.deliveryBLService.OrderBLService;
import constant.City;
import constant.DeliveryType;
import vo.deliveryVO.OrderVO;

/**
 * description:为订单信息界面提供服务的具体实现
 * @author 肖安祥
 */
public class OrderBLImpl implements OrderBLService{

	public OrderVO getOrderInfoById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean saveOrderInfo(OrderVO orderVO) {
		// TODO Auto-generated method stub
		return false;
	}

	public int calculateTime(City source, City destination) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double calculatePrice(DeliveryType type, double weight, City source, City destination) {
		// TODO Auto-generated method stub
		return 0;
	}

}
