package stub.businessLogicImpl_stub.deliveryBLImpl_stub;

import java.rmi.RemoteException;

import businessLogicService.deliveryBLService.OrderBLService;
import constant.City;
import constant.DeliveryType;
import dataService.deliveryDataService.OrderDataService;
import po.deliveryPO.OrderPO;
import stub.dataImpl_stub.deliveryDataImpl_stub.OrderDataImpl_Stub;
import vo.deliveryVO.OrderVO;
import vo.deliveryVO.VerifyMessage;

public class OrderBLImpl_Stub implements OrderBLService{
	
	private OrderDataService order = new OrderDataImpl_Stub();

	public OrderVO getOrderInfoById(String id){
		try {
			return this.OrderPOToOrderVO(order.getOrderInfoById(id));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean saveOrderInfo(OrderVO orderVO){
		try {
			return order.saveOrderInfo(this.orderVOToOrderPO(orderVO));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public int calculateTime(City source, City destination) {
		// TODO Auto-generated method stub
		return 2;
	}

	public double calculatePrice(DeliveryType type, double weight, City source, City destination) {
		// TODO Auto-generated method stub
		return 20.5;
	}

	private OrderVO OrderPOToOrderVO(OrderPO orderPO) {
		return new OrderVO(orderPO.getSenderInfo(), orderPO.getReceiverInfo(), orderPO.getGoodsInfo());
	}

	private OrderPO orderVOToOrderPO(OrderVO orderVO) {
		return new OrderPO(orderVO.getSenderInfo(), orderVO.getReceiverInfo(), orderVO.getGoodsInfo());
	}

	public VerifyMessage verifyOrderInfo(OrderVO orderVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VerifyMessage verifyOrderId(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
