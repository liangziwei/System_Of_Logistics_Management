package mock.object;

import po.managerPO.UncheckedFormPO;

import java.rmi.RemoteException;

import dataService.managerDataService.ApprovalFormDataService;

public class MockApprovalFormData implements ApprovalFormDataService{
	public UncheckedFormPO getUncheckedForms(String date){
//		List<OrderPO> orderlist = new ArrayList<OrderPO>();
//		List<EntruckingPO> entruckinglist = new ArrayList<EntruckingPO>();
//		List<ArrivalFormPO> arrivalformlist;
//		List<ReceivablePO> receivablelist;
//		List<SendFormPO> sendformlist;
//		List<ReceivingPO> receivinglist;
//		List<InRepositoryPO> inrepositorylist;
//		List<TransferringPO> transferringlist;
//		List<OutRepositoryPO> outrepositorylist; 
//		List<PaymentPO> paymentlist;
//		List<TransitionNode> trace = new ArrayList<TransitionNode>();
//		List<City> city = new ArrayList<City>();
//		trace.add(TransitionNode.RECEIVER_BUSINESS_HALL);
//		orderlist.add(new OrderPO(new ClientInfo(ClientType.SENDER, "张三", "南京市", null, null, "12345678901"),
//				new ClientInfo(ClientType.RECEIVER, "李四", "上海市", null, null, "00000000000"),
//				new GoodsInfo("1", "1234561869", "2", "衣服", "2*2*2", 
//						PackageType.COURIER_BAG, DeliveryType.ECONOMIC,
//						"2015-10-27", trace, city)));
		
		
		return null;
	}

	@Override
	public UncheckedFormPO getUncheckedForms() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
