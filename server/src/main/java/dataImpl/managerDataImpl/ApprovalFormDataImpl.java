package dataImpl.managerDataImpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dataService.managerDataService.ApprovalFormDataService;
import po.deliveryPO.GoodsInfo;
import po.deliveryPO.OrderPO;
import po.managerPO.UncheckedFormPO;
/**
 * description:数据服务层为审批单据提供服务的具体实现
 * @author 张仁知
 */

public class ApprovalFormDataImpl implements ApprovalFormDataService{

	public UncheckedFormPO getUncheckedForms() throws RemoteException {
		List<OrderPO> po = new ArrayList<OrderPO>();
		po.add(new OrderPO(null, null, new GoodsInfo("", "", "", "",
				"", null, null, "1990-1-1", null, null, "", "")));
		return new UncheckedFormPO(null, null, null, null, null, null, null, null, null, null);
	}
}
