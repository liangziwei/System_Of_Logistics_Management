package stub.dataImpl_stub.financeDataImpl_stub;

import java.util.ArrayList;
import java.util.List;

import po.businessPO.ReceivablePO;
import po.financePO.PaymentPO;
import dataService.financeDataService.StatisticsDataService;

public class StatisticsDataImpl_Stub implements StatisticsDataService {
	public List<ReceivablePO> getReceivableList(String startDate,String endDate) {
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
		return receivable;
	}
	
	public List<ReceivablePO> getReceivableList() {
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
		return receivable;
	}
	
	public List<PaymentPO>	getPaymentList() {
		List<PaymentPO> payment = new ArrayList<PaymentPO>();
//		payment.add(new PaymentPO("2015-05-12", 10000.0, "李小龙",
//			"南京大学", "人员工资", "2015年3月"));
//		payment.add(new PaymentPO("2015-05-12", 1000000.0, "张华",
//				"南京大学", "租金", "2015年"));
//		payment.add(new PaymentPO("2015-05-15", 10000.0, "向华胜",
//				"南京大学", "人员工资", "2015年4月"));
		return payment;
	}
}
