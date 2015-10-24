package stub.businessLogicImpl_stub.deliveryBLImpl_stub;

import java.util.ArrayList;
import java.util.List;

import businessLogicService.deliveryBLService.OrderBLService;
import constant.City;
import constant.ClientType;
import constant.DeliveryType;
import constant.PackageType;
import constant.TransitionNode;
import vo.deliveryVO.ClientInfo;
import vo.deliveryVO.GoodsInfo;
import vo.deliveryVO.OrderVO;

public class OrderBLImpl_Stub implements OrderBLService{

	public OrderVO getOrderInfoById(String id) {
		List<String> names = new ArrayList<String>();
		names.add("衣服");
		List<TransitionNode> trace = new ArrayList<TransitionNode>();
		trace.add(TransitionNode.RECEIVER_BUSINESS_HALL);
		trace.add(TransitionNode.RECEIVER);
		return 
		new OrderVO(
			new ClientInfo(ClientType.SENDER, "张三", "南京市", null, null, "12345678901"),
			new ClientInfo(ClientType.RECEIVER, "李四", "上海市", null, null, "00000000000"),
			new GoodsInfo(id, 2, names, "2*2*2", 
					PackageType.COURIER_BAG, DeliveryType.ECONOMIC,
					"2015-10-27", trace)
		);
	}

	public boolean saveOrderInfo(OrderVO orderVO) {
		// TODO Auto-generated method stub
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

}
