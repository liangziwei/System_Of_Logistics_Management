package businessLogic.businessLogicController.financeController;

import java.rmi.RemoteException;
import java.util.List;

import vo.businessVO.VehicleVO;
import vo.financeVO.AccountVO;
import vo.managerVO.OrganizationVO;
import vo.managerVO.StaffVO;
import vo.repositoryVO.RepositoryInfoVO;
import businessLogic.businessLogicModel.financeModel.OriginalInfo;
import businessLogicService.financeBLService.OriginalInfoBLService;

/**
 *业务逻辑层为展示层提供的期初建账服务的实现
 *@author 肖安祥 
 */
public class OriginalInfoController implements OriginalInfoBLService{
	
	private OriginalInfo original = new OriginalInfo();

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

	public List<RepositoryInfoVO> getRepositoryInfo(int year) {
		// TODO Auto-generated method stub
		return original.getRepositoryInfo(year);
	}

	public List<AccountVO> getAccountInfo(int year) {
		// TODO Auto-generated method stub
		return original.getAccountInfo(year);
	}

}
