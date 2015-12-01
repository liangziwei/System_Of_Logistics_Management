package businessLogic.businessLogicModel.financeModel;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dataService.financeDataService.SettlementDataService;
import network.RMI;
import po.businessPO.ReceivablePO;
import vo.businessVO.ReceivableVO;

public class Settlement {
	
	private SettlementDataService settlementData = RMI.<SettlementDataService>getDataService("settlement");
	
	private List<ReceivablePO> po = null;
	
	public List<ReceivableVO> showReceiList(String date) {
		List<ReceivableVO> receivablevo = new ArrayList<ReceivableVO>();
		try{
			po = settlementData.getReceiList(date);
			if(po == null) return null;
			for(int i=0;i<po.size();i++){
				receivablevo.add(ReceivablePO.ReceiptPOToVO((po.get(i))));
			}
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
		return receivablevo;
	}
	
	public double calculateSum() {
		double sum = 0.0;
		if(this.po == null) return 0.0;
		int size = this.po.size();
		for(int i = 0; i < size; i++) {
			sum += this.po.get(i).getMoney();
		}
		return sum;
	}
	
	public List<ReceivableVO> showBusinessRecei( String id,String date) {
		try {
			po = settlementData.getBusinessRecei(id, date);
			if(po == null) return null;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		int size = po.size();
		List<ReceivableVO> vo = new ArrayList<ReceivableVO>();
		for(int i = 0; i < size; i++) {
			vo.add(ReceivablePO.ReceiptPOToVO(po.get(i)));
		}
		return vo;
	
	}
	

}
