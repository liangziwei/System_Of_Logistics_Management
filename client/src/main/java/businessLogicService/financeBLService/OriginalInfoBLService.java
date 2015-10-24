package businessLogicService.financeBLService;

import java.util.List;

import vo.businessVO.VehicleVO;
import vo.financeVO.AccountVO;
import vo.managerVO.OrganizationVO;
import vo.managerVO.StaffVO;
import vo.repositoryVO.RepositoryInfoVO;
/**
 *业务逻辑层为展示层提供的期初建账服务
 *@author 肖安祥 
 */
public interface OriginalInfoBLService {

	/**
	 * description:获得某一年份的人员信息
	 * 前置条件：界面传递的年份有效
	 * 后置条件：根据年份查询所有的人员信息，返回给界面展示
	 * 需接口：OriginalInfoDataService.getStaffInfo(int year)（根据年份查找所有的人员信息）
	 * @param year 年份
	 * @return List<StaffVO> 所有人员信息的值对象
	 */
	public List<StaffVO> getStaffInfo(int year);
	
	/**
	 * description:获得某一年份的机构信息
	 * 前置条件：界面传递的年份有效
	 * 后置条件：根据年份查询所有的机构信息，返回给界面展示
	 * 需接口：OriginalInfoDataService.getOrganizationInfo(int year)（根据年份查找所有的机构信息）
	 * @param year 年份
	 * @return List<OrganizationVO> 所有机构信息的值对象
	 */
	public List<OrganizationVO> getOrganization(int year);
	
	/**
	 * description:获得某一年份的车辆信息
	 * 前置条件：界面传递的年份有效
	 * 后置条件：根据年份查询所有的车辆信息，返回给界面展示
	 * 需接口：OriginalInfoDataService.getVehicleInfo(int year)（根据年份查找所有的车辆信息）
	 * @param year 年份
	 * @return List<VehicleVO> 所有车辆信息的值对象
	 */
	public List<VehicleVO> getVehicleInfo(int year);
	
	/**
	 * description:获得某一年份的库存信息
	 * 前置条件：界面传递的年份有效
	 * 后置条件：根据年份查询所有的库存信息，返回给界面展示
	 * 需接口：OriginalInfoDataService.getRepositoryInfo(int year)（根据年份查找所有的库存信息）
	 * @param year 年份
	 * @return List<RepositoryInfoVO> 所有库存信息的值对象
	 */
    public RepositoryInfoVO getRepositoryInfo(int year);
    
    /**
	 * description:获得某一年份的银行信息
	 * 前置条件：界面传递的年份有效
	 * 后置条件：根据年份查询银行信息，返回给界面展示
	 * 需接口：OriginalInfoDataService.getBankInfo(int year)（根据年份查找银行信息）
	 * @param year 年份
	 * @return List<AccountVO> 银行信息的值对象
	 */
    public AccountVO getAccountInfo(int year);
}
