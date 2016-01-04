package delivery_test;

import static org.junit.Assert.*;

import org.junit.Test;

import businessLogic.businessLogicController.deliveryController.OrderController;
import businessLogicService.deliveryBLService.OrderBLService;
import constant.City;
import constant.DeliveryType;

/**
 *测试计算订单运费的 需求
 */
public class CalPriceTest {

	@Test
	public void test() {
		OrderBLService order = new OrderController();
		
		//经济快递，南京-北京
		double p1 = order.calculatePrice(DeliveryType.ECONOMIC, 10, City.NAN_JING, City.BEI_JING);
		assertEquals(162.0, p1, 3);
		//特快，本地
		double p2 = order.calculatePrice(DeliveryType.FAST, 2, City.NAN_JING, City.NAN_JING);
		assertEquals(1.5, p2, 3);
		//普通快递，上海-广州
		double p3 = order.calculatePrice(DeliveryType.NORMAL, 3, City.SHANG_HAI, City.GUANG_ZHOU);
		assertEquals(83.697, p3, 3);
//		//溢出
//		double p4 = order.calculatePrice(DeliveryType.NORMAL, Double.MAX_VALUE, City.GUANG_ZHOU, City.BEI_JING);
//		assertEquals(new Double(p4).toString(), "Infinity");
	}

}
