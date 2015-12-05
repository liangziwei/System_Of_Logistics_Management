package driver.ui_driver.financeUI_driver;

import java.util.Scanner;

import stub.businessLogicImpl_stub.financeBLImpl_stub.AccountBLImpl_Stub;
import vo.financeVO.AccountVO;
import businessLogicService.financeBLService.AccountBLService;

public class AccountUI_Driver {
	public static void main(String[] args) {
		AccountBLService account =new AccountBLImpl_Stub();
		boolean go=true;
		Scanner s = new Scanner(System.in);
		while(go) {
			System.out.println("请输入请求：（1）添加账户（2）删除账户（3）修改账户（4）查询账户（5）退出");
			int input = s.nextInt();
			switch(input) {
			case 1:
				System.out.println("添加是否成功："+account.addAccount(new AccountVO(null,0.0)));
				break;
			case 2:
				System.out.println("删除是否成功："+account.deleteAccount(null));
				break;
			case 3:
//				System.out.println("修改是否成功："+account.modifyAccount(null));
				break;
			case 4:
//				System.out.println("输入关键字（账户名称）进行查询：");
//				Scanner a = new Scanner(System.in);
				String str = "南京大学";
//				a.close();
				System.out.println("账户信息："+"\n"+"账户名称："+account.findAccount(str).getName()
						+"账户余额："+account.findAccount(str).getBalance());
				break;
			case 5:
				go = false;
				break;
			}
		}
		s.close();
	}
}
