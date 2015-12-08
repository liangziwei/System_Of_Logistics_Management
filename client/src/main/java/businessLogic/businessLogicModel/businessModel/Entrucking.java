package businessLogic.businessLogicModel.businessModel;

import java.rmi.RemoteException;

import stub.dataImpl_stub.businessDataImpl_stub.EntruckingDataImpl_stub;
import vo.businessVO.EntruckingVO;
import businessLogic.businessLogicModel.managerModel.TransitPriceIO;
import constant.TransitType;
import dataService.businessDataService.EntruckingDataService;

public class Entrucking {

	private EntruckingDataService entruckingData=new EntruckingDataImpl_stub();
//	private EntruckingDataService entruckingData=RMI.<EntruckingDataService>getDataService("entrucking");
	
	private static double freight=0;
	private TransitPriceIO TransitPrice=new TransitPriceIO();
	
	public boolean addEntruckingFrom(EntruckingVO entruckingVO) {
		// TODO Auto-generated method stub

		try {
			return entruckingData.addEntruckingFrom(entruckingVO.entruckingVOToPO());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	public double getFreight(){
		@SuppressWarnings("static-access")
		double price=TransitPrice.getTransitPrice(TransitType.ROAD);
		freight=300*price;
		return freight;
	}
}
