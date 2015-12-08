package mock.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import businessLogic.businessLogicController.financeController.SettlementController;
import vo.businessVO.ReceivableVO;

public class SettlementTest {

	@Test
	public void test() {
		SettlementController settlement = new SettlementController();
		List<ReceivableVO> receilist =settlement.showReceiList("2015-12-31");
		List<ReceivableVO> businessrecei = settlement.showBusinessRecei("023", "2015-12-31");
		List<ReceivableVO> receivable = new ArrayList<ReceivableVO>();
		ArrayList<String> deliveryid1 = new ArrayList<String>();
		ArrayList<String> deliveryid2 = new ArrayList<String>();
		ArrayList<String> deliveryid3 = new ArrayList<String>();
		deliveryid1.add("1234567890");
		deliveryid1.add("1245678952");
		deliveryid2.add("1245678552");
		deliveryid2.add("1245453122");
		deliveryid2.add("1245678212");
		deliveryid3.add("1245655542");
		deliveryid3.add("1245658952");
		deliveryid3.add("1245675152");
//		receivable.add(new ReceivableVO("2015-02-11",100.0,"小红",deliveryid1));
//		receivable.add(new ReceivableVO("2015-02-11",120.0,"小李",deliveryid2));
//		receivable.add(new ReceivableVO("2015-02-11",145.0,"小王",deliveryid3));
		List<ReceivableVO> businessrec = new ArrayList<ReceivableVO>();
		ArrayList<String> delivery1 = new ArrayList<String>();
		ArrayList<String> delivery2 = new ArrayList<String>();
		ArrayList<String> delivery3 = new ArrayList<String>();
		delivery1.add("1234567890");
		delivery1.add("1245678952");
		delivery2.add("1245678552");
		delivery2.add("1245451122");
		delivery2.add("1245675212");
		delivery3.add("1245696542");
		delivery3.add("1245651952");
		delivery3.add("1245675452");
//		businessrec.add(new ReceivableVO("2015-02-11",100.0,"小红",delivery1));
//		businessrec.add(new ReceivableVO("2015-02-11",120.0,"小李",delivery2));
//		businessrec.add(new ReceivableVO("2015-02-11",145.0,"小王",delivery3));
		
		
		assertEquals(receivable.size(), receilist.size());
		assertEquals(businessrec.size(), businessrecei.size());
		
		for(int i=0;i<receivable.size();i++){
			assertEquals(receivable.get(i).getCourier(), receilist.get(i).getCourier());
			assertEquals(businessrec.get(i).getCourier(),businessrecei.get(i).getCourier());
			assertEquals(receivable.get(i).getDate(), receilist.get(i).getDate());
			assertEquals(businessrec.get(i).getDate(),businessrecei.get(i).getDate());
			assertEquals(receivable.get(i).getDeliveryid(), receilist.get(i).getDeliveryid());
			assertEquals(businessrec.get(i).getDeliveryid(),businessrecei.get(i).getDeliveryid());
			assertEquals(receivable.get(i).getMoney(), receilist.get(i).getMoney(), 0.01);
			assertEquals(businessrec.get(i).getMoney(),businessrecei.get(i).getMoney(),0.01);
			}
	}

}
