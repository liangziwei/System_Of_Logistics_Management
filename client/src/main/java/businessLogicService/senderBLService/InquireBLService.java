package businessLogicService.senderBLService;

import vo.senderVO.LogisticsVO;

/**
 * description:业务逻辑层为物流信息界面提供的服务
 * @author 肖安祥
 */
public interface InquireBLService {

	/**
	 * description:根据订单条形码号查询物流信息
	 * @param id:订单条形码号
	 * @return 返回物流信息的值对象，具体参见LogisticsVO的定义
	 */
	public LogisticsVO getLogInfoById(String id);
	
}
