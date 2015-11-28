package ui.transitionui.loadingui;

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

import businessLogic.businessLogicController.transitionController.LoadingController;
import businessLogicService.transitionBLService.LoadingBLService;
import ui.baseui.DetailPanel;
import vo.transitionVO.LoadingVO;

public class FindLoadingPanel extends DetailPanel{
	private LoadingBLService loadingservice = new LoadingController();
	//添加下拉框
	private JScrollPane jScrollPane =new JScrollPane();
	private JPanel container = new JPanel();
	//组件
	private JLabel loadingid = new JLabel("装运编号");
	
	private JLabel arrivalid = new JLabel("到达地");
	
	private JLabel way = new JLabel("装运方式");
	
	private JLabel wayid = new JLabel("装运方式代号");
	
	private JLabel supervisionid = new JLabel("监装员");
	
	private JLabel supercargoid = new JLabel("押运员");
	
	private JLabel alldeliveryid = new JLabel("本次装箱所有订单条形码号");
	
	private JLabel fare = new JLabel("运费");
	
	private JComboBox<String> wayBox = new JComboBox<String>();
	
	private JTextField loadingidText = new JTextField(11);
	
	private JTextField arrivalidText = new JTextField();
	
	private JTextField wayidText = new JTextField();
	
	private JTextField supervisionidText = new JTextField();
	
	private JTextField supercargoidText = new JTextField();
	
	private JTextField fareText = new JTextField();
	
	private JTextArea alldeliveryidArea = new JTextArea();
	
	private JPanel infoPanel = new JPanel();
	
	private JButton find = new JButton("查询");
	
	private JButton cancle = new JButton("取消查询");
	
	public static Font WORD_FONT = new Font("宋体", Font.PLAIN, 15);
	
	private JLabel state = new JLabel();
	
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
	
	public FindLoadingPanel() {
		// TODO Auto-generated constructor stub
		super();
		//下拉框设置
		container.setLayout(null);
		container.setPreferredSize(new Dimension(CONTAINER_W, CONTAINER_H));
		jScrollPane.setBounds(0, 0,DETAIL_PANEL_W, DETAIL_PANEL_H);
		jScrollPane.setViewportView(this.container);
		jScrollPane.getVerticalScrollBar().setUnitIncrement(15);
		super.add(jScrollPane);
		
		//查询的相关组件
		loadingid.setBounds(AddLoadingPanel.START_X, AddLoadingPanel.START_Y, AddLoadingPanel.LABEL_W, AddLoadingPanel.LABEL_H);
		this.container.add(this.loadingid);
		loadingidText.setBounds(loadingid.getX()+loadingid.getWidth()+AddLoadingPanel.COMPONENT_GAP_X,loadingid.getY(),
				AddLoadingPanel.TEXTid_W,AddLoadingPanel.TEXT_H);
		this.container.add(this.loadingidText);
		find.setBounds(loadingidText.getX()+loadingidText.getWidth()+AddLoadingPanel.COMPONENT_GAP_X,loadingid.getY(),
				AddLoadingPanel.LABEL_W, AddLoadingPanel.LABEL_H);
		this.container.add(find);
		cancle.setBounds(find.getX()+find.getWidth()+AddLoadingPanel.COMPONENT_GAP_X, loadingid.getY(), 
				AddLoadingPanel.LABEL_W, AddLoadingPanel.LABEL_H);
		this.container.add(cancle);
		
		//信息面板的相关操作
		this.infoPanel.setBounds(loadingid.getX(),loadingid.getY()+loadingid.getHeight()+COMPONENT_GAP_Y,
				AddLoadingPanel.DETAIL_PANEL_W,AddLoadingPanel.START_Y+(LABEL_H+COMPONENT_GAP_Y)*5+Area_H);
		this.infoPanel.setLayout(null);
		this.container.add(infoPanel);
		this.infoPanel.setVisible(false);
		//初始化信息面板
		this.initUI();
		
		//状态信息
		this.state.setBounds(loadingid.getX(),loadingid.getY()+loadingid.getHeight()+AddLoadingPanel.COMPONENT_GAP_Y,
						(AddLoadingPanel.BUTTON_W<<2), AddLoadingPanel.BUTTON_W);
		this.state.setFont(AddLoadingPanel.WORD_FONT);
		this.state.setForeground(Color.RED);
		this.container.add(state);
		//添加事件监听
		this.addListener();
	
	}
	
