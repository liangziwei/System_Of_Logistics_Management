package stub.businessLogicImpl_stub.administratorBLImpl_stub;

import stub.dataImpl_stub.administratorDataImpl_stub.AdministratorDataImpl_Stub;
import businessLogicService.administratorBLService.LoginBLService;
import dataService.administratorDataService.AdministratorDataService;

public class LoginBLImpl_Stub implements LoginBLService{
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
