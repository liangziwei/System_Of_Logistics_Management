package businessLogic.businessLogicModel.managerModel;

import java.util.ArrayList;

import po.managerPO.OrganizationPO;
import po.managerPO.StaffPO;
import vo.managerVO.OrganizationVO;
import vo.managerVO.StaffVO;
import mock.object.MockOrganizationData;
import dataService.managerDataService.OrganizationManagementDataService;

public class OrganizationManagement {

	private OrganizationManagementDataService organizationData = new MockOrganizationData();
	
	public boolean addOrganization(OrganizationVO organizationVO) {
		return organizationData.addOrganization(organizationVOToOrganizationPO(organizationVO));
	}
	
	public OrganizationVO findOrganization(String id) {
		return this.organizationPOToOrganizationVO(organizationData.findOrganization(id));
	}
	
	public boolean deleteOrganization(String id) {
		return organizationData.deleteOrganization(id);
	}
	
	public boolean modifyOrganization(OrganizationVO organizationVO) {
		return organizationData.modifyOrganization(this.organizationVOToOrganizationPO(organizationVO));
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
