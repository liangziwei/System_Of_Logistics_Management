package businessLogicService.businessBLService;

import vo.businessVO.ReceivableVO;
/**
 *description:业务逻辑层为新建收款单界面提供的服务 
 * @author 张云飞
 */
public interface PaymentBLService {
	
	/**
	 *description:通过传入收款单信息新建一个收款单
	 * 前置条件：ui层发出添加收款单单的命令
	 * 后置条件：系统添加收款单信息
	 * 需要的服务：PaymentDataService.addPayentForm(ReceivablePO paymentPO) （添加单一持久化对象）
	 *@param receivableVO 收款单信息值对象，具体参见ReceivableVO
	 *@return 添加是否成功
	 */
	public  boolean addPayentForm(ReceivableVO receivableVO);
}
