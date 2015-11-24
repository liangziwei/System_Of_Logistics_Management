package stub.businessLogicImpl_stub.managerBLImpl_stub;

import stub.dataImpl_stub.managerDataImpl_stub.MakeConstantDataImpl_Stub;
import constant.City;
import constant.PackageType;
import constant.TransitType;
import dataService.managerDataService.MakeConstantDataService;
import businessLogicService.managerBLService.MakeConstantBLService;

public class MakeConstantBLImpl_Stub implements MakeConstantBLService{
	
	private MakeConstantDataService makeConstant = new MakeConstantDataImpl_Stub();
	public boolean setTransitPrice(double price,TransitType transType) {
		boolean success =false;
		try{
			success = makeConstant.updatePrice(price, transType);
		}catch(Exception e){
			e.printStackTrace();
		}
		return success;
	}
	
	public boolean setDistance(double distance,City source,City destination) {
		boolean success =false;
		try{
			success = makeConstant.updateDistance(distance, source, destination);
		}catch(Exception e){
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public boolean setPackPrice(double price, PackageType packType) {
		// TODO Auto-generated method stub
		return false;
	}
}