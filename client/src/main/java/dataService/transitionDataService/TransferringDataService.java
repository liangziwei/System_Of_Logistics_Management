package dataService.transitionDataService;

import java.util.List;

import po.transitionPO.TransferringPO;

/**
 *description:数据服务层为中转中心中转信息管理提供的服务 
 * @author 阮威威
 */
public interface TransferringDataService{
	
	/**
	 * description:添加新的中转单
	 * @param TransferringPO ,中转信息的相关持久化对象存储，具体参照TransferringPO的定义
	 * @return boolean, 返回给方法调用者中转单信息是否添加成功
	 * */
	public boolean AddTransferringFormDT(TransferringPO transferringPO);
	
	/**
	 * description:修改中转单
	 * @param TransferringPO ,中转信息的相关持久化对象存储，具体参照TransferringPO的定义
	 * @return boolean, 返回给方法调用者中转单信息是否修改成功
	 * */
	public boolean ModifyTransferringFormDT(TransferringPO transferringPO);
	
	/**
	 * description:通过中转单编号得到相应的中转单信息
	 * @param transferringNumber ,中转单编号（中转中心编号+日期+0000000七位数字）
	 * @return TransferringPO, 返回中转单信息的持久化对象，具体参照TransferringPO的定义
	 */
	public TransferringPO FindTransferringFormDT(String transferringNumber);
	
	/**
	 * description:查询当天的中转单列表
	 * @param  Date : 当天的日期
	 * @return List<TransferringPO> 返回记录当天的中转单的持久化对象的列表
	 */
	public List<TransferringPO> GetTansferringInfoDT(String date);

}
