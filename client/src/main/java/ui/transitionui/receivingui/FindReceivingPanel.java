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
import ui.baseui.DetailPanel;
import ui.transitionui.loadingui.AddLoadingPanel;
import vo.transitionVO.ReceivingVO;

public class FindReceivingPanel extends DetailPanel {
	private ReceivingBLService receivingService = new ReceivingController();
	// 添加下拉框
	private JScrollPane jScrollPane = new JScrollPane();
	private JPanel container = new JPanel();
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

	private JTextField arrivaldateTextmonth = new JTextField();

	private JTextField arrivaldateTextday = new JTextField();

	private JTextField transitionidText = new JTextField();

	private JTextField departureidText = new JTextField();

	private JTextField arrivalidText = new JTextField();

	private JPanel infoPanel = new JPanel();

	private JButton find = new JButton("查询");

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

	public FindReceivingPanel() {
		// TODO Auto-generated constructor stub
		super();
		// 下拉框设置
		container.setLayout(null);
		container.setPreferredSize(new Dimension(CONTAINER_W, CONTAINER_H));
		jScrollPane.setBounds(0, 0, DETAIL_PANEL_W, DETAIL_PANEL_H);
		jScrollPane.setViewportView(this.container);
		jScrollPane.getVerticalScrollBar().setUnitIncrement(15);
		super.add(jScrollPane);
				
		transferringid.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.container.add(transferringid);
		transferringidText.setBounds(transferringid.getX() + transferringid.getWidth() + COMPONENT_GAP_X,
				transferringid.getY(), TEXTid_W, TEXT_H);
		this.container.add(transferringidText);
		find.setBounds(transferringidText.getX() + transferringidText.getWidth() + COMPONENT_GAP_X,
				transferringid.getY(), BUTTON_W, BUTTON_H);
		this.container.add(find);
		cancel.setBounds(find.getX() + find.getWidth() + COMPONENT_GAP_X, find.getY(), BUTTON_W, BUTTON_H);
		this.container.add(cancel);

		// 主信息面板设置
		infoPanel.setBounds(transferringid.getX(), transferringid.getY() + transferringid.getHeight() + COMPONENT_GAP_Y,
				AddLoadingPanel.DETAIL_PANEL_W, AddLoadingPanel.START_Y + (LABEL_H + COMPONENT_GAP_Y) * 5 + Area_H);
		this.infoPanel.setLayout(null);
		this.container.add(infoPanel);
		this.infoPanel.setVisible(false);
		// 初始化信息面板
		this.initUI();

		// 状态信息
		this.state.setBounds(transferringid.getX(),
				transferringid.getY() + transferringid.getHeight() + AddLoadingPanel.COMPONENT_GAP_Y,
				(AddLoadingPanel.BUTTON_W << 2), AddLoadingPanel.BUTTON_W);
		this.state.setFont(AddLoadingPanel.WORD_FONT);
		this.state.setForeground(Color.RED);
		this.container.add(state);
		// 添加事件监听
		this.addListener();
	}

	private void initUI() {
		// 到达日期
		arrivaldate.setBounds(0, 0, LABEL_W, LABEL_H);
		this.infoPanel.add(arrivaldate);
		arrivaldateTextyear.setBounds(arrivaldate.getX() + arrivaldate.getWidth() + COMPONENT_GAP_X, arrivaldate.getY(),
				TEXT_W / 2, TEXT_H);
		this.infoPanel.add(arrivaldateTextyear);
		JLabel apart1 = new JLabel("-");
		JLabel apart2 = new JLabel("-");
		apart1.setBounds(arrivaldateTextyear.getX() + arrivaldateTextyear.getWidth(), arrivaldateTextyear.getY(), 10,
				TEXT_H);
		this.infoPanel.add(apart1);
		arrivaldateTextmonth.setBounds(apart1.getX() + apart1.getWidth(), arrivaldate.getY(), TEXT_W / 2, TEXT_H);
		this.infoPanel.add(arrivaldateTextmonth);
		apart2.setBounds(arrivaldateTextmonth.getX() + arrivaldateTextmonth.getWidth(), arrivaldate.getY(), 10, TEXT_H);
		this.infoPanel.add(apart2);
		arrivaldateTextday.setBounds(apart2.getX() + apart2.getWidth(), arrivaldate.getY(), TEXT_W / 2, TEXT_H);
		this.infoPanel.add(arrivaldateTextday);
		// 本中转中心编号
		transitionid.setBounds(arrivaldate.getX(), arrivaldate.getY() + arrivaldate.getHeight() + COMPONENT_GAP_Y,
				LABEL_W + 20, LABEL_H);

		this.infoPanel.add(transitionid);
		transitionidText.setBounds(transferringid.getX() + transitionid.getWidth() + COMPONENT_GAP_X,
				transitionid.getY(), TEXTid_W, TEXT_H);
		this.infoPanel.add(transitionidText);
		// 出发地
		departureid.setBounds(transitionid.getX(), transitionid.getY() + transitionid.getHeight() + COMPONENT_GAP_Y,
				LABEL_W, LABEL_H);
		this.infoPanel.add(departureid);
		departureidText.setBounds(departureid.getX() + departureid.getWidth() + COMPONENT_GAP_X, departureid.getY(),
				TEXT_W, TEXT_H);
		this.infoPanel.add(departureidText);
		// 到达地
		arrivalid.setBounds(departureidText.getX() + departureidText.getWidth() + COMPONENT_GAP_Y, departureid.getY(),
				LABEL_W, LABEL_H);
		this.infoPanel.add(arrivalid);
		arrivalidText.setBounds(arrivalid.getX() + arrivalid.getWidth() + COMPONENT_GAP_X, arrivalid.getY(), TEXT_W,
				TEXT_H);
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
				if (receivingVO.getVerifyResult()) {
					//设置当前的信息面板可见
					infoPanel.setVisible(true);
					//设置细节信息面板为将要显示的内容
					setinfo(receivingVO);
					//设置相关面板可见
					state.setVisible(false);
					//重新布局
					revalidate();
				}
				else {
					showState("接收单编号错误或接收单编号不存在！");
				}
			}
		});
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				transferringidText.setText("");
			}
		});
	}

	private void setinfo(ReceivingVO receivingVO) {
		String[] ArrivalDate = receivingVO.getarrivaldate().split("-");
		arrivaldateTextyear.setText(ArrivalDate[0]);
		arrivaldateTextmonth.setText(ArrivalDate[1]);
		arrivaldateTextday.setText(ArrivalDate[2]);
		transitionidText.setText(receivingVO.gettransitionid());
		departureidText.setText(receivingVO.getdepartureid());
		arrivalidText.setText(receivingVO.getarrivalid());
		switch (receivingVO.getstate()) {
		case DAMAGE:
			this.endState.setToolTipText("损坏");
			break;
		case INTACT:
			this.endState.setToolTipText("完整");
			break;
		case lOSE:
			this.endState.setToolTipText("丢失");
			break;
		}
	}
	private void showState(String msg) {
		this.state.setText(msg);
		this.repaint();
	}
}
