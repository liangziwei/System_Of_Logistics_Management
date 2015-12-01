package dataImpl.financeDataImpl;

import java.util.ArrayList;
import java.util.List;

import dataService.financeDataService.StatisticsDataService;
import po.businessPO.ReceivablePO;
import po.financePO.PaymentPO;

/**
 * description:数据服务层为成本经营统计分析提供服务的具体实现
 * @author 张仁知
 */
public class StatisticsDataImpl implements StatisticsDataService{

	public List<ReceivablePO> getReceivableList(String startDate,String endDate) {
		List<ReceivablePO> receivable = new ArrayList<ReceivablePO>();
		ArrayList<String> deliveryid1 = new ArrayList<String>();
		ArrayList<String> deliveryid2 = new ArrayList<String>();
		ArrayList<String> deliveryid3 = new ArrayList<String>();
		ArrayList<String> deliveryid4 = new ArrayList<String>();
		deliveryid1.add("1234567890");
		deliveryid1.add("1245678952");
		deliveryid2.add("1245678552");
		deliveryid2.add("1245453122");
		deliveryid2.add("1245678212");
		deliveryid3.add("1245655542");
		deliveryid3.add("1245658952");
		deliveryid3.add("1245675152");
		deliveryid4.add("1245678212");
		deliveryid4.add("1245655542");
		deliveryid4.add("1245658952");
		deliveryid4.add("1245675152");
		receivable.add(new ReceivablePO("2015-02-11",100.0,"1",deliveryid1));
		receivable.add(new ReceivablePO("2015-02-11",120.0,"2",deliveryid2));
		receivable.add(new ReceivablePO("2015-02-11",145.0,"3",deliveryid3));
		receivable.add(new ReceivablePO("2015-02-11",145.0,"4",deliveryid4));
		receivable.add(new ReceivablePO("2015-02-11",145.0,"5",deliveryid4));
		receivable.add(new ReceivablePO("2015-02-11",145.0,"6",deliveryid4));
		return receivable;
	}
	
	public List<ReceivablePO> getReceivableList() {
		List<ReceivablePO> receivable = new ArrayList<ReceivablePO>();
		ArrayList<String> deliveryid1 = new ArrayList<String>();
		ArrayList<String> deliveryid2 = new ArrayList<String>();
		ArrayList<String> deliveryid3 = new ArrayList<String>();
		ArrayList<String> deliveryid4 = new ArrayList<String>();
		deliveryid1.add("1234567890");
		deliveryid1.add("1245678952");
		deliveryid2.add("1245678552");
		deliveryid2.add("1245453122");
		deliveryid2.add("1245678212");
		deliveryid3.add("1245655542");
		deliveryid3.add("1245658952");
		deliveryid3.add("1245675152");
		deliveryid4.add("1245678212");
		deliveryid4.add("1245655542");
		deliveryid4.add("1245658952");
		deliveryid4.add("1245675152");
		receivable.add(new ReceivablePO("2015-02-11",100.0,"1",deliveryid1));
		receivable.add(new ReceivablePO("2015-02-11",120.0,"2",deliveryid2));
		receivable.add(new ReceivablePO("2015-02-11",145.0,"3",deliveryid3));
		receivable.add(new ReceivablePO("2015-02-11",145.0,"4",deliveryid4));
		receivable.add(new ReceivablePO("2015-02-11",145.0,"5",deliveryid4));
		receivable.add(new ReceivablePO("2015-02-11",145.0,"6",deliveryid4));
		return receivable;
	}
	
	public List<PaymentPO>	getPaymentList() {
		List<PaymentPO> pay = new ArrayList<PaymentPO>();
		pay.add(new PaymentPO(null, 10.0, null, null, null, null, false, false));
		pay.add(new PaymentPO(null, 20.0, null, null, null, null, false, false));
		pay.add(new PaymentPO(null, 30.0, null, null, null, null, false, false));
		return pay;
	}
}
