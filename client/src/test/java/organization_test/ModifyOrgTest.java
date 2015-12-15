package organization_test;

import static org.junit.Assert.*;

import org.junit.Test;

import businessLogic.businessLogicController.managerController.OrganizationManagementController;
import businessLogicService.managerBLService.OrganizationManagementBLService;
import vo.managerVO.OrganizationVO;

/**
 *测试修改机构信息的需求 
 */
public class ModifyOrgTest {

	@Test
	public void test() {
		OrganizationManagementBLService org = new OrganizationManagementController();
//		OrganizationVO mVO = new OrganizationVO("中转中心", id, name, false, false);
//		org.modifyOrganization(organizationVO)
	}

}
