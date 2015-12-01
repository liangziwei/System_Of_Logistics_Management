package businessLogic.businessLogicModel.financeModel;
 
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dataService.financeDataService.StatisticsDataService;
import network.RMI;
import po.businessPO.ReceivablePO;
import po.financePO.PaymentPO;
import vo.businessVO.ReceivableVO;
import vo.financeVO.CostBenefitVO;

public class Statistics {

	private StatisticsDataService statisticsData = RMI.<StatisticsDataService>getDataService("statistics");
	
	public CostBenefitVO getCostBenefit(String startDate, String endDate) {
		//计算总成本
		double cost = this.calculateCost(startDate, endDate);
		//计算总收入
		double income = this.calculateIncome(startDate, endDate);
		//计算总利润
		double profit = income - cost;
		return new CostBenefitVO(income, cost, profit);
	}
	
	public List<ReceivableVO> getReceivableList(String startDate,String endDate) {
		List<ReceivableVO> receivablevo = new ArrayList<ReceivableVO>();
		try{
			List<ReceivablePO> po = statisticsData.getReceivableList(startDate, endDate);
			int size = po.size();
			for(int i=0;i<size;i++){
				ReceivablePO temp = po.get(i);
				receivablevo.add(receivablePOToreceivableVO(temp));
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
	
	private double calculateCost(String startDate, String endDate) {
		List<PaymentPO> pay = null;
		try {
			pay = statisticsData.getPaymentList();
		} catch (RemoteException e) {
			e.printStackTrace();
			return 0.0;
		}
		double cost = 0.0;
		int size = pay.size();
		for(int i = 0; i < size; i++) {
			cost += pay.get(i).getPayAmount();
		}
		return cost;
	}
	
	private double calculateIncome(String startDate, String endDate) {
		List<ReceivablePO> rec = null;
		try {
			rec = this.statisticsData.getReceivableList(startDate, endDate);
		} catch (RemoteException e) {
			e.printStackTrace();
			return 0.0;
		}
		int size = rec.size();
		double income = 0.0;
		for(int i = 0; i < size; i++) {
			income += rec.get(i).getMoney();
		}
		return income;
	}
}
