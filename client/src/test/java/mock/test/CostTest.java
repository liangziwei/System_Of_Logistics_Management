package mock.test;

import static org.junit.Assert.assertEquals;
import mock.object.MockCostData;

import org.junit.Test;

import po.financePO.PaymentPO;

public class CostTest {

	@Test
	public void test() {
		MockCostData cost = new MockCostData();
		PaymentPO paymentPO = new PaymentPO(null,0.0,null,null,null,null);
		assertEquals(true, cost.addPayment(paymentPO));
	}

}
