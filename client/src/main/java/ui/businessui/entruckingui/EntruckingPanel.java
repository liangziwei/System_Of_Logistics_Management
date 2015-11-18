package ui.businessui.entruckingui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ui.baseui.DetailPanel;

public class EntruckingPanel extends DetailPanel{
	private JLabel date=new JLabel("装车日期");
	private JLabel businessHallid=new JLabel("营业厅编号");
	private JLabel transportNumber=new JLabel("汽运编号");
	private JLabel destionation=new JLabel("到达地");
	private JLabel vehicleid=new JLabel("车辆代号");
	private JLabel supervisor=new JLabel("监装员");//监装员
	private JLabel supercargo=new JLabel("押运员");//押运员
	private JLabel freight=new JLabel("运费");//运费
	

	private JTextField dateText=new JTextField();
	private JTextField businessHallidText=new JTextField();
	private JTextField transportNumberText=new JTextField();
	private JTextField destionationText=new JTextField();
	private JTextField vehicleidText=new JTextField();
	private JTextField supervisorText=new JTextField();//监装员
	private JTextField supercargoText=new JTextField();//押运员
	private JTextField freightText=new JTextField();//运费
	
	private JButton ok = new JButton("确定");
	
	private JButton cancel = new JButton("取消");
	
	private static final int LABEL_W = 100;
	
	private static final int LABEL_H = 30;
	
	/**
	 * 每行信息之间的间隔
	 */
	private static final int LINE_GAP = 20;
	
	private static final int TEXT_W = LABEL_W << 1;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int START_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W) >> 3;
	
	private static final int START_Y = START_X;
	
	private static final int BUTTON_W = LABEL_W;
	
	private static final int BUTTON_H = LABEL_H;
	
	private static final Font WORD_FONT = new Font("宋体", Font.PLAIN, 18);
	
	private boolean isFirstEnsure = true;
	
	public EntruckingPanel(){
		this.date.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.date.setFont(WORD_FONT);	
		this.dateText.setBounds(START_X + LABEL_W + LINE_GAP, START_Y, TEXT_W, TEXT_H);
		this.dateText.setFont(WORD_FONT);
		
		this.businessHallid.setBounds(START_X, START_Y + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.businessHallid.setFont(WORD_FONT);
		this.businessHallidText.setBounds(this.dateText.getX(), this.businessHallid.getY(), TEXT_W, TEXT_H);
		this.businessHallidText.setFont(WORD_FONT);
		
		this.transportNumber.setBounds(START_X, this.businessHallid.getY() + LABEL_H + LINE_GAP,
				LABEL_W , LABEL_H);
		this.transportNumber.setFont(WORD_FONT);
		this.transportNumberText.setBounds(this.dateText.getX(), this.transportNumber.getY(), TEXT_W, TEXT_H);
		this.transportNumberText.setFont(WORD_FONT);
		
		this.destionation.setBounds(START_X, this.transportNumber.getY() + LABEL_H + LINE_GAP,
				LABEL_W , LABEL_H);
		this.destionation.setFont(WORD_FONT);
		this.destionationText.setBounds(this.dateText.getX(), this.destionation.getY(), TEXT_W, TEXT_H);
		this.destionationText.setFont(WORD_FONT);
		
		this.vehicleid.setBounds(START_X, this.destionation.getY() + LABEL_H + LINE_GAP,
				LABEL_W , LABEL_H);
		this.vehicleid.setFont(WORD_FONT);
		this.vehicleidText.setBounds(this.dateText.getX(), this.vehicleid.getY(), TEXT_W, TEXT_H);
		this.vehicleidText.setFont(WORD_FONT);
		
		this.supervisor.setBounds(START_X, this.vehicleid.getY() + LABEL_H + LINE_GAP,
				LABEL_W , LABEL_H);
		this.supervisor.setFont(WORD_FONT);
		this.supervisorText.setBounds(this.dateText.getX(), this.supervisor.getY(), TEXT_W, TEXT_H);
		this.supervisorText.setFont(WORD_FONT);
		
		this.supercargo.setBounds(START_X, this.supervisor.getY() + LABEL_H + LINE_GAP,
				LABEL_W , LABEL_H);
		this.supercargo.setFont(WORD_FONT);
		this.supercargoText.setBounds(this.dateText.getX(), this.supercargo.getY(), TEXT_W, TEXT_H);
		this.supercargoText.setFont(WORD_FONT);
		
		this.freight.setBounds(START_X, this.supervisor.getY() + LABEL_H + LINE_GAP,
				LABEL_W , LABEL_H);
		this.freight.setFont(WORD_FONT);
		this.freightText.setBounds(this.dateText.getX(), this.freight.getY(), TEXT_W, TEXT_H);
		this.freightText.setFont(WORD_FONT);
		this.freightText.setText("600");
		
		//确定按钮
		this.ok.setBounds(this.freight.getX() + TEXT_W, this.freight.getY() + LABEL_H + LINE_GAP,
				BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + BUTTON_W + LINE_GAP, this.ok.getY(), BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		this.cancel.setVisible(false);
		//错误提示
		//添加事件监听
		this.addListener();
		//将组件添加到主面板
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
		this.add(businessHallid);
		this.add(businessHallidText);
		this.add(destionation);
		this.add(destionationText);
		this.add(transportNumber);
		this.add(transportNumberText);
		this.add(supercargo);
		this.add(supercargoText);
		this.add(supervisor);
		this.add(supervisorText);
		this.add(freight);
		this.add(freightText);
		this.add(vehicleid);
		this.add(vehicleidText);
	}
}
