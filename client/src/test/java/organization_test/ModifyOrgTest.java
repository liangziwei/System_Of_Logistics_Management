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
		//修改
		OrganizationVO mVO = new OrganizationVO("中转中心", "123465", "南京中转中心", false, false);
		org.modifyOrganization(mVO);
		//查询、比对是否修改正确
		OrganizationVO fVO = org.findOrganization("123465");
		assertEquals("中转中心", fVO.getType());
	}

}
