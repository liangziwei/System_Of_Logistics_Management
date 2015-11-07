package mock.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import constant.City;
import mock.object.MockTimeRecord;
import mock.object.MockTimeRecordList;

public class CalculateTimeTest {

	@Test
	public void test() {
		MockTimeRecord t1 = new MockTimeRecord(City.NAN_JING, City.BEI_JING, 3);
		MockTimeRecord t2 = new MockTimeRecord(City.NAN_JING, City.BEI_JING, 1);
		MockTimeRecord t3 = new MockTimeRecord(City.NAN_JING, City.BEI_JING, 2);
		
		List<MockTimeRecord> l = new ArrayList<MockTimeRecord>();
		l.add(t1);
		l.add(t2);
		l.add(t3);
		
		MockTimeRecordList order = new MockTimeRecordList(l);
		
		assertEquals(2, order.calculateTime());
		
	}

}
