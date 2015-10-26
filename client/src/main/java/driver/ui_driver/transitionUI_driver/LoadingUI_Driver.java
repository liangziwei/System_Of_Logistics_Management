package driver.ui_driver.transitionUI_driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import businessLogicService.transitionBLService.LoadingBLService;
import constant.LoadingType;
import stub.businessLogicImpl_stub.transitionBLImpl_stub.LoadingBLImpl_Stub;
import vo.transitionVO.LoadingVO;

public class LoadingUI_Driver {
	public static void main(String[] args) {
		LoadingBLService loadingBLService=new LoadingBLImpl_Stub();
		boolean go =true;
		Scanner s = new Scanner(System.in);
		while (go) {
			System.out.println("请输入请求:(1)添加装运单（2）修改装运单"
					+ "（3）查询装运单 (4)结束");
			int input = s.nextInt();
			switch(input){
			case 1:List<String> alldeliveryid = new ArrayList<String>();
				alldeliveryid.add("1000221181");
				alldeliveryid.add("1244291091");
				alldeliveryid.add("1827461871");
				boolean add=loadingBLService.addLoadingFormBL(new LoadingVO("017 1010 0007", "北京", LoadingType.PLANE,"139 010 001","茗柯","茗柯",alldeliveryid));
				if(add){
					System.out.println("添加成功");
				}
				else {
					System.out.println("添加失败");
				}
				break;
			case 2:alldeliveryid = new ArrayList<String>();
				alldeliveryid.add("1000221181");
				alldeliveryid.add("1244291091");
				alldeliveryid.add("1827461871");
				boolean modify=loadingBLService.modifyLoadingFormBL(new LoadingVO("017 1010 0007", "北京", LoadingType.TRAIN,"139 010 001","茗柯","茗柯",alldeliveryid));
				if(modify){
					System.out.println("修改成功");
				}
				else {
					System.out.println("修改失败");
				}			
				break;
			case 3:LoadingVO loadingVO = loadingBLService.findLoadingFormBL("139 010 001");
				System.out.println("装运编号"+loadingVO.getloadingid()+"\n"+"到达地"+loadingVO.getarrivalid()+"\n"+
						"装运方式"+loadingVO.getway()+"\n"+"车辆（或火车或飞机）代号"+loadingVO.getwayid()+"\n"+
						"监装员"+loadingVO.getsupervisionid()+"\n"+"押运员"+loadingVO.getsupercargoid()+"\n"+
						"本次装箱所有货物的订单条形码号"+loadingVO.getalldeliveryid()+"运费"+loadingVO.getfare());
				break;
			case 4:go = false;
				break;
			}
		}
	}
}
