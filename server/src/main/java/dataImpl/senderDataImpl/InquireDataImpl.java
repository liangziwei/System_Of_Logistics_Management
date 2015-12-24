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
			if(temp == null) {
				return null;
			}
			po = new LogisticsPO(temp.getGoodsInfo().getTransitNode(), temp.getGoodsInfo().getCity());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return po;
	}

}
