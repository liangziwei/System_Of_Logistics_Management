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
	 *@param arrivalFormVO 到达单信息值对象，具体参见ArrivalFormVO
	 *@return 添加是否成功 
	 */
	public boolean addReceiveFrom(ArrivalFormVO arrivalFormVO);
	
	/**
	 *description:通过传入派件单信息新建一个派件单 
	 * @param sendFormVO 派件单信息值对象，具体参见SendFormVO
	 * @return 添加是否成功
	 */
	public boolean addSendFrom(SendFormVO sendFormVO);
	
}
