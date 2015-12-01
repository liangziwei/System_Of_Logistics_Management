package businessLogic.businessLogicModel.businessModel;

import java.rmi.RemoteException;

import constant.TransitType;
import network.RMI;
import po.businessPO.EntruckingPO;
import vo.businessVO.EntruckingVO;
import businessLogic.businessLogicModel.managerModel.TransitPriceIO;
import dataService.businessDataService.EntruckingDataService;

public class Entrucking {

//	private EntruckingDataService entruckingData=new EntruckingDataImpl_stub();
	private EntruckingDataService entruckingData=RMI.<EntruckingDataService>getDataService("entrucking");
	
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
		double price=this.TransitPrice.getTransitPrice(TransitType.ROAD);
		freight=300*price;
		return freight;
	}
}