	private void initUI(){
		arrivalid.setBounds(0, 0, LABEL_W, LABEL_H);
		this.infoPanel.add(arrivalid);
		arrivalidText.setBounds(arrivalid.getX()+arrivalid.getWidth()+COMPONENT_GAP_X,arrivalid.getY(),TEXT_W,TEXT_H);
		this.infoPanel.add(arrivalidText);
		way.setBounds(arrivalidText.getX()+arrivalidText.getWidth()+COMPONENT_GAP_X, arrivalid.getY(),LABEL_W, LABEL_H);
		this.infoPanel.add(way);
		wayBox.setBounds(way.getX()+way.getWidth()+COMPONENT_GAP_X, way.getY(), TEXT_W, TEXT_H);
		wayBox.addItem("飞机");
		wayBox.addItem("火车");
		wayBox.addItem("汽车");
		this.infoPanel.add(wayBox);
		wayid.setBounds(arrivalid.getX(), arrivalid.getY()+LABEL_H+COMPONENT_GAP_Y, LABEL_W, LABEL_H);
		this.infoPanel.add(wayid);
		wayidText.setBounds(wayid.getX()+wayid.getWidth()+COMPONENT_GAP_X, wayid.getY(), TEXTid_W, TEXT_H);
		this.infoPanel.add(wayidText);
		supervisionid.setBounds(wayid.getX(), wayid.getY()+LABEL_H+COMPONENT_GAP_Y, LABEL_W, LABEL_H);
		this.infoPanel.add(supervisionid);
		supervisionidText.setBounds(supervisionid.getX()+supervisionid.getWidth()+COMPONENT_GAP_X, supervisionid.getY(), TEXT_W, TEXT_H);
		this.infoPanel.add(supervisionidText);
		supercargoid.setBounds(supervisionidText.getX()+supervisionidText.getWidth()+COMPONENT_GAP_X, supervisionid.getY(), LABEL_W, LABEL_H);
		this.infoPanel.add(supercargoid);
		supercargoidText.setBounds(supercargoid.getX()+supercargoid.getWidth()+COMPONENT_GAP_X, supercargoid.getY(), TEXT_W, TEXT_H);
		this.infoPanel.add(supercargoidText);
		alldeliveryid.setBounds(supervisionid.getX(), supervisionid.getY()+supervisionid.getHeight()+COMPONENT_GAP_Y, TEXTid_W,LABEL_H);
		this.infoPanel.add(alldeliveryid);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(alldeliveryid.getX(), alldeliveryid.getY()+alldeliveryid.getHeight(), Area_W,Area_H);
		this.infoPanel.add(scrollPane);
		scrollPane.setViewportView(alldeliveryidArea);
		fare.setBounds(scrollPane.getX(), scrollPane.getY()+Area_H+COMPONENT_GAP_Y, LABEL_W, LABEL_H);
		this.infoPanel.add(fare);
		fareText.setBounds(fare.getX()+fare.getWidth()+COMPONENT_GAP_X, fare.getY(), TEXTid_W, TEXT_H);
		fareText.setBackground(Color.GRAY);
		fareText.setEditable(false);
		this.infoPanel.add(fareText);
	}
	
	public void addListener() {
		find.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String Loadingid = loadingidText.getText().trim();
				LoadingVO loadingVO = loadingservice.findLoadingFormBL(Loadingid);
				if(loadingVO!=null){
					//设置当前的信息面板可见
					infoPanel.setVisible(true);
					//设置细节信息面板为将要显示的内容
					setinfo(loadingVO);
					//设置相关面板可见
					state.setVisible(false);
					//重新布局
					revalidate();
				}
				else {
					//设置当前的信息面板不可见
					infoPanel.setVisible(false);
					
					state.setVisible(true);
					showState("装运单编号错误或装运单编号不存在！");
				}
			}
		});
		
		cancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loadingidText.setText("");;
			}
		});
	}
	
	private void setinfo(LoadingVO loadingVO) {
		this.arrivalidText.setText(loadingVO.getarrivalid());
		switch (loadingVO.getway()) {
		case PLANE:
			this.wayBox.setToolTipText("飞机");
			break;
		case TRAIN:
			this.wayBox.setToolTipText("火车");
			break;
		case TRUCK:
			this.wayBox.setToolTipText("汽车");
			break;
		}
		this.wayidText.setText(loadingVO.getwayid());
		this.supervisionidText.setText(loadingVO.getsupervisionid());
		this.supercargoidText.setText(loadingVO.getsupercargoid());
		this.fareText.setText(loadingVO.getfare()+"");
		List<String> deliveryID = loadingVO.getalldeliveryid();
		for (String str: deliveryID){
			alldeliveryidArea.append(str+"\n");
		}
	}
	
	private void showState(String msg) {
		this.state.setText(msg);
		this.repaint();
	}
}
