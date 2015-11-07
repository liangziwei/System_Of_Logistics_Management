package mock.test;

import static org.junit.Assert.assertEquals;
import mock.object.MockCostData;

import org.junit.Test;

import businessLogic.businessLogicController.financeController.CostController;
import businessLogic.businessLogicModel.financeModel.Cost;
import po.financePO.PaymentPO;
import vo.financeVO.PaymentVO;

public class CostTest {

	@Test
	public void test() {
		CostController costControl = new CostController();
		PaymentVO paymentVO = new PaymentVO(null, 100.0, null, null, null, null);		
		assertEquals(true, costControl.addPayment(paymentVO));
	}

}
