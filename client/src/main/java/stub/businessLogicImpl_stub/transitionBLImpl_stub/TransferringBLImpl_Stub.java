package stub.businessLogicImpl_stub.transitionBLImpl_stub;

import java.util.List;

import businessLogicService.repositoryBLService.ManageRepositoryBLService;
import businessLogicService.transitionBLService.TransferringBLService;
import constant.City;
import dataService.transitionDataService.TransferringDataService;
import po.transitionPO.TransferringPO;
import stub.businessLogicImpl_stub.repositoryBLImpl_stub.ManageRepositoryBLImpl_Stub;
import stub.dataImpl_stub.transitionDataImpl.TransferringDataImpl_Stub;
import vo.repositoryVO.RepositoryVO;
import vo.transitionVO.TransferringVO;

public class TransferringBLImpl_Stub implements TransferringBLService{
	private TransferringDataService transferringdata= new TransferringDataImpl_Stub();
	private ManageRepositoryBLService manageRepositoryBL =new ManageRepositoryBLImpl_Stub();

	public TransferringVO findTransferringFormBL(String transferringNumber) {
		// TODO Auto-generated method stub
		return this.TransferringPOtoTransferringVO(transferringdata.FindTransferringFormDT(transferringNumber));
	}

	public boolean addTransferringFormBL(TransferringVO transferringVO) {
		// TODO Auto-generated method stub
		double fare =this.tranferringFare(transferringVO.getdepartureid(), transferringVO.getarrivalid());
		transferringVO.setfare(fare);
		TransferringPO transferringPO=this.TransferringVOtoTransferringPO(transferringVO);
		return transferringdata.AddTransferringFormDT(transferringPO);
	}

	public boolean modifyTransferringFormBL(TransferringVO transferringVO) {
		// TODO Auto-generated method stub
		double fare =this.tranferringFare(transferringVO.getdepartureid(), transferringVO.getarrivalid());
		transferringVO.setfare(fare);
		TransferringPO transferringPO=this.TransferringVOtoTransferringPO(transferringVO);
		return transferringdata.AddTransferringFormDT(transferringPO);
	}

	public double tranferringFare(City CityFrom, City CityTo) {
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
		List<TransferringPO> transferringPOs = this.transferringdata.GetTransferringInfoDT(date);
		List<TransferringVO> transferringVOs =null;
		for(int i=0;i<transferringPOs.size();i++){
			transferringVOs.add(this.TransferringPOtoTransferringVO(transferringPOs.get(i)));
		}
		return transferringVOs;
	}
	

}
