package dataImpl.financeDataImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dataService.financeDataService.SettlementDataService;
import po.businessPO.ReceivablePO;

/**
 * description:数据服务层为结算管理提供服务的具体实现
 * @author 张仁知
 */
public class SettlementDataImpl implements SettlementDataService{

	ResultSet rs;
	
	public List<ReceivablePO> getReceiList(String date) {
		List<ReceivablePO> receivables = new ArrayList<ReceivablePO>();
		ArrayList<String> id1 = new ArrayList<String>();
		id1.add("1000010000");
		id1.add("1000010001");
		ArrayList<String> id2 = new ArrayList<String>();
		id2.add("0000010000");
		id2.add("0000010001");
		ArrayList<String> id3 = new ArrayList<String>();
		id3.add("1000610000");
		id3.add("1000610001");
		id3.add("1000610002");
		id3.add("1000610001");
		id3.add("1000610002");
		id3.add("1000610003");
		receivables.add(new ReceivablePO("1990-1-1", 12.0, "A", id1));
		receivables.add(new ReceivablePO("1990-1-1", 0.0, "B", id2));
		receivables.add(new ReceivablePO("1990-1-1", 0.0, "C", id3));
		return receivables;
	}
	
	public List<ReceivablePO> getBusinessRecei(String id,String date) {
		//TODO TEST
		List<ReceivablePO> receivables = new ArrayList<ReceivablePO>();
		if(id.equals("1")) {
			ArrayList<String> id1 = new ArrayList<String>();
			id1.add("1000010000");
			id1.add("1000010001");
			ArrayList<String> id2 = new ArrayList<String>();
			id2.add("0000010000");
			id2.add("0000010001");
			ArrayList<String> id3 = new ArrayList<String>();
			id3.add("1000610000");
			id3.add("1000610001");
			id3.add("1000610002");
			id3.add("1000610003");
			receivables.add(new ReceivablePO("1990-1-1", 12.0, "A", id1));
			receivables.add(new ReceivablePO("1990-1-1", 0.0, "B", id2));
			receivables.add(new ReceivablePO("1990-1-1", 0.0, "C", id3));
		}
		else {
			ArrayList<String> id1 = new ArrayList<String>();
			id1.add("1000010000");
			id1.add("1000010001");
			ArrayList<String> id2 = new ArrayList<String>();
			id2.add("0000010000");
			id2.add("0000010001");
			ArrayList<String> id3 = new ArrayList<String>();
			id3.add("1000610000");
			id3.add("1000610001");
			id3.add("1000610002");
			id3.add("1000610003");
			receivables.add(new ReceivablePO("1993-1-1", 12.0, "A", id1));
			receivables.add(new ReceivablePO("1993-1-1", 2.0, "B", id2));
			receivables.add(new ReceivablePO("1993-1-1", 0.0, "C", id3));
			receivables.add(new ReceivablePO("1993-1-1", 12.0, "A", id1));
			receivables.add(new ReceivablePO("1993-1-1", 2.0, "B", id2));
			receivables.add(new ReceivablePO("1993-1-1", 0.0, "C", id3));
			receivables.add(new ReceivablePO("1993-1-1", 12.0, "A", id1));
			receivables.add(new ReceivablePO("1993-1-1", 2.0, "B", id2));
			receivables.add(new ReceivablePO("1993-1-1", 0.0, "C", id3));
		}
		return receivables;
	}
	
//	private ReceivablePO rsToReceivablePO(ResultSet rs){
//		
//	}
}
