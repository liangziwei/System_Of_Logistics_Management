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
import po.deliveryPO.OrderPO;
import po.deliveryPO.ReceiptPO;
import stub.dataImpl_stub.deliveryDataImpl_stub.OrderDataImpl_Stub;
import stub.dataImpl_stub.deliveryDataImpl_stub.ReceiptDataImpl_Stub;
import vo.deliveryVO.ReceiptVO;
import vo.deliveryVO.VerifyMessage;

/**
 * description:为收件信息界面提供服务的具体实现
 * @author 肖安祥
 */
public class ReceiptModel{
	
	private ReceiptDataService receipt = new ReceiptDataImpl_Stub();
	
	private OrderDataService order = new OrderDataImpl_Stub();

	public boolean saveReceiptInfo(ReceiptVO receiptVO) {
		return this.receipt.saveReceiptInfo(ReceiptPO.ReceiptVOToPO(receiptVO));
	}

	public boolean updateTimeRecord(String arriveTime, String id) {
		OrderPO orderPO = null;
		try {
			orderPO = this.order.getOrderInfoById(id);			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		//获得订单信息中的快递的起始地和目的地，以及出发时间
		City source = orderPO.getSenderInfo().getCity();
		City destination = orderPO.getReceiverInfo().getCity();
		String startTime = orderPO.getGoodsInfo().getDate();
		
		//计算快递所用时间
		int day = this.calculateDays(startTime, arriveTime);
		System.out.println(startTime);
		System.out.println(arriveTime);
		System.out.println(day);
		this.receipt.updateTimeRecord(day, source, destination);
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
		VerifyMessage msg = new VerifyMessage();
		String name = receiptVO.getName();
		String id = receiptVO.getOrderID();
		//验证姓名
		if(CommonLogic.isNull(name)) {
			msg.setResult(VerifyResult.FAIL);
			msg.setErrorMsg("姓名不能为空");
			msg.setLabel(LabelName.RECEIVER_NAME);
		}
		else if(CommonLogic.isNull(id)) {
			msg.setResult(VerifyResult.FAIL);
			msg.setErrorMsg("订单条形码号不能为空");
			msg.setLabel(LabelName.GOODS_ID);
		}
		else if(id.length() != 10 || !CommonLogic.isNumber(id)) {
			msg.setResult(VerifyResult.FAIL);
			msg.setErrorMsg("订单条形码号应该为10位数字");
			msg.setLabel(LabelName.GOODS_ID);
		}
		else {
			msg.setResult(VerifyResult.SUCCESS);
		}
		return msg;
	}
}
