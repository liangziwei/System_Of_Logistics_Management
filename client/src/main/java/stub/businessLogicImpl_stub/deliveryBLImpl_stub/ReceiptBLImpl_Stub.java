package stub.businessLogicImpl_stub.deliveryBLImpl_stub;

import java.rmi.RemoteException;

import businessLogicService.deliveryBLService.ReceiptBLService;
import constant.City;
import dataService.deliveryDataService.ReceiptDataService;
import po.deliveryPO.ReceiptPO;
import stub.dataImpl_stub.deliveryDataImpl_stub.ReceiptDataImpl_Stub;
import vo.deliveryVO.ReceiptVO;
import vo.deliveryVO.VerifyMessage;

public class ReceiptBLImpl_Stub implements ReceiptBLService{

	private ReceiptDataService receipt = new ReceiptDataImpl_Stub();
	
	public boolean saveReceiptInfo(ReceiptVO receiptVO) {
		try {
			return this.receipt.saveReceiptInfo(this.receiptVOToReceiptPO(receiptVO));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateTimeRecord(String name, String arriveTime, String id) {
		try {
			return this.receipt.updateTimeRecord(2, City.BEI_JING, City.GUANG_ZHOU);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	private ReceiptPO receiptVOToReceiptPO(ReceiptVO receiptVO) {
		return new ReceiptPO(receiptVO.getOrderID(), receiptVO.getName(), receiptVO.getDate());
	}

	public VerifyMessage verifyReceiptInfo(ReceiptVO receiptVO) {
		// TODO Auto-generated method stub
		return null;
	}
}
