package businessLogic.businessLogicModel.senderModel;

import java.rmi.RemoteException;

import dataService.senderDataService.InquireDataService.InquireDataService;
import network.RMI;
import po.senderPO.LogisticsPO;
import vo.senderVO.LogisticsVO;

/**
 * description:为物流信息界面提供服务的具体实现
 * @author 肖安祥
 */
public class InquireModel{
	
	private InquireDataService inquire = RMI.<InquireDataService>getDataService("inquire");

	public LogisticsVO getLogInfoById(String id) {
		LogisticsPO logistics = null;
		try {
			logistics = this.inquire.getLogInfoById(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return LogisticsPO.LogisticsPOToVO(logistics);
	}

}
