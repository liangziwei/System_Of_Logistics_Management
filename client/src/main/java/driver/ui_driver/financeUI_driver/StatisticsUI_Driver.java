package driver.ui_driver.financeUI_driver;

import java.util.Scanner;

import businessLogicService.financeBLService.StatisticsBLSevice;
import stub.businessLogicImpl_stub.financeBLImpl_stub.StatisticsBLImpl_Stub;

public class StatisticsUI_Driver {
	public static void main(String[] args) {
		StatisticsBLSevice statistics = new StatisticsBLImpl_Stub();
		boolean go = true;
		Scanner s = new Scanner(System.in);
		while(go){
			System.out.println("请输入请求:(1)查看成本收益表（2）查看经营情况表（3）退出"); 
			int input = s.nextInt();
			switch(input) {
			case 1:
//				System.out.println(statistics.getCostBenefit().getTotalIncome()+" "
//						+statistics.getCostBenefit().getTotalPayment()+" "
//						+statistics.getCostBenefit().getTotalProfit());
				break;
			case 2:
				String startDate = "2015-02-11";
				String endDate = "2015-02-13";
				for(int i=0;i<statistics.getReceivableList(startDate, endDate).size();i++){
					System.out.println(statistics.getReceivableList(startDate, endDate).get(i).getDate()+" "
							+statistics.getReceivableList(startDate, endDate).get(i).getMoney()+" "
							+statistics.getReceivableList(startDate, endDate).get(i).getCourier()+" "
							+statistics.getReceivableList(startDate, endDate).get(i).getDeliveryid());
				}
				break;
			case 3:
				go = false;
				break;
			}
			
		}
		s.close();
	}
}
