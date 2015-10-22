package dataService.deliveryDataService;

import po.deliveryPO.ReceiptPO;

/**
 * description:数据服务层为收件信息逻辑处理提供的服务
 * @author 肖安祥
 * */
public interface ReceiptDataService {

	/**
	 * description:将收件信息的持久化对象存储
	 * @param receiptPO,收件信息的持久化对象，具体参见ReceiptPO的定义
	 * @return boolean，通知方法调用者是否保存成功
	 */
	public boolean saveReceiptInfo(ReceiptPO receiptPO);
	
	/**
	 * description:将快递到达时间历史记录更新
	 * @param day:快递到达时间（天）
	 * @param source：快递出发地的名称
	 * @param destination：快递目的地的名称
	 */
	public boolean updateTimeRecord(int day, String source, String destination);
}
