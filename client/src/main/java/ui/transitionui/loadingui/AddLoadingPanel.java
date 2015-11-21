package ui.transitionui.loadingui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import businessLogic.businessLogicController.transitionController.LoadingController;
import businessLogicService.transitionBLService.LoadingBLService;
import constant.LoadingType;
import ui.baseui.DetailPanel;
import vo.transitionVO.LoadingVO;

public class AddLoadingPanel extends DetailPanel{
	private LoadingBLService loadingservice = new LoadingController();
	//添加下拉框
	private JScrollPane jScrollPane =new JScrollPane();
	private JPanel container = new JPanel();
	//组件
	private JLabel loadingid = new JLabel("装运编号");
	
	private JLabel arrivalid = new JLabel("到达地");
	
	private JLabel way = new JLabel("装运方式");
	
	private JLabel wayid = new JLabel("装运方式代号");
	
	private JLabel supervisionid = new JLabel("监装员");
	
	private JLabel supercargoid = new JLabel("押运员");
	
	private JLabel alldeliveryid = new JLabel("本次装箱所有订单条形码号");
	
	private JLabel fare = new JLabel("运费");
	
	private JComboBox<String> wayBox = new JComboBox<String>();
	
	private JTextField loadingidText = new JTextField();
	
	private JTextField arrivalidText = new JTextField();
	
	private JTextField wayidText = new JTextField();
	
	private JTextField supervisionidText = new JTextField();
	
	private JTextField supercargoidText = new JTextField();
	
	private JTextField fareText = new JTextField();
	
	private JTextArea alldeliveryidArea = new JTextArea();
	
	private JPanel infoPanel = new JPanel();
	
	private JPanel buttonPanel = new JPanel();
	
	private JButton ok = new JButton("确定");
	
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
	
	public static final int Area_W = LABEL_W * 7;
	
	public static final int Area_H = LABEL_H * 6;
	
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
	
	/**
	 * 是否为第一次按确认按钮
	 */
	private boolean isFirstEnsure = true;
	
	public AddLoadingPanel() {
		// TODO Auto-generated constructor stub
		super();
		//下拉框设置
		container.setLayout(null);
		container.setPreferredSize(new Dimension(CONTAINER_W, CONTAINER_H));
		jScrollPane.setBounds(0, 0,DETAIL_PANEL_W, DETAIL_PANEL_H);
		jScrollPane.setViewportView(this.container);
		jScrollPane.getVerticalScrollBar().setUnitIncrement(15);
		super.add(jScrollPane);
		
		//主面板
		this.infoPanel.setBounds(START_X,START_Y,this.DETAIL_PANEL_W,START_Y+(LABEL_H+COMPONENT_GAP_Y)*5+Area_H);
		this.infoPanel.setLayout(null);
		//初始化信息面板
		this.initUI();
		//按钮面板
		this.buttonPanel.setBounds(START_X+LABEL_W +COMPONENT_GAP_X+TEXTid_W, infoPanel.getY()+infoPanel.getHeight(),
				(BUTTON_W << 1)+COMPONENT_GAP_Y , BUTTON_H);
				
		this.buttonPanel.setLayout(null);
		//确定按钮
		this.ok.setBounds(0, 0, BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		//取消按钮
		this.cancel.setBounds(BUTTON_W + COMPONENT_GAP_Y, 0, BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		//添加事件监听
		this.addListener();
		//将按钮添加到按钮面板
		this.buttonPanel.setLayout(null);
		this.buttonPanel.add(this.ok);
		this.buttonPanel.add(this.cancel);
		cancel.setVisible(false);
		//状态信息
		this.state.setBounds(START_X, this.buttonPanel.getY() - BUTTON_H, (BUTTON_W<<2), BUTTON_W);
		this.state.setFont(WORD_FONT);
		this.state.setForeground(Color.RED);
		//将信息面板加到主面板
		this.addPanels();
	}
	
	private void initUI(){
		loadingid.setBounds(0, 0, LABEL_W, LABEL_H);
		this.infoPanel.add(loadingid);
		loadingidText.setBounds(loadingid.getX()+LABEL_W+COMPONENT_GAP_X,loadingid.getY() , TEXTid_W, TEXT_H);
		this.infoPanel.add(loadingidText);
		arrivalid.setBounds(loadingid.getX(), loadingid.getY()+LABEL_H+COMPONENT_GAP_Y, LABEL_W, LABEL_H);
		this.infoPanel.add(arrivalid);
		arrivalidText.setBounds(arrivalid.getX()+arrivalid.getWidth()+COMPONENT_GAP_X,arrivalid.getY(),TEXT_W,TEXT_H);
		this.infoPanel.add(arrivalidText);
		way.setBounds(arrivalidText.getX()+arrivalidText.getWidth()+COMPONENT_GAP_X, arrivalid.getY(),LABEL_W, LABEL_H);
		this.infoPanel.add(way);
		wayBox.setBounds(way.getX()+way.getWidth()+COMPONENT_GAP_X, way.getY(), TEXT_W, TEXT_H);
		wayBox.setToolTipText("123");
		wayBox.addItem("飞机");
		wayBox.addItem("火车");
		wayBox.addItem("汽车");
		this.infoPanel.add(wayBox);
		wayid.setBounds(arrivalid.getX(), arrivalid.getY()+LABEL_H+COMPONENT_GAP_Y, LABEL_W, LABEL_H);
		this.infoPanel.add(wayid);
		wayidText.setBounds(wayid.getX()+wayid.getWidth()+COMPONENT_GAP_X, wayid.getY(), TEXTid_W, TEXT_H);
		this.infoPanel.add(wayidText);
		supervisionid.setBounds(wayid.getX(), wayid.getY()+LABEL_H+COMPONENT_GAP_Y, LABEL_W, LABEL_H);
		this.infoPanel.add(supervisionid);
		supervisionidText.setBounds(supervisionid.getX()+supervisionid.getWidth()+COMPONENT_GAP_X, supervisionid.getY(), TEXT_W, TEXT_H);
		this.infoPanel.add(supervisionidText);
		supercargoid.setBounds(supervisionidText.getX()+supervisionidText.getWidth()+COMPONENT_GAP_X, supervisionid.getY(), LABEL_W, LABEL_H);
		this.infoPanel.add(supercargoid);
		supercargoidText.setBounds(supercargoid.getX()+supercargoid.getWidth()+COMPONENT_GAP_X, supercargoid.getY(), TEXT_W, TEXT_H);
		this.infoPanel.add(supercargoidText);
		alldeliveryid.setBounds(supervisionid.getX(), supervisionid.getY()+supervisionid.getHeight()+COMPONENT_GAP_Y, TEXTid_W,LABEL_H);
		this.infoPanel.add(alldeliveryid);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(alldeliveryid.getX(), alldeliveryid.getY()+alldeliveryid.getHeight(), Area_W,Area_H);
		this.infoPanel.add(scrollPane);
		scrollPane.setViewportView(alldeliveryidArea);
		fare.setBounds(scrollPane.getX(), scrollPane.getY()+Area_H+COMPONENT_GAP_Y, LABEL_W, LABEL_H);
		this.infoPanel.add(fare);
		fareText.setBounds(fare.getX()+fare.getWidth()+COMPONENT_GAP_X, fare.getY(), TEXTid_W, TEXT_H);
		fareText.setBackground(Color.GRAY);
		fareText.setEditable(false);
		this.infoPanel.add(fareText);
	
	}
	
	private void addListener(){
		this.ok.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//创建装运单对象
				LoadingVO loadingVO = creatLoadingVO();
				//验证输入是否规范
				boolean result = loadingservice.verify(loadingVO);
				
				if (result) {
					throughVerifyOperation(loadingVO);   //验证成功
					cancel.setVisible(true);
					fare.setForeground(Color.red);
				}
				else {
					verifyFailOperation(loadingVO);   //验证失败
				}
				
				//刷新页面
				repaint();
			}
		});
		
