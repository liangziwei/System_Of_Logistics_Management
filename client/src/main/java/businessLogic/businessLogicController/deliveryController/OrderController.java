package businessLogic.businessLogicController.deliveryController;

import businessLogic.businessLogicModel.deliveryModel.OrderModel;
import businessLogicService.deliveryBLService.OrderBLService;
import constant.City;
import constant.DeliveryType;
import vo.deliveryVO.OrderVO;
import vo.deliveryVO.VerifyMessage;

/**
 * description:为订单信息界面提供服务的控制器
 * @author 肖安祥
 */
public class OrderController implements OrderBLService{
	
	private OrderModel order = new OrderModel();
	
	public OrderVO getOrderInfoById(String id) {
		return this.order.getOrderInfoById(id);
	}

	public boolean saveOrderInfo(OrderVO orderVO) {
		return this.order.saveOrderInfo(orderVO);
	}

	public int calculateTime(City source, City destination) {
		return this.order.calculateTime(source, destination);
	}

	public double calculatePrice(DeliveryType type, double weight, City source, City destination) {
		return OrderModel.calculatePrice(type, weight, source, destination);
	}
	
	public VerifyMessage verifyOrderInfo(OrderVO orderVO) {
		return OrderModel.verifyOrderInfo(orderVO);
		
	}
	
	public VerifyMessage verifyOrderId(String id) {
		return OrderModel.verifyOrderId(id);
	}
}
