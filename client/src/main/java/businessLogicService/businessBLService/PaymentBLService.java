package businessLogicService.businessBLService;

import vo.businessVO.PaymentVO;
/**
 *description:新建收款单逻辑操作 
 * @author 张云飞
 */
public interface PaymentBLService {
	
	/**
	 *description:新建一个收款单
	 *@param paymentVO 
	 *@return 添加是否成功
	 */
	public  boolean addPayentForm(PaymentVO paymentVO);
}
