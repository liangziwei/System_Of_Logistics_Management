package dataService.repositoryDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataService.ApproveFormService;
import po.repositoryPO.InRepositoryPO;

/**
 *description:数据服务层为中转中心库存管理的入库单信息管理提供的服务 
 * @author 阮威威
 */
public interface InRepositoryDataService extends Remote, ApproveFormService{
	
	/**
	 * description:添加新的入库单信息
	 * 前置条件：逻辑层传送的InRepositoryPO不为null且格式正确
	 * 后置条件：保存入库单
	 * 需接口：无
	 * @param InRepositoryPO ,入库单信息的相关持久化对象存储，具体参照InRepositoryPO的定义
	 * @return boolean, 返回给方法调用者入库单信息是否添加成功
	 * */
	public boolean AddInRepositoryFormDT(InRepositoryPO inRepositoryPO)throws RemoteException;
	
	/**
	 * description:修改入库单信息
	 * 前置条件：逻辑层传送的InRepositoryPO不为null且格式正确
	 * 后置条件：修改入库单
	 * 需接口：无
	 * @param InRepositoryPO ,入库单信息的相关持久化对象存储，具体参照InRepositoryPO的定义
	 * @return boolean, 返回给方法调用者入库单信息是否修改成功
	 * */
	public boolean ModifyInRepositoryFormDT(InRepositoryPO inRepository)throws RemoteException;
	
	/**
	 * description:通过入库单的快递编号得到相应的入库单信息
	 * 前置条件：逻辑层传送的InRepositoryNumber正确
	 * 后置条件：将获得的入库单信息返回给逻辑层
	 * 需接口：无
	 * @param InRepositoryNumber ,入库单的快递编号（十位数字）
	 * @return InRepositoryPO, 返回入库单信息的持久化对象，具体参照InRepositoryPO的定义
	 */
	public InRepositoryPO FindInRepositoryFormDT(String InRepositoryNumber)throws RemoteException;
	
	/**
	 * description:根据入库单信息更新库存信息
	 * 前置条件：逻辑层传送的InRepositoryPO不为null且格式正确
	 * 后置条件：库存信息更新(添加，修改)
	 * 需接口：无
	 * @param InRepositoryPO , 入库单信息的相关持久化对象存储，具体参照InRepositoryPO的定义
	 * @return boolean, 返回给方法调用者库存信息是否更新成功
	 * */
	public boolean UpdateRepositoryInfoDT(InRepositoryPO inRepository)throws RemoteException;
	
	/**
	 * description:根据入库单信息更新库存信息
	 * 前置条件：逻辑层传送的InRepositoryPO不为null且格式正确
	 * 后置条件：库存信息更新(修改)
	 * 需接口：无
	 * @param InRepositoryPO , 入库单信息的相关持久化对象存储，具体参照InRepositoryPO的定义
	 * @return boolean, 返回给方法调用者库存信息是否更新成功
	 * */
	public boolean modifyUpdateRepositoryInfoDT(InRepositoryPO inRepository)throws RemoteException;
	
}
