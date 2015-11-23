package mock.object;

import po.financePO.PaymentPO;
import dataService.financeDataService.CostDataService;

public class MockCostData implements CostDataService{
	public boolean addPayment(PaymentPO paymentPO){
		return true;
	}
}
