package stub.businessLogicImpl_stub.repositoryBLImpl_stub;

import businessLogicService.repositoryBLService.InRepositoryBLService;
import businessLogicService.repositoryBLService.ManageRepositoryBLService;
import constant.AreaCodeType;
import dataService.repositoryDataService.InRepositoryDataService;
import po.repositoryPO.InRepositoryPO;
import stub.dataImpl_stub.repositoryDataImpl.InRepositoryDataImpl_Stub;
import vo.repositoryVO.InRepositoryVO;

public class InRepositoryBLImpl_Stub implements InRepositoryBLService{
	InRepositoryDataService inRepositoryDataService=new InRepositoryDataImpl_Stub();
	ManageRepositoryBLService manageRepositoryBLService =new ManageRepositoryBLImpl_Stub();

	public String addInRepositoryFormBL(InRepositoryVO inRepositoryVO) {
		// TODO Auto-generated method stub
		String result=null;
		inRepositoryVO.setbeinrepository(true);
		boolean update =inRepositoryDataService.UpdateRepositoryInfoDT(this.InRepositoryVOtoInRepositoryPO(inRepositoryVO));
		boolean add=inRepositoryDataService.AddInRepositoryFormDT(this.InRepositoryVOtoInRepositoryPO(inRepositoryVO));
		boolean warn = this.warnBL(inRepositoryVO);
		if(add&&update){
			if(warn){
				result="true.warn";
			}
			else {
				result="ture";
			}
		}
		else {
			result="false";
		}
		return result;
	}

	public String modifyInRepositoryFormBL(InRepositoryVO inRepositoryVO) {
		// TODO Auto-generated method stub
		String result=null;
		inRepositoryVO.setbeinrepository(true);
		boolean update =inRepositoryDataService.UpdateRepositoryInfoDT(this.InRepositoryVOtoInRepositoryPO(inRepositoryVO));
		boolean modify=inRepositoryDataService.ModifyInRepositoryFormDT(this.InRepositoryVOtoInRepositoryPO(inRepositoryVO));
		boolean warn = this.warnBL(inRepositoryVO);
		if(modify&&update){
			if(warn){
				result="true.warn";
			}
			else {
				result="ture";
			}
		}
		else {
			result="false";
		}
		return result;
	}

	public InRepositoryVO findInRepositoryFormBL(String InRepositoryNumber) {
		// TODO Auto-generated method stub
		return this.InRepositoryPOtoInRepositoryVO(inRepositoryDataService.FindInRepositoryFormDT(InRepositoryNumber));
	}

	public boolean warnBL(InRepositoryVO inRepositoryVO) {
		// TODO Auto-generated method stub
		AreaCodeType ID = inRepositoryVO.getareaCode();
		double warnnum =this.getWarnNum(ID);
		double repositorynum =this.GetRepositoryNum(ID);
		double repositoryexist =this.GetRepositoryExist(ID);
		if(repositoryexist>=(repositorynum*warnnum)){
			return true;
		}
		else {
			return false;
		}
	}

	public double getWarnNum(AreaCodeType ID) {
		// TODO Auto-generated method stub
		return manageRepositoryBLService.GetWranNumBL(ID);
	}

	public int GetRepositoryNum(AreaCodeType ID) {
		// TODO Auto-generated method stub
		return manageRepositoryBLService.GetRepositoryNumBL(ID);
	}

	public int GetRepositoryExist(AreaCodeType ID) {
		// TODO Auto-generated method stub
		return manageRepositoryBLService.GetRepositoryExistBL(ID);
	}
	
	private InRepositoryVO InRepositoryPOtoInRepositoryVO(InRepositoryPO inRepositoryPO){
		return new InRepositoryVO(inRepositoryPO.getdeliveryid(), inRepositoryPO.getinrepositorydate(),
				inRepositoryPO.getarrivalid(), inRepositoryPO.getareaCode(), inRepositoryPO.getrowid(), 
				inRepositoryPO.getshelfid(), inRepositoryPO.getposid(), inRepositoryPO.getbeinrepository());
	}
	private InRepositoryPO InRepositoryVOtoInRepositoryPO(InRepositoryVO inRepositoryVO){
		return new InRepositoryPO(inRepositoryVO.getdeliveryid(), inRepositoryVO.getinrepositorydate(),
				inRepositoryVO.getarrivalid(), inRepositoryVO.getareaCode(), 
				inRepositoryVO.getrowid(), inRepositoryVO.getshelfid(), 
				inRepositoryVO.getposid(), inRepositoryVO.getbeinrepository());
	}

}
