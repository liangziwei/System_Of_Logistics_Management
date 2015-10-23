package businessLogicImpl_stub.deliveryBLImpl_Stub;

import java.util.ArrayList;
import java.util.List;

import businessLogicService.deliveryBLService.OrderBLService;
import constant.City;
import constant.DeliveryType;
import vo.deliveryVO.ClientInfo;
import vo.deliveryVO.GoodsInfo;
import vo.deliveryVO.OrderVO;

public class OrderBLImpl_Stub implements OrderBLService{

	public OrderVO getOrderInfoById(long id) {
		List<String> names = new ArrayList<String>();
		names.add("衣服");
		return 
		new OrderVO(
			new ClientInfo("寄件人", "张三", "南京市", null, null, "12345678901"),
			new ClientInfo("收件人", "李四", "上海市", null, null, "00000000000"),
			new GoodsInfo(id, 2, names, "2*2*2", 
					"快递袋", "经济快递", "2015-10-27", "寄件人营业厅")
		);
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

}
