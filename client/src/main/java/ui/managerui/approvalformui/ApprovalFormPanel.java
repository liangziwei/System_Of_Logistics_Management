package ui.managerui.approvalformui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import businessLogic.businessLogicController.managerController.ApprovalFormController;
import businessLogicService.managerBLService.ApprovalFormBLService;
import ui.baseui.DetailPanel;
import vo.ApprovalFormVO;
import vo.businessVO.ArrivalFormVO;
import vo.businessVO.EntruckingVO;
import vo.businessVO.ReceivableVO;
import vo.businessVO.SendFormVO;
import vo.deliveryVO.OrderVO;
import vo.financeVO.PaymentVO;
import vo.managerVO.UncheckedFormVO;
import vo.repositoryVO.InRepositoryVO;
import vo.repositoryVO.OutRepositoryVO;
import vo.transitionVO.ReceivingVO;
import vo.transitionVO.TransferringVO;

@SuppressWarnings("serial")
public class ApprovalFormPanel extends DetailPanel{
	
	private ApprovalFormBLService approve = new ApprovalFormController();
	
	private JLabel typeLabel = new JLabel("单据类型");

	private JComboBox<String> typeText = new JComboBox<String>();
	
	private JScrollPane formContainer = new JScrollPane();
	
	private JTable form = null;
	
	private JButton approveOne = new JButton("通过审批");
	
	private JButton approveMore = new JButton("批量审批");
	
	private JLabel tip = new JLabel();
	
	private UncheckedFormVO uncheck = this.approve.getUncheckedForms();
	
	/**
	 * 单据名称与单据列表的映射
	 */
	private Map<String, ArrayList<? extends ApprovalFormVO>> formListMap
			= new HashMap<String, ArrayList<? extends ApprovalFormVO>>();
	
