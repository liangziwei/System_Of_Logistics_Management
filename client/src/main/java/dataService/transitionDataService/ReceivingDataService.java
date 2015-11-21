package dataService.transitionDataService;

import java.rmi.Remote;

import po.transitionPO.ReceivingPO;

/**
 *description:数据服务层为中转中心货物接收信息管理提供的服务 
 * @author 阮威威
 */
public interface ReceivingDataService extends Remote{
	
	/**
	 * description:添加新的货物接收单信息
	 * 前置条件：逻辑层传送的ReceivingPO不为null且格式正确
	 * 后置条件：保存货物接收单
	 * 需接口：无
	 * @param ReceivingPO ,货物接收信息的相关持久化对象存储，具体参照ReceivingPO的定义
	 * @return boolean, 返回给方法调用者货物接收信息是否添加成功
	 * */
	public boolean addReceivingFormDT(ReceivingPO receivingPO);
	
	/**
	 * description:修改新的货物接收单信息
	 * 前置条件：逻辑层传送的ReceivingPO不为null且格式正确
	 * 后置条件：保存货物接收单
	 * 需接口：无
	 * @param ReceivingPO ,货物接收信息的相关持久化对象存储，具体参照ReceivingPO的定义
	 * @return boolean, 返回给方法调用者货物接收信息是否修改成功
	 * */
	public boolean modifyReceivingFormDT(ReceivingPO receivingPO);
	
	/**
	 * description:通过中转单编号找到相应的货物接收单
	 * 前置条件：逻辑层传送的receivingNumber正确
	 * 后置条件：将获得的货物接收单信息返回给逻辑层
	 * 需接口：无
	 * @param ReceivingNumber ,中转单编号（年月日＋000000六位数字）
	 * @return ReceivingPO, 返回货物接受信息的持久化对象，具体参见ReceivingPO的定义
	 */
	public ReceivingPO FindReceivingFormDT(String receivingNumber);
	
}
