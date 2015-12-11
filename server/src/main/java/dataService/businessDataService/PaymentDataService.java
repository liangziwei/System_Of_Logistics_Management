package dataService.businessDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataService.ApproveFormService;
import po.businessPO.ReceivablePO;

/**
 *description:数据服务层为新建收款单提供的服务 
 * @author 张云飞
 */
public interface PaymentDataService extends Remote, ApproveFormService{
	
	/**
	 *description:通过传入收款单信息新建一个收款单
	 * 前置条件：同样id的po在数据库中不存在
	 * 后置条件：在数据库增加一个po记录
	 *@param receivablePO 收款单信息的持久化对象，具体参见ReceivablePO
	 *@return 添加是否成功
	 */
	public  boolean addPayentForm(ReceivablePO paymentPO)throws RemoteException;
	
//	/**
//	 *审批一张收款单 
//	 */
//	public boolean approveOneReceivable(ReceivablePO form) throws RemoteException;
//	
//	/**
//	 *审批多张收款单 
//	 */
//	public boolean approveMoreReceivable(ArrayList<ReceivablePO> form) throws RemoteException;
}
