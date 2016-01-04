package ui.financeui.originalInfoui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import businessLogic.businessLogicController.financeController.OriginalInfoController;
import businessLogic.businessLogicController.financeController.OriginalRecordController;
import businessLogicService.financeBLService.OriginalInfoRecordBLService;
import constant.AreaCodeType;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;
import vo.businessVO.VehicleVO;
import vo.financeVO.AccountVO;
import vo.managerVO.OrganizationVO;
import vo.managerVO.StaffVO;
import vo.repositoryVO.RepositoryVO;

@SuppressWarnings("serial")
public class OriginalInfoPanel extends DetailPanel {

	private OriginalInfoController originalInfoCon = new OriginalInfoController(null);
	private OriginalInfoRecordBLService originalInfoRecordBLService = new OriginalRecordController();

//	private JLabel query = new JLabel("历史建账信息");

	private JLabel OriginizationLabel = new JLabel("机构");
	private JLabel staffLabel = new JLabel("人员");
	private JLabel vehicleLabel = new JLabel("车辆");
	private JLabel storeLabel = new JLabel("库存");
	private JLabel accountLabel = new JLabel("银行账户");
	// 信息JScroll
	private JScrollPane infopane = new JScrollPane();
	// 账单（年份）JScroll
	private JScrollPane yearpane = new JScrollPane();
	private JTable yeartable = null;
	private LimpidButton find = new LimpidButton("","picture/账单查询.png");
	private LimpidButton creat = new LimpidButton("","picture/期初建账Button.png");
	// 按钮面板
	private JPanel buttonPanel = new JPanel();
	private LimpidButton ok = new LimpidButton("","picture/确定.png");
	private LimpidButton cancel = new LimpidButton("","picture/取消.png");
	private LimpidButton cancle = new LimpidButton("","picture/取消.png");
	// 信息信息面板
	private JPanel InfoPanel = new JPanel();

	private JLabel state = new JLabel("", JLabel.CENTER);

	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 12);

	// 账单年份列表
	private List<String> allyear = null;

	private static final int LABEL_W = 120;
	private static final int LABEL_H = 20;
	private static final int START_X = 20;
