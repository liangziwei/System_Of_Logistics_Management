package businessLogicService.financeBLService;

import java.util.List;

import vo.businessVO.ReceivableVO;
import vo.financeVO.CostBenefitVO;


/**
 * description:业务逻辑层为成本经营统计分析界面提供的服务
 * @author 张仁知
 */
public interface StatisticsBLSevice {
	
	/**
	 * description:显示成本收益表
	 * 前置条件：启动成本经营统计分析
	 * 后置条件：返回成本收益表
	 * @param startDate, 开始日期
	 * @param endDate, 结束日期
	 * 需接口：StatisticsDataService.getReceivableList(),
	 * 		StatisticsDataService.getPaymentList()
	 * @return CostBenefitVO ,记录成本收益表信息的值对象，具体参照CostBenefitVO的定义
	 */
	public CostBenefitVO getCostBenefit(String startDate, String endDate);
	
	/**
	 * description:  显示一段时间内的收款单记录
	 * 前置条件：启动成本经营统计分析
	 * 后置条件：返回一段时间内的收款单列表
	 * 需接口：StatisticsDataService.getReceivableList(String startDate,String endDate)
	 * @param  startDate ,开始日期（yyyy-mm-dd）
	 * @param  endDate   ,结束日期（yyyy-mm-dd）
	 * @return List<ReceivableVO> ,返回记录收款单信息对象的列表
	 */
	public List<ReceivableVO> getReceivableList(String startDate,String endDate);
	
	public void outExcel(String fileSave, List<ReceivableVO> list);

}
