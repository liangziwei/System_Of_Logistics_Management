package businessLogic.businessLogicModel.businessModel;

import java.rmi.RemoteException;

import dataService.businessDataService.PaymentDataService;
import network.RMI;
import vo.businessVO.ReceivableVO;

public class Payment {
	
	private static final String KEY = "receivable";

	private PaymentDataService paymentData=RMI.<PaymentDataService>getDataService(KEY);
	
	public boolean addPayentForm(ReceivableVO receivableVO) {
		// TODO Auto-generated method stub
		
		try {
			return paymentData.addPayentForm(receivableVO.receivableVOToPO());
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
