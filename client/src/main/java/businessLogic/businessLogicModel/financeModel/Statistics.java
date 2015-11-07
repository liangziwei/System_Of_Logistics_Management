package businessLogic.businessLogicModel.financeModel;

import java.util.ArrayList;
import java.util.List;

import po.businessPO.ReceivablePO;
import vo.businessVO.ReceivableVO;
import vo.financeVO.CostBenefitVO;
import mock.object.MockStatisticsData;
import dataService.financeDataService.StatisticsDataService;

public class Statistics {

	private StatisticsDataService statisticsData = new MockStatisticsData();
	
	public CostBenefitVO getCostBenefit() {
		return new CostBenefitVO(1000.0, 500.0, 500.0);
	}
	
	public List<ReceivableVO> getReceivableList(String startDate,String endDate) {
		List<ReceivableVO> receivablevo = new ArrayList<ReceivableVO>();
		for(int i=0;i<statisticsData.getReceivableList(startDate, endDate).size();i++){
			receivablevo.add(receivablePOToreceivableVO(statisticsData.getReceivableList
					(startDate, endDate).get(i)));
		}
		return receivablevo;
	}
	private ReceivableVO receivablePOToreceivableVO(ReceivablePO receivablePO){
		return new ReceivableVO(receivablePO.getDate(),receivablePO.getMoney(),
				receivablePO.getCourier(),receivablePO.getDeliveryid());
	}
}
