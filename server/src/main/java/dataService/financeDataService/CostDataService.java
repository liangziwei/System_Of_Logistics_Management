package dataService.financeDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.financePO.PaymentPO;


/**
 * description:数据服务层为成本管理逻辑处理提供的服务
 * @author 张仁知
 */


public interface CostDataService extends Remote{


	/**
	 * description:新建一个付款单
	 * 前置条件：同样的的po在数据库中不存在
	 * 后置条件：在数据库中增加一个po记录
	 * @param  PaymentPO ,记录付款单信息的值对象，具体参照PaymentPO的定义
	 * @return 添加是否成功
	 */
	
	public boolean addPayment(PaymentPO paymentPO) throws RemoteException;
	
	/**
	 *审批一张付款单 
	 */
	public boolean approveOnePayment(PaymentPO form) throws RemoteException;
	
	/**
	 *审批多张付款单 
	 */
	public boolean approveMorePayment(ArrayList<PaymentPO> form) throws RemoteException;
}
