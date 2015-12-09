package mock.test;

//import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


import vo.businessVO.ReceivableVO;
import vo.financeVO.CostBenefitVO;
import businessLogic.businessLogicController.financeController.StatisticsController;

public class StatisticsTest {

//	@Test
//	public void test() {
//		StatisticsController statistics = new StatisticsController();
//				
//		List<ReceivableVO> ReceivableList = statistics.getReceivableList("2015-02-11", "2015-02-13");
//		CostBenefitVO costBenefit = statistics.getCostBenefit("1", "2");
//		CostBenefitVO costbenefit = new CostBenefitVO(1000.0, 500.0, 500.0);
//		List<ReceivableVO> receivable = new ArrayList<ReceivableVO>();
//		ArrayList<String> deliveryid1 = new ArrayList<String>();
//		ArrayList<String> deliveryid2 = new ArrayList<String>();
//		ArrayList<String> deliveryid3 = new ArrayList<String>();
//		deliveryid1.add("1234567890");
//		deliveryid1.add("1245678952");
//		deliveryid2.add("1245678552");
//		deliveryid2.add("1245453122");
//		deliveryid2.add("1245678212");
//		deliveryid3.add("1245655542");
//		deliveryid3.add("1245658952");
//		deliveryid3.add("1245675152");
////		receivable.add(new ReceivableVO("2015-02-11",100.0,"小红",deliveryid1));
////		receivable.add(new ReceivableVO("2015-02-12",120.0,"小李",deliveryid2));
////		receivable.add(new ReceivableVO("2015-02-13",145.0,"小王",deliveryid3));
//		
//		assertEquals(receivable.size(), ReceivableList.size());
//		for(int i=0;i<receivable.size();i++){
//			assertEquals(receivable.get(i).getCourier(), ReceivableList.get(i).getCourier());
//			assertEquals(receivable.get(i).getDate(), ReceivableList.get(i).getDate());
//			assertEquals(receivable.get(i).getDeliveryid(), ReceivableList.get(i).getDeliveryid());
//			assertEquals(receivable.get(i).getMoney(), ReceivableList.get(i).getMoney(),0.01);
//		}
//		
//		assertEquals(costbenefit.getTotalIncome(), costBenefit.getTotalIncome(),0.01);
//		assertEquals(costbenefit.getTotalPayment(), costBenefit.getTotalPayment(),0.01);
//		assertEquals(costbenefit.getTotalProfit(), costBenefit.getTotalProfit(),0.01);
//		
//	}

}
