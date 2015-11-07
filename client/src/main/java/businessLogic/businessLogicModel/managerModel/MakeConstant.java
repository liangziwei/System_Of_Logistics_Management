package businessLogic.businessLogicModel.managerModel;

import constant.City;
import constant.TransitType;
import mock.object.MockMakeConstantData;
import dataService.managerDataService.MakeConstantDataService;

public class MakeConstant {
	
	private MakeConstantDataService makeConstant = new MockMakeConstantData();
	
	public boolean setPrice(double price,TransitType transType) {
		return makeConstant.updatePrice(price, transType);
	}
	
	public boolean setDistance(double distance,City source,City destination) {
		return makeConstant.updateDistance(distance, source, destination);
	}
}
