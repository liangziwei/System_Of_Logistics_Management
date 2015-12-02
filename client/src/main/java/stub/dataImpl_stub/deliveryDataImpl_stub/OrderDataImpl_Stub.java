package stub.dataImpl_stub.deliveryDataImpl_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import constant.City;
import constant.ClientType;
import constant.DeliveryType;
import constant.PackageType;
import constant.TransitionNode;
import dataService.deliveryDataService.OrderDataService;
import po.deliveryPO.ClientInfo;
import po.deliveryPO.GoodsInfo;
import po.deliveryPO.OrderPO;
import po.deliveryPO.TimeRecordPO;

public class OrderDataImpl_Stub implements OrderDataService{
	
	public OrderPO getOrderInfoById(String id) {
		// TODO Auto-generated method stub
		List<TransitionNode> trace = new ArrayList<TransitionNode>();
		List<City> city = new ArrayList<City>();
		trace.add(TransitionNode.RECEIVER_BUSINESS_HALL);
		return new OrderPO(new ClientInfo(ClientType.SENDER, "张三", "南京市", null, null, "12345678901", City.NAN_JING),
				new ClientInfo(ClientType.RECEIVER, "李四", "上海市", null, null, "00000000000", City.SHANG_HAI),
				new GoodsInfo("1", id, "2", "衣服", "2*2*2", 
						PackageType.COURIER_BAG, DeliveryType.ECONOMIC,
						"2015-10-27", trace, city, "2", "10.3"));
	}

	public boolean saveOrderInfo(OrderPO orderPO) {
		return true;
	}

	//TODO MODIFY
	public List<TimeRecordPO> getTimeRecords(City source, City destination) {
		// TODO Auto-generated method stub
		List<TimeRecordPO> timeRecord = new ArrayList<TimeRecordPO>();
		timeRecord.add(new TimeRecordPO(City.NAN_JING, City.BEI_JING, 2));
		timeRecord.add(new TimeRecordPO(City.SHANG_HAI, City.GUANG_ZHOU, 1));
		timeRecord.add(new TimeRecordPO(City.BEI_JING, City.GUANG_ZHOU, 3));
		return timeRecord;
	}

	@Override
	public List<OrderPO> getUnCheckOrder() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUnCheckOrders(List<String> id) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUnCheckOrder(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
