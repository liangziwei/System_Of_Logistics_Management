package ui.repositoryui.manageRep;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businessLogic.businessLogicController.repositoryController.ManageRepositoryController;
import businessLogicService.repositoryBLService.ManageRepositoryBLService;
import constant.AreaCodeType;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;
import vo.repositoryVO.DeliveryInfoVO;

public class CheckDeliveryPanel extends DetailPanel {
	ManageRepositoryBLService manageRepositoryBLService = new ManageRepositoryController();

	// 添加下拉框
	private JScrollPane jScrollPane = new JScrollPane();
	private JPanel container = new JPanel();
	// 组件
	private JTable tablepl = null;
	private JTable tabletra = null;
	private JTable tabletru = null;
	private JTable tablemo = null;
	private LimpidButton find = new LimpidButton("", "picture/库存盘点.png");
	private LimpidButton excel = new LimpidButton("", "picture/全部库存信息导出.png");
	private LimpidButton excelPlane = new LimpidButton("","picture/航运区导出.png");
	private LimpidButton excelTrain = new LimpidButton("","picture/铁运区导出.png");
	private LimpidButton exceltruck = new LimpidButton("","picture/汽运区导出.png");
	private LimpidButton excelmoto = new LimpidButton("","picture/机动区导出.png");
	// private JButton update = new JButton("更新");

	private JLabel plane = new JLabel("航运区");
	private JLabel train = new JLabel("铁运区");
	private JLabel truck = new JLabel("汽运区");
	private JLabel moto = new JLabel("机动区");

	private List<DeliveryInfoVO> list = null;
	private List<DeliveryInfoVO> pllist = null;
	private List<DeliveryInfoVO> tralist = null;
	private List<DeliveryInfoVO> trulist = null;
	private List<DeliveryInfoVO> motolist = null;

	private static final Font WORD_FONT = new Font("宋体", Font.PLAIN, 16);

	public static final int LABEL_W = 80;
	public static final int LABEL_H = 32;
	public static final int TEXT_W = LABEL_W << 1;
	public static final int TEXT_H = LABEL_H;
	public static final int TEXTid_W = LABEL_W * 4;
	public static final int COMPONENT_GAP_X = 20;
	public static final int COMPONENT_GAP_Y = COMPONENT_GAP_X << 1;
	public static final int Area_W = LABEL_W * 7;
	public static final int Area_H = LABEL_H * 6;
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

	public CheckDeliveryPanel() {
		// TODO Auto-generated constructor stub
		super();

		// 下拉框设置
		container.setLayout(null);
		container.setPreferredSize(new Dimension(CONTAINER_W, CONTAINER_H));
		container.setOpaque(false);
		jScrollPane.setBounds(0, 0, DETAIL_PANEL_W, DETAIL_PANEL_H);
		jScrollPane.setViewportView(this.container);
		jScrollPane.getVerticalScrollBar().setUnitIncrement(15);
		jScrollPane.getViewport().setOpaque(false);
		jScrollPane.setOpaque(false);
		super.add(jScrollPane);

		// 按钮
		find.setBounds(START_X * 2, 10, TEXT_W+70, LABEL_H);
		find.setFont(WORD_FONT);
		container.add(find);
		excel.setBounds(find.getX() + find.getWidth() + LABEL_W, find.getY(), TEXT_W, LABEL_H);
		excel.setFont(WORD_FONT);
		container.add(excel);
		// update.setBounds(find.getX() + find.getWidth() + COMPONENT_GAP_Y * 4,
		// find.getY(), TEXT_W, LABEL_H);
		// add(update);
		//
		plane.setBounds(40, find.getY() + find.getHeight() + COMPONENT_GAP_Y, TEXT_W, TEXT_H);
		plane.setFont(WORD_FONT);
		container.add(plane);
		excelPlane.setBounds(plane.getX() + plane.getWidth() + TEXT_W * 2, plane.getY(), TEXT_W, TEXT_H);
		excelPlane.setFont(WORD_FONT);
		container.add(excelPlane);
		//
		train.setBounds(40, plane.getY() + plane.getHeight() + LABEL_H * 3, TEXT_W, TEXT_H);
		train.setFont(WORD_FONT);
		container.add(train);
		excelTrain.setBounds(train.getX() + train.getWidth() + TEXT_W * 2, train.getY(), TEXT_W, TEXT_H);
		excelTrain.setFont(WORD_FONT);
		container.add(excelTrain);
		//
		truck.setBounds(40, train.getY() + train.getHeight() + LABEL_H * 3, TEXT_W, TEXT_H);
		truck.setFont(WORD_FONT);
		container.add(truck);
		exceltruck.setBounds(truck.getX() + truck.getWidth() + TEXT_W * 2, truck.getY(), TEXT_W, TEXT_H);
		exceltruck.setFont(WORD_FONT);
		container.add(exceltruck);
		//
		moto.setBounds(40, truck.getY() + truck.getHeight() + LABEL_H * 3, TEXT_W, TEXT_H);
		moto.setFont(WORD_FONT);
		container.add(moto);
		excelmoto.setBounds(moto.getX() + moto.getWidth() + TEXT_W * 2, moto.getY(), TEXT_W, TEXT_H);
		excelmoto.setFont(WORD_FONT);
		container.add(excelmoto);

		visiblefalse();

		addListener();

	}

