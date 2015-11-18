package dataImpl.deliveryDataImpl;

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

/**
 * description:数据服务层为订单信息处理提供服务的具体实现
 * @author 肖安祥
 */
public class OrderDataImpl implements OrderDataService{

	public OrderPO getOrderInfoById(String id){
		//临时数据
		List<TransitionNode> nodes = new ArrayList<TransitionNode>();
		nodes.add(TransitionNode.RECEIVER_BUSINESS_HALL);
		List<City> citys = new ArrayList<City>();
		citys.add(City.NAN_JING);
		citys.add(City.SHANG_HAI);
		return new OrderPO(
				new ClientInfo(ClientType.SENDER, "张三", "南京大学", "可不填", "可不填", "12345678901", City.BEI_JING),
				new ClientInfo(ClientType.RECEIVER, "李四", "复旦大学", "可不填", "可不填", "00000000000", City.NAN_JING),
				new GoodsInfo("1", "1231231231", "1", "暴走漫画", "2", PackageType.COURIER_BAG,
						DeliveryType.ECONOMIC, "2015-1-1", nodes, citys, "2天", "10元"));
	}

	public boolean saveOrderInfo(OrderPO orderPO) {
		// TODO Auto-generated method stub
		return true;
	}

	public List<TimeRecordPO> getTimeRecords(City source, City destination) {
		//临时数据
		List<TimeRecordPO> t = new ArrayList<TimeRecordPO>();
		t.add(new TimeRecordPO(City.NAN_JING, City.BEI_JING, 2));
		t.add(new TimeRecordPO(City.NAN_JING, City.BEI_JING, 3));
		t.add(new TimeRecordPO(City.NAN_JING, City.BEI_JING, 4));
		return t;
	}

}
