package mock.test;

import java.util.ArrayList;
import java.util.List;

import mock.object.MockOriginalInfoData;

import org.junit.Test;
import static org.junit.Assert.*;

import po.businessPO.VehiclePO;
import po.financePO.AccountPO;
import po.managerPO.OrganizationPO;
import po.managerPO.StaffPO;
import po.repositoryPO.RepositoryInfoPO;
import constant.AreaCodeType;

public class OriginalInfoTest {

	@Test
	public void test() {
		MockOriginalInfoData originalInfo = new MockOriginalInfoData();
		List<StaffPO> stafflist = originalInfo.getStaffInfo(2015);
		List<OrganizationPO>  organizationlist = originalInfo.getOrganizationInfo(2015);
		List<VehiclePO> vehiclelist = originalInfo.getVehicleInfo(2015);
		List<RepositoryInfoPO> repositoryInfolist = originalInfo.getRepositoryInfo(2015);
		List<AccountPO> accountlist = originalInfo.getAccountInfo(2015);
		List<StaffPO> staff = new ArrayList<StaffPO>();
		staff.add(new StaffPO("小明", "B1235468", "快递员", "男",
			"1987-02-15", "按提成"));
		staff.add(new StaffPO("小红", "B1235468", "快递员", "女",
			"1990-02-25", "按提成"));
		
		List<OrganizationPO> org = new ArrayList<OrganizationPO>();
		ArrayList<StaffPO> staffs = new ArrayList<StaffPO>();
		staffs.add(new StaffPO("小明", "B1235468", "快递员", "男",
			"1987-02-15", "按提成"));
		staffs.add(new StaffPO("小红", "B1235468", "快递员", "女",
			"1990-02-25", "按提成"));
		org.add(new OrganizationPO("营业厅", "001", "南京市营业厅", staffs));
		org.add(new OrganizationPO("中转中心", "002", "南京市中转中心", staffs));
		
		List<VehiclePO> vehicle = new ArrayList<VehiclePO>();
		vehicle.add(new VehiclePO("025001001","苏A 00001","2"));
		vehicle.add(new VehiclePO("025001002","苏B 00002","3"));
		
		List<RepositoryInfoPO> repository = new ArrayList<RepositoryInfoPO>();
		repository.add(new RepositoryInfoPO("1232409000",AreaCodeType.PLANEAREA, "014","101","067", true));
		repository.add(new RepositoryInfoPO("1232409120",AreaCodeType.PLANEAREA, "015","111","167", false));
		repository.add(new RepositoryInfoPO("1232409010",AreaCodeType.TRAINAREA, "024","001","067", true));
		repository.add(new RepositoryInfoPO("1682409010",AreaCodeType.TRUCKAREA, "064","041","014", false));
		
		List<AccountPO> account = new ArrayList<AccountPO>();
		account.add(new AccountPO("建设银行",100000.0));
		account.add(new AccountPO("工商银行",200000.0));
		
		assertEquals(staff.size(), stafflist.size());
		assertEquals(vehicle.size(),vehiclelist.size());
		assertEquals(account.size(), accountlist.size());
		assertEquals(repository.size(), repositoryInfolist.size());
		assertEquals(org.size(), organizationlist.size());
	}

}
