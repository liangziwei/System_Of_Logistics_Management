package driver.ui_driver.repositoryUI_driver;

import java.util.Scanner;

import businessLogicService.repositoryBLService.InRepositoryBLService;
import constant.AreaCodeType;
import po.repositoryPO.InRepositoryPO;
import stub.businessLogicImpl_stub.repositoryBLImpl_stub.InRepositoryBLImpl_Stub;
import vo.repositoryVO.InRepositoryVO;

public class InRepositoryUI_Driver {
	public static void main(String[] args) {
		InRepositoryBLService inRepositoryBLService=new InRepositoryBLImpl_Stub();
		boolean go =true;
		Scanner s = new Scanner(System.in);
		while (go) {
			System.out.println("请输入请求:(1)添加入库单（2）修改入库单"
					+ "（3）查询入库单 (4)结束");
			int input = s.nextInt();
			switch(input){
			case 1:String add = inRepositoryBLService.addInRepositoryFormBL(new InRepositoryVO("1110101023","2015-10-13", "北京",AreaCodeType.PLANEAREA,"004","012","042",""));
			if(add.equals("ture")){
				System.out.println("添加成功，不报警");
			}
			else if(add.equals("ture.warn")){
				System.out.println("添加成功，报警");
			}
			else if(add.equals("false")){
				System.out.println("添加失败");
			}
			break;
			case 2:String modify = inRepositoryBLService.modifyInRepositoryFormBL(new InRepositoryVO("1110101023","2015-10-13", "北京",AreaCodeType.PLANEAREA,"004","012","042",""));
			if(modify.equals("ture")){
				System.out.println("修改成功，不报警");
			}
			else if(modify.equals("ture.warn")){
				System.out.println("修改成功，报警");
			}
			else if(modify.equals("false")){
				System.out.println("修改失败");
			}
			break;
			case 3:InRepositoryVO inRepositoryVO =inRepositoryBLService.findInRepositoryFormBL("1110101023");
			System.out.println("快递编号"+inRepositoryVO.getdeliveryid()+"\n"+"入库日期"+inRepositoryVO.getinrepositorydate()+"\n"
					+"目的地"+inRepositoryVO.getarrivalid()+"\n"+"区号"+inRepositoryVO.getareaCode()+"\n"+
					"排号"+inRepositoryVO.getrowid()+"\n"+"架号"+inRepositoryVO.getshelfid()+"\n"+
					"位号"+inRepositoryVO.getposid());
			break;
			case 4:go = false;
			break;
				
			
			}
		}
	}
}
