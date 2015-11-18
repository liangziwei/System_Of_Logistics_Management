package stub.businessLogicImpl_stub.senderBLImpl_stub;

import java.rmi.RemoteException;

import businessLogicService.senderBLService.InquireBLService;
import dataService.senderDataService.InquireDataService;
import po.senderPO.LogisticsPO;
import stub.dataImpl_stub.senderDataImpl_stub.InquireDataImpl_Stub;
import vo.senderVO.LogisticsVO;

public class InquireBLImpl_Stub implements InquireBLService{

	private InquireDataService inquire = new InquireDataImpl_Stub();
	
	public LogisticsVO getLogInfoById(String id) {
		LogisticsPO po = null;
		try {
			po = inquire.getLogInfoById(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//如果不存在该订单条形码号
		if(!po.isExit()) {
			return null;
		}
		return this.LogisticsPOToLogisticsVO(po);
	}

	private LogisticsVO LogisticsPOToLogisticsVO(LogisticsPO logisticsPO) {
		return new LogisticsVO(logisticsPO.getState(), logisticsPO.getTrace());
	}
}
