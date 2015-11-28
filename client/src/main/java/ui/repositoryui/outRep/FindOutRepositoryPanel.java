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
import ui.baseui.DetailPanel;
import ui.transitionui.loadingui.AddLoadingPanel;
import vo.repositoryVO.InRepositoryVO;
import vo.repositoryVO.OutRepositoryVO;

public class FindOutRepositoryPanel extends DetailPanel{
	private OutRepositoryBLService outRepositoryBLService = new OutRepositoryController();
	// 组件
	private JLabel Deliveryid = new JLabel("快递编号");
	private JLabel outrepositorydate = new JLabel("出库日期");
	private JLabel arrivalid = new JLabel("目的地");
	private JLabel loadingway = new JLabel("装运形式");
	private JLabel wayid = new JLabel("装运信息编号");

	private JTextField DeliveryidText = new JTextField();
	private JTextField outrepositoryYear = new JTextField();
	private JTextField outrepositoryMonth = new JTextField();
	private JTextField outrepositoryDay = new JTextField();
	private JTextField arrivalidText = new JTextField();
	private JComboBox<String> loadingwayText = new JComboBox<String>();
	private JTextField wayidText = new JTextField();

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
	
	public FindOutRepositoryPanel() {
		// TODO Auto-generated constructor stub
		super();
		//查询相关组件
		Deliveryid.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.add(Deliveryid);
		DeliveryidText.setBounds(Deliveryid.getX()+Deliveryid.getWidth()+COMPONENT_GAP_X, Deliveryid.getY(), TEXTid_W, TEXT_H);
		this.add(DeliveryidText);
		find.setBounds(DeliveryidText.getX()+DeliveryidText.getWidth()+COMPONENT_GAP_X, DeliveryidText.getY(), LABEL_W, LABEL_H);
		this.add(find);
		cancle.setBounds(find.getX()+find.getWidth()+COMPONENT_GAP_X, find.getY(), LABEL_W, LABEL_H);
		this.add(cancle);
		//信息面板
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
	
	private void initUI(){
		// 出库日期
		outrepositorydate.setBounds(0, 0,LABEL_W, LABEL_H);
		this.infoPanel.add(outrepositorydate);
		outrepositoryYear.setBounds(outrepositorydate.getX() + outrepositorydate.getWidth() + COMPONENT_GAP_X,
				outrepositorydate.getY(), TEXT_W / 2, TEXT_H);
		this.infoPanel.add(outrepositoryYear);
		JLabel apart1 = new JLabel("-");
		JLabel apart2 = new JLabel("-");
		apart1.setBounds(outrepositoryYear.getX() + outrepositoryYear.getWidth(), outrepositoryYear.getY(), 10, TEXT_H);
		this.infoPanel.add(apart1);
		outrepositoryMonth.setBounds(apart1.getX() + apart1.getWidth(), apart1.getY(), TEXT_W / 2, TEXT_H);
		this.infoPanel.add(outrepositoryMonth);
		apart2.setBounds(outrepositoryMonth.getX() + outrepositoryMonth.getWidth(), outrepositoryMonth.getY(), 10,
				TEXT_H);
		this.infoPanel.add(apart2);
		outrepositoryDay.setBounds(apart2.getX() + apart2.getWidth(), apart2.getY(), TEXT_W / 2, TEXT_H);
		this.infoPanel.add(outrepositoryDay);
		// 目的地
		arrivalid.setBounds(outrepositorydate.getX(),
				outrepositorydate.getY() + outrepositorydate.getHeight() + COMPONENT_GAP_Y, LABEL_W, LABEL_H);
		this.infoPanel.add(arrivalid);
		arrivalidText.setBounds(arrivalid.getX() + arrivalid.getWidth() + COMPONENT_GAP_X, arrivalid.getY(), TEXT_W,
				TEXT_H);
		this.infoPanel.add(arrivalidText);
		//装运形式
		loadingway.setBounds(arrivalidText.getX()+arrivalidText.getWidth()+COMPONENT_GAP_X, arrivalidText.getY(), LABEL_W, LABEL_H);
		this.infoPanel.add(loadingway);
		loadingwayText.setBounds(loadingway.getX()+loadingway.getWidth()+COMPONENT_GAP_X, loadingway.getY(),  TEXT_W, TEXT_H);
		loadingwayText.addItem("飞机");
		loadingwayText.addItem("火车");
		loadingwayText.addItem("汽车");
		this.infoPanel.add(loadingwayText);
		//装运信息编号
		wayid.setBounds(arrivalid.getX(), arrivalid.getY()+arrivalid.getHeight()+COMPONENT_GAP_Y, LABEL_W, LABEL_H);
		this.infoPanel.add(wayid);
		wayidText.setBounds(wayid.getX()+wayid.getWidth()+COMPONENT_GAP_X, wayid.getY(), TEXTid_W, TEXT_H);
		this.infoPanel.add(wayidText);
	}
	private void addListener(){
		find.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				String deliveryID = DeliveryidText.getText().trim();
				OutRepositoryVO outRepositoryVO = outRepositoryBLService.findOutRepositoryFormBL(deliveryID);
				if (outRepositoryVO!=null) {
					//设置当前的信息面板可见
					infoPanel.setVisible(true);
					//设置细节信息面板为将要显示的内容
					setinfo(outRepositoryVO);
					//设置相关面板可见
					state.setVisible(false);
					//重新布局
					revalidate();
				}
				else {
					//设置当前的信息面板不可见
					infoPanel.setVisible(false);
					
					state.setVisible(true);
					showState("出库单编号错误或出库单不存在！");
				}
			}
		});
		
		cancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DeliveryidText.setText("");
			}
		});
	}
	
	private void setinfo(OutRepositoryVO outRepositoryVO) {
		String[] outdate  = outRepositoryVO.getoutrepositorydate().split("-");
		outrepositoryYear.setText(outdate[0]);
		outrepositoryMonth.setText(outdate[1]);
		outrepositoryDay.setText(outdate[2]);
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
		loadingwayText.setToolTipText(WAY);
		wayidText.setText(outRepositoryVO.getloadingid());
	}
	
	private void showState(String msg) {
		this.state.setText(msg);
		this.repaint();
	}

}
