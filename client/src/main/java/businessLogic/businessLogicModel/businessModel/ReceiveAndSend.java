package businessLogic.businessLogicModel.businessModel;

import java.rmi.RemoteException;

import network.RMI;
import po.businessPO.ArrivalFormPO;
import po.businessPO.SendFormPO;
import stub.dataImpl_stub.businessDataImpl_stub.ReceiveAndSendDataImpl_Stub;
import vo.businessVO.ArrivalFormVO;
import vo.businessVO.SendFormVO;
import dataService.businessDataService.ReceiveAndSendDataService;

public class ReceiveAndSend {

	private ReceiveAndSendDataService receiveAndSendData=new ReceiveAndSendDataImpl_Stub();
//	private ReceiveAndSendDataService receiveAndSendData=RMI.<ReceiveAndSendDataService>getDataService("receiveAndSend");
	
	public boolean addReceiveFrom(ArrivalFormVO arrivalFormVO) {
		// TODO Auto-generated method stub
		
		try {
			return receiveAndSendData.addReceiveFrom(arrivalFormVO.arrivalVOToPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean addSendFrom(SendFormVO sendFormVO) {
		// TODO Auto-generated method stub
		try {
			return receiveAndSendData.addSendFrom(sendFormVO.sendFormVOToPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	
}
