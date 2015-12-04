package ui.managerui.approvalformui;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dataService.businessDataService.EntruckingDataService;
import dataService.businessDataService.PaymentDataService;
import dataService.businessDataService.ReceiveAndSendDataService;
import dataService.deliveryDataService.OrderDataService;
import dataService.repositoryDataService.InRepositoryDataService;
import dataService.repositoryDataService.OutRepositoryDataService;
import dataService.transitionDataService.LoadingDataService;
import dataService.transitionDataService.ReceivingDataService;
import dataService.transitionDataService.TransferringDataService;
import network.RMI;
import po.deliveryPO.OrderPO;
import vo.businessVO.ArrivalFormVO;
import vo.businessVO.EntruckingVO;
import vo.businessVO.ReceivableVO;
import vo.businessVO.SendFormVO;
import vo.deliveryVO.OrderVO;
import vo.repositoryVO.InRepositoryVO;
import vo.repositoryVO.OutRepositoryVO;
import vo.transitionVO.LoadingVO;
import vo.transitionVO.ReceivingVO;
import vo.transitionVO.TransferringVO;

public class FindForm {

	private static OrderDataService order = RMI.<OrderDataService>getDataService("order");
	
	private static ReceiveAndSendDataService  recAndSend = RMI.<ReceiveAndSendDataService>getDataService("receiveAndSend");
	
	private static  EntruckingDataService entrucking = RMI.<EntruckingDataService>getDataService("entrucking");
	
	private static PaymentDataService payment = RMI.<PaymentDataService>getDataService("receivable");
	
	private static ReceivingDataService receiving = RMI.<ReceivingDataService>getDataService("receiving");
	
	private static LoadingDataService loading = RMI.<LoadingDataService>getDataService("loading");
	
	private static TransferringDataService transfer = RMI.getDataService("transferring");
	
	private static InRepositoryDataService in = RMI.<InRepositoryDataService>getDataService("inrepository");
	
	private static OutRepositoryDataService out = RMI.<OutRepositoryDataService>getDataService("outrepository");
	
//	public static List<OrderVO> getOrderVO() {
//		List<OrderVO> vo = new ArrayList<OrderVO>();
//		List<OrderPO> po = null;
//		try {
//			po = order.getUnCheckOrder();
//		} catch (RemoteException e) {
//			e.printStackTrace();
//			return vo;
//		}
//		int size = po.size();
//		for(int i = 0; i < size; i++) {
//			vo.add(OrderPO.orderPOToVO(po.get(i)));
//		}
//		return vo;
//	}
	
	public static List<ReceivingVO> getReceivingVO() {
		List<ReceivingVO> vo = new ArrayList<ReceivingVO>();
		return vo;
	}
	
	public static List<TransferringVO> getTransferringVO() {
		List<TransferringVO> vo = new ArrayList<TransferringVO>();
		return vo;
	}
	
	public static List<LoadingVO> getLoadingVO() {
		List<LoadingVO> vo = new ArrayList<LoadingVO>();
		return vo;
	}
	
	public static List<InRepositoryVO> getInRepositoryVO() {
		List<InRepositoryVO> vo = new ArrayList<InRepositoryVO>();
		return vo;
	}
	
	public static List<OutRepositoryVO> getOutRepositoryVO() {
		List<OutRepositoryVO> vo = new ArrayList<OutRepositoryVO>();
		return vo;
	}
	
	public static List<EntruckingVO> getEntruckingVO() {
		List<EntruckingVO> vo = new ArrayList<EntruckingVO>();
		return vo;
	}
	
	public static List<ArrivalFormVO> getArrivalFormVO() {
		List<ArrivalFormVO> vo = new ArrayList<ArrivalFormVO>();
		return vo;
	}
	
	public static List<SendFormVO> getSendFormVO() {
		List<SendFormVO> vo = new ArrayList<SendFormVO>();
		return vo;
	}
	
	public static List<ReceivableVO> getReceivableVO() {
		List<ReceivableVO> vo = new ArrayList<ReceivableVO>();
		return vo;
	}
}
