package businessLogic.businessLogicModel.businessModel;

import java.rmi.RemoteException;

import network.RMI;
import po.businessPO.EntruckingPO;
import vo.businessVO.EntruckingVO;
import dataService.businessDataService.EntruckingDataService;

public class Entrucking {

//	private EntruckingDataService entruckingData=new EntruckingDataImpl_stub();
	private EntruckingDataService entruckingData=RMI.<EntruckingDataService>getDataService("entrucking");
	
	public boolean addEntruckingFrom(EntruckingVO entruckingVO) {
		// TODO Auto-generated method stub

		try {
			return entruckingData.addEntruckingFrom(entruckingVOToPO(entruckingVO));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	private EntruckingPO entruckingVOToPO(EntruckingVO entruckingVO){
		
		return new EntruckingPO(entruckingVO.getDate(),entruckingVO.getBusinessHallid(),entruckingVO.getTransportNumber(),entruckingVO.getDestionation(),entruckingVO.getVehicleid(),entruckingVO.getSupervisor(),entruckingVO.getSupercargo(),entruckingVO.getFreight());
	}
}
