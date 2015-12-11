package vo.businessVO;

import constant.CargoState;
import dataService.Approvable;
import po.businessPO.ArrivalFormPO;

public class ArrivalFormVO implements Approvable{

	private String date;
	private String transitNumber;
	private String departPlace;
	private CargoState state;
	
	public ArrivalFormVO(String date, String transitNumber, String departPlace,
			CargoState state) {
		super();
		this.date = date;
		this.transitNumber = transitNumber;
		this.departPlace = departPlace;
		this.state = state;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTransitNumber() {
		return transitNumber;
	}

	public void setTransitNumber(String transitNumber) {
		this.transitNumber = transitNumber;
	}

	public String getDepartPlace() {
		return departPlace;
	}

	public void setDepartPlace(String departPlace) {
		this.departPlace = departPlace;
	}

	public CargoState getState() {
		return state;
	}

	public void setState(CargoState state) {
		this.state = state;
	}
	
	public ArrivalFormPO arrivalVOToPO(){
		return new ArrivalFormPO(date,transitNumber,departPlace,state);
	}
	
}
