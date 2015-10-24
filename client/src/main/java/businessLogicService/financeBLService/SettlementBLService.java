package businessLogicService.financeBLService;

import java.util.List;

import vo.businessVO.ReceivableVO;


/**
 * description:业务逻辑层为结算管理界面提供的服务
 * @author 张仁知
 */


public interface SettlementBLService {
	
	/**
	 * description:显示当天所有收款单记录
	 * @param  date ,要查看收款单的日期（yyyy-mm-dd）
	 * @return List<ReceivableVO> ,返回记录收款单信息对象的列表
	 */

	public List<ReceivableVO> showReceiList(String date);
	
	/**
	 * description: 合计当天所有收款单的总收款金额
	 * @return double ,总收款金额
	 */
	public double calculateSum();
	
	/**
	 * description:显示当天XX营业厅收款单记录
	 * @param  date ,要查看收款单的日期（yyyy-mm-dd）
	 * @param  id ,营业厅编号
	 * @return List<ReceivableVO> ,返回记录收款单信息对象的列表
	 */
	
	public List<ReceivableVO> showBusinessRecei(int id,String date);
	
}
