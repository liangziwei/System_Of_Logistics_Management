package stub.businessLogicImpl_stub.managerBLImpl_stub;

import java.util.ArrayList;

import po.managerPO.OrganizationPO;
import po.managerPO.StaffPO;
import stub.dataImpl_stub.managerDataImpl_stub.OrganizationManagementDataImpl_Stub;
import vo.managerVO.OrganizationVO;
import vo.managerVO.StaffVO;
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
