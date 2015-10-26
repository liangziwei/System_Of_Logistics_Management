package dataService.deliveryDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import constant.City;
import po.deliveryPO.OrderPO;
import po.deliveryPO.TimeRecordPO;

/**
 * description:数据服务层为订单信息逻辑处理提供的服务
 * @author 肖安祥
 */
public interface OrderDataService extends Remote{

	/**
	 * description:通过订单条形码号得到相应的订单信息
	 * 前置条件：逻辑层传送的订单条形码号有效
	 * 后置条件：将获得的订单信息返回给逻辑层
	 * 需接口：无
	 * @param id ,订单条形码号（10位数字）
	 * @return OrderPO, 返回订单信息的持久化对象，具体参照OrdePO的定义
	 */
	public OrderPO getOrderInfoById(String id)throws RemoteException;
	
	/**
	 * description:将订单信息保存
	 * 前置条件：逻辑层传送的orderVO不为null
	 * 后置条件：把订单信息存储
	 * 需接口：无
	 * @param orderVO,将订单信息的持久化对象存储，具体参照OrderPO的定义
	 * @return boolean,通知方法调用者是否保存成功
	 */
	public boolean saveOrderInfo(OrderPO orderPO)throws RemoteException;
	
	/**
	 * description:查询数据存储，得到两地之间快递运送时间的所有历史记录
	 * 前置条件：逻辑层传送的快递出发地和目的地有效
	 * 后置条件：根据出发地和目的地查询快递运送时间的历史记录
	 * 需接口：无
	 * @param source 快递出发地的名称
	 * @param destination 快递目的地的名称
	 * @return List<TimeRecordPO> 返回时间记录持久化对象的列表
	 */
	public List<TimeRecordPO> getTimeRecords(City source, City destination)throws RemoteException;
}
