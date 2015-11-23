package stub.businessLogicImpl_stub.financeBLImpl_stub;

import java.util.ArrayList;
import java.util.List;

import po.businessPO.ReceivablePO;
import stub.dataImpl_stub.financeDataImpl_stub.SettlementDataImpl_Stub;
import vo.businessVO.ReceivableVO;
import businessLogicService.financeBLService.SettlementBLService;
import dataService.financeDataService.SettlementDataService;

public class SettlementBLImpl_Stub implements SettlementBLService {
	private SettlementDataService settlement = new SettlementDataImpl_Stub();
	public List<ReceivableVO> showReceiList(String date) {
		List<ReceivableVO> receivablevo = new ArrayList<ReceivableVO>();
		try{
			for(int i=0;i<settlement.getReceiList(date).size();i++){
				receivablevo.add(receivablePOToreceivableVO(settlement.getReceiList(date).get(i)));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return receivablevo;
	}
	
	public double calculateSum() {
		return 0.0;
	}
	
	public List<ReceivableVO> showBusinessRecei( String id,String date) {
		List<ReceivableVO> receivablevo = new ArrayList<ReceivableVO>();
		try{
			for(int i=0;i<settlement.getBusinessRecei(id, date).size();i++){
				receivablevo.add(receivablePOToreceivableVO(settlement.getBusinessRecei(id, date).get(i)));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return receivablevo;
	}
	private ReceivableVO receivablePOToreceivableVO(ReceivablePO receivablePO){
		return new ReceivableVO(receivablePO.getDate(),receivablePO.getMoney(),
				receivablePO.getCourier(),receivablePO.getDeliveryid());
	}

}
