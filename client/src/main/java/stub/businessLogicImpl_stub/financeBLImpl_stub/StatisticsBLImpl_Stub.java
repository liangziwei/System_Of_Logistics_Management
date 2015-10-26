package stub.businessLogicImpl_stub.financeBLImpl_stub;

import java.util.ArrayList;
import java.util.List;

import po.businessPO.ReceivablePO;
import dataService.financeDataService.CostDataService;
import dataService.financeDataService.StatisticsDataService;
import stub.dataImpl_stub.financeDataImpl_stub.StatisticsDataImpl_Stub;
import vo.businessVO.ReceivableVO;
import vo.financeVO.CostBenefitVO;
import businessLogicService.financeBLService.StatisticsBLSevice;

public class StatisticsBLImpl_Stub implements StatisticsBLSevice{
	private StatisticsDataService statistics = new StatisticsDataImpl_Stub();
	public CostBenefitVO getCostBenefit() {
		return new CostBenefitVO(1000.0, 500.0, 500.0);
	}
	
	public List<ReceivableVO> getReceivableList(String startDate,String endDate) {
		List<ReceivableVO> receivablevo = new ArrayList<ReceivableVO>();
		for(int i=0;i<statistics.getReceivableList(startDate, endDate).size();i++){
			receivablevo.add(receivablePOToreceivableVO(statistics.getReceivableList
					(startDate, endDate).get(i)));
		}
		return receivablevo;
	}
	
	private ReceivableVO receivablePOToreceivableVO(ReceivablePO receivablePO){
		return new ReceivableVO(receivablePO.getDate(),receivablePO.getMoney(),
				receivablePO.getCourier(),receivablePO.getDeliveryid());
	}
}
