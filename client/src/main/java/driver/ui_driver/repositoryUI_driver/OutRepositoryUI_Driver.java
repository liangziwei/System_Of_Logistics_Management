package driver.ui_driver.repositoryUI_driver;

import java.util.List;
import java.util.Scanner;

import businessLogicService.repositoryBLService.OutRepositoryBLService;
import constant.LoadingType;
import po.repositoryPO.OutRepositoryPO;
import stub.businessLogicImpl_stub.repositoryBLImpl_stub.OutRepositoryBLImpl_Stub;
import vo.repositoryVO.OutRepositoryVO;
import vo.transitionVO.TransferringVO;

public class OutRepositoryUI_Driver {
	public static void main(String[] args) {
		OutRepositoryBLService outRepositoryBLService=new OutRepositoryBLImpl_Stub();
		boolean go =true;
		Scanner s = new Scanner(System.in);
		while (go) {
			System.out.println("请输入请求:(1)添加出库单（2）修改出库单"
					+ "（3）查询出库单 (4)查询中转单列表(5)结束");
			int input = s.nextInt();
			switch(input){
			case 1:boolean add =outRepositoryBLService.addOutRepositoryFormBL(new OutRepositoryVO("2015100046", "2015-10-18","广州",LoadingType.TRUCK,"025 1012 0002301",""));
			if(add){
				System.out.println("添加成功");
			}
			else {
				System.out.println("添加失败");
			}
			break;
			case 2:boolean modify =outRepositoryBLService.modifyOutRepositoryFormBL(new OutRepositoryVO("2015100046", "2015-10-18","广州",LoadingType.TRUCK,"025 1012 0002301",""));
			if(modify){
				System.out.println("修改成功");
			}
			else {
				System.out.println("修改失败");
			}			
			break;
			case 4:List<TransferringVO> outRepositoryVO = outRepositoryBLService.GetTransferringInfo("2015-10-25");
			for(int i=0;i<outRepositoryVO.size();i++){
				System.out.println("装车（机）日期"+outRepositoryVO.get(i).getloadingdate()+"\n"+
						"本中转中心中转单编号"+outRepositoryVO.get(i).gettransferringid()+"\n"+"运送方式"+outRepositoryVO.get(i).getway()+"\n"
						+"汽车(或火车)(或航班)编号"+outRepositoryVO.get(i).getwayid()+"\n"+"出发地"+outRepositoryVO.get(i).getdepartureid()+"\n"+
						"到达地"+outRepositoryVO.get(i).getarrivalid()+"\n"+"货柜号"+outRepositoryVO.get(i).getcontainerid()+"\n"+
						"监装员"+outRepositoryVO.get(i).getsupervisionid()+"\n"+"本次装箱所有托运单号"+outRepositoryVO.get(i).getalldeliveryid()+"\n"+
						"运费"+outRepositoryVO.get(i).getfare());
			}
			break;
			case 3:OutRepositoryVO outRepositoryVO2 =outRepositoryBLService.findOutRepositoryFormBL("2015100046");
			System.out.println("快递编号"+outRepositoryVO2.getdeliveryid()+"\n"+"出库日期"+outRepositoryVO2.getoutrepositorydate()+"\n"
			+"目的地"+outRepositoryVO2.getarrivalid()+"\n"+"装运方式"+outRepositoryVO2.getway()+"\n"+
					"装运单编号"+outRepositoryVO2.getloadingid());
			break;
			case 5:go = false;
			break;
			}
		}
	}
}
