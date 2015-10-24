package stub.businessLogicImpl_stub.deliveryBLImpl_stub;

import businessLogicService.deliveryBLService.ReceiptBLService;
import constant.City;
import dataService.deliveryDataService.ReceiptDataService;
import po.deliveryPO.ReceiptPO;
import stub.dataImpl_stub.deliveryDataImpl_stub.ReceiptDataImpl_Stub;
import vo.deliveryVO.ReceiptVO;

public class ReceiptBLImpl_Stub implements ReceiptBLService{

	private ReceiptDataService receipt = new ReceiptDataImpl_Stub();
	
	public boolean saveReceiptInfo(ReceiptVO receiptVO) {
		return this.receipt.saveReceiptInfo(this.receiptVOToReceiptPO(receiptVO));
	}

	public boolean updateTimeRecord(String arriveTime, String id) {
		return this.receipt.updateTimeRecord(2, City.BEI_JING, City.GUANG_ZHOU);
	}

	private ReceiptPO receiptVOToReceiptPO(ReceiptVO receiptVO) {
		return new ReceiptPO(receiptVO.getOrderID(), receiptVO.getName(), receiptVO.getDate());
	}
}
