package stub.businessLogicImpl_stub.financeBLImpl_stub;

import po.financePO.PaymentPO;
import stub.dataImpl_stub.financeDataImpl_stub.CostDataImpl_Stub;
import vo.financeVO.PaymentVO;
import businessLogicService.financeBLService.CostBLService;
import dataService.financeDataService.CostDataService;

public class CostBLImpl_Stub implements CostBLService{
	private CostDataService cost = new CostDataImpl_Stub();
	public boolean addPayment(PaymentVO paymentVO) {
		return cost.addPayment(paymentVOTopaymentPO(paymentVO));
		}
	private PaymentPO paymentVOTopaymentPO(PaymentVO paymentVO){
		return new PaymentPO(paymentVO.getDate(),paymentVO.getPayAmount(),
				paymentVO.getName(),paymentVO.getAccount(),
				paymentVO.getEntry(),paymentVO.getRemark());
	}
}
