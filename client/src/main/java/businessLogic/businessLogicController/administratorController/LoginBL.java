package businessLogic.businessLogicController.administratorController;

import stub.dataImpl_stub.administratorDataImpl_stub.AdministratorDataImpl_Stub;
import dataService.administratorDataService.AdministratorDataService;
import businessLogicService.administratorBLService.LoginBLService;

public class LoginBL implements LoginBLService{
	
	private AdministratorDataService adminData=new AdministratorDataImpl_Stub();

	public boolean login(String userid, String passward) {
		// TODO Auto-generated method stub
		if(passward.equals(adminData.findUser(userid))){
		  return true;
		}else{
			return false;
		}
	}


}
