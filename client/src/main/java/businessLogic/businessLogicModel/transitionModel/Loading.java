package businessLogic.businessLogicModel.transitionModel;

import java.util.ArrayList;

import constant.City;
import constant.LoadingType;
import vo.transitionVO.LoadingVO;

public class Loading {
	public LoadingVO findLoadingFormBL(String loadingNumber) {
		// TODO Auto-generated method stub
		ArrayList<String>  alldeliveryid = new ArrayList<>();
		alldeliveryid.add("1234567890");
		alldeliveryid.add("0987654321");
		LoadingVO loadingVO =new LoadingVO("12312311111", "123", LoadingType.TRAIN, "212453", "haha", "xixi", alldeliveryid);
		loadingVO.setVerifyResult(true);
		return loadingVO;
	}

	public boolean addLoadingFormBL(LoadingVO loadingVO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean modifyLoadingFormBL(LoadingVO loadingVO) {
		// TODO Auto-generated method stub
		return false;
	}

	public double loadingFare(String CityFrom, String CityTo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean verifyres(LoadingVO loadingVO) {
		if(loadingVO.getloadingid().equals("")||loadingVO.getloadingid().length()!=11){
			loadingVO.seterrorMsg("装运单编号不能为空或装运单编号错误");
			return false;
		}
		if(loadingVO.getarrivalid().equals("")){
			loadingVO.seterrorMsg("到达地不能为空");
			return false;
		}
		if (loadingVO.getwayid().equals("")||loadingVO.getwayid().length()!=9) {
			loadingVO.seterrorMsg("装运方式编号不能为空或编号输入错误");
			return false;
		}
		if (loadingVO.getsupervisionid().equals("")) {
			loadingVO.seterrorMsg("监装员不可为空");
			return false;
		}
		if (loadingVO.getsupercargoid().equals("")) {
			loadingVO.seterrorMsg("押运员不可为空");
			return false;
		}
		if (loadingVO.getalldeliveryid()==null) {
			loadingVO.seterrorMsg("所有订单条形码号不能为空");
			return false;
		}
		return true;
	}
}
