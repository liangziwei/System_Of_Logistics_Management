package stub.businessLogicImpl_stub.transitionBLImpl_stub;

import java.rmi.RemoteException;

import businessLogic.businessLogicModel.transitionModel.Receiving;
import businessLogicService.transitionBLService.ReceivingBLService;
import dataService.transitionDataService.ReceivingDataService;
import po.transitionPO.ReceivingPO;
import stub.dataImpl_stub.transitionDataImpl_stub.ReceivingDataImpl_Stub;
import vo.transitionVO.ReceivingVO;

public class ReceivingBLImpl_Stub implements ReceivingBLService{
	private ReceivingDataService receivingdata =new ReceivingDataImpl_Stub();

	public boolean addReceivingFormBL(ReceivingVO receivingVO) {
		// TODO Auto-generated method stub
		try {
			return  receivingdata.addReceivingFormDT(this.ReceivingVOtoReceivingPO(receivingVO));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean modifyReceivingFormBL(ReceivingVO receivingVO) {
		// TODO Auto-generated method stub
		try {
			return receivingdata.modifyReceivingFormDT(this.ReceivingVOtoReceivingPO(receivingVO));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public ReceivingVO findReceivingformBL(String receivingNumber) {
		// TODO Auto-generated method stub
		try {
			return this.ReceivingPOtoReceivingVO(receivingdata.FindReceivingFormDT(receivingNumber));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private ReceivingPO ReceivingVOtoReceivingPO(ReceivingVO receivingVO){
		return new ReceivingPO(receivingVO.gettransitionid(), receivingVO.getarrivaldate(),
				receivingVO.gettransferringid(),receivingVO.getdepartureid(),
				receivingVO.getarrivalid(), receivingVO.getstate());
	}
	private ReceivingVO ReceivingPOtoReceivingVO(ReceivingPO receivingPO) {
		return new ReceivingVO(receivingPO.gettransitionid(), receivingPO.getarrivaldate(), 
				receivingPO.gettransferringid(), receivingPO.getdepartureid(), 
				receivingPO.getarrivalid(), receivingPO.getstate());
	}

	@Override
	public boolean verify(ReceivingVO receivingVO) {
		// TODO Auto-generated method stub
		return false;
	}

}
