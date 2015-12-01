package rmiTest.businessRMI;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import vo.businessVO.ReceivableVO;
import businessLogic.businessLogicController.businessController.PaymentController;

public class paymentRMI {

	@Test
	public void test() {
		ArrayList<String> s=new ArrayList<String>();
		s.add("1234567890");
		ReceivableVO receivableVO=new ReceivableVO("2015-11-22",220,"二黄",s);
		PaymentController paymentCon=new PaymentController();
		assertEquals(true,paymentCon.addPayentForm(receivableVO));
	}

}
