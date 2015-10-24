package dataService.financeDataService;

import po.financePO.PaymentPO;


/**
 * description:数据服务层为成本管理逻辑处理提供的服务
 * @author 张仁知
 */


public interface CostDataService {


	/**
	 * description:新建一个付款单
	 * @param  PaymentPO ,记录付款单信息的值对象，具体参照PaymentPO的定义
	 * @return 添加是否成功
	 */
	
	public boolean addPayment(PaymentPO paymentPO);
}
