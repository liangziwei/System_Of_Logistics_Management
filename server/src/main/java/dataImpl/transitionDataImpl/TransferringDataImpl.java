package dataImpl.transitionDataImpl;

import java.util.ArrayList;
import java.util.List;

import constant.LoadingType;
import dataService.transitionDataService.TransferringDataService;
import po.transitionPO.TransferringPO;

public class TransferringDataImpl implements TransferringDataService{

	public boolean AddTransferringFormDT(TransferringPO transferringPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean ModifyTransferringFormDT(TransferringPO transferringPO) {
		// TODO Auto-generated method stub
		return false;
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
		return null;
	}

}
