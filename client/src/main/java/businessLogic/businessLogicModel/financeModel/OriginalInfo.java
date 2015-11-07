package businessLogic.businessLogicModel.financeModel;

import java.util.ArrayList;
import java.util.List;

import po.businessPO.VehiclePO;
import po.financePO.AccountPO;
import po.managerPO.OrganizationPO;
import po.managerPO.StaffPO;
import po.repositoryPO.RepositoryInfoPO;
import vo.businessVO.VehicleVO;
import vo.financeVO.AccountVO;
import vo.managerVO.OrganizationVO;
import vo.managerVO.StaffVO;
import vo.repositoryVO.RepositoryInfoVO;
import mock.object.MockOriginalInfoData;
import dataService.financeDataService.OriginalInfoDataService;

public class OriginalInfo {

	private OriginalInfoDataService originalInfo = new MockOriginalInfoData();
	
	public List<StaffVO> getStaffInfo(int year) {
		// TODO Auto-generated method stub
		return this.StaffPOToStaffVO(originalInfo.getStaffInfo(year));
	}

	public List<OrganizationVO> getOrganizationInfo(int year) {
		// TODO Auto-generated method stub
		return this.OrganizationPOToVO(originalInfo.getOrganizationInfo(year));
	}

	public List<VehicleVO> getVehicleInfo(int year) {
		// TODO Auto-generated method stub
		return this.vehiclePOToVO(originalInfo.getVehicleInfo(year));
	}

	public List<RepositoryInfoVO> getRepositoryInfo(int year) {
		// TODO Auto-generated method stub
		return this.repositoryPOToVO(originalInfo.getRepositoryInfo(year));
	}

	public List<AccountVO> getAccountInfo(int year) {
		// TODO Auto-generated method stub
		return this.accountPOToVO(originalInfo.getAccountInfo(year));
	}
	
	private List<StaffVO> StaffPOToStaffVO(List<StaffPO> staff) {
		List<StaffVO> s = new ArrayList<StaffVO>();
		for(int i = 0; i < staff.size(); i++) {
			s.add(new StaffVO(staff.get(i).getName(), staff.get(i).getId(), staff.get(i).getPosition(),
					staff.get(i).getGender(), staff.get(i).getBirthday(), staff.get(i).getSalary()));
		}
		return s;
	}
	
	private List<OrganizationVO> OrganizationPOToVO(List<OrganizationPO> org) {
		List<OrganizationVO> o = new ArrayList<OrganizationVO>();
		for(int i = 0; i < org.size(); i++) {
			o.add(new OrganizationVO(org.get(i).getType(), org.get(i).getId(),
					org.get(i).getName(), this.StaffPOToStaffVO(org.get(i).getStaffInfo())));
		}
		return o;
	}
	
	private List<VehicleVO> vehiclePOToVO(List<VehiclePO> vehicle) {
		List<VehicleVO> v = new ArrayList<VehicleVO>();
		for(int i = 0; i < vehicle.size(); i++) {
			v.add(new VehicleVO(vehicle.get(i).getVehicleid(),
					vehicle.get(i).getNumber(), vehicle.get(i).getAge()));
		}
		return v;
	}
	
	private List<AccountVO> accountPOToVO(List<AccountPO> account) {
		List<AccountVO> a = new ArrayList<AccountVO>();
		for(int i = 0; i < account.size(); i++) {
			a.add(new AccountVO(account.get(i).getName(), account.get(i).getBalance()));
		}
		return a;
	}
	
	private List<RepositoryInfoVO> repositoryPOToVO(List<RepositoryInfoPO> repository) {
		List<RepositoryInfoVO> r = new ArrayList<RepositoryInfoVO>();
		for(int i = 0; i < repository.size(); i++) {
			r.add(new RepositoryInfoVO(repository.get(i).getdeliveryid(), repository.get(i).getareaCode(),
					repository.get(i).getrowid(), repository.get(i).getshelfid(),
					repository.get(i).getposid(), repository.get(i).getbeinrepository()));
		}
		return r;
	}
}
