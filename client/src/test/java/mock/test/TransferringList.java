package mock.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import businessLogic.businessLogicController.repositoryController.OutRepositoryController;
import businessLogicService.repositoryBLService.OutRepositoryBLService;
import constant.City;
import constant.LoadingType;
import mock.object.MockTransferring;
import po.transitionPO.TransferringPO;
import vo.repositoryVO.RepositoryInfoVO;
import vo.transitionVO.TransferringVO;

public class TransferringList {
	MockTransferring mockTransferring = new MockTransferring();
	OutRepositoryBLService outRepositoryBLService = new OutRepositoryController();
	@Test
	public void test() {
		List<TransferringPO> alltransferringPO =new ArrayList<TransferringPO>();
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
		mockTransferring.setTransferringInfoDT(alltransferringPO);
		List<TransferringVO> list = new ArrayList<TransferringVO>();
		list =outRepositoryBLService.GetTransferringInfo("2015-11-7");
		for(int i=0;i<list.size();i++){
			assertEquals(alltransferringPO.get(i).getloadingdate(), list.get(i).getloadingdate());
			assertEquals(alltransferringPO.get(i).getarrivalid(), list.get(i).getarrivalid());
			assertEquals(alltransferringPO.get(i).gettransferringid(), list.get(i).gettransferringid());
			assertEquals(alltransferringPO.get(i).getway(), list.get(i).getway());
			assertEquals(alltransferringPO.get(i).getwayid(), list.get(i).getwayid());
			assertEquals(alltransferringPO.get(i).getdepartureid(), list.get(i).getdepartureid());
			assertEquals(alltransferringPO.get(i).getsupervisionid(), list.get(i).getsupervisionid());
			assertEquals(alltransferringPO.get(i).getcontainerid(), list.get(i).getcontainerid());
			List<String> alldeliveryid = alltransferringPO.get(i).getalldeliveryid();
			List<String> alldeliveryida = list.get(i).getalldeliveryid();
			for(int o=0;o<alldeliveryid.size();o++){
				assertEquals(alldeliveryid.get(o), alldeliveryida.get(o));
			}
		}
		
		
		
	}

}
