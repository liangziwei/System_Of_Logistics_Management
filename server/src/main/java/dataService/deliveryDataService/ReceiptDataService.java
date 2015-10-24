package dataService.deliveryDataService;

import constant.City;
import po.deliveryPO.ReceiptPO;

/**
 * description:数据服务层为收件信息逻辑处理提供的服务
 * @author 肖安祥
 * */
public interface ReceiptDataService {

	/**
	 * description:将收件信息的持久化对象存储
	 * 前置条件：逻辑层传送的receiptVO不为null
	 * 后置条件：把收件信息存储
	 * 需接口：无
	 * @param receiptPO,收件信息的持久化对象，具体参见ReceiptPO的定义
	 * @return boolean，通知方法调用者是否保存成功
	 */
	public boolean saveReceiptInfo(ReceiptPO receiptPO);
	
	/**
	 * description:将快递到达时间历史记录更新
	 * 前置条件：逻辑层传送的快递时间，出发地和目的地
	 * 后置条件：在存储中插入一条新的时间记录，更新存储
	 * 需接口：无
	 * @param day:快递到达时间（天）
	 * @param source：快递出发地的名称
	 * @param destination：快递目的地的名称
	 */
	public boolean updateTimeRecord(int day, City source, City destination);
}
