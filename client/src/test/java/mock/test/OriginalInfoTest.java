package mock.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import vo.businessVO.VehicleVO;
import vo.financeVO.AccountVO;
import vo.managerVO.OrganizationVO;
import vo.managerVO.StaffVO;
import vo.repositoryVO.RepositoryInfoVO;
import businessLogic.businessLogicController.financeController.OriginalInfoController;
import constant.AreaCodeType;

public class OriginalInfoTest {

	@Test
	public void test() {
		OriginalInfoController originalInfo = new OriginalInfoController();
		List<StaffVO> stafflist = originalInfo.getStaffInfo(2015);
		List<OrganizationVO>  organizationlist = originalInfo.getOrganizationInfo(2015);
		List<VehicleVO> vehiclelist = originalInfo.getVehicleInfo(2015);
		List<RepositoryInfoVO> repositoryInfolist = originalInfo.getRepositoryInfo(2015);
		List<AccountVO> accountlist = originalInfo.getAccountInfo(2015);
		List<StaffVO> staff = new ArrayList<StaffVO>();
//		staff.add(new StaffVO("小明", "B1235468", "快递员", "男",
//			"1987-02-15", "按提成"));
//		staff.add(new StaffVO("小红", "B1235468", "快递员", "女",
//			"1990-02-25", "按提成"));
		
		List<OrganizationVO> org = new ArrayList<OrganizationVO>();
		ArrayList<String> staffs = new ArrayList<String>();
		staffs.add("B1235468");
		staffs.add("B1235468");
//		org.add(new OrganizationVO("营业厅", "001", "南京市营业厅"));
//		org.add(new OrganizationVO("中转中心", "002", "南京市中转中心"));
		
		List<VehicleVO> vehicle = new ArrayList<VehicleVO>();
		vehicle.add(new VehicleVO("025001001","苏A 00001","2"));
		vehicle.add(new VehicleVO("025001002","苏B 00002","3"));
		
		List<RepositoryInfoVO> repository = new ArrayList<RepositoryInfoVO>();
		repository.add(new RepositoryInfoVO("1232409000",AreaCodeType.PLANEAREA, "014","101","067", true));
		repository.add(new RepositoryInfoVO("1232409120",AreaCodeType.PLANEAREA, "015","111","167", false));
		repository.add(new RepositoryInfoVO("1232409010",AreaCodeType.TRAINAREA, "024","001","067", true));
		repository.add(new RepositoryInfoVO("1682409010",AreaCodeType.TRUCKAREA, "064","041","014", false));
		
		List<AccountVO> account = new ArrayList<AccountVO>();
		account.add(new AccountVO("建设银行",100000.0));
		account.add(new AccountVO("工商银行",200000.0));
		
		assertEquals(staff.size(), stafflist.size());
		assertEquals(vehicle.size(),vehiclelist.size());
		assertEquals(account.size(), accountlist.size());
		assertEquals(repository.size(), repositoryInfolist.size());
		assertEquals(org.size(), organizationlist.size());
	}

}
