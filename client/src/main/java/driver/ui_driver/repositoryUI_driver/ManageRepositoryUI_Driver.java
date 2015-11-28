package driver.ui_driver.repositoryUI_driver;

import java.util.List;
import java.util.Scanner;

import businessLogicService.repositoryBLService.ManageRepositoryBLService;
import constant.AreaCodeType;
import stub.businessLogicImpl_stub.repositoryBLImpl_stub.ManageRepositoryBLImpl_Stub;
import vo.repositoryVO.DeliveryInfoVO;
import vo.repositoryVO.RepositoryInfoVO;

public class ManageRepositoryUI_Driver {
	public static void main(String[] args) {
		ManageRepositoryBLService manageRepositoryBLService =new ManageRepositoryBLImpl_Stub();
		boolean go =true;
		Scanner s = new Scanner(System.in);
		while (go) {
			System.out.println("请输入请求:(1)库存查看（2）库存盘点"
					+ "（3设置库存预警 (4)结束");
			int input = s.nextInt();
			switch(input){
			case 1:
				List<RepositoryInfoVO> repositoryInfoVOs = manageRepositoryBLService.SeeRepositoryBL("2015-5-5,2015-5-6");
				int in=0;
				int out=0;
				System.out.println("该段时间内入库单：");
				for(int i=0;i<repositoryInfoVOs.size();i++){
					if(repositoryInfoVOs.get(i).getbeinrepository()){
						in++;
						System.out.println("快递编号"+repositoryInfoVOs.get(i).getdeliveryid()+"\n"
								+"区号"+repositoryInfoVOs.get(i).getareaCode()+"\n"+"排号"+repositoryInfoVOs.get(i).getrowid()
								+"\n"+"架号"+repositoryInfoVOs.get(i).getshelfid()+"\n"+"位号"+repositoryInfoVOs.get(i).getposid());
					}
				}	
				System.out.println("入库单的数量为："+in+"\n");
				System.out.println("该段时间内出库单：");
				for(int i=0;i<repositoryInfoVOs.size();i++){
					if(repositoryInfoVOs.get(i).getbeinrepository()==false){
						out++;
						System.out.println("快递编号"+repositoryInfoVOs.get(i).getdeliveryid()+"\n"
								+"区号"+repositoryInfoVOs.get(i).getareaCode()+"\n"+"排号"+repositoryInfoVOs.get(i).getrowid()
								+"\n"+"架号"+repositoryInfoVOs.get(i).getshelfid()+"\n"+"位号"+repositoryInfoVOs.get(i).getposid());
					}
				}
				System.out.println("出库单的数量为："+out);
				break;
			case 2:List<DeliveryInfoVO> deliveryInfoVOs =manageRepositoryBLService.CheckRepositoryBL();
				for(int i=0;i<deliveryInfoVOs.size();i++){
					System.out.println("快递编号"+deliveryInfoVOs.get(i).getdeliveryid()+"\n"+
							"入库日期"+deliveryInfoVOs.get(i).getinrepositorydate()+"\n"+"目的地"+deliveryInfoVOs.get(i).getarrivalid()+"\n"+
							"区号"+deliveryInfoVOs.get(i).getareaCode()+"\n"+"排号"+deliveryInfoVOs.get(i).getrowid()+"\n"+
							"架号"+deliveryInfoVOs.get(i).getshelfid()+"\n"+"位号"+deliveryInfoVOs.get(i).getposid());
				}

				break;
			case 3:boolean setwarn =manageRepositoryBLService.SetWarnValueBL(AreaCodeType.PLANEAREA, 1000,0.75);
				if(setwarn){
					System.out.println("仓库预警值保存成功");
				}
				break;
			case 4:go = false;
				break;	
			}
		}
	}
}
