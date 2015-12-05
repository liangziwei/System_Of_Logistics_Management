package businessLogic.businessLogicModel.financeModel;

import java.util.ArrayList;
import java.util.List;

import network.RMI;
import po.businessPO.VehiclePO;
import po.financePO.AccountPO;
import po.managerPO.OrganizationPO;
import po.managerPO.StaffPO;
import po.repositoryPO.RepositoryInfoPO;
import po.repositoryPO.RepositoryPO;
import vo.businessVO.VehicleVO;
import vo.financeVO.AccountVO;
import vo.managerVO.OrganizationVO;
import vo.managerVO.StaffVO;
import vo.repositoryVO.RepositoryInfoVO;
import vo.repositoryVO.RepositoryVO;
import dataService.financeDataService.OriginalInfoDataService;

public class OriginalInfo {

	private OriginalInfoDataService originalInfo;

	public OriginalInfo(String order) {
		// TODO Auto-generated constructor stub
		if(order.equals("query")){
			originalInfo = RMI.<OriginalInfoDataService> getDataService("originalInfoRecord");
		}else{
		
			originalInfo = RMI.<OriginalInfoDataService> getDataService("originalInfo");
		}
	}
	
	public List<StaffVO> getStaffInfo(int year) {
		// TODO Auto-generated method stub
		List<StaffVO> list = null;
		try {
			list = this.StaffPOToStaffVO(originalInfo.getStaffInfo(year));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<OrganizationVO> getOrganizationInfo(int year) {
		// TODO Auto-generated method stub
		List<OrganizationVO> list = null;
		try {
			list = this.OrganizationPOToVO(originalInfo.getOrganizationInfo(year));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<VehicleVO> getVehicleInfo(int year) {
		// TODO Auto-generated method stub
		List<VehicleVO> list = null;
		try {
			list = this.vehiclePOToVO(originalInfo.getVehicleInfo(year));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<RepositoryVO> getRepositoryInfo(int year) {
		// TODO Auto-generated method stub
		List<RepositoryVO> list = null;
		try {
			list = this.repositoryPOToVO(originalInfo.getRepositoryInfo(year));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<AccountVO> getAccountInfo(int year) {
		// TODO Auto-generated method stub
		List<AccountVO> list = null;
		try {
			list = this.accountPOToVO(originalInfo.getAccountInfo(year));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	private List<StaffVO> StaffPOToStaffVO(List<StaffPO> staff) {
		List<StaffVO> s = new ArrayList<StaffVO>();
		// for(int i = 0; i < staff.size(); i++) {
		// s.add(new StaffVO(staff.get(i).getName(), staff.get(i).getId(),
		// staff.get(i).getPosition(),
		// staff.get(i).getGender(), staff.get(i).getBirthday(),
		// staff.get(i).getSalary()));
		// }
		return s;
	}

	private List<OrganizationVO> OrganizationPOToVO(List<OrganizationPO> org) {
		List<OrganizationVO> o = new ArrayList<OrganizationVO>();
		for (int i = 0; i < org.size(); i++) {
			// o.add(new OrganizationVO(org.get(i).getType(),
			// org.get(i).getId(),
			// org.get(i).getName()));
		}
		return o;
	}

	private List<VehicleVO> vehiclePOToVO(List<VehiclePO> vehicle) {
		List<VehicleVO> v = new ArrayList<VehicleVO>();
		for (int i = 0; i < vehicle.size(); i++) {
			v.add(new VehicleVO(vehicle.get(i).getVehicleid(), vehicle.get(i).getNumber(), vehicle.get(i).getAge()));
		}
		return v;
	}

	private List<AccountVO> accountPOToVO(List<AccountPO> account) {
		List<AccountVO> a = new ArrayList<AccountVO>();
		for (int i = 0; i < account.size(); i++) {
			a.add(new AccountVO(account.get(i).getName(), account.get(i).getBalance()));
		}
		return a;
	}

	private List<RepositoryVO> repositoryPOToVO(List<RepositoryPO> repository) {
		List<RepositoryVO> r = new ArrayList<RepositoryVO>();
		for (int i = 0; i < repository.size(); i++) {
			r.add(new RepositoryVO(repository.get(i).getdeliveryid(), repository.get(i).getinrepositorydate(),
					repository.get(i).getarrivalid(), repository.get(i).getareaCode(), repository.get(i).getrowid(),
					repository.get(i).getshelfid(), repository.get(i).getposid()));
		}
		return r;
	}
}
