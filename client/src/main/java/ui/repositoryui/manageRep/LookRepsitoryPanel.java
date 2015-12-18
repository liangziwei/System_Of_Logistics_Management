package ui.repositoryui.manageRep;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import businessLogic.businessLogicController.repositoryController.ManageRepositoryController;
import businessLogic.businessLogicModel.util.CommonLogic;
import businessLogicService.repositoryBLService.ManageRepositoryBLService;
import constant.AreaCodeType;
import ui.DateChooser;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;
import vo.repositoryVO.RepositoryInfoVO;
import vo.repositoryVO.RepositoryVO;

public class LookRepsitoryPanel extends DetailPanel {
	ManageRepositoryBLService manageRepositoryBLService = new ManageRepositoryController();

	private DateChooser dateChoose1 = DateChooser.getInstance();
	private DateChooser dateChoose2 = DateChooser.getInstance();

	private JLabel inRepository = new JLabel("入库单数量");
	private JLabel outRepository = new JLabel("出库单数量");
	private JLabel inMoney = new JLabel("入库金额");
	private JLabel outMoney = new JLabel("出库金额");
	private JLabel allRepository = new JLabel("库存总数");
	private JLabel startdate = new JLabel("开始日期:");
	private JLabel enddate = new JLabel("结束日期:");

	private JTextField inRepositoryText = new JTextField();
	private JTextField outRepositoryText = new JTextField();
	private JTextField inMoneyText = new JTextField();
	private JTextField outMoneyText = new JTextField();
	private JTextField allRepositoryText = new JTextField();
	private JTextField startyear = new JTextField();
	// private JTextField startmonth = new JTextField();
	// private JTextField startday = new JTextField();
	private JTextField endyear = new JTextField();
	// private JTextField endmonth = new JTextField();
	// private JTextField endday = new JTextField();

	private JTable table = null;
	JScrollPane jScrollPaneTable = null;
	private LimpidButton find = new LimpidButton("", "picture/查询.png");
	private LimpidButton cancle = new LimpidButton("", "picture/清空.png");
	private JPanel datePanel = new JPanel() {
		// public void paintComponent(Graphics g) {
		// super.paintComponent(g);
		// g.setColor(Color.gray);
		// // 开始日期
		// g.drawLine(startyear.getX() + startyear.getWidth(), startyear.getY()
		// + BUTTON_H / 2,
		// startyear.getX() + startyear.getWidth() + 10, startyear.getY() +
		// BUTTON_H / 2);
		// g.drawLine(startmonth.getX() + startmonth.getWidth(),
		// startyear.getY() + BUTTON_H / 2,
		// startmonth.getX() + startmonth.getWidth() + 10, startyear.getY() +
		// BUTTON_H / 2);
		// // 结束日期
		// g.drawLine(endyear.getX() + endyear.getWidth(), endyear.getY() +
		// BUTTON_H / 2,
		// endyear.getX() + endyear.getWidth() + 10, endyear.getY() + BUTTON_H /
		// 2);
		// g.drawLine(endmonth.getX() + endmonth.getWidth(), endyear.getY() +
		// BUTTON_H / 2,
		// endmonth.getX() + endmonth.getWidth() + 10, endyear.getY() + BUTTON_H
		// / 2);
		// }
	};
	private JPanel tablePanel = new JPanel();

	private JPanel infoPanel = new JPanel();

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

	private static final int date_W = 50;

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

	public LookRepsitoryPanel() {
		// TODO Auto-generated constructor stub
		super();
		// 时间面板
		datePanel.setBounds(5, 5, this.DETAIL_PANEL_W, LABEL_H + BUTTON_H);
		datePanel.setLayout(null);
		datePanel.setOpaque(false);
		initdate();
		// 状态信息
		state.setBounds(datePanel.getX(), datePanel.getY() + datePanel.getHeight(), LABEL_W * 2,
				TEXT_H + COMPONENT_GAP_X);
		state.setFont(WORD_FONT);
		state.setForeground(Color.red);
		// 信息面板
		infoPanel.setBounds(state.getX(), state.getY() + state.getHeight(), LABEL_W + TEXT_W + COMPONENT_GAP_X,
				(LABEL_H + COMPONENT_GAP_X) * 9);
		infoPanel.setLayout(null);
		infoPanel.setVisible(false);
		infoPanel.setOpaque(false);
		initinfo();

		// tablePanel
		tablePanel.setBounds(inRepositoryText.getX() + inRepositoryText.getWidth() + 10,
				find.getY() + find.getHeight() + COMPONENT_GAP_Y, Area_W, Area_H + LABEL_H * 3);
		tablePanel.setOpaque(false);
		addPanels();
		// showState("123121");

		AddListener();
	}

