package businessLogicService.administratorBLService;

import vo.administratorVO.AdministratorVO;


public interface AdministratorBLService {
	
	public boolean addUser(AdministratorVO administratorVO);
    
    public boolean deleteUser(int administratorid);
    
    public boolean modifyUser(AdministratorVO administratorVO);
    
    public AdministratorVO findUser(int administratorid);
}
