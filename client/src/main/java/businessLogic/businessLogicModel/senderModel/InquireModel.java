package businessLogic.businessLogicModel.senderModel;

import dataService.senderDataService.InquireDataService.InquireDataService;
import stub.dataImpl_stub.senderDataImpl_stub.InquireDataImpl_Stub;
import vo.senderVO.LogisticsVO;

/**
 * description:为物流信息界面提供服务的具体实现
 * @author 肖安祥
 */
public class InquireModel{
	
	private InquireDataService inquire = new InquireDataImpl_Stub();

	public LogisticsVO getLogInfoById(String id) {
//		this.inquire.getLogInfoById(id);
		return null;
	}

}
