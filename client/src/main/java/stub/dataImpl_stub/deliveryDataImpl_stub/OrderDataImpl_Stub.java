package stub.dataImpl_stub.deliveryDataImpl_stub;

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
		List<String> names = new ArrayList<String>();
		names.add("衣服");
		names.add("书");
		List<TransitionNode> trace = new ArrayList<TransitionNode>();
		trace.add(TransitionNode.RECEIVER_BUSINESS_HALL);
		return new OrderPO(new ClientInfo(ClientType.SENDER, "张三", "南京市", null, null, "12345678901"),
				new ClientInfo(ClientType.RECEIVER, "李四", "上海市", null, null, "00000000000"),
				new GoodsInfo(id, 2, names, "2*2*2", 
						PackageType.COURIER_BAG, DeliveryType.ECONOMIC,
						"2015-10-27", trace));
	}

	public boolean saveOrderInfo(OrderPO orderPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<TimeRecordPO> getTimeRecords(City source, City destination) {
		// TODO Auto-generated method stub
		List<TimeRecordPO> timeRecord = new ArrayList<TimeRecordPO>();
		timeRecord.add(new TimeRecordPO(City.NAN_JING, City.BEI_JING, 2));
		timeRecord.add(new TimeRecordPO(City.SHANG_HAI, City.GUANG_ZHOU, 1));
		timeRecord.add(new TimeRecordPO(City.BEI_JING, City.GUANG_ZHOU, 3));
		return timeRecord;
	}

}
