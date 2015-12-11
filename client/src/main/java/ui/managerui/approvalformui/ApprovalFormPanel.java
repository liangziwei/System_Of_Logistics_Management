package ui.managerui.approvalformui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import businessLogic.businessLogicController.managerController.ApprovalFormController;
import businessLogicService.managerBLService.ApprovalFormBLService;
import dataService.Approvable;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;
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
	
	private UncheckedFormVO uncheck = this.approve.getUncheckedForms();
	
	/**
	 * 单据名称与单据列表的映射
	 */
	private Map<String, ArrayList<? extends Approvable>> formListMap
			= new HashMap<String, ArrayList<? extends Approvable>>();
	
	/**
	 * 单据名称与获得单据方法的映射
	 */
	private static Map<String, Method> TABLE_GETTER_METHOD = new HashMap<String, Method>();
	
	/**
	 * 表格默认列数
	 */
	private static final int ROW_NUM = 10; 
	
	/**
	 *获得待审批单据的表格的构造器
	 */
	private static ApproveTableCreator TABLE_CREATOR = new ApproveTableCreator(ROW_NUM);
	
	/**
	 *初始化单据 名称与获得单据的 方法的映射表
	 */
	static {
		try {
			//订单
			TABLE_GETTER_METHOD.put(TableTypeName.ORDER_NAME,
					TABLE_CREATOR.getClass().getMethod("getOrderTable", new ArrayList<OrderVO>().getClass()));
			//装车单
			TABLE_GETTER_METHOD.put(TableTypeName.ENTRUCKING_NAME, 
					TABLE_CREATOR.getClass().getMethod("getEntruckingTable", new ArrayList<EntruckingVO>().getClass()));
			//收款单
			TABLE_GETTER_METHOD.put(TableTypeName.RECEIVABLE_NAME,
					TABLE_CREATOR.getClass().getMethod("getReceivableTable", new ArrayList<ReceivableVO>().getClass()));
			//营业厅到达单
			TABLE_GETTER_METHOD.put(TableTypeName.ARRIVAL_NAME, 
					TABLE_CREATOR.getClass().getMethod("getArrivalTable", new ArrayList<ArrivalFormVO>().getClass()));
			//派送单
			TABLE_GETTER_METHOD.put(TableTypeName.SEND_NAME,
					TABLE_CREATOR.getClass().getMethod("getSendTable", new ArrayList<SendFormVO>().getClass()));
			//中转中心到达单
			TABLE_GETTER_METHOD.put(TableTypeName.RECEIVING_NAME,
					TABLE_CREATOR.getClass().getMethod("getReceivingTable", new ArrayList<ReceivingVO>().getClass()));
			//入库单
			TABLE_GETTER_METHOD.put(TableTypeName.IN_NAME,
					TABLE_CREATOR.getClass().getMethod("getInRepositoryTable", new ArrayList<InRepositoryVO>().getClass()));
			//中转单
			TABLE_GETTER_METHOD.put(TableTypeName.TRANSFERRING_NAME,
					TABLE_CREATOR.getClass().getMethod("getTransferringTable", new ArrayList<TransferringVO>().getClass()));
			//出库单
			TABLE_GETTER_METHOD.put(TableTypeName.OUT_NAME,
					TABLE_CREATOR.getClass().getMethod("getOutRepositoryTable", new ArrayList<OutRepositoryVO>().getClass()));
			//付款单
			TABLE_GETTER_METHOD.put(TableTypeName.PAYMENT_NAME,
					TABLE_CREATOR.getClass().getMethod("getPaymentTable", new ArrayList<PaymentVO>().getClass()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//组件
	private JLabel typeLabel = new JLabel("单据类型");

	private JComboBox<String> typeText = new JComboBox<String>();

	private JScrollPane formContainer = new JScrollPane();

	private JTable form = null;

	private LimpidButton approveOne = new LimpidButton("","picture/通过审批.png");

	private LimpidButton approveMore = new LimpidButton("","picture/批量审批.png");

	private JLabel tip = new JLabel();
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 12);
	
	//常量
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
	
	public ApprovalFormPanel() {
		//初始化单据名字-数据VO列表的映射表
		this.initFormListMap();
		//初始化界面
		this.initUI();
	}
	
	/**
	 * 初始化单据名字-数据VO列表的映射表
	 */
	private void initFormListMap() {
		//寄件单
		this.formListMap.put(TableTypeName.ORDER_NAME, this.uncheck.getOrderlist());
		//装车单
		this.formListMap.put(TableTypeName.ENTRUCKING_NAME, this.uncheck.getEntruckinglist());
		//营业厅到达单
		this.formListMap.put(TableTypeName.ARRIVAL_NAME, this.uncheck.getArrivalformlist());
		//收款单
		this.formListMap.put(TableTypeName.RECEIVABLE_NAME, this.uncheck.getReceivablelist());
		//派件单
		this.formListMap.put(TableTypeName.SEND_NAME, this.uncheck.getSendformlist());
		//中转中心到达单
		this.formListMap.put(TableTypeName.RECEIVING_NAME, this.uncheck.getReceivinglist());
		//入库单
		this.formListMap.put(TableTypeName.IN_NAME, this.uncheck.getInrepositorylist());
		//中转单
		this.formListMap.put(TableTypeName.TRANSFERRING_NAME, this.uncheck.getTransferringlist());
		//出库单
		this.formListMap.put(TableTypeName.OUT_NAME, this.uncheck.getOutrepositorylist());
		//付款单
		this.formListMap.put(TableTypeName.PAYMENT_NAME, this.uncheck.getPaymentlist());
	}
	
	/**
	 * 初始化界面
	 */
	private void initUI() {
		//类型标签
		this.typeLabel.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.typeLabel.setFont(WORD_FONT);
		//类型文本
		this.typeText.setBounds(this.typeLabel.getX() + (LABEL_W * 3 >> 1), this.typeLabel.getY(),
				TEXT_W, TEXT_H);
		this.typeText.setFont(WORD_FONT);
		this.addTypeItem();    //增加单据类型选项
		this.addTypeItemListener();			
		//单据表格
		this.initTableUI("寄件单");
		//审批一张单按钮
		this.approveOne.setBounds(this.typeLabel.getX(), this.formContainer.getY() +
				this.formContainer.getHeight() + (LABEL_H * 3 >> 1), BUTTON_W, BUTTON_H);
		this.approveOne.setFont(WORD_FONT);
		this.addApproveOneListener();
		//审批多张单按钮
		this.approveMore.setBounds(this.approveOne.getX() + (int)(BUTTON_W * 2.5),
				this.approveOne.getY(), BUTTON_W, BUTTON_H);
		this.approveMore.setFont(WORD_FONT);
		this.addApproveMoreListener();;
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
	
	/**
	 * 增加单据类型选项
	 */
	private void addTypeItem() {
		//寄件单
		this.typeText.addItem(TableTypeName.ORDER_NAME);
		//装车单
		this.typeText.addItem(TableTypeName.ENTRUCKING_NAME);
		//营业厅到达单
		this.typeText.addItem(TableTypeName.ARRIVAL_NAME);
		//收款单
		this.typeText.addItem(TableTypeName.RECEIVABLE_NAME);
		//派件单
		this.typeText.addItem(TableTypeName.SEND_NAME);
		//中转中心到达单
		this.typeText.addItem(TableTypeName.RECEIVING_NAME);
		//入库单
		this.typeText.addItem(TableTypeName.IN_NAME);
		//中转单
		this.typeText.addItem(TableTypeName.TRANSFERRING_NAME);
		//出库单
		this.typeText.addItem(TableTypeName.OUT_NAME);
		//付款单
		this.typeText.addItem(TableTypeName.PAYMENT_NAME);
	}
	
	/**
	 *添加对单据下拉选项 的监听
	 */
	private void addTypeItemListener() {
		this.typeText.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(form != null) form.setVisible(false);
				//根据用户的选择的表格类型获得相应单据的编号
				initTableUI((String)typeText.getSelectedItem());				
				//刷新面板
				repaint();
			}
		});
	}
	
	/**
	 * 初始化单据表格界面
	 * @param formType, 要展示的表格类型
	 */
	private void initTableUI(String formType) {
		//根据单据名称获得对应单据VO列表
		ArrayList<? extends Approvable> vo = formListMap.get(formType);
		int size = vo.size();
		int formNum = size < ROW_NUM ? ROW_NUM : size;
		try {
			//根据单据名称获得单据表格
			form = (JTable) TABLE_GETTER_METHOD.get(formType).invoke(TABLE_CREATOR, formListMap.get(formType));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//表格容器
		formContainer.setBounds(START_X >> 1, typeLabel.getY() + (LABEL_H << 1),
				TABLE_W, TABLE_H - 7);
		form.setRowHeight(TABLE_H / (formNum + 1));
		form.setFont(WORD_FONT);
		formContainer.setViewportView(form);
	}
	
	/**
	 * 添加对审批一张单据按钮的监听
	 */
	private void addApproveOneListener() {
		this.approveOne.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String type = (String)typeText.getSelectedItem();
				ArrayList<? extends Approvable> selectedForm = formListMap.get(type);//当前要审批的单据列表
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
				initTableUI(type);
				repaint();
			}
		});
	}
	
	/**
	 * 添加对审批多张单据按钮的监听
	 */
	private void addApproveMoreListener() {
		this.approveMore.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				tip.setText("");
				String type = (String)typeText.getSelectedItem();
				ArrayList<? extends Approvable> selectedForm = formListMap.get(type);//当前要审批的单据列表
				//更新单据审批状态
				approve.approveMoreForm((ArrayList<Approvable>) selectedForm, type);
				//更新单据列表的显示
				formListMap.get(type).clear();;
				initTableUI(type);
				repaint();
			}
		});
	}
}
