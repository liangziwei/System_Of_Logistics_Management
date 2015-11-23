package mock.test;

import static org.junit.Assert.*;

import org.junit.Test;

import businessLogic.businessLogicController.managerController.ApprovalFormController;

public class ApprovalFormTest {

	@Test
	public void test() {
		ApprovalFormController approval = new ApprovalFormController();
		assertEquals(null, approval.getUncheckedForms("2015-02-14"));
	}

}
