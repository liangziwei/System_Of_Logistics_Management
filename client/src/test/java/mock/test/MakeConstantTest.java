package mock.test;

import static org.junit.Assert.*;
import mock.object.MockMakeConstantData;

import org.junit.Test;

import constant.City;
import constant.TransitType;

public class MakeConstantTest {

	@Test
	public void test() {
		MockMakeConstantData makeConstant = new MockMakeConstantData();
		assertEquals(false, makeConstant.updateDistance(100.0, City.BEI_JING, City.GUANG_ZHOU));
		assertEquals(true, makeConstant.updatePrice(50.0, TransitType.RAILWAY));
	}

}
