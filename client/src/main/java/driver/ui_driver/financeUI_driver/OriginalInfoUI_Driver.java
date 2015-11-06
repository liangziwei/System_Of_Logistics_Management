package driver.ui_driver.financeUI_driver;

import java.util.List;

import businessLogicService.financeBLService.OriginalInfoBLService;
import stub.businessLogicImpl_stub.financeBLImpl_stub.OriginalInfoBLImpl_Stub;
import vo.businessVO.VehicleVO;
import vo.financeVO.AccountVO;
import vo.managerVO.OrganizationVO;
import vo.managerVO.StaffVO;
import vo.repositoryVO.RepositoryInfoVO;

public class OriginalInfoUI_Driver {

	public static void main(String[] args) {
		OriginalInfoBLService original = new OriginalInfoBLImpl_Stub();
		List<AccountVO> account =  original.getAccountInfo(1996);
		List<OrganizationVO> organizaion = original.getOrganizationInfo(1996);
		List<RepositoryInfoVO> repository = original.getRepositoryInfo(1996);
		List<StaffVO> staff = original.getStaffInfo(1996);
		List<VehicleVO> vehicle = original.getVehicleInfo(1996);
		System.out.println("期初账单信息如下：");
		System.out.println("==========================");
		showAccountInfo(account);
		System.out.println("==========================");
		showOrganizationInfo(organizaion);
		System.out.println("==========================");
		showRepositoryInfo(repository);
		System.out.println("==========================");
		showStaffInfo(staff);
		System.out.println("==========================");
		showVehicleInfo(vehicle);
		System.out.println("==========================");
	}
	
	private static void showAccountInfo(List<AccountVO> account) {
		System.out.println("银行信息如下：");
		for(int i = 0; i < account.size(); i++) {
			System.out.println("第" + (i + 1) + "个账户的信息为：");
			System.out.println("名称： " + account.get(i).getName());
			System.out.println("余额： " + account.get(i).getBalance());
			System.out.println();
		}
		
	}
	
	private static void showOrganizationInfo(List<OrganizationVO> org) {
		System.out.println("机构信息如下:");
		for(int i = 0; i < org.size(); i++) {
			System.out.println("第" + (i + 1) + "个机构的信息为：");
			System.out.println("机构编号为：" + org.get(i).getId());
			System.out.println("机构名称为：" + org.get(i).getName());
			System.out.println("机构类型为: " + org.get(i).getType());
			System.out.println();
		}
	}
	
	private static void showRepositoryInfo(List<RepositoryInfoVO> repository) {
		System.out.println("库存信息如下：");
		for(int i = 0; i < repository.size(); i++) {
			System.out.println("第" + (i + 1) + "份快递的信息为：");
			System.out.println("快递编号为：" + repository.get(i).getdeliveryid());
			System.out.println("快递金额为：" + repository.get(i).getmoney());
			System.out.println("区号为：" + repository.get(i).getareaCode());
			System.out.println("排号为：" + repository.get(i).getrowid());
			System.out.println("架号为： " + repository.get(i).getshelfid());
			System.out.println("位号为：" + repository.get(i).getposid());
		}
		
	}
	
	private static void showStaffInfo(List<StaffVO> staff) {
		System.out.println("人员信息如下：");
		for (int i = 0; i < staff.size(); i++) {
			System.out.println("第" + (i + 1) + "个人员的信息为：");
			System.out.println("姓名：" + staff.get(i).getName());
			System.out.println("性别" + staff.get(i).getGender());
			System.out.println("编号：" + staff.get(i).getId());
			System.out.println("职位：" + staff.get(i).getPosition());
			System.out.println("工资" + staff.get(i).getSalary());
		}	
	}
	
	private static void showVehicleInfo(List<VehicleVO> vehicle) {
		System.out.println("车辆信息如下：");
		for(int i = 0; i < vehicle.size(); i++) {
			System.out.println("第" + (i + 1) + "辆车辆信息如下：");
			System.out.println("车龄：" + vehicle.get(i).getAge());
			System.out.println("数量：" + vehicle.get(i).getNumber());
			System.out.println("编号: " + vehicle.get(i).getVehicleid());
		}
	}
}
