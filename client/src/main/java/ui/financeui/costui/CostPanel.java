package ui.financeui.costui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ui.baseui.DatePanel;
import ui.baseui.DetailPanel;

@SuppressWarnings("serial")
public class CostPanel extends DetailPanel{

	private JLabel dateLabel = new JLabel("付款日期");
	
	private DatePanel dateText = new DatePanel();
	
	private JLabel moneyLabel = new JLabel("付款金额");
	
	private JTextField moneyText = new JTextField();
	
	private JLabel nameLabel = new JLabel("付款人");
	
	private JTextField nameText = new JTextField();
	
	private JLabel accountLabel = new JLabel("付款账户");
	
	private JTextField accountText = new JTextField();
	
	private JLabel itemLabel = new JLabel("条目");
	
	private JComboBox<String> itemText = new JComboBox<String>();
	
	private JLabel noteLabel = new JLabel("备注");
	
	private JTextField noteText = new JTextField();
	
	private JButton ok = new JButton("确定");
	
	private JButton cancel = new JButton("取消");
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 12);
	
	private static final int LABEL_W = 0;
	
	private static final int LABEL_H = 0;
	
	private static final int TEXT_W = 0;
	
	private static final int TEXT_H = 0;
	
	private static final int BUTTON_W = 0;
	
	private static final int BUTTON_H = 0;
	
	private static final int START_X = 0;
	
	private static final int START_Y = 0;
	
	public CostPanel() {
		//初始化界面
		this.initUI();
		//增加下拉框选项
		this.addItem();
		//增加事件监听
		this.addListener();
	}
	
	private void initUI() {
		//付款日期标签
		this.dateLabel.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.dateLabel.setFont(WORD_FONT);
		//付款日期文本框
		this.dateText.setFont(WORD_FONT);
		//付款金额标签
		this.moneyLabel.setFont(WORD_FONT);
		//付款金额文本框
		this.moneyText.setFont(WORD_FONT);
		//付款人标签
		this.nameLabel.setFont(WORD_FONT);
		//付款人文本框
		this.nameText.setFont(WORD_FONT);
		//付款账户标签
		this.accountLabel.setFont(WORD_FONT);
		//付款账户文本框
		this.accountText.setFont(WORD_FONT);
		//条目标签
		this.itemLabel.setFont(WORD_FONT);
		//条目文本框
		this.itemText.setFont(WORD_FONT);
		//备注标签
		this.noteLabel.setFont(WORD_FONT);
		//备注文本框
		this.noteText.setFont(WORD_FONT);
		//确定按钮
		
	}
	
	private void addItem() {
		this.itemText.addItem("租金（按年收）");
		this.itemText.addItem("运费（按次计算）");
		this.itemText.addItem("人员工资（按月统计）");
		this.itemText.addItem("奖励（一次性）");
	}
	
	private void addListener() {
		//确定按钮
		this.ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		//取消按钮
		this.cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
