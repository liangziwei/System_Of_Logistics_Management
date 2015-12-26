package ui.financeui.originalInfoui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
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

public class OriginalBuildPanel extends DetailPanel {
	private OriginalInfoController originalInfoCon = new OriginalInfoController(null);
	private OriginalInfoRecordBLService originalInfoRecordBLService = new OriginalRecordController();

	private JButton OriginizationLabel = new JButton("<html>"+"机构"+"<html>");
	private JButton staffLabel = new JButton("<html>"+"人员"+"<html>");
	private JButton vehicleLabel = new JButton("<html>"+"车辆"+"<html>");
	private JButton storeLabel = new JButton("<html>"+"库存"+"<html>");
	private JButton accountLabel = new JButton("<html>"+"银行账户"+"<html>");
	// 信息JScroll
	private JScrollPane infopane = new JScrollPane();

	// 按钮面板
	private JPanel buttonPanel = new JPanel();
	private JLabel leixin = new JLabel("建账类型");
	private JComboBox<String> many = new JComboBox<String>();
	private static Map<String, JButton> TABLE_GETTER_METHOD = new HashMap<String, JButton>();
//	private JButton creat = new JButton("picture/期初建账Button.png");
	private LimpidButton ok = new LimpidButton("", "picture/确定.png");
	// 信息信息面板
	private JPanel InfoPanel = new JPanel();

