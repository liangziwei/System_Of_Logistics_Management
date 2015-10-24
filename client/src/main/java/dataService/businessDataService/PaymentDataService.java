package dataService.businessDataService;

import po.businessPO.ReceivablePO;

/**
 *description:数据服务层为新建收款单提供的服务 
 * @author 张云飞
 */
public interface PaymentDataService {
	
	/**
	 *description:通过传入收款单信息新建一个收款单
	 *@param receivablePO 收款单信息的持久化对象，具体参见ReceivablePO
	 *@return 添加是否成功
	 */
	public  boolean addPayentForm(ReceivablePO paymentPO);
}
