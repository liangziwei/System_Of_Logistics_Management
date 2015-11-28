package businessLogic.businessLogicModel.administratorModel;

import java.rmi.RemoteException;

import network.RMI;
import po.administratorPO.AdministratorPO;
import stub.dataImpl_stub.administratorDataImpl_stub.AdministratorDataImpl_Stub;
import vo.administratorVO.AdministratorVO;
import dataService.administratorDataService.AdministratorDataService;

public class Administrator {

	private AdministratorDataService adminData=new AdministratorDataImpl_Stub();
//	private AdministratorDataService adminData=RMI.<AdministratorDataService>getDataService("administrator");
	public boolean addUser(AdministratorVO administratorVO) {
		// TODO Auto-generated method stub
		try {
			return adminData.addUser(adminVOToPO(administratorVO));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteUser(String administratorid) {
		// TODO Auto-generated method stub
		try {
			return adminData.deleteUser(administratorid);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean modifyUser(AdministratorVO administratorVO) {
		// TODO Auto-generated method stub
		try {
			return adminData.modifyUser(adminVOToPO(administratorVO));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public AdministratorVO findUser(String administratorid) {
		// TODO Auto-generated method stub
		try {
			return adminPOToVO(adminData.findUser(administratorid));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private AdministratorPO adminVOToPO(AdministratorVO administratorVO){
		return new AdministratorPO(administratorVO.getType(),administratorVO.getName(),administratorVO.getId(),administratorVO.getPassword(),administratorVO.getLimit());
	}
	private AdministratorVO adminPOToVO(AdministratorPO administratorPO){
		return new AdministratorVO(administratorPO.getType(),administratorPO.getName(),administratorPO.getId(),administratorPO.getPassword(),administratorPO.getLimit());
	}
}
