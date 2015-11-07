package businessLogic.businessLogicModel.financeModel;

import java.util.ArrayList;
import java.util.List;

import po.businessPO.ReceivablePO;
import vo.businessVO.ReceivableVO;
import mock.object.MockSettlementData;
import dataService.financeDataService.SettlementDataService;

public class Settlement {
	
	private SettlementDataService settlementData = new MockSettlementData();
	
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
		List<ReceivableVO> receivablevo = new ArrayList<ReceivableVO>();
		for(int i=0;i<settlementData.getBusinessRecei(id, date).size();i++){
			receivablevo.add(receivablePOToreceivableVO(settlementData.getBusinessRecei(id, date).get(i)));
		}
		return receivablevo;
	}
	private ReceivableVO receivablePOToreceivableVO(ReceivablePO receivablePO){
		return new ReceivableVO(receivablePO.getDate(),receivablePO.getMoney(),
				receivablePO.getCourier(),receivablePO.getDeliveryid());
	}

}
