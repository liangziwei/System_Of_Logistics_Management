package businessLogic.businessLogicModel.transitionModel;

import java.rmi.RemoteException;
import java.util.HashMap;

import businessLogic.businessLogicModel.managerModel.MakeConstant;
import constant.City;
import constant.LoadingType;
import constant.TransitType;
import dataService.managerDataService.MakeConstantDataService;
import dataService.transitionDataService.LoadingDataService;
import network.RMI;
import po.transitionPO.LoadingPO;
import vo.transitionVO.LoadingVO;

public class Loading {
	private LoadingDataService loadingDataService = RMI.<LoadingDataService>getDataService("loading");
	private MakeConstantDataService makeConstantDataService = RMI.<MakeConstantDataService>getDataService("makeConstant");
	
	public LoadingVO findLoadingFormBL(String loadingNumber) {
		// TODO Auto-generated method stub
		LoadingVO loadingVO = null;
		LoadingPO loadingPO = null;
		try {
			loadingPO = loadingDataService.FindLoadingFormDT(loadingNumber);
			if (loadingPO==null) {
				return null;
			}
			else {
				loadingVO = LoadingPOtoLoadingVO(loadingPO);
				loadingVO.setVerifyResult(true);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loadingVO;
	}

	public boolean addLoadingFormBL(LoadingVO loadingVO) {
		// TODO Auto-generated method stub
		HashMap<String, String> constant = null;
		try {
			constant = makeConstantDataService.getIDTable();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String departure = loadingVO.getloadingid().substring(0, 3);
		String city = constant.get(departure);
		double faremoney = this.loadingFare(city, loadingVO.getarrivalid(),loadingVO.getway());
		loadingVO.setfare(faremoney);
		LoadingPO loadingPO = LoadingVOtoLoadingPO(loadingVO);
		boolean add =false;
		try {
			add = loadingDataService.AddLoadingFormDT(loadingPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return add;
	}

	public boolean modifyLoadingFormBL(LoadingVO loadingVO) {
		// TODO Auto-generated method stub
		HashMap<String, String> constant = null;
		try {
			constant = makeConstantDataService.getIDTable();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String departure = loadingVO.getloadingid().substring(0, 3);
		String city = constant.get(departure);
		double faremoney = this.loadingFare(city, loadingVO.getarrivalid(),loadingVO.getway());
		loadingVO.setfare(faremoney);
		LoadingPO loadingPO = LoadingVOtoLoadingPO(loadingVO);
		boolean modify =false;
		try {
			modify = loadingDataService.ModifyLoadingFormDT(loadingPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modify;
	}

	public double loadingFare(String CityFrom, String CityTo,LoadingType type) {
		// TODO Auto-generated method stub
		City from =null;
		City to = null;
		switch (CityFrom) {
		case "南京":
			from = City.NAN_JING;
			break;
		case "北京":
			from = City.BEI_JING;
			break;
		case "上海":
			from = City.SHANG_HAI;
			break;
		case "广州":
			from = City.GUANG_ZHOU;
			break;
		}
		switch (CityTo) {
		case "南京":
			to = City.NAN_JING;
			break;
		case "北京":
			to = City.BEI_JING;
			break;
		case "上海":
			to = City.SHANG_HAI;
			break;
		case "广州":
			to = City.GUANG_ZHOU;
			break;
		}
		MakeConstant constant = new MakeConstant();
		double distance = constant.getDistance(from, to);
		double weight =0;
		TransitType transitType =null;
		switch (type) {
		case PLANE:
			transitType = TransitType.AIR;
			weight = 50;
			break;
		case TRAIN:
			transitType = TransitType.RAILWAY;
			weight = 2000;
			break;
		case TRUCK:
			transitType = TransitType.ROAD;
			weight = 10;
			break;
		}
		double transitprice = constant.getTransitPrice(transitType);
		
		return (distance*transitprice*weight);
	}
	
	private LoadingVO LoadingPOtoLoadingVO(LoadingPO loadingPO){
		LoadingVO loadingVO =new LoadingVO(loadingPO.getloadingid(), loadingPO.getarrivalid(), 
				loadingPO.getway(), loadingPO.getwayid(), loadingPO.getsupervisionid(), 
				loadingPO.getsupercargoid(),loadingPO.getalldeliveryid());
		loadingVO.setfare(loadingPO.getfare());
		return loadingVO;
	}
	private LoadingPO LoadingVOtoLoadingPO(LoadingVO loadingVO){
		LoadingPO loadingPO =new LoadingPO(loadingVO.getloadingid(), loadingVO.getarrivalid(), loadingVO.getway(),
				loadingVO.getwayid(), loadingVO.getsupervisionid(), loadingVO.getsupercargoid(),
				loadingVO.getalldeliveryid());
		loadingPO.setfare(loadingVO.getfare());
		return loadingPO;
	}
	
	public boolean verifyres(LoadingVO loadingVO) {
		if(loadingVO.getloadingid().equals("")||(!loadingVO.getloadingid().matches("\\d{11}"))){
			loadingVO.seterrorMsg("装运单编号不能为空或装运单编号错误(11位),前三位为中转中心编号");
			return false;
		}
		HashMap<String, String> constant = null;
		try {
			constant = makeConstantDataService.getIDTable();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String position = constant.get(loadingVO.getloadingid().substring(0, 3));
		if (position==null) {
			loadingVO.seterrorMsg("装运编号前3位数字应为城市编号025 南京,010 北京,021 上海,020 广州");
			return false;
		}
		if(loadingVO.getarrivalid().equals("")){
			loadingVO.seterrorMsg("到达地不能为空");
			return false;
		}
		if (loadingVO.getwayid().equals("")||(!loadingVO.getwayid().matches("\\d{9}"))) {
			loadingVO.seterrorMsg("装运方式编号不能为空或编号输入错误(9位)");
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
		for(String id:(loadingVO.getalldeliveryid())){
			if (id.matches("\\d{10}")) {
			}
			else {
				loadingVO.seterrorMsg("所有订单条形码号均为10位数字");
				return false;
			}
		}
		return true;
	}
}