	private void addListener() {
		find.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				List<DeliveryInfoVO> LIST = manageRepositoryBLService.CheckRepositoryBL();
				list = LIST;
				List<DeliveryInfoVO> listpl = planelist(LIST);
				pllist = listpl;
				List<DeliveryInfoVO> listtra = trainlist(LIST);
				tralist = listtra;
				List<DeliveryInfoVO> listtru = trucklist(LIST);
				trulist = listtru;
				List<DeliveryInfoVO> listmo = motolist(LIST);
				motolist = listmo;
				initTabel(listpl, listtra, listtru, listmo);
				visibletrue();

			}
		});
		excel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (list != null) {
					JFileChooser jfc = new JFileChooser();
					jfc.setFileSelectionMode(JFileChooser.OPEN_DIALOG);
					jfc.showSaveDialog(new JLabel());
					File file = jfc.getSelectedFile();
					String fileSave = file.getAbsolutePath();
					int i = fileSave.lastIndexOf(".");
					String extention = fileSave.substring(i + 1);
					if (!extention.equals("xls")) {
						fileSave += ".xls";
					}
					manageRepositoryBLService.allExcel(fileSave, list);
				}

			}
		});
		excelPlane.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (list != null) {
					JFileChooser jfc = new JFileChooser();
					jfc.setFileSelectionMode(JFileChooser.OPEN_DIALOG);
					jfc.showSaveDialog(new JLabel());
					File file = jfc.getSelectedFile();
					String fileSave = file.getAbsolutePath();
					int i = fileSave.lastIndexOf(".");
					String extention = fileSave.substring(i + 1);
					if (!extention.equals("xls")) {
						fileSave += ".xls";
					}
					manageRepositoryBLService.plExcel(fileSave, pllist);
				}
			}
		});
		excelTrain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (list != null) {
					JFileChooser jfc = new JFileChooser();
					jfc.setFileSelectionMode(JFileChooser.OPEN_DIALOG);
					jfc.showSaveDialog(new JLabel());
					File file = jfc.getSelectedFile();
					String fileSave = file.getAbsolutePath();
					int i = fileSave.lastIndexOf(".");
					String extention = fileSave.substring(i + 1);
					if (!extention.equals("xls")) {
						fileSave += ".xls";
					}
					manageRepositoryBLService.traExcel(fileSave, tralist);
				}
			}
		});
		exceltruck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (list != null) {
					JFileChooser jfc = new JFileChooser();
					jfc.setFileSelectionMode(JFileChooser.OPEN_DIALOG);
					jfc.showSaveDialog(new JLabel());
					File file = jfc.getSelectedFile();
					String fileSave = file.getAbsolutePath();
					int i = fileSave.lastIndexOf(".");
					String extention = fileSave.substring(i + 1);
					if (!extention.equals("xls")) {
						fileSave += ".xls";
					}
					manageRepositoryBLService.truExcel(fileSave, trulist);
				}
			}
		});
		excelmoto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (list != null) {
					JFileChooser jfc = new JFileChooser();
					jfc.setFileSelectionMode(JFileChooser.OPEN_DIALOG);
					jfc.showSaveDialog(new JLabel());
					File file = jfc.getSelectedFile();
					String fileSave = file.getAbsolutePath();
					int i = fileSave.lastIndexOf(".");
					String extention = fileSave.substring(i + 1);
					if (!extention.equals("xls")) {
						fileSave += ".xls";
					}
					manageRepositoryBLService.moExcel(fileSave, motolist);
				}
			}
		});
		// update.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// // TODO Auto-generated method stub
		// DefaultTableModel tableModel = (DefaultTableModel)
		// tablepl.getModel();
		//// tableModel.setRowCount(0);// 清除原有行
		// List<DeliveryInfoVO> LIST2 =
		// manageRepositoryBLService.CheckRepositoryBL();
		// if (LIST2.size() > list.size()) {
		// for (int i = list.size(); i < LIST2.size(); i++) {
		// String[] arr = new String[7];
		// arr[0] = LIST2.get(i).getdeliveryid();
		// arr[1] = LIST2.get(i).getinrepositorydate();
		// arr[2] = LIST2.get(i).getarrivalid();
		// AreaCodeType area = LIST2.get(i).getareaCode();
		// String AREA = null;
		// switch (area) {
		// case PLANEAREA:
		// AREA = "航运区";
		// break;
		// case TRAINAREA:
		// AREA = "铁运区";
		// break;
		// case TRUCKAREA:
		// AREA = "汽运区";
		// break;
		// case MOTOAREA:
		// AREA = "机动区";
		// break;
		// }
		// arr[3] = AREA;
		// arr[4] = LIST2.get(i).getrowid();
		// arr[5] = LIST2.get(i).getshelfid();
		// arr[6] = LIST2.get(i).getposid();
		// // 添加数据到表格
		// tableModel.addRow(arr);
		// }
		// }
		// }
		// });
	}

	// 将所有快递单转化为各个区的快递单集合
	private List<DeliveryInfoVO> planelist(List<DeliveryInfoVO> list) {
		List<DeliveryInfoVO> theplane = new ArrayList<DeliveryInfoVO>();
		for (DeliveryInfoVO deliveryInfoVO : list) {
			if (deliveryInfoVO.getareaCode() == AreaCodeType.PLANEAREA) {
				theplane.add(deliveryInfoVO);
			}
		}
		return theplane;
	}

	private List<DeliveryInfoVO> trainlist(List<DeliveryInfoVO> list) {
		List<DeliveryInfoVO> thetrain = new ArrayList<DeliveryInfoVO>();
		for (DeliveryInfoVO deliveryInfoVO : list) {
			if (deliveryInfoVO.getareaCode() == AreaCodeType.TRAINAREA) {
				thetrain.add(deliveryInfoVO);
			}
		}
		return thetrain;
	}

	private List<DeliveryInfoVO> trucklist(List<DeliveryInfoVO> list) {
		List<DeliveryInfoVO> thetruck = new ArrayList<DeliveryInfoVO>();
		for (DeliveryInfoVO deliveryInfoVO : list) {
			if (deliveryInfoVO.getareaCode() == AreaCodeType.TRUCKAREA) {
				thetruck.add(deliveryInfoVO);
			}
		}
		return thetruck;
	}

	private List<DeliveryInfoVO> motolist(List<DeliveryInfoVO> list) {
		List<DeliveryInfoVO> themoto = new ArrayList<DeliveryInfoVO>();
		for (DeliveryInfoVO deliveryInfoVO : list) {
			if (deliveryInfoVO.getareaCode() == AreaCodeType.MOTOAREA) {
				themoto.add(deliveryInfoVO);
			}
		}
		return themoto;
	}

	private void initTabel(List<DeliveryInfoVO> listpl, List<DeliveryInfoVO> listtra, List<DeliveryInfoVO> listtru,
			List<DeliveryInfoVO> listmo) {
		// 设置列表
		Object[] names = { "快递编号", "入库日期", "目的地", "区号", "排号", "架号", "位号" };
		// 初始化表格信息
		// plane
		int sizepl = listpl.size();
		Object[][] dataspl = new Object[sizepl][7];
		for (int i = 0; i < sizepl; i++) {
			String AREA = "航运区";
			dataspl[i] = new Object[] { listpl.get(i).getdeliveryid(), listpl.get(i).getinrepositorydate(),
					listpl.get(i).getarrivalid(), AREA, listpl.get(i).getrowid(), listpl.get(i).getshelfid(),
					listpl.get(i).getposid() };
		}
		DefaultTableModel modelpl = new DefaultTableModel(dataspl, names) {
			public boolean isCellEditable(int row, int column) {
				return true;
			}
		};
		this.tablepl = new JTable(modelpl);
		int rowH = 20;
		this.tablepl.setRowHeight(rowH);
		// train
		int sizetra = listtra.size();
		Object[][] datastra = new Object[sizetra][7];
		for (int i = 0; i < sizetra; i++) {
			String AREA = "铁运区";
			datastra[i] = new Object[] { listtra.get(i).getdeliveryid(), listtra.get(i).getinrepositorydate(),
					listtra.get(i).getarrivalid(), AREA, listtra.get(i).getrowid(), listtra.get(i).getshelfid(),
					listtra.get(i).getposid() };
		}
		DefaultTableModel modeltra = new DefaultTableModel(datastra, names) {
			public boolean isCellEditable(int row, int column) {
				return true;
			}
		};
		this.tabletra = new JTable(modeltra);
		this.tabletra.setRowHeight(rowH);
		// truck
		int sizetru = listtru.size();
		Object[][] datastru = new Object[sizetru][7];
		for (int i = 0; i < sizetru; i++) {
			String AREA = "汽运区";
			datastru[i] = new Object[] { listtru.get(i).getdeliveryid(), listtru.get(i).getinrepositorydate(),
					listtru.get(i).getarrivalid(), AREA, listtru.get(i).getrowid(), listtru.get(i).getshelfid(),
					listtru.get(i).getposid() };
		}
		DefaultTableModel modeltru = new DefaultTableModel(datastru, names) {
			public boolean isCellEditable(int row, int column) {
				return true;
			}
		};
		this.tabletru = new JTable(modeltru);
		this.tabletru.setRowHeight(rowH);
		// moto
		int sizemo = listmo.size();
		Object[][] datasmo = new Object[sizemo][7];
		for (int i = 0; i < sizemo; i++) {
			String AREA = "机动区";
			datasmo[i] = new Object[] { listmo.get(i).getdeliveryid(), listmo.get(i).getinrepositorydate(),
					listmo.get(i).getarrivalid(), AREA, listmo.get(i).getrowid(), listmo.get(i).getshelfid(),
					listmo.get(i).getposid() };
		}
		DefaultTableModel modelmo = new DefaultTableModel(datasmo, names) {
			public boolean isCellEditable(int row, int column) {
				return true;
			}
		};
		this.tablemo = new JTable(modelmo);
		this.tablemo.setRowHeight(rowH);

		// 添加组件
		// plane
		JScrollPane jScrollPane1 = new JScrollPane();
		jScrollPane1.setBounds(40, plane.getY() + plane.getHeight(), Area_W + LABEL_W, LABEL_H * 3);
		jScrollPane1.setViewportView(tablepl);
		container.add(jScrollPane1);
		// train
		JScrollPane jScrollPane2 = new JScrollPane();
		jScrollPane2.setBounds(40, train.getY() + train.getHeight(), Area_W + LABEL_W, LABEL_H * 3);
		jScrollPane2.setViewportView(tabletra);
		container.add(jScrollPane2);
		// truck
		JScrollPane jScrollPane3 = new JScrollPane();
		jScrollPane3.setBounds(40, truck.getY() + truck.getHeight(), Area_W + LABEL_W, LABEL_H * 3);
		jScrollPane3.setViewportView(tabletru);
		container.add(jScrollPane3);
		// moto
		JScrollPane jScrollPane4 = new JScrollPane();
		jScrollPane4.setBounds(40, moto.getY() + moto.getHeight(), Area_W + LABEL_W, LABEL_H * 3);
		jScrollPane4.setViewportView(tablemo);
		container.add(jScrollPane4);
	}

	private void visiblefalse() {
		excel.setVisible(false);
		excelmoto.setVisible(false);
		excelPlane.setVisible(false);
		excelTrain.setVisible(false);
		exceltruck.setVisible(false);
	}

	private void visibletrue() {
		excel.setVisible(true);
		excelmoto.setVisible(true);
		excelPlane.setVisible(true);
		excelTrain.setVisible(true);
		exceltruck.setVisible(true);
	}
}
