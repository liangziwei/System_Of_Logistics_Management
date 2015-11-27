package dataService.businessDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.businessPO.EntruckingPO;

/**
 * description:数据服务层为装车管理提供的服务 
 * @author 张云飞
 */
public interface EntruckingDataService extends Remote{
	
	/**
	 * description:通过传入装车单信息新建一个装车单
	 * 前置条件：同样id的po在数据库中不存在
	 * 后置条件：在数据库增加一个po记录
	 * @param entruckingPO 装车单信息的持久化对象，具体参见EntruckingPO
	 * @return 添加是否成功
	 */
	public boolean addEntruckingFrom(EntruckingPO entruckingPO)throws RemoteException;
}
