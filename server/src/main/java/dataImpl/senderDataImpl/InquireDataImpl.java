package dataImpl.senderDataImpl;

import java.rmi.RemoteException;

import dataImpl.deliveryDataImpl.OrderDataImpl;
import dataService.deliveryDataService.OrderDataService;
import dataService.senderDataService.InquireDataService;
import po.deliveryPO.OrderPO;
import po.senderPO.LogisticsPO;

/**
 * description:数据服务层为物流信息逻辑处理提供服务的具体实现
 * @author 肖安祥
 */
public class InquireDataImpl implements InquireDataService{

	public LogisticsPO getLogInfoById(String id) {
		OrderDataService order = new OrderDataImpl();
		LogisticsPO po = null;
		try {
			OrderPO temp = order.getOrderInfoById(id);
			po = new LogisticsPO(null, temp.getGoodsInfo().getCity());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return po;
		//临时数据
//		TransitionNode state = TransitionNode.SENDER_TRANSI_CENTER;
//		List<City> trace = new ArrayList<City>();
//		trace.add(City.BEI_JING);
//		trace.add(City.NAN_JING);
//		trace.add(City.SHANG_HAI);
//		trace.add(City.GUANG_ZHOU);
//		return new LogisticsPO(state, trace);
	}

}
