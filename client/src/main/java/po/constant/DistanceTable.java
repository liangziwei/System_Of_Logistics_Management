package po.constant;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import constant.City;

/**
 *城市距离表 
 */
public class DistanceTable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3986296629496079661L;
	
	/**
	 *城市个数 
	 */
	private static final int CITY_NUM = 4;
	
	/**
	 *城市距离表 
	 */
	private double[][] table = new double[CITY_NUM][CITY_NUM];
	
	/**
	 *城市名称与在城市距离表中对应下标的映射表
	 */
	private static Map<City, Integer> CITY_INDEX_MAP = new HashMap<City, Integer>();
	
	static {
		CITY_INDEX_MAP.put(City.NAN_JING, 0);
		CITY_INDEX_MAP.put(City.BEI_JING, 1);
		CITY_INDEX_MAP.put(City.SHANG_HAI, 2);
		CITY_INDEX_MAP.put(City.GUANG_ZHOU, 3);
	}
	
	public DistanceTable() {
		//城市默认距离
		table[0][0] = table[1][1] = table[2][2] = table[3][3] = 30.0;	//同城的距离
		table[0][1] = table[1][0] = 900.0;								//南京-北京
		table[0][2] = table[2][0] = 266.0;								//南京-上海
		table[0][3] = table[3][0] = 1132.0;								//南京-广州
		table[1][2] = table[2][1] = 1064.7;								//北京-上海
		table[1][3] = table[3][1] = 1888.8;								//北京-广州
		table[2][3] = table[3][2] = 1213.0;								//上海-广州
	}
	
	public DistanceTable(List<DistanceItem> list) {
		//用户定义的城市距离
		this.setCityItems(list);
	}
	
	/**
	 *设置一条城市距离记录 
	 */
	public void setCityItem(DistanceItem item) {
		int src = CITY_INDEX_MAP.get(item.getSource());
		int dst = CITY_INDEX_MAP.get(item.getDestination());
		//如果是同城的距离
		if(src == dst) {
			table[0][0] = table[1][1] = table[2][2] = table[3][3] = item.getDistance();
			return ;
		}
		table[src][dst] = item.getDistance();
		table[dst][src] = item.getDistance();
	}
	
	/**
	 *设置多条城市距离记录 
	 */
	public void setCityItems(List<DistanceItem> list) {
		if(list == null) return;
		
		int size = list.size();
		for(int i = 0; i < size; i++) {
			this.setCityItem(list.get(i));
		}
	}
	
	/**
	 *获得城市距离表 
	 */
	public Map<City, HashMap<City, Double>> getDistanceTable() {
		Map<City, HashMap<City, Double>> t = new HashMap<City, HashMap<City, Double>>();
		//以南京为出发地
		HashMap<City, Double> nanJing = new HashMap<City, Double>();
		nanJing.put(City.NAN_JING, table[0][0]);
		nanJing.put(City.BEI_JING, table[0][1]);
		nanJing.put(City.SHANG_HAI, table[0][2]);
		nanJing.put(City.GUANG_ZHOU, table[0][3]);
		//以北京为出发地
		HashMap<City, Double> beiJing = new HashMap<City, Double>();
		beiJing.put(City.NAN_JING, table[1][0]);
		beiJing.put(City.BEI_JING, table[1][1]);
		beiJing.put(City.SHANG_HAI, table[1][2]);
		beiJing.put(City.GUANG_ZHOU, table[1][3]);
		//以上海为出发地
		HashMap<City, Double> shangHai = new HashMap<City, Double>();
		shangHai.put(City.NAN_JING, table[2][0]);
		shangHai.put(City.BEI_JING, table[2][1]);
		shangHai.put(City.SHANG_HAI, table[2][2]);
		shangHai.put(City.GUANG_ZHOU, table[2][3]);
		//以广州为出发地
		HashMap<City, Double> guangZhou = new HashMap<City, Double>();
		guangZhou.put(City.NAN_JING, table[3][0]);
		guangZhou.put(City.BEI_JING, table[3][1]);
		guangZhou.put(City.SHANG_HAI, table[3][2]);
		guangZhou.put(City.GUANG_ZHOU, table[3][3]);
		
		t.put(City.NAN_JING, nanJing);
		t.put(City.BEI_JING, beiJing);
		t.put(City.SHANG_HAI, shangHai);
		t.put(City.GUANG_ZHOU, guangZhou);
		return t;
	}
}
