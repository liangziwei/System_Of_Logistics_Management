package ui.repositoryui.outRep;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businessLogic.businessLogicController.repositoryController.OutRepositoryController;
import businessLogicService.repositoryBLService.OutRepositoryBLService;
import constant.LoadingType;
import ui.DateChooser;
import ui.baseui.DetailPanel;
import ui.transitionui.loadingui.AddLoadingPanel;
import vo.repositoryVO.OutRepositoryVO;

public class ModifyOutRepositoryPanel extends DetailPanel {
	private OutRepositoryBLService outRepositoryBLService = new OutRepositoryController();
	
	private DateChooser dateChoose=DateChooser.getInstance();
	// 组件
	private JLabel Deliveryid = new JLabel("快递编号");
	private JLabel outrepositorydate = new JLabel("出库日期");
	private JLabel arrivalid = new JLabel("目的地");
	private JLabel loadingway = new JLabel("装运形式");
	private JLabel wayid = new JLabel("装运信息编号");

	private JTextField DeliveryidText = new JTextField();
	private JTextField outrepositoryYear = new JTextField();
//	private JTextField outrepositoryMonth = new JTextField();
//	private JTextField outrepositoryDay = new JTextField();
	private JTextField arrivalidText = new JTextField();
	private JComboBox<String> loadingwayText = new JComboBox<String>();
	private JTextField wayidText = new JTextField();

	private JPanel infoPanel = new JPanel();

	private JPanel buttonPanel = new JPanel();

	private JButton find = new JButton("查询");

	private JButton cancle1 = new JButton("取消查询");

	private JButton ok = new JButton("确定");

	private JButton cancle2 = new JButton("取消");

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

	public ModifyOutRepositoryPanel() {
		// TODO Auto-generated constructor stub
		super();
		// 查询相关组件
		Deliveryid.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.add(Deliveryid);
		DeliveryidText.setBounds(Deliveryid.getX() + Deliveryid.getWidth() + COMPONENT_GAP_X, Deliveryid.getY(),
				TEXTid_W, TEXT_H);
		this.add(DeliveryidText);
		find.setBounds(DeliveryidText.getX() + DeliveryidText.getWidth() + COMPONENT_GAP_X, DeliveryidText.getY(),
				LABEL_W, LABEL_H);
		this.add(find);
		cancle1.setBounds(find.getX() + find.getWidth() + COMPONENT_GAP_X, find.getY(), LABEL_W, LABEL_H);
		this.add(cancle1);
		// 信息面板
		infoPanel.setBounds(Deliveryid.getX(), Deliveryid.getY() + Deliveryid.getHeight() + COMPONENT_GAP_Y,
				AddLoadingPanel.DETAIL_PANEL_W, START_Y + (LABEL_H + COMPONENT_GAP_Y) * 2);
		infoPanel.setLayout(null);
		infoPanel.setVisible(false);
		this.add(infoPanel);
		infoPanel.setOpaque(false);

		// 初始化信息面板
		this.initUI();

		// 按钮面板
		this.buttonPanel.setBounds(AddLoadingPanel.START_X + LABEL_W + COMPONENT_GAP_X + TEXTid_W,
				infoPanel.getY() + infoPanel.getHeight(), (BUTTON_W << 1) + COMPONENT_GAP_Y, BUTTON_H);

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
		this.add(buttonPanel);
		this.buttonPanel.setVisible(false);
		buttonPanel.setOpaque(false);
		
		// 状态信息
		this.state1.setBounds(Deliveryid.getX(),
				Deliveryid.getY() + Deliveryid.getHeight() + AddLoadingPanel.COMPONENT_GAP_Y,
				(AddLoadingPanel.BUTTON_W << 2), AddLoadingPanel.BUTTON_W);
		this.state1.setFont(AddLoadingPanel.WORD_FONT);
		this.state1.setForeground(Color.RED);
		this.add(state1);
		// 状态信息2
		this.state2.setBounds(AddLoadingPanel.START_X, this.buttonPanel.getY() - BUTTON_H, (BUTTON_W << 2), BUTTON_W);
		this.state2.setFont(WORD_FONT);
		this.state2.setForeground(Color.RED);
		this.add(state2);
		this.state2.setVisible(false);
		// 添加事件监听
		this.addListener();

	}

