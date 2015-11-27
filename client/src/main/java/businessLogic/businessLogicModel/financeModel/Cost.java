package businessLogic.businessLogicModel.financeModel;


import network.RMI;
import po.financePO.PaymentPO;
import vo.financeVO.PaymentVO;
import dataService.financeDataService.CostDataService;

public class Cost {
	
	private CostDataService  costData = RMI.<CostDataService>getDataService("cost");
	
	public boolean addPayment(PaymentVO paymentVO) {
		boolean success = false;
		try{
			success = costData.addPayment(paymentVOTopaymentPO(paymentVO));
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return success;
	}
	
	private PaymentPO paymentVOTopaymentPO(PaymentVO paymentVO){
		return new PaymentPO(paymentVO.getDate(),paymentVO.getPayAmount(),
				paymentVO.getName(),paymentVO.getAccount(),
				paymentVO.getEntry(),paymentVO.getRemark(),
				paymentVO.isApproved(), paymentVO.isPassed());
	}
}
