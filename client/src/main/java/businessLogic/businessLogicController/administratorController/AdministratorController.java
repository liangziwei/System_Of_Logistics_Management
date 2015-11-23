package businessLogic.businessLogicController.administratorController;

import vo.administratorVO.AdministratorVO;
import businessLogic.businessLogicModel.administratorModel.Administrator;
import businessLogicService.administratorBLService.AdministratorBLService;

public class AdministratorController implements AdministratorBLService {

	private Administrator admin=new Administrator();
	
	public boolean addUser(AdministratorVO administratorVO) {
		// TODO Auto-generated method stub
		return admin.addUser(administratorVO);
	}

	public boolean modifyUser(AdministratorVO administratorVO) {
		// TODO Auto-generated method stub
		return admin.modifyUser(administratorVO);
	}

	public boolean deleteUser(String administratorid) {
		// TODO Auto-generated method stub
		return admin.deleteUser(administratorid);
	}

	public AdministratorVO findUser(String administratorid) {
		// TODO Auto-generated method stub
		return admin.findUser(administratorid);
	}

}
