package businessLogic.businessLogicModel.financeModel;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import network.RMI;
import po.businessPO.ReceivablePO;
import vo.businessVO.ReceivableVO;
import dataService.financeDataService.SettlementDataService;

public class Settlement {
	
	private SettlementDataService settlementData = RMI.<SettlementDataService>getDataService("settlement");
	public List<ReceivableVO> showReceiList(String date) {
		List<ReceivableVO> receivablevo = new ArrayList<ReceivableVO>();
		try{
			for(int i=0;i<settlementData.getReceiList(date).size();i++){
				receivablevo.add(receivablePOToreceivableVO(settlementData.getReceiList(date).get(i)));
			}
		} catch(Exception e){
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
			for(int i=0;i<settlementData.getBusinessRecei(id, date).size();i++){
				receivablevo.add(receivablePOToreceivableVO(settlementData.getBusinessRecei(id, date).get(i)));
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return receivablevo;
	}
	private ReceivableVO receivablePOToreceivableVO(ReceivablePO receivablePO) {
		return new ReceivableVO(receivablePO.getDate(),receivablePO.getMoney(),
				receivablePO.getCourier(),receivablePO.getDeliveryid());
	}

}
