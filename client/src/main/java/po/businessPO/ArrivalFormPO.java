package po.businessPO;



import java.io.Serializable;
import java.util.ArrayList;

import constant.CargoState;
import vo.businessVO.ArrivalFormVO;



public class ArrivalFormPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6469790271856856083L;
	private String date;
	private String transitNumber;
	private String departPlace;
	private CargoState state;
	private boolean isApproved=false; 
	private boolean isPassed=true;
	
	public ArrivalFormPO(String date, String transitNumber, String departPlace,
			CargoState state) {
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

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public boolean isPassed() {
		return isPassed;
	}

	public void setPassed(boolean isPassed) {
		this.isPassed = isPassed;
	}
	
	public ArrivalFormVO arrivalPOToVO(){
		return new ArrivalFormVO(date,transitNumber,departPlace,state);
	}
	
	public static ArrayList<ArrivalFormVO> arrivalPOListToVO(ArrayList<ArrivalFormPO> po) {
		ArrayList<ArrivalFormVO> vo = new ArrayList<ArrivalFormVO>();
		int size = po.size();
		for(int i = 0; i < size; i++) {
			vo.add(po.get(i).arrivalPOToVO());
		}
		return vo;
	}
}
