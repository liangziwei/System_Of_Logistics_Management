package organization_test;

import static org.junit.Assert.*;

import org.junit.Test;

import businessLogic.businessLogicController.managerController.OrganizationManagementController;
import businessLogicService.managerBLService.OrganizationManagementBLService;
import vo.managerVO.OrganizationVO;

/**
 *测试查找机构信息的需求 
 */
public class FindOrgTest {

	@Test
	public void test() {
		OrganizationManagementBLService org = new OrganizationManagementController();
		//测试机构编号、机构名称、机构类型是否一致
		OrganizationVO vo = org.findOrganization("025000");
		assertEquals("025000", vo.getId());
		assertEquals("南京营业厅", vo.getName());
		assertEquals("营业厅", vo.getType());
	}

}
