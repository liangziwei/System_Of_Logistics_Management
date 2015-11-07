package businessLogic.businessLogicController.businessController;

import vo.businessVO.ReceivableVO;
import businessLogic.businessLogicModel.businessModel.Payment;
import businessLogicService.businessBLService.PaymentBLService;

public class PaymentController implements PaymentBLService {

	private Payment payment=new Payment();
	
	public boolean addPayentForm(ReceivableVO receivableVO) {
		// TODO Auto-generated method stub
		return payment.addPayentForm(receivableVO);
	}

}
