package stub.businessLogicImpl_stub.businessBLImpl_stub;

import java.rmi.RemoteException;

import po.businessPO.ArrivalFormPO;
import po.businessPO.SendFormPO;
import stub.dataImpl_stub.businessDataImpl_stub.ReceiveAndSendDataImpl_Stub;
import vo.businessVO.ArrivalFormVO;
import vo.businessVO.SendFormVO;
import businessLogicService.businessBLService.ReceiveAndSendBLService;
import dataService.businessDataService.ReceiveAndSendDataService;

public class ReceiveAndSendBLImpl_Stub implements ReceiveAndSendBLService{

	private ReceiveAndSendDataService receiveAndSendData=new ReceiveAndSendDataImpl_Stub();
	
	public boolean addReceiveFrom(ArrivalFormVO arrivalFormVO) {
		// TODO Auto-generated method stub
		
		try {
			return receiveAndSendData.addReceiveFrom(arrivalVOToPO(arrivalFormVO));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean addSendFrom(SendFormVO sendFormVO) {
		// TODO Auto-generated method stub
		try {
			return receiveAndSendData.addSendFrom(sendFormVOToPO(sendFormVO));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	private ArrivalFormPO arrivalVOToPO(ArrivalFormVO arrivalFormVO){
		return new ArrivalFormPO(arrivalFormVO.getDate(),arrivalFormVO.getTransitNumber(),arrivalFormVO.getDepartPlace(),arrivalFormVO.getState());
	}
	private SendFormPO sendFormVOToPO(SendFormVO sendFormVO){
		return new SendFormPO(sendFormVO.getDate(),sendFormVO.getDeliveryid(),sendFormVO.getSender());
	}
}
