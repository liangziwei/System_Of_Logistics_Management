package ui.transitionui.receivingui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import businessLogic.businessLogicController.transitionController.ReceivingController;
import businessLogicService.transitionBLService.ReceivingBLService;
import constant.CargoState;
import ui.DateChooser;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;
import ui.transitionui.loadingui.AddLoadingPanel;
import vo.transitionVO.ReceivingVO;

public class ModifyReceivingPanel extends DetailPanel {
	private ReceivingBLService receivingService = new ReceivingController();
	
	private DateChooser dateChoose=DateChooser.getInstance();
//	// 添加下拉框
//	private JScrollPane jScrollPane = new JScrollPane();
//	private JPanel container = new JPanel();
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

//	private JTextField arrivaldateTextmonth = new JTextField();
//
//	private JTextField arrivaldateTextday = new JTextField();

	private JTextField transitionidText = new JTextField();

	private JTextField departureidText = new JTextField();

	private JTextField arrivalidText = new JTextField();

	private JPanel infoPanel = new JPanel();

	private JPanel buttonPanel = new JPanel();

	private LimpidButton find = new LimpidButton("","picture/查询.png");

	private LimpidButton cancel1 = new LimpidButton("","picture/取消.png");

	private LimpidButton ok = new LimpidButton("","picture/确定.png");

	private LimpidButton cancle2 = new LimpidButton("","picture/取消.png");

	public static Font WORD_FONT = new Font("宋体", Font.PLAIN, 15);

	private JLabel state1 = new JLabel("", JLabel.CENTER);

	private JLabel state2 = new JLabel();

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

	public ModifyReceivingPanel() {
		// TODO Auto-generated constructor stub
		super();
		//下拉框设置
//		container.setLayout(null);
//		container.setPreferredSize(new Dimension(CONTAINER_W, CONTAINER_H));
//		jScrollPane.setBounds(0, 0,DETAIL_PANEL_W, DETAIL_PANEL_H);
//		jScrollPane.setViewportView(this.container);
//		jScrollPane.getVerticalScrollBar().setUnitIncrement(15);
//		super.add(jScrollPane);
				
		transferringid.setBounds(START_X, START_Y/2, LABEL_W, LABEL_H);
		this.add(transferringid);
		transferringidText.setBounds(transferringid.getX() + transferringid.getWidth() + COMPONENT_GAP_X,
				transferringid.getY(), TEXTid_W, TEXT_H);
		transferringidText.setOpaque(false);
		this.add(transferringidText);
		find.setBounds(transferringidText.getX() + transferringidText.getWidth() + COMPONENT_GAP_X,
				transferringid.getY(), BUTTON_W, BUTTON_H);
		this.add(find);
		cancel1.setBounds(find.getX() + find.getWidth() + COMPONENT_GAP_X, find.getY(), BUTTON_W, BUTTON_H);
		this.add(cancel1);

		// 主信息面板设置
		infoPanel.setBounds(transferringid.getX(), transferringid.getY() + transferringid.getHeight() + COMPONENT_GAP_Y,
				AddLoadingPanel.DETAIL_PANEL_W, AddLoadingPanel.START_Y + (LABEL_H + COMPONENT_GAP_Y) * 3-20);
		this.infoPanel.setLayout(null);
		infoPanel.setOpaque(false);
		this.add(infoPanel);
		this.infoPanel.setVisible(false);
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
		buttonPanel.setOpaque(false);
		this.add(buttonPanel);
		this.buttonPanel.setVisible(false);

		// 状态信息1
		this.state1.setBounds(transferringid.getX(),
				transferringid.getY() + transferringid.getHeight() + AddLoadingPanel.COMPONENT_GAP_Y,
				(AddLoadingPanel.BUTTON_W << 2), AddLoadingPanel.BUTTON_W);
		this.state1.setFont(AddLoadingPanel.WORD_FONT);
		this.state1.setForeground(Color.RED);
		this.add(state1);
		
		//状态信息2
		this.state2.setBounds(AddLoadingPanel.START_X, this.buttonPanel.getY() - BUTTON_H, (BUTTON_W<<2), BUTTON_W);
		this.state2.setFont(WORD_FONT);
		this.state2.setForeground(Color.RED);
		this.add(state2);
		this.state2.setVisible(false);
		// 添加事件监听
		this.addListener();
	}

