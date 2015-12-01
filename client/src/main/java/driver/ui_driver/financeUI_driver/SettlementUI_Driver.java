package driver.ui_driver.financeUI_driver;

import java.util.Scanner;

import stub.businessLogicImpl_stub.financeBLImpl_stub.SettlementBLImpl_Stub;
import businessLogicService.financeBLService.SettlementBLService;

public class SettlementUI_Driver {
	public static void main(String[] args) {
		SettlementBLService settlement = new SettlementBLImpl_Stub();
		boolean go = true;
		Scanner s = new Scanner(System.in);
		while(go){
			System.out.println("请输入请求:(1)查看当天收款单记录（2）合计当天收款金额"
					+ "（3）查看营业厅收款单记录（4）合计营业厅收款金额（5）退出"); 
			int input = s.nextInt();
			switch(input){
			case 1:
				String date = "2015-02-11";
				for(int i=0;i<settlement.showReceiList(date).size();i++){
					System.out.println(settlement.showReceiList(date).get(i).getDate()+" "
							+settlement.showReceiList(date).get(i).getMoney()+" "
							+settlement.showReceiList(date).get(i).getCourier()+" "
							+settlement.showReceiList(date).get(i).getDeliveryid());
				}
				
				break;
			case 2:
				System.out.println(settlement.calculateSum());
				break;
			case 3:
				String id = "000000002540";
				date = "2015-02-11";
				for(int i=0;i<settlement.showBusinessRecei(id, date).size();i++){
					System.out.println(settlement.showBusinessRecei(id, date).get(i).getDate()+" "
							+settlement.showBusinessRecei(id, date).get(i).getMoney()+" "
							+settlement.showBusinessRecei(id, date).get(i).getCourier()+" "
							+settlement.showBusinessRecei(id, date).get(i).getDeliveryid());
				}
				break;
			case 4:
				System.out.println(settlement.calculateSum());
				break;
			case 5:
				go = false;
				break;
			}
		}
		s.close();
	}

}