	private JLabel state = new JLabel("", JLabel.CENTER);

	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 16);

	private static final int LABEL_W = 120;
	private static final int LABEL_H = 20;
	private static final int START_X = 20;
	private static final int RowHeight = 20;
	private static final int TABEL_W = DETAIL_PANEL_W - 80;

	private static final int TABEL_H = DETAIL_PANEL_H - 150;

	private static final int BUTTON_W = LABEL_W;

	private static final int BUTTON_H = LABEL_H + 10;

	public OriginalBuildPanel() {
		// TODO Auto-generated constructor stub
//		creat.setBounds(START_X, 5, TABEL_W, LABEL_H * 2);
//		creat.setFont(WORD_FONT);
		leixin.setBounds(START_X*4, 5, LABEL_W, LABEL_H*2);
		leixin.setFont(WORD_FONT);
		many.setBounds(leixin.getX()+leixin.getWidth()+50,leixin.getY(),LABEL_W*2,LABEL_H*2);
		many.setFont(WORD_FONT);
		this.addTypeItem();    //增加单据类型选项
		this.addTypeItemListener();		

		InfoPanel.setBounds(0,  leixin.getY()+leixin.getHeight()+5, DETAIL_PANEL_W, LABEL_H + TABEL_H-2);
		InfoPanel.setLayout(null);
		InfoPanel.setVisible(false);
		InfoPanel.setOpaque(false);
		
		
		infopane.setVisible(false);

		state.setBounds(InfoPanel.getX(), InfoPanel.getY() + InfoPanel.getHeight()-20, 250, BUTTON_W);
		state.setFont(WORD_FONT);
		state.setVisible(false);
		state.setForeground(Color.red);

		buttonPanel.setBounds(state.getX() + state.getWidth() + 100, state.getY(), LABEL_W * 3, LABEL_H * 4);
		buttonPanel.setLayout(null);
		buttonPanel.setOpaque(false);
		buttonPanel.setVisible(false);
		buttonPanel.add(ok);

		ok.setBounds(40, LABEL_H + 5, BUTTON_W*2, BUTTON_H * 2);
		ok.setFont(WORD_FONT);

		
		buttonPanel.setVisible(true);
		state.setVisible(true);
		creatinfopanel();
		
		addcombo();
		addComponents();
		addListener();
		repaint();
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
			datas[i] = new Object[] { repositoryVOs.get(i).getdeliveryid(), repositoryVOs.get(i).getinrepositorydate(),
					repositoryVOs.get(i).getarrivalid(), AREA, repositoryVOs.get(i).getrowid(),
					repositoryVOs.get(i).getshelfid(), repositoryVOs.get(i).getposid() };
		}
		// Object[][] datas = { { "1234567890", "2015-11-11", "北京", "A", "22",
		// "11", "22" },
		// { "1234567891", "2015-11-11", "北京", "A", "22", "11", "33" } };
		createInfoTable(datas, name);
	}

	// 创建银行账户的表
	private void createAccountTable(List<AccountVO> accountVOs) {
		String[] name = { "账户名称", "账户余额" };

		int size = accountVOs.size();
		Object[][] datas = new Object[size][2];
		for (int i = 0; i < size; i++) {
			datas[i] = new Object[] { accountVOs.get(i).getName(), accountVOs.get(i).getBalance() };
		}
		// Object[][] datas = { { "茗柯110", "122222" }, { "茗柯111", "1111111" } };
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
		infopane.getViewport().setOpaque(false);
		infopane.setOpaque(false);
		// infopane.setOpaque(false);
		// infopane.getViewport().setOpaque(false);

		// infopane.setColumnHeaderView(table.getTableHeader());
		// infopane.getColumnHeader().setOpaque(false);
//		infopane.setBounds(START_X << 1, OriginizationLabel.getY() + OriginizationLabel.getHeight(), TABEL_W, TABEL_H);
		infopane.setBounds((START_X << 1), 10, TABEL_W, TABEL_H);
		infopane.setVisible(true);
		this.InfoPanel.add(infopane);
		repaint();
	}

	private void creatinfopanel() {
		InfoPanel.setVisible(true);
		infopane.setVisible(true);
		buildtable("0");
		this.validate();
	}

	private void buildtable(String theyear) {
		// originalInfoCon = new OriginalInfoController(order);
		List<StaffVO> staffVOs = originalInfoCon.getStaffInfo(Integer.parseInt(theyear));
		List<VehicleVO> vehicleVOs = originalInfoCon.getVehicleInfo(Integer.parseInt(theyear));
		List<OrganizationVO> organizationVOs = originalInfoCon.getOrganizationInfo(Integer.parseInt(theyear));
		List<RepositoryVO> repositoryVOs = originalInfoCon.getRepositoryInfo(Integer.parseInt(theyear));
		List<AccountVO> accountVOs = originalInfoCon.getAccountInfo(Integer.parseInt(theyear));
		addLabelListener(staffVOs, vehicleVOs, organizationVOs, repositoryVOs, accountVOs);

	}

	private void addLabelListener(final List<StaffVO> staffVOs, final List<VehicleVO> vehicleVOs,
			final List<OrganizationVO> organizationVOs, final List<RepositoryVO> repositoryVOs,
			final List<AccountVO> accountVOs) {
		this.OriginizationLabel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createOriginizationTable(organizationVOs);
				repaint();
			}
		});

		this.staffLabel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				createStaffTable(staffVOs);
				repaint();
			}
		});

		this.vehicleLabel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				createVehicleTable(vehicleVOs);
				repaint();
			}
		});

		this.storeLabel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				createStoreTable(repositoryVOs);
				repaint();
			}
		});

		this.accountLabel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				createAccountTable(accountVOs);
				repaint();
			}
		});

	}

	private void addListener() {
		// 期初建账相关监听
		ok.addActionListener(new ActionListener() {
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
	}
	/**
	 * 增加建账信息类型
	 */
	private void addTypeItem() {
		many.addItem("机构信息");
		many.addItem("人员信息");
		many.addItem("车辆信息");
		many.addItem("库存信息");
		many.addItem("银行账户");
	}
	/**
	 *添加对单据下拉选项 的监听
	 */
	private void addTypeItemListener() {
		this.many.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
//				InfoPanel.remove(infopane);
				//根据用户的选择的表格类型获得相应单据的编号
				JButton temp = TABLE_GETTER_METHOD.get((String)many.getSelectedItem());
				temp.doClick();
				//刷新面板
				repaint();
			}
		});
	}
	
	private void addcombo(){
		TABLE_GETTER_METHOD.put("机构信息",this.OriginizationLabel);
		TABLE_GETTER_METHOD.put("人员信息", this.staffLabel);
		TABLE_GETTER_METHOD.put("车辆信息", this.vehicleLabel);
		TABLE_GETTER_METHOD.put("库存信息", this.storeLabel);
		TABLE_GETTER_METHOD.put("银行账户", this.accountLabel);
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
		this.add(state);
		this.add(buttonPanel);
		this.add(leixin);
		this.add(many);

		// this.add(infopane);
	}
	
	private void showstate(String msg) {
		this.state.setText(msg);
	}
}
