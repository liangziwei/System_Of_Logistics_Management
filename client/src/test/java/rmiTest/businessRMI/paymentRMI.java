package rmiTest.businessRMI;

import java.util.ArrayList;

import org.junit.Test;

import businessLogic.businessLogicController.businessController.PaymentController;

public class paymentRMI {

	@SuppressWarnings("unused")
	@Test
	public void test() {
		ArrayList<String> s=new ArrayList<String>();
		s.add("1234567890");
//		ReceivableVO receivableVO=new ReceivableVO("2015-11-22",220,"二黄",s);
		PaymentController paymentCon=new PaymentController();
//		assertEquals(true,paymentCon.addPayentForm(receivableVO));
	}

}
