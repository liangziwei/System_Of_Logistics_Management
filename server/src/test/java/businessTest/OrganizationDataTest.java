package businessTest;

import java.util.ArrayList;

import dataImpl.managerDataImpl.OrganizationManagementDataImpl;
import po.managerPO.OrganizationPO;

public class OrganizationDataTest {
	public static void main(String[] args) {
		ArrayList<String> staffInfo = new ArrayList<String>();
		staffInfo.add("B1235467");
		staffInfo.add("B1289567");
		staffInfo.add("B1784467");
		OrganizationPO organizationPO = new OrganizationPO("营业厅","02500003","南京市栖霞营业厅", false, false);
		OrganizationManagementDataImpl organizationData = new OrganizationManagementDataImpl();
		OrganizationPO organizationTest = organizationData.findOrganization("02500001");
//		System.out.print(organizationTest.getId()+" "+organizationTest.getType()+
//				" "+organizationTest.getName());
//		ArrayList<String> staffinfo = organizationTest.getStaffInfo();
//		for(int i=0;i<staffinfo.size();i++){
//			System.out.print(" "+staffinfo.get(i));
//		}
//		System.out.println(organizationData.addOrganization(organizationPO));
		System.out.println(organizationData.deleteOrganization("02500003"));
//		System.out.println(organizationData.modifyOrganization(organizationPO));
	}
}
