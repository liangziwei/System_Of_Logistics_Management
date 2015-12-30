package dataService.repositoryDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dataService.ApproveFormService;
import po.repositoryPO.OutRepositoryPO;

/**
 *description:数据服务层为中转中心库存管理的出库单信息管理提供的服务 
 * @author 阮威威
 */
public interface OutRepositoryDataService extends Remote, ApproveFormService{
	
	/**
	 * description:添加新的出库单信息
	 * 前置条件：逻辑层传送的OutRepositoryPO不为null且格式正确
	 * 后置条件：保存出库单
	 * 需接口：无
	 * @param OutRepositoryPO ,出库单信息的相关持久化对象存储，具体参照OutRepositoryPO的定义
	 * @return boolean, 返回给方法调用者出库单信息是否添加成功
	 * */
	public boolean AddOutRepositoryFormDT(OutRepositoryPO outRepository)throws RemoteException;
	
	/**
	 * description:修改出库单信息
	 * 前置条件：逻辑层传送的OutRepositoryPO不为null且格式正确
	 * 后置条件：修改出库单
	 * 需接口：无
	 * @param OutRepositoryPO ,出库单信息的相关持久化对象存储，具体参照OutRepositoryPO的定义
	 * @return boolean, 返回给方法调用者出库单信息是否修改成功
	 * */
	public boolean ModifyOutRepositoryFormDT(OutRepositoryPO outRepositoryPO)throws RemoteException;
	
	/**
	 * description:通过出库单的快递编号得到相应的出库单信息
	 * 前置条件：逻辑层传送的OutRepositoryNumber正确
	 * 后置条件：将获得的出库单信息返回给逻辑层
	 * 需接口：无
	 * @param OutRepositoryNumber ,出库单的快递编号（十位数字）
	 * @return OutRepositoryPO, 返回出库单信息的持久化对象，具体参照OutRepositoryPO的定义
	 */
	public OutRepositoryPO FindOutRepositoryFormDT(String OutRepositoryNumber)throws RemoteException;
	
	/**
	 * description:根据出库单信息更新库存信息
	 * 前置条件：逻辑层传送的OutRepositoryPO不为null且格式正确
	 * 后置条件：库存信息更新(添加，修改)
	 * 需接口：无
	 * @param OutRepositoryPO , 出库单信息的相关持久化对象存储，具体参照OutRepositoryPO的定义
	 * @return boolean, 返回给方法调用者库存信息是否更新成功
	 * */
	public boolean UpdateRepositoryInfoDT(OutRepositoryPO outRepositoryPO)throws RemoteException;
	//查询相关装运单的所有快递编号
	public List<String> getdeliveryid(String loadingid)throws RemoteException;
	
//	/**
//	 *审批一张出库单 
//	 */
//	public boolean approveOneOutRepository(OutRepositoryPO form) throws RemoteException;
//	
//	/**
//	 *审批多张出库单 
//	 */
//	public boolean approveMoreOutRepository(ArrayList<OutRepositoryPO> form) throws RemoteException;
}