	private void initUI() {
		// 出库日期
		outrepositorydate.setBounds(0, 0, LABEL_W, LABEL_H);
		this.infoPanel.add(outrepositorydate);
		outrepositoryYear.setBounds(outrepositorydate.getX() + outrepositorydate.getWidth() + COMPONENT_GAP_X,
				outrepositorydate.getY(), (TEXT_W / 2)*3, TEXT_H);
		dateChoose.register(outrepositoryYear);
		this.infoPanel.add(outrepositoryYear);
//		JLabel apart1 = new JLabel("-");
//		JLabel apart2 = new JLabel("-");
//		apart1.setBounds(outrepositoryYear.getX() + outrepositoryYear.getWidth(), outrepositoryYear.getY(), 10, TEXT_H);
//		this.infoPanel.add(apart1);
//		outrepositoryMonth.setBounds(apart1.getX() + apart1.getWidth(), apart1.getY(), TEXT_W / 2, TEXT_H);
//		this.infoPanel.add(outrepositoryMonth);
//		apart2.setBounds(outrepositoryMonth.getX() + outrepositoryMonth.getWidth(), outrepositoryMonth.getY(), 10,
//				TEXT_H);
//		this.infoPanel.add(apart2);
//		outrepositoryDay.setBounds(apart2.getX() + apart2.getWidth(), apart2.getY(), TEXT_W / 2, TEXT_H);
//		this.infoPanel.add(outrepositoryDay);
		// 目的地
		arrivalid.setBounds(outrepositorydate.getX(),
				outrepositorydate.getY() + outrepositorydate.getHeight() + COMPONENT_GAP_Y, LABEL_W, LABEL_H);
		this.infoPanel.add(arrivalid);
		arrivalidText.setBounds(arrivalid.getX() + arrivalid.getWidth() + COMPONENT_GAP_X, arrivalid.getY(), TEXT_W,
				TEXT_H);
		this.infoPanel.add(arrivalidText);
		// 装运形式
		loadingway.setBounds(arrivalidText.getX() + arrivalidText.getWidth() + COMPONENT_GAP_X, arrivalidText.getY(),
				LABEL_W, LABEL_H);
		this.infoPanel.add(loadingway);
		loadingwayText.setBounds(loadingway.getX() + loadingway.getWidth() + COMPONENT_GAP_X, loadingway.getY(), TEXT_W,
				TEXT_H);
		loadingwayText.addItem("飞机");
		loadingwayText.addItem("火车");
		loadingwayText.addItem("汽车");
		this.infoPanel.add(loadingwayText);
		// 装运信息编号
		wayid.setBounds(arrivalid.getX(), arrivalid.getY() + arrivalid.getHeight() + COMPONENT_GAP_Y, LABEL_W, LABEL_H);
		this.infoPanel.add(wayid);
		wayidText.setBounds(wayid.getX() + wayid.getWidth() + COMPONENT_GAP_X, wayid.getY(), TEXTid_W, TEXT_H);
		this.infoPanel.add(wayidText);
	}

	private void addListener() {
		find.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String deliveryID = DeliveryidText.getText().trim();
				OutRepositoryVO outRepositoryVO = outRepositoryBLService.findOutRepositoryFormBL(deliveryID);
				if (outRepositoryVO != null) {
					// 设置当前的信息面板可见
					infoPanel.setVisible(true);
					// 设置细节信息面板为将要显示的内容
					setinfo(outRepositoryVO);
					// 设置相关面板可见
					buttonPanel.setVisible(true);
					state2.setVisible(true);
					
					state1.setVisible(false);
					// 重新布局
					revalidate();
				} else {
					//设置当前的信息面板不可见
					infoPanel.setVisible(false);
					//设置相关面板不可见
					buttonPanel.setVisible(false);
					state2.setVisible(false);
					
					state1.setVisible(true);
					//重新布局
					revalidate();
					showState1("出库单编号错误或出库单不存在！");
				}
			}
		});

		cancle1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DeliveryidText.setText("");
			}
		});
		
		this.ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//创建接收单对象
				OutRepositoryVO outRepositoryVO = creatOutRepository();
				//验证输入是否规范
				boolean result = outRepositoryBLService.verify(outRepositoryVO);
				
				if (result) {//验证成功
					//重置出库时间
					outRepositoryVO.setoutrepositorydate(outrepositoryYear.getText().trim());
					throughVerifyOperation(outRepositoryVO);   
					cancle2.setVisible(true);
				}
				else {
					verifyFailOperation(outRepositoryVO);   //验证失败
				}
				
				//刷新页面
				repaint();
			}
		});

		this.cancle2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//回到第一次点击确定的状态
				isFirstEnsure = true;
				//使提示信息消失
				state2.setText("");
				//使信息可编辑
				enableComponents();
				cancle2.setVisible(false);
			}
		});
	}

	private void throughVerifyOperation(OutRepositoryVO outRepositoryVO) {
		// 使所有组件不可编辑
		disableComponents();

		if (isFirstEnsure) {
			showState2("请再次确认信息，无误后按确定，否则按取消");
			isFirstEnsure = false;
		} else {
			// 添加装运信息
			boolean save = outRepositoryBLService.modifyOutRepositoryFormBL(outRepositoryVO);
			if (save) { // 保存成功
				showState2("订单修改成功");
				disableComponents();
			} else { // TODO 保存失败，说明保存失败的原因或者提出建议
				showState2("订单修改失败");
			}
		}
	}

	private void verifyFailOperation(OutRepositoryVO outRepositoryVO) {
		// 提示修改意见
		showState2(outRepositoryVO.geterrorMsg());
	}

	private void disableComponents() {
		DeliveryidText.setEditable(false);
		outrepositoryYear.setEditable(false);
		dateChoose.setEnabled(false);
//		outrepositoryMonth.setEditable(false);
//		outrepositoryDay.setEditable(false);
		arrivalidText.setEditable(false);
		loadingwayText.setEnabled(false);
		wayidText.setEditable(false);
	}

	private void enableComponents() {
		DeliveryidText.setEditable(true);
		outrepositoryYear.setEditable(true);
		dateChoose.setEnabled(true);
//		outrepositoryMonth.setEditable(true);
//		outrepositoryDay.setEditable(true);
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

	private void setinfo(OutRepositoryVO outRepositoryVO) {
//		String[] outdate = outRepositoryVO.getoutrepositorydate().split("-");
		outrepositoryYear.setText(outRepositoryVO.getoutrepositorydate());
//		outrepositoryMonth.setText(outdate[1]);
//		outrepositoryDay.setText(outdate[2]);
		arrivalidText.setText(outRepositoryVO.getarrivalid());
		String WAY = null;
		switch (outRepositoryVO.getway()) {
		case PLANE:
			WAY = "飞机";
			break;
		case TRAIN:
			WAY = "火车";
			break;
		case TRUCK:
			WAY = "汽车";
			break;
		}
		loadingwayText.setSelectedItem(WAY);
		wayidText.setText(outRepositoryVO.getloadingid());
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
