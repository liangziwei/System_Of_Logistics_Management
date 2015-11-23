package businessLogic.businessLogicModel.businessModel;

import java.rmi.RemoteException;

import network.RMI;
import po.businessPO.ReceivablePO;
import stub.dataImpl_stub.businessDataImpl_stub.PaymentDataImpl_Stub;
import vo.businessVO.ReceivableVO;
import dataService.businessDataService.PaymentDataService;

public class Payment {

	private PaymentDataService paymentData=new PaymentDataImpl_Stub();
//	private PaymentDataService paymentData=RMI.<PaymentDataService>getDataService("receivable");
	
	public boolean addPayentForm(ReceivableVO receivableVO) throws RemoteException {
		// TODO Auto-generated method stub
		
		return paymentData.addPayentForm(receivableVOToPO(receivableVO));
	}
	
	private ReceivablePO receivableVOToPO(ReceivableVO receivableVO){
		return new ReceivablePO(receivableVO.getDate(),receivableVO.getMoney(),receivableVO.getCourier(),receivableVO.getDeliveryid());
	}
}
