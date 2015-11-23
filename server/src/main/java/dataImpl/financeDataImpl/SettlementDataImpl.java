package dataImpl.financeDataImpl;

import java.sql.ResultSet;
import java.util.List;

import mysql.Database;
import po.businessPO.ReceivablePO;
import dataService.financeDataService.SettlementDataService;

/**
 * description:数据服务层为结算管理提供服务的具体实现
 * @author 张仁知
 */
public class SettlementDataImpl implements SettlementDataService{

	ResultSet rs;
	
	public List<ReceivablePO> getReceiList(String date) {
		return null;
	}
	
	public List<ReceivablePO> getBusinessRecei(String id,String date) {
		return null;
	}
	
//	private ReceivablePO rsToReceivablePO(ResultSet rs){
//		
//	}
}
