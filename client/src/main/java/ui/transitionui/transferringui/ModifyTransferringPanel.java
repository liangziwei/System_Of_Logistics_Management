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
import ui.DateChooser;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;
import ui.transitionui.loadingui.AddLoadingPanel;
import vo.transitionVO.TransferringVO;

public class ModifyTransferringPanel extends DetailPanel {
	private TransferringBLService transferringBLService = new TransferringController();
	
	private DateChooser dateChoose=DateChooser.getInstance();
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
//	private JTextField loadingdateTextmonth = new JTextField();
//	private JTextField loadingdateTextday = new JTextField();
	private JComboBox<String> loadingway = new JComboBox<String>();
	private JTextField loadingwayidText = new JTextField();
	private JComboBox<String> departureidText = new JComboBox<String>();
	private JComboBox<String> arrivalidText = new JComboBox<String>();
	private JTextField supervisionidText = new JTextField();
	private JTextField containeridText = new JTextField();
	private JTextField fareText = new JTextField();
	private JTextArea alldeliveryidText = new JTextArea();

	private JPanel infoPanel = new JPanel();

	private JPanel buttonPanel = new JPanel();

	private LimpidButton ok = new LimpidButton("","picture/确定.png");

	private LimpidButton cancle2 = new LimpidButton("","取消.png");

	private LimpidButton find = new LimpidButton("","picture/查询.png");

	private LimpidButton cancle1 = new LimpidButton("","picture/取消.png");

	public static Font WORD_FONT = new Font("宋体", Font.PLAIN, 15);

	private JLabel state1 = new JLabel("", JLabel.CENTER);

	private JLabel state2 = new JLabel("", JLabel.CENTER);

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

