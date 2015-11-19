package ui.financeui.accountui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ui.baseui.DetailPanel;

@SuppressWarnings("serial")
public class InquireAccountPanel extends DetailPanel{

	private JLabel nameLabel = new JLabel("账户名称");
	
	private JTextField nameText = new JTextField();
	
	private JLabel moneyLabel = new JLabel("账户金额");
	
	private JTextField moneyText = new JTextField();
	
	private JButton ok = new JButton("确定");
	
	private JButton cancel = new JButton("取消");
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 20);
	
	private static final int LABEL_W = 100;
	
	private static final int LABEL_H = 40;
	
	private static final int TEXT_W = LABEL_W * 3;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int BUTTON_W = 80;
	
	private static final int BUTTON_H = 30;
	
	private static final int START_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W) / 3;
	
	private static final int START_Y = START_X;
	
	public InquireAccountPanel() {
		//初始化界面
		this.initUI();
		//增加事件监听
		this.addListener();
	}
	
	private void initUI() {
		//账户名称标签
		this.nameLabel.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.nameLabel.setFont(WORD_FONT);
		//账户名称文本框
		this.nameText.setBounds(LABEL_W + (START_X * 3 >> 1), this.nameLabel.getY(), TEXT_W, TEXT_H);
		this.nameText.setFont(WORD_FONT);
		//账户金额标签
		this.moneyLabel.setVisible(false);
		//账户金额文本框
		this.moneyText.setVisible(false);
		//确定按钮
		this.ok.setBounds(this.nameText.getX() + (TEXT_W >> 1), this.nameText.getY() + TEXT_H + (START_Y >> 1),
				BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + (BUTTON_W * 3 >> 1), this.ok.getY(),
				BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		//将按钮添加到面板
		this.setLayout(null);
		this.add(this.nameLabel);
		this.add(this.nameText);
		this.add(this.moneyLabel);
		this.add(this.moneyText);
		this.add(this.ok);
		this.add(this.cancel);
	}
	
	private void addListener() {
		//确定按钮
		this.ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//TODO test
				resetUI();
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
	
	private void resetUI() {
		//账户名称标签
		this.nameLabel.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.nameLabel.setFont(WORD_FONT);
		//账户名称文本框
		this.nameText.setBounds(LABEL_W + (START_X * 3 >> 1), this.nameLabel.getY(), TEXT_W, TEXT_H);
		this.nameText.setFont(WORD_FONT);
		this.nameText.setEditable(false);
		//账户金额标签
		this.moneyLabel.setBounds(this.nameLabel.getX(), this.nameLabel.getY() + LABEL_H + (START_Y >> 1),
				LABEL_W, LABEL_H);
		this.moneyLabel.setFont(WORD_FONT);
		this.moneyLabel.setVisible(true);
		//账户金额文本框
		this.moneyText.setBounds(this.nameText.getX(), this.moneyLabel.getY(), TEXT_W, TEXT_H);
		this.moneyText.setFont(WORD_FONT);
		this.moneyText.setEditable(false);
		this.moneyText.setVisible(true);
		//确定按钮
		this.ok.setBounds(this.moneyText.getX() + (TEXT_W >> 1), this.moneyText.getY() + TEXT_H + (START_Y >> 1),
				BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + (BUTTON_W * 3 >> 1), this.ok.getY(),
				BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
	}
}
