package businessLogicService.financeBLService;

import java.util.List;

import vo.businessVO.VehicleVO;
import vo.managerVO.OrganizationVO;
import vo.managerVO.StaffVO;

public interface OriginalInfoBLService {

//	+getStuffInfo(year:int):List<StuffVO>
//	+getOrganizationInfo(year:int):OrganizationVO
//	+getVehicleInfo(year:int):List<VehicleVO>
//	+getRepositoryInfo(year:int):RepositoryVO
//	+getBankInfo(year:int):BankVO
	/**
	 * 
	 */
	public List<StaffVO> getStaffInfo(int year);
	
	/**
	 * 
	 */
	public List<OrganizationVO> getOrganization(int year);
	
	/**
	 * 
	 */
	public List<VehicleVO> getVehicleInfo(int year);
	
	
}
