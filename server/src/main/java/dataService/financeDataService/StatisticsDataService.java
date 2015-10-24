package dataService.financeDataService;

import java.util.List;

import po.businessPO.ReceivablePO;
import po.financePO.PaymentPO;


/**
 * description:数据服务层为成本经营统计分析逻辑处理提供的服务
 * @author 张仁知
 */

public interface StatisticsDataService {
	
	/**
	 * description:  显示一段时间内的收款单记录
	 * 前置条件：无
	 * 后置条件：按日期进行查找返回一段时间内的收款单列表
	 * @param  startDate ,开始日期（yyyy-mm-dd）
	 * @param  endDate   ,结束日期（yyyy-mm-dd）
	 * @return List<ReceivablePO> ,返回记录收款单信息对象的列表
	 */
	public List<ReceivablePO> getReceivableList(String startDate,String endDate);
	
	/**
	 * description:显示所有收款单记录
	 * 前置条件：无
	 * 后置条件：返回所有收款单列表
	 * @return List<ReceivablePO> ,返回记录收款单信息对象的列表
	 */
	public List<ReceivablePO> getReceivableList();
	
	/**
	 * description:显示所有付款单记录
	 * 前置条件：无
	 * 后置条件：返回所有付款单列表
	 * @return List<ReceivablePO> ,返回记录付款单信息对象的列表
	 */
	public List<PaymentPO>	getPaymentList();

}
