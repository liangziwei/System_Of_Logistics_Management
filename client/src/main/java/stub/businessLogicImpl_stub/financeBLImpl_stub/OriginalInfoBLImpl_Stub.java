package stub.businessLogicImpl_stub.financeBLImpl_stub;

import java.util.ArrayList;
import java.util.List;

import businessLogicService.financeBLService.OriginalInfoBLService;
import dataService.financeDataService.OriginalInfoDataService;
import po.businessPO.VehiclePO;
import po.financePO.AccountPO;
import po.managerPO.OrganizationPO;
import po.managerPO.StaffPO;
import stub.dataImpl_stub.financeDataImpl_stub.OriginalInfoDataImpl_Stub;
import vo.businessVO.VehicleVO;
import vo.financeVO.AccountVO;
import vo.managerVO.OrganizationVO;
import vo.managerVO.StaffVO;
import vo.repositoryVO.RepositoryVO;

public class OriginalInfoBLImpl_Stub implements OriginalInfoBLService{

	private OriginalInfoDataService original = new OriginalInfoDataImpl_Stub();
	
	public List<StaffVO> getStaffInfo(int year) {
		List<StaffVO> list = null;
		try{
			list = this.StaffPOToStaffVO(original.getStaffInfo(year));
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public List<OrganizationVO> getOrganizationInfo(int year) {
		List<OrganizationVO> list = null;
		try{
			list = this.OrganizationVOToPO(original.getOrganizationInfo(year)); 
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public List<VehicleVO> getVehicleInfo(int year) {
		List<VehicleVO> list = null;
		try{
			list = this.vehiclePOToVO(original.getVehicleInfo(year));
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public List<RepositoryVO> getRepositoryInfo(int year) {
//		List<RepositoryInfoVO> list = null;
//		try{
//			list = this.repositoryPOToVO(original.getRepositoryInfo(year));
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		return null;
	}

	public List<AccountVO> getAccountInfo(int year) {
		List<AccountVO> list = null;
		try{
			list = this.accountPOToVO(original.getAccountInfo(year));
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	private List<StaffVO> StaffPOToStaffVO(List<StaffPO> staff) {
		List<StaffVO> s = new ArrayList<StaffVO>();
		for(int i = 0; i < staff.size(); i++) {
//			s.add(new StaffVO(staff.get(i).getName(), staff.get(i).getId(), staff.get(i).getPosition(),
//					staff.get(i).getGender(), staff.get(i).getBirthday(), staff.get(i).getSalary()));
		}
		return s;
	}
	
	private List<OrganizationVO> OrganizationVOToPO(List<OrganizationPO> org) {
		List<OrganizationVO> o = new ArrayList<OrganizationVO>();
		for(int i = 0; i < org.size(); i++) {
//			o.add(new OrganizationVO(org.get(i).getType(), org.get(i).getId(),
//					org.get(i).getName()));
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
	
//	private List<RepositoryInfoVO> repositoryPOToVO(List<RepositoryInfoPO> repository) {
//		List<RepositoryInfoVO> r = new ArrayList<RepositoryInfoVO>();
//		for(int i = 0; i < repository.size(); i++) {
//			r.add(new RepositoryInfoVO(repository.get(i).getdeliveryid(), repository.get(i).getareaCode(),
//					repository.get(i).getrowid(), repository.get(i).getshelfid(),
//					repository.get(i).getposid(), repository.get(i).getbeinrepository()));
//		}
//		return r;
//	}
}
