package ui.transitionui.receivingui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businessLogic.businessLogicController.transitionController.ReceivingController;
import businessLogic.businessLogicController.transitionController.TransferringController;
import businessLogicService.transitionBLService.ReceivingBLService;
import businessLogicService.transitionBLService.TransferringBLService;
import constant.CargoState;
import dataService.businessDataService.EntruckingDataService;
import network.RMI;
import ui.DateChooser;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;
import vo.transitionVO.ReceivingVO;
import vo.transitionVO.TransferringVO;

public class AddReceivingPanel extends DetailPanel {
	private ReceivingBLService receivingService = new ReceivingController();
	private TransferringBLService transferringBLService = new TransferringController();
	private EntruckingDataService entruckingData=RMI.<EntruckingDataService>getDataService("entrucking");

	private DateChooser dateChoose = DateChooser.getInstance();
	// // 添加下拉框
	// private JScrollPane jScrollPane = new JScrollPane();
	// private JPanel container = new JPanel();
	// 组件
	private JLabel transferringid = new JLabel("中转单编号");

	private JLabel arrivaldate = new JLabel("到达日期");

	private JLabel transitionid = new JLabel("本中转中心编号");

	private JLabel departureid = new JLabel("出发地");

	private JLabel arrivalid = new JLabel("到达地");

	private JLabel statelabel = new JLabel("货物到达状态");

	private JComboBox<String> endState = new JComboBox<String>();

	private JTextField transferringidText = new JTextField();

	private JTextField arrivaldateTextyear = new JTextField();

	// private JTextField arrivaldateTextmonth = new JTextField();
	//
	// private JTextField arrivaldateTextday = new JTextField();

	private JTextField transitionidText = new JTextField();

	private JTextField departureidText = new JTextField();

	private JTextField arrivalidText = new JTextField();

	private JPanel infoPanel = new JPanel();

	private JPanel buttonPanel = new JPanel();

	private LimpidButton check = new LimpidButton("","picture/同步相关中转单.png");

	private LimpidButton ok = new LimpidButton("", "picture/确定.png");

	private LimpidButton cancel = new LimpidButton("", "picture/取消.png");

	public static Font WORD_FONT = new Font("宋体", Font.PLAIN, 15);

	private JLabel betransfer = new JLabel("不存在该中转单");
	private JLabel beloading = new JLabel("不存在该装车单");
	private JLabel state = new JLabel("", JLabel.CENTER);

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
	/**
	 * 是否为已存在的中转单
	 */
	private boolean istransfer = false;

