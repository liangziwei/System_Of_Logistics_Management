package stub.dataImpl_stub.transitionDataImpl_stub;

import java.util.ArrayList;
import java.util.List;

import constant.City;
import constant.LoadingType;
import dataService.transitionDataService.TransferringDataService;
import po.transitionPO.TransferringPO;

public class TransferringDataImpl_Stub implements TransferringDataService{

	public boolean AddTransferringFormDT(TransferringPO transferringPO) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean ModifyTransferringFormDT(TransferringPO transferringPO) {
		// TODO Auto-generated method stub
		return true;
	}

	public TransferringPO FindTransferringFormDT(String transferringNumber) {
		// TODO Auto-generated method stub
		List<String> alldeliveryid = new ArrayList<String>();
		alldeliveryid.add("1110000123");
		alldeliveryid.add("1110001342");
		alldeliveryid.add("1110022123");
		TransferringPO transferringPO =new TransferringPO("2015-10-11","01710100000127" , LoadingType.PLANE,"139010001","北京", "南京", "茗柯", "3", alldeliveryid);
		transferringPO.setfare(500);
		return transferringPO;
	}

	public List<TransferringPO> GetTransferringInfoDT(String date) {
		// TODO Auto-generated method stub
		List<TransferringPO> alltransferringPO =new ArrayList<TransferringPO>();
		List<String> alldeliveryid1 = new ArrayList<String>();
		alldeliveryid1.add("1110000123");
		alldeliveryid1.add("1110001342");
		alldeliveryid1.add("1110022123");
		List<String> alldeliveryid2 = new ArrayList<String>();
		alldeliveryid2.add("1110120123");
		alldeliveryid2.add("1111001342");
		alldeliveryid2.add("1110452123");
		alltransferringPO.add(new TransferringPO("2015-10-11","01710100000127",LoadingType.PLANE,
				"139010001","北京", "南京", "茗柯", "3", alldeliveryid1));
		alltransferringPO.add(new TransferringPO("2015-10-12","01710100010127",LoadingType.TRAIN,
				"159010101","北京", "南京", "haha", "2", alldeliveryid2));
		return alltransferringPO;
	}

}
