package ui.managerui.approvalformui;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import businessLogic.businessLogicController.managerController.ApprovalFormController;
import businessLogicService.managerBLService.ApprovalFormBLService;
import ui.baseui.DetailPanel;
import vo.ApprovalFormVO;
import vo.managerVO.UncheckedFormVO;

@SuppressWarnings("serial")
public class ApprovalFormPanel extends DetailPanel{
	
	private ApprovalFormBLService approve = new ApprovalFormController();
	
	private JLabel typeLabel = new JLabel("单据类型");

	private JComboBox<String> typeText = new JComboBox<String>();
	
	private JTable form = null;
	
	private JScrollPane formContainer = new JScrollPane();
	
	private JScrollPane infoContainer = new JScrollPane();
	
	private JButton approveOne = new JButton("通过审批");
	
	private JButton approveMore = new JButton("批量审批");
	
	private UncheckedFormVO uncheck = approve.getUncheckedForms();
	
	/**
	 * 单据名称与单据列表的映射
	 */
	private Map<String, ArrayList<? extends ApprovalFormVO>> formListMap
			= new HashMap<String, ArrayList<? extends ApprovalFormVO>>();
	
	/**
	 * 单据名称与具体单据显示信息面板的映射
	 */
	private Map<String, JPanel> panelMap = new HashMap<String, JPanel>();
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 12);
	
	private static final int LABEL_W = DETAIL_PANEL_W / 12;
	
	private static final int LABEL_H = LABEL_W >> 1;
	
	private static final int TEXT_W = LABEL_W * 3;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int TABLE_W = (LABEL_W * 3 >> 1) + TEXT_W;
	
	private static final int TABLE_H = DETAIL_PANEL_H >> 1;
	
	private static final int BUTTON_W = TABLE_W / 3;
	
	private static final int BUTTON_H = (BUTTON_W >> 1) - 10;
	
	private static final int START_X = ((DETAIL_PANEL_W >> 1) - TABLE_W) >> 1;
	
	private static final int START_Y = START_X >> 1;
	
	private static final int PANEL_W = (DETAIL_PANEL_W >> 1) - (START_X << 1);
	
	private static final int PANEL_H = DETAIL_PANEL_H - 108;
	
	public ApprovalFormPanel() {
		//初始化单据映射表
		this.formListMap.put("寄件单", this.approve.getUncheckedForms().getOrderlist());
		this.formListMap.put("装车单", this.approve.getUncheckedForms().getEntruckinglist());
		this.formListMap.put("营业厅到达单", this.approve.getUncheckedForms().getArrivalformlist());
		this.formListMap.put("收款单", this.approve.getUncheckedForms().getReceivablelist());
		this.formListMap.put("派件单", this.approve.getUncheckedForms().getSendformlist());
		this.formListMap.put("中转中心到达单", this.approve.getUncheckedForms().getReceivinglist());
		this.formListMap.put("入库单", this.approve.getUncheckedForms().getInrepositorylist());
		this.formListMap.put("中转单", this.approve.getUncheckedForms().getTransferringlist());
		this.formListMap.put("出库单", this.approve.getUncheckedForms().getOutrepositorylist());
		this.formListMap.put("付款单", this.approve.getUncheckedForms().getPaymentlist());
		//初始化单据信息面板映射表
//		this.panelMap.put(", value)
		//类型标签
		this.typeLabel.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.typeLabel.setFont(WORD_FONT);
		//类型文本
		this.typeText.setBounds(this.typeLabel.getX() + (LABEL_W * 3 >> 1), this.typeLabel.getY(),
				TEXT_W, TEXT_H);
		this.typeText.setFont(WORD_FONT);
		
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
		
		this.addTypeItemListener();
		//单据表格
		this.setTable("寄件单");
		this.addFormListener();
		//审批一张单按钮
		this.approveOne.setBounds(this.formContainer.getX(), this.formContainer.getY() +
				this.formContainer.getHeight() + (LABEL_H * 3 >> 1), BUTTON_W, BUTTON_H);
		this.approveOne.setFont(WORD_FONT);
		//审批多张单按钮
		this.approveMore.setBounds(this.approveOne.getX() + (BUTTON_W << 1),
				this.approveOne.getY(), BUTTON_W, BUTTON_H);
		this.approveMore.setFont(WORD_FONT);
		//单据详细信息面板
		this.infoContainer.setBounds((DETAIL_PANEL_W >> 1) + 20, this.typeLabel.getY(),
				PANEL_W, PANEL_H);
		//把组件添加到主面板
		this.add(this.typeLabel);
		this.add(this.typeText);
		this.add(this.formContainer);
		this.add(this.approveOne);
		this.add(this.approveMore);
		this.add(this.infoContainer);
	}
	
	private void addFormListener() {
		this.form.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
			    int row = form.getSelectedRow();
			    
			}
		});
	}

	private void setTable(String formType) {
		//单据表格
		String[] date = this.getDate(formType);
		int dateLen = date.length;
		int formNum = dateLen < 10 ? 10 : dateLen;
		Object[][] datas = new Object[formNum][1];
		for(int i = 0; i < dateLen; i++) {
			datas[i][0] = date[i];
		}
		Object[] names = new Object[]{"单据日期"};
		form = new JTable(datas, names);
		//表格容器
		formContainer.setBounds(typeLabel.getX(), typeLabel.getY() + (LABEL_H << 1),
				TABLE_W, TABLE_H - 7);
		form.setRowHeight(TABLE_H / (formNum + 1));
		form.setFont(WORD_FONT);
		formContainer.setViewportView(form);
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
