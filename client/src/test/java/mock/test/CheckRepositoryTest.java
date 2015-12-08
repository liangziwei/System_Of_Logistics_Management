package mock.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import businessLogic.businessLogicController.repositoryController.ManageRepositoryController;
import businessLogicService.repositoryBLService.ManageRepositoryBLService;
import constant.AreaCodeType;
import mock.object.MockCheckRepository;
import po.repositoryPO.DeliveryInfoPO;
import vo.repositoryVO.DeliveryInfoVO;

public class CheckRepositoryTest {
	MockCheckRepository mockCheckRepository = new MockCheckRepository();
	ManageRepositoryBLService manageRepository = new ManageRepositoryController();
	@Test
	public void test() {
		List<DeliveryInfoPO> deliveryInfoPOs = new ArrayList<DeliveryInfoPO>();
		deliveryInfoPOs.add(new DeliveryInfoPO("1269324125", "2015-08-14","南京",AreaCodeType.TRUCKAREA,"072", "044", "011"));
		deliveryInfoPOs.add(new DeliveryInfoPO("1298697725", "2015-07-25","北京",AreaCodeType.MOTOAREA,"015", "034", "321"));
		deliveryInfoPOs.add(new DeliveryInfoPO("1349124125", "2015-10-13","北京",AreaCodeType.TRAINAREA,"012", "054", "141"));
		deliveryInfoPOs.add(new DeliveryInfoPO("8669124125", "2015-09-12","广州",AreaCodeType.PLANEAREA,"014", "084", "561"));
		deliveryInfoPOs.add(new DeliveryInfoPO("1269122352", "2015-12-13","上海",AreaCodeType.TRUCKAREA,"032", "564", "323"));
		deliveryInfoPOs.add(new DeliveryInfoPO("1262354125", "2015-08-15","南京",AreaCodeType.PLANEAREA,"022", "654", "091"));
		mockCheckRepository.setdeliveryInfoDT(deliveryInfoPOs);
		
		List<DeliveryInfoVO> list = new ArrayList<DeliveryInfoVO>();
		list =manageRepository.CheckRepositoryBL();
//		for(int i=0;i<list.size();i++){
//			assertEquals(deliveryInfoPOs.get(i).getdeliveryid(), list.get(i).getdeliveryid());
//			assertEquals(deliveryInfoPOs.get(i).getarrivalid(), list.get(i).getarrivalid());
//			assertEquals(deliveryInfoPOs.get(i).getareaCode(), list.get(i).getareaCode());
//			assertEquals(deliveryInfoPOs.get(i).getinrepositorydate(), list.get(i).getinrepositorydate());
//			assertEquals(deliveryInfoPOs.get(i).getposid(), list.get(i).getposid());
//			assertEquals(deliveryInfoPOs.get(i).getrowid(), list.get(i).getrowid());
//			assertEquals(deliveryInfoPOs.get(i).getshelfid(), list.get(i).getshelfid());
//		}
	}

}
