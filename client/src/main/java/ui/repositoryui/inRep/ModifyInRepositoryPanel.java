package ui.repositoryui.inRep;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businessLogic.businessLogicController.repositoryController.InRepositoryController;
import businessLogicService.repositoryBLService.InRepositoryBLService;
import constant.AreaCodeType;
import ui.DateChooser;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;
import ui.transitionui.loadingui.AddLoadingPanel;
import vo.repositoryVO.InRepositoryVO;

public class ModifyInRepositoryPanel extends DetailPanel {
	private InRepositoryBLService inRepositoryBLService = new InRepositoryController();
	
	private DateChooser dateChoose=DateChooser.getInstance();
	// 组件
	private JLabel Deliveryid = new JLabel("快递编号");
	private JLabel inrepositorydate = new JLabel("入库日期");
	private JLabel arrivalid = new JLabel("目的地");
	private JLabel transition = new JLabel("中转中心编号");
	private JLabel areaid = new JLabel("区号");
	private JLabel rowid = new JLabel("排号");
	private JLabel shelfid = new JLabel("架号");
	private JLabel posid = new JLabel("位号");

	private JTextField DeliveryidText = new JTextField();
	private JTextField inrepositoryYear = new JTextField();
	private JTextField transitionid = new JTextField();
//	private JTextField inrepositoryMonth = new JTextField();
//	private JTextField inrepositoryDay = new JTextField();
	private JTextField arrivalidText = new JTextField();
	private JComboBox<String> areaidText = new JComboBox<String>();
	private JTextField rowidText = new JTextField();
	private JTextField shelfidText = new JTextField();
	private JTextField posidText = new JTextField();

	private JPanel infoPanel = new JPanel();

	private JPanel buttonPanel = new JPanel();

	private LimpidButton find = new LimpidButton("","picture/查询.png");

	private LimpidButton cancle1 = new LimpidButton("","picture/取消.png");

	private LimpidButton ok = new LimpidButton("","picture/确定.png");

	private LimpidButton cancle2 = new LimpidButton("","picture/取消.png");

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

