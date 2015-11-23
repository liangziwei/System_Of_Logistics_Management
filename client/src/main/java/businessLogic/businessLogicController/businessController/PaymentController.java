package businessLogic.businessLogicController.businessController;

import java.rmi.RemoteException;

import vo.businessVO.ReceivableVO;
import businessLogic.businessLogicModel.businessModel.Payment;
import businessLogicService.businessBLService.PaymentBLService;

public class PaymentController implements PaymentBLService {

	private Payment payment=new Payment();
	
	public boolean addPayentForm(ReceivableVO receivableVO) {
		// TODO Auto-generated method stub
		try {
			if(payment.addPayentForm(receivableVO)){
				return true;
			}else{
				return false;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
