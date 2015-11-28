package dataImpl.transitionDataImpl;

import constant.CargoState;
import dataService.transitionDataService.ReceivingDataService;
import po.transitionPO.ReceivingPO;

public class ReceivingDataImpl implements ReceivingDataService {

	public ReceivingPO FindReceivingFormDT(String receivingNumber) {
		// TODO Auto-generated method stub
		ReceivingPO receiving = new ReceivingPO("0025","2015-10-14", "2015100800001711","北京","南京",CargoState.丢失);
		return receiving;
	}

	public boolean addReceivingFormDT(ReceivingPO receivingPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean modifyReceivingFormDT(ReceivingPO receivingPO) {
		// TODO Auto-generated method stub
		
		return false;
	}

}
