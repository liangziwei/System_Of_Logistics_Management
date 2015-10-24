package dataService.financeDataService;

import java.util.List;

import po.businessPO.VehiclePO;
import po.financePO.AccountPO;
import po.managerPO.OrganizationPO;
import po.managerPO.StaffPO;
import po.repositoryPO.RepositoryInfoPO;

public interface OriginalInfoDataService {

	/**
	 * description:根据年份获得该年份的所有人员信息
	 * 前置条件：逻辑层传送的年份有效
	 * 后置条件：根据年份查找所有的人员信息，并返回给逻辑层
	 * 需接口：无
	 * @param year 年份
	 * @return List<StaffPO>所有人员信息的持久化对象
	 */
	public List<StaffPO> getStaffInfo(int year);
	
	/**
	 * description:根据年份获得该年份的所有机构信息
	 * 前置条件：逻辑层传送的年份有效
	 * 后置条件：根据年份查找所有的机构信息，并返回给逻辑层
	 * 需接口：无
	 * @param year 年份
	 * @return List<OrganizationPO>所有机构信息的持久化对象
	 */
	public OrganizationPO getOrganizationInfo(int year);
	
	/**
	 * description:根据年份获得该年份的所有车辆信息
	 * 前置条件：逻辑层传送的年份有效
	 * 后置条件：根据年份查找所有的车辆信息，并返回给逻辑层
	 * 需接口：无
	 * @param year 年份
	 * @return List<StaffPO>所有车辆信息的持久化对象
	 */
	public List<VehiclePO> getVehicleInfo(int year);
	
	/**
	 * description:根据年份获得该年份的所有库存信息
	 * 前置条件：逻辑层传送的年份有效
	 * 后置条件：根据年份查找所有的库存信息，并返回给逻辑层
	 * 需接口：无
	 * @param year 年份
	 * @return List<RepositoryInfoPO>所有库存信息的持久化对象
	 */
	public RepositoryInfoPO getRepositoryInfo(int year);
	
	/**
	 * description:根据年份获得该年份的银行信息
	 * 前置条件：逻辑层传送的年份有效
	 * 后置条件：根据年份查找银行信息，并返回给逻辑层
	 * 需接口：无
	 * @param year 年份
	 * @return List<AccountPO>银行信息的持久化对象
	 */
	public AccountPO getAccountInfo(int year);
}
