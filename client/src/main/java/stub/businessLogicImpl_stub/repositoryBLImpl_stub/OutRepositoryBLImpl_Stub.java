package stub.businessLogicImpl_stub.repositoryBLImpl_stub;

import java.rmi.RemoteException;
import java.util.List;

import businessLogicService.repositoryBLService.OutRepositoryBLService;
import businessLogicService.transitionBLService.TransferringBLService;
import dataService.repositoryDataService.OutRepositoryDataService;
import po.repositoryPO.OutRepositoryPO;
import stub.businessLogicImpl_stub.transitionBLImpl_stub.TransferringBLImpl_Stub;
import stub.dataImpl_stub.repositoryDataImpl_stub.OutRepositoryDataImpl_Stub;
import vo.repositoryVO.OutRepositoryVO;
import vo.transitionVO.TransferringVO;

public class OutRepositoryBLImpl_Stub implements OutRepositoryBLService{
	OutRepositoryDataService outRepositoryDataService=new OutRepositoryDataImpl_Stub();
	TransferringBLService transferringBLService=new TransferringBLImpl_Stub();

	public boolean addOutRepositoryFormBL(OutRepositoryVO outRepositoryVO) {
		// TODO Auto-generated method stub
		outRepositoryVO.setbeinrepository(false);
		boolean update = false;
		try {
			update = outRepositoryDataService.UpdateRepositoryInfoDT(this.OutRepositoryVOtoOutRepositoryPO(outRepositoryVO));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean add = false;
		try {
			add = outRepositoryDataService.AddOutRepositoryFormDT(this.OutRepositoryVOtoOutRepositoryPO(outRepositoryVO));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(update&&add){
			return true;
		}
		else {			
			return false;
		}
	}

	public boolean modifyOutRepositoryFormBL(OutRepositoryVO outRepositoryVO) {
		// TODO Auto-generated method stub
		outRepositoryVO.setbeinrepository(false);
		boolean update = false;
		try {
			update = outRepositoryDataService.UpdateRepositoryInfoDT(this.OutRepositoryVOtoOutRepositoryPO(outRepositoryVO));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean add = false;
		try {
			add = outRepositoryDataService.ModifyOutRepositoryFormDT(this.OutRepositoryVOtoOutRepositoryPO(outRepositoryVO));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(update&&add){
			return true;
		}
		else {			
			return false;
		}
	}

	public OutRepositoryVO findOutRepositoryFormBL(String OutRepositoryNumber) {
		// TODO Auto-generated method stub
		try {
			return this.OutRepositoryPOtoOutRepositoryVO(outRepositoryDataService.FindOutRepositoryFormDT(OutRepositoryNumber));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<TransferringVO> GetTransferringInfo(String data) {
		// TODO Auto-generated method stub
		
		return transferringBLService.GetTansferringInfoBL(data);
	}
	
	private OutRepositoryVO OutRepositoryPOtoOutRepositoryVO(OutRepositoryPO outRepositoryPO){
		return new OutRepositoryVO(outRepositoryPO.getdeliveryid(), outRepositoryPO.getoutrepositorydate(), 
				outRepositoryPO.getarrivalid(), outRepositoryPO.getway(), 
				outRepositoryPO.getloadingid(), outRepositoryPO.getbeinrepository());
	}
	private OutRepositoryPO OutRepositoryVOtoOutRepositoryPO(OutRepositoryVO outRepositoryVO){
		return new OutRepositoryPO(outRepositoryVO.getdeliveryid(), outRepositoryVO.getoutrepositorydate(), 
				outRepositoryVO.getarrivalid(), outRepositoryVO.getway(), 
				outRepositoryVO.getloadingid(), outRepositoryVO.getbeinrepository());
	}
}
