package driver.ui_driver.managerUI_driver;

import java.util.Scanner;

import constant.City;
import constant.TransitType;
import stub.businessLogicImpl_stub.managerBLImpl_stub.MakeConstantBLImpl_Stub;
import vo.financeVO.AccountVO;
import businessLogicService.managerBLService.MakeConstantBLService;

public class MakeConstantUI_Driver {
	public static void main(String[] args) {
		MakeConstantBLService makeConstant = new MakeConstantBLImpl_Stub();
		boolean go=true;
		Scanner s = new Scanner(System.in);
		while(go) {
			System.out.println("请输入请求：（1）制定城市距离（2）制定价格常量（3）退出");
			int input = s.nextInt();
			switch(input) {
			case 1:
				System.out.println("制定城市距离是否成功："	+
						makeConstant.setDistance(1000.0, City.BEI_JING, City.GUANG_ZHOU));
				break;
			case 2:
				System.out.println("制定价格常量是否成功："	+
						makeConstant.setPrice(25.0, TransitType.RAILWAY));
				break;
			case 3:
				go = false;
				break;
			}
		}
		s.close();
	}
}
