package businessLogic.businessLogicModel.transitionModel;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

import mock.object.MockTransferring;
import po.transitionPO.TransferringPO;
import vo.transitionVO.TransferringVO;

public class Transferring {
//	MockTransferring mockTransferring = new MockTransferring();
	
	public TransferringVO findTransferringFormBL(String transferringNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addTransferringFormBL(TransferringVO transferringVO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean modifyTransferringFormBL(TransferringVO transferringVO) {
		// TODO Auto-generated method stub
		return false;
	}

	public double tranferringFare(String CityFrom, String CityTo) {
		// TODO Auto-generated method stub
		return 0;
	}


	public List<TransferringVO> GetTansferringInfoBL(String date) {
		// TODO Auto-generated method stub
//		List<TransferringPO> transferringPOs = mockTransferring.GetTransferringInfoDT(date);
//		List<TransferringVO> transferringVOs = new ArrayList<TransferringVO>();
//		for(int i=0;i<transferringPOs.size();i++){
//			transferringVOs.add(this.TransferringPOtoTransferringVO(transferringPOs.get(i)));
//		}
		return null;		
	}
	
	public boolean verify(TransferringVO transferringVO) {
		if (transferringVO.gettransferringid() == null || transferringVO.gettransferringid().length() != 15) {
			transferringVO.seterrorMsg("中转单编号为空或输入错误");
			return false;
		}
		String[] aStrings =transferringVO.getloadingdate().split("-");
//		for(String x :aStrings){
//			System.out.println(x+"1");
//		}
		if(aStrings[0].equals(" ")||aStrings[1].equals(" ")||aStrings[2].equals(" ")){
			transferringVO.seterrorMsg("装运日期不能为空");
			return false;
		}
		for(int i=0;i<3;i++){
			aStrings[i] =aStrings[i].trim();
			
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
		
		if (transferringVO.getwayid()==null||transferringVO.getwayid().length()!=9) {
			transferringVO.seterrorMsg("装运方式编号不能为空或输入错误");
			return false;
		}
		if (transferringVO.getdepartureid()==null) {
			transferringVO.seterrorMsg("出发地不能为空");
			return false;
		}
		if (transferringVO.getarrivalid()==null) {
			transferringVO.seterrorMsg("到达地不能为空");
			return false;
		}
		if (transferringVO.getsupervisionid()==null) {
			transferringVO.seterrorMsg("监装员不能为空");
			return false;
		}
		if (transferringVO.getcontainerid()==null) {
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
