package businessLogic.businessLogicModel.transitionModel;

import java.util.ArrayList;
import java.util.List;

import mock.object.MockTransferring;
import po.transitionPO.TransferringPO;
import vo.transitionVO.TransferringVO;

public class Transferring {
	MockTransferring mockTransferring = new MockTransferring();
	
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
		List<TransferringPO> transferringPOs = mockTransferring.GetTransferringInfoDT(date);
		List<TransferringVO> transferringVOs = new ArrayList<TransferringVO>();
		for(int i=0;i<transferringPOs.size();i++){
			transferringVOs.add(this.TransferringPOtoTransferringVO(transferringPOs.get(i)));
		}
		return transferringVOs;
		
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
