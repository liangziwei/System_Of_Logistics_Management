package driver.ui_driver.transitionUI_driver;

import java.util.Scanner;

import businessLogicService.transitionBLService.LoadingBLService;
import businessLogicService.transitionBLService.ReceivingBLService;
import constant.CargoState;
import po.transitionPO.ReceivingPO;
import stub.businessLogicImpl_stub.transitionBLImpl_stub.LoadingBLImpl_Stub;
import stub.businessLogicImpl_stub.transitionBLImpl_stub.ReceivingBLImpl_Stub;
import vo.transitionVO.ReceivingVO;

public class ReceivingUI_Driver {
	public static void main(String[] args) {
		ReceivingBLService receivingBLService= new ReceivingBLImpl_Stub();
		LoadingBLService loadingBLService=new LoadingBLImpl_Stub();
		boolean go =true;
		Scanner s = new Scanner(System.in);
		while (go) {
			System.out.println("请输入请求:(1)添加接收单（2）修改接收单"
					+ "（3）查询接收单 (4)结束");
			int input = s.nextInt();
			switch(input){
			case 1:boolean add=receivingBLService.addReceivingFormBL
					(new ReceivingVO("0025 010","2015-10-8", "20151008000017","北京","南京",CargoState.INTACT));
			if(add){
				System.out.println("添加成功");
			}
			else {
				System.out.println("添加失败");
			}
			break;
			case 2:boolean modify =receivingBLService.modifyReceivingFormBL
					(new ReceivingVO("0025 010","2015-10-12", "20151008111017","北京","南京",CargoState.DAMAGE));
			if(modify){
				System.out.println("修改成功");
			}
			else {
				System.out.println("修改失败");
			}	
			break;
			case 3:ReceivingVO receivingVO=receivingBLService.findReceivingformBL("20151008000017");
			System.out.println("中转中心编号"+receivingVO.gettransitionid()+"\n"+"到达日期"+receivingVO.getarrivaldate()+"\n"+
					"中转单编号"+receivingVO.gettransferringid()+"\n"+"出发地"+receivingVO.getdepartureid()+"\n"+
					"目的地"+receivingVO.getarrivalid()+"\n"+"货物到达状态"+receivingVO.getstate());
			break;
			case 4:go = false;
			break;
			
			}

		}
	}
}
