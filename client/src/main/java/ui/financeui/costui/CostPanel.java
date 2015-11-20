package ui.financeui.costui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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
	
	private JLabel noteLabel = new JLabel("租金年份");
	
	private JTextField noteText = new JTextField();
	
	private JButton ok = new JButton("确定");
	
	private JButton cancel = new JButton("取消");
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 12);
	
	private static final int LABEL_W = 60;
	
	private static final int LABEL_H = 35;
	
	private static final int TEXT_W = LABEL_W * 3;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int BUTTON_W = 80;
	
	private static final int BUTTON_H = 30;
	
	/**
	 * 标签与文本框之间的距离
	 */
	private static final int LT_GAP = 96;
	
	private static final int START_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W - LT_GAP) >> 1;
	
	private static final int START_Y = (DETAIL_PANEL_H - (LABEL_H << 3) - BUTTON_H) / 9;
	
	public CostPanel() {
		//初始化界面
		this.initUI();
		//增加下拉框选项
		this.addItem();
		//增加事件监听
		this.addListener();
	}
	
	private void initUI() {
		int gap = LABEL_H + START_Y;
		//付款日期标签
		this.dateLabel.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.dateLabel.setFont(WORD_FONT);
		//付款日期文本框
		this.dateText.setPanelBound(this.dateLabel.getX() + LABEL_W + LT_GAP, this.dateLabel.getY(), TEXT_W, TEXT_H);
		this.dateText.setFont(WORD_FONT);
		this.dateText.setDate();
		//付款金额标签
		this.moneyLabel.setBounds(this.dateLabel.getX(), this.dateLabel.getY() + gap, LABEL_W, LABEL_H);
		this.moneyLabel.setFont(WORD_FONT);
		//付款金额文本框
		this.moneyText.setBounds(this.dateText.getX(), this.moneyLabel.getY(), TEXT_W, TEXT_H);
		this.moneyText.setFont(WORD_FONT);
		//付款人标签
		this.nameLabel.setBounds(this.moneyLabel.getX(), this.moneyLabel.getY() + gap, LABEL_W, LABEL_H);
		this.nameLabel.setFont(WORD_FONT);
		//付款人文本框
		this.nameText.setBounds(this.moneyText.getX(), this.nameLabel.getY(), TEXT_W, TEXT_H);
		this.nameText.setFont(WORD_FONT);
		//付款账户标签
		this.accountLabel.setBounds(this.nameLabel.getX(), this.nameLabel.getY() + gap, LABEL_W, LABEL_H);
		this.accountLabel.setFont(WORD_FONT);
		//付款账户文本框
		this.accountText.setBounds(this.nameText.getX(), this.accountLabel.getY(), TEXT_W, TEXT_H);
		this.accountText.setFont(WORD_FONT);
		//条目标签
		this.itemLabel.setBounds(this.accountLabel.getX(), this.accountLabel.getY() + gap, LABEL_W, LABEL_H);
		this.itemLabel.setFont(WORD_FONT);
		//条目文本框
		this.itemText.setBounds(this.accountText.getX(), this.itemLabel.getY(), TEXT_W, TEXT_H);
		this.itemText.setFont(WORD_FONT);
		//备注标签
		this.noteLabel.setBounds(this.itemLabel.getX(), this.itemLabel.getY() + gap, LABEL_W, LABEL_H);
		this.noteLabel.setFont(WORD_FONT);
		//备注文本框
		this.noteText.setBounds(this.itemText.getX(), this.noteLabel.getY(), TEXT_W, TEXT_H);
		this.noteText.setFont(WORD_FONT);
		//确定按钮
		this.ok.setBounds(this.noteText.getX() + (TEXT_W >> 1), this.noteText.getY() + TEXT_H + gap
				, BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + (BUTTON_W * 3 >> 1), this.ok.getY(), BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		//将按钮添加到面板
		this.setLayout(null);
		this.add(this.dateLabel);
		this.add(this.dateText);
		this.add(this.moneyLabel);
		this.add(this.moneyText);
		this.add(this.nameLabel);
		this.add(this.nameText);
		this.add(this.accountLabel);
		this.add(this.accountText);
		this.add(this.itemLabel);
		this.add(this.itemText);
		this.add(this.noteLabel);
		this.add(this.noteText);
		this.add(this.ok);
		this.add(this.cancel);
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
		//付款条目
		itemText.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				int selected = itemText.getSelectedIndex();
				switch(selected) {
				case 0:
					noteLabel.setText("租金年份");
					break;
				case 1:
					noteLabel.setText("运单号");
					break;
				case 2:
					noteLabel.setText("月份");
					break;
				case 3:
					noteLabel.setText("备注");
					break;
				default:
					noteLabel.setText("租金年份");
					break;
				}
			}
		});
	}
}
