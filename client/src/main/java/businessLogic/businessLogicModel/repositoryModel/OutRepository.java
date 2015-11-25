package businessLogic.businessLogicModel.repositoryModel;


import java.rmi.RemoteException;

import dataService.repositoryDataService.OutRepositoryDataService;
import network.RMI;
import po.repositoryPO.OutRepositoryPO;
import vo.repositoryVO.OutRepositoryVO;

public class OutRepository {
	private OutRepositoryDataService outRepositoryDataService = RMI.<OutRepositoryDataService>getDataService("outrepository");
	public boolean addOutRepositoryFormBL(OutRepositoryVO outRepositoryVO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean modifyOutRepositoryFormBL(OutRepositoryVO outRepositoryVO) {
		// TODO Auto-generated method stub
		return false;
	}

	public OutRepositoryVO findOutRepositoryFormBL(String OutRepositoryNumber) {
		// TODO Auto-generated method stub
		OutRepositoryPO outRepositoryPO =null;
		OutRepositoryVO result=null;
		try {
			outRepositoryPO = outRepositoryDataService.FindOutRepositoryFormDT(OutRepositoryNumber);
			if(outRepositoryPO==null){
				return null;
			}
			else {
				result = OutRepositoryPOtoOutRepositoryVO(outRepositoryPO);				
				result.setVerifyResult(true);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	private OutRepositoryVO OutRepositoryPOtoOutRepositoryVO(OutRepositoryPO outRepositoryPO){
		return new OutRepositoryVO(outRepositoryPO.getdeliveryid(), outRepositoryPO.getoutrepositorydate(), 
				outRepositoryPO.getarrivalid(), outRepositoryPO.getway(), 
				outRepositoryPO.getloadingid());
	}
	private OutRepositoryPO OutRepositoryVOtoOutRepositoryPO(OutRepositoryVO outRepositoryVO){
		return new OutRepositoryPO(outRepositoryVO.getdeliveryid(), outRepositoryVO.getoutrepositorydate(), 
				outRepositoryVO.getarrivalid(), outRepositoryVO.getway(), 
				outRepositoryVO.getloadingid());
	}
	
	public boolean verify(OutRepositoryVO outRepositoryVO) {
		// TODO Auto-generated method stub
		if (outRepositoryVO.getdeliveryid().equals("")||outRepositoryVO.getdeliveryid().length()!=10) {
			outRepositoryVO.seterrorMsg("快递编号不能为空或输入错误(10位)");
			return false;
		}
		String[] aStrings =outRepositoryVO.getoutrepositorydate().split("-");
		if(aStrings[0].equals(" ")||aStrings[1].equals(" ")||aStrings[2].equals(" ")){
			outRepositoryVO.seterrorMsg("入库日期不能为空");
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
			outRepositoryVO.seterrorMsg("月份输入错误");
			return false;
		}
		if (aint[2]<1||aint[2]>31) {
			outRepositoryVO.seterrorMsg("日期输入错误");
			return false;
		}
		if (outRepositoryVO.getarrivalid().equals("")) {
			outRepositoryVO.seterrorMsg("目的地不能为空");
			return false;
		}
		if (outRepositoryVO.getloadingid().equals("")||outRepositoryVO.getloadingid().length()!=11) {
			outRepositoryVO.seterrorMsg("装运信息编号不能为空或输入错误(11位)");
			return false;
		}
		return true;
	}
}