	public ModifyInRepositoryPanel() {
		// TODO Auto-generated constructor stub
		super();
		// 查询设置
		Deliveryid.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.add(Deliveryid);
		DeliveryidText.setBounds(Deliveryid.getX() + Deliveryid.getWidth() + COMPONENT_GAP_X, Deliveryid.getY(),
				TEXTid_W, TEXT_H);
		DeliveryidText.setOpaque(false);
		this.add(DeliveryidText);
		find.setBounds(DeliveryidText.getX() + DeliveryidText.getWidth() + COMPONENT_GAP_X, DeliveryidText.getY(),
				LABEL_W, LABEL_H);
		this.add(find);
		cancle1.setBounds(find.getX() + find.getWidth() + COMPONENT_GAP_X, find.getY(), LABEL_W, LABEL_H);
		this.add(cancle1);

		// 信息界面
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
		this.buttonPanel.setOpaque(false);

		// 状态信息1
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
		// 入库日期
		inrepositorydate.setBounds(0, 0, LABEL_W, LABEL_H);
		this.infoPanel.add(inrepositorydate);
		inrepositoryYear.setBounds(inrepositorydate.getX() + inrepositorydate.getWidth() + COMPONENT_GAP_X,
				inrepositorydate.getY(), (TEXT_W), TEXT_H);
		inrepositoryYear.setOpaque(false);
		dateChoose.register(inrepositoryYear);
		this.infoPanel.add(inrepositoryYear);
		transition.setBounds(inrepositoryYear.getX()+inrepositoryYear.getWidth()+COMPONENT_GAP_X, inrepositoryYear.getY(), LABEL_W, LABEL_H);
		this.infoPanel.add(transition);
		transitionid.setBounds(transition.getX()+transition.getWidth()+COMPONENT_GAP_X, transition.getY(), TEXT_W, TEXT_H);
		transitionid.setOpaque(false);
		this.infoPanel.add(transitionid);
//		JLabel apart1 = new JLabel("-");
//		JLabel apart2 = new JLabel("-");
//		apart1.setBounds(inrepositoryYear.getX() + inrepositoryYear.getWidth(), inrepositoryYear.getY(), 10, TEXT_H);
//		this.infoPanel.add(apart1);
//		inrepositoryMonth.setBounds(apart1.getX() + apart1.getWidth(), apart1.getY(), TEXT_W / 2, TEXT_H);
//		this.infoPanel.add(inrepositoryMonth);
//		apart2.setBounds(inrepositoryMonth.getX() + inrepositoryMonth.getWidth(), inrepositoryMonth.getY(), 10, TEXT_H);
//		this.infoPanel.add(apart2);
//		inrepositoryDay.setBounds(apart2.getX() + apart2.getWidth(), apart2.getY(), TEXT_W / 2, TEXT_H);
//		this.infoPanel.add(inrepositoryDay);
		// 目的地
		arrivalid.setBounds(inrepositorydate.getX(),
				inrepositorydate.getY() + inrepositorydate.getHeight() + COMPONENT_GAP_Y, LABEL_W, LABEL_H);
		this.infoPanel.add(arrivalid);
		arrivalidText.setBounds(arrivalid.getX() + arrivalid.getWidth() + COMPONENT_GAP_X, arrivalid.getY(), TEXT_W,
				TEXT_H);
		arrivalidText.setOpaque(false);
		this.infoPanel.add(arrivalidText);
		// 区号
		areaid.setBounds(arrivalidText.getX() + arrivalidText.getWidth() + COMPONENT_GAP_Y, arrivalidText.getY(),
				LABEL_W / 2, LABEL_H);
		this.infoPanel.add(areaid);
		areaidText.setBounds(areaid.getX() + areaid.getWidth() + COMPONENT_GAP_X, areaid.getY(), TEXT_W, TEXT_H);
		areaidText.setOpaque(false);
		areaidText.addItem("航运区");
		areaidText.addItem("铁运区");
		areaidText.addItem("汽运区");
		areaidText.addItem("机动区");
		areaidText.setOpaque(false);
		this.infoPanel.add(areaidText);
		// 排号
		rowid.setBounds(arrivalid.getX(), arrivalid.getY() + arrivalid.getHeight() + COMPONENT_GAP_Y, LABEL_W, LABEL_H);
		this.infoPanel.add(rowid);
		rowidText.setBounds(rowid.getX() + rowid.getWidth() + COMPONENT_GAP_X, rowid.getY(), LABEL_W, LABEL_H);
		rowidText.setOpaque(false);
		this.infoPanel.add(rowidText);
		// 架号
		shelfid.setBounds(rowidText.getX() + rowidText.getWidth() + COMPONENT_GAP_Y, rowidText.getY(), LABEL_W / 2,
				LABEL_H);
		this.infoPanel.add(shelfid);
		shelfidText.setBounds(shelfid.getX() + shelfid.getWidth() + COMPONENT_GAP_X, shelfid.getY(), LABEL_W, LABEL_H);
		shelfidText.setOpaque(false);
		this.infoPanel.add(shelfidText);
		// 位号
		posid.setBounds(shelfidText.getX() + shelfidText.getWidth() + COMPONENT_GAP_Y, shelfidText.getY(), LABEL_W / 2,
				LABEL_H);
		this.infoPanel.add(posid);
		posidText.setBounds(posid.getX() + posid.getWidth() + COMPONENT_GAP_X, posid.getY(), LABEL_W, LABEL_H);
		posidText.setOpaque(false);
		this.infoPanel.add(posidText);
	}