//	private static final int START_Y = 20;
	private static final int RowHeight = 20;
	private static final int TABEL_W = DETAIL_PANEL_W - 80;

	private static final int TABEL_H = DETAIL_PANEL_H - 150;

	private static final int BUTTON_W = LABEL_W;

	private static final int BUTTON_H = LABEL_H;

	public OriginalInfoPanel() {
		// TODO Auto-generated constructor stub
		find.setBounds(START_X << 1, 0, LABEL_W, LABEL_H * 2);
		find.setFont(WORD_FONT);

		cancle.setBounds(find.getX(), find.getY() + find.getHeight() + 10, LABEL_W, LABEL_H * 2);
		cancle.setFont(WORD_FONT);
		cancle.setVisible(false);

		state.setBounds(START_X << 1, 0, LABEL_W, LABEL_H * 2);
		state.setFont(WORD_FONT);
		state.setVisible(false);

		creat.setBounds(find.getX(), find.getY() + find.getHeight() + 10, LABEL_W, LABEL_H * 2);
		creat.setFont(WORD_FONT);

		InfoPanel.setBounds(0, creat.getY() + creat.getHeight() + 5, DETAIL_PANEL_W, DETAIL_PANEL_H);
		InfoPanel.setLayout(null);
		InfoPanel.setVisible(false);
		InfoPanel.setOpaque(false);
		InfoPanel.add(OriginizationLabel);
		InfoPanel.add(staffLabel);
		InfoPanel.add(vehicleLabel);
		InfoPanel.add(storeLabel);
		InfoPanel.add(accountLabel);
		InfoPanel.add(infopane);

		OriginizationLabel.setBounds(START_X << 2, 0, LABEL_W, LABEL_H);
		OriginizationLabel.setFont(WORD_FONT);

		staffLabel.setBounds(OriginizationLabel.getX() + LABEL_W, 0, LABEL_W, LABEL_H);
		staffLabel.setFont(WORD_FONT);

		vehicleLabel.setBounds(staffLabel.getX() + LABEL_W, 0, LABEL_W, LABEL_H);
		vehicleLabel.setFont(WORD_FONT);

		storeLabel.setBounds(vehicleLabel.getX() + LABEL_W, 0, LABEL_W, LABEL_H);
		storeLabel.setFont(WORD_FONT);

		accountLabel.setBounds(storeLabel.getX() + LABEL_W, 0, LABEL_W, LABEL_H);
		accountLabel.setFont(WORD_FONT);
		infopane.setVisible(false);

		buttonPanel.setBounds(find.getX() + find.getWidth() + 100, find.getY() + 2, LABEL_W * 3, LABEL_H * 4);
		buttonPanel.setLayout(null);
		buttonPanel.setOpaque(false);
		buttonPanel.setVisible(false);
		buttonPanel.add(ok);
		buttonPanel.add(cancel);

		ok.setBounds(20, LABEL_H + 5, BUTTON_W, BUTTON_H * 2);
		ok.setFont(WORD_FONT);

		cancel.setBounds(ok.getX() + ok.getWidth() + 50, ok.getY(), BUTTON_W, BUTTON_H * 2);
		cancel.setFont(WORD_FONT);

		addComponents();
		addListener();
		repaint();
	}

	private void buildtable(String order, String theyear) {
		if (order.equals("creat")) {
//			originalInfoCon = new OriginalInfoController(order);
			List<StaffVO> staffVOs = originalInfoCon.getStaffInfo(Integer.parseInt(theyear));
			List<VehicleVO> vehicleVOs = originalInfoCon.getVehicleInfo(Integer.parseInt(theyear));
			List<OrganizationVO> organizationVOs = originalInfoCon.getOrganizationInfo(Integer.parseInt(theyear));
			List<RepositoryVO> repositoryVOs = originalInfoCon.getRepositoryInfo(Integer.parseInt(theyear));
			List<AccountVO> accountVOs = originalInfoCon.getAccountInfo(Integer.parseInt(theyear));
			addLabelListener(staffVOs, vehicleVOs, organizationVOs, repositoryVOs, accountVOs);
		}
		else{
			List<StaffVO> staffVOs = originalInfoRecordBLService.getStaffInfo(Integer.parseInt(theyear));
			List<VehicleVO> vehicleVOs = originalInfoRecordBLService.getVehicleInfo(Integer.parseInt(theyear));
			List<OrganizationVO> organizationVOs = originalInfoRecordBLService.getOrganizationInfo(Integer.parseInt(theyear));
			List<RepositoryVO> repositoryVOs = originalInfoRecordBLService.getRepositoryInfo(Integer.parseInt(theyear));
			List<AccountVO> accountVOs = originalInfoRecordBLService.getAccountInfo(Integer.parseInt(theyear));
			addLabelListener(staffVOs, vehicleVOs, organizationVOs, repositoryVOs, accountVOs);
		}

	}

	// 创建机构信息的表
	private void createOriginizationTable(List<OrganizationVO> organizationVOs) {
		String[] name = { "机构编号", "机构类型", "机构名称" };
		int Size = organizationVOs.size();

		Object[][] datas = new Object[Size][3];
		for (int i = 0; i < Size; i++) {
			datas[i] = new Object[] { organizationVOs.get(i).getId(), organizationVOs.get(i).getType(),
					organizationVOs.get(i).getName() };
		}
		// Object[][] datas = { { "025001001", "营业厅", "茗柯" }, { "025001001",
		// "营业厅", "茗柯" },
		// { "025001001", "营业厅", "茗柯营业厅" } };
		createInfoTable(datas, name);

	}

	// 创建人员信息的表
	private void createStaffTable(List<StaffVO> staffVOs) {
		String[] name = { "ID", "姓名", "性别", "职位", "出生日期", "薪水" };
		int size = staffVOs.size();

		Object[][] datas = new Object[size][6];
		for (int i = 0; i < size; i++) {
			datas[i] = new Object[] { staffVOs.get(i).getId(), staffVOs.get(i).getName(), staffVOs.get(i).getGender(),
					staffVOs.get(i).getPosition(), staffVOs.get(i).getBirthday(), staffVOs.get(i).getSalary() };
		}

		// Object[][] datas = { { "025001001", "茗柯", "男", "秘书", "33", "123456"
		// },
		// { "025001001", "茗柯1", "男", "经理", "33", "1234567" } };
		createInfoTable(datas, name);

	}

	// 创建车辆信息的表
	private void createVehicleTable(List<VehicleVO> vehicleVOs) {
		String[] name = { "车辆代号", "车牌号", "服役时间" };

		int size = vehicleVOs.size();
		Object[][] datas = new Object[size][3];
		for (int i = 0; i < size; i++) {
			datas[i] = new Object[] { vehicleVOs.get(i).getVehicleid(), vehicleVOs.get(i).getNumber(),
					vehicleVOs.get(i).getAge() };
		}
		// Object[][] datas = { { "025001001", "苏A 12345", "5" }, { "025001001",
		// "苏A 54321", "11" } };
		createInfoTable(datas, name);
	}

	// 创建库存信息的表
	private void createStoreTable(List<RepositoryVO> repositoryVOs) {
		String[] name = { "快递编号", "入库日期", "目的地", "区号", "排号", "架号", "位号" };
		
		int size = repositoryVOs.size();
		Object[][] datas = new Object[size][7];
		for (int i = 0; i < size; i++) {
			AreaCodeType area = repositoryVOs.get(i).getareaCode();
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
			datas[i] = new Object[] { repositoryVOs.get(i).getdeliveryid(),repositoryVOs.get(i).getinrepositorydate(),
					repositoryVOs.get(i).getarrivalid(),AREA,repositoryVOs.get(i).getrowid(),repositoryVOs.get(i).getshelfid()
					,repositoryVOs.get(i).getposid()
			};
		}
//		Object[][] datas = { { "1234567890", "2015-11-11", "北京", "A", "22", "11", "22" },
//				{ "1234567891", "2015-11-11", "北京", "A", "22", "11", "33" } };
		createInfoTable(datas, name);
	}

	// 创建银行账户的表
	private void createAccountTable(List<AccountVO> accountVOs) {
		String[] name = { "账户名称", "账户余额" };
		
		int size = accountVOs.size();
		Object[][] datas = new Object[size][2];
		for (int i = 0; i < size; i++) {
			datas[i] = new Object[]{
					accountVOs.get(i).getName(),accountVOs.get(i).getBalance()
			};
		}
//		Object[][] datas = { { "茗柯110", "122222" }, { "茗柯111", "1111111" } };
		createInfoTable(datas, name);

	}
	// 创建信息table

	private void createInfoTable(Object[][] datas, String[] name) {
		JTable table = new JTable(datas, name);
		table.setFont(WORD_FONT);
		table.setRowHeight(RowHeight);// 设置每行的高度为20
		table.setRowMargin(5);// 设置相邻两行单元格的距离
		// table.setSelectionBackground (Color.white);//设置所选择行的背景色
		table.setSelectionForeground(Color.red);// 设置所选择行的前景色
		table.setGridColor(Color.black);// 设置网格线的颜色
		table.doLayout();

		// 设置透明
		// table.setOpaque(false);
		// DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		// renderer.setOpaque(false);// render单元格的属性
		//
		// JTableHeader header = table.getTableHeader();// 获取头部
		// header.setOpaque(false);// 设置头部为透明
		// header.getTable().setOpaque(false);// 设置头部里面的表格透明
		// // header.setDefaultRenderer(renderer);
		// header.setBackground(Color.BLUE);
		// // TableCellRenderer headerRenderer = header.getDefaultRenderer();
		// // if (headerRenderer instanceof JLabel){
		// // ((JLabel) headerRenderer).setHorizontalAlignment(JLabel.CENTER);
		// // ((JLabel) headerRenderer).setOpaque(false);
		// // }
		// for (int i = 0; i < name.length; i++) {
		// table.getColumn(name[i]).setCellRenderer(renderer);
		// }

		this.InfoPanel.remove(infopane);
		infopane = new JScrollPane(table);
		// infopane.setOpaque(false);
		// infopane.getViewport().setOpaque(false);

		// infopane.setColumnHeaderView(table.getTableHeader());
		// infopane.getColumnHeader().setOpaque(false);
		infopane.setBounds(START_X << 1, OriginizationLabel.getY() + OriginizationLabel.getHeight(), TABEL_W, TABEL_H);
		infopane.setVisible(true);
		this.InfoPanel.add(infopane);
		repaint();
	}