	public AddReceivingPanel() {
		// TODO Auto-generated constructor stub
		super();
		// // 下拉框设置
		// container.setLayout(null);
		// container.setPreferredSize(new Dimension(CONTAINER_W, CONTAINER_H));
		// jScrollPane.setBounds(0, 0, DETAIL_PANEL_W, DETAIL_PANEL_H);
		// jScrollPane.setViewportView(this.container);
		// jScrollPane.getVerticalScrollBar().setUnitIncrement(15);
		// super.add(jScrollPane);

		// 主面板
		this.infoPanel.setBounds(START_X, START_Y / 2, this.DETAIL_PANEL_W,
				START_Y + (LABEL_H + COMPONENT_GAP_Y) * 4 - 30);
		this.infoPanel.setLayout(null);
		infoPanel.setOpaque(false);
		;
		// 初始化信息面板
		this.initUI();
		// 按钮面板
		this.buttonPanel.setBounds(START_X + LABEL_W + COMPONENT_GAP_X + TEXTid_W,
				infoPanel.getY() + infoPanel.getHeight(), (BUTTON_W << 1) + COMPONENT_GAP_Y, BUTTON_H);
		this.buttonPanel.setLayout(null);
		buttonPanel.setOpaque(false);
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
		// 中转单编号
		transferringid.setBounds(0, 0, LABEL_W, LABEL_H);
		this.infoPanel.add(transferringid);
		transferringidText.setBounds(transferringid.getX() + transferringid.getWidth() + COMPONENT_GAP_X,
				transferringid.getY(), TEXTid_W, TEXT_H);
		transferringidText.setOpaque(false);
		this.infoPanel.add(transferringidText);
		check.setBounds(transferringidText.getX() + transferringidText.getWidth() + COMPONENT_GAP_Y,
				transferringidText.getY(), 80 * 2, 30);
		check.setFont(WORD_FONT);
		this.infoPanel.add(check);
		//是否存在中转单
		betransfer.setBounds(transferringid.getX(), transferringid.getY() + transferringid.getHeight(), TEXTid_W,
				COMPONENT_GAP_Y);
		betransfer.setFont(WORD_FONT);
		betransfer.setForeground(Color.red);
		betransfer.setVisible(false);
		this.infoPanel.add(betransfer);
		//是否存在营业厅装车单
		beloading.setBounds(transferringid.getX(), transferringid.getY() + transferringid.getHeight(), TEXTid_W,
				COMPONENT_GAP_Y);
		beloading.setFont(WORD_FONT);
		beloading.setForeground(Color.red);
		beloading.setVisible(false);
		this.infoPanel.add(beloading);
		// 到达日期
		arrivaldate.setBounds(transferringid.getX(),
				transferringid.getY() + transferringid.getHeight() + COMPONENT_GAP_Y, LABEL_W, LABEL_H);
		this.infoPanel.add(arrivaldate);
		arrivaldateTextyear.setBounds(arrivaldate.getX() + arrivaldate.getWidth() + COMPONENT_GAP_X, arrivaldate.getY(),
				TEXT_W * (2), TEXT_H);
		dateChoose.register(arrivaldateTextyear);
		arrivaldateTextyear.setOpaque(false);
		this.infoPanel.add(arrivaldateTextyear);
		// JLabel apart1 = new JLabel("-");
		// JLabel apart2 = new JLabel("-");
		// apart1.setBounds(arrivaldateTextyear.getX() +
		// arrivaldateTextyear.getWidth(), arrivaldateTextyear.getY(), 10,
		// TEXT_H);
		// this.infoPanel.add(apart1);
		// arrivaldateTextmonth.setBounds(apart1.getX() + apart1.getWidth(),
		// arrivaldate.getY(), TEXT_W / 2, TEXT_H);
		// this.infoPanel.add(arrivaldateTextmonth);
		// apart2.setBounds(arrivaldateTextmonth.getX() +
		// arrivaldateTextmonth.getWidth(), arrivaldate.getY(), 10, TEXT_H);
		// this.infoPanel.add(apart2);
		// arrivaldateTextday.setBounds(apart2.getX() + apart2.getWidth(),
		// arrivaldate.getY(), TEXT_W / 2, TEXT_H);
		// this.infoPanel.add(arrivaldateTextday);
		// 本中转中心编号
		transitionid.setBounds(arrivaldate.getX(), arrivaldate.getY() + arrivaldate.getHeight() + COMPONENT_GAP_Y,
				LABEL_W + 11, LABEL_H);

		this.infoPanel.add(transitionid);
		transitionidText.setBounds(transferringid.getX() + transitionid.getWidth() + COMPONENT_GAP_X,
				transitionid.getY(), TEXTid_W, TEXT_H);
		transitionidText.setOpaque(false);
		this.infoPanel.add(transitionidText);
		// 出发地
		departureid.setBounds(transitionid.getX(), transitionid.getY() + transitionid.getHeight() + COMPONENT_GAP_Y,
				LABEL_W, LABEL_H);
		this.infoPanel.add(departureid);
		departureidText.setBounds(departureid.getX() + departureid.getWidth() + COMPONENT_GAP_X, departureid.getY(),
				TEXT_W, TEXT_H);
		departureidText.setOpaque(false);
		this.infoPanel.add(departureidText);
		// 到达地
		arrivalid.setBounds(departureidText.getX() + departureidText.getWidth() + COMPONENT_GAP_Y, departureid.getY(),
				LABEL_W, LABEL_H);
		this.infoPanel.add(arrivalid);
		arrivalidText.setBounds(arrivalid.getX() + arrivalid.getWidth() + COMPONENT_GAP_X, arrivalid.getY(), TEXT_W,
				TEXT_H);
		arrivalidText.setOpaque(false);
		this.infoPanel.add(arrivalidText);
		// 货物到达状态
		statelabel.setBounds(departureid.getX(), departureid.getY() + departureid.getHeight() + COMPONENT_GAP_Y,
				LABEL_W, LABEL_H);
		this.infoPanel.add(statelabel);
		endState.setBounds(statelabel.getX() + statelabel.getWidth() + COMPONENT_GAP_Y, statelabel.getY(), TEXT_W,
				TEXT_H);
		endState.addItem("完整");
		endState.addItem("损坏");
		endState.addItem("丢失");
		this.infoPanel.add(endState);

	}

