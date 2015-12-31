package businessLogic.businessLogicController.repositoryController;

import java.util.List;

import businessLogic.businessLogicModel.repositoryModel.ManageRepository;
import businessLogicService.repositoryBLService.ManageRepositoryBLService;
import constant.AreaCodeType;
import vo.repositoryVO.DeliveryInfoVO;
import vo.repositoryVO.RepositoryInfoVO;
import vo.repositoryVO.RepositoryVO;

public class ManageRepositoryController implements ManageRepositoryBLService{
	ManageRepository manageRepository = new ManageRepository();

	public List<RepositoryInfoVO> SeeRepositoryBL(String time) {
		// TODO Auto-generated method stub
		return manageRepository.SeeRepositoryBL(time);
	}

	public List<DeliveryInfoVO> CheckRepositoryBL() {
		// TODO Auto-generated method stub
		return manageRepository.CheckRepositoryBL();
	}

	public boolean SetWarnValueBL(AreaCodeType ID, int allNum, double WarnNum) {
		// TODO Auto-generated method stub
		return manageRepository.SetWarnValueBL(ID, allNum, WarnNum);
	}

	public double GetWarnNumBL(AreaCodeType ID) {
		// TODO Auto-generated method stub
		return manageRepository.GetWarnNumBL(ID);
	}

	public int GetRepositoryNumBL(AreaCodeType ID) {
		// TODO Auto-generated method stub
		return manageRepository.GetRepositoryNumBL(ID);
	}

	public int GetRepositoryExistBL(AreaCodeType ID) {
		// TODO Auto-generated method stub
		return manageRepository.GetRepositoryExistBL(ID);
	}

	public List<RepositoryVO> GetRepositoryInfoBL() {
		// TODO Auto-generated method stub
		return manageRepository.GetRepositoryInfoBL();
	}

	@Override
	public boolean verify(String warn, String all) {
		// TODO Auto-generated method stub	
		return manageRepository.verify(warn, all);
	}

	@Override
	public void allExcel(String fileSave, List<DeliveryInfoVO> list) {
		// TODO Auto-generated method stub
		manageRepository.Excel(fileSave, list);
	}

//	@Override
//	public void plExcel(String fileSave, List<DeliveryInfoVO> list) {
//		// TODO Auto-generated method stub
//		manageRepository.Excel(fileSave, list);
//	}
//
//	@Override
//	public void traExcel(String fileSave, List<DeliveryInfoVO> list) {
//		// TODO Auto-generated method stub
//		manageRepository.Excel(fileSave, list);
//	}
//
//	@Override
//	public void truExcel(String fileSave, List<DeliveryInfoVO> list) {
//		// TODO Auto-generated method stub
//		manageRepository.Excel(fileSave, list);
//	}
//
//	@Override
//	public void moExcel(String fileSave, List<DeliveryInfoVO> list) {
//		// TODO Auto-generated method stub
//		manageRepository.Excel(fileSave, list);
//	}
	



}
