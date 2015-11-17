package businessLogic.businessLogicModel.transitionModel;

import constant.City;
import vo.transitionVO.LoadingVO;

public class Loading {
	public LoadingVO findLoadingFormBL(String loadingNumber) {
		// TODO Auto-generated method stub
		return null;
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
		if(loadingVO.getloadingid()==null||loadingVO.getloadingid().length()!=11){
			loadingVO.seterrorMsg("装运单编号不能为空或装运单编号错误");
			return false;
		}
		if(loadingVO.getarrivalid()==null){
			loadingVO.seterrorMsg("到达地不能为空");
			return false;
		}
		if (loadingVO.getwayid()==null) {
			loadingVO.seterrorMsg("装运方式编号不能为空");
			return false;
		}
		if (loadingVO.getsupervisionid()==null) {
			loadingVO.seterrorMsg("监装员不可为空");
			return false;
		}
		if (loadingVO.getsupercargoid()==null) {
			loadingVO.seterrorMsg("押运员不可为空");
			return false;
		}
		if (loadingVO.getarrivalid().isEmpty()) {
			loadingVO.seterrorMsg("装运单编号不能为空");
			return false;
		}
		return true;
	}
}
