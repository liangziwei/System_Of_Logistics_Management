package businessTest;

import mysql.Database;
import dataImpl.financeDataImpl.CostDataImpl;
import po.financePO.PaymentPO;

public class PaymentDataTest {
	public static void main(String[] args) {
		PaymentPO paymentPO = new PaymentPO("2015-02-11",1000.0,"李晓","南财","租金","2015");
		CostDataImpl costData = new CostDataImpl();
		System.out.println(costData.addPayment(paymentPO));
	}
}
