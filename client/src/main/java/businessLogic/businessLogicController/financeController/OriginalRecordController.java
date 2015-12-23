package businessLogic.businessLogicController.financeController;

import java.util.List;

import businessLogic.businessLogicModel.financeModel.OriginalRecord;
import businessLogicService.financeBLService.OriginalInfoRecordBLService;
import vo.businessVO.VehicleVO;
import vo.financeVO.AccountVO;
import vo.managerVO.OrganizationVO;
import vo.managerVO.StaffVO;
import vo.repositoryVO.RepositoryVO;

public class OriginalRecordController implements OriginalInfoRecordBLService{
	OriginalRecord originalrecord = new OriginalRecord();
	@Override
	public List<StaffVO> getStaffInfo(int year) {
		// TODO Auto-generated method stub
		return originalrecord.getStaffInfo(year);
	}

	@Override
	public List<OrganizationVO> getOrganizationInfo(int year) {
		// TODO Auto-generated method stub
		return originalrecord.getOrganizationInfo(year);
	}

	@Override
	public List<VehicleVO> getVehicleInfo(int year) {
		// TODO Auto-generated method stub
		return originalrecord.getVehicleInfo(year);
	}

	@Override
	public List<RepositoryVO> getRepositoryInfo(int year) {
		// TODO Auto-generated method stub
		return originalrecord.getRepositoryInfo(year);
	}

	@Override
	public List<AccountVO> getAccountInfo(int year) {
		// TODO Auto-generated method stub
		return originalrecord.getAccountInfo(year);
	}

	@Override
	public boolean addStaffInfo(int year, List<StaffVO> list) {
		// TODO Auto-generated method stub
		return originalrecord.addStaffInfo(year, list);
	}

	@Override
	public boolean addOrganizationInfo(int year, List<OrganizationVO> list) {
		// TODO Auto-generated method stub
		return originalrecord.addOrganizationInfo(year, list);
	}

	@Override
	public boolean addVehicleInfo(int year, List<VehicleVO> list) {
		// TODO Auto-generated method stub
		return originalrecord.addVehicleInfo(year, list);
	}

	@Override
	public boolean addRepositoryInfo(int year, List<RepositoryVO> list) {
		// TODO Auto-generated method stub
		return originalrecord.addRepositoryInfo(year, list);
	}

	@Override
	public boolean addAccountInfo(int year, List<AccountVO> list) {
		// TODO Auto-generated method stub
		return originalrecord.addAccountInfo(year, list);
	}

	@Override
	public List<Integer> getYearList() {
		// TODO Auto-generated method stub
		return originalrecord.getYearList();
	}

}
