package dataService.financeDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.financePO.AccountPO;

/**
 * description:数据服务层为账户管理逻辑处理提供的服务
 * @author 张仁知
 */
public interface AccountDataService extends Remote{
	
	/**
	 * description:添加一个账户
	 * 前置条件：同样的name的po在数据库中不存在
	 * 后置条件：在数据库中增加一个po记录
	 * @param AccountPO ,记录账户信息的值对象，具体参照AccountPO的定义
	 * @return 添加是否成功
	 */
	public boolean addAccount(AccountPO accountPO) throws RemoteException;		
	
	/**
	 * description:查询一个账户
	 * 前置条件：无
	 * 后置条件：按name进行查找返回相应的AccountPO结果
	 * @param  name 关键字（账户名称）
	 * @return AccountPO 返回查询到的账户信息
	 */
	public AccountPO findAccount(String name) throws RemoteException;
	
	/**
	 * description:删除一个账户
	 * 前置条件：在数据库中存在同样name的po
	 * 后置条件：删除一个po
	 * @param  name 账户名称
	 * @return boolean删除是否成功
	 */
	public boolean deleteAccount(String name) throws RemoteException;
	
	/**
	 * description:修改一个账户
	 * 前置条件：在数据库中存在同样name的po
	 * 后置条件：修改一个po
	 * @param oldName, 原来账户名称
	 * @param newName, 修改后账户名称
	 * @return 要修改的账户是否存在
	 */
	public boolean modifyAccount(String oldName, String newName) throws RemoteException;

}
