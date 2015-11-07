package mock.object;

import java.util.List;

import stub.dataImpl_stub.deliveryDataImpl_stub.OrderDataImpl_Stub;

public class MockTimeRecordList extends OrderDataImpl_Stub{

	public void setList(List<MockTimeRecord> list) {
		this.list = list;
	}
}
