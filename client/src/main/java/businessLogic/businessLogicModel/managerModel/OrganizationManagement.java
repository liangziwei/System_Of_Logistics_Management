package businessLogic.businessLogicModel.managerModel;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dataService.managerDataService.OrganizationManagementDataService;
import network.RMI;
import po.managerPO.OrganizationPO;
import po.managerPO.StaffPO;
import vo.managerVO.OrganizationVO;
import vo.managerVO.StaffVO;

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
			OrganizationPO po = organizationData.findOrganization(id);
			if(po == null) return null;
			organization = this.organizationPOToOrganizationVO(po);
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
	
	public List<StaffVO> getStaffInfos(String organizationId) {
		List<StaffVO> staffs = new ArrayList<StaffVO>();
		List<StaffPO> temp = null;
		try {
			temp = organizationData.findStaffInfos(organizationId);
			if(temp == null) return null;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		for(int i = 0; i < temp.size(); i++) {
			staffs.add(StaffPO.staffPOTostaffVO(temp.get(i)));
		}
		return staffs;
	}
	
	public boolean deleteStaffByOrgId(String organizationId) {
		try {
			return organizationData.deleteStaffsByOrgId(organizationId);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private OrganizationPO organizationVOToOrganizationPO(OrganizationVO organizationVO){
		return new OrganizationPO(organizationVO.getType(), organizationVO.getId(), 
				organizationVO.getName(), organizationVO.isApproved(), organizationVO.isPassed());
	}
	
	private OrganizationVO organizationPOToOrganizationVO(OrganizationPO organizationPO){
		return new OrganizationVO(organizationPO.getType(), organizationPO.getId(), 
				organizationPO.getName(),organizationPO.isApproved(), organizationPO.isPassed());
	}
}
