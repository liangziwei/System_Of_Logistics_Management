package ui.repositoryui.manageRep;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businessLogic.businessLogicController.repositoryController.ManageRepositoryController;
import businessLogicService.repositoryBLService.ManageRepositoryBLService;
import constant.AreaCodeType;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;

public class RepositoryWarnPanel extends DetailPanel {
	ManageRepositoryBLService manageRepositoryBLService = new ManageRepositoryController();
	// 组件
	private JLabel Plane = new JLabel("航运区:");
	private JLabel Train = new JLabel("铁运区:");
	private JLabel Truck = new JLabel("汽运区:");
	private JLabel Moto = new JLabel("机动区:");
	private JLabel warnnum1 = new JLabel("预警值");
	private JLabel warnnum2 = new JLabel("预警值");
	private JLabel warnnum3 = new JLabel("预警值");
	private JLabel warnnum4 = new JLabel("预警值");
	private JLabel allnum1 = new JLabel("该区容量");
	private JLabel allnum2 = new JLabel("该区容量");
	private JLabel allnum3 = new JLabel("该区容量");
	private JLabel allnum4 = new JLabel("该区容量");

	private JTextField warnnum1Text = new JTextField();
	private JTextField warnnum2Text = new JTextField();
	private JTextField warnnum3Text = new JTextField();
	private JTextField warnnum4Text = new JTextField();
	private JTextField allnum1Text = new JTextField();
	private JTextField allnum2Text = new JTextField();
	private JTextField allnum3Text = new JTextField();
	private JTextField allnum4Text = new JTextField();

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

	public RepositoryWarnPanel() {
		// TODO Auto-generated constructor stub
		// 主面板
		this.infoPanel.setBounds(START_X / 2, START_Y / 2, this.DETAIL_PANEL_W,
				START_Y + (LABEL_H + COMPONENT_GAP_Y) * 3);
		this.infoPanel.setLayout(null);
		infoPanel.setOpaque(false);
		// 初始化信息面板
		this.initUI();
		// 按钮面板
		this.buttonPanel.setBounds(START_X + LABEL_W + COMPONENT_GAP_X + TEXTid_W,
				infoPanel.getY() + infoPanel.getHeight(), (BUTTON_W << 1) + COMPONENT_GAP_Y, BUTTON_H);
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
		// 区号
		Plane.setBounds(0, 0, LABEL_W, LABEL_H);
		Plane.setFont(WORD_FONT);
		this.infoPanel.add(Plane);
		Train.setBounds(Plane.getX(), Plane.getY() + Plane.getHeight() + COMPONENT_GAP_Y, LABEL_W, LABEL_H);
		Train.setFont(WORD_FONT);
		this.infoPanel.add(Train);
		Truck.setBounds(Train.getX(), Train.getY() + Train.getHeight() + COMPONENT_GAP_Y, LABEL_W, LABEL_H);
		Truck.setFont(WORD_FONT);
		this.infoPanel.add(Truck);
		Moto.setBounds(Truck.getX(), Truck.getY() + Truck.getHeight() + COMPONENT_GAP_Y, LABEL_W, LABEL_H);
		Moto.setFont(WORD_FONT);
		this.infoPanel.add(Moto);
		// 预警值
		warnnum1.setBounds(Plane.getX() + Plane.getWidth() + COMPONENT_GAP_X, Plane.getY(), LABEL_W, LABEL_H);
		warnnum1.setFont(WORD_FONT);
		this.infoPanel.add(warnnum1);
		warnnum1Text.setBounds(warnnum1.getX() + warnnum1.getWidth() + COMPONENT_GAP_X, warnnum1.getY(), TEXT_W,
				TEXT_H);
		warnnum1Text.setOpaque(false);
		this.infoPanel.add(warnnum1Text);
		warnnum2.setBounds(Train.getX() + Train.getWidth() + COMPONENT_GAP_X, Train.getY(), LABEL_W, LABEL_H);
		warnnum2.setFont(WORD_FONT);
		this.infoPanel.add(warnnum2);
		warnnum2Text.setBounds(warnnum2.getX() + warnnum2.getWidth() + COMPONENT_GAP_X, warnnum2.getY(), TEXT_W,
				TEXT_H);
		warnnum2Text.setOpaque(false);
		this.infoPanel.add(warnnum2Text);
		warnnum3.setBounds(Truck.getX() + Truck.getWidth() + COMPONENT_GAP_X, Truck.getY(), LABEL_W, LABEL_H);
		warnnum3.setFont(WORD_FONT);
		this.infoPanel.add(warnnum3);
		warnnum3Text.setBounds(warnnum3.getX() + warnnum3.getWidth() + COMPONENT_GAP_X, warnnum3.getY(), TEXT_W,
				TEXT_H);
		warnnum3Text.setOpaque(false);
		this.infoPanel.add(warnnum3Text);
		warnnum4.setBounds(Moto.getX() + Moto.getWidth() + COMPONENT_GAP_X, Moto.getY(), LABEL_W, LABEL_H);
		warnnum4.setFont(WORD_FONT);
		this.infoPanel.add(warnnum4);
		warnnum4Text.setBounds(warnnum4.getX() + warnnum4.getWidth() + COMPONENT_GAP_X, warnnum4.getY(), TEXT_W,
				TEXT_H);
		warnnum4Text.setOpaque(false);
		this.infoPanel.add(warnnum4Text);
		// 当前区总容量
		allnum1.setBounds(warnnum1Text.getX() + warnnum1Text.getWidth() + COMPONENT_GAP_X + 20, warnnum1Text.getY(),
				LABEL_W, LABEL_H);
		allnum1.setFont(WORD_FONT);
		this.infoPanel.add(allnum1);
		allnum1Text.setBounds(allnum1.getX() + allnum1.getWidth() + COMPONENT_GAP_X, allnum1.getY(), TEXT_W, TEXT_H);
		allnum1Text.setOpaque(false);
		this.infoPanel.add(allnum1Text);
		allnum2.setBounds(warnnum2Text.getX() + warnnum2Text.getWidth() + COMPONENT_GAP_X + 20, warnnum2Text.getY(),
				LABEL_W, LABEL_H);
		allnum2.setFont(WORD_FONT);
		this.infoPanel.add(allnum2);
		allnum2Text.setBounds(allnum2.getX() + allnum2.getWidth() + COMPONENT_GAP_X, allnum2.getY(), TEXT_W, TEXT_H);
		allnum2Text.setOpaque(false);
		this.infoPanel.add(allnum2Text);
		allnum3.setBounds(warnnum3Text.getX() + warnnum3Text.getWidth() + COMPONENT_GAP_X + 20, warnnum3Text.getY(),
				LABEL_W, LABEL_H);
		allnum3.setFont(WORD_FONT);
		this.infoPanel.add(allnum3);
		allnum3Text.setBounds(allnum3.getX() + allnum3.getWidth() + COMPONENT_GAP_X, allnum3.getY(), TEXT_W, TEXT_H);
		allnum3Text.setOpaque(false);
		this.infoPanel.add(allnum3Text);
		allnum4.setBounds(warnnum4Text.getX() + warnnum4Text.getWidth() + COMPONENT_GAP_X + 20, warnnum4Text.getY(),
				LABEL_W, LABEL_H);
		allnum4.setFont(WORD_FONT);
		this.infoPanel.add(allnum4);
		allnum4Text.setBounds(allnum4.getX() + allnum4.getWidth() + COMPONENT_GAP_X, allnum4.getY(), TEXT_W, TEXT_H);
		allnum4Text.setOpaque(false);
		this.infoPanel.add(allnum4Text);
	}

