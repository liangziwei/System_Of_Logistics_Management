package businessLogic.businessLogicController.transitionController;

import businessLogic.businessLogicModel.transitionModel.Receiving;
import businessLogicService.transitionBLService.ReceivingBLService;
import vo.transitionVO.LoadingVO;
import vo.transitionVO.ReceivingVO;

public class ReceivingController implements ReceivingBLService{
	Receiving receiving = new Receiving();
	public boolean addReceivingFormBL(ReceivingVO receivingVO) {
		// TODO Auto-generated method stub
		return receiving.addReceivingFormBL(receivingVO);
	}

	public boolean modifyReceivingFormBL(ReceivingVO receivingVO) {
		// TODO Auto-generated method stub
		return receiving.modifyReceivingFormBL(receivingVO);
	}

	public ReceivingVO findReceivingformBL(String receivingNumber) {
		// TODO Auto-generated method stub
		return receiving.findReceivingformBL(receivingNumber);
	}
	
	public boolean verify(ReceivingVO receivingVO) {
		// TODO Auto-generated method stub
		boolean result = receiving.verifyres(receivingVO);
		return result;
	}
}
