package businessLogic.businessLogicModel.administratorModel;

import po.administratorPO.AdministratorPO;
import stub.dataImpl_stub.administratorDataImpl_stub.AdministratorDataImpl_Stub;
import vo.administratorVO.AdministratorVO;
import dataService.administratorDataService.AdministratorDataService;

public class Administrator {

	private AdministratorDataService adminData=new AdministratorDataImpl_Stub();

	public boolean addUser(AdministratorVO administratorVO) {
		// TODO Auto-generated method stub
		return adminData.addUser(adminVOToPO(administratorVO));
	}

	public boolean deleteUser(String administratorid) {
		// TODO Auto-generated method stub
		return adminData.deleteUser(administratorid);
	}

	public boolean modifyUser(AdministratorVO administratorVO) {
		// TODO Auto-generated method stub
		return adminData.modifyUser(adminVOToPO(administratorVO));
	}

	public AdministratorVO findUser(String administratorid) {
		// TODO Auto-generated method stub
		return adminPOToVO(adminData.findUser(administratorid));
	}

	private AdministratorPO adminVOToPO(AdministratorVO administratorVO){
		return new AdministratorPO(administratorVO.getType(),administratorVO.getName(),administratorVO.getId(),administratorVO.getPassword(),administratorVO.getLimit());
	}
	private AdministratorVO adminPOToVO(AdministratorPO administratorPO){
		return new AdministratorVO(administratorPO.getType(),administratorPO.getName(),administratorPO.getId(),administratorPO.getPassword(),administratorPO.getLimit());
	}
}
