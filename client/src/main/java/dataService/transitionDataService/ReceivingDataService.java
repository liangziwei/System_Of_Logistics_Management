package dataService.transitionDataService;

import po.transitionPO.ReceivingPO;

/**
 *description:数据服务层为中转中心货物接收信息管理提供的服务 
 * @author 阮威威
 */
public interface ReceivingDataService {
	
	/**
	 * description:添加新的货物接收单信息
	 * @param ReceivingPO ,货物接收信息的相关持久化对象存储，具体参照ReceivingPO的定义
	 * @return boolean, 返回给方法调用者货物接收信息是否添加成功
	 * */
	public boolean addReceivingFormDT(ReceivingPO receivingPO);
	
	/**
	 * description:修改新的货物接收单信息
	 * @param ReceivingPO ,货物接收信息的相关持久化对象存储，具体参照ReceivingPO的定义
	 * @return boolean, 返回给方法调用者货物接收信息是否修改成功
	 * */
	public boolean ModifyReceivingFormDT(ReceivingPO receivingPO);
	
	/**
	 * description:通过中转单编号找到相应的货物接收单
	 * @param ReceivingNumber ,中转单编号（年月日＋000000六位数字）
	 * @return ReceivingPO, 返回货物接受信息的持久化对象，具体参见ReceivingPO的定义
	 */
	public ReceivingPO FindReceivingFormDT(String receivingNumber);
	
}
