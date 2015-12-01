package businessLogic.businessLogicController.senderController;

import businessLogic.businessLogicModel.senderModel.InquireModel;
import businessLogicService.senderBLService.InquireBLService;
import vo.senderVO.LogisticsVO;

/**
 * description:为物流信息界面提供服务的控制器
 * @author 肖安祥
 */
public class InquireController implements InquireBLService{

	private InquireModel inquire = new InquireModel();
	
	public LogisticsVO getLogInfoById(String id) {
		return this.inquire.getLogInfoById(id);
	}

}
