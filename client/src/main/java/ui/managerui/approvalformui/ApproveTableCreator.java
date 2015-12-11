package ui.managerui.approvalformui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTable;

import dataService.Approvable;
import vo.businessVO.ArrivalFormVO;
import vo.businessVO.EntruckingVO;
import vo.businessVO.ReceivableVO;
import vo.businessVO.SendFormVO;
import vo.deliveryVO.OrderVO;
import vo.financeVO.PaymentVO;
import vo.repositoryVO.InRepositoryVO;
import vo.repositoryVO.OutRepositoryVO;
import vo.transitionVO.ReceivingVO;
import vo.transitionVO.TransferringVO;

/**
 * 根据不同的VO生成不同的表格
 */
public class ApproveTableCreator {
	
	private int tableRow = 0;
	
	/**
	 * 单据名称与具体单据字段的映射
	 */
	private static Map<String, Object[]> TABLE_NAME_MAP = new HashMap<String, Object[]>();
	
	/**
	 * 初始化单据名字-表格字段的映射表
	 */
	static {
		//寄件单列名
		Object[] order = new Object[] {"建单日期", "订单条形码号", "快递类型", "包装类型", "运费", "预估时间"};
		TABLE_NAME_MAP.put(TableTypeName.ORDER_NAME, order);
		//装车单列名
		Object[] entrucking = new Object[] {"装车日期", "营业厅编号","汽运编号","到达地","车辆代号","监装员","押运员","运费"};
		TABLE_NAME_MAP.put(TableTypeName.ENTRUCKING_NAME, entrucking);
		//营业厅到达单列名
		Object[] arrival = new Object[] {"到达日期", "中转单编号", "出发地", "货物到达状态"};
		TABLE_NAME_MAP.put(TableTypeName.ARRIVAL_NAME, arrival);
		//收款单列名
		Object[] receivable = new Object[] {"收款日期", "营业厅编号", "收款金额", "收款快递员"};
		TABLE_NAME_MAP.put(TableTypeName.RECEIVABLE_NAME, receivable);
		//派件单列名
		Object[] send = new Object[] {"到达日期", "订单条形码号", "派送员"};
		TABLE_NAME_MAP.put(TableTypeName.SEND_NAME, send);
		//中转中心到达单列名
		Object[] receiving = new Object[] {"到达日期", "中转单编号", "本中转中心编号", "出发地", "到达地", "货物到达状态"};
		TABLE_NAME_MAP.put(TableTypeName.RECEIVING_NAME, receiving);
		//入库单列名
		Object[] in = new Object[] {"入库日期", "快递编号", "目的地", "区号", "排号", "架号", "位号"};
		TABLE_NAME_MAP.put(TableTypeName.IN_NAME, in);
		//中转单列名
		Object[] transferring = new Object[] {"装车日期","中转单编号","装运方式编号","运送方式","出发地","目的地","监装员","货柜号"};
		TABLE_NAME_MAP.put(TableTypeName.TRANSFERRING_NAME, transferring);
		//出库单列名
		Object[] out = new Object[] {"出库日期", "快递编号", "目的地", "装运方式", "装运信息编号"};
		TABLE_NAME_MAP.put(TableTypeName.OUT_NAME, out);
		//付款单列名
		Object[] payment = new Object[] {"付款日期", "付款金额", "付款人", "付款账户", "条目", "备注"};
		TABLE_NAME_MAP.put(TableTypeName.PAYMENT_NAME, payment);
	}
	
	public ApproveTableCreator(int dataRow) {
		this.tableRow = dataRow;
	}
	

	/**
	 *获得订单的表格 
	 */
	public JTable getOrderTable(ArrayList<OrderVO> list) {
		int size = list.size();
		int rowNum = this.getRowNumber(list);
		Object[][] data = new Object[rowNum][6];
		OrderVO vo = null;
		for(int i = 0; i < size; i++) {
			vo = list.get(i);
			//"建单日期", "订单条形码号", "快递类型", "包装类型", "运费", "预估时间"
			data[i][0] = vo.getDate();
			data[i][1] = vo.getGoodsInfo().getId();
			data[i][2] = vo.getGoodsInfo().getDeliveryString();
			data[i][3] = vo.getGoodsInfo().getPackageString();
			data[i][4] = vo.getGoodsInfo().getPrice();
			data[i][5] = vo.getGoodsInfo().getTime();
		}
		return new JTable(data, TABLE_NAME_MAP.get(TableTypeName.ORDER_NAME));
	}
	
