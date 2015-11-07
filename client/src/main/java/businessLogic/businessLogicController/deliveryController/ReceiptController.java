package businessLogic.businessLogicController.deliveryController;

import businessLogic.businessLogicModel.deliveryModel.ReceiptModel;
import businessLogicService.deliveryBLService.ReceiptBLService;
import vo.deliveryVO.ReceiptVO;

/**
 * description:为收件信息界面提供服务的控制器
 * @author 肖安祥
 */
public class ReceiptController implements ReceiptBLService{

	private ReceiptModel receipt = new ReceiptModel();
	
	public boolean saveReceiptInfo(ReceiptVO receiptVO) {
		return this.receipt.saveReceiptInfo(receiptVO);
	}

	public boolean updateTimeRecord(String arriveTime, String id) {
		return this.updateTimeRecord(arriveTime, id);
	}

}
