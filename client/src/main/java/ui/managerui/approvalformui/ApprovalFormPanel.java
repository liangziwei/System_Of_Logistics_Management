package ui.managerui.approvalformui;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ui.baseui.DetailPanel;

@SuppressWarnings("serial")
public class ApprovalFormPanel extends DetailPanel{
	
	private JLabel typeLabel = new JLabel("单据类型");

	private JComboBox<String> typeText = new JComboBox<String>();
	
	private JTable form = null;
	
	private JScrollPane container = new JScrollPane();
	
	private JButton approveOne = new JButton("通过审批");
	
	private JButton approveMore = new JButton("批量审批");
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 15);
	
	private static final int LABEL_W = DETAIL_PANEL_W / 12;
	
	private static final int LABEL_H = LABEL_W >> 1;
	
	private static final int TEXT_W = LABEL_W * 3;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int TABLE_W = (LABEL_W * 3 >> 1) + TEXT_W;
	
	private static final int TABLE_H = DETAIL_PANEL_H >> 1;
	
	private static final int PANEL_W = DETAIL_PANEL_W >> 1;
	
	private static final int PANEL_H = DETAIL_PANEL_H;
	
	private static final int START_X = ((DETAIL_PANEL_W >> 1) - TABLE_W) >> 1;
	
	private static final int START_Y = START_X >> 1;
	
	public ApprovalFormPanel() {
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
		//审批一张单按钮
		//审批多张单按钮
		//单据详细信息面板
		//把组件添加到主面板
		this.add(this.typeLabel);
		this.add(this.typeText);
	}
	
	private void addTypeItemListener() {
		this.typeText.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				//查询单据信息
				
				if(form != null) form.setVisible(false);
				//创建表格
				Object[] names = new Object[]{"单据编号"};
				
			}
		});
	}
	
	private<T> T findForm(T type) {
		return null;
	}
}
