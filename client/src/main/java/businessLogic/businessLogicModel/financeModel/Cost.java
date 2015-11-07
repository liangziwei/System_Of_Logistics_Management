package businessLogic.businessLogicModel.financeModel;

import po.financePO.PaymentPO;
import mock.object.MockCostData;
import vo.financeVO.PaymentVO;
import dataService.financeDataService.CostDataService;

public class Cost {
	
	private CostDataService  costData = new MockCostData();
	
	public boolean addPayment(PaymentVO paymentVO) {
		
		return costData.addPayment(paymentVOTopaymentPO(paymentVO));
	}
	
	private PaymentPO paymentVOTopaymentPO(PaymentVO paymentVO){
		return new PaymentPO(paymentVO.getDate(),paymentVO.getPayAmount(),
				paymentVO.getName(),paymentVO.getAccount(),
				paymentVO.getEntry(),paymentVO.getRemark());
	}
}