//	// 账单查询相关操作

	// 账单（各年份）的表
	private void creatyearlist() {
		List<Integer> temp = originalInfoRecordBLService.getYearList();
		allyear = new ArrayList<String>();
		for (int i = 0; i < temp.size(); i++) {
			allyear.add(temp.get(i) + "");
		}
		// allyear.add("2015");
		// allyear.add("2014");
		// allyear.add("2016");
		// allyear.add("2017");
		// allyear.add("2018");
		creatyeartable(allyear);
	}

	private void creatyeartable(List<String> year) {
		Object[] name = { "账单年份" };
		int size = year.size();
		Object[][] datas = new Object[size][1];
		for (int i = 0; i < size; i++) {
			datas[i] = new Object[] { year.get(i) + "年" };
		}
		this.yeartable = new JTable(datas, name);
		yeartable.setFont(WORD_FONT);
		yeartable.setRowHeight(RowHeight);// 设置每行的高度为20
		yeartable.setSelectionForeground(Color.red);// 设置所选择行的前景色
		yeartable.setGridColor(Color.black);// 设置网格线的颜色
		yeartable.doLayout();

		this.yearpane.setViewportView(yeartable);
		this.yearpane.setBounds(find.getX() + find.getWidth() + 100, find.getY() + 2, LABEL_W * 3, LABEL_H * 4);
		this.yearpane.setVisible(true);
		this.add(yearpane);
		// 添加表格监听
		this.addTableListener();
	}

	private void addTableListener() {
		this.yeartable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				showinfopanel(allyear.get(yeartable.getSelectedRow()));
			}
		});
	}

	private void showinfopanel(String theyear) {
		// this.add(InfoPanel);
		InfoPanel.setVisible(true);
		infopane.setVisible(true);
		buildtable("query", theyear);
		this.revalidate();
		// this.repaint();
	}

	// 期初建帐相关操作
	private void creatinfopanel() {
		InfoPanel.setVisible(true);
		infopane.setVisible(true);
		buildtable("creat", "0");
		this.validate();
	}

	private void addListener() {
		// 期初建账相关监听
		this.creat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buttonPanel.setVisible(true);
				state.setVisible(true);
				yearpane.setVisible(false);
				InfoPanel.setVisible(false);
				find.setVisible(false);
				creatinfopanel();
			}
		});
		this.ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean result = save();
				if (result) {
					showstate("账单保存成功");
					;
				} else {
					showstate("账单保存失败");
				}
			}
		});
		this.cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buttonPanel.setVisible(false);
				InfoPanel.setVisible(false);
				state.setVisible(false);
				find.setVisible(true);
			}
		});

		// 账单查询相关监听
		this.find.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buttonPanel.setVisible(false);
				InfoPanel.setVisible(false);
				// find.setVisible(false);
				cancle.setVisible(true);
				creatyearlist();
				repaint();
			}
		});
		this.cancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				find.setVisible(true);
				cancle.setVisible(false);
				InfoPanel.setVisible(false);
				yearpane.setVisible(false);
				revalidate();
			}
		});

	}

	private void addLabelListener(final List<StaffVO> staffVOs, final List<VehicleVO> vehicleVOs,
			final List<OrganizationVO> organizationVOs, final List<RepositoryVO> repositoryVOs,
			final List<AccountVO> accountVOs) {
		this.OriginizationLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createOriginizationTable(organizationVOs);
				repaint();
			}
		});

		this.staffLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createStaffTable(staffVOs);
				repaint();
			}
		});

		this.vehicleLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createVehicleTable(vehicleVOs);
				repaint();
			}
		});

		this.storeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createStoreTable(repositoryVOs);
				repaint();
			}
		});

		this.accountLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createAccountTable(accountVOs);
				repaint();
			}
		});
	}

	private boolean save() {
		Calendar a = Calendar.getInstance();
		int theyear = a.get(Calendar.YEAR);
		System.out.println(a.get(Calendar.YEAR));// 得到年
		originalInfoCon = new OriginalInfoController("creat");
		List<StaffVO> staffVOs = originalInfoCon.getStaffInfo(0);
		List<VehicleVO> vehicleVOs = originalInfoCon.getVehicleInfo(0);
		List<OrganizationVO> organizationVOs = originalInfoCon.getOrganizationInfo(0);
		List<RepositoryVO> repositoryVOs = originalInfoCon.getRepositoryInfo(0);
		List<AccountVO> accountVOs = originalInfoCon.getAccountInfo(0);
		boolean sta = originalInfoRecordBLService.addStaffInfo(theyear, staffVOs);
		boolean veh = originalInfoRecordBLService.addVehicleInfo(theyear, vehicleVOs);
		boolean org = originalInfoRecordBLService.addOrganizationInfo(theyear, organizationVOs);
		boolean rep = originalInfoRecordBLService.addRepositoryInfo(theyear, repositoryVOs);
		boolean acc = originalInfoRecordBLService.addAccountInfo(theyear, accountVOs);
		if (sta && veh && org && rep && acc) {
			return true;
		} else {
			return false;
		}
	}

	private void addComponents() {
		this.add(InfoPanel);
		// this.add(OriginizationLabel);
		// this.add(accountLabel);
		// this.add(staffLabel);
		// this.add(storeLabel);
		// this.add(vehicleLabel);
		this.add(cancle);
		this.add(find);
		this.add(creat);

		this.add(buttonPanel);

		// this.add(infopane);
		this.add(yearpane);
	}

	private void showstate(String msg) {
		this.state.setText(msg);
	}

}
