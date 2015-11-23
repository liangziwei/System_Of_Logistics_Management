package driver.ui_driver.managerUI_driver;

import java.util.ArrayList;
import java.util.Scanner;

import stub.businessLogicImpl_stub.managerBLImpl_stub.OrganizationManagementBLImpl_Stub;
import vo.managerVO.OrganizationVO;
import businessLogicService.managerBLService.OrganizationManagementBLService;

public class OrganizationManagementUI_DriverStub {
	public static void main(String[] args) {
		OrganizationManagementBLService organization = new OrganizationManagementBLImpl_Stub();
		boolean go = true;
		Scanner s = new Scanner(System.in);
		while(go) {
			System.out.println("请输入请求:(1)添加机构信息（2）删除机构信息"
					+ "（3）修改机构信息（4）查询机构信息（5）退出");
			int input = s.nextInt();
			switch(input) {
			case 1:
				ArrayList<String> staffInfo = new ArrayList<String>();
				staffInfo.add("B1235468");
				staffInfo.add("B1289568");
				staffInfo.add("B1784468");
				OrganizationVO organizationVO = new OrganizationVO(null, null, null, staffInfo);
				System.out.println("添加机构信息是否成功："+organization.addOrganization(organizationVO));
				break;
			case 2:
				System.out.println("删除机构信息是否成功："+organization.deleteOrganization(null));
				break;
			case 3:
				staffInfo = new ArrayList<String>();
				staffInfo.add("B1235468");
				staffInfo.add("B1289568");
				staffInfo.add("B1784468");
				organizationVO = new OrganizationVO(null, null, null, staffInfo);
				System.out.println("修改机构信息是否成功："+organization.modifyOrganization(organizationVO));
				break;
			case 4:
				organizationVO = organization.findOrganization(null);
				System.out.println("机构信息："+"\n"+"类型："+organizationVO.getType()
				+"id："+organizationVO.getId()+"名称："+organizationVO.getName()+"\n"+"人员信息：");
				for(int i=0;i<organizationVO.getStaffInfo().size();i++){
					System.out.println("姓名："+organizationVO.getStaffInfo().get(i));
				}
				
				break;
			case 5:
				go = false;
				break;
			}
		}
		s.close();
	}
}
