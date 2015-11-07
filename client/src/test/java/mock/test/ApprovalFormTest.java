package mock.test;

import static org.junit.Assert.*;
import mock.object.MockApprovalFormData;

import org.junit.Test;

public class ApprovalFormTest {

	@Test
	public void test() {
		MockApprovalFormData approval = new MockApprovalFormData();
		assertEquals(null, approval.getUncheckedForms("2015-02-14"));
	}

}
