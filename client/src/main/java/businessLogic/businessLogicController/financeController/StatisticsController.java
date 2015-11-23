package businessLogic.businessLogicController.financeController;

import java.util.List;

import vo.businessVO.ReceivableVO;
import vo.financeVO.CostBenefitVO;
import businessLogic.businessLogicModel.financeModel.Statistics;
import businessLogicService.financeBLService.StatisticsBLSevice;
/**
 * description:为成本经营统计分析界面提供服务的具体实现
 * @author 张仁知
 *
 */
public class StatisticsController implements StatisticsBLSevice{
	
	private Statistics statistics = new Statistics();
	
	public CostBenefitVO getCostBenefit() {
		return statistics.getCostBenefit();
	}
	
	public List<ReceivableVO> getReceivableList(String startDate,String endDate) {
		return statistics.getReceivableList(startDate, endDate);
	}

}
