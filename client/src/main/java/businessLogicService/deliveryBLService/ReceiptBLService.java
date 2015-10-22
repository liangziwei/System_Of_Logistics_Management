package businessLogicService.deliveryBLService;

import vo.deliveryVO.ReceiptVO;

/**
 * description:业务逻辑层为收件信息界面提供的服务
 * @author 肖安祥
 */
public interface ReceiptBLService {

	/**
	 * description:把收件信息保存
	 * @param receiptVO 记录收件信息的值对象，具体参见ReceiptVO的定义
	 * @return boolean 通知方法调用者是否保存成功
	 */
	public boolean saveReceiptInfo(ReceiptVO receiptVO);
	
	/**
	 * description:更新快递到达时间历史记录
	 * @param arriveTime 快递到达时间
	 * @param id 订单条形码号
	 * @return 通知方法调用者是否更新成功
	 */
	public boolean updateTimeRecord(String arriveTime, String id);
	
}
