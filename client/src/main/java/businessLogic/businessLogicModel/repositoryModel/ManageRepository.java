package businessLogic.businessLogicModel.repositoryModel;

import java.util.ArrayList;
import java.util.List;

import constant.AreaCodeType;
import mock.object.MockCheckRepository;
import mock.object.MockGetRepository;
import mock.object.MockSeeRepository;
import po.repositoryPO.DeliveryInfoPO;
import po.repositoryPO.RepositoryInfoPO;
import po.repositoryPO.RepositoryPO;
import vo.repositoryVO.DeliveryInfoVO;
import vo.repositoryVO.RepositoryInfoVO;
import vo.repositoryVO.RepositoryVO;

public class ManageRepository {
	MockCheckRepository check = new MockCheckRepository();
	MockGetRepository get = new MockGetRepository();
	MockSeeRepository see = new MockSeeRepository();
	private List<RepositoryVO> repositoryVOs;
	private List<RepositoryInfoVO> repositoryVOs2;
	private List<DeliveryInfoVO> deliveryInfoVOs;

	public List<RepositoryInfoVO> SeeRepositoryBL(String time) {
		// TODO Auto-generated method stub
		List<RepositoryInfoPO> repositoryPOs = see.SeeRepositoryDT(time);
		repositoryVOs2 = new ArrayList<RepositoryInfoVO>();
		for(int i=0;i<(repositoryPOs.size());i++){
			repositoryVOs2.add(this.RepositoryInfoPOtoRepositoryInfoVO(repositoryPOs.get(i)));
		}
		return repositoryVOs2;
	}

	public List<DeliveryInfoVO> CheckRepositoryBL() {
		// TODO Auto-generated method stub
		List<DeliveryInfoPO> deliveryInfoPOs = check.CheckRepositoryDT();
		deliveryInfoVOs = new ArrayList<DeliveryInfoVO>();
		for(int i=0;i<(deliveryInfoPOs.size());i++){
			deliveryInfoVOs.add(this.DeliveryInfoPOtoDeliveryInfoVO(deliveryInfoPOs.get(i)));
		}
		return deliveryInfoVOs;
	}

	public boolean SetWarnValueBL(AreaCodeType ID, int allNum, double WarnNum) {
		// TODO Auto-generated method stub
		return false;
	}

	public double GetWranNumBL(AreaCodeType ID) {
		// TODO Auto-generated method stub
		return 0.0;
	}

	public int GetRepositoryNumBL(AreaCodeType ID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int GetRepositoryExistBL(AreaCodeType ID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<RepositoryVO> GetRepositoryInfoBL() {
		// TODO Auto-generated method stub
		List<RepositoryPO> repositoryPOs = get.GetRepositoryInfoDT();
		repositoryVOs = new ArrayList<RepositoryVO>();
		for(int i=0;i<(repositoryPOs.size());i++){
			RepositoryVO repositoryvo=this.RepositoryPOtoRepositoryVO(repositoryPOs.get(i));
			repositoryVOs.add(repositoryvo);
		}
		return repositoryVOs;
	}
	private RepositoryVO RepositoryPOtoRepositoryVO(RepositoryPO repositoryPO){
		return new RepositoryVO(repositoryPO.getdeliveryid(), repositoryPO.getinrepositorydate(),
				repositoryPO.getarrivalid(), repositoryPO.getareaCode(), 
				repositoryPO.getrowid(), repositoryPO.getshelfid(), repositoryPO.getposid());
	}
	private RepositoryInfoVO RepositoryInfoPOtoRepositoryInfoVO(RepositoryInfoPO repositoryInfoPO){
		return new RepositoryInfoVO(repositoryInfoPO.getdeliveryid(),repositoryInfoPO.getareaCode(), 
				repositoryInfoPO.getrowid(), repositoryInfoPO.getshelfid(), 
				repositoryInfoPO.getposid(), repositoryInfoPO.getbeinrepository());
	}
	private DeliveryInfoVO DeliveryInfoPOtoDeliveryInfoVO(DeliveryInfoPO deliveryInfoPO){
		return new DeliveryInfoVO(deliveryInfoPO.getdeliveryid(), deliveryInfoPO.getinrepositorydate(), 
				deliveryInfoPO.getarrivalid(), deliveryInfoPO.getareaCode(), 
				deliveryInfoPO.getrowid(), deliveryInfoPO.getshelfid(), deliveryInfoPO.getposid());
	}
}
