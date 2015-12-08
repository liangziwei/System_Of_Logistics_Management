package businessLogic.businessLogicController.financeController;

import java.util.List;

import businessLogic.businessLogicModel.financeModel.OriginalInfo;
import businessLogicService.financeBLService.OriginalInfoBLService;
import vo.businessVO.VehicleVO;
import vo.financeVO.AccountVO;
import vo.managerVO.OrganizationVO;
import vo.managerVO.StaffVO;
import vo.repositoryVO.RepositoryVO;

/**
 *业务逻辑层为展示层提供的期初建账服务的实现
 *@author 肖安祥 
 */
public class OriginalInfoController implements OriginalInfoBLService{
	
	private OriginalInfo original;

	public OriginalInfoController(String order) {
		// TODO Auto-generated constructor stub
		original = new OriginalInfo();
	}
	
	public List<StaffVO> getStaffInfo(int year)  {
		// TODO Auto-generated method stub
		return original.getStaffInfo(year);
	}

	public List<OrganizationVO> getOrganizationInfo(int year) {
		// TODO Auto-generated method stub
		return original.getOrganizationInfo(year);
	}

	public List<VehicleVO> getVehicleInfo(int year) {
		// TODO Auto-generated method stub
		return original.getVehicleInfo(year);
	}

	public List<RepositoryVO> getRepositoryInfo(int year) {
		// TODO Auto-generated method stub
		return original.getRepositoryInfo(year);
	}

	public List<AccountVO> getAccountInfo(int year) {
		// TODO Auto-generated method stub
		return original.getAccountInfo(year);
	}

}
