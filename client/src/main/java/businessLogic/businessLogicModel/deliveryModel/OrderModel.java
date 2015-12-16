package businessLogic.businessLogicModel.deliveryModel;

import java.rmi.RemoteException;
import java.util.List;

import businessLogic.businessLogicModel.managerModel.MakeConstant;
import businessLogic.businessLogicModel.util.CommonLogic;
import constant.City;
import constant.DeliveryType;
import constant.LabelName;
import constant.VerifyResult;
import dataService.deliveryDataService.OrderDataService;
import network.RMI;
import po.deliveryPO.ClientInfo;
import po.deliveryPO.GoodsInfo;
import po.deliveryPO.OrderPO;
import po.deliveryPO.TimeRecordPO;
import vo.deliveryVO.OrderVO;
import vo.deliveryVO.VerifyMessage;

/**
 * description:为订单信息界面提供服务的具体实现
 * @author 肖安祥
 */
public class OrderModel{
	
	private  OrderDataService order = RMI.<OrderDataService>getDataService("order");
	
	public OrderVO getOrderInfoById(String id) {
		OrderPO orderInfo = null;
		try {
			orderInfo = order.getOrderInfoById(id);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		if(orderInfo == null) return null;
		return OrderPO.orderPOToVO(orderInfo);
	}

	public boolean saveOrderInfo(OrderVO orderVO) {
		boolean result = false;
		try {
			result = order.saveOrderInfo(OrderPO.orderVOToPO(orderVO));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int calculateTime(City source, City destination) {
		int time = 0;
		List<TimeRecordPO> timeRecords = null;
		try {
			 timeRecords = order.getTimeRecords(source, destination);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < timeRecords.size(); i++) {
			time += timeRecords.get(i).getTime();
		}
		return timeRecords.size() == 0 ? 0 : time / timeRecords.size();
	}

	public static double calculatePrice(DeliveryType type, double weight, City source, City destination) {
		//获得城市距离
		MakeConstant constant = new MakeConstant();
		double distance = constant.getDistance(source, destination);
		//计算价格(标准快递的运费价格=公里数/1000*23元每公斤)
		double price = DeliveryPriceTable.calculatePrice(type, distance, weight);
		
		return price;
	}	
	
	public static VerifyMessage verifyOrderId(String id) {
		VerifyMessage msg = new VerifyMessage();
		if(CommonLogic.isNull(id)) {
			msg.setResult(VerifyResult.FAIL);
			msg.setErrorMsg("输入不能为空");
		}
		else if(id.length() != 10 || !CommonLogic.isNumber(id)) {
			msg.setResult(VerifyResult.FAIL);
			msg.setErrorMsg("输入应该为10位数字");
		}
		else {
			msg.setResult(VerifyResult.SUCCESS);
		}
		return msg;
	}
	
	public static VerifyMessage verifyOrderInfo(OrderVO orderVO) {
		VerifyMessage msg = null;
		//检验寄件人信息
		ClientInfo sender = orderVO.getSenderInfo();
		msg = verifySender(sender);
		if(msg.getResult() == VerifyResult.FAIL) return msg;
		//检验收件人信息
		ClientInfo receiver = orderVO.getReceiverInfo();
		msg = verifyReceiver(receiver);
		if(msg.getResult() == VerifyResult.FAIL) return msg;
		//检验物品信息
		GoodsInfo goods = orderVO.getGoodsInfo();
		msg = verifyGoodsInfo(goods);
		return msg;
		
	}
	
	private static VerifyMessage verifySender(ClientInfo sender) {
		if(CommonLogic.isNull(sender.getName())) //姓名
			return new VerifyMessage(LabelName.SENDER_NAME, "寄件人姓名不能为空", VerifyResult.FAIL);
		if(CommonLogic.isNull(sender.getAddress())) //地址
			return new VerifyMessage(LabelName.SENDER_ADDR, "寄件人地址不能为空", VerifyResult.FAIL);
		if(sender.getMobileNumber().length() != 11 || !CommonLogic.isNumber(sender.getMobileNumber())) //手机
			return new VerifyMessage(LabelName.SENDER_MOBILE, "寄件人手机应该为11位数字", VerifyResult.FAIL);
		return new VerifyMessage(null, null, VerifyResult.SUCCESS);
	}
	
	private static VerifyMessage verifyReceiver(ClientInfo receiver) {
		if(CommonLogic.isNull(receiver.getName())) //姓名
			return new VerifyMessage(LabelName.RECEIVER_NAME, "收件人姓名不能为空", VerifyResult.FAIL);
		if(CommonLogic.isNull(receiver.getAddress())) //地址
			return new VerifyMessage(LabelName.RECEIVER_ADDR, "收件人地址不能为空", VerifyResult.FAIL);
		if(receiver.getMobileNumber().length() != 11 || !CommonLogic.isNumber(receiver.getMobileNumber())) //手机
			return new VerifyMessage(LabelName.RECEIVER_MOBILE, "收件人手机应该为11位数字", VerifyResult.FAIL);
		return new VerifyMessage(null, null, VerifyResult.SUCCESS);
	}
	
	private static VerifyMessage verifyGoodsInfo(GoodsInfo goods) {
		if(!CommonLogic.isNumber(goods.getNumber()))//原件数
			return new VerifyMessage(LabelName.GOODS_NUM, "原件数应该为数字", VerifyResult.FAIL);
		if(!CommonLogic.isDouble(goods.getWeight()))//重量
			return new VerifyMessage(LabelName.GOODS_WEIGHT, "物品重量应该为数字", VerifyResult.FAIL);
		if(Double.parseDouble(goods.getWeight()) <= 0)
			return new VerifyMessage(LabelName.GOODS_WEIGHT, "物品重量应该为正数", VerifyResult.FAIL);
		if(!CommonLogic.isDouble(goods.getSize()))//体积
			return new VerifyMessage(LabelName.GOODS_VOLUMN, "物品体积应该为数字", VerifyResult.FAIL);
		if(CommonLogic.isNull(goods.getName()))//名称
			return new VerifyMessage(LabelName.GOODS_NAME, "物品名称不能为空", VerifyResult.FAIL);
		if(goods.getId().length() != 10 || !CommonLogic.isNumber(goods.getId()))//订单条形码号
			return new VerifyMessage(LabelName.GOODS_ID, "订单条形码号应该为10位数字", VerifyResult.FAIL);
		return new VerifyMessage(null, null, VerifyResult.SUCCESS);
	}
}