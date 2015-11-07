package mock.object;

import java.util.ArrayList;
import java.util.List;

public class MockTimeRecordList{

	private List<MockTimeRecord> list = new ArrayList<MockTimeRecord>();
	
	public MockTimeRecordList(List<MockTimeRecord> list) {
		this.list = list;
	}

	public List<MockTimeRecord> getList() {
		return list;
	}
	
	public int calculateTime() {
		int time = 0;
		for(int i = 0; i < list.size(); i++) {
			time += list.get(i).getTime();
		}
		return time / list.size();
	}
}
