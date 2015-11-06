package ui.deliveryui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ui.baseui.DatePanel;
import ui.baseui.DetailPanel;

@SuppressWarnings("serial")
public class ReceiptPanel extends DetailPanel{
	
	private JLabel nameLabel = new JLabel("收件人姓名");
	
	private JTextField nameText = new JTextField();
	
	private JLabel idLabel = new JLabel("收件编号");
	
	private JTextField idText = new JTextField();
	
	private JLabel dateLabel = new JLabel("收件日期");

	private DatePanel date = new DatePanel();
	
	private JButton ok = new JButton("确定");
	
	private JButton cancel = new JButton("取消");
	
	private static final int LABEL_W = 100;
	
	private static final int LABEL_H = 40;
	
	/**
	 * 每行信息之间的间隔
	 */
	private static final int LINE_GAP = 60;
	
	private static final int TEXT_W = LABEL_W << 1;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int START_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W) >> 3;
	
	private static final int START_Y = START_X;
	
	private static final int BUTTON_W = LABEL_W;
	
	private static final int BUTTON_H = LABEL_H;
	
	private static final Font WORD_FONT = new Font("宋体", Font.PLAIN, 18);
	
	public ReceiptPanel() {
		//名字标签
		this.nameLabel.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.nameLabel.setFont(WORD_FONT);
		//名字文本框
		this.nameText.setBounds(START_X + LABEL_W + LINE_GAP, START_Y, TEXT_W, TEXT_H);
		this.nameText.setFont(WORD_FONT);
		//收件编号标签
		this.idLabel.setBounds(START_X, START_Y + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.idLabel.setFont(WORD_FONT);
		//收件编号文本框
		this.idText.setBounds(this.nameText.getX(), this.idLabel.getY(), TEXT_W, TEXT_H);
		this.idText.setFont(WORD_FONT);
		//收件日期标签
		this.dateLabel.setBounds(START_X, this.idLabel.getY() + LABEL_H + LINE_GAP,
				LABEL_W , LABEL_H);
		this.dateLabel.setFont(WORD_FONT);
		//收件日期面板
		this.date.setPanelBound(this.nameText.getX(), this.idLabel.getY() + LABEL_H + LINE_GAP,
				TEXT_W << 1, TEXT_H);
		//确定按钮
		this.ok.setBounds(this.date.getX() + TEXT_W, this.date.getY() + LABEL_H + LINE_GAP,
				BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + BUTTON_W + LINE_GAP, this.ok.getY(), BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		//添加事件监听
		this.addListener();
		//将组件添加到主面板
		this.addComponents();
	}
	
	private void addComponents() {
		this.add(this.nameLabel);
		this.add(this.nameText);
		this.add(this.idLabel);
		this.add(this.idText);
		this.add(this.dateLabel);
		this.add(this.date);
		this.add(this.ok);
		this.add(this.cancel);
	}
	
	private void addListener() {
		
		//确定按钮
		this.ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//取消按钮
		this.cancel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
