package stub.businessLogicImpl_stub.senderBLImpl_stub;

import businessLogicService.senderBLService.InquireBLService;
import dataService.senderDataService.InquireDataService.InquireDataService;
import po.senderPO.LogisticsPO;
import stub.dataImpl_stub.senderDataImpl_stub.InquireDataImpl_Stub;
import vo.senderVO.LogisticsVO;

public class InquireBLImpl_Stub implements InquireBLService{

	private InquireDataService inquire = new InquireDataImpl_Stub();
	
	public LogisticsVO getLogInfoById(String id) {
		return this.LogisticsPOToLogisticsVO(inquire.getLogInfoById(id));
	}

	private LogisticsVO LogisticsPOToLogisticsVO(LogisticsPO logisticsPO) {
		return new LogisticsVO(logisticsPO.getState(), logisticsPO.getTrace());
	}
}
