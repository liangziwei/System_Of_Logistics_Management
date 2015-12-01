package stub.dataImpl_stub.financeDataImpl_stub;

import java.util.ArrayList;
import java.util.List;

import po.businessPO.ReceivablePO;
import dataService.financeDataService.SettlementDataService;

public class SettlementDataImpl_Stub implements SettlementDataService{
	public List<ReceivablePO> getReceiList(String date) {
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
		receivable.add(new ReceivablePO("2015-02-11",120.0,"小李",deliveryid2));
		receivable.add(new ReceivablePO("2015-02-11",145.0,"小王",deliveryid3));
		return receivable;
	}
	
	public List<ReceivablePO> getBusinessRecei(String id,String date) {
		List<ReceivablePO> receivable = new ArrayList<ReceivablePO>();
		ArrayList<String> deliveryid1 = new ArrayList<String>();
		ArrayList<String> deliveryid2 = new ArrayList<String>();
		ArrayList<String> deliveryid3 = new ArrayList<String>();
		deliveryid1.add("1234567890");
		deliveryid1.add("1245678952");
		deliveryid2.add("1245678552");
		deliveryid2.add("1245451122");
		deliveryid2.add("1245675212");
		deliveryid3.add("1245696542");
		deliveryid3.add("1245651952");
		deliveryid3.add("1245675452");
		receivable.add(new ReceivablePO("2015-02-11",100.0,"小红",deliveryid1));
		receivable.add(new ReceivablePO("2015-02-11",120.0,"小李",deliveryid2));
		receivable.add(new ReceivablePO("2015-02-11",145.0,"小王",deliveryid3));
		return receivable;
	}
}
