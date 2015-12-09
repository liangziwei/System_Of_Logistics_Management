package mock.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import vo.businessVO.ReceivableVO;
import vo.financeVO.CostBenefitVO;
import businessLogic.businessLogicController.financeController.StatisticsController;

public class ExcelTest {

	@Test
	public void test() {
		StatisticsController statCon=new StatisticsController();
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
		receivable.add(new ReceivableVO("2015-02-11",100.0,"小红",deliveryid1,"02500001"));
		receivable.add(new ReceivableVO("2015-02-12",120.0,"小李",deliveryid2,"02500002"));
		receivable.add(new ReceivableVO("2015-02-13",145.0,"小王",deliveryid3,"02500003"));
		statCon.outExcel(receivable);
	}

}
