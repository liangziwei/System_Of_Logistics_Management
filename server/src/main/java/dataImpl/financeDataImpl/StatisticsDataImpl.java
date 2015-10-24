package dataImpl.financeDataImpl;

import java.util.List;

import po.businessPO.ReceivablePO;
import po.financePO.PaymentPO;
import dataService.financeDataService.StatisticsDataService;

/**
 * description:数据服务层为成本经营统计分析提供服务的具体实现
 * @author 张仁知
 */
public class StatisticsDataImpl implements StatisticsDataService{

	public List<ReceivablePO> getReceivableList(String startDate,String endDate) {
		return null;
	}
	
	public List<ReceivablePO> getReceivableList() {
		return null;
	}
	
	public List<PaymentPO>	getPaymentList() {
		return null;
	}
}
