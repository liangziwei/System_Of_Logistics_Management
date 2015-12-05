package businessLogic.businessLogicModel.repositoryModel;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import mock.object.MockCheckRepository;
import mock.object.MockGetRepository;
import mock.object.MockSeeRepository;
import network.RMI;
import po.repositoryPO.DeliveryInfoPO;
import po.repositoryPO.RepositoryInfoPO;
import po.repositoryPO.RepositoryPO;
import vo.repositoryVO.DeliveryInfoVO;
import vo.repositoryVO.RepositoryInfoVO;
import vo.repositoryVO.RepositoryVO;
import constant.AreaCodeType;
import dataService.repositoryDataService.ManageRepositoryDataService;

public class ManageRepository {
//	MockCheckRepository check = new MockCheckRepository();
//	MockGetRepository get = new MockGetRepository();
//	MockSeeRepository see = new MockSeeRepository();
	private ManageRepositoryDataService manageRepositoryDataService = RMI.<ManageRepositoryDataService>getDataService("manage");
//	private List<RepositoryVO> repositoryVOs;
//	private List<RepositoryInfoVO> repositoryVOs2;
//	private List<DeliveryInfoVO> deliveryInfoVOs;

	public List<RepositoryInfoVO> SeeRepositoryBL(String time) {
		// TODO Auto-generated method stub
//		List<RepositoryInfoPO> repositoryPOs = see.SeeRepositoryDT(time);
//		repositoryVOs2 = new ArrayList<RepositoryInfoVO>();
//		for(int i=0;i<(repositoryPOs.size());i++){
//			repositoryVOs2.add(this.RepositoryInfoPOtoRepositoryInfoVO(repositoryPOs.get(i)));
//		}
		List<RepositoryInfoPO> listPO = new ArrayList<RepositoryInfoPO>();
		List<RepositoryInfoVO> listVO = new ArrayList<RepositoryInfoVO>();
		try {
			listPO = manageRepositoryDataService.SeeRepositoryDT(time);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<(listPO.size());i++){
			listVO.add(this.RepositoryInfoPOtoRepositoryInfoVO(listPO.get(i)));
		}
		return listVO;
	}

	public List<DeliveryInfoVO> CheckRepositoryBL() {
		// TODO Auto-generated method stub
//		List<DeliveryInfoPO> deliveryInfoPOs = check.CheckRepositoryDT();
//		deliveryInfoVOs = new ArrayList<DeliveryInfoVO>();
//		for(int i=0;i<(deliveryInfoPOs.size());i++){
//			deliveryInfoVOs.add(this.DeliveryInfoPOtoDeliveryInfoVO(deliveryInfoPOs.get(i)));
//		}
		List<DeliveryInfoPO> listPO2 = new ArrayList<DeliveryInfoPO>();
		List<DeliveryInfoVO> listVO2 = new ArrayList<DeliveryInfoVO>();
		try {
			listPO2 = manageRepositoryDataService.CheckRepositoryDT();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<(listPO2.size());i++){
			DeliveryInfoVO deliveryInfoVO = this.DeliveryInfoPOtoDeliveryInfoVO(listPO2.get(i));
			listVO2.add(deliveryInfoVO);
		}
		return listVO2;
	}

	public boolean SetWarnValueBL(AreaCodeType ID, int allNum, double WarnNum) {
		// TODO Auto-generated method stub
		boolean set = false;
		try {
			set = manageRepositoryDataService.UpdataRepositoryWarnDT(allNum, WarnNum, ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return set;
	}

	public double GetWarnNumBL(AreaCodeType ID) {
		// TODO Auto-generated method stub
		double warnnnum = 0.0;
		try {
			warnnnum = manageRepositoryDataService.GetWarnNumDT(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return warnnnum;
	}

	public int GetRepositoryNumBL(AreaCodeType ID) {
		// TODO Auto-generated method stub
		int num=0;
		try {
			num = manageRepositoryDataService.GetRepositoryNumDT(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	public int GetRepositoryExistBL(AreaCodeType ID) {
		// TODO Auto-generated method stub
		int exist = 0;
		try {
			exist = manageRepositoryDataService.GetRepositoryExistDT(ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exist;
	}

	public List<RepositoryVO> GetRepositoryInfoBL() {
		// TODO Auto-generated method stub
		List<RepositoryPO> repositoryPOs = new ArrayList<RepositoryPO>();
		List<RepositoryVO> repositoryVOs = new ArrayList<RepositoryVO>();
		try {
			repositoryPOs = manageRepositoryDataService.GetRepositoryInfoDT();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<(repositoryPOs.size());i++){
			RepositoryVO repositoryvo=this.RepositoryPOtoRepositoryVO(repositoryPOs.get(i));
			repositoryVOs.add(repositoryvo);
		}
		return repositoryVOs;
	}
	
	public boolean verify(String warn, String all) {
		// TODO Auto-generated method stub
		if (warn.equals("")||all.equals("")) {
			return false;
		}
		if ((Double.parseDouble(warn))>1||(Double.parseDouble(warn))<0) {
			return false;
		}
		return true;
	}
	
	private RepositoryVO RepositoryPOtoRepositoryVO(RepositoryPO repositoryPO){
		return new RepositoryVO(repositoryPO.getdeliveryid(), repositoryPO.getinrepositorydate(),
				repositoryPO.getarrivalid(), repositoryPO.getareaCode(), 
				repositoryPO.getrowid(), repositoryPO.getshelfid(), repositoryPO.getposid());
	}
	private RepositoryInfoVO RepositoryInfoPOtoRepositoryInfoVO(RepositoryInfoPO repositoryInfoPO){
		RepositoryInfoVO repositoryInfoVO = new RepositoryInfoVO(repositoryInfoPO.getdeliveryid(),repositoryInfoPO.getareaCode(), 
				repositoryInfoPO.getrowid(), repositoryInfoPO.getshelfid(), 
				repositoryInfoPO.getposid(), repositoryInfoPO.getbeinrepository());
		repositoryInfoVO.setmoney(repositoryInfoPO.getmoney());
		return repositoryInfoVO;
	}
	private DeliveryInfoVO DeliveryInfoPOtoDeliveryInfoVO(DeliveryInfoPO deliveryInfoPO){
		return new DeliveryInfoVO(deliveryInfoPO.getdeliveryid(), deliveryInfoPO.getinrepositorydate(), 
				deliveryInfoPO.getarrivalid(), deliveryInfoPO.getareaCode(), 
				deliveryInfoPO.getrowid(), deliveryInfoPO.getshelfid(), deliveryInfoPO.getposid());
	}
}
