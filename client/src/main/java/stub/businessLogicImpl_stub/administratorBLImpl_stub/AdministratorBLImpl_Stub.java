package stub.businessLogicImpl_stub.administratorBLImpl_stub;

import java.rmi.RemoteException;

import po.administratorPO.AdministratorPO;
import stub.dataImpl_stub.administratorDataImpl_stub.AdministratorDataImpl_Stub;
import vo.administratorVO.AdministratorVO;
import businessLogicService.administratorBLService.AdministratorBLService;
import dataService.administratorDataService.AdministratorDataService;

public class AdministratorBLImpl_Stub implements AdministratorBLService{
	
	private AdministratorDataService adminData=new AdministratorDataImpl_Stub();

	public boolean addUser(AdministratorVO administratorVO) throws RemoteException {
		// TODO Auto-generated method stub
		return adminData.addUser(adminVOToPO(administratorVO));
	}

	public boolean deleteUser(String administratorid) throws RemoteException {
		// TODO Auto-generated method stub
		return adminData.deleteUser(administratorid);
	}

	public boolean modifyUser(AdministratorVO administratorVO) throws RemoteException {
		// TODO Auto-generated method stub
		return adminData.modifyUser(adminVOToPO(administratorVO));
	}

	public AdministratorVO findUser(String administratorid) throws RemoteException {
		// TODO Auto-generated method stub
		return adminPOToVO(adminData.findUser(administratorid));
	}

	private AdministratorPO adminVOToPO(AdministratorVO administratorVO){
		return new AdministratorPO(administratorVO.getType(),administratorVO.getName(),administratorVO.getId(),administratorVO.getPassword(),administratorVO.getLimit());
	}
	private AdministratorVO adminPOToVO(AdministratorPO administratorPO){
		return new AdministratorVO(administratorPO.getType(),administratorPO.getName(),administratorPO.getId(),administratorPO.getPassword(),administratorPO.getLimit());
	}
}
