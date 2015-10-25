package stub.dataImpl_stub.administratorDataImpl_stub;

import constant.Authority;
import constant.UserType;
import po.administratorPO.AdministratorPO;
import dataService.administratorDataService.AdministratorDataService;

public class AdministratorDataImpl_Stub implements AdministratorDataService {

	public boolean addUser(AdministratorPO administratorPO) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean deleteUser(String administratorid) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean modifyUser(AdministratorPO administratorPO) {
		// TODO Auto-generated method stub
		return true;
	}

	public AdministratorPO findUser(String administratorid) {
		// TODO Auto-generated method stub
		return new AdministratorPO(UserType.COURIER,"小黄","B123456","0000",Authority.LOW);
	}

	public String getPassword(String userid) {
		// TODO Auto-generated method stub
		return "0000";
	}

}
