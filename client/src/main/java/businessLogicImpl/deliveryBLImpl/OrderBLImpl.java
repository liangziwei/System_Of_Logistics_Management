package businessLogicImpl.deliveryBLImpl;

import businessLogicService.deliveryBLService.OrderBLService;
import vo.deliveryVO.OrderVO;

/**
 * description:为订单信息界面提供服务的具体实现
 * @author 肖安祥
 * */
public class OrderBLImpl implements OrderBLService{

	public OrderVO getOrderInfoById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean saveOrderInfo(OrderVO orderVO) {
		// TODO Auto-generated method stub
		return false;
	}

	public int calculateTime(String source, String destination) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double calculatePrice(int type, double weight, String source, String destination) {
		// TODO Auto-generated method stub
		return 0;
	}

}