	private void AddListener() {
		this.find.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (startyear.getText().trim().equals("") || endyear.getText().trim().equals("")
						|| (!CommonLogic.isDate(startyear.getText().trim()))
						|| (!CommonLogic.isDate(endyear.getText().trim()))) {
					// infoPanel.setVisible(false);
					infoPanel.setVisible(false);
					if (jScrollPaneTable!=null) {
						tablePanel.remove(jScrollPaneTable);						
					}
					isFirstEnsure = true;
					showState("时间不可为空或时间输入有误");
					
				} else {
					if (isFirstEnsure) {
						showState("");
						String starttime = startyear.getText().trim();
						String endtime = endyear.getText().trim();
						if (CommonLogic.isDate(starttime) && CommonLogic.isDate(endtime)) {
							String time = starttime + ";" + endtime;
							List<RepositoryInfoVO> list = manageRepositoryBLService.SeeRepositoryBL(time);
							List<RepositoryInfoVO> InRepInfo = BeinRepositoryInfo(list);
							List<RepositoryInfoVO> OutRepInfo = BeoutRepositoryInfo(list);
							List<RepositoryVO> allRep = manageRepositoryBLService.GetRepositoryInfoBL();
							setinRepinfo(InRepInfo);
							setoutRepinfo(OutRepInfo);
							setallRep(allRep);
							initTable(list);
							infoPanel.setVisible(true);
						}
						isFirstEnsure = false;
					}
				}
			}
		});

		this.cancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				startyear.setText("");
				// startmonth.setText("");
				// startday.setText("");
				endyear.setText("");
				// endmonth.setText("");
				// endday.setText("");
				infoPanel.setVisible(false);
				tablePanel.remove(jScrollPaneTable);
				isFirstEnsure = true;
			}
		});
	}

	// 将RepositoryInfo转化为入库单集合与出库单集合
	private List<RepositoryInfoVO> BeinRepositoryInfo(List<RepositoryInfoVO> repositoryInfoVOs) {
		List<RepositoryInfoVO> inRep = new ArrayList<RepositoryInfoVO>();
		for (int i = 0; i < repositoryInfoVOs.size(); i++) {
			if (repositoryInfoVOs.get(i).getbeinrepository()) {
				inRep.add(repositoryInfoVOs.get(i));
			}
		}

		return inRep;
	}

	private List<RepositoryInfoVO> BeoutRepositoryInfo(List<RepositoryInfoVO> repositoryInfoVOs) {
		List<RepositoryInfoVO> outRep = new ArrayList<RepositoryInfoVO>();
		for (int i = 0; i < repositoryInfoVOs.size(); i++) {
			if (!repositoryInfoVOs.get(i).getbeinrepository()) {
				outRep.add(repositoryInfoVOs.get(i));
			}
		}
		return outRep;
	}

	// 设置infoPanel
	private void setinRepinfo(List<RepositoryInfoVO> repositoryInfoVOs) {
		inRepositoryText.setText(repositoryInfoVOs.size() + "");
		double money = 0.0;
		for (int i = 0; i < repositoryInfoVOs.size(); i++) {
			money += repositoryInfoVOs.get(i).getmoney();
		}
		inMoneyText.setText(money + "");
	}

	private void setoutRepinfo(List<RepositoryInfoVO> repositoryInfoVOs) {
		outRepositoryText.setText(repositoryInfoVOs.size() + "");
		double money = 0.0;
		for (int i = 0; i < repositoryInfoVOs.size(); i++) {
			money += repositoryInfoVOs.get(i).getmoney();
		}
		outMoneyText.setText(money + "");
	}

	private void setallRep(List<RepositoryVO> repositoryVOs) {
		allRepositoryText.setText(repositoryVOs.size() + "");
	}

	// 初始化table面板
	private void initTable(List<RepositoryInfoVO> list) {
		// 设置列表
		Object[] names = { "快递编号", "区号", "排号", "架号", "位号" ,"出/入库"};

		int size = list.size();
		Object[][] datas = new Object[size][6];
		for (int i = 0; i < size; i++) {
			AreaCodeType area = list.get(i).getareaCode();
			String AREA = null;
			switch (area) {
			case PLANEAREA:
				AREA = "航运区";
				break;
			case TRAINAREA:
				AREA = "铁运区";
				break;
			case TRUCKAREA:
				AREA = "汽运区";
				break;
			case MOTOAREA:
				AREA = "机动区";
				break;
			}
			String beinRep = null;
			if (list.get(i).getbeinrepository()) {
				beinRep = "入库单";
			}
			else {
				beinRep = "出库单";
			}
			datas[i] = new Object[] { list.get(i).getdeliveryid(), AREA, list.get(i).getrowid(),
					list.get(i).getshelfid(), list.get(i).getposid(),beinRep };
		}
		DefaultTableModel model = new DefaultTableModel(datas, names) {
			public boolean isCellEditable(int row, int column) {
				return true;
			}
		};
		this.table = new JTable(model);
		int rowH = 20;
		this.table.setRowHeight(rowH);
		// 添加列表
		jScrollPaneTable = new JScrollPane();
		jScrollPaneTable.setBounds(0, 0, Area_W - 30, Area_H + LABEL_H * 2);
		jScrollPaneTable.setViewportView(table);
		this.tablePanel.add(jScrollPaneTable);
	}

	private void initdate() {
		startdate.setBounds(0, (LABEL_H + BUTTON_H) / 2, LABEL_W, BUTTON_H);
		startdate.setFont(WORD_FONT);
		this.datePanel.add(startdate);
		startyear.setBounds(startdate.getX() + startdate.getWidth() + 5, startdate.getY(), date_W * 3 + 30, BUTTON_H);
		dateChoose1.register(startyear);
		this.datePanel.add(startyear);
		// startmonth.setBounds(startyear.getX() + startyear.getWidth() + 10,
		// startyear.getY(), date_W, BUTTON_H);
		// this.datePanel.add(startmonth);
		// startday.setBounds(startmonth.getX() + startmonth.getWidth() + 10,
		// startmonth.getY(), date_W, BUTTON_H);
		// this.datePanel.add(startday);

		enddate.setBounds(startyear.getX() + startyear.getWidth() + COMPONENT_GAP_X, startdate.getY(), LABEL_W,
				BUTTON_H);
		enddate.setFont(WORD_FONT);
		this.datePanel.add(enddate);
		endyear.setBounds(enddate.getX() + enddate.getWidth() + 5, enddate.getY(), date_W * 3 + 30, BUTTON_H);
		dateChoose2.register(endyear);
		this.datePanel.add(endyear);
		// endmonth.setBounds(endyear.getX() + endyear.getWidth() + 10,
		// endyear.getY(), date_W, BUTTON_H);
		// this.datePanel.add(endmonth);
		// endday.setBounds(endmonth.getX() + endmonth.getWidth() + 10,
		// endmonth.getY(), date_W, BUTTON_H);
		// this.datePanel.add(endday);

		find.setBounds(endyear.getX() + endyear.getWidth() + COMPONENT_GAP_X, endyear.getY(), BUTTON_W, BUTTON_H);
		find.setFont(WORD_FONT);
		this.datePanel.add(find);
		cancle.setBounds(find.getX() + find.getWidth() + COMPONENT_GAP_X / 2, find.getY(), BUTTON_W, BUTTON_H);
		cancle.setFont(WORD_FONT);
		this.datePanel.add(cancle);
	}

	private void initinfo() {
		// 入库单数量
		inRepository.setBounds(0, 0, LABEL_W, LABEL_H);
		inRepository.setFont(WORD_FONT);
		this.infoPanel.add(inRepository);
		//
		inRepositoryText.setBounds(inRepository.getX() + inRepository.getWidth() + COMPONENT_GAP_X / 2,
				inRepository.getY(), LABEL_W, LABEL_H);
		inRepositoryText.setEditable(false);
		this.infoPanel.add(inRepositoryText);
		// 入库金额
		inMoney.setBounds(inRepository.getX(), inRepository.getY() + inRepository.getHeight() + COMPONENT_GAP_X,
				LABEL_W, LABEL_H);
		inMoney.setFont(WORD_FONT);
		this.infoPanel.add(inMoney);
		//
		inMoneyText.setBounds(inMoney.getX() + inMoney.getWidth() + COMPONENT_GAP_X / 2, inMoney.getY(), LABEL_W,
				LABEL_H);
		inMoneyText.setEditable(false);
		this.infoPanel.add(inMoneyText);
		// 出库单数量
		outRepository.setBounds(inMoney.getX(), inMoney.getY() + inMoney.getHeight() + COMPONENT_GAP_X, LABEL_W,
				LABEL_H);
		outRepository.setFont(WORD_FONT);
		this.infoPanel.add(outRepository);
		//
		outRepositoryText.setBounds(outRepository.getX() + outRepository.getWidth() + COMPONENT_GAP_X / 2,
				outRepository.getY(), LABEL_W, LABEL_H);
		outRepositoryText.setEditable(false);
		this.infoPanel.add(outRepositoryText);
		// 出库金额
		outMoney.setBounds(outRepository.getX(), outRepository.getY() + outRepository.getHeight() + COMPONENT_GAP_X,
				LABEL_W, LABEL_H);
		outMoney.setFont(WORD_FONT);
		this.infoPanel.add(outMoney);
		//
		outMoneyText.setBounds(outMoney.getX() + outMoney.getWidth() + COMPONENT_GAP_X / 2, outMoney.getY(), LABEL_W,
				LABEL_H);
		outMoneyText.setEditable(false);
		this.infoPanel.add(outMoneyText);
		// 库存总数
		allRepository.setBounds(outMoney.getX(), outMoney.getY() + outMoney.getHeight() + COMPONENT_GAP_X, LABEL_W,
				LABEL_H);
		allRepository.setFont(WORD_FONT);
		this.infoPanel.add(allRepository);
		//
		allRepositoryText.setBounds(allRepository.getX() + allRepository.getWidth() + COMPONENT_GAP_X / 2,
				allRepository.getY(), LABEL_W, LABEL_H);
		allRepositoryText.setEditable(false);
		this.infoPanel.add(allRepositoryText);
	}

	private void addPanels() {
		this.add(datePanel);
		this.add(state);
		this.add(infoPanel);
		this.add(tablePanel);
	}

	private void showState(String msg) {
		this.state.setText("<html>"+msg+"</html>");
		this.repaint();
	}
}
