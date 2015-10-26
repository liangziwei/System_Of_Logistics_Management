package driver.ui_driver.managerUI_driver;

import java.util.ArrayList;
import java.util.Scanner;

import po.managerPO.StaffPO;
import stub.businessLogicImpl_stub.managerBLImpl_stub.OrganizationManagementBLImpl_Stub;
import vo.managerVO.OrganizationVO;
import vo.managerVO.StaffVO;
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
				ArrayList<StaffVO> staffInfo = new ArrayList<StaffVO>();
				staffInfo.add(new StaffVO("小明", "B1235468", "快递员", "男","1987-02-15", "按提成"));
				staffInfo.add(new StaffVO("小李", "B1289568", "业务员", "男","1984-08-11", "按月"));
				staffInfo.add(new StaffVO("小王", "B1784468", "快递员", "男","195", "按提成"));
				OrganizationVO organizationVO = new OrganizationVO(null, null, null, staffInfo);
				System.out.println("添加机构信息是否成功："+organization.addOrganization(organizationVO));
				break;
			case 2:
				System.out.println("删除机构信息是否成功："+organization.deleteOrganization(null));
				break;
			case 3:
				staffInfo = new ArrayList<StaffVO>();
				staffInfo.add(new StaffVO("小明", "B1235468", "快递员", "男","1987-02-15", "按提成"));
				staffInfo.add(new StaffVO("小李", "B1289568", "业务员", "男","1984-08-11", "按月"));
				staffInfo.add(new StaffVO("小王", "B1784468", "快递员", "男","195", "按提成"));
				organizationVO = new OrganizationVO(null, null, null, staffInfo);
				System.out.println("修改机构信息是否成功："+organization.modifyOrganization(organizationVO));
				break;
			case 4:
				organizationVO = organization.findOrganization(null);
				System.out.println("机构信息："+"\n"+"类型："+organizationVO.getType()
				+"id："+organizationVO.getId()+"名称："+organizationVO.getName()+"\n"+"人员信息：");
				for(int i=0;i<organizationVO.getStaffInfo().size();i++){
					System.out.println("姓名："+organizationVO.getStaffInfo().get(i).getName()
							+"id:"+organizationVO.getStaffInfo().get(i).getId()
							+"职位："+organizationVO.getStaffInfo().get(i).getPosition()
							+"性别："+organizationVO.getStaffInfo().get(i).getGender()
							+"出生日期："+organizationVO.getStaffInfo().get(i).getBirthday()
							+"薪水："+organizationVO.getStaffInfo().get(i).getSalary());
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
