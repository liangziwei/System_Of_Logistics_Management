package businessLogic.businessLogicModel.transitionModel;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import businessLogic.businessLogicModel.managerModel.MakeConstant;
import businessLogic.businessLogicModel.util.CommonLogic;
import constant.City;
import constant.LoadingType;
import constant.TransitType;
import dataService.deliveryDataService.OrderDataService;
import dataService.managerDataService.MakeConstantDataService;
import dataService.transitionDataService.TransferringDataService;
import network.RMI;
import po.transitionPO.TransferringPO;
import vo.transitionVO.TransferringVO;

public class Transferring {
	//	MockTransferring mockTransferring = new MockTransferring();
	private TransferringDataService transferringDataService = RMI.<TransferringDataService>getDataService("transferring");
	private MakeConstantDataService makeConstantDataService = RMI.<MakeConstantDataService>getDataService("makeConstant");
	private OrderDataService order = RMI.<OrderDataService>getDataService("order");
	
	public TransferringVO findTransferringFormBL(String transferringNumber) {
		// TODO Auto-generated method stub
		TransferringPO transferringPO = null;
		TransferringVO transferringVO = null;
		try {
			transferringPO = transferringDataService.FindTransferringFormDT(transferringNumber);
			if(transferringPO==null){
				return null;
			}
			else {
				transferringVO = TransferringPOtoTransferringVO(transferringPO);				
				transferringVO.setVerifyResult(true);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return transferringVO;
	}

	public boolean addTransferringFormBL(TransferringVO transferringVO) {
		// TODO Auto-generated method stub
		//编辑物流轨迹
		boolean trace = false;
		HashMap<String, String> constant = null;
		try {
			constant = makeConstantDataService.getIDTable();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String position = constant.get(transferringVO.gettransferringid().substring(0, 3));
		for(String del:(transferringVO.getalldeliveryid())){
			try {
				trace = order.setTrace(del, position+"中转中心");
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//保存中转单
		if (trace) {
			double faremoney = this.tranferringFare(transferringVO.getdepartureid(), transferringVO.getarrivalid(),transferringVO.getway());
			transferringVO.setfare(faremoney);
			TransferringPO transferringPO = TransferringVOtoTransferringPO(transferringVO);
			boolean add =false;
			try {
				add = transferringDataService.AddTransferringFormDT(transferringPO);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return add;			
		}
		else {
			return trace;
		}
	}

	public boolean modifyTransferringFormBL(TransferringVO transferringVO) {
		// TODO Auto-generated method stub
		double faremoney = this.tranferringFare(transferringVO.getdepartureid(), transferringVO.getarrivalid(),transferringVO.getway());
		transferringVO.setfare(faremoney);
		TransferringPO transferringPO = TransferringVOtoTransferringPO(transferringVO);
		boolean modify =false;
		try {
			modify = transferringDataService.ModifyTransferringFormDT(transferringPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modify;
	}

	public double tranferringFare(String CityFrom, String CityTo,LoadingType type) {
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


	public List<TransferringVO> GetTansferringInfoBL(String date) {
		// TODO Auto-generated method stub
		List<TransferringPO> transferringPOs = null;
		List<TransferringVO> transferringVOs = new ArrayList<TransferringVO>();
		try {
			transferringPOs = transferringDataService.GetTransferringInfoDT(date);
			if (transferringPOs == null) {
				return null;
			}
			else {
				for(int i=0;i<transferringPOs.size();i++){
					transferringVOs.add(this.TransferringPOtoTransferringVO(transferringPOs.get(i)));
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transferringVOs;		
	}
	
	public boolean verify(TransferringVO transferringVO) {
		if (transferringVO.gettransferringid() .equals("") || (!transferringVO
				.gettransferringid().matches("\\d{15}"))) {
			transferringVO.seterrorMsg("中转单编号为空或输入错误(15位)");
			return false;
		}
		if (transferringVO.getloadingdate().equals("")) {
			transferringVO.seterrorMsg("时间不可为空");
			return false;
		}
		if (!CommonLogic.isDate(transferringVO.getloadingdate())) {
			transferringVO.seterrorMsg("时间输入错误");
			return false;
		}
//		String[] aStrings =transferringVO.getloadingdate().split("-");
//		String date = "";
////		for(String x :aStrings){
////			System.out.println(x+"1");
////		}
//		if(aStrings[0].equals(" ")||aStrings[1].equals(" ")||aStrings[2].equals(" ")){
//			transferringVO.seterrorMsg("装运日期不能为空");
//			return false;
//		}
//		for(int i=0;i<3;i++){
//			aStrings[i] =aStrings[i].trim();
//			if (i == 2) {
//				date += aStrings[i];
//			}
//			else {
//				date = date + aStrings[i] + "-";				
//			}
//		}
//		int[] aint = new int[3];
// 		for(int i=0;i<3;i++){
//			aint[i] = Integer.parseInt(aStrings[i]);
//			
//		}
//		if(aint[1]<1||aint[1]>12){
//			transferringVO.seterrorMsg("月份输入错误");
//			return false;
//		}
//		if (aint[2]<1||aint[2]>31) {
//			transferringVO.seterrorMsg("日期输入错误");
//			return false;
//		}
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		try {
//			// 设置lenient为false.
//			// 否则SimpleDateFormat会比较宽松地验证日期，比如2007-02-29会被接受，并转换成2007-03-01
//			format.setLenient(false);
//			format.parse(date);
//		} catch (ParseException e) {
//			// e.printStackTrace();
//			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
//			transferringVO.seterrorMsg("日期输入有误");
//			return false;
//		}
		

		if (transferringVO.getwayid().equals("")||(!transferringVO.getwayid().matches("\\d{9}"))) {
			transferringVO.seterrorMsg("装运方式编号不能为空或输入错误(9位)");
			return false;
		}
		if (transferringVO.getdepartureid().equals("")) {
			transferringVO.seterrorMsg("出发地不能为空");
			return false;
		}
		if (transferringVO.getarrivalid().equals("")) {
			transferringVO.seterrorMsg("到达地不能为空");
			return false;
		}
		if (transferringVO.getsupervisionid().equals("")) {
			transferringVO.seterrorMsg("监装员不能为空");
			return false;
		}
		if (transferringVO.getcontainerid().equals("")) {
			transferringVO.seterrorMsg("货柜号不能为空");
			return false;
		}
		if (transferringVO.getalldeliveryid()==null) {
			transferringVO.seterrorMsg("所有装运单号不能为空");
			return false;
		}
		
		return true;
	}
	private TransferringPO TransferringVOtoTransferringPO(TransferringVO transferringVO){
		TransferringPO transferringPO=new TransferringPO(transferringVO.getloadingdate(), transferringVO.gettransferringid(),
				transferringVO.getway(), transferringVO.getwayid(), transferringVO.getdepartureid(),
				transferringVO.getarrivalid(), transferringVO.getsupervisionid(), 
				transferringVO.getcontainerid(), transferringVO.getalldeliveryid());
		transferringPO.setfare(transferringVO.getfare());
		return transferringPO;
	}
	private TransferringVO TransferringPOtoTransferringVO(TransferringPO transferringPO){
		TransferringVO transferringVO =new TransferringVO(transferringPO.getloadingdate(), transferringPO.gettransferringid(),
				transferringPO.getway(), transferringPO.getwayid(), 
				transferringPO.getdepartureid(), transferringPO.getarrivalid(), 
				transferringPO.getsupervisionid(), transferringPO.getcontainerid(), 
				transferringPO.getalldeliveryid());
		transferringVO.setfare(transferringPO.getfare());
		return transferringVO;
	}
}
