package dataService.administratorDataService;

import po.administratorPO.AdministratorPO;

public interface AdministratorDataService {

	public boolean addUser(AdministratorPO administratorPO);
    
    public boolean deleteUser(int administratorid);
    
    public boolean modifyUser(AdministratorPO administratorPO);
    
    public AdministratorPO findUser(int administratorid);
    
    public String getPassword(int userid);
}
