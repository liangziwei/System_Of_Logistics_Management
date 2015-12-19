package businessLogic.businessLogicModel.businessModel;

import java.rmi.RemoteException;
import java.util.HashMap;

import network.RMI;
import network.RemoteExceptionHandler;
import vo.businessVO.ArrivalFormVO;
import vo.businessVO.SendFormVO;
import dataService.businessDataService.ReceiveAndSendDataService;
import dataService.deliveryDataService.OrderDataService;
import dataService.managerDataService.MakeConstantDataService;

public class ReceiveAndSend {
	
	private static final String REC_AND_SEND = "receiveAndSend";
	
	private static final String CONSTANT = "makeConstant";
	
	private static final String ORDER = "order";

	private ReceiveAndSendDataService receiveAndSendData=RMI.<ReceiveAndSendDataService>getDataService(REC_AND_SEND);
	
	public boolean addReceiveFrom(ArrivalFormVO arrivalFormVO) {
		// TODO Auto-generated method stub
		try {
			ReceiveAndSendDataService receiveAndSendData=RMI.<ReceiveAndSendDataService>getDataService(REC_AND_SEND);
			return receiveAndSendData.addReceiveFrom(arrivalFormVO.arrivalVOToPO());
		} catch (RemoteException e) {
			new RemoteExceptionHandler<ReceiveAndSendDataService>(REC_AND_SEND);
			e.printStackTrace();
			return false;
		}
	}

	public boolean addSendFrom(SendFormVO sendFormVO) {
		// TODO Auto-generated method stub
		MakeConstantDataService constantData=RMI.<MakeConstantDataService>getDataService(CONSTANT);
		OrderDataService order=RMI.<OrderDataService>getDataService(ORDER);
		String businessID=sendFormVO.getBusinessID();
		String deliveryID=sendFormVO.getDeliveryid();
		String place="";
		HashMap<String, String> idTable = new HashMap<String, String>();
		try {
			idTable=constantData.getIDTable();
		} catch (RemoteException e) {
			new RemoteExceptionHandler<MakeConstantDataService>(CONSTANT);
			e.printStackTrace();
			return false;
		}
		try {
			place=idTable.get(businessID.substring(0, 3))+"营业厅";
		    order.setTrace(deliveryID, place);
		} catch (RemoteException e) {
			new RemoteExceptionHandler<OrderDataService>(ORDER);
			e.printStackTrace();
			return false;
		}
		
		try {
			return receiveAndSendData.addSendFrom(sendFormVO.sendFormVOToPO());
		} catch (RemoteException e) {
			new RemoteExceptionHandler<ReceiveAndSendDataService>(REC_AND_SEND);
			e.printStackTrace();
			return false;
		}
	}

	
}
