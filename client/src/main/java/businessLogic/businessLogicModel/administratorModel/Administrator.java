package businessLogic.businessLogicModel.administratorModel;

import java.rmi.RemoteException;

import network.RMI;
import po.administratorPO.AdministratorPO;
import vo.administratorVO.AdministratorVO;
import dataService.administratorDataService.AdministratorDataService;
import network.RemoteExceptionHandler;

public class Administrator {

	private static final String KEY = "administrator";
	
	private AdministratorDataService adminData=RMI.<AdministratorDataService>getDataService(KEY);
	
	public boolean addUser(AdministratorVO administratorVO) {
		// TODO Auto-generated method stub
		try {
			return adminData.addUser(administratorVO.adminVOToPO());
		} catch (RemoteException e) {
			new RemoteExceptionHandler<AdministratorDataService>(KEY);
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteUser(String administratorid) {
		// TODO Auto-generated method stub
		try {
			return adminData.deleteUser(administratorid);
		} catch (RemoteException e) {
			new RemoteExceptionHandler<AdministratorDataService>(KEY);
			e.printStackTrace();
			return false;
		}
	}

	public boolean modifyUser(AdministratorVO administratorVO) {
		// TODO Auto-generated method stub
		try {
			return adminData.modifyUser(administratorVO.adminVOToPO());
		} catch (RemoteException e) {
			new RemoteExceptionHandler<AdministratorDataService>(KEY);
			e.printStackTrace();
			return false;
		}
	}

	public AdministratorVO findUser(String administratorid) {
		// TODO Auto-generated method stub
		try {
			AdministratorPO adminPO=adminData.findUser(administratorid);
			return adminPO.adminPOToVO();
		} catch (RemoteException e) {
			new RemoteExceptionHandler<AdministratorDataService>(KEY);
			e.printStackTrace();
			return null;
		}
	}

}
