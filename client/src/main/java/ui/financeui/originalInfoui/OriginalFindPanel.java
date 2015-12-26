package ui.financeui.originalInfoui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
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
import vo.businessVO.VehicleVO;
import vo.financeVO.AccountVO;
import vo.managerVO.OrganizationVO;
import vo.managerVO.StaffVO;
import vo.repositoryVO.RepositoryVO;

public class OriginalFindPanel extends DetailPanel {
	private OriginalInfoController originalInfoCon = new OriginalInfoController(null);
	private OriginalInfoRecordBLService originalInfoRecordBLService = new OriginalRecordController();

	private JLabel type = new JLabel("账单类型");
	private JLabel leixin = new JLabel("账单年份");
	private JComboBox<String> TypeCom = new JComboBox<String>();
	private JComboBox<String> many = new JComboBox<String>();
	private static Map<String, JButton> TABLE_GETTER_METHOD = new HashMap<String, JButton>();

	// 信息JScroll
	private JScrollPane infopane = new JScrollPane();
	// 信息信息面板
	private JPanel InfoPanel = new JPanel();

	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 16);

	private Map<String, ArrayList> formListMap = new HashMap<String, ArrayList>();

	private static final int LABEL_W = 120;
	private static final int LABEL_H = 20;
	private static final int START_X = 20;
	private static final int RowHeight = 20;
	private static final int TABEL_W = DETAIL_PANEL_W - 80;

	private static final int TABEL_H = DETAIL_PANEL_H - 150;

	private static final int BUTTON_W = LABEL_W;

	private static final int BUTTON_H = LABEL_H + 10;

	public OriginalFindPanel() {
		leixin.setBounds(START_X, 5, LABEL_W/2+15, LABEL_H * 2);
		leixin.setFont(WORD_FONT);
		many.setBounds(leixin.getX() + leixin.getWidth() + 50, leixin.getY(), LABEL_W * 2-20, LABEL_H * 2);
		many.setFont(WORD_FONT);
		type.setBounds(many.getX() + many.getWidth() + 20, many.getY(), LABEL_W/2+15, LABEL_H * 2);
		type.setFont(WORD_FONT);
		TypeCom.setBounds(type.getX() + type.getWidth() + 50, type.getY(), LABEL_W * 2-20, LABEL_H * 2);
		TypeCom.setFont(WORD_FONT);
		this.addTypeItem(); // 增加单据类型选项
		this.addTypeItemListener();

		InfoPanel.setBounds(0, leixin.getY() + leixin.getHeight() + 5, DETAIL_PANEL_W, LABEL_H + TABEL_H - 2);
		InfoPanel.setLayout(null);
		InfoPanel.setVisible(false);
		InfoPanel.setOpaque(false);

		infopane.setVisible(false);

		addComponents();
		addTypeItemListener();
		
		List<Integer> temp = originalInfoRecordBLService.getYearList();
		buildtable(temp.get(0)+"");
		InfoPanel.setVisible(true);
		infopane.setVisible(true);
		createOriginizationTable(formListMap.get("机构信息"));
		// 刷新面板
		repaint();
		
	}

	private void addTypeItemListener() {
		this.many.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// InfoPanel.remove(infopane);
				// 根据用户的选择的表格类型获得相应单据的编号
				String temp = (String) many.getSelectedItem();
				buildtable(temp);
				InfoPanel.setVisible(true);
				infopane.setVisible(true);
				// 刷新面板
				repaint();
			}
		});

		this.TypeCom.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				String way = (String) TypeCom.getSelectedItem();
				if (way.equals("人员信息")) {
					createStaffTable(formListMap.get(way));
				} else if (way.equals("车辆信息")) {
					createVehicleTable(formListMap.get(way));
				} else if (way.equals("机构信息")) {
					createOriginizationTable(formListMap.get(way));
				} else if (way.equals("库存信息")) {
					createStoreTable(formListMap.get(way));
				} else if (way.equals("银行账户")) {
					createAccountTable(formListMap.get(way));
				}

			}
		});
	}

	private void buildtable(String theyear) {
		List<StaffVO> staffVOs = originalInfoRecordBLService.getStaffInfo(Integer.parseInt(theyear));
		List<VehicleVO> vehicleVOs = originalInfoRecordBLService.getVehicleInfo(Integer.parseInt(theyear));
		List<OrganizationVO> organizationVOs = originalInfoRecordBLService
				.getOrganizationInfo(Integer.parseInt(theyear));
		List<RepositoryVO> repositoryVOs = originalInfoRecordBLService.getRepositoryInfo(Integer.parseInt(theyear));
		List<AccountVO> accountVOs = originalInfoRecordBLService.getAccountInfo(Integer.parseInt(theyear));
		formListMap.put("人员信息", (ArrayList) staffVOs);
		formListMap.put("车辆信息", (ArrayList) vehicleVOs);
		formListMap.put("机构信息", (ArrayList) organizationVOs);
		formListMap.put("库存信息", (ArrayList) repositoryVOs);
		formListMap.put("银行账户", (ArrayList) accountVOs);
		// addLabelLi/stener(staffVOs, vehicleVOs, organizationVOs,
		// repositoryVOs, accountVOs);
	}

	/**
	 * 增加建账信息类型
	 */
	private void addTypeItem() {
		List<Integer> temp = originalInfoRecordBLService.getYearList();
		for (int year : temp) {
			many.addItem(year + "");
		}
		TypeCom.addItem("机构信息");
		TypeCom.addItem("人员信息");
		TypeCom.addItem("车辆信息");
		TypeCom.addItem("库存信息");
		TypeCom.addItem("银行账户");
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

		this.InfoPanel.remove(infopane);
		infopane = new JScrollPane(table);
		infopane.getViewport().setOpaque(false);
		infopane.setOpaque(false);
		// infopane.setOpaque(false);
		// infopane.getViewport().setOpaque(false);

		// infopane.setColumnHeaderView(table.getTableHeader());
		// infopane.getColumnHeader().setOpaque(false);
		// infopane.setBounds(START_X << 1, OriginizationLabel.getY() +
		// OriginizationLabel.getHeight(), TABEL_W, TABEL_H);
		infopane.setBounds((START_X << 1), 10, TABEL_W, TABEL_H);
		infopane.setVisible(true);
		this.InfoPanel.add(infopane);
		repaint();
	}

	private void addComponents() {
		this.add(InfoPanel);
		this.add(TypeCom);
		this.add(type);
		this.add(leixin);
		this.add(many);

	}

}
