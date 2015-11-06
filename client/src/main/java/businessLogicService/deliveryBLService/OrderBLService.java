package businessLogicService.deliveryBLService;

import constant.City;
import constant.DeliveryType;
import vo.deliveryVO.OrderVO;
import vo.deliveryVO.VerifyMessage;

/**
 * description:业务逻辑层为订单信息界面提供的服务
 * @author 肖安祥
 */
public interface OrderBLService {
	
	/**
	 * description:通过订单条形码号得到相应的订单信息
	 * 前置条件：用户输入有效的订单条形码号
	 * 后置条件：根据订单条形码号查找相应订单信息，返回给界面显示
	 * 需接口：OrderDataService.getOrderInfoById(String id)（根据订单条形码号查询订单信息）
	 * @param id ,订单条形码号（10位数字）
	 * @return OrderVO, 返回订单信息的值对象，具体参照OrdeVO的定义
	 */
	public OrderVO getOrderInfoById(String id);
	
	
	/**
	 * description:将订单信息保存
	 * 前置条件：界面传递一个不为null的orderVO，里面记录了订单的信息
	 * 后置条件：将订单信息进行存储
	 * 需接口：OrderDataService.saveOrderInfo(OrderPO orderPO)（将订单信息进行存储）
	 * @param orderVO,记录订单信息的值对象，具体参照OrderVO的定义
	 * @return boolean,通知方法调用者是否保存成功
	 */
	public boolean saveOrderInfo(OrderVO orderVO);
	
	/**
	 * description:计算快递的预估时间
	 * 前置条件：界面传递快递的出发地和目的地
	 * 后置条件：计算快递所需要的时间
	 * 需接口：OrderDataService.getTimeRecords(City source, City destination)
	 *        （返回快递运送时间的历史记录，根据历史记录估算时间）
	 * @param source 快递的出发地名称
	 * @param destination 快递的目的地名称
	 * @return int, 返回时间值（天）
	 */
	public int calculateTime(City source, City destination);
	
	/**
	 * description:计算快递的预估费用
	 * 前置条件：界面传递快递的快递类型，重量，出发地，目的地
	 * 后置条件：计算快递所需要的价格
	 * 需接口：无
	 * @param type 快递的类型（经济快递、普通快递、特快）
	 * @param weight 物品的重量
	 * @param source 快递的出发地名称
	 * @param destination 快递的目的地名称
	 * @return double, 返回价格（元）
	 */
	public double calculatePrice(DeliveryType type, double weight, City source, City destination);
	
	/**
	 * description:验证用户在界面的输入是否符合规范
	 * 前置条件：用户确认订单输入
	 * 后置条件：给用户的输入返回反馈信息
	 * 需接口：无
	 * @param orderVO 用户输入的值对象
	 * @return VerifyMessage, 返回验证结果以及修改意见
	 */
	public VerifyMessage verifyOrderInfo(OrderVO orderVO);
	
}
