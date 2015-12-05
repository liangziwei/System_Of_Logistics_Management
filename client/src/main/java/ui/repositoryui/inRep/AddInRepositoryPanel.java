package ui.repositoryui.inRep;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.DateChooser;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;
import vo.repositoryVO.InRepositoryVO;
import businessLogic.businessLogicController.repositoryController.InRepositoryController;
import businessLogicService.repositoryBLService.InRepositoryBLService;
import constant.AreaCodeType;

public class AddInRepositoryPanel extends DetailPanel {
	private InRepositoryBLService inRepositoryBLService = new InRepositoryController();
	
	private DateChooser dateChoose=DateChooser.getInstance();
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

	private JPanel buttonPanel = new JPanel();

	private LimpidButton ok = new LimpidButton("","picture/确定.png");

	private LimpidButton cancel = new LimpidButton("","picture/取消.png");

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

	/**
	 * 是否为第一次按确认按钮
	 */
	private boolean isFirstEnsure = true;

	public AddInRepositoryPanel() {
		// TODO Auto-generated constructor stub
		super();

		// 主面板
		this.infoPanel.setBounds(START_X, START_Y, this.DETAIL_PANEL_W, START_Y + (LABEL_H + COMPONENT_GAP_Y) * 3);
		this.infoPanel.setLayout(null);
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
		// 入库日期
		inrepositorydate.setBounds(Deliveryid.getX(), Deliveryid.getY() + Deliveryid.getHeight() + COMPONENT_GAP_Y,
				LABEL_W, LABEL_H);
		this.infoPanel.add(inrepositorydate);
		inrepositoryYear.setBounds(inrepositorydate.getX() + inrepositorydate.getWidth() + COMPONENT_GAP_X,	inrepositorydate.getY(), TEXT_W / 2, TEXT_H);
		inrepositoryYear.setOpaque(false);
		this.infoPanel.add(inrepositoryYear);
		JLabel apart1 = new JLabel("-");
		JLabel apart2 = new JLabel("-");
		apart1.setBounds(inrepositoryYear.getX() + inrepositoryYear.getWidth(), inrepositoryYear.getY(), 10, TEXT_H);
		this.infoPanel.add(apart1);
		inrepositoryMonth.setBounds(apart1.getX() + apart1.getWidth(), apart1.getY(), TEXT_W / 2, TEXT_H);
		inrepositoryMonth.setOpaque(false);
		this.infoPanel.add(inrepositoryMonth);
		apart2.setBounds(inrepositoryMonth.getX() + inrepositoryMonth.getWidth(), inrepositoryMonth.getY(), 10, TEXT_H);
		this.infoPanel.add(apart2);
		inrepositoryDay.setBounds(apart2.getX() + apart2.getWidth(), apart2.getY(), TEXT_W / 2, TEXT_H);
		inrepositoryDay.setOpaque(false);
		this.infoPanel.add(inrepositoryDay);
		dateChoose.register(inrepositoryYear);
		this.infoPanel.add(inrepositoryYear);
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
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 创建接收单对象
				InRepositoryVO inRepositoryVO = creatInRepository();
				// 验证输入是否规范
				boolean result = inRepositoryBLService.verify(inRepositoryVO);

				if (result) {
					// 重置入库时间
					inRepositoryVO.setinrepositorydate(inrepositoryYear.getText().trim());
					throughVerifyOperation(inRepositoryVO); // 验证成功
					cancel.setVisible(true);
				} else {
					verifyFailOperation(inRepositoryVO); // 验证失败
				}

				// 刷新页面
				repaint();
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
				// 使信息可编辑
				enableComponents();
				cancel.setVisible(false);
			}
		});
	}

	private void throughVerifyOperation(InRepositoryVO inRepositoryVO) {
		// 使所有组件不可编辑
		disableComponents();

		if (isFirstEnsure) {
			showState("请再次确认信息，无误后按确定，否则按取消");
			isFirstEnsure = false;
		} else {
			// 添加装运信息
			String save = inRepositoryBLService.addInRepositoryFormBL(inRepositoryVO);
			if (save.equals("true")) { // 保存成功
				showState("订单保存成功");
				disableComponents();
			} else if (save.equals("true.warn")) {// 保存成功,报警
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
				showState("保存成功，但" + way + "库存报警");
			} else if (save.equals("false")) {
				// TODO 保存失败，说明保存失败的原因或者提出建议
				showState("订单保存失败");
			}
		}
	}

	private void verifyFailOperation(InRepositoryVO inRepositoryVO) {
		// 提示修改意见
		showState(inRepositoryVO.geterrorMsg());
	}

	private InRepositoryVO creatInRepository() {
		String delivery = DeliveryidText.getText().trim();
		String InRepDate = inrepositoryYear.getText().trim();
		String arrive = arrivalidText.getText().trim();
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
		InRepositoryVO inRepositoryVO = new InRepositoryVO(delivery, InRepDate, arrive, areacode, row, shelf, position);
		return inRepositoryVO;
	}

	private void disableComponents() {
		DeliveryidText.setEditable(false);
		inrepositoryYear.setEditable(false);
		dateChoose.setEnabled(false);
//		inrepositoryMonth.setEditable(false);
//		inrepositoryDay.setEditable(false);
		arrivalidText.setEditable(false);
		areaidText.setEnabled(false);
		rowidText.setEditable(false);
		shelfidText.setEditable(false);
		posidText.setEditable(false);
	}

	private void enableComponents() {
		DeliveryidText.setEditable(true);
		inrepositoryYear.setEditable(true);
		dateChoose.setEnabled(true);
//		inrepositoryMonth.setEditable(true);
//		inrepositoryDay.setEditable(true);
		arrivalidText.setEditable(true);
		areaidText.setEnabled(true);
		rowidText.setEditable(true);
		shelfidText.setEditable(true);
		posidText.setEditable(true);
	}

	private void addPanels() {
		this.infoPanel.setOpaque(false);
		this.buttonPanel.setOpaque(false);
		this.add(this.infoPanel);
		this.add(this.buttonPanel);
		this.add(this.state);
	}

	private void showState(String msg) {
		this.state.setText(msg);
		this.repaint();
	}

}
