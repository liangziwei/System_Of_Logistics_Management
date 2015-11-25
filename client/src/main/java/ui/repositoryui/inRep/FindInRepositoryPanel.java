package ui.repositoryui.inRep;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businessLogic.businessLogicController.repositoryController.InRepositoryController;
import businessLogicService.repositoryBLService.InRepositoryBLService;
import constant.AreaCodeType;
import ui.baseui.DetailPanel;
import ui.transitionui.loadingui.AddLoadingPanel;
import vo.repositoryVO.InRepositoryVO;

public class FindInRepositoryPanel extends DetailPanel {
	private InRepositoryBLService inRepositoryBLService = new InRepositoryController();
	// 组件
	private JLabel Deliveryid = new JLabel("快递编号");
	private JLabel inrepositorydate = new JLabel("入库日期");
	private JLabel arrivalid = new JLabel("目的地");
	private JLabel areaid = new JLabel("区号");
	private JLabel rowid = new JLabel("排号");
	private JLabel shelfid = new JLabel("架号");
	private JLabel posid = new JLabel("位号");

	private JTextField DeliveryidText = new JTextField();
	private JTextField inrepositoryYear = new JTextField();
	private JTextField inrepositoryMonth = new JTextField();
	private JTextField inrepositoryDay = new JTextField();
	private JTextField arrivalidText = new JTextField();
	private JComboBox<String> areaidText = new JComboBox<String>();
	private JTextField rowidText = new JTextField();
	private JTextField shelfidText = new JTextField();
	private JTextField posidText = new JTextField();

	private JPanel infoPanel = new JPanel();
	private JButton find = new JButton("查询");

	private JButton cancle = new JButton("取消查询");

	public static Font WORD_FONT = new Font("宋体", Font.PLAIN, 15);

	private JLabel state = new JLabel("", JLabel.CENTER);

	public static final int LABEL_W = 80;

	public static final int LABEL_H = 40;

	public static final int TEXT_W = LABEL_W << 1;

	public static final int TEXT_H = LABEL_H;

	public static final int TEXTid_W = LABEL_W * 4;

	public static final int Area_H = LABEL_H * 6;

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

	public FindInRepositoryPanel() {
		// TODO Auto-generated constructor stub
		super();
		// 查询设置
		Deliveryid.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.add(Deliveryid);
		DeliveryidText.setBounds(Deliveryid.getX() + Deliveryid.getWidth() + COMPONENT_GAP_X, Deliveryid.getY(),
				TEXTid_W, TEXT_H);
		this.add(DeliveryidText);
		find.setBounds(DeliveryidText.getX() + DeliveryidText.getWidth() + COMPONENT_GAP_X, DeliveryidText.getY(),
				LABEL_W, LABEL_H);
		this.add(find);
		cancle.setBounds(find.getX() + find.getWidth() + COMPONENT_GAP_X, find.getY(), LABEL_W, LABEL_H);
		this.add(cancle);

		// 信息界面
		infoPanel.setBounds(Deliveryid.getX(), Deliveryid.getY() + Deliveryid.getHeight() + COMPONENT_GAP_Y,
				AddLoadingPanel.DETAIL_PANEL_W, START_Y + (LABEL_H + COMPONENT_GAP_Y) * 3);
		infoPanel.setLayout(null);
		infoPanel.setVisible(false);
		this.add(infoPanel);

		// 初始化信息面板
		this.initUI();

		// 状态信息
		this.state.setBounds(Deliveryid.getX(),
				Deliveryid.getY() + Deliveryid.getHeight() + AddLoadingPanel.COMPONENT_GAP_Y,
				(AddLoadingPanel.BUTTON_W << 2), AddLoadingPanel.BUTTON_W);
		this.state.setFont(AddLoadingPanel.WORD_FONT);
		this.state.setForeground(Color.RED);
		this.add(state);
		// 添加事件监听
		this.addListener();
	}