	/**
	 *获得装车单的表格 
	 */
	public JTable getEntruckingTable(ArrayList<EntruckingVO> list) {
		int size = list.size();
		int rowNum = this.getRowNumber(list);
		Object[][] data = new Object[rowNum][8];
		EntruckingVO vo = null;
		for(int i = 0; i < size; i++) {
			vo = list.get(i);
			//"装车日期", "营业厅编号", "汽运编号", "到达地", "车辆代号", "监装员", "押运员", "运费"
			data[i][0] = vo.getDate();
			data[i][1] = vo.getBusinessHallid();
			data[i][2] = vo.getTransportNumber();
			data[i][3] = vo.getDestionation();
			data[i][4] = vo.getVehicleid();
			data[i][5] = vo.getSupervisor();
			data[i][6] = vo.getSupercargo();
			data[i][7] = vo.getFreight();
		}
		return new JTable(data, TABLE_NAME_MAP.get(TableTypeName.ENTRUCKING_NAME));
	}
	
	/**
	 * 获得营业厅到达单的表格
	 */
	public JTable getArrivalTable(ArrayList<ArrivalFormVO> list) {
		int size = list.size();
		int rowNum = this.getRowNumber(list);
		Object[][] data = new Object[rowNum][4];
		ArrivalFormVO vo = null;
		for(int i = 0; i < size; i++) {
			vo = list.get(i);
			//"到达日期", "中转单编号", "出发地", "货物到达状态"
			data[i][0] = vo.getDate();
			data[i][1] = vo.getTransitNumber();
			data[i][2] = vo.getDepartPlace();
			data[i][3] = vo.getState();
		}
		
		return new JTable(data, TABLE_NAME_MAP.get(TableTypeName.ARRIVAL_NAME));
	}
	
	/**
	 *获得收款单的表格 
	 */
	public JTable getReceivableTable(ArrayList<ReceivableVO> list) {
		int size = list.size();
		int rowNum = this.getRowNumber(list);
		Object[][] data = new Object[rowNum][4];
		ReceivableVO vo = null;
		for(int i = 0; i < size; i++) {
			vo = list.get(i);
			//"收款日期", "营业厅编号", "收款金额", "收款快递员"
			data[i][0] = vo.getDate();
			data[i][1] = vo.getBusinessID();
			data[i][2] = vo.getMoney();
			data[i][3] = vo.getCourier();
		}
		return new JTable(data, TABLE_NAME_MAP.get(TableTypeName.RECEIVABLE_NAME));
	}
	
	/**
	 * 获得中转中心接收单的表格
	 */
	public JTable getReceivingTable(ArrayList<ReceivingVO> list) {
		int size = list.size();
		int rowNum = this.getRowNumber(list);
		Object[][] data = new Object[rowNum][6];
		ReceivingVO vo = null;
		for(int i = 0; i < size; i++) {
			vo = list.get(i);
			//"到达日期", "中转单编号", "本中转中心编号", "出发地", "到达地", "货物到达状态"
			data[i][0] = vo.getarrivaldate();
			data[i][1] = vo.gettransferringid();
			data[i][2] = vo.gettransitionid();
			data[i][3] = vo.getdepartureid();
			data[i][4] = vo.getarrivalid();
			data[i][5] = vo.getstate();
		}
		return new JTable(data, TABLE_NAME_MAP.get(TableTypeName.RECEIVING_NAME));
	}
	
	/**
	 *获得 派送单的表格
	 */
	public JTable getSendTable(ArrayList<SendFormVO> list) {
		int size = list.size();
		int rowNum = this.getRowNumber(list);
		Object[][] data = new Object[rowNum][3];
		SendFormVO vo = null;
		for(int i = 0; i < size; i++) {
			vo = list.get(i);
			//"到达日期", "订单条形码号", "派送员"
			data[i][0] = vo.getDate();
			data[i][1] = vo.getDeliveryid();
			data[i][2] = vo.getSender();
		}
		return new JTable(data, TABLE_NAME_MAP.get(TableTypeName.SEND_NAME));
	}
	
