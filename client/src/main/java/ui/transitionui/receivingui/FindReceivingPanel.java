package ui.transitionui.receivingui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businessLogic.businessLogicController.transitionController.ReceivingController;
import businessLogicService.transitionBLService.ReceivingBLService;
import ui.baseui.DetailPanel;

public class FindReceivingPanel extends DetailPanel{
private ReceivingBLService receivingService = new ReceivingController();
	
	private JLabel transferringid = new JLabel("中转单编号");
	
	private JLabel arrivaldate = new JLabel("到达日期");
	
	private JLabel transitionid = new JLabel("本中转中心编号");
	
	private JLabel departureid = new JLabel("出发地");
	
	private JLabel arrivalid = new JLabel("到达地");
	
	private JLabel statelabel = new JLabel("货物到达状态"); 
	
	private JComboBox<String> endState = new JComboBox<String>();
	
	private JTextField transferringidText = new JTextField();
	
	private JTextField arrivaldateTextyear = new JTextField();
	
	private JTextField arrivaldateTextmonth = new JTextField();
	
	private JTextField arrivaldateTextday = new JTextField();
	
	private JTextField transitionidText = new JTextField();
	
	private JTextField departureidText = new JTextField();
	
	private JTextField arrivalidText = new JTextField();
	
	private JPanel infoPanel = new JPanel();
	
	private JButton find = new JButton("查询");
	
	private JButton cancel = new JButton("取消");
	
	public static Font WORD_FONT = new Font("宋体", Font.PLAIN, 15);
	
	private JLabel state = new JLabel("" ,JLabel.CENTER);
	
	public static final int LABEL_W = 80;
	
	public static final int LABEL_H = 40;
	
	public static final int TEXT_W = LABEL_W << 1;
	
	public static final int TEXT_H = LABEL_H;

	public static final int TEXTid_W = LABEL_W * 4;
	
	public static final int COMPONENT_GAP_X = 20;
	
	public static final int COMPONENT_GAP_Y = COMPONENT_GAP_X << 1;
	
	public static final int BUTTON_W = 80;
	
	private static final int BUTTON_H = 30;
	
	/**
	 *组件开始x坐标 
	 */
	public static final int START_X = (DetailPanel.DETAIL_PANEL_W - ((LABEL_W+TEXT_W+COMPONENT_GAP_X)* 2)) / 3;
	
	/**
	 *组件开始y坐标 
	 */
	public static final int START_Y = START_X;
	
	public FindReceivingPanel() {
		// TODO Auto-generated constructor stub
		super();
		
		transferringid.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.container.add(transferringid);
		transferringidText.setBounds(transferringid.getX()+transferringid.getWidth()+COMPONENT_GAP_X, transferringid.getY(), TEXTid_W, TEXT_H);
		this.container.add(transferringidText);
		find.setBounds(transferringidText.getX()+transferringidText.getWidth()+COMPONENT_GAP_X, transferringid.getY(), BUTTON_W, BUTTON_H);
		this.container.add(find);
		
	}
}
