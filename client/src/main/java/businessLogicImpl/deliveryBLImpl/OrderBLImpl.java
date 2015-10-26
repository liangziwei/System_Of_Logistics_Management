package businessLogicImpl.deliveryBLImpl;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import businessLogicService.deliveryBLService.OrderBLService;
import constant.City;
import constant.DeliveryType;
import dataService.deliveryDataService.OrderDataService;
import po.deliveryPO.OrderPO;
import vo.deliveryVO.OrderVO;

/**
 * description:为订单信息界面提供服务的具体实现
 * @author 肖安祥
 */
public class OrderBLImpl implements OrderBLService{
	
	public OrderVO getOrderInfoById(String id) {
		OrderPO orderInfo = null;
		try {
			Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
			OrderDataService order = (OrderDataService) registry.lookup("order");
			orderInfo = order.getOrderInfoById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.OrderPOToOrderVO(orderInfo);
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
	
	private OrderVO OrderPOToOrderVO(OrderPO orderPO) {
		return new OrderVO(orderPO.getSenderInfo(), orderPO.getReceiverInfo(), orderPO.getGoodsInfo());
	}

}
