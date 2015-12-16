package delivery_test;

import static org.junit.Assert.*;

import org.junit.Test;

import businessLogic.businessLogicController.deliveryController.OrderController;
import businessLogicService.deliveryBLService.OrderBLService;
import vo.deliveryVO.OrderVO;

/**
 *测试根据订单条形码号查询订单的需求 
 */
public class FindOrderTest {

	@Test
	public void test() {
		OrderBLService order = new OrderController();
		OrderVO vo = order.getOrderInfoById("1234561230");
		//测试订单条形码号、送件人姓名、收件人姓名和货物名称是否与预期一致
		//如果一致，认为所查找的订单与预期查找的订单一致
		assertEquals("1234561230", vo.getGoodsInfo().getId());
		assertEquals("张三", vo.getSenderInfo().getName());
		assertEquals("李四", vo.getReceiverInfo().getName());
		assertEquals("衣服", vo.getGoodsInfo().getName());
	}

}
