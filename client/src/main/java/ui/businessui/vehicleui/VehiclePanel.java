package ui.businessui.vehicleui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ui.baseui.DetailPanel;

public class VehiclePanel extends DetailPanel{
	
	private JLabel vehicleid=new JLabel("车辆代号");
	private JLabel number=new JLabel("车牌号");
	private JLabel age=new JLabel("服役时间(年)");
	
	private JTextField vehicleidText=new JTextField();
	private JTextField numberText=new JTextField();
	private JTextField ageText=new JTextField();
	
	private JButton query = new JButton("查询");
	
	private JButton ok = new JButton("确定");
	
	private JButton cancel = new JButton("取消");
	
	private static final int LABEL_W = 150;
	
	private static final int LABEL_H = 25;

	private static final int LINE_GAP = 18;
	
	private static final int TEXT_W = LABEL_W *2;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int START_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W) / 3;
	
	private static final int START_Y = START_X;
	
	private static final int BUTTON_W = LABEL_W;
	
	private static final int BUTTON_H = LABEL_H;
	
	private static final Font WORD_FONT = new Font("宋体", Font.PLAIN, 18);
	
	private boolean isFirstEnsure = true;
	
	
	public VehiclePanel(){
		this.vehicleid.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.vehicleid.setFont(WORD_FONT);	
		this.vehicleidText.setBounds(START_X + LABEL_W + LINE_GAP, START_Y, TEXT_W, TEXT_H);
		this.vehicleidText.setFont(WORD_FONT);
		
		this.number.setBounds(START_X, START_Y + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.number.setFont(WORD_FONT);
		this.numberText.setBounds(this.vehicleidText.getX(), this.number.getY(), TEXT_W, TEXT_H);
		this.numberText.setFont(WORD_FONT);
		
		this.age.setBounds(START_X, this.number.getY() + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.age.setFont(WORD_FONT);
		this.ageText.setBounds(this.vehicleidText.getX(), this.age.getY(), TEXT_W>>2, TEXT_H);
		this.ageText.setFont(WORD_FONT);
		
		this.query.setBounds(START_X+TEXT_W+ LABEL_W + LINE_GAP,START_Y,BUTTON_W>>1,BUTTON_H);
		this.query.setFont(WORD_FONT);
		this.ok.setBounds(this.age.getX() + TEXT_W, this.age.getY() + LABEL_H*6+ LINE_GAP,
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

		this.query.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//验证收件信息是否合法
				
			}
		});
		
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
		this.add(vehicleid);
		this.add(vehicleidText);
		this.add(number);
		this.add(numberText);
		this.add(age);
		this.add(ageText);
		this.add(query);
		this.add(ok);
		this.add(cancel);
	}
}