	private void addListener() {
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 创建接收单对象
				ReceivingVO receivingVO = creatReceivingVO();
				//是否有相关中转单
				if (!istransfer) {
					check.doClick();	
				}
				
				if (istransfer) {
					// 验证输入是否规范
					boolean result = receivingService.verify(receivingVO);
					
					if (result) {
						// 重置接受单时间
						receivingVO.setarrivaldate(arrivaldateTextyear.getText().trim());
						throughVerifyOperation(receivingVO); // 验证成功
						cancel.setVisible(true);
					} else {
						verifyFailOperation(receivingVO); // 验证失败
					}
					
					// 刷新页面
					repaint();
				}
				
			}
		});

		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 回到第一次点击确定的状态
				isFirstEnsure = true;
				// 使提示信息消失
				state.setText("");
				state.setForeground(Color.red);
				// 使信息可编辑
				enableComponents();
				cancel.setVisible(false);
				
			}
		});
		
		check.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String transferID = transferringidText.getText().trim();
				if (transferID.matches("\\d{16}")) {
					TransferringVO transferringVO = transferringBLService.findTransferringFormBL(transferID);
					if (transferringVO!=null) {
						arrivalidText.setText(transferringVO.getarrivalid().trim());
						departureidText.setText(transferringVO.getdepartureid().trim());
						betransfer.setForeground(Color.green);
						betransfer.setText("中转单编号正确");
						betransfer.setVisible(true);
						istransfer = true;
					}
					else {
						istransfer = false;
						betransfer.setForeground(Color.red);
						betransfer.setText("不存在该中转单");
						betransfer.setVisible(true);
					}
					
				}
				else if (transferID.matches("\\d{19}")) {
					boolean entruck=false;
					try {
						entruck = entruckingData.isExist(transferID);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (entruck) {
						beloading.setForeground(Color.green);
						beloading.setText("装运单编号正确");
						beloading.setVisible(true);
						istransfer = true;						
					}
					else {
						beloading.setForeground(Color.red);
						beloading.setText("不存在该装车单");
						beloading.setVisible(true);
						istransfer = false;
					}
				}
				else {
					betransfer.setVisible(true);
				}
				
			}
		});
		
		transferringidText.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					check.doClick();
				}
			}
		});
		
		
	}

	private void throughVerifyOperation(ReceivingVO receivingVO) {
		// 使所有组件不可编辑
		disableComponents();

		if (isFirstEnsure) {
			showState("请再次确认信息，无误后按确定，否则按取消");
			isFirstEnsure = false;
		} else {
			// 添加装运信息
			boolean save = receivingService.addReceivingFormBL(receivingVO);
			if (save) { // 保存成功
				state.setForeground(Color.green);
				showState("订单保存成功");
				disableComponents();
			} else { // TODO 保存失败，说明保存失败的原因或者提出建议
				state.setForeground(Color.red);
				showState("订单保存失败，注意检查中转单编号");
			}
		}
	}

	private void verifyFailOperation(ReceivingVO receivingVO) {
		// 提示修改意见
		state.setForeground(Color.red);
		showState(receivingVO.geterrorMsg());
	}

	private ReceivingVO creatReceivingVO() {
		String transfer = transferringidText.getText().trim();
		String arrdate = arrivaldateTextyear.getText().trim();
		String transition = transitionidText.getText().trim();
		String depart = departureidText.getText().trim();
		String arrive = arrivalidText.getText().trim();
		String stat = (String) endState.getSelectedItem();
		CargoState state = null;
		switch (stat) {
		case "损坏":
			state = CargoState.损坏;
			break;
		case "完整":
			state = CargoState.完整;
			break;
		case "丢失":
			state = CargoState.丢失;
			break;
		}

		ReceivingVO receivingVO = new ReceivingVO(transition, arrdate, transfer, depart, arrive, state);
		return receivingVO;
	}

	private void disableComponents() {
		transferringidText.setEditable(false);
		transitionidText.setEditable(false);
		arrivaldateTextyear.setEditable(false);
		dateChoose.setEnabled(false);
		// arrivaldateTextmonth.setEditable(false);
		// arrivaldateTextday.setEditable(false);
		departureidText.setEditable(false);
		arrivalidText.setEditable(false);
		endState.setEnabled(false);
	}

	private void enableComponents() {
		transferringidText.setEditable(true);
		transitionidText.setEditable(true);
		arrivaldateTextyear.setEditable(true);
		dateChoose.setEnabled(true);
		// arrivaldateTextmonth.setEditable(true);
		// arrivaldateTextday.setEditable(true);
		departureidText.setEditable(true);
		arrivalidText.setEditable(true);
		endState.setEnabled(true);
	}

	private void addPanels() {
		this.add(this.infoPanel);
		this.add(this.buttonPanel);
		this.add(this.state);
	}

	private void showState(String msg) {
		this.state.setText(msg);
		this.repaint();
	}
}
