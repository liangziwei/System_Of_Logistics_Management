package businessTest;

import dataImpl.managerDataImpl.StaffManagementDataImpl;

public class StaffDataTest {
	public static void main(String[] args) {
//		StaffPO staffPO = new StaffPO("李晓", "B12345854", "快递员", "男","1987-02-15", "按提成");
		StaffManagementDataImpl staffData = new StaffManagementDataImpl();
//		StaffPO staffTest = staffData.findStaff("B12345854");
//		System.out.println(staffTest.getId()+" "+staffTest.getName()+"  "+staffTest.getPosition()
//				+"  "+staffTest.getGender()+"  "+staffTest.getBirthday()+" "+staffTest.getSalary());
//		System.out.println(staffData.modifyStaff(staffPO));
//		System.out.println(staffData.addStaff(staffPO));
		System.out.println(staffData.deleteStaff("B12345854"));
	}
}
