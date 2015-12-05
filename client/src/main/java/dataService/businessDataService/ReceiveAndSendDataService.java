package dataService.businessDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.businessPO.ArrivalFormPO;
import po.businessPO.SendFormPO;

/**
 *description:数据服务层为接受和派件提供的服务
 *@author 张云飞 
 */
public interface ReceiveAndSendDataService extends Remote{

	/**
	 *description:通过传入到达单信息新建一个到达单
	 * 前置条件：同样id的po在数据库中不存在
	 * 后置条件：在数据库增加一个po记录
	 *@param arrivalFormPO 到达单信息的持久化对象，具体参见ArrivalFormPO
	 *@return 添加是否成功 
	 */
	public boolean addReceiveFrom(ArrivalFormPO arrivalFormPO)throws RemoteException;
	
	/**
	 *description:通过传入派件单信息新建一个派件单
	 * 前置条件：同样id的po在数据库中不存在
	 * 后置条件：在数据库增加一个po记录 
	 * @param sendFormPO 派件单信息的持久化对象，具体参见SendFormPO
	 * @return 添加是否成功
	 */
	public boolean addSendFrom(SendFormPO sendFormPO)throws RemoteException;
	
	/**
	 * 审批一张到达单
	 */
	public boolean approveOneArrivalForm(ArrivalFormPO form) throws RemoteException;
	
	/**
	 * 审批多张到达单
	 */
	public boolean approveMoreArrivalForm(ArrayList<ArrivalFormPO> form) throws RemoteException;
	
	/**
	 * 审批一张派送单
	 */
	public boolean approveOneSendForm(SendFormPO form) throws RemoteException;
	
	/**
	 *审批多张派送单 
	 */
	public boolean approveMoreSendForm(ArrayList<SendFormPO> form) throws RemoteException;
	
}
