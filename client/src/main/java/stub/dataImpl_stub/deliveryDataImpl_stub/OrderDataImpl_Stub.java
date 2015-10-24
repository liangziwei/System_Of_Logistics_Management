package stub.dataImpl_stub.deliveryDataImpl_stub;

import java.util.List;

import constant.City;
import dataService.deliveryDataService.OrderDataService;
import po.deliveryPO.OrderPO;
import po.deliveryPO.TimeRecordPO;

public class OrderDataImpl_Stub implements OrderDataService{

	public OrderPO getOrderInfoById(String id) {
		// TODO Auto-generated method stub
//		return new OrderPO(senderInfo, receiverInfo, goodsInfo);
		return null;
	}

	public boolean saveOrderInfo(OrderPO orderPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<TimeRecordPO> getTimeRecords(City source, City destination) {
		// TODO Auto-generated method stub
		return null;
	}

}
