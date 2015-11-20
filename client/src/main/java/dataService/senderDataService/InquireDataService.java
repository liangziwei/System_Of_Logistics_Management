package dataService.senderDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.senderPO.LogisticsPO;

/**
 * description:数据服务层为物流信息逻辑处理提供的服务
 * @author 肖安祥
 */
public interface InquireDataService extends Remote{

	/**
	 * description:通过订单条形码号得到相应的物流信息
	 * 前置条件：逻辑层传送的订单条形码号有效
	 * 后置条件：根据订单条形码号查找相应物品的物流信息，返回逻辑层
	 * 需接口：无
	 * @param id:订单条形码号
	 * @return LogisticsPO：物流信息的持久化对象，具体参见LogisticsPO的定义
	 */
	public LogisticsPO getLogInfoById(String id)throws RemoteException;
}
