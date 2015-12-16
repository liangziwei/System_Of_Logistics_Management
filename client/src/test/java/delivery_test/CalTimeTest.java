package delivery_test;

import static org.junit.Assert.*;

import org.junit.Test;

import businessLogic.businessLogicController.deliveryController.OrderController;
import businessLogicService.deliveryBLService.OrderBLService;
import constant.City;

/**
 * 测试计算快递到达时间的需求
 */
public class CalTimeTest {

	@Test
	public void test() {
		OrderBLService order = new OrderController();
		
		//南京-上海
		int t1 = order.calculateTime(City.NAN_JING, City.SHANG_HAI);
		assertEquals(2, t1);
		//北京-广州
		int t2 = order.calculateTime(City.BEI_JING, City.GUANG_ZHOU);
		assertEquals(0, t2);
		//本地
		int t3 = order.calculateTime(City.GUANG_ZHOU, City.GUANG_ZHOU);
		assertEquals(0, t3);
	}

}
