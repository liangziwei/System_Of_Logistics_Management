package mock.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
		List<ReceivablePO> receivable = new ArrayList<ReceivablePO>();
		ArrayList<String> deliveryid1 = new ArrayList<String>();
		ArrayList<String> deliveryid2 = new ArrayList<String>();
		ArrayList<String> deliveryid3 = new ArrayList<String>();
		deliveryid1.add("1234567890");
		deliveryid1.add("1245678952");
		deliveryid2.add("1245678552");
		deliveryid2.add("1245453122");
		deliveryid2.add("1245678212");
		deliveryid3.add("1245655542");
		deliveryid3.add("1245658952");
		deliveryid3.add("1245675152");
		receivable.add(new ReceivablePO("2015-02-11",100.0,"小红",deliveryid1));
		receivable.add(new ReceivablePO("2015-02-12",120.0,"小李",deliveryid2));
		receivable.add(new ReceivablePO("2015-02-13",145.0,"小王",deliveryid3));
		List<ReceivablePO> receivableAll = new ArrayList<ReceivablePO>();
		ArrayList<String> delivery1 = new ArrayList<String>();
		ArrayList<String> delivery2 = new ArrayList<String>();
		ArrayList<String> delivery3 = new ArrayList<String>();
		delivery1.add("1234567890");
		delivery1.add("1245678952");
		delivery2.add("1245678552");
		delivery2.add("1245453122");
		delivery2.add("1245678212");
		delivery3.add("1245655542");
		delivery3.add("1245658952");
		delivery3.add("1245675152");
		receivableAll.add(new ReceivablePO("2015-02-11",100.0,"小红",delivery1));
		receivableAll.add(new ReceivablePO("2015-02-12",120.0,"小李",delivery2));
		receivableAll.add(new ReceivablePO("2015-02-13",145.0,"小王",delivery3));
		List<PaymentPO> payment = new ArrayList<PaymentPO>();
		payment.add(new PaymentPO("2015-05-12", 10000.0, "李小龙",
			"南京大学", "人员工资", "2015年3月"));
		payment.add(new PaymentPO("2015-05-12", 1000000.0, "张华",
				"南京大学", "租金", "2015年"));
		payment.add(new PaymentPO("2015-05-15", 10000.0, "向华胜",
				"南京大学", "人员工资", "2015年4月"));
		assertEquals(receivable.size(), ReceivableList.size());
		for(int i=0;i<receivable.size();i++){
			assertEquals(receivable.get(i).getCourier(), ReceivableList.get(i).getCourier());
			assertEquals(receivable.get(i).getDate(), ReceivableList.get(i).getDate());
			assertEquals(receivable.get(i).getDeliveryid(), ReceivableList.get(i).getDeliveryid());
			assertEquals(receivable.get(i).getMoney(), ReceivableList.get(i).getMoney(),0.01);
		}
		assertEquals(receivableAll.size(), ReceivableListAll.size());
		for(int i=0;i<receivableAll.size();i++){
			assertEquals(receivableAll.get(i).getCourier(), ReceivableListAll.get(i).getCourier());
			assertEquals(receivableAll.get(i).getDate(), ReceivableListAll.get(i).getDate());
			assertEquals(receivableAll.get(i).getDeliveryid(), ReceivableListAll.get(i).getDeliveryid());
			assertEquals(receivableAll.get(i).getMoney(), ReceivableListAll.get(i).getMoney(),0.01);
		}
		assertEquals(payment.size(), PaymentList.size());
		for(int i=0;i<payment.size();i++){
			assertEquals(payment.get(i).getAccount(), PaymentList.get(i).getAccount());
			assertEquals(payment.get(i).getDate(), PaymentList.get(i).getDate());
			assertEquals(payment.get(i).getEntry(), PaymentList.get(i).getEntry());
			assertEquals(payment.get(i).getName(), PaymentList.get(i).getName());
			assertEquals(payment.get(i).getPayAmount(), PaymentList.get(i).getPayAmount(),0.01);
			assertEquals(payment.get(i).getRemark(), PaymentList.get(i).getRemark());
		}
	}

}
