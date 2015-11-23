package stub.businessLogicImpl_stub.transitionBLImpl_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businessLogicService.repositoryBLService.ManageRepositoryBLService;
import businessLogicService.transitionBLService.TransferringBLService;
import constant.City;
import dataService.transitionDataService.TransferringDataService;
import po.transitionPO.TransferringPO;
import stub.businessLogicImpl_stub.repositoryBLImpl_stub.ManageRepositoryBLImpl_Stub;
import stub.dataImpl_stub.transitionDataImpl_stub.TransferringDataImpl_Stub;
import vo.repositoryVO.RepositoryVO;
import vo.transitionVO.TransferringVO;

public class TransferringBLImpl_Stub implements TransferringBLService{
	private TransferringDataService transferringdata= new TransferringDataImpl_Stub();
	private ManageRepositoryBLService manageRepositoryBL =new ManageRepositoryBLImpl_Stub();

	public TransferringVO findTransferringFormBL(String transferringNumber) {
		// TODO Auto-generated method stub
		try {
			return this.TransferringPOtoTransferringVO(transferringdata.FindTransferringFormDT(transferringNumber));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean addTransferringFormBL(TransferringVO transferringVO) {
		// TODO Auto-generated method stub
		double fare =this.tranferringFare(transferringVO.getdepartureid(), transferringVO.getarrivalid());
		transferringVO.setfare(fare);
		TransferringPO transferringPO=this.TransferringVOtoTransferringPO(transferringVO);
		try {
			return transferringdata.AddTransferringFormDT(transferringPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean modifyTransferringFormBL(TransferringVO transferringVO) {
		// TODO Auto-generated method stub
		double fare =this.tranferringFare(transferringVO.getdepartureid(), transferringVO.getarrivalid());
		transferringVO.setfare(fare);
		TransferringPO transferringPO=this.TransferringVOtoTransferringPO(transferringVO);
		try {
			return transferringdata.AddTransferringFormDT(transferringPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public double tranferringFare(String CityFrom, String CityTo) {
		// TODO Auto-generated method stub
		return 500;
	}

	public List<RepositoryVO> getRepositoryInfo() {
		// TODO Auto-generated method stub
		return manageRepositoryBL.GetRepositoryInfoBL();
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


	public List<TransferringVO> GetTansferringInfoBL(String date) {
		// TODO Auto-generated method stub
		List<TransferringPO> transferringPOs = null;
		try {
			transferringPOs = transferringdata.GetTransferringInfoDT(date);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<TransferringVO> transferringVOs = new ArrayList<TransferringVO>();
		for(int i=0;i<transferringPOs.size();i++){
			transferringVOs.add(this.TransferringPOtoTransferringVO(transferringPOs.get(i)));
		}
		return transferringVOs;
	}

	@Override
	public boolean verify(TransferringVO transferringVO) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
