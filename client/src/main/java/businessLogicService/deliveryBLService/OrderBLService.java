package businessLogicService.deliveryBLService;

import vo.deliveryVO.OrderVO;

/**
 * description:业务逻辑层为订单信息界面提供的服务
 * @author 肖安祥
 * */
public interface OrderBLService {
	
	/**
	 * description:通过订单条形码号得到相应的订单信息
	 * @param id ,订单条形码号（10位数字）
	 * @return OrderVO, 返回订单信息的值对象，具体参照OrdeVO的定义
	 * */
	public OrderVO getOrderInfoById(String id);
	
	
	/**
	 * description:将订单信息保存
	 * @param orderVO,记录订单信息的值对象，具体参照OrderVO的定义
	 * @return boolean,通知方法调用者是否保存成功
	 * */
	public boolean saveOrderInfo(OrderVO orderVO);
	
	/**
	 * description:计算快递的预估时间
	 * @param source 快递的出发地名称
	 * @param destination 快递的目的地名称
	 * @return int, 返回时间值（天）
	 * */
	public int calculateTime(String source, String destination);
	
	/**
	 * description:计算快递的预估费用
	 * @param type 快递的类型（经济快递、普通快递、特快）
	 * @param weight 物品的重量
	 * @param source 快递的出发地名称
	 * @param destination 快递的目的地名称
	 * @return double, 返回价格（元）
	 * */
	public double calculatePrice(int type, double weight, String source, String destination);
	
}
