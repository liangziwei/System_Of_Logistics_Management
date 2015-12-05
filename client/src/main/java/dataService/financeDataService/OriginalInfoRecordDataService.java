package dataService.financeDataService;

import java.rmi.RemoteException;
import java.util.List;

import po.businessPO.VehiclePO;
import po.financePO.AccountPO;
import po.managerPO.OrganizationPO;
import po.managerPO.StaffPO;
import po.repositoryPO.RepositoryPO;

public interface OriginalInfoRecordDataService extends OriginalInfoDataService {

	/**
	 *存储员工信息 
	 * @param 年份
	 * @param 人员列表
	 * @return 是否创建成功
	 */
	public boolean addStaffInfo(int year,List<StaffPO> list) throws RemoteException;
	
	/**
	 *存储机构信息 
	 * @param 年份
	 * @param 机构列表
	 * @return 是否创建成功
	 */
	public  boolean addOrganizationInfo(int year,List<OrganizationPO> list) throws RemoteException;
	
	/**
	 *存储车辆信息 
	 * @param 年份
	 * @param 车辆信息列表
	 * @return 是否创建成功
	 */
	public  boolean addVehicleInfo(int year,List<VehiclePO> list) throws RemoteException;
	
	/**
	 *存储库存信息 
	 * @param 年份
	 * @param 库存信息列表
	 * @return 是否创建成功
	 */
	public  boolean addRepositoryInfo(int year,List<RepositoryPO> list) throws RemoteException;
	
	/**
	 *存储银行账户信息 
	 * @param 年份
	 * @param 银行账户列表
	 * @return 是否创建成功
	 */
	public boolean addAccountInfo(int year,List<AccountPO> list) throws RemoteException;
	
	/**
	 *获取已有年份的列表 
	 * @return 已经建账的年份
	 */
	public List<Integer> getYearList() throws RemoteException;
}