	private void addListener() {
		find.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String deliveryID = DeliveryidText.getText().trim();
				InRepositoryVO inRepositoryVO = inRepositoryBLService.findInRepositoryFormBL(deliveryID);
				if (inRepositoryVO != null) {
					// 设置当前的信息面板可见
					infoPanel.setVisible(true);
					// 设置细节信息面板为将要显示的内容
					setinfo(inRepositoryVO);
					// 设置相关面板可见
					buttonPanel.setVisible(true);
					state2.setVisible(true);
					
					state1.setVisible(false);
					// 重新布局
					revalidate();
				} else {
					//设置当前的信息面板可见
					infoPanel.setVisible(false);
					//设置相关面板可见
					buttonPanel.setVisible(false);
					state2.setVisible(false);
					
					state1.setVisible(true);
					//重新布局
					revalidate();
					showState1("入库单编号错误或入库单不存在！");
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

		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//创建接收单对象
				InRepositoryVO inRepositoryVO = creatInRepository();
				//验证输入是否规范
				boolean result = inRepositoryBLService.verify(inRepositoryVO);
				
				if (result) {
					// 重置入库时间
					inRepositoryVO.setinrepositorydate(inrepositoryYear.getText().trim());
					throughVerifyOperation(inRepositoryVO);   //验证成功
					cancle2.setVisible(true);
				}
				else {
					verifyFailOperation(inRepositoryVO);   //验证失败
				}
				
				//刷新页面
				repaint();
			}
		});
		cancle2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//回到第一次点击确定的状态
				isFirstEnsure = true;
				//使提示信息消失
				state2.setText("");
				state2.setForeground(Color.red);
				//使信息可编辑
				enableComponents();
				cancle2.setVisible(false);
			}
		});
	}
	
	private void throughVerifyOperation(InRepositoryVO inRepositoryVO) {
		//使所有组件不可编辑
		disableComponents();
		
		if(isFirstEnsure) {
			state2.setForeground(Color.red);
			showState2("请再次确认信息，无误后按确定，否则按取消");
			isFirstEnsure = false;
		}
		else {
			//添加装运信息
			String save =inRepositoryBLService.modifyInRepositoryFormBL(inRepositoryVO);
			if(save.equals("true")) {		//保存成功
				state2.setForeground(Color.green);
				showState2("订单修改成功");
				disableComponents();
			}
			else if(save.equals("true.warn")){//保存成功,报警
				AreaCodeType Area = inRepositoryVO.getareaCode();
				String way = null;
				switch (Area) {
				case PLANEAREA:
					way = "航运区";
					break;
				case TRAINAREA:
					way = "铁运区";
					break;
				case TRUCKAREA:
					way = "汽运区";
					break;
				case MOTOAREA:
					way = "机动区";
					break;
				}
				state2.setForeground(Color.red);
				showState2("修改成功，但"+way+"库存报警");
			}
			else if(save.equals("false")){
				//TODO 保存失败，说明保存失败的原因或者提出建议
				state2.setForeground(Color.red);
				showState2("订单修改失败");
			}
		}
	}
	
	private void verifyFailOperation(InRepositoryVO inRepositoryVO) {
		//提示修改意见
		state2.setForeground(Color.red);
		showState2(inRepositoryVO.geterrorMsg());
	}

	private InRepositoryVO creatInRepository() {
		String delivery = DeliveryidText.getText().trim();
		String InRepDate = inrepositoryYear.getText().trim();
		String arrive = arrivalidText.getText().trim();
		String transitid = transitionid.getText().trim();
		String AREA = (String) areaidText.getSelectedItem();
		AreaCodeType areacode = null;
		switch (AREA) {
		case "航运区":
			areacode = AreaCodeType.PLANEAREA;
			break;
		case "铁运区":
			areacode = AreaCodeType.TRAINAREA;
			break;
		case "汽运区":
			areacode = AreaCodeType.TRUCKAREA;
			break;
		case "机动区":
			areacode = AreaCodeType.MOTOAREA;
			break;
		}
		String row = rowidText.getText().trim();
		String shelf = shelfidText.getText().trim();
		String position = posidText.getText().trim();
		InRepositoryVO inRepositoryVO = new InRepositoryVO(delivery, InRepDate, arrive, areacode, row, shelf, position,transitid);
		return inRepositoryVO;
	}

	private void disableComponents() {
		inrepositoryYear.setEditable(false);
		dateChoose.setEnabled(false);
		transitionid.setEditable(false);
//		inrepositoryMonth.setEditable(false);
//		inrepositoryDay.setEditable(false);
		arrivalidText.setEditable(false);
		areaidText.setEnabled(false);
		rowidText.setEditable(false);
		shelfidText.setEditable(false);
		posidText.setEditable(false);
	}

	private void enableComponents() {
		inrepositoryYear.setEditable(true);
		dateChoose.setEnabled(true);
		transitionid.setEditable(true);
//		inrepositoryMonth.setEditable(true);
//		inrepositoryDay.setEditable(true);
		arrivalidText.setEditable(true);
		areaidText.setEnabled(true);
		rowidText.setEditable(true);
		shelfidText.setEditable(true);
		posidText.setEditable(true);
	}

	private void setinfo(InRepositoryVO inRepositoryVO) {
//		String[] inrepositorydate = inRepositoryVO.getinrepositorydate().split("-");
		inrepositoryYear.setText(inRepositoryVO.getinrepositorydate());
		transitionid.setText(inRepositoryVO.gettransitionid());
//		inrepositoryMonth.setText(inrepositorydate[1].trim());
//		inrepositoryDay.setText(inrepositorydate[2].trim());
		arrivalidText.setText(inRepositoryVO.getarrivalid().trim());
		rowidText.setText(inRepositoryVO.getrowid().trim());
		shelfidText.setText(inRepositoryVO.getshelfid().trim());
		posidText.setText(inRepositoryVO.getposid().trim());
		switch (inRepositoryVO.getareaCode()) {
		case PLANEAREA:
			this.areaidText.setSelectedItem("航运区");
			break;
		case TRAINAREA:
			this.areaidText.setSelectedItem("铁运区");
			break;
		case TRUCKAREA:
			this.areaidText.setSelectedItem("汽运区");
			break;
		case MOTOAREA:
			this.areaidText.setSelectedItem("机动区");
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
