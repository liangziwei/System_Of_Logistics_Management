package businessLogic.businessLogicModel.businessModel;

import po.businessPO.ArrivalFormPO;
import po.businessPO.SendFormPO;
import stub.dataImpl_stub.businessDataImpl_stub.ReceiveAndSendDataImpl_Stub;
import vo.businessVO.ArrivalFormVO;
import vo.businessVO.SendFormVO;
import dataService.businessDataService.ReceiveAndSendDataService;

public class ReceiveAndSend {

	private ReceiveAndSendDataService receiveAndSendData=new ReceiveAndSendDataImpl_Stub();
	
	public boolean addReceiveFrom(ArrivalFormVO arrivalFormVO) {
		// TODO Auto-generated method stub
		
		return receiveAndSendData.addReceiveFrom(arrivalVOToPO(arrivalFormVO));
	}

	public boolean addSendFrom(SendFormVO sendFormVO) {
		// TODO Auto-generated method stub
		return receiveAndSendData.addSendFrom(sendFormVOToPO(sendFormVO));
	}

	private ArrivalFormPO arrivalVOToPO(ArrivalFormVO arrivalFormVO){
		return new ArrivalFormPO(arrivalFormVO.getDate(),arrivalFormVO.getTransitNumber(),arrivalFormVO.getDepartPlace(),arrivalFormVO.getState());
	}
	private SendFormPO sendFormVOToPO(SendFormVO sendFormVO){
		return new SendFormPO(sendFormVO.getDate(),sendFormVO.getDeliveryid(),sendFormVO.getSender());
	}
}
