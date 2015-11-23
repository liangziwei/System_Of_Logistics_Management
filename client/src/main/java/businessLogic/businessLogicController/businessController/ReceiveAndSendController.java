package businessLogic.businessLogicController.businessController;

import vo.businessVO.ArrivalFormVO;
import vo.businessVO.SendFormVO;
import businessLogic.businessLogicModel.businessModel.ReceiveAndSend;
import businessLogicService.businessBLService.ReceiveAndSendBLService;

public class ReceiveAndSendController implements ReceiveAndSendBLService{

	private ReceiveAndSend receiveAndSend=new ReceiveAndSend();
	public boolean addReceiveFrom(ArrivalFormVO arrivalFormVO) {
		// TODO Auto-generated method stub
		return receiveAndSend.addReceiveFrom(arrivalFormVO);
	}

	public boolean addSendFrom(SendFormVO sendFormVO) {
		// TODO Auto-generated method stub
		return receiveAndSend.addSendFrom(sendFormVO);
	}

}
