package businessTest;

import static org.junit.Assert.*;
import mysql.Database;

import org.junit.Test;

import dataImpl.businessDataImpl.EntruckingDataImpl;
import po.businessPO.EntruckingPO;

public class EntruckingDataTest {

	@Test
	public void test() {
		EntruckingPO entruckingPO=new EntruckingPO("2015-10-10","025001","0250012015101012345","025002","025001001","监装员","押运员",600);
		EntruckingDataImpl entruckingData=new EntruckingDataImpl();
		assertEquals(true, entruckingData.addEntruckingFrom(entruckingPO));
	}

}
