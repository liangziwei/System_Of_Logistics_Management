package businessLogic.businessLogicController.administratorController;

import java.rmi.RemoteException;

import network.RMI;
import stub.dataImpl_stub.administratorDataImpl_stub.AdministratorDataImpl_Stub;
import dataService.administratorDataService.AdministratorDataService;
import businessLogicService.administratorBLService.LoginBLService;

public class LoginBL implements LoginBLService{
	
//	private AdministratorDataService adminData=new AdministratorDataImpl_Stub();
	private AdministratorDataService adminData=RMI.<AdministratorDataService>getDataService("administrator");

	public boolean login(String userid, String passward) {
		// TODO Auto-generated method stub
		try {
			if(passward.equals(adminData.getPassword(userid))){
			  return true;
			}else{
				return false;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


}
