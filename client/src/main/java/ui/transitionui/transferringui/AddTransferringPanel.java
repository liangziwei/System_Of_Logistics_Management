package ui.transitionui.transferringui;

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

import businessLogic.businessLogicController.transitionController.TransferringController;
import businessLogicService.transitionBLService.TransferringBLService;
import constant.LoadingType;
import ui.baseui.DetailPanel;
import vo.transitionVO.TransferringVO;

public class AddTransferringPanel extends DetailPanel {
	private TransferringBLService transferringBLService = new TransferringController();

	// 添加下拉框
	private JScrollPane jScrollPane = new JScrollPane();
	private JPanel container = new JPanel();
	// 组件
	private JLabel transferringid = new JLabel("中转单编号");
	private JLabel loadingdate = new JLabel("装车日期");
	private JLabel way = new JLabel("运送方式");
	private JLabel loadingwayid = new JLabel("装运方式编号");
	private JLabel departureid = new JLabel("出发地");
	private JLabel arrivalid = new JLabel("目的地");
	private JLabel supervisionid = new JLabel("监装员");
	private JLabel containerid = new JLabel("货柜号");
	private JLabel alldeliveryid = new JLabel("本次装箱所有托运单号");
	private JLabel fare = new JLabel("运费");

	private JTextField transferringidText = new JTextField();
	private JTextField loadingdateTextyear = new JTextField();
	private JTextField loadingdateTextmonth = new JTextField();
	private JTextField loadingdateTextday = new JTextField();
	private JComboBox<String> loadingway = new JComboBox<String>();
	private JTextField loadingwayidText = new JTextField();
	private JTextField departureidText = new JTextField();
	private JTextField arrivalidText = new JTextField();
	private JTextField supervisionidText = new JTextField();
	private JTextField containeridText = new JTextField();
	private JTextField fareText = new JTextField();
	private JTextArea alldeliveryidText = new JTextArea();

	private JPanel infoPanel = new JPanel();

	private JPanel buttonPanel = new JPanel();

	private JButton ok = new JButton("确定");

	private JButton cancel = new JButton("取消");

	public static Font WORD_FONT = new Font("宋体", Font.PLAIN, 15);

	private JLabel state = new JLabel("", JLabel.CENTER);

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
	 * 组件开始x坐标
	 */
	public static final int START_X = (DetailPanel.DETAIL_PANEL_W - ((LABEL_W + TEXT_W + COMPONENT_GAP_X) * 2)) / 3;

	/**
	 * 组件开始y坐标
	 */
	public static final int START_Y = START_X;

	/**
	 * 是否为第一次按确认按钮
	 */
	private boolean isFirstEnsure = true;

