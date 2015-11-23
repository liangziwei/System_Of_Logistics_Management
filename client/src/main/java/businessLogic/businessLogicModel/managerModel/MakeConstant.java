package businessLogic.businessLogicModel.managerModel;



import network.RMI;
import constant.City;
import constant.TransitType;
import dataService.managerDataService.MakeConstantDataService;

public class MakeConstant {
	
	private MakeConstantDataService makeConstant = RMI.<MakeConstantDataService>getDataService("makeConstant");
	
	public boolean setPrice(double price,TransitType transType) {
		boolean success = false;
		try{
			success = makeConstant.updatePrice(price, transType);
		}catch(Exception e){
			e.printStackTrace();
		}
		return success;
	}
	
	public boolean setDistance(double distance,City source,City destination) {
		boolean success = false;
		try{
			success = makeConstant.updateDistance(distance, source, destination);
		}catch(Exception e){
			e.printStackTrace();
		}
		return success;
	}
}
