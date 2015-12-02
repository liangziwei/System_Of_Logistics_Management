package businessLogic.businessLogicModel.transitionModel;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

import dataService.transitionDataService.TransferringDataService;
import mock.object.MockTransferring;
import network.RMI;
import po.transitionPO.LoadingPO;
import po.transitionPO.TransferringPO;
import vo.transitionVO.TransferringVO;

public class Transferring {
//	MockTransferring mockTransferring = new MockTransferring();
	private TransferringDataService transferringDataService = RMI.<TransferringDataService>getDataService("transferring");
	
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
		double faremoney = this.tranferringFare(transferringVO.getdepartureid(), transferringVO.getarrivalid());
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

	public boolean modifyTransferringFormBL(TransferringVO transferringVO) {
		// TODO Auto-generated method stub
		double faremoney = this.tranferringFare(transferringVO.getdepartureid(), transferringVO.getarrivalid());
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

	public double tranferringFare(String CityFrom, String CityTo) {
		// TODO Auto-generated method stub
		return 0;
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
		if (transferringVO.gettransferringid() .equals("") || transferringVO.gettransferringid().length() != 15) {
			transferringVO.seterrorMsg("中转单编号为空或输入错误(15位)");
			return false;
		}
		String[] aStrings =transferringVO.getloadingdate().split("-");
		String date = "";
//		for(String x :aStrings){
//			System.out.println(x+"1");
//		}
		if(aStrings[0].equals(" ")||aStrings[1].equals(" ")||aStrings[2].equals(" ")){
			transferringVO.seterrorMsg("装运日期不能为空");
			return false;
		}
		for(int i=0;i<3;i++){
			aStrings[i] =aStrings[i].trim();
			if (i == 2) {
				date += aStrings[i];
			}
			else {
				date = date + aStrings[i] + "-";				
			}
		}
		int[] aint = new int[3];
 		for(int i=0;i<3;i++){
			aint[i] = Integer.parseInt(aStrings[i]);
			
		}
		if(aint[1]<1||aint[1]>12){
			transferringVO.seterrorMsg("月份输入错误");
			return false;
		}
		if (aint[2]<1||aint[2]>31) {
			transferringVO.seterrorMsg("日期输入错误");
			return false;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			// 设置lenient为false.
			// 否则SimpleDateFormat会比较宽松地验证日期，比如2007-02-29会被接受，并转换成2007-03-01
			format.setLenient(false);
			format.parse(date);
		} catch (ParseException e) {
			// e.printStackTrace();
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			transferringVO.seterrorMsg("日期输入有误");
			return false;
		}
		

		if (transferringVO.getwayid().equals("")||transferringVO.getwayid().length()!=9) {
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