	public AddTransferringPanel() {
		// TODO Auto-generated constructor stub
		super();
		// 下拉框设置
		container.setLayout(null);
		container.setPreferredSize(new Dimension(CONTAINER_W, CONTAINER_H));
		jScrollPane.setBounds(0, 0, DETAIL_PANEL_W, DETAIL_PANEL_H);
		jScrollPane.setViewportView(this.container);
		jScrollPane.getVerticalScrollBar().setUnitIncrement(15);
		super.add(jScrollPane);

		// 主面板
		this.infoPanel.setBounds(START_X, START_Y, this.DETAIL_PANEL_W,
				START_Y + (LABEL_H + COMPONENT_GAP_Y) * 6 + Area_H - 40);
		this.infoPanel.setLayout(null);
		// 初始化信息面板
		this.initUI();
		// 按钮面板
		this.buttonPanel.setBounds(START_X + LABEL_W + COMPONENT_GAP_X + TEXTid_W,
				infoPanel.getY() + infoPanel.getHeight(), (BUTTON_W << 1) + COMPONENT_GAP_Y, BUTTON_H);

		this.buttonPanel.setLayout(null);
		// 确定按钮
		this.ok.setBounds(0, 0, BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		// 取消按钮
		this.cancel.setBounds(BUTTON_W + COMPONENT_GAP_Y, 0, BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		// 添加事件监听
		this.addListener();
		// 将按钮添加到按钮面板
		this.buttonPanel.setLayout(null);
		this.buttonPanel.add(this.ok);
		this.buttonPanel.add(this.cancel);
		cancel.setVisible(false);
		// 状态信息
		this.state.setBounds(START_X, this.buttonPanel.getY() - BUTTON_H, (BUTTON_W << 2), BUTTON_W);
		this.state.setFont(WORD_FONT);
		this.state.setForeground(Color.RED);
		// 将信息面板加到主面板
		this.addPanels();
	}

	private void initUI() {
		transferringid.setBounds(0, 0, LABEL_W, LABEL_H);
		this.infoPanel.add(transferringid);
		transferringidText.setBounds(transferringid.getX() + transferringid.getWidth() + COMPONENT_GAP_X,
				transferringid.getY(), TEXTid_W, TEXT_H);
		this.infoPanel.add(transferringidText);
		
		JLabel apart1 = new JLabel("-");
		JLabel apart2 = new JLabel("-");
		loadingdate.setBounds(transferringid.getX(),
				transferringid.getY() + transferringid.getHeight() + COMPONENT_GAP_Y, LABEL_W, LABEL_H);
		this.infoPanel.add(loadingdate);
		loadingdateTextyear.setBounds(loadingdate.getX() + loadingdate.getWidth() + COMPONENT_GAP_X, loadingdate.getY(),
				TEXT_W/3, TEXT_H);
		this.infoPanel.add(loadingdateTextyear);
		apart1.setBounds(loadingdateTextyear.getX()+loadingdateTextyear.getWidth(), loadingdateTextyear.getY(), 10, LABEL_H);
		this.infoPanel.add(apart1);
		loadingdateTextmonth.setBounds(apart1.getX()+apart1.getWidth(),apart1.getY(),TEXT_W/3,TEXT_H);
		this.infoPanel.add(loadingdateTextmonth);
		apart2.setBounds(loadingdateTextmonth.getX()+loadingdateTextmonth.getWidth(),loadingdateTextmonth.getY(),10,LABEL_H);
		this.infoPanel.add(apart2);
		loadingdateTextday.setBounds(apart2.getX()+apart2.getWidth(), apart2.getY(), TEXT_W/3, TEXT_H);
		this.infoPanel.add(loadingdateTextday);
		
		way.setBounds(loadingdateTextday.getX() + loadingdateTextday.getWidth() + COMPONENT_GAP_X, loadingdateTextday.getY(),
				LABEL_W, LABEL_H);
		this.infoPanel.add(way);
		loadingway.setBounds(way.getX() + way.getWidth() + COMPONENT_GAP_X, way.getY(), TEXT_W, TEXT_H);
		this.infoPanel.add(loadingway);
		loadingway.addItem("飞机");
		loadingway.addItem("火车");
		loadingway.addItem("汽车");

		loadingwayid.setBounds(loadingdate.getX(), loadingdate.getY() + loadingdate.getHeight() + COMPONENT_GAP_Y,
				LABEL_W, LABEL_H);
		this.infoPanel.add(loadingwayid);
		loadingwayidText.setBounds(loadingwayid.getX() + loadingwayid.getWidth() + COMPONENT_GAP_X, loadingwayid.getY(),
				TEXTid_W, TEXT_H);
		this.infoPanel.add(loadingwayidText);

		departureid.setBounds(loadingwayid.getX(), loadingwayid.getY() + loadingwayid.getHeight() + COMPONENT_GAP_Y,
				LABEL_W, LABEL_H);
		this.infoPanel.add(departureid);
		departureidText.setBounds(departureid.getX() + departureid.getWidth() + COMPONENT_GAP_X, departureid.getY(),
				TEXT_W, TEXT_H);
		this.infoPanel.add(departureidText);

		arrivalid.setBounds(departureidText.getX() + departureidText.getWidth() + COMPONENT_GAP_X,
				departureidText.getY(), LABEL_W, LABEL_H);
		this.infoPanel.add(arrivalid);
		arrivalidText.setBounds(arrivalid.getX() + arrivalid.getWidth() + COMPONENT_GAP_X, arrivalid.getY(), TEXT_W,
				TEXT_H);
		this.infoPanel.add(arrivalidText);

		supervisionid.setBounds(departureid.getX(), departureid.getY() + departureid.getHeight() + COMPONENT_GAP_Y,
				LABEL_W, LABEL_H);
		this.infoPanel.add(supervisionid);
		supervisionidText.setBounds(supervisionid.getX() + supervisionid.getWidth() + COMPONENT_GAP_X,
				supervisionid.getY(), TEXT_W, TEXT_H);
		this.infoPanel.add(supervisionidText);

		containerid.setBounds(supervisionidText.getX() + supervisionidText.getWidth() + COMPONENT_GAP_X,
				supervisionid.getY(), LABEL_W, LABEL_H);
		this.infoPanel.add(containerid);
		containeridText.setBounds(containerid.getX() + containerid.getWidth() + COMPONENT_GAP_X, containerid.getY(),
				TEXT_W, TEXT_H);
		this.infoPanel.add(containeridText);

		alldeliveryid.setBounds(supervisionid.getX(),
				supervisionid.getY() + supervisionid.getHeight() + COMPONENT_GAP_Y - 15, TEXTid_W, LABEL_H);
		this.infoPanel.add(alldeliveryid);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(alldeliveryid.getX(), alldeliveryid.getY() + alldeliveryid.getHeight(), Area_W, Area_H);
		this.infoPanel.add(scrollPane);
		scrollPane.setViewportView(alldeliveryidText);

		fare.setBounds(alldeliveryid.getX(), scrollPane.getY() + scrollPane.getHeight() + COMPONENT_GAP_Y - 15, LABEL_W,
				LABEL_H);
		this.infoPanel.add(fare);
		fareText.setBounds(fare.getX() + fare.getWidth() + COMPONENT_GAP_X, fare.getY(), TEXTid_W, TEXT_H);
		fareText.setBackground(Color.GRAY);
		fareText.setEditable(false);
		this.infoPanel.add(fareText);

	}

	private void addListener() {
		this.ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//创建中转单对象
				TransferringVO transferringvo = creattransferringvo();
				//验证输入是否成功
				boolean result = transferringBLService.verify(transferringvo);
				
				if (result) {
					throughVerifyOperation(transferringvo);
					cancel.setVisible(true);
					fare.setForeground(Color.red);
				}
				else {
					verifyFailOperation(transferringvo);
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
	
	private void throughVerifyOperation(TransferringVO transferringVO){
		//使所有组件不可编辑
		disableComponents();
		//计算运费
		String thefare = transferringBLService.tranferringFare(transferringVO.getdepartureid(),transferringVO.getarrivalid())+"";
		//显示运费
		fareText.setText(thefare);
		if(isFirstEnsure) {
			showState("请再次确认信息，无误后按确定，否则按取消");
			isFirstEnsure = false;
		}
		else {
			//添加装运信息
			boolean save =transferringBLService.addTransferringFormBL(transferringVO);
			if(save) {		//保存成功
				showState("订单保存成功");
				disableComponents();
			}else {			//TODO 保存失败，说明保存失败的原因或者提出建议
				showState("订单保存失败");
			}
		}
	}
	
	private void verifyFailOperation(TransferringVO transferringVO) {
		//提示修改意见
		showState(transferringVO.geterrorMsg());
	}
	
	private TransferringVO creattransferringvo() {
		String transferringid = transferringidText.getText().trim();
		String date = loadingdateTextyear.getText().trim()+" -"+loadingdateTextmonth.getText().trim()+" -"+loadingdateTextday.getText().trim()+" ";
		String WAY = (String) loadingway.getSelectedItem();
		LoadingType loadingWAY = null;
		switch (WAY) {
		case "飞机":
			loadingWAY = LoadingType.PLANE;
			break;
		case "火车":
			loadingWAY = LoadingType.TRAIN;
			break;
		case "汽车":
			loadingWAY = LoadingType.TRUCK;
			break;
		}
		String loadingWAYid = loadingwayidText.getText().trim();
		String departure = departureidText.getText().trim();
		String arrival = arrivalidText.getText().trim();
		String supervision = supervisionidText.getText().trim();
		String con = containeridText.getText().trim();
		
		
		List<String> all = new ArrayList<String>();
		String alldeli = alldeliveryidText.getText();
		if (alldeli.equals("")) {
			all = null;
		}
		else{
			String[] alldeli1 = alldeli.split("\n");
			for(String q:alldeli1){
				all.add(q);
			}
		}
		TransferringVO transfer = new TransferringVO(date, transferringid, loadingWAY, loadingWAYid, departure, arrival,
				supervision, con, all);
		return transfer;
	}

	private void disableComponents() {
		this.transferringidText.setEditable(false);
		this.loadingdateTextyear.setEditable(false);
		this.loadingdateTextmonth.setEditable(false);
		this.loadingdateTextday.setEditable(false);
		this.loadingway.setEnabled(false);
		this.loadingwayidText.setEditable(false);
		this.departureidText.setEditable(false);
		this.arrivalidText.setEditable(false);
		this.supervisionidText.setEditable(false);
		this.containeridText.setEditable(false);
		this.alldeliveryidText.setEditable(false);
	}

	private void enableComponents() {
		this.transferringidText.setEditable(true);
		this.loadingdateTextyear.setEditable(true);
		this.loadingdateTextmonth.setEditable(true);
		this.loadingdateTextday.setEditable(true);
		this.loadingway.setEnabled(true);
		this.loadingwayidText.setEditable(true);
		this.departureidText.setEditable(true);
		this.arrivalidText.setEditable(true);
		this.supervisionidText.setEditable(true);
		this.containeridText.setEditable(true);
		this.alldeliveryidText.setEditable(true);
	}

	private void addPanels() {
		this.container.add(this.infoPanel);
		this.container.add(this.buttonPanel);
		this.container.add(this.state);
	}

	private void showState(String msg) {
		this.state.setText(msg);
		this.repaint();
	}
}