	public ModifyTransferringPanel() {
		// TODO Auto-generated constructor stub
		super();
		// 下拉框设置
		container.setLayout(null);
		container.setPreferredSize(new Dimension(CONTAINER_W, CONTAINER_H));
		jScrollPane.setBounds(0, 0, DETAIL_PANEL_W, DETAIL_PANEL_H);
		jScrollPane.setViewportView(this.container);
		jScrollPane.getVerticalScrollBar().setUnitIncrement(15);
		super.add(jScrollPane);
		// 添加查询组件
		transferringid.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		container.add(transferringid);
		transferringidText.setBounds(transferringid.getX() + transferringid.getWidth() + COMPONENT_GAP_X,
				transferringid.getY(), TEXTid_W, TEXT_H);
		container.add(transferringidText);
		find.setBounds(transferringidText.getX() + transferringidText.getWidth() + COMPONENT_GAP_X,
				transferringidText.getY(), LABEL_W, LABEL_H);
		container.add(find);
		cancle1.setBounds(find.getX() + find.getWidth() + COMPONENT_GAP_X, find.getY(), LABEL_W, LABEL_H);
		container.add(cancle1);
		// 主面板
		this.infoPanel.setBounds(transferringid.getX(),
				transferringid.getY() + transferringid.getHeight() + COMPONENT_GAP_Y, DETAIL_PANEL_W,
				START_Y + (LABEL_H + COMPONENT_GAP_Y) * 5 + Area_H - 40);
		this.infoPanel.setLayout(null);
		this.infoPanel.setVisible(false);
		container.add(this.infoPanel);
		// 初始化信息面板
		this.initUI();

		// 按钮面板
		this.buttonPanel.setBounds(AddLoadingPanel.START_X + LABEL_W + COMPONENT_GAP_X + TEXTid_W,
				infoPanel.getY() + infoPanel.getHeight(), (BUTTON_W << 1) + COMPONENT_GAP_Y, BUTTON_H);
		this.buttonPanel.setVisible(false);
		this.buttonPanel.setLayout(null);
		// 确定按钮
		this.ok.setBounds(0, 0, BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		// 取消按钮
		this.cancle2.setBounds(BUTTON_W + COMPONENT_GAP_Y, 0, BUTTON_W, BUTTON_H);
		this.cancle2.setFont(WORD_FONT);
		this.buttonPanel.add(this.ok);
		this.buttonPanel.add(this.cancle2);
		cancle2.setVisible(false);
		this.container.add(buttonPanel);
		this.buttonPanel.setVisible(false);

		// 状态信息
		this.state1.setBounds(transferringid.getX(),
				transferringid.getY() + transferringid.getHeight() + AddLoadingPanel.COMPONENT_GAP_Y,
				(AddLoadingPanel.BUTTON_W << 2), AddLoadingPanel.BUTTON_W);
		this.state1.setFont(AddLoadingPanel.WORD_FONT);
		this.state1.setForeground(Color.RED);
		this.container.add(state1);

		// 状态信息2
		this.state2.setBounds(AddLoadingPanel.START_X, this.buttonPanel.getY() - BUTTON_H, (BUTTON_W << 2), BUTTON_W);
		this.state2.setFont(WORD_FONT);
		this.state2.setForeground(Color.RED);
		this.container.add(state2);
		this.state2.setVisible(false);
		// 添加事件监听
		this.addListener();

	}

	private void initUI() {
//		JLabel apart1 = new JLabel("-");
//		JLabel apart2 = new JLabel("-");
		loadingdate.setBounds(0, 0, LABEL_W, LABEL_H);
		this.infoPanel.add(loadingdate);
		loadingdateTextyear.setBounds(loadingdate.getX() + loadingdate.getWidth() + COMPONENT_GAP_X, loadingdate.getY(),
				TEXT_W , TEXT_H);
		dateChoose.register(loadingdateTextyear);
		this.infoPanel.add(loadingdateTextyear);
//		apart1.setBounds(loadingdateTextyear.getX() + loadingdateTextyear.getWidth(), loadingdateTextyear.getY(), 10,
//				LABEL_H);
//		this.infoPanel.add(apart1);
//		loadingdateTextmonth.setBounds(apart1.getX() + apart1.getWidth(), apart1.getY(), TEXT_W / 3, TEXT_H);
//		this.infoPanel.add(loadingdateTextmonth);
//		apart2.setBounds(loadingdateTextmonth.getX() + loadingdateTextmonth.getWidth(), loadingdateTextmonth.getY(), 10,
//				LABEL_H);
//		this.infoPanel.add(apart2);
//		loadingdateTextday.setBounds(apart2.getX() + apart2.getWidth(), apart2.getY(), TEXT_W / 3, TEXT_H);
//		this.infoPanel.add(loadingdateTextday);

		way.setBounds(loadingdateTextyear.getX() + loadingdateTextyear.getWidth() + COMPONENT_GAP_X,
				loadingdateTextyear.getY(), LABEL_W, LABEL_H);
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
		departureidText.addItem("南京");
		departureidText.addItem("北京");
		departureidText.addItem("广州");
		departureidText.addItem("上海");
		this.infoPanel.add(departureidText);

		arrivalid.setBounds(departureidText.getX() + departureidText.getWidth() + COMPONENT_GAP_X,
				departureidText.getY(), LABEL_W, LABEL_H);
		this.infoPanel.add(arrivalid);
		arrivalidText.setBounds(arrivalid.getX() + arrivalid.getWidth() + COMPONENT_GAP_X, arrivalid.getY(), TEXT_W,
				TEXT_H);
		arrivalidText.addItem("南京");
		arrivalidText.addItem("北京");
		arrivalidText.addItem("广州");
		arrivalidText.addItem("上海");
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
		find.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String transferringID = transferringidText.getText().trim();
				TransferringVO transferringVO = transferringBLService.findTransferringFormBL(transferringID);
				if (transferringVO != null) {
					// 设置当前的信息面板可见
					infoPanel.setVisible(true);
					// 设置细节信息面板为将要显示的内容
					setinfo(transferringVO);
					// 设置相关面板可见
					buttonPanel.setVisible(true);
					state2.setVisible(true);

					state1.setVisible(false);
					// 重新布局
					revalidate();
				} else {
					// 设置当前的信息面板不可见
					infoPanel.setVisible(false);
					// 设置相关面板不可见
					buttonPanel.setVisible(false);
					state2.setVisible(false);

					state1.setVisible(true);
					// 重新布局
					revalidate();
					showState1("中转单编号错误或中转单编号不存在！");
				}
			}
		});

		cancle1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				transferringidText.setText("");
			}
		});

		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 创建中转单对象
				TransferringVO transferringvo = creatTransferringVO();
				// 验证输入是否成功
				boolean result = transferringBLService.verify(transferringvo);

				if (result) {
					// 重置中转单时间
					transferringvo.setloadingdate(loadingdateTextyear.getText().trim());
					throughVerifyOperation(transferringvo);
					cancle2.setVisible(true);
					fare.setForeground(Color.red);
				} else {
					verifyFailOperation(transferringvo);
				}

				// 刷新页面
				repaint();
			}

		});

		cancle2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 回到第一次点击确定的状态
				isFirstEnsure = true;
				// 使提示信息消失
				state2.setText("");
				// 使信息可编辑
				enableComponents();
				cancle2.setVisible(false);
				// 重置运费
				fareText.setText("");
				fare.setForeground(Color.black);
			}
		});
	}

	private void throughVerifyOperation(TransferringVO transferringVO) {
		// 使所有组件不可编辑
		disableComponents();
		// 计算运费
		String thefare = transferringBLService.tranferringFare(transferringVO.getdepartureid(),
				transferringVO.getarrivalid(), transferringVO.getway()) + "";
		// 显示运费
		fareText.setText(thefare);
		if (isFirstEnsure) {
			showState2("请再次确认信息，无误后按确定，否则按取消");
			isFirstEnsure = false;
		} else {
			// 添加装运信息
			boolean save = transferringBLService.modifyTransferringFormBL(transferringVO);
			if (save) { // 保存成功
				showState2("订单修改成功");
				disableComponents();
			} else { // TODO 保存失败，说明保存失败的原因或者提出建议
				showState2("订单修改失败");
			}
		}
	}

	private void verifyFailOperation(TransferringVO transferringVO) {
		// 提示修改意见
		showState2(transferringVO.geterrorMsg());
	}

	private TransferringVO creatTransferringVO() {
		String transfer = transferringidText.getText().trim();
		String date = loadingdateTextyear.getText().trim();
		String way = (String) loadingway.getSelectedItem();
		LoadingType WAY = null;
		switch (way) {
		case "飞机":
			WAY = LoadingType.PLANE;
			break;
		case "火车":
			WAY = LoadingType.TRAIN;
			break;
		case "汽车":
			WAY = LoadingType.TRUCK;
			break;
		}
		String wayid = loadingwayidText.getText().trim();
		String depart = (String) departureidText.getSelectedItem();
		String arrive = (String) arrivalidText.getSelectedItem();
		String Supervision = supervisionidText.getText().trim();
		String theContainer = containeridText.getText().trim();

		List<String> all = new ArrayList<String>();
		String alldeli = alldeliveryidText.getText();
		if (alldeli.equals("")) {
			all = null;
		} else {
			String[] alldeli1 = alldeli.split("\n");
			for (String q : alldeli1) {
				all.add(q);
			}
		}
		TransferringVO transferringvo = new TransferringVO(date, transfer, WAY, wayid, depart, arrive, Supervision,
				theContainer, all);
		return transferringvo;
	}

	private void disableComponents() {
		this.loadingdateTextyear.setEditable(false);
		dateChoose.setEnabled(false);
//		this.loadingdateTextmonth.setEditable(false);
//		this.loadingdateTextday.setEditable(false);
		this.loadingway.setEnabled(false);
		this.loadingwayidText.setEditable(false);
		this.departureidText.setEnabled(false);
		this.arrivalidText.setEnabled(false);
		this.supervisionidText.setEditable(false);
		this.containeridText.setEditable(false);
		this.alldeliveryidText.setEditable(false);
	}

	private void enableComponents() {
		this.loadingdateTextyear.setEditable(true);
		dateChoose.setEnabled(true);
//		this.loadingdateTextmonth.setEditable(true);
//		this.loadingdateTextday.setEditable(true);
		this.loadingway.setEnabled(true);
		this.loadingwayidText.setEditable(true);
		this.departureidText.setEnabled(true);
		this.arrivalidText.setEnabled(true);
		this.supervisionidText.setEditable(true);
		this.containeridText.setEditable(true);
		this.alldeliveryidText.setEditable(true);
	}

	private void setinfo(TransferringVO transferringVO) {
		this.loadingdateTextyear.setText(transferringVO.getloadingdate().trim());
		switch (transferringVO.getway()) {
		case PLANE:
			loadingway.setSelectedItem("飞机");
			break;
		case TRAIN:
			loadingway.setSelectedItem("火车");
			break;
		case TRUCK:
			loadingway.setSelectedItem("汽车");
			break;
		}
		this.loadingwayidText.setText(transferringVO.getwayid().trim());
		this.departureidText.setSelectedItem(transferringVO.getdepartureid().trim());
		this.arrivalidText.setSelectedItem(transferringVO.getarrivalid().trim());
		this.supervisionidText.setText(transferringVO.getsupervisionid().trim());
		this.containeridText.setText(transferringVO.getcontainerid().trim());
		List<String> deliveryID = transferringVO.getalldeliveryid();
		for (String str : deliveryID) {
			alldeliveryidText.append(str + "\n");
		}
		this.fareText.setText(transferringVO.getfare() + "");
	}

	private void showState1(String msg) {
		this.state1.setText(msg);
		this.repaint();
	}

	private void showState2(String msg) {
		this.state2.setText(msg);
		this.repaint();
	}
}
