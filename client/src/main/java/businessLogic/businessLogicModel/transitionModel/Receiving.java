package businessLogic.businessLogicModel.transitionModel;

import dataService.transitionDataService.ReceivingDataService;
import vo.transitionVO.ReceivingVO;

public class Receiving {
//	private ReceivingDataService = RMI.<ReceivingDataService>getDataService("receiving");
	public boolean addReceivingFormBL(ReceivingVO receivingVO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean modifyReceivingFormBL(ReceivingVO receivingVO) {
		// TODO Auto-generated method stub
		return false;
	}

	public ReceivingVO findReceivingformBL(String receivingNumber) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean verifyres(ReceivingVO receivingVO){
			
		if(receivingVO.gettransferringid()==null||receivingVO.gettransferringid().length()!=16){
			receivingVO.seterrorMsg("中转单编号不能为空或输入错误");
			return false;
		}
		
		String[] aStrings =receivingVO.getarrivaldate().split("-");
//		for(String x :aStrings){
//			System.out.println(x+"1");
//		}
		if(aStrings[0].equals(" ")||aStrings[1].equals(" ")||aStrings[2].equals(" ")){
			receivingVO.seterrorMsg("到达日期不能为空");
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
			receivingVO.seterrorMsg("月份输入错误");
			return false;
		}
		if (aint[2]<1||aint[2]>31) {
			receivingVO.seterrorMsg("日期输入错误");
			return false;
		}
		
		if(receivingVO.gettransitionid()==null||receivingVO.gettransitionid().length()!=4){
			receivingVO.seterrorMsg("本中转中心编号不能为空或者输入错误");
			return false;
		}
		
		if (receivingVO.getdepartureid()==null) {
			receivingVO.seterrorMsg("出发地不能为空");
			return false;
		}
		
		if (receivingVO.getarrivalid()==null) {
			receivingVO.seterrorMsg("到达地不能为空");
			return false;
		}
		return true;
	}
}
