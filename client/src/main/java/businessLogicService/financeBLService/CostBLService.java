package businessLogicService.financeBLService;

import vo.financeVO.PaymentVO;
/**
 * description:业务逻辑层为成本管理界面提供的服务
 * @author 张仁知
 */

public interface CostBLService {
	
	/**
	 * description:新建一个付款单
	 * 前置条件：启动成本管理
	 * 后置条件：在数据库中增加一个付款单信息
	 * 需接口： CostDataService.addPayment(PaymentPO paymentPO)
	 * @param  PaymentVO ,记录付款单信息的值对象，具体参照PaymentVO的定义
	 * @return 添加是否成功
	 */
	
	public boolean addPayment(PaymentVO paymentVO);

}
