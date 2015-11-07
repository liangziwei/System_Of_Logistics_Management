package mock.object;

import constant.City;
import po.deliveryPO.TimeRecordPO;

@SuppressWarnings("serial")
public class MockTimeRecord extends TimeRecordPO{

	public MockTimeRecord(City src, City des, int time) {
		super(src, des, time);
	}
}

