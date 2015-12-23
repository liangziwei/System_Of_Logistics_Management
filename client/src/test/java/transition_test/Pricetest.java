package transition_test;

import static org.junit.Assert.*;

import org.junit.Test;

import businessLogic.businessLogicModel.transitionModel.Loading;
import businessLogic.businessLogicModel.transitionModel.Transferring;
import constant.LoadingType;


/**
 *测试运费计算的正确性
 */
public class Pricetest {

	@Test
	public void test() {
		Loading loading = new Loading();
		Transferring transferring = new Transferring();
		double fare1 = loading.loadingFare("南京", "上海", LoadingType.PLANE);
		double fare11 = loading.loadingFare("南京", "上海", LoadingType.TRAIN);
		double fare12 = loading.loadingFare("南京", "上海", LoadingType.TRUCK);
		double fare2 = loading.loadingFare("南京", "北京", LoadingType.PLANE);
		double fare21 = loading.loadingFare("南京", "北京", LoadingType.TRAIN);
		double fare22 = loading.loadingFare("南京", "北京", LoadingType.TRUCK);
		double fare3 = loading.loadingFare("南京", "广州", LoadingType.PLANE);
		double fare31 = loading.loadingFare("南京", "广州", LoadingType.TRAIN);
		double fare32 = loading.loadingFare("南京", "广州", LoadingType.TRUCK);
		
		double Fare1 = transferring.tranferringFare("南京", "上海", LoadingType.PLANE);
		double Fare11 = transferring.tranferringFare("南京", "北京", LoadingType.PLANE);
		double Fare12 = transferring.tranferringFare("南京", "广州", LoadingType.PLANE);
		double Fare13 = transferring.tranferringFare("上海", "北京", LoadingType.PLANE);
		double Fare14 = transferring.tranferringFare("上海", "广州", LoadingType.PLANE);
		double Fare15 = transferring.tranferringFare("广州", "北京", LoadingType.PLANE);
		double Fare2 = transferring.tranferringFare("南京", "上海", LoadingType.TRAIN);
		double Fare21 = transferring.tranferringFare("南京", "北京", LoadingType.TRAIN);
		double Fare22 = transferring.tranferringFare("南京", "广州", LoadingType.TRAIN);
		double Fare23 = transferring.tranferringFare("上海", "北京", LoadingType.TRAIN);
		double Fare24 = transferring.tranferringFare("上海", "广州", LoadingType.TRAIN);
		double Fare25 = transferring.tranferringFare("广州", "北京", LoadingType.TRAIN);
		double Fare3 = transferring.tranferringFare("南京", "上海", LoadingType.TRUCK);
		double Fare31 = transferring.tranferringFare("南京", "北京", LoadingType.TRUCK);
		double Fare32 = transferring.tranferringFare("南京", "广州", LoadingType.TRUCK);
		double Fare33 = transferring.tranferringFare("上海", "北京", LoadingType.TRUCK);
		double Fare34 = transferring.tranferringFare("上海", "广州", LoadingType.TRUCK);
		double Fare35 = transferring.tranferringFare("广州", "北京", LoadingType.TRUCK);
		
		
		//loading
		assertEquals(266000.0, fare1,1.0);
		assertEquals(106400.0, fare11,1.0);
		assertEquals(5320.0, fare12,1.0);
		assertEquals(900000.0, fare2,1.0);
		assertEquals(360000.0, fare21,1.0);
		assertEquals(18000.0, fare22,1.0);
		assertEquals(1132000.0, fare3,1.0);
		assertEquals(452800.0, fare31,1.0);
		assertEquals(22640.0, fare32,1.0);
		
		//transferring
		assertEquals(266000.0, Fare1,1.0);
		assertEquals(900000.0, Fare11,1.0);
		assertEquals(1132000.0, Fare12,1.0);
		assertEquals(1064700.0, Fare13,1.0);
		assertEquals(1213000.0, Fare14,1.0);
		assertEquals(1888800.0, Fare15,1.0);
		assertEquals(106400.0, Fare2,1.0);
		assertEquals(360000.0, Fare21,1.0);
		assertEquals(452800.0, Fare22,1.0);
		assertEquals(425880.0, Fare23,1.0);
		assertEquals(485200.0, Fare24,1.0);
		assertEquals(755520.0, Fare25,1.0);
		assertEquals(5320.0, Fare3,1.0);
		assertEquals(18000.0, Fare31,1.0);
		assertEquals(22640.0, Fare32,1.0);
		assertEquals(21294.0, Fare33,1.0);
		assertEquals(24260.0, Fare34,1.0);
		assertEquals(37776.0, Fare35,1.0);
//		fail("Not yet implemented");
	}

}