	private void addListener() {
		this.ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String planewarn = warnnum1Text.getText().trim();
				String planeall = allnum1Text.getText().trim();
				String trainwarn = warnnum2Text.getText().trim();
				String trainall = allnum2Text.getText().trim();
				String truckwarn = warnnum3Text.getText().trim();
				String truckall = allnum3Text.getText().trim();
				String motowarn = warnnum4Text.getText().trim();
				String motoall = allnum4Text.getText().trim();
				boolean plane = manageRepositoryBLService.verify(planewarn, planeall);
				boolean train = manageRepositoryBLService.verify(trainwarn, trainall);
				boolean truck = manageRepositoryBLService.verify(truckwarn, truckall);
				boolean moto = manageRepositoryBLService.verify(motowarn, motoall);

				if (plane && train && truck && moto) {
					cancel.setVisible(true);
					Startsave(planewarn,planeall,trainwarn,trainall,truckwarn,truckall,motowarn,motoall);
				} else {
					showState("信息输入有误，不可为空，预警值小于1");
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
	}

	private void Startsave(String planewarn, String planeall, String trainwarn, String trainall, String truckwarn,
			String truckall, String motowarn, String motoall) {
		boolean pla=false;
		boolean tra=false;
		boolean tru=false;
		boolean moto=false;
		// 使所有组件不可编辑
		disableComponents();
		if (isFirstEnsure) {
			showState("请再次确认信息，无误后按确定，否则按取消");
			isFirstEnsure = false;
		} else {
			// 添加预警信息
			// 航运区相关操作
			pla=throughVerifyOperation(planewarn, planeall, AreaCodeType.PLANEAREA);
			// 铁运区相关操作
			tra=throughVerifyOperation(trainwarn, trainall, AreaCodeType.TRAINAREA);
			// 汽运区相关操作
			tru=throughVerifyOperation(truckwarn, truckall, AreaCodeType.TRUCKAREA);
			// 机动区相关操作
			moto=throughVerifyOperation(motowarn, motoall, AreaCodeType.MOTOAREA);
			if (pla&&tra&&tru&&moto) {// 保存成功
				showState("预警信息保存成功");
				disableComponents();
			}
			else {// TODO 保存失败
				showState("预警信息保存失败");
			}
		}
		

	}

	private boolean throughVerifyOperation(String warn, String all, AreaCodeType area) {
		double WarnNum = Double.parseDouble(warn);
		int allNum = Integer.parseInt(all);
		boolean save = manageRepositoryBLService.SetWarnValueBL(area, allNum, WarnNum);
		return save;
	}

	private void disableComponents() {
		this.warnnum1Text.setEditable(false);
		this.warnnum2Text.setEditable(false);
		this.warnnum3Text.setEditable(false);
		this.warnnum4Text.setEditable(false);
		this.allnum1Text.setEditable(false);
		this.allnum2Text.setEditable(false);
		this.allnum3Text.setEditable(false);
		this.allnum4Text.setEditable(false);
	}

	private void enableComponents() {
		this.warnnum1Text.setEditable(true);
		this.warnnum2Text.setEditable(true);
		this.warnnum3Text.setEditable(true);
		this.warnnum4Text.setEditable(true);
		this.allnum1Text.setEditable(true);
		this.allnum2Text.setEditable(true);
		this.allnum3Text.setEditable(true);
		this.allnum4Text.setEditable(true);
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
