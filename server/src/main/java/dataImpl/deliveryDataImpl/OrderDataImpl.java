package dataImpl.deliveryDataImpl;

import java.util.ArrayList;
import java.util.List;

import constant.City;
import constant.ClientType;
import constant.TransitionNode;
import dataService.deliveryDataService.OrderDataService;
import po.deliveryPO.ClientInfo;
import po.deliveryPO.OrderPO;
import po.deliveryPO.TimeRecordPO;

/**
 * description:数据服务层为订单信息处理提供服务的具体实现
 * @author 肖安祥
 */
public class OrderDataImpl implements OrderDataService{

	public OrderPO getOrderInfoById(String id){
		List<String> names = new ArrayList<String>();
		names.add("衣服");
		names.add("书");
		List<TransitionNode> trace = new ArrayList<TransitionNode>();
		trace.add(TransitionNode.RECEIVER_BUSINESS_HALL);
		return new OrderPO(new ClientInfo(ClientType.SENDER, "张三", "南京市", null, null, "12345678901"),
				new ClientInfo(ClientType.RECEIVER, "李四", "上海市", null, null, "00000000000"),
				null);
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
