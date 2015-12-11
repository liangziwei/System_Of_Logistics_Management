package businessLogic.businessLogicController.administratorController;

import java.rmi.RemoteException;

import network.RMI;
import businessLogicService.administratorBLService.LoginBLService;
import dataService.administratorDataService.AdministratorDataService;

public class LoginBL implements LoginBLService{
	
//	private AdministratorDataService adminData=new AdministratorDataImpl_Stub();
	private AdministratorDataService adminData=RMI.<AdministratorDataService>getDataService("administrator");

	public boolean login(String userid, String password){
		// TODO Auto-generated method stub
		try {
			if(password.equals(adminData.getPassword(userid))){
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
