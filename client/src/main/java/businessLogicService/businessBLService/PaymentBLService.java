package businessLogicService.businessBLService;

import vo.businessVO.ReceivableVO;
/**
 *description:业务逻辑层为新建收款单界面提供的服务 
 * @author 张云飞
 */
public interface PaymentBLService {
	
	/**
	 *description:通过传入收款单信息新建一个收款单
	 *@param receivableVO 收款单信息值对象，具体参见ReceivableVO
	 *@return 添加是否成功
	 */
	public  boolean addPayentForm(ReceivableVO receivableVO);
}
