package businessLogic.businessLogicModel.financeModel;

import java.util.ArrayList;
import java.util.List;

import po.businessPO.ReceivablePO;
import vo.businessVO.ReceivableVO;
import mock.object.MockSettlementData;
import dataService.financeDataService.SettlementDataService;

public class Settlement {
	
	private SettlementDataService settlementData = null;
	
	public List<ReceivableVO> showReceiList(String date) {
		List<ReceivableVO> receivablevo = new ArrayList<ReceivableVO>();
		for(int i=0;i<settlementData.getReceiList(date).size();i++){
			receivablevo.add(receivablePOToreceivableVO(settlementData.getReceiList(date).get(i)));
		}
		return receivablevo;
	}
	
	public double calculateSum() {
		return 0.0;
	}
	
	public List<ReceivableVO> showBusinessRecei( String id,String date) {
//		List<ReceivableVO> receivablevo = new ArrayList<ReceivableVO>();
//		for(int i=0;i<settlementData.getBusinessRecei(id, date).size();i++){
//			receivablevo.add(receivablePOToreceivableVO(settlementData.getBusinessRecei(id, date).get(i)));
//		}
//		return receivablevo;
		
		//TODO TEST
		List<ReceivableVO> receivables = new ArrayList<ReceivableVO>();
		ArrayList<String> id1 = new ArrayList<String>();
		id1.add("1000010000");
		id1.add("1000010001");
//		id1.add("1000010002");
//		id1.add("1000010003");
		ArrayList<String> id2 = new ArrayList<String>();
		id2.add("0000010000");
		id2.add("0000010001");
//		id2.add("0000010002");
//		id2.add("0000010003");
		ArrayList<String> id3 = new ArrayList<String>();
		id3.add("1000610000");
		id3.add("1000610001");
		id3.add("1000610002");
		id3.add("1000610003");
		receivables.add(new ReceivableVO("1990-1-1", 12.0, "A", id1));
		receivables.add(new ReceivableVO("1990-1-1", 0.0, "B", id2));
		receivables.add(new ReceivableVO("1990-1-1", 0.0, "C", id3));
		return receivables;
	}
	
	private ReceivableVO receivablePOToreceivableVO(ReceivablePO receivablePO){
		return new ReceivableVO(receivablePO.getDate(),receivablePO.getMoney(),
				receivablePO.getCourier(),receivablePO.getDeliveryid());
	}

}
