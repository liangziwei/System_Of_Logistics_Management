package mock.object;

import java.util.ArrayList;
import java.util.List;

import constant.AreaCodeType;
import po.repositoryPO.DeliveryInfoPO;

public class MockCheckRepository {
	List<DeliveryInfoPO> deliveryInfoPOs = new ArrayList<DeliveryInfoPO>();
	public List<DeliveryInfoPO> CheckRepositoryDT() {
		deliveryInfoPOs.add(new DeliveryInfoPO("1269324125", "2015-08-14","南京",AreaCodeType.TRUCKAREA,"072", "044", "011",""));
		deliveryInfoPOs.add(new DeliveryInfoPO("1298697725", "2015-07-25","北京",AreaCodeType.MOTOAREA,"015", "034", "321",""));
		deliveryInfoPOs.add(new DeliveryInfoPO("1349124125", "2015-10-13","北京",AreaCodeType.TRAINAREA,"012", "054", "141",""));
		deliveryInfoPOs.add(new DeliveryInfoPO("8669124125", "2015-09-12","广州",AreaCodeType.PLANEAREA,"014", "084", "561",""));
		deliveryInfoPOs.add(new DeliveryInfoPO("1269122352", "2015-12-13","上海",AreaCodeType.TRUCKAREA,"032", "564", "323",""));
		deliveryInfoPOs.add(new DeliveryInfoPO("1262354125", "2015-08-15","南京",AreaCodeType.PLANEAREA,"022", "654", "091",""));
		return deliveryInfoPOs;
	}
	
	public void setdeliveryInfoDT(List<DeliveryInfoPO> deliveryInfoPOs) {
		this.deliveryInfoPOs=deliveryInfoPOs;
	}
}
