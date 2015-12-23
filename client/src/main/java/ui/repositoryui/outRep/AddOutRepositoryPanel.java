package ui.repositoryui.outRep;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businessLogic.businessLogicController.repositoryController.InRepositoryController;
import businessLogic.businessLogicController.repositoryController.OutRepositoryController;
import businessLogicService.repositoryBLService.InRepositoryBLService;
import businessLogicService.repositoryBLService.OutRepositoryBLService;
import constant.LoadingType;
import ui.DateChooser;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;
import ui.transitionui.loadingui.AddLoadingPanel;
import vo.repositoryVO.InRepositoryVO;
import vo.repositoryVO.OutRepositoryVO;

public class AddOutRepositoryPanel extends DetailPanel {
	private OutRepositoryBLService outRepositoryBLService = new OutRepositoryController();
	private InRepositoryBLService inRepositoryBLService = new InRepositoryController();

	private DateChooser dateChoose = DateChooser.getInstance();
	// 组件
	private JLabel Deliveryid = new JLabel("快递编号");
	private JLabel outrepositorydate = new JLabel("出库日期");
	private JLabel arrivalid = new JLabel("目的地");
	private JLabel loadingway = new JLabel("装运形式");
	private JLabel wayid = new JLabel("装运信息编号");

	private JTextField DeliveryidText = new JTextField();
	private JTextField outrepositoryYear = new JTextField();
	// private JTextField outrepositoryMonth = new JTextField();
	// private JTextField outrepositoryDay = new JTextField();
	private JTextField arrivalidText = new JTextField();
	private JComboBox<String> loadingwayText = new JComboBox<String>();
	private JTextField wayidText = new JTextField();

	private JPanel infoPanel = new JPanel();

	private JPanel buttonPanel = new JPanel();
	
	private JButton check = new JButton("同步该快递单");

	private LimpidButton ok = new LimpidButton("", "picture/确定.png");

	private LimpidButton cancel = new LimpidButton("", "picture/取消.png");

	public static Font WORD_FONT = new Font("宋体", Font.PLAIN, 15);
	
	
	private JLabel deliveryNumberState = new JLabel("该快递单未曾入库",JLabel.CENTER);
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
	 * 是否在数据库中找到该入库单
	 */
	private boolean isInRepo = false;

	public AddOutRepositoryPanel() {
		// TODO Auto-generated constructor stub
		super();

		// 主面板
		this.infoPanel.setBounds(START_X, START_Y, AddLoadingPanel.DETAIL_PANEL_W,
				START_Y + (LABEL_H + COMPONENT_GAP_Y) * 3);
		this.infoPanel.setLayout(null);
		infoPanel.setOpaque(false);
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
		buttonPanel.setOpaque(false);
		// 状态信息
		this.state.setBounds(START_X, this.buttonPanel.getY() - BUTTON_H, (BUTTON_W << 2), BUTTON_W);
		this.state.setFont(WORD_FONT);
		this.state.setForeground(Color.RED);
		// 将信息面板加到主面板
		this.addPanels();
	}

