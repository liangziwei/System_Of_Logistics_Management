package stub.businessLogicImpl_stub.managerBLImpl_stub;



import po.managerPO.OrganizationPO;
import stub.dataImpl_stub.managerDataImpl_stub.OrganizationManagementDataImpl_Stub;
import vo.managerVO.OrganizationVO;
import businessLogicService.managerBLService.OrganizationManagementBLService;
import dataService.managerDataService.OrganizationManagementDataService;

public class OrganizationManagementBLImpl_Stub implements OrganizationManagementBLService{
	
	private OrganizationManagementDataService organization = new OrganizationManagementDataImpl_Stub();
	
	public boolean addOrganization(OrganizationVO organizationVO) {
		boolean success = false;
		try{
			success = organization.addOrganization(organizationVOToOrganizationPO(organizationVO));
		}catch(Exception e){
			e.printStackTrace();
		}
		return success;
	}
	
	public OrganizationVO findOrganization(String id) {
		OrganizationVO organizationVO = null;
		try{
			organizationVO = this.organizationPOToOrganizationVO(organization.findOrganization(id));
		}catch(Exception e){
			e.printStackTrace();
		}
		return organizationVO;
	}
	
	public boolean deleteOrganization(String id) {
		boolean success =false;
		try{
			success = organization.deleteOrganization(id); 
		}catch(Exception e){
			e.printStackTrace();
		}
		return success;
	}
	
	public boolean modifyOrganization(OrganizationVO organizationVO) {
		boolean success =false;
		try{
			success = organization.modifyOrganization(this.organizationVOToOrganizationPO(organizationVO));
		}catch(Exception e){
			e.printStackTrace();
		}
		return success;
	}
	
	private OrganizationPO organizationVOToOrganizationPO(OrganizationVO organizationVO) {
		return new OrganizationPO(organizationVO.getType(), organizationVO.getId(), 
				organizationVO.getName(),organizationVO.getStaffInfo() );
	}
	
	private OrganizationVO organizationPOToOrganizationVO(OrganizationPO organizationPO){
		return new OrganizationVO(organizationPO.getType(), organizationPO.getId(), 
				organizationPO.getName(),organizationPO.getStaffInfo());
	}
}
