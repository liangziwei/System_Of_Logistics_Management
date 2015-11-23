package mock.object;

import java.util.ArrayList;
import java.util.List;

import constant.LoadingType;
import po.transitionPO.TransferringPO;

public class MockTransferring {
	List<TransferringPO> alltransferringPO =new ArrayList<TransferringPO>();
	public List<TransferringPO> GetTransferringInfoDT(String date) {
		List<String> alldeliveryid1 = new ArrayList<String>();
		alldeliveryid1.add("1110000123");
		alldeliveryid1.add("1110001342");
		alldeliveryid1.add("1110022123");
		List<String> alldeliveryid2 = new ArrayList<String>();
		alldeliveryid2.add("1110120123");
		alldeliveryid2.add("1111001342");
		alldeliveryid2.add("1110452123");
		alltransferringPO.add(new TransferringPO("2015-10-11","017110100000127",LoadingType.PLANE,
				"139010001","北京", "南京", "茗柯", "3", alldeliveryid1));
		alltransferringPO.add(new TransferringPO("2015-10-12","017110100010127",LoadingType.TRAIN,
				"159010101","北京", "南京", "haha", "2", alldeliveryid2));
		return alltransferringPO;
	}
	
	public void setTransferringInfoDT(List<TransferringPO> transferringPOs) {
		this.alltransferringPO=transferringPOs;
	}
}