	/**
	 * 单据名称与具体单据数据信息的映射
	 */
	private Map<String, Object[]> tableNameMap = new HashMap<String, Object[]>();
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 12);
	
	private static final int LABEL_W = DETAIL_PANEL_W / 12;
	
	private static final int LABEL_H = LABEL_W >> 1;
	
	private static final int TEXT_W = LABEL_W * 3;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int TABLE_W = DETAIL_PANEL_W - TEXT_W;
	
	private static final int TABLE_H = DETAIL_PANEL_H >> 1;
	
	private static final int BUTTON_W = TEXT_W >> 1;
	
	private static final int BUTTON_H = (BUTTON_W >> 1) - 10;
	
	private static final int START_X = DETAIL_PANEL_W - TABLE_W;
	
	private static final int START_Y = START_X >> 2;
	
	private static final int ROW_NUM = 10;
	
	public ApprovalFormPanel() {
		//初始化单据名字-数据VO列表的映射表
		this.initFormListMap();
		//初始化单据名字-表格列名的映射表
		this.initTableName();
		//类型标签
		this.typeLabel.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.typeLabel.setFont(WORD_FONT);
		//类型文本
		this.typeText.setBounds(this.typeLabel.getX() + (LABEL_W * 3 >> 1), this.typeLabel.getY(),
				TEXT_W, TEXT_H);
		this.typeText.setFont(WORD_FONT);
		this.addTypeItem();    //增加下拉框选项
		this.addTypeItemListener();			
		//单据表格
		this.setTable("寄件单");
		//审批一张单按钮
		this.approveOne.setBounds(this.typeLabel.getX(), this.formContainer.getY() +
				this.formContainer.getHeight() + (LABEL_H * 3 >> 1), BUTTON_W, BUTTON_H);
		this.approveOne.setFont(WORD_FONT);
		//审批多张单按钮
		this.approveMore.setBounds(this.approveOne.getX() + (int)(BUTTON_W * 2.5),
				this.approveOne.getY(), BUTTON_W, BUTTON_H);
		this.approveMore.setFont(WORD_FONT);
		//添加按钮监听
		this.addButtonListener();
		//提示标签
		this.tip.setBounds(this.typeText.getX() + TEXT_W + TEXT_H,
				this.typeText.getY(),TEXT_W, TEXT_H);
		this.tip.setFont(WORD_FONT);
		tip.setForeground(Color.RED);
		//把组件添加到主面板
		this.add(this.typeLabel);
		this.add(this.typeText);
		this.add(this.formContainer);
		this.add(this.approveOne);
		this.add(this.approveMore);
		this.add(this.tip);
	}
	
	private void addTypeItemListener() {
		this.typeText.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(form != null) form.setVisible(false);
				//根据用户的选择的表格类型获得相应单据的编号
				setTable((String)typeText.getSelectedItem());				
				//刷新面板
				repaint();
			}
		});
	}
	
	private void addButtonListener() {
		//审批一张单据
		this.approveOne.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String type = (String)typeText.getSelectedItem();
				ArrayList<? extends ApprovalFormVO> selectedForm = formListMap.get(type);//当前要审批的单据列表
				int formNum = selectedForm.size();
				int select = form.getSelectedRow();
				//如果用户没有选择单据,提示用户进行选择
				if(select == -1 || select >= formNum) {
					tip.setText("请选择要审批的单据");
					repaint();
					return;
				}
				else {
					tip.setText("");
				}
				//更新单据审批状态
				approve.approveOneForm(selectedForm.get(select), type);
				//更新单据列表的显示
				formListMap.get(type).remove(select);
				setTable(type);
				repaint();
			}
		});
		//审批所有相同的单据
		this.approveMore.addActionListener(new ActionListener() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				tip.setText("");
				String type = (String)typeText.getSelectedItem();
				ArrayList<? extends ApprovalFormVO> selectedForm = formListMap.get(type);//当前要审批的单据列表
				//更新单据审批状态
				approve.approveMoreForm((ArrayList<ApprovalFormVO>) selectedForm, type);
				//更新单据列表的显示
				formListMap.get(type).clear();;
				setTable(type);
				repaint();
			}
		});
	}
	
	private void initFormListMap() {
		this.formListMap.put("寄件单", this.uncheck.getOrderlist());
		this.formListMap.put("装车单", this.uncheck.getEntruckinglist());
		this.formListMap.put("营业厅到达单", this.uncheck.getArrivalformlist());
		this.formListMap.put("收款单", this.uncheck.getReceivablelist());
		this.formListMap.put("派件单", this.uncheck.getSendformlist());
		this.formListMap.put("中转中心到达单", this.uncheck.getReceivinglist());
		this.formListMap.put("入库单", this.uncheck.getInrepositorylist());
		this.formListMap.put("中转单", this.uncheck.getTransferringlist());
		this.formListMap.put("出库单", this.uncheck.getOutrepositorylist());
		this.formListMap.put("付款单", this.uncheck.getPaymentlist());
	}
	
	private void addTypeItem() {
		this.typeText.addItem("寄件单");
		this.typeText.addItem("装车单");
		this.typeText.addItem("营业厅到达单");
		this.typeText.addItem("收款单");
		this.typeText.addItem("派件单");
		this.typeText.addItem("中转中心到达单");
		this.typeText.addItem("入库单");
		this.typeText.addItem("中转单");
		this.typeText.addItem("出库单");
		this.typeText.addItem("付款单");
	}
	
	private void initTableName() {
		//寄件单列名
		Object[] order = new Object[] {
				"建单日期", "订单条形码号", "快递类型", "包装类型", "运费", "预估时间"
		};
		this.tableNameMap.put("寄件单", order);
		//装车单列名
		Object[] entrucking = new Object[] {
				"装车日期", "营业厅编号", "汽运编号", "到达地", "车辆代号", "监装员", "押运员", "运费"
		};
		
		this.tableNameMap.put("装车单", entrucking);
		//营业厅到达单列名
		Object[] arrival = new Object[] {
				"到达日期", "中转单编号", "出发地", "货物到达状态"
		};
		this.tableNameMap.put("营业厅到达单", arrival);
		//收款单列名
		Object[] receivable = new Object[] {
				"收款日期", "营业厅编号", "收款金额", "收款快递员"
		};
		this.tableNameMap.put("收款单", receivable);
		//派件单列名
		Object[] send = new Object[] {
				"到达日期", "订单条形码号", "派送员"
		};
		this.tableNameMap.put("派件单", send);
		//中转中心到达单列名
		Object[] receiving = new Object[] {
				"到达日期", "中转单编号", "本中转中心编号", "出发地", "到达地", "货物到达状态"
		};
		this.tableNameMap.put("中转中心到达单", receiving);
		//入库单列名
		Object[] in = new Object[] {
				"入库日期", "快递编号", "目的地", "区号", "排号", "架号", "位号"
		};
		this.tableNameMap.put("入库单", in);
		//中转单列名
		Object[] transferring = new Object[] {
				"装车日期", "中转单编号", "装运方式编号", "运送方式", "出发地", "目的地", "监装员", "货柜号"
		};
		this.tableNameMap.put("中转单", transferring);
		//出库单列名
		Object[] out = new Object[] {
				"出库日期", "快递编号", "目的地", "装运方式", "装运信息编号"
		};
		this.tableNameMap.put("出库单", out);
		//付款单列名
		Object[] payment = new Object[] {
				"付款日期", "付款金额", "付款人", "付款账户", "条目", "备注"
		};
		this.tableNameMap.put("付款单", payment);
	}
	
	private void setTable(String formType) {
		//单据表格
		//列名
		Object[] names = this.tableNameMap.get(formType);
		String[] date = this.getDate(formType);
		int dateLen = date.length;
		int formNum = dateLen < ROW_NUM ? ROW_NUM : dateLen;
		//数据
		Object[][] datas = this.getTableData(formType, this.formListMap.get(formType));
		form = new JTable(datas, names);
		//表格容器
		formContainer.setBounds(START_X >> 1, typeLabel.getY() + (LABEL_H << 1),
				TABLE_W, TABLE_H - 7);
		form.setRowHeight(TABLE_H / (formNum + 1));
		form.setFont(WORD_FONT);
		formContainer.setViewportView(form);
	}
	
	@SuppressWarnings("unchecked")
	private Object[][] getTableData(String formType, ArrayList<? extends ApprovalFormVO> list) {
		switch(formType) {
		case "寄件单":
			return this.getOrderData((ArrayList<OrderVO>)list);
		case "装车单":
			return this.getEntruckingData((ArrayList<EntruckingVO>) list);
		case "营业厅到达单":
			return this.getArrivalData((ArrayList<ArrivalFormVO>) list);
		case "收款单":
			return this.getReceivableData((ArrayList<ReceivableVO>) list);
		case "派件单":
			return this.getSendData((ArrayList<SendFormVO>) list);
		case "中转中心到达单":
			return this.getReceivingData((ArrayList<ReceivingVO>) list);
		case "入库单":
			return this.getInRepositoryData((ArrayList<InRepositoryVO>) list);
		case "中转单":
			return this.getTransferringData((ArrayList<TransferringVO>) list);
		case "出库单":
			return this.getOutRepositoryData((ArrayList<OutRepositoryVO>) list);
		case "付款单":
			return this.getPaymentData((ArrayList<PaymentVO>) list);
		}
		return new Object[1][ROW_NUM];
	}
	
	private Object[][] getOrderData(ArrayList<OrderVO> list) {
		int size = list.size();
		int rowNum = this.calculateRowNumber(list);
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
		return data;
	}
	
	private Object[][] getEntruckingData(ArrayList<EntruckingVO> list) {
		int size = list.size();
		int rowNum = this.calculateRowNumber(list);
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
		return data;
	}
	
	private Object[][] getArrivalData(ArrayList<ArrivalFormVO> list) {
		int size = list.size();
		int rowNum = this.calculateRowNumber(list);
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
		
		return data;
	}
	
	private Object[][] getReceivableData(ArrayList<ReceivableVO> list) {
		int size = list.size();
		int rowNum = this.calculateRowNumber(list);
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
		return data;
	}
	
	private Object[][] getReceivingData(ArrayList<ReceivingVO> list) {
		int size = list.size();
		int rowNum = this.calculateRowNumber(list);
		Object[][] data = new Object[rowNum][6];
		ReceivingVO vo = null;
		for(int i = 0; i < size; i++) {
			vo = list.get(i);
			//"到达日期", "中转单编号", "本中转中心编号", "出发地", "到达地", "货物到达状态"
			data[i][0] = vo.getDate();
			data[i][1] = vo.gettransferringid();
			data[i][2] = vo.gettransitionid();
			data[i][3] = vo.getdepartureid();
			data[i][4] = vo.getarrivalid();
			data[i][5] = vo.getstate();
		}
		return data;
	}
	
	private Object[][] getSendData(ArrayList<SendFormVO> list) {
		int size = list.size();
		int rowNum = this.calculateRowNumber(list);
		Object[][] data = new Object[rowNum][3];
		SendFormVO vo = null;
		for(int i = 0; i < size; i++) {
			vo = list.get(i);
			//"到达日期", "订单条形码号", "派送员"
			data[i][0] = vo.getDate();
			data[i][1] = vo.getDeliveryid();
			data[i][2] = vo.getSender();
		}
		return data;
	}
	
	private Object[][] getInRepositoryData(ArrayList<InRepositoryVO> list) {
		int size = list.size();
		int rowNum = this.calculateRowNumber(list);
		Object[][] data = new Object[rowNum][7];
		InRepositoryVO vo = null;
		for(int i = 0; i < size; i++) {
			vo = list.get(i);
			//"入库日期", "快递编号", "目的地", "区号", "排号", "架号", "位号"
			data[i][0] = vo.getDate();
			data[i][1] = vo.getdeliveryid();
			data[i][2] = vo.getarrivalid();
			data[i][3] = vo.getAreaCodeString();
			data[i][4] = vo.getrowid();
			data[i][5] = vo.getshelfid();
			data[i][6] = vo.getposid();
		}
		return data;
	}
	
	private Object[][] getTransferringData(ArrayList<TransferringVO> list) {
		int size = list.size();
		int rowNum = this.calculateRowNumber(list);
		Object[][] data = new Object[rowNum][8];
		TransferringVO vo = null;
		for(int i = 0; i < size; i++) {
			vo = list.get(i);
			//"装车日期", "中转单编号", "装运方式编号", "运送方式", "出发地", "目的地", "监装员", "货柜号"
			data[i][0] = vo.getDate();
			data[i][1] = vo.gettransferringid();
			data[i][2] = vo.getwayid();
			data[i][3] = vo.getLoadingTypeString();
			data[i][4] = vo.getdepartureid();
			data[i][5] = vo.getarrivalid();
			data[i][6] = vo.getsupervisionid();
			data[i][7] = vo.getcontainerid();
		}
		return data;
	}
	
	private Object[][] getOutRepositoryData(ArrayList<OutRepositoryVO> list) {
		int size = list.size();
		int rowNum = this.calculateRowNumber(list);
		Object[][] data = new Object[rowNum][5];
		OutRepositoryVO vo = null;
		for(int i = 0; i < size; i++) {
			vo = list.get(i);
			//"出库日期", "快递编号", "目的地", "装运方式", "装运信息编号"
			data[i][0] = vo.getDate();
			data[i][1] = vo.getdeliveryid();
			data[i][2] = vo.getarrivalid();
			data[i][3] = vo.getWayString();
			data[i][4] = vo.getloadingid();
		}
		return data;
	}
	
	private Object[][] getPaymentData(ArrayList<PaymentVO> list) {
		int size = list.size();
		int rowNum = this.calculateRowNumber(list);
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
		return data;
	}
	
	private int calculateRowNumber(ArrayList<? extends ApprovalFormVO> list) {
		int size = list.size();
		int rowNum = size < ROW_NUM ? ROW_NUM : size;
		return rowNum;
	}
	
	private String[] getDate(String type) {
		ArrayList<? extends ApprovalFormVO> form = this.formListMap.get(type);
		int size = form.size();
		String[] date = new String[size];
		for(int i = 0; i < size; i++) {
			date[i] = form.get(i).getDate();
		}
		return date;
	}
	
}
