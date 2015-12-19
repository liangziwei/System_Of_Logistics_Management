package businessLogic.businessLogicModel.deliveryModel;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import businessLogic.businessLogicModel.util.CommonLogic;
import constant.City;
import constant.LabelName;
import constant.VerifyResult;
import dataService.deliveryDataService.OrderDataService;
import dataService.deliveryDataService.ReceiptDataService;
import network.RMI;
import po.deliveryPO.OrderPO;
import po.deliveryPO.ReceiptPO;
import vo.deliveryVO.ReceiptVO;
import vo.deliveryVO.VerifyMessage;

/**
 * description:为收件信息界面提供服务的具体实现
 * @author 肖安祥
 */
public class ReceiptModel{
	
	private ReceiptDataService receipt = RMI.<ReceiptDataService>getDataService("receipt");
	
	private OrderDataService order = RMI.<OrderDataService>getDataService("order");

	public boolean saveReceiptInfo(ReceiptVO receiptVO) {
		try {
			return this.receipt.saveReceiptInfo(ReceiptPO.ReceiptVOToPO(receiptVO));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateTimeRecord(String name, String arriveTime, String id) {
		OrderPO orderPO = null;
		try {
			orderPO = this.order.getOrderInfoById(id);			
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		//验证收件人姓名是否和订单收件人姓名一致
		if(!name.equals(orderPO.getReceiverInfo().getName())) {
			return false;
		}
		//获得订单信息中的快递的起始地和目的地，以及出发时间
		City source = orderPO.getSenderInfo().getCity();
		City destination = orderPO.getReceiverInfo().getCity();
		String startTime = orderPO.getGoodsInfo().getDate();
		
		//计算快递所用时间
		int day = this.calculateDays(startTime, arriveTime);
		try {
			this.receipt.updateTimeRecord(day, source, destination);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	private int calculateDays(String startTime, String arriveTime) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		long start = 0;
		long end = 0;
		try {
			calendar.setTime(format.parse(startTime));
			start = calendar.getTimeInMillis();
			calendar.setTime(format.parse(arriveTime));
			end = calendar.getTimeInMillis();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return end - start > 0 ? (int) ((end - start) / (1000 * 3600 * 24)) : 1;
	}
	
	public static VerifyMessage verifyReceiptInfo(ReceiptVO receiptVO) {
		String name = receiptVO.getName();
		String id = receiptVO.getOrderID();
		
		if(CommonLogic.isNull(name)) {
			return new VerifyMessage(LabelName.RECEIVER_NAME, "姓名不能为空", VerifyResult.FAIL);
		}
		if(CommonLogic.isNull(id)) {
			return new VerifyMessage(LabelName.GOODS_ID, "订单条形码号不能为空", VerifyResult.FAIL);
		}
		if(id.length() != 10 || !CommonLogic.isNumber(id)) {
			return new VerifyMessage(LabelName.GOODS_ID, "订单条形码号应该为10位数字", VerifyResult.FAIL);
		}
		OrderDataService order = RMI.getDataService("order");
		try {
			OrderPO po = order.getOrderInfoById(id);
			if(po == null) return new VerifyMessage(LabelName.GOODS_ID, "该订单不存在", VerifyResult.FAIL);
			if(!po.getReceiverInfo().getName().equals(name)) {
				return new VerifyMessage(LabelName.RECEIVER_NAME, 
						"该订单信息对应的姓名为:" + po.getReceiverInfo().getName(), VerifyResult.FAIL);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return new VerifyMessage(null, null, VerifyResult.SUCCESS);
	}
}
