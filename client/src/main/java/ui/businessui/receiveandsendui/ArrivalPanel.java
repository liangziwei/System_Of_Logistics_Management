package ui.businessui.receiveandsendui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ui.baseui.DetailPanel;

public class ArrivalPanel extends DetailPanel {

	private JLabel date=new JLabel("到达日期");
	private JLabel transitNumber=new JLabel("中转单编号");
	private JLabel departPlace=new JLabel("出发地");
	private JLabel state=new JLabel("货物到达状态");
	
	private JTextField dateText=new JTextField();
	private JTextField transitNumberText=new JTextField();
	private JTextField departPlaceText=new JTextField();
	private JComboBox stateBox = new JComboBox();
	
	private JButton ok = new JButton("确定");
	
	private JButton cancel = new JButton("取消");
	
	private static final int LABEL_W = 120;
	
	private static final int LABEL_H = 25;

	private static final int LINE_GAP = 18;
	
	private static final int TEXT_W = LABEL_W *3;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int START_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W) / 3;
	
	private static final int START_Y = START_X;
	
	private static final int BUTTON_W = LABEL_W;
	
	private static final int BUTTON_H = LABEL_H;
	
	private static final Font WORD_FONT = new Font("宋体", Font.PLAIN, 18);
	
	private boolean isFirstEnsure = true;
	
	
	public ArrivalPanel(){
		this.date.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.date.setFont(WORD_FONT);	
		this.dateText.setBounds(START_X + LABEL_W + LINE_GAP, START_Y, TEXT_W, TEXT_H);
		this.dateText.setFont(WORD_FONT);
		
		this.transitNumber.setBounds(START_X, START_Y + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.transitNumber.setFont(WORD_FONT);
		this.transitNumberText.setBounds(this.dateText.getX(), this.transitNumber.getY(), TEXT_W, TEXT_H);
		this.transitNumberText.setFont(WORD_FONT);
		
		this.departPlace.setBounds(START_X, this.transitNumber.getY() + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.departPlace.setFont(WORD_FONT);
		this.departPlaceText.setBounds(this.dateText.getX(), this.departPlace.getY(), TEXT_W, TEXT_H);
		this.departPlaceText.setFont(WORD_FONT);
		
		this.state.setBounds(START_X, this.departPlace.getY() + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.state.setFont(WORD_FONT);
		this.stateBox.setBounds(this.dateText.getX(), this.state.getY(), LABEL_W, TEXT_H);
		this.stateBox.setModel(new DefaultComboBoxModel(new String[] {"完整", "损坏", "丢失"}));
		this.stateBox.setFont(WORD_FONT);
		
		this.ok.setBounds(this.state.getX() + TEXT_W, this.state.getY() + LABEL_H*5+ LINE_GAP,
				BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + BUTTON_W + LINE_GAP, this.ok.getY(), BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		this.cancel.setVisible(false);
		
		
		this.addListener();
		this.addComponents();
		
	}
	
	private void addListener(){

		this.ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//验证收件信息是否合法
				
			}
		});
		
		//取消按钮
		this.cancel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//设置取消按钮不可见
				cancel.setVisible(false);
				//设置状态为第一次点击确定按钮
				isFirstEnsure = true;
				//使组件可编辑
				//消除提示信息
			}
		});
	}
	
	private void addComponents(){
		this.add(date);
		this.add(dateText);
		this.add(transitNumber);
		this.add(transitNumberText);
		this.add(departPlace);
		this.add(departPlaceText);
		this.add(state);
		this.add(stateBox);
		this.add(ok);
		this.add(cancel);
	}
}
