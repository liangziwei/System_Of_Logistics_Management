package businessLogicService.businessBLService;

import vo.businessVO.ArrivalFormVO;
import vo.businessVO.SendFormVO;
/**
 *description:业务逻辑层为接受和派件界面提供的服务
 *@author 张云飞 
 */
public interface ReceiveAndSendBLService {
	
	/**
	 *description:通过传入到达单信息新建一个到达单
	 * 前置条件：ui层发出添加到达单的命令
	 * 后置条件：系统添加到达单信息
	 * 需要的服务：ReceiveAndSendDataService。addReceiveFrom(ArrivalFormPO arrivalFormPO)（添加一个持久化对象）
	 *@param arrivalFormVO 到达单信息值对象，具体参见ArrivalFormVO
	 *@return 添加是否成功 
	 */
	public boolean addReceiveFrom(ArrivalFormVO arrivalFormVO);
	
	/**
	 *description:通过传入派件单信息新建一个派件单
	 * 前置条件：ui层发出添加派件单的命令
	 * 后置条件：系统添加派件单信息
	 * 需要的服务： ReceiveAndSendDataService。addSendFrom(SendFormPO sendFormPO) （添加一个持久化对象）
	 * @param sendFormVO 派件单信息值对象，具体参见SendFormVO
	 * @return 添加是否成功
	 */
	public boolean addSendFrom(SendFormVO sendFormVO);
	
}
