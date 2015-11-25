package ui.transitionui.transferringui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import ui.baseui.DetailPanel;
import ui.transitionui.loadingui.AddLoadingPanel;
import vo.transitionVO.TransferringVO;

public class FindTransferringPanel extends DetailPanel{
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

	private JButton find = new JButton("查询");

	private JButton cancle1 = new JButton("取消查询");

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
	public FindTransferringPanel() {
		// TODO Auto-generated constructor stub
		super();
		// 下拉框设置
		container.setLayout(null);
		container.setPreferredSize(new Dimension(CONTAINER_W, CONTAINER_H));
		jScrollPane.setBounds(0, 0, DETAIL_PANEL_W, DETAIL_PANEL_H);
		jScrollPane.setViewportView(this.container);
		jScrollPane.getVerticalScrollBar().setUnitIncrement(15);
		super.add(jScrollPane);
		//添加查询组件
		transferringid.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		container.add(transferringid);
		transferringidText.setBounds(transferringid.getX()+transferringid.getWidth()+COMPONENT_GAP_X, transferringid.getY(), TEXTid_W, TEXT_H);
		container.add(transferringidText);
		find.setBounds(transferringidText.getX()+transferringidText.getWidth()+COMPONENT_GAP_X, transferringidText.getY(), LABEL_W, LABEL_H);
		container.add(find);
		cancle1.setBounds(find.getX()+find.getWidth()+COMPONENT_GAP_X, find.getY(), LABEL_W, LABEL_H);
		container.add(cancle1);
		// 主面板
		this.infoPanel.setBounds(transferringid.getX(), transferringid.getY()+transferringid.getHeight()+COMPONENT_GAP_Y, DETAIL_PANEL_W,
						START_Y + (LABEL_H + COMPONENT_GAP_Y) * 6 + Area_H - 40);
		this.infoPanel.setLayout(null);
		container.add(infoPanel);
		this.infoPanel.setVisible(false);
		// 初始化信息面板
		this.initUI();
		//状态信息
		this.state.setBounds(transferringid.getX(),transferringid.getY()+transferringid.getHeight()+AddLoadingPanel.COMPONENT_GAP_Y,
								(AddLoadingPanel.BUTTON_W<<2), AddLoadingPanel.BUTTON_W);
		this.state.setFont(AddLoadingPanel.WORD_FONT);
		this.state.setForeground(Color.RED);
		this.container.add(state);
		// 添加事件监听
		this.addListener();
		
		
	}
	
	private void initUI(){
		
		JLabel apart1 = new JLabel("-");
		JLabel apart2 = new JLabel("-");
		loadingdate.setBounds(0,0, LABEL_W, LABEL_H);
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
	
	private void addListener(){
		find.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String transferringID = transferringidText.getText().trim();
				TransferringVO transferringVO = transferringBLService.findTransferringFormBL(transferringID);
				if (transferringVO!=null) {
					//设置当前的信息面板可见
					infoPanel.setVisible(true);
					//设置细节信息面板为将要显示的内容
					setinfo(transferringVO);
					//设置相关面板可见
					state.setVisible(false);
					//重新布局
					revalidate();
				}
				else{
					//设置当前的信息面板不可见
					infoPanel.setVisible(false);
					
					state.setVisible(true);
					showState("中转单编号错误或中转单编号不存在！");
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
	}
	
	private void setinfo(TransferringVO transferringVO){
		String LoadingDate = transferringVO.getloadingdate();
		String[] Date = LoadingDate.split("-");
		this.loadingdateTextyear.setText(Date[0].trim());
		this.loadingdateTextmonth.setText(Date[1].trim());
		this.loadingdateTextday.setText(Date[2].trim());
		switch (transferringVO.getway()) {
		case PLANE:
			loadingway.setToolTipText("飞机");
			break;
		case TRAIN:
			loadingway.setToolTipText("火车");
			break;
		case TRUCK:
			loadingway.setToolTipText("汽车");
			break;
		}
		this.loadingwayidText.setText(transferringVO.getwayid().trim());
		this.departureidText.setText(transferringVO.getdepartureid().trim());
		this.arrivalidText.setText(transferringVO.getarrivalid().trim());
		this.supervisionidText.setText(transferringVO.getsupervisionid().trim());
		this.containeridText.setText(transferringVO.getcontainerid().trim());
		List<String> deliveryID = transferringVO.getalldeliveryid();
		for (String str: deliveryID){
			alldeliveryidText.append(str+"\n");
		}
		this.fareText.setText(transferringVO.getfare()+"");	
	}
	
	private void showState(String msg) {
		this.state.setText(msg);
		this.repaint();
	}
}
