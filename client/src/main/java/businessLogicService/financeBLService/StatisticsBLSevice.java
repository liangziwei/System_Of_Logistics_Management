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
	 * @return CostBenefitVO ,记录成本收益表信息的值对象，具体参照CostBenefitVO的定义
	 */
	public CostBenefitVO getCostBenefit();
	
	/**
	 * description:  显示一段时间内的收款单记录
	 * @param  startDate ,开始日期（yyyy-mm-dd）
	 * @param  endDate   ,结束日期（yyyy-mm-dd）
	 * @return List<ReceivableVO> ,返回记录收款单信息对象的列表
	 */
	public List<ReceivableVO> getReceivableList(String startDate,String endDate);

}