		this.cancel.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//回到第一次点击确定的状态
				isFirstEnsure = true;
				//使提示信息消失
				state.setText("");
				//使信息可编辑
				enableComponents();
				cancel.setVisible(false);
				//重置运费
				fareText.setText("");
				fare.setForeground(Color.black);
			}
		});
	}
	
	private void throughVerifyOperation(LoadingVO loadingVO) {
		//使所有组件不可编辑
		disableComponents();
		//计算运费
		String thefare = loadingservice.loadingFare("南京", loadingVO.getarrivalid())+"";
		//显示运费
		fareText.setText(thefare);
		if(isFirstEnsure) {
			showState("请再次确认信息，无误后按确定，否则按取消");
			isFirstEnsure = false;
		}
		else {
			//添加装运信息
			boolean save =loadingservice.addLoadingFormBL(loadingVO);
			if(save) {		//保存成功
				showState("订单保存成功");
				disableComponents();
			}else {			//TODO 保存失败，说明保存失败的原因或者提出建议
				showState("订单保存失败");
			}
		}
	}
	
	private void verifyFailOperation(LoadingVO loadingVO) {
		//提示修改意见
		showState(loadingVO.geterrorMsg());
	}
	
	private void addPanels() {
		this.container.add(this.infoPanel);
		this.container.add(this.buttonPanel);
		this.container.add(this.state);
	}
	
	private LoadingVO creatLoadingVO(){
		String loadid = loadingidText.getText().trim();
		String arriveid = arrivalidText.getText().trim();
		String Wayid = wayidText.getText().trim();
		String Supervis = supervisionidText.getText().trim();
		String Supercar = supercargoidText.getText().trim();
		String Way = (String) wayBox.getSelectedItem();
		LoadingType way1 = null;
		switch (Way) {
		case "飞机":
			way1 = LoadingType.PLANE;
			break;
		case "火车":
			way1 = LoadingType.TRAIN;
			break;
		case "汽车":
			way1 = LoadingType.TRUCK;
			break;
		}
		String alldeli = alldeliveryidArea.getText();
		String[] alldeli1 = alldeli.split("\n");
		List<String> all = new ArrayList<String>();
		for(String q:alldeli1){
			all.add(q);
		}
		
		LoadingVO loadingVO = new LoadingVO(loadid, arriveid, way1, Wayid, Supervis, Supercar, all);
		return loadingVO;
	}
	private void disableComponents() {
		this.loadingidText.setEditable(false);
		this.arrivalidText.setEditable(false);
		this.wayBox.setEnabled(false);
		this.wayidText.setEditable(false);
		this.supercargoidText.setEditable(false);
		this.supervisionidText.setEditable(false);
		this.alldeliveryidArea.setEditable(false);
	}
	
	private void enableComponents() {
		this.loadingidText.setEditable(true);
		this.arrivalidText.setEditable(true);
		this.wayBox.setEnabled(true);
		this.wayidText.setEditable(true);
		this.supercargoidText.setEditable(true);
		this.supervisionidText.setEditable(true);
		this.alldeliveryidArea.setEditable(true);
	}
	
	private void showState(String msg) {
		this.state.setText(msg);
		this.repaint();
	}
}