	/**
	 *获得入库单的表格 
	 */
	public JTable getInRepositoryTable(ArrayList<InRepositoryVO> list) {
		int size = list.size();
		int rowNum = this.getRowNumber(list);
		Object[][] data = new Object[rowNum][7];
		InRepositoryVO vo = null;
		for(int i = 0; i < size; i++) {
			vo = list.get(i);
			//"入库日期", "快递编号", "目的地", "区号", "排号", "架号", "位号"
			data[i][0] = vo.getinrepositorydate();
			data[i][1] = vo.getdeliveryid();
			data[i][2] = vo.getarrivalid();
			data[i][3] = vo.getAreaCodeString();
			data[i][4] = vo.getrowid();
			data[i][5] = vo.getshelfid();
			data[i][6] = vo.getposid();
		}
		return new JTable(data, TABLE_NAME_MAP.get(TableTypeName.IN_NAME));
	}
	
	/**
	 *获得中转单的表格 
	 */
	public JTable getTransferringTable(ArrayList<TransferringVO> list) {
		int size = list.size();
		int rowNum = this.getRowNumber(list);
		Object[][] data = new Object[rowNum][8];
		TransferringVO vo = null;
		for(int i = 0; i < size; i++) {
			vo = list.get(i);
			//"装车日期", "中转单编号", "装运方式编号", "运送方式", "出发地", "目的地", "监装员", "货柜号"
			data[i][0] = vo.getloadingdate();
			data[i][1] = vo.gettransferringid();
			data[i][2] = vo.getwayid();
			data[i][3] = vo.getLoadingTypeString();
			data[i][4] = vo.getdepartureid();
			data[i][5] = vo.getarrivalid();
			data[i][6] = vo.getsupervisionid();
			data[i][7] = vo.getcontainerid();
		}
		return new JTable(data, TABLE_NAME_MAP.get(TableTypeName.TRANSFERRING_NAME));
	}
	
	/**
	 *获得出库单的表格 
	 */
	public JTable getOutRepositoryTable(ArrayList<OutRepositoryVO> list) {
		int size = list.size();
		int rowNum = this.getRowNumber(list);
		Object[][] data = new Object[rowNum][5];
		OutRepositoryVO vo = null;
		for(int i = 0; i < size; i++) {
			vo = list.get(i);
			//"出库日期", "快递编号", "目的地", "装运方式", "装运信息编号"
			data[i][0] = vo.getoutrepositorydate();
			data[i][1] = vo.getdeliveryid();
			data[i][2] = vo.getarrivalid();
			data[i][3] = vo.getWayString();
			data[i][4] = vo.getloadingid();
		}
		return new JTable(data, TABLE_NAME_MAP.get(TableTypeName.OUT_NAME));
	}
	
	/**
	 *获得付款单的表格 
	 */
	public JTable getPaymentTable(ArrayList<PaymentVO> list) {
		int size = list.size();
		int rowNum = this.getRowNumber(list);
		Object[][] data = new Object[rowNum][6];
		PaymentVO vo = null;
		for(int i = 0; i < size; i++) {
			vo = list.get(i);
			//"付款日期", "付款金额", "付款人", "付款账户", "条目", "备注"
			data[i][0] = vo.getDate();
			data[i][1] = vo.getPayAmount();
			data[i][2] = vo.getName();
			data[i][3] = vo.getAccount();
			data[i][4] = vo.getEntry();
			data[i][5] = vo.getRemark();
		}
		return new JTable(data, TABLE_NAME_MAP.get(TableTypeName.PAYMENT_NAME));
	}
	
	
	/**
	 * 获得表格的行数
	 */
	private int getRowNumber(ArrayList<? extends Approvable> list) {
		int size = list.size();
		int rowNum = size < tableRow ? tableRow : size;
		return rowNum;
	}
}
