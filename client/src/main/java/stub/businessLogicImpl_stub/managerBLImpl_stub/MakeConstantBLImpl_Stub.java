package stub.businessLogicImpl_stub.managerBLImpl_stub;

import stub.dataImpl_stub.managerDataImpl_stub.MakeConstantDataImpl_Stub;
import constant.City;
import constant.TransitType;
import dataService.managerDataService.MakeConstantDataService;
import businessLogicService.managerBLService.MakeConstantBLService;

public class MakeConstantBLImpl_Stub implements MakeConstantBLService{
	
	private MakeConstantDataService makeConstant = new MakeConstantDataImpl_Stub();
	public boolean setPrice(double price,TransitType transType) {
		return makeConstant.updatePrice(price, transType);
	}
	
	public boolean setDistance(double distance,City source,City destination) {
		return makeConstant.updateDistance(distance, source, destination);
	}
}