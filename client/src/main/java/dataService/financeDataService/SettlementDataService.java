package dataService.financeDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.businessPO.ReceivablePO;



/**
 * description:数据服务层为结算管理逻辑处理提供的服务
 * @author 张仁知
 */
public interface SettlementDataService extends Remote{

	/**
	 * description:显示当天所有收款单记录
	 * 前置条件：无
	 * 后置条件：按日期进行查找返回相应的收款单列表
	 * @param  date ,当天日期（yyyy-mm-dd）
	 * @return List<ReceivablePO> ,返回记录收款单信息对象的列表
	 */
	public List<ReceivablePO> getReceiList(String date) throws RemoteException;
	
	/**
	 * description:显示当天XX营业厅收款单记录
	 * 前置条件：无
	 * 后置条件：按营业厅编号和日期返回当天XX营业厅收款单列表
	 * @param  date ,当天日期（yyyy-mm-dd）
	 * @param  id ,营业厅编号
	 * @return List<ReceivablePO> ,返回记录收款单信息对象的列表
	 */
	public List<ReceivablePO> getBusinessRecei(String id,String date) throws RemoteException;
}
