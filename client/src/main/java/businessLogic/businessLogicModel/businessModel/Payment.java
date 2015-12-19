package businessLogic.businessLogicModel.businessModel;

import java.rmi.RemoteException;

import stub.dataImpl_stub.businessDataImpl_stub.PaymentDataImpl_Stub;
import vo.businessVO.ReceivableVO;
import dataService.businessDataService.PaymentDataService;
import network.RemoteExceptionHandler;

public class Payment {
	
	private static final String KEY = "receivable";

	private PaymentDataService paymentData=new PaymentDataImpl_Stub();
//	private PaymentDataService paymentData=RMI.<PaymentDataService>getDataService("receivable");
	
	public boolean addPayentForm(ReceivableVO receivableVO) {
		// TODO Auto-generated method stub
		
		try {
			return paymentData.addPayentForm(receivableVO.receivableVOToPO());
		} catch (RemoteException e) {
			new RemoteExceptionHandler<PaymentDataService>(KEY);
			e.printStackTrace();
			return false;
		}
	}
	
}
