package businessLogic.businessLogicModel.managerModel;


import network.RMI;
import po.managerPO.OrganizationPO;
import vo.managerVO.OrganizationVO;
import dataService.managerDataService.OrganizationManagementDataService;

public class OrganizationManagement {

	private OrganizationManagementDataService organizationData = 
			RMI.<OrganizationManagementDataService>getDataService("organization");
	
	public boolean addOrganization(OrganizationVO organizationVO) {
		boolean success = false;
		try{
			success = organizationData.addOrganization(organizationVOToOrganizationPO(organizationVO));
		}catch(Exception e){
			e.printStackTrace();
		}
		return success;
	}
	
	public OrganizationVO findOrganization(String id) {
		OrganizationVO organization = null;
		try{
			organization = this.organizationPOToOrganizationVO(organizationData.findOrganization(id));
		}catch(Exception e){
			e.printStackTrace();
		}
		return organization;
	}
	
	public boolean deleteOrganization(String id) {
		boolean success = false;
		try{
			success = organizationData.deleteOrganization(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return success;
	}
	
	public boolean modifyOrganization(OrganizationVO organizationVO) {
		boolean success = false;
		try{
			success = organizationData.modifyOrganization(this.organizationVOToOrganizationPO(organizationVO));
		}catch(Exception e){
			e.printStackTrace();
		}
		return success;
	}
	
	private OrganizationPO organizationVOToOrganizationPO(OrganizationVO organizationVO){
		return new OrganizationPO(organizationVO.getType(), organizationVO.getId(), 
				organizationVO.getName(),organizationVO.getStaffInfo());
	}
	
	private OrganizationVO organizationPOToOrganizationVO(OrganizationPO organizationPO){
		return new OrganizationVO(organizationPO.getType(), organizationPO.getId(), 
				organizationPO.getName(),organizationPO.getStaffInfo());
	}
}
