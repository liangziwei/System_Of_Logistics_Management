package businessLogic.businessLogicModel.businessModel;

import java.rmi.RemoteException;

import businessLogic.businessLogicModel.managerModel.MakeConstant;
import constant.TransitType;
import dataService.businessDataService.EntruckingDataService;
import po.businessPO.EntruckingPO;
import po.constant.TransitPrice;
import stub.dataImpl_stub.businessDataImpl_stub.EntruckingDataImpl_stub;
import vo.businessVO.EntruckingVO;

public class Entrucking {

	private EntruckingDataService entruckingData=new EntruckingDataImpl_stub();
//	private EntruckingDataService entruckingData=RMI.<EntruckingDataService>getDataService("entrucking");
	
	private static double freight=0;
	
	public boolean addEntruckingFrom(EntruckingVO entruckingVO) {
		// TODO Auto-generated method stub
		EntruckingPO entruckingPO=entruckingVO.entruckingVOToPO();
		entruckingPO.setDeliveryIDList(entruckingVO.getDeliveryIDList());
		try {
			return entruckingData.addEntruckingFrom(entruckingPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	public double getFreight(){
		MakeConstant constant = new MakeConstant();
		double price=constant.getTransitPrice(TransitType.ROAD);
		freight=300*price;
		return freight;
	}
}