	private void initUI() {
		// 入库日期
		inrepositorydate.setBounds(0, 0, LABEL_W, LABEL_H);
		this.infoPanel.add(inrepositorydate);
		inrepositoryYear.setBounds(inrepositorydate.getX() + inrepositorydate.getWidth() + COMPONENT_GAP_X,
				inrepositorydate.getY(), TEXT_W / 2, TEXT_H);
		this.infoPanel.add(inrepositoryYear);
		JLabel apart1 = new JLabel("-");
		JLabel apart2 = new JLabel("-");
		apart1.setBounds(inrepositoryYear.getX() + inrepositoryYear.getWidth(), inrepositoryYear.getY(), 10, TEXT_H);
		this.infoPanel.add(apart1);
		inrepositoryMonth.setBounds(apart1.getX() + apart1.getWidth(), apart1.getY(), TEXT_W / 2, TEXT_H);
		this.infoPanel.add(inrepositoryMonth);
		apart2.setBounds(inrepositoryMonth.getX() + inrepositoryMonth.getWidth(), inrepositoryMonth.getY(), 10, TEXT_H);
		this.infoPanel.add(apart2);
		inrepositoryDay.setBounds(apart2.getX() + apart2.getWidth(), apart2.getY(), TEXT_W / 2, TEXT_H);
		this.infoPanel.add(inrepositoryDay);
		// 目的地
		arrivalid.setBounds(inrepositorydate.getX(),
				inrepositorydate.getY() + inrepositorydate.getHeight() + COMPONENT_GAP_Y, LABEL_W, LABEL_H);
		this.infoPanel.add(arrivalid);
		arrivalidText.setBounds(arrivalid.getX() + arrivalid.getWidth() + COMPONENT_GAP_X, arrivalid.getY(), TEXT_W,
				TEXT_H);
		this.infoPanel.add(arrivalidText);
		// 区号
		areaid.setBounds(arrivalidText.getX() + arrivalidText.getWidth() + COMPONENT_GAP_Y, arrivalidText.getY(),
				LABEL_W / 2, LABEL_H);
		this.infoPanel.add(areaid);
		areaidText.setBounds(areaid.getX() + areaid.getWidth() + COMPONENT_GAP_X, areaid.getY(), TEXT_W, TEXT_H);
		areaidText.addItem("航运区");
		areaidText.addItem("铁运区");
		areaidText.addItem("汽运区");
		areaidText.addItem("机动区");
		this.infoPanel.add(areaidText);
		// 排号
		rowid.setBounds(arrivalid.getX(), arrivalid.getY() + arrivalid.getHeight() + COMPONENT_GAP_Y, LABEL_W, LABEL_H);
		this.infoPanel.add(rowid);
		rowidText.setBounds(rowid.getX() + rowid.getWidth() + COMPONENT_GAP_X, rowid.getY(), LABEL_W, LABEL_H);
		this.infoPanel.add(rowidText);
		// 架号
		shelfid.setBounds(rowidText.getX() + rowidText.getWidth() + COMPONENT_GAP_Y, rowidText.getY(), LABEL_W / 2,
				LABEL_H);
		this.infoPanel.add(shelfid);
		shelfidText.setBounds(shelfid.getX() + shelfid.getWidth() + COMPONENT_GAP_X, shelfid.getY(), LABEL_W, LABEL_H);
		this.infoPanel.add(shelfidText);
		// 位号
		posid.setBounds(shelfidText.getX() + shelfidText.getWidth() + COMPONENT_GAP_Y, shelfidText.getY(), LABEL_W / 2,
				LABEL_H);
		this.infoPanel.add(posid);
		posidText.setBounds(posid.getX() + posid.getWidth() + COMPONENT_GAP_X, posid.getY(), LABEL_W, LABEL_H);
		this.infoPanel.add(posidText);
	}

	private void addListener() {
		this.find.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String deliveryID = DeliveryidText.getText().trim();
				InRepositoryVO inRepositoryVO = inRepositoryBLService.findInRepositoryFormBL(deliveryID);
				if (inRepositoryVO!=null) {
					//设置当前的信息面板可见
					infoPanel.setVisible(true);
					//设置细节信息面板为将要显示的内容
					setinfo(inRepositoryVO);
					//设置相关面板可见
					state.setVisible(false);
					//重新布局
					revalidate();
				}
				else {
					//设置当前的信息面板不可见
					infoPanel.setVisible(false);
					
					state.setVisible(true);
					showState("入库单编号错误或入库单不存在！");
				}
			}
		});
		
		this.cancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DeliveryidText.setText("");
			}
		});
	}
	
	private void setinfo(InRepositoryVO inRepositoryVO) {
		String[] inrepositorydate = inRepositoryVO.getinrepositorydate().split("-");
		inrepositoryYear.setText(inrepositorydate[0].trim());
		inrepositoryMonth.setText(inrepositorydate[1].trim());
		inrepositoryDay.setText(inrepositorydate[2].trim());
		arrivalidText.setText(inRepositoryVO.getarrivalid().trim());
		rowidText.setText(inRepositoryVO.getrowid().trim());
		shelfidText.setText(inRepositoryVO.getshelfid().trim());
		posidText.setText(inRepositoryVO.getposid().trim());
		switch (inRepositoryVO.getareaCode()) {
		case PLANEAREA:
			this.areaidText.setToolTipText("航运区");
			break;
		case TRAINAREA:
			this.areaidText.setToolTipText("铁运区");
			break;
		case TRUCKAREA:
			this.areaidText.setToolTipText("汽运区");
			break;
		case MOTOAREA:
			this.areaidText.setToolTipText("机动区");
			break;
		}
	}
	
	private void showState(String msg) {
		this.state.setText(msg);
		this.repaint();
	}
}
