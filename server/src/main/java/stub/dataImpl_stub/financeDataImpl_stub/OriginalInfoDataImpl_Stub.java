package stub.dataImpl_stub.financeDataImpl_stub;

import java.util.ArrayList;
import java.util.List;

import constant.AreaCodeType;
import dataService.financeDataService.OriginalInfoDataService;
import po.businessPO.VehiclePO;
import po.financePO.AccountPO;
import po.managerPO.OrganizationPO;
import po.managerPO.StaffPO;
import po.repositoryPO.RepositoryPO;

public class OriginalInfoDataImpl_Stub implements OriginalInfoDataService{

	public List<StaffPO> getStaffInfo(int year) {
		List<StaffPO> staff = new ArrayList<StaffPO>();
//		staff.add(new StaffPO("小明", "B1235468", "快递员", "男",
//			"1987-02-15", "按提成"));
//		staff.add(new StaffPO("小红", "B1235468", "快递员", "女",
//			"1990-02-25", "按提成"));
		return staff;
	}

	public List<OrganizationPO> getOrganizationInfo(int year) {
		List<OrganizationPO> org = new ArrayList<OrganizationPO>();
		ArrayList<String> staff = new ArrayList<String>();
		staff.add("B1235468");
		staff.add("B1235468");
//		org.add(new OrganizationPO("营业厅", "001", "南京市营业厅"));
//		org.add(new OrganizationPO("中转中心", "002", "南京市中转中心"));
		return org;
	}

	public List<VehiclePO> getVehicleInfo(int year) {
		List<VehiclePO> vehicle = new ArrayList<VehiclePO>();
		vehicle.add(new VehiclePO("025001001","苏A 00001","2"));
		vehicle.add(new VehiclePO("025001002","苏B 00002","3"));
		return vehicle;
	}

	public List<RepositoryPO> getRepositoryInfo(int year) {
		List<RepositoryPO> repository = new ArrayList<RepositoryPO>();
		repository.add(new RepositoryPO("1232409000","","",AreaCodeType.PLANEAREA, "014","101","067"));
		repository.add(new RepositoryPO("1232409120","","",AreaCodeType.PLANEAREA, "015","111","167"));
		repository.add(new RepositoryPO("1232409010","","",AreaCodeType.TRAINAREA, "024","001","067"));
		repository.add(new RepositoryPO("1682409010","","",AreaCodeType.TRUCKAREA, "064","041","014"));
		return repository;
	}

	public List<AccountPO> getAccountInfo(int year) {
		List<AccountPO> account = new ArrayList<AccountPO>();
		account.add(new AccountPO("建设银行",100000.0));
		account.add(new AccountPO("工商银行",200000.0));
		return account;
	}

}
