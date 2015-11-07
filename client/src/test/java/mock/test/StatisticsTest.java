package mock.test;

import static org.junit.Assert.*;

import java.util.List;

import mock.object.MockStatisticsData;

import org.junit.Test;

import po.businessPO.ReceivablePO;
import po.financePO.PaymentPO;

public class StatisticsTest {

	@Test
	public void test() {
		MockStatisticsData statistics = new MockStatisticsData();
		List<ReceivablePO> ReceivableList = statistics.getReceivableList("2015-02-11", "2015-02-13");
		List<ReceivablePO> ReceivableListAll = statistics.getReceivableList();
		List<PaymentPO>	 PaymentList = statistics.getPaymentList();
	}

}
