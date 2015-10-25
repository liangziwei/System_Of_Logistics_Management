package stub.dataImpl_stub.financeDataImpl_stub;

import java.util.ArrayList;
import java.util.List;

import po.businessPO.ReceivablePO;
import dataService.financeDataService.SettlementDataService;

public class SettlementDataImpl_Stub implements SettlementDataService{
	public List<ReceivablePO> getReceiList(String date) {
		List<ReceivablePO> receivable = new ArrayList<ReceivablePO>();
		receivable.add(new ReceivablePO("2015-02-11",100.0,"小红",(Long)12345678));
		receivable.add(new ReceivablePO("2015-02-11",120.0,"小李",));
		receivable.add(new ReceivablePO("2015-02-11",145.0,"小王",));
		return receivable;
	}
	
	public List<ReceivablePO> getBusinessRecei(String id,String date) {
		List<ReceivablePO> receivable = new ArrayList<ReceivablePO>();
		receivable.add(new ReceivablePO("2015-02-11",100.0,"小红",(Long)12345678));
		receivable.add(new ReceivablePO("2015-02-11",120.0,"小李",));
		receivable.add(new ReceivablePO("2015-02-11",145.0,"小王",));
		return receivable;
	}
}
