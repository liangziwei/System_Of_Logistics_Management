package businessLogicService.deliveryBLService;

import vo.deliveryVO.ReceiptVO;
import vo.deliveryVO.VerifyMessage;

/**
 * description:业务逻辑层为收件信息界面提供的服务
 * @author 肖安祥
 */
public interface ReceiptBLService {

	/**
	 * description:把收件信息保存
	 * 前置条件：界面传递一个不为null的receiptVO，里面记录了收件信息
	 * 后置条件：将收件信息存储
	 * 需接口：ReceiptDataService.saveReceiptInfo(ReceiptPO receiptPO)（将收件信息存储）
	 * @param receiptVO 记录收件信息的值对象，具体参见ReceiptVO的定义
	 * @return boolean 通知方法调用者是否保存成功
	 */
	public boolean saveReceiptInfo(ReceiptVO receiptVO);
	
	/**
	 * description:更新快递到达时间历史记录
	 * 前置条件：用户输入有效的快递到达日期和订单条形码号
	 * 后置条件：根据订单条形码号查询订单的出发日期以及出发地和目的地，
	 * 			 将快递运送于这两地所需时间的记录进行存储
	 * 需接口：OrderDataService.getOrderInfoById(String id)
	 *        （获得订单信息，包括出发日期，出发地和目的地信息）
	 *         ReceiptDataService.updateTimeRecord(int day, City source, City destination)
	 *        （存储时间记录）
	 * @param arriveTime 快递到达日期
	 * @param id 订单条形码号
	 * @return 通知方法调用者是否更新成功
	 */
	public boolean updateTimeRecord(String name, String arriveTime, String id);
	
	/**
	 * description:验证收件信息的输入是否合法
	 * 前置条件：快递员输入收件信息后，确认保存收件信息
	 * 后置条件：给出验证的反馈结果
	 * 需接口：无
	 * @param receiptVO,订单信息的值对象
	 * @return 返回验证的结果
	 */
	public VerifyMessage verifyReceiptInfo(ReceiptVO receiptVO);
	
}
