package stub.businessLogicImpl_stub.businessBLImpl_stub;

import po.businessPO.ReceivablePO;
import stub.dataImpl_stub.businessDataImpl_stub.PaymentDataImpl_Stub;
import vo.businessVO.ReceivableVO;
import businessLogicService.businessBLService.PaymentBLService;
import dataService.businessDataService.PaymentDataService;

public class PaymentBLImpl_Stub implements PaymentBLService{

	private PaymentDataService paymentData=new PaymentDataImpl_Stub();
	
	public boolean addPayentForm(ReceivableVO receivableVO) {
		// TODO Auto-generated method stub
		
		return paymentData.addPayentForm(receivableVOToPO(receivableVO));
	}
	
	private ReceivablePO receivableVOToPO(ReceivableVO receivableVO){
		return new ReceivablePO(receivableVO.getDate(),receivableVO.getMoney(),receivableVO.getCourier(),receivableVO.getDeliveryid());
	}

}