	private void initUI() {
		// 到达日期
		arrivaldate.setBounds(0, 0, LABEL_W, LABEL_H);
		this.infoPanel.add(arrivaldate);
		arrivaldateTextyear.setBounds(arrivaldate.getX() + arrivaldate.getWidth() + COMPONENT_GAP_X, arrivaldate.getY(),
				(TEXT_W / 2)*3, TEXT_H);
		dateChoose.register(arrivaldateTextyear);
		arrivaldateTextyear.setOpaque(false);
		this.infoPanel.add(arrivaldateTextyear);
//		JLabel apart1 = new JLabel("-");
//		JLabel apart2 = new JLabel("-");
//		apart1.setBounds(arrivaldateTextyear.getX() + arrivaldateTextyear.getWidth(), arrivaldateTextyear.getY(), 10,
//				TEXT_H);
//		this.infoPanel.add(apart1);
//		arrivaldateTextmonth.setBounds(apart1.getX() + apart1.getWidth(), arrivaldate.getY(), TEXT_W / 2, TEXT_H);
//		this.infoPanel.add(arrivaldateTextmonth);
//		apart2.setBounds(arrivaldateTextmonth.getX() + arrivaldateTextmonth.getWidth(), arrivaldate.getY(), 10, TEXT_H);
//		this.infoPanel.add(apart2);
//		arrivaldateTextday.setBounds(apart2.getX() + apart2.getWidth(), arrivaldate.getY(), TEXT_W / 2, TEXT_H);
//		this.infoPanel.add(arrivaldateTextday);
		// 本中转中心编号
		transitionid.setBounds(arrivaldate.getX(), arrivaldate.getY() + arrivaldate.getHeight() + COMPONENT_GAP_Y,
				LABEL_W +11, LABEL_H);

		this.infoPanel.add(transitionid);
		transitionidText.setBounds(transitionid.getX() + transitionid.getWidth() + COMPONENT_GAP_X,
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
		find.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String receivingid = transferringidText.getText().trim();
				ReceivingVO receivingVO = receivingService.findReceivingformBL(receivingid);
				if (receivingVO!=null) {
					// 设置当前的信息面板可见
					infoPanel.setVisible(true);
					// 设置细节信息面板为将要显示的内容
					setinfo(receivingVO);
					// 设置相关面板可见
					buttonPanel.setVisible(true);
					state2.setVisible(true);
					
					state1.setVisible(false);
					// 重新布局
					revalidate();
				}else {
					//设置当前的信息面板可见
					infoPanel.setVisible(false);
					//设置相关面板可见
					buttonPanel.setVisible(false);
					state2.setVisible(false);
					
					state1.setVisible(true);
					//重新布局
					revalidate();
					showState1("接收单编号错误或接收单编号不存在！");
				}
			}
		});
		cancel1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				transferringidText.setText("");
			}
		});
		
		this.ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//创建接收单对象
				ReceivingVO receivingVO = creatReceivingVO();
				//验证输入是否规范
				boolean result = receivingService.verify(receivingVO);
				
				if (result) {
					//重置接受单时间
					receivingVO.setarrivaldate(arrivaldateTextyear.getText().trim());
					throughVerifyOperation(receivingVO);   //验证成功
					cancle2.setVisible(true);
				}
				else {
					verifyFailOperation(receivingVO);   //验证失败
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
	
	
	private void throughVerifyOperation(ReceivingVO receivingVO) {
		//使所有组件不可编辑
		disableComponents();
		
		if(isFirstEnsure) {
			showState2("请再次确认信息，无误后按确定，否则按取消");
			isFirstEnsure = false;
		}
		else {
			//添加装运信息
			boolean save =receivingService.modifyReceivingFormBL(receivingVO);
			if(save) {		//保存成功
				showState2("订单修改成功");
				disableComponents();
			}else {			//TODO 保存失败，说明保存失败的原因或者提出建议
				showState2("订单修改失败");
			}
		}
	}
	
	private void verifyFailOperation(ReceivingVO receivingVO) {
		//提示修改意见
		showState2(receivingVO.geterrorMsg());
	}
	
	private ReceivingVO creatReceivingVO() {
		String transfer = transferringidText.getText().trim();
		String arrdate = arrivaldateTextyear.getText().trim();
		String transition = transitionidText.getText().trim();
		String depart = departureidText.getText().trim();
		String arrive = arrivalidText.getText().trim();
		String stat = (String) endState.getSelectedItem();
		CargoState state =null;
		switch (stat) {
		case "损坏":
			state = CargoState.损坏;
			break;
		case "完整":
			state =CargoState.完整;
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
//		arrivaldateTextmonth.setEditable(false);
//		arrivaldateTextday.setEditable(false);
		departureidText.setEditable(false);
		arrivalidText.setEditable(false);
		endState.setEnabled(false);
	}
	
	private void enableComponents() {
		transferringidText.setEditable(true);
		transitionidText.setEditable(true);
		arrivaldateTextyear.setEditable(true);
		dateChoose.setEnabled(true);
//		arrivaldateTextmonth.setEditable(true);
//		arrivaldateTextday.setEditable(true);
		departureidText.setEditable(true);
		arrivalidText.setEditable(true);
		endState.setEnabled(true);
	}
	
	private void setinfo(ReceivingVO receivingVO) {
//		String[] ArrivalDate = receivingVO.getarrivaldate().split("-");
		arrivaldateTextyear.setText(receivingVO.getarrivaldate());
//		arrivaldateTextmonth.setText(ArrivalDate[1]);
//		arrivaldateTextday.setText(ArrivalDate[2]);
		transitionidText.setText(receivingVO.gettransitionid());
		departureidText.setText(receivingVO.getdepartureid());
		arrivalidText.setText(receivingVO.getarrivalid());
		switch (receivingVO.getstate()) {
		case 损坏:
			this.endState.setSelectedItem("损坏");
			break;
		case 完整:
			this.endState.setSelectedItem("完整");
			break;
		case 丢失:
			this.endState.setSelectedItem("丢失");
			break;
		}
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
