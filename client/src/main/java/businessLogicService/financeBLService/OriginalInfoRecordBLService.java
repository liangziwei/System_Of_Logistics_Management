package businessLogicService.financeBLService;

import java.util.List;

import vo.businessVO.VehicleVO;
import vo.financeVO.AccountVO;
import vo.managerVO.OrganizationVO;
import vo.managerVO.StaffVO;
import vo.repositoryVO.RepositoryVO;

public interface OriginalInfoRecordBLService extends OriginalInfoBLService {
	/**
	 *存储员工信息 
	 * @param 年份
	 * @param 人员列表
	 * @return 是否创建成功
	 */
	public boolean addStaffInfo(int year,List<StaffVO> list);
	
	/**
	 *存储机构信息 
	 * @param 年份
	 * @param 机构列表
	 * @return 是否创建成功
	 */
	public  boolean addOrganizationInfo(int year,List<OrganizationVO> list);
	
	/**
	 *存储车辆信息 
	 * @param 年份
	 * @param 车辆信息列表
	 * @return 是否创建成功
	 */
	public  boolean addVehicleInfo(int year,List<VehicleVO> list);
	
	/**
	 *存储库存信息 
	 * @param 年份
	 * @param 库存信息列表
	 * @return 是否创建成功
	 */
	public  boolean addRepositoryInfo(int year,List<RepositoryVO> list);
	
	/**
	 *存储银行账户信息 
	 * @param 年份
	 * @param 银行账户列表
	 * @return 是否创建成功
	 */
	public boolean addAccountInfo(int year,List<AccountVO> list);
	
	/**
	 *获取已有年份的列表 
	 * @return 已经建账的年份
	 */
	public List<Integer> getYearList();
}
