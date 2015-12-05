package businessLogic.businessLogicModel.financeModel;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import network.RMI;
import po.businessPO.VehiclePO;
import po.financePO.AccountPO;
import po.managerPO.OrganizationPO;
import po.managerPO.StaffPO;
import po.repositoryPO.RepositoryPO;
import vo.businessVO.VehicleVO;
import vo.financeVO.AccountVO;
import vo.managerVO.OrganizationVO;
import vo.managerVO.StaffVO;
import vo.repositoryVO.RepositoryVO;
import businessLogicService.financeBLService.OriginalInfoRecordBLService;
import dataService.financeDataService.OriginalInfoDataService;
import dataService.financeDataService.OriginalInfoRecordDataService;

public class OriginalRecord{

	private OriginalInfoRecordDataService originalInfo= (OriginalInfoRecordDataService) RMI.<OriginalInfoDataService> getDataService("originalInfoRecord");;
	
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

	public boolean addStaffInfo(int year, List<StaffVO> list) {
		// TODO Auto-generated method stub		
		try {
			return originalInfo.addStaffInfo(year, StaffVOToPO(list));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean addOrganizationInfo(int year, List<OrganizationVO> list) {
		// TODO Auto-generated method stub
		try {
			return originalInfo.addOrganizationInfo(year, OrganizationVOToPO(list));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean addVehicleInfo(int year, List<VehicleVO> list) {
		// TODO Auto-generated method stub
		try {
			return originalInfo.addVehicleInfo(year, vehicleVOToPO(list));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean addRepositoryInfo(int year, List<RepositoryVO> list) {
		// TODO Auto-generated method stub
		try {
			return originalInfo.addRepositoryInfo(year, repositoryVOToPO(list));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean addAccountInfo(int year, List<AccountVO> list) {
		// TODO Auto-generated method stub
		try {
			return originalInfo.addAccountInfo(year, accountVOToPO(list));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public List<Integer> getYearList() {
		// TODO Auto-generated method stub
		try {
			return originalInfo.getYearList();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private List<StaffVO> StaffPOToStaffVO(List<StaffPO> staff) {
		List<StaffVO> s = new ArrayList<StaffVO>();
		// for(int i = 0; i < staff.size(); i++) {
		// s.add(new StaffVO(staff.get(i).getName(), staff.get(i).getId(),
		// staff.get(i).getPosition(),
		// staff.get(i).getGender(), staff.get(i).getBirthday(),
		// staff.get(i).getSalary()));
		// }
		for(StaffPO staffPO:staff){
			s.add(new StaffVO(staffPO.getName(), staffPO.getId(),staffPO.getPosition(),staffPO.getGender(),
			staffPO.getBirthday(),staffPO.getSalary(),null,true,false));
		}
		return s;
	}

	private List<StaffPO> StaffVOToPO(List<StaffVO> staff) {
		List<StaffPO> s = new ArrayList<StaffPO>();
		
		for(StaffVO staffVO:staff){
			s.add(new StaffPO(staffVO.getName(), staffVO.getId(),staffVO.getPosition(),staffVO.getGender(),
			staffVO.getBirthday(),staffVO.getSalary(),null,true,false));
		}
		return s;
	}
	
	private List<OrganizationVO> OrganizationPOToVO(List<OrganizationPO> org) {
		List<OrganizationVO> o = new ArrayList<OrganizationVO>();
		for (OrganizationPO organizationPO:org) {
			// o.add(new OrganizationVO(org.get(i).getType(),
			// org.get(i).getId(),
			// org.get(i).getName()));
			o.add(new OrganizationVO(organizationPO.getType(),organizationPO.getId(),organizationPO.getName(),true,true));
		}
		return o;
	}

	private List<OrganizationPO> OrganizationVOToPO(List<OrganizationVO> org) {
		List<OrganizationPO> o = new ArrayList<OrganizationPO>();
		for (OrganizationVO organizationVO:org) {
			// o.add(new OrganizationVO(org.get(i).getType(),
			// org.get(i).getId(),
			// org.get(i).getName()));
			o.add(new OrganizationPO(organizationVO.getType(),organizationVO.getId(),organizationVO.getName(),true,true));
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
	
	private List<VehiclePO> vehicleVOToPO(List<VehicleVO> vehicle) {
		List<VehiclePO> v = new ArrayList<VehiclePO>();
		for (int i = 0; i < vehicle.size(); i++) {
			v.add(new VehiclePO(vehicle.get(i).getVehicleid(), vehicle.get(i).getNumber(), vehicle.get(i).getAge()));
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
	
	private List<AccountPO> accountVOToPO(List<AccountVO> account) {
		List<AccountPO> a = new ArrayList<AccountPO>();
		for (int i = 0; i < account.size(); i++) {
			a.add(new AccountPO(account.get(i).getName(), account.get(i).getBalance()));
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
	
	private List<RepositoryPO> repositoryVOToPO(List<RepositoryVO> repository) {
		List<RepositoryPO> r = new ArrayList<RepositoryPO>();
		for (int i = 0; i < repository.size(); i++) {
			r.add(new RepositoryPO(repository.get(i).getdeliveryid(), repository.get(i).getinrepositorydate(),
					repository.get(i).getarrivalid(), repository.get(i).getareaCode(), repository.get(i).getrowid(),
					repository.get(i).getshelfid(), repository.get(i).getposid()));
		}
		return r;
	}
}
