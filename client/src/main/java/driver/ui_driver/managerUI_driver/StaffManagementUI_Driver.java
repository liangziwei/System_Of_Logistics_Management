package driver.ui_driver.managerUI_driver;

import java.util.Scanner;

import stub.businessLogicImpl_stub.managerBLImpl_stub.StaffManagementBLImpl_Stub;
import vo.managerVO.StaffVO;
import businessLogicService.managerBLService.StaffManagementBLService;

public class StaffManagementUI_Driver {
	public static void main(String[] args) {
		StaffManagementBLService staff = new StaffManagementBLImpl_Stub();
		boolean go = true;
		Scanner s = new Scanner(System.in);
		while(go) {
			System.out.println("请输入请求:(1)添加人员信息（2）删除人员信息"
					+ "（3）修改人员信息（4）查询人员信息（5）退出");
			int input = s.nextInt();
			switch(input) {
			case 1:
//				StaffVO staffVO = new StaffVO(null,null,null,null,null,null);
//				System.out.println("添加人员信息是否成功："+staff.addStaff(staffVO));
				break;
			case 2:
				System.out.println("删除人员信息是否成功："+staff.deleteStaff(null));
				break;
			case 3:
//				staffVO = new StaffVO(null,null,null,null,null,null);
//				System.out.println("修改人员信息是否成功："+staff.modifyStaff(staffVO));
				break;
			case 4:
//				staffVO = staff.findStaff("B1235468");
//				System.out.println("人员信息："+"\n"+"姓名："+staffVO.getName()
//						+"id:"+staffVO.getId()+"职位："+staffVO.getPosition()
//						+"性别："+staffVO.getGender()+"出生日期："+staffVO.getBirthday()
//						+"薪水："+staffVO.getSalary());
				break;
			case 5:
				go = false;
				break;
			}
		}
		s.close();
	}
}
