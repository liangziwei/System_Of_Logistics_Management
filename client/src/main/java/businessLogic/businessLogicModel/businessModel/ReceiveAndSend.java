package businessLogic.businessLogicModel.businessModel;

import java.rmi.RemoteException;
import java.util.HashMap;

import constant.City;
import constant.TransitionNode;
import dataService.businessDataService.ReceiveAndSendDataService;
import dataService.deliveryDataService.OrderDataService;
import dataService.managerDataService.MakeConstantDataService;
import network.RMI;
import vo.businessVO.ArrivalFormVO;
import vo.businessVO.SendFormVO;

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
			place=idTable.get(businessID.substring(0, 3));
			City city = this.strToCity(place);
			if(city != null) {
				order.setTrace(deliveryID, TransitionNode.BUSINESS_HALL, city);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		
		try {
			return receiveAndSendData.addSendFrom(sendFormVO.sendFormVOToPO());
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

	private City strToCity(String city) {
		switch(city) {
		case "南京":
			return City.NAN_JING;
		case "北京":
			return City.BEI_JING;
		case "上海":
			return City.SHANG_HAI;
		case "广州":
			return City.GUANG_ZHOU;
		}
		return null;
	}
}
