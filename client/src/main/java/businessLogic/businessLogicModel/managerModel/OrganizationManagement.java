package businessLogic.businessLogicModel.managerModel;

import java.util.ArrayList;

import network.RMI;
import po.managerPO.OrganizationPO;
import po.managerPO.StaffPO;
import vo.managerVO.OrganizationVO;
import vo.managerVO.StaffVO;
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
		ArrayList<StaffPO> staffInfo = new ArrayList<StaffPO>();
		for(int i=0;i<organizationVO.getStaffInfo().size();i++){
			staffInfo.add(staffVOTostaffPO(organizationVO.getStaffInfo().get(i)));
		}
		return new OrganizationPO(organizationVO.getType(), organizationVO.getId(), 
				organizationVO.getName(),staffInfo );
	}
	
	private OrganizationVO organizationPOToOrganizationVO(OrganizationPO organizationPO){
		ArrayList<StaffVO> staffInfo = new ArrayList<StaffVO>();
		for(int i=0;i<organizationPO.getStaffInfo().size();i++){
			staffInfo.add(staffPOTostaffVO(organizationPO.getStaffInfo().get(i)));
		}
		return new OrganizationVO(organizationPO.getType(), organizationPO.getId(), 
				organizationPO.getName(),staffInfo );
	}
	
	private StaffPO staffVOTostaffPO(StaffVO staffVO){
		return new StaffPO(staffVO.getName(),staffVO.getId(),staffVO.getPosition(),
				staffVO.getGender(),staffVO.getBirthday(),staffVO.getSalary());
	}
	
	private StaffVO staffPOTostaffVO(StaffPO staffPO){
		return new StaffVO(staffPO.getName(),staffPO.getId(),staffPO.getPosition(),
				staffPO.getGender(),staffPO.getBirthday(),staffPO.getSalary());
	}
}