	private void initUI() {
		// 快递编号
		Deliveryid.setBounds(0, 0, LABEL_W, LABEL_H);
		this.infoPanel.add(Deliveryid);
		DeliveryidText.setBounds(Deliveryid.getX() + Deliveryid.getWidth() + COMPONENT_GAP_X, Deliveryid.getY(),
				TEXTid_W, TEXT_H);
		DeliveryidText.setOpaque(false);
		this.infoPanel.add(DeliveryidText);
		//检查快递编号相关组件
		check.setBounds(DeliveryidText.getX()+DeliveryidText.getWidth()+COMPONENT_GAP_Y,DeliveryidText.getY(),80,30);
		check.setFont(WORD_FONT);
		this.infoPanel.add(check);
		deliveryNumberState.setBounds(Deliveryid.getX(), Deliveryid.getY()+Deliveryid.getHeight(), TEXTid_W, COMPONENT_GAP_Y);
		deliveryNumberState.setFont(WORD_FONT);
		deliveryNumberState.setForeground(Color.RED);
		deliveryNumberState.setVisible(false);
		this.infoPanel.add(deliveryNumberState);
		// 出库日期
		outrepositorydate.setBounds(Deliveryid.getX(), Deliveryid.getY() + Deliveryid.getHeight() + COMPONENT_GAP_Y,
				LABEL_W, LABEL_H);
		this.infoPanel.add(outrepositorydate);
		outrepositoryYear.setBounds(outrepositorydate.getX() + outrepositorydate.getWidth() + COMPONENT_GAP_X,
				outrepositorydate.getY(), (TEXT_W / 2) * 3, TEXT_H);
		outrepositoryYear.setOpaque(false);
		this.infoPanel.add(outrepositoryYear);
		dateChoose.register(outrepositoryYear);
		this.infoPanel.add(outrepositoryYear);
		// JLabel apart1 = new JLabel("-");
		// JLabel apart2 = new JLabel("-");
		// apart1.setBounds(outrepositoryYear.getX() +
		// outrepositoryYear.getWidth(), outrepositoryYear.getY(), 10, TEXT_H);
		// this.infoPanel.add(apart1);
		// outrepositoryMonth.setBounds(apart1.getX() + apart1.getWidth(),
		// apart1.getY(), TEXT_W / 2, TEXT_H);
		// this.infoPanel.add(outrepositoryMonth);
		// apart2.setBounds(outrepositoryMonth.getX() +
		// outrepositoryMonth.getWidth(), outrepositoryMonth.getY(), 10,
		// TEXT_H);
		// this.infoPanel.add(apart2);
		// outrepositoryDay.setBounds(apart2.getX() + apart2.getWidth(),
		// apart2.getY(), TEXT_W / 2, TEXT_H);
		// this.infoPanel.add(outrepositoryDay);
		// 目的地
		arrivalid.setBounds(outrepositorydate.getX(),
				outrepositorydate.getY() + outrepositorydate.getHeight() + COMPONENT_GAP_Y, LABEL_W, LABEL_H);
		this.infoPanel.add(arrivalid);
		arrivalidText.setBounds(arrivalid.getX() + arrivalid.getWidth() + COMPONENT_GAP_X, arrivalid.getY(), TEXT_W,
				TEXT_H);
		arrivalidText.setOpaque(false);
		this.infoPanel.add(arrivalidText);
		// 装运形式
		loadingway.setBounds(arrivalidText.getX() + arrivalidText.getWidth() + COMPONENT_GAP_X, arrivalidText.getY(),
				LABEL_W, LABEL_H);
		this.infoPanel.add(loadingway);
		loadingwayText.setBounds(loadingway.getX() + loadingway.getWidth() + COMPONENT_GAP_X, loadingway.getY(), TEXT_W,
				TEXT_H);
		loadingwayText.setOpaque(false);
		loadingwayText.addItem("飞机");
		loadingwayText.addItem("火车");
		loadingwayText.addItem("汽车");
		loadingwayText.setOpaque(false);
		this.infoPanel.add(loadingwayText);
		// 装运信息编号
		wayid.setBounds(arrivalid.getX(), arrivalid.getY() + arrivalid.getHeight() + COMPONENT_GAP_Y, LABEL_W, LABEL_H);
		this.infoPanel.add(wayid);
		wayidText.setBounds(wayid.getX() + wayid.getWidth() + COMPONENT_GAP_X, wayid.getY(), TEXTid_W, TEXT_H);
		wayidText.setOpaque(false);
		this.infoPanel.add(wayidText);
	}

