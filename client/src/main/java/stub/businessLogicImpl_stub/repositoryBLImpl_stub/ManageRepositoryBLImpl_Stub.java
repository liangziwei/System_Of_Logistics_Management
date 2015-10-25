package stub.businessLogicImpl_stub.repositoryBLImpl_stub;

import java.util.List;

import businessLogicService.repositoryBLService.ManageRepositoryBLService;
import dataService.repositoryDataService.ManageRepositoryDataService;
import po.repositoryPO.RepositoryPO;
import stub.dataImpl_stub.repositoryDataImpl.ManageRepositoryDataImpl_Stub;
import vo.repositoryVO.DeliveryInfoVO;
import vo.repositoryVO.RepositoryInfoVO;
import vo.repositoryVO.RepositoryVO;

public class ManageRepositoryBLImpl_Stub implements ManageRepositoryBLService{
	private ManageRepositoryDataService manageRepositoryData =new ManageRepositoryDataImpl_Stub();

	public List<RepositoryInfoVO> SeeRepositoryBL(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DeliveryInfoVO> CheckRepositoryBL() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean SetWarnValueBL(String ID, int allNum, double WarnNum) {
		// TODO Auto-generated method stub
		return false;
	}

	public double GetWranNumBL(String ID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int GetRepositoryNumBL(String ID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int GetRepositoryExistBL(String ID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<RepositoryVO> GetRepositoryInfoBL() {
		// TODO Auto-generated method stub
		List<RepositoryPO> repositoryPOs = manageRepositoryData.GetRepositoryInfoDT();
		List<RepositoryVO> repositoryVOs = null;
		for(int i=0;i<(repositoryPOs.size());i++){
			repositoryVOs.add(this.RepositoryPOtoRepositoryVO(repositoryPOs.get(i)));
		}
		return repositoryVOs;
	}
	private RepositoryVO RepositoryPOtoRepositoryVO(RepositoryPO repositoryPO){
		return new RepositoryVO(repositoryPO.getdeliveryid(), repositoryPO.getinrepositorydate(),
				repositoryPO.getarrivalid(), repositoryPO.getareaCode(), 
				repositoryPO.getrowid(), repositoryPO.getshelfid(), repositoryPO.getposid());
	}

}
