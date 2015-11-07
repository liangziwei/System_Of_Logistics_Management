package businessLogic.businessLogicModel.businessModel;

import po.businessPO.EntruckingPO;
import stub.dataImpl_stub.businessDataImpl_stub.EntruckingDataImpl_stub;
import vo.businessVO.EntruckingVO;
import dataService.businessDataService.EntruckingDataService;

public class Entrucking {

	private EntruckingDataService entruckingData=new EntruckingDataImpl_stub();
	
	public boolean addEntruckingFrom(EntruckingVO entruckingVO) {
		// TODO Auto-generated method stub

		return entruckingData.addEntruckingFrom(entruckingVOToPO(entruckingVO));
	}
	
	private EntruckingPO entruckingVOToPO(EntruckingVO entruckingVO){
		
		return new EntruckingPO(entruckingVO.getDate(),entruckingVO.getBusinessHallid(),entruckingVO.getTransportNumber(),entruckingVO.getDestionation(),entruckingVO.getVehicleid(),entruckingVO.getSupervisor(),entruckingVO.getSupercargo(),entruckingVO.getFreight());
	}
}
