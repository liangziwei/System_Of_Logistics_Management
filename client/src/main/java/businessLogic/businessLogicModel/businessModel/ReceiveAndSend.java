package businessLogic.businessLogicModel.businessModel;

import java.rmi.RemoteException;
import java.util.HashMap;

import network.RMI;
import vo.businessVO.ArrivalFormVO;
import vo.businessVO.SendFormVO;
import dataService.businessDataService.ReceiveAndSendDataService;
import dataService.deliveryDataService.OrderDataService;
import dataService.managerDataService.MakeConstantDataService;

public class ReceiveAndSend {

//	private ReceiveAndSendDataService receiveAndSendData=new ReceiveAndSendDataImpl_Stub();
	private ReceiveAndSendDataService receiveAndSendData=RMI.<ReceiveAndSendDataService>getDataService("receiveAndSend");
	private MakeConstantDataService constantData=RMI.<MakeConstantDataService>getDataService("makeConstant");
	private OrderDataService order=RMI.<OrderDataService>getDataService("order");
	
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
		String businessID=sendFormVO.getBusinessID();
		String deliveryID=sendFormVO.getDeliveryid();
		String place="";
		try {
			HashMap<String, String> idTable=constantData.getIDTable();
			place=idTable.get(businessID.substring(0, 3))+"营业厅";
		    order.setTrace(deliveryID, place);
			
			return receiveAndSendData.addSendFrom(sendFormVO.sendFormVOToPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	
}
