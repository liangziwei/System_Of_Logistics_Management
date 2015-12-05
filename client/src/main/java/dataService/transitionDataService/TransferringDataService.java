package dataService.transitionDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.transitionPO.TransferringPO;

/**
 *description:数据服务层为中转中心中转信息管理提供的服务 
 * @author 阮威威
 */
public interface TransferringDataService extends Remote{
	
	/**
	 * description:添加新的中转单
	 * 前置条件：逻辑层传送的TransferringPO不为null且格式正确
	 * 后置条件：保存中转单
	 * 需接口：无
	 * @param TransferringPO ,中转信息的相关持久化对象存储，具体参照TransferringPO的定义
	 * @return boolean, 返回给方法调用者中转单信息是否添加成功
	 * */
	public boolean AddTransferringFormDT(TransferringPO transferringPO)throws RemoteException;
	
	/**
	 * description:修改中转单
	 * 前置条件：逻辑层传送的TransferringPO不为null且格式正确
	 * 后置条件：修改中转单单
	 * 需接口：无
	 * @param TransferringPO ,中转信息的相关持久化对象存储，具体参照TransferringPO的定义
	 * @return boolean, 返回给方法调用者中转单信息是否修改成功
	 * */
	public boolean ModifyTransferringFormDT(TransferringPO transferringPO)throws RemoteException;
	
	/**
	 * description:通过中转单编号得到相应的中转单信息
	 * 前置条件：逻辑层传送的transferringNumber正确
	 * 后置条件：将获得的中转单信息返回给逻辑层
	 * 需接口：无
	 * @param transferringNumber ,中转单编号（中转中心编号+日期+0000000七位数字）
	 * @return TransferringPO, 返回中转单信息的持久化对象，具体参照TransferringPO的定义
	 */
	public TransferringPO FindTransferringFormDT(String transferringNumber)throws RemoteException;
	
	/**
	 * description:查询当天的中转单列表
	 * 前置条件：逻辑层传送的data正确
	 * 后置条件：将获得的中转单信息列表返回给逻辑层
	 * 需接口：无
	 * @param  Date : 当天的日期
	 * @return List<TransferringPO> 返回记录当天的中转单的持久化对象的列表
	 */
	public List<TransferringPO> GetTransferringInfoDT(String date)throws RemoteException;
	
	/**
	 *审批一张中转单 
	 */
	public boolean approveOneTransferring(TransferringPO form) throws RemoteException;
	
	/**
	 *审批多张中转单 
	 */
	public boolean approveMoreTransferring(ArrayList<TransferringPO> form) throws RemoteException;

}
