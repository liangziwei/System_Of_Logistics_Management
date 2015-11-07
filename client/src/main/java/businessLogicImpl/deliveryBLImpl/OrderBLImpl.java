package businessLogicImpl.deliveryBLImpl;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import businessLogicService.deliveryBLService.OrderBLService;
import constant.City;
import constant.DeliveryType;
import constant.OrderLabelName;
import constant.VerifyResult;
import dataService.deliveryDataService.OrderDataService;
import po.deliveryPO.ClientInfo;
import po.deliveryPO.GoodsInfo;
import po.deliveryPO.OrderPO;
import vo.deliveryVO.OrderVO;
import vo.deliveryVO.VerifyMessage;

/**
 * description:为订单信息界面提供服务的具体实现
 * @author 肖安祥
 */
public class OrderBLImpl implements OrderBLService{
	
	
	
	public OrderVO getOrderInfoById(String id) {
		OrderPO orderInfo = null;
		try {
			Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
			OrderDataService order = (OrderDataService) registry.lookup("order");
			orderInfo = order.getOrderInfoById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.OrderPOToOrderVO(orderInfo);
	}

	public boolean saveOrderInfo(OrderVO orderVO) {
		// TODO Auto-generated method stub
		return false;
	}

	public int calculateTime(City source, City destination) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double calculatePrice(DeliveryType type, double weight, City source, City destination) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private OrderVO OrderPOToOrderVO(OrderPO orderPO) {
		return new OrderVO(orderPO.getSenderInfo(), orderPO.getReceiverInfo(), orderPO.getGoodsInfo());
	}

	public VerifyMessage verifyOrderInfo(OrderVO orderVO) {
		VerifyMessage msg = null;
		//检验寄件人信息
		ClientInfo sender = orderVO.getSenderInfo();
		msg = this.verifySender(sender);
		if(msg.getResult() == VerifyResult.FAIL) return msg;
		//检验收件人信息
		ClientInfo receiver = orderVO.getReceiverInfo();
		msg = this.verifyReceiver(receiver);
		if(msg.getResult() == VerifyResult.FAIL) return msg;
		//检验物品信息
		GoodsInfo goods = orderVO.getGoodsInfo();
		msg = this.verifyGoodsInfo(goods);
		return msg;
		
	}
	
	private VerifyMessage verifySender(ClientInfo sender) {
		if(this.isNull(sender.getName())) //姓名
			return new VerifyMessage(OrderLabelName.SENDER_NAME, "寄件人姓名不能为空", VerifyResult.FAIL);
		if(this.isNull(sender.getAddress())) //地址
			return new VerifyMessage(OrderLabelName.SENDER_ADDR, "寄件人地址不能为空", VerifyResult.FAIL);
		if(sender.getMobileNumber().length() != 11 || !this.isNumber(sender.getMobileNumber())) //手机
			return new VerifyMessage(OrderLabelName.SENDER_MOBILE, "寄件人手机应该为11位数字", VerifyResult.FAIL);
		return new VerifyMessage(null, null, VerifyResult.SUCCESS);
	}
	
	private VerifyMessage verifyReceiver(ClientInfo receiver) {
		if(this.isNull(receiver.getName())) //姓名
			return new VerifyMessage(OrderLabelName.RECEIVER_NAME, "收件人姓名不能为空", VerifyResult.FAIL);
		if(this.isNull(receiver.getAddress())) //地址
			return new VerifyMessage(OrderLabelName.RECEIVER_ADDR, "收件人地址不能为空", VerifyResult.FAIL);
		if(receiver.getMobileNumber().length() != 11 || !this.isNumber(receiver.getMobileNumber())) //手机
			return new VerifyMessage(OrderLabelName.RECEIVER_MOBILE, "收件人手机应该为11位数字", VerifyResult.FAIL);
		return new VerifyMessage(null, null, VerifyResult.SUCCESS);
	}
	
	private VerifyMessage verifyGoodsInfo(GoodsInfo goods) {
		if(!this.isNumber(goods.getNumber()))//原件数
			return new VerifyMessage(OrderLabelName.GOODS_NUM, "原件数应该为数字", VerifyResult.FAIL);
		if(!this.isDouble(goods.getWeight()))//重量
			return new VerifyMessage(OrderLabelName.GOODS_WEIGHT, "物品重量应该为数字", VerifyResult.FAIL);
		if(!this.isDouble(goods.getSize()))//体积
			return new VerifyMessage(OrderLabelName.GOODS_VOLUMN, "物品体积应该为数字", VerifyResult.FAIL);
		if(this.isNull(goods.getName()))//名称
			return new VerifyMessage(OrderLabelName.GOODS_NAME, "物品名称不能为空", VerifyResult.FAIL);
		if(goods.getId().length() != 10 || !this.isNumber(goods.getId()))//订单条形码号
			return new VerifyMessage(OrderLabelName.GOODS_ID, "订单条形码号应该为10位数字", VerifyResult.FAIL);
		return new VerifyMessage(null, null, VerifyResult.SUCCESS);
	}

	private boolean isNull(String s) {
		return s == null || s.equals("");
	}
	
	private boolean isNumber(String s) {
		if(this.isNull(s)) return false;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) > '9' || s.charAt(i) < '0') return false;
		}
		return true;
	}
	
	private boolean isDouble(String s) {
		if(this.isNull(s)) return false;
		try {
			Double.parseDouble(s);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
}
