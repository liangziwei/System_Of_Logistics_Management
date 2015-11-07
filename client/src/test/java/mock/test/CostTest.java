package mock.test;

import static org.junit.Assert.assertEquals;
import mock.object.MockCostData;

import org.junit.Test;

import businessLogic.businessLogicController.financeController.CostController;
import businessLogic.businessLogicModel.financeModel.Cost;
import po.financePO.PaymentPO;

public class CostTest {

	@Test
	public void test() {
		CostController costControl = new CostController();
		
		
		assertEquals(true, costControl.addPayment(paymentVO));
	}

}
