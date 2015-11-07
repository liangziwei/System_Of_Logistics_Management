package mock.object;

import java.util.ArrayList;
import java.util.List;

import constant.AreaCodeType;
import po.businessPO.VehiclePO;
import po.financePO.AccountPO;
import po.managerPO.OrganizationPO;
import po.managerPO.StaffPO;
import po.repositoryPO.RepositoryInfoPO;
import dataService.financeDataService.OriginalInfoDataService;

public class MockOriginalInfoData implements OriginalInfoDataService{
	public List<StaffPO> getStaffInfo(int year){
		List<StaffPO> staff = new ArrayList<StaffPO>();
		staff.add(new StaffPO("小明", "B1235468", "快递员", "男",
			"1987-02-15", "按提成"));
		staff.add(new StaffPO("小红", "B1235468", "快递员", "女",
			"1990-02-25", "按提成"));
		return staff;
	}
	
	public List<OrganizationPO> getOrganizationInfo(int year){
		List<OrganizationPO> org = new ArrayList<OrganizationPO>();
		ArrayList<StaffPO> staff = new ArrayList<StaffPO>();
		staff.add(new StaffPO("小明", "B1235468", "快递员", "男",
			"1987-02-15", "按提成"));
		staff.add(new StaffPO("小红", "B1235468", "快递员", "女",
			"1990-02-25", "按提成"));
		org.add(new OrganizationPO("营业厅", "001", "南京市营业厅", staff));
		org.add(new OrganizationPO("中转中心", "002", "南京市中转中心", staff));
		return org;
	}
	
	public List<VehiclePO> getVehicleInfo(int year){
		List<VehiclePO> vehicle = new ArrayList<VehiclePO>();
		vehicle.add(new VehiclePO("025001001","苏A 00001","2"));
		vehicle.add(new VehiclePO("025001002","苏B 00002","3"));
		return vehicle;
	}
	
	public List<RepositoryInfoPO> getRepositoryInfo(int year){
		List<RepositoryInfoPO> repository = new ArrayList<RepositoryInfoPO>();
		repository.add(new RepositoryInfoPO("1232409000",AreaCodeType.PLANEAREA, "014","101","067", true));
		repository.add(new RepositoryInfoPO("1232409120",AreaCodeType.PLANEAREA, "015","111","167", false));
		repository.add(new RepositoryInfoPO("1232409010",AreaCodeType.TRAINAREA, "024","001","067", true));
		repository.add(new RepositoryInfoPO("1682409010",AreaCodeType.TRUCKAREA, "064","041","014", false));
		return repository;
	}

	public List<AccountPO> getAccountInfo(int year){
		List<AccountPO> account = new ArrayList<AccountPO>();
		account.add(new AccountPO("建设银行",100000.0));
		account.add(new AccountPO("工商银行",200000.0));
		return account;
	}
}
