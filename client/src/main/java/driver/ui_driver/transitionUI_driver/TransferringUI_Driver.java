package driver.ui_driver.transitionUI_driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import businessLogicService.transitionBLService.TransferringBLService;
import constant.AreaCodeType;
import constant.City;
import constant.LoadingType;
import po.repositoryPO.RepositoryPO;
import stub.businessLogicImpl_stub.transitionBLImpl_stub.TransferringBLImpl_Stub;
import vo.repositoryVO.RepositoryVO;
import vo.transitionVO.TransferringVO;

public class TransferringUI_Driver {
	public static void main(String[] args) {
		TransferringBLService transferringBLService=new TransferringBLImpl_Stub();
		boolean go =true;
		Scanner s = new Scanner(System.in);
		while (go) {
			System.out.println("请输入请求:(1)添加中转单（2）修改中转单"
					+ "（3）查询中转单 (4)查看库存信息 (5)结束");
			int input = s.nextInt();
			switch(input){
			case 1:List<String> alldeliveryid = new ArrayList<String>();
			alldeliveryid.add("1110000123");
			alldeliveryid.add("1110001342");
			alldeliveryid.add("1110022123");
			boolean add=transferringBLService.addTransferringFormBL(new TransferringVO("2015-10-11","01710100000127" , LoadingType.PLANE,"139010001","北京", "南京", "茗柯", "3", alldeliveryid));
			if(add){
				System.out.println("添加成功");
			}
			else {
				System.out.println("添加失败");
			}
			break;
			case 2:alldeliveryid = new ArrayList<String>();
			alldeliveryid.add("1110000123");
			alldeliveryid.add("1110001342");
			alldeliveryid.add("1110022123");
			boolean modify = transferringBLService.modifyTransferringFormBL(new TransferringVO("2015-10-11","01710100000127" , LoadingType.PLANE,"139010001","北京", "南京", "茗柯", "5", alldeliveryid));
			if(modify){
				System.out.println("修改成功");
			}
			else {
				System.out.println("修改失败");
			}			
			break;
			case 3:TransferringVO transferringVO=transferringBLService.findTransferringFormBL("01710100000127");
			System.out.println("装车（机）日期"+transferringVO.getloadingdate()+"\n"+
			"本中转中心中转单编号"+transferringVO.gettransferringid()+"\n"+"运送方式"+transferringVO.getway()+"\n"
			+"汽车(或火车)(或航班)编号"+transferringVO.getwayid()+"\n"+"出发地"+transferringVO.getdepartureid()+"\n"+
			"到达地"+transferringVO.getarrivalid()+"\n"+"货柜号"+transferringVO.getcontainerid()+"\n"+
			"监装员"+transferringVO.getsupervisionid()+"\n"+"本次装箱所有托运单号"+transferringVO.getalldeliveryid()+"\n"+
			"运费"+transferringVO.getfare());
			
			break;
			case 4:List<RepositoryVO> repositoryVO=transferringBLService.getRepositoryInfo();
				for(int i=0;i<repositoryVO.size();i++){
					String deliveryid=(repositoryVO.get(i)).getdeliveryid();
					String inrepositoryDate=(repositoryVO.get(i)).getinrepositorydate();
					String arrivalid = (repositoryVO.get(i)).getarrivalid();
					AreaCodeType area = (repositoryVO.get(i)).getareaCode();
					String row =(repositoryVO.get(i)).getrowid();
					String shelfid =(repositoryVO.get(i)).getshelfid();
					String pos=(repositoryVO.get(i)).getposid();
					System.out.println("快递编号"+deliveryid+"\n"+"入库日期"+inrepositoryDate+"\n"+
					"目的地"+arrivalid+"\n"+"区号"+area+"\n"+"排号"+row+"\n"+"架号"+shelfid+"\n"+"位号"+pos);
				}
				break;
			case 5:go = false;
				break;			
			}
		}
	}
}