	private void addListener() {
		this.ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 创建接收单对象
				OutRepositoryVO outRepositoryVO = creatOutRepository();
				//是否有相关入库单
				if (!isInRepo) {
					check.doClick();					
				}
				if (isInRepo) {
					// 验证输入是否规范
					boolean result = outRepositoryBLService.verify(outRepositoryVO);
					
					if (result) {
						// 重置出库时间
						outRepositoryVO.setoutrepositorydate(outrepositoryYear.getText().trim());
						throughVerifyOperation(outRepositoryVO); // 验证成功
						cancel.setVisible(true);
					} else {
						verifyFailOperation(outRepositoryVO); // 验证失败
					}
					
					// 刷新页面
					repaint();
					
				}
			}
		});

		this.cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 回到第一次点击确定的状态
				isFirstEnsure = true;
				// 使提示信息消失
				state.setText("");
				// 使信息可编辑
				enableComponents();
				cancel.setVisible(false);
			}
		});
		
		this.check.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InRepositoryVO inRepositoryVO = inRepositoryBLService.findInRepositoryFormBL(DeliveryidText.getText().trim());
				if (inRepositoryVO!=null) {
					arrivalidText.setText(inRepositoryVO.getarrivalid().trim());
					switch (inRepositoryVO.getareaCode()) {
					case PLANEAREA:
						loadingwayText.setSelectedItem("飞机");
						break;
					case TRAINAREA:
						loadingwayText.setSelectedItem("火车");
						break;
					case TRUCKAREA:
						loadingwayText.setSelectedItem("汽车");
						break;
					case MOTOAREA:
						break;
					}
					deliveryNumberState.setVisible(false);
					isInRepo = true;
				}
				else {
					isInRepo = false;
					deliveryNumberState.setVisible(true);
				}
			}
		});
		
		DeliveryidText.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					check.doClick();
				}
			}
		});
//		wayidText.addKeyListener(new KeyAdapter() {
//
//			public void keyPressed(KeyEvent e) {
//
//				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
//					ok.doClick();
//				}
//			}
//		});
	}

	private void throughVerifyOperation(OutRepositoryVO outRepositoryVO) {
		// 使所有组件不可编辑
		disableComponents();

		if (isFirstEnsure) {
			showState("请再次确认信息，无误后按确定，否则按取消");
			isFirstEnsure = false;
		} else {
			// 添加装运信息
			boolean save = outRepositoryBLService.addOutRepositoryFormBL(outRepositoryVO);
			if (save) { // 保存成功
				showState("订单保存成功");
				disableComponents();
			} else { // TODO 保存失败，说明保存失败的原因或者提出建议
				showState("订单保存失败(检查快递编号)");
			}
		}
	}

	private void verifyFailOperation(OutRepositoryVO outRepositoryVO) {
		// 提示修改意见
		showState(outRepositoryVO.geterrorMsg());
	}

	private void disableComponents() {
		DeliveryidText.setEditable(false);
		outrepositoryYear.setEditable(false);
		dateChoose.setEnabled(false);
		// outrepositoryMonth.setEditable(false);
		// outrepositoryDay.setEditable(false);
		arrivalidText.setEditable(false);
		loadingwayText.setEnabled(false);
		wayidText.setEditable(false);
	}

	private void enableComponents() {
		DeliveryidText.setEditable(true);
		outrepositoryYear.setEditable(true);
		dateChoose.setEnabled(true);
		// outrepositoryMonth.setEditable(true);
		// outrepositoryDay.setEditable(true);
		arrivalidText.setEditable(true);
		loadingwayText.setEnabled(true);
		wayidText.setEditable(true);
	}

	private OutRepositoryVO creatOutRepository() {
		String Delivery = DeliveryidText.getText().trim();
		String outdate = outrepositoryYear.getText().trim();
		String arrive = arrivalidText.getText().trim();
		LoadingType type = null;
		String way = (String) loadingwayText.getSelectedItem();
		switch (way) {
		case "飞机":
			type = LoadingType.PLANE;
			break;
		case "火车":
			type = LoadingType.TRAIN;
			break;
		case "汽车":
			type = LoadingType.TRUCK;
			break;
		}
		String loadingwayid = wayidText.getText().trim();
		OutRepositoryVO outRepositoryVO = new OutRepositoryVO(Delivery, outdate, arrive, type, loadingwayid);
		return outRepositoryVO;
	}

	private void addPanels() {
		this.add(infoPanel);
		this.add(buttonPanel);
		this.add(state);
	}

	private void showState(String msg) {
		this.state.setText(msg);
		this.repaint();
	}
}
