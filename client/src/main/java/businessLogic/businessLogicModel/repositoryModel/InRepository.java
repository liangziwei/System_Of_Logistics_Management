package businessLogic.businessLogicModel.repositoryModel;

import vo.repositoryVO.InRepositoryVO;

public class InRepository {
	public String addInRepositoryFormBL(InRepositoryVO inRepository) {
		// TODO Auto-generated method stub
		return null;
	}

	public String modifyInRepositoryFormBL(InRepositoryVO inRepositoryVO) {
		// TODO Auto-generated method stub
		return null;
	}

	public InRepositoryVO findInRepositoryFormBL(String InRepositoryNumber) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean verify(InRepositoryVO inRepositoryVO) {
		if (inRepositoryVO.getdeliveryid().equals("")||inRepositoryVO.getdeliveryid().length()!=10) {
			inRepositoryVO.seterrorMsg("快递编号不能为空或输入错误");
			return false;
		}
		if (inRepositoryVO.getarrivalid().equals("")) {
			inRepositoryVO.seterrorMsg("目的地不能为空");
			return false;
		}
		String[] aStrings =inRepositoryVO.getinrepositorydate().split("-");
		if(aStrings[0].equals(" ")||aStrings[1].equals(" ")||aStrings[2].equals(" ")){
			inRepositoryVO.seterrorMsg("入库日期不能为空");
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
			inRepositoryVO.seterrorMsg("月份输入错误");
			return false;
		}
		if (aint[2]<1||aint[2]>31) {
			inRepositoryVO.seterrorMsg("日期输入错误");
			return false;
		}
		
		if (inRepositoryVO.getrowid().equals("")) {
			inRepositoryVO.seterrorMsg("排号不能为空");
			return false;
		}
		if (inRepositoryVO.getshelfid().equals("")) {
			inRepositoryVO.seterrorMsg("架号不能为空");
			return false;
		}
		if (inRepositoryVO.getposid().equals("")) {
			inRepositoryVO.seterrorMsg("位号不能为空");
			return false;
		}
		return true;	
	}
}
