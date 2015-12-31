package ui.transitionui.transferringui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businessLogic.businessLogicController.transitionController.TransferringController;
import businessLogicService.transitionBLService.TransferringBLService;
import constant.AreaCodeType;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;
import vo.repositoryVO.RepositoryVO;

public class SeeRepositoryPanel extends DetailPanel {
	TransferringBLService transferring = new TransferringController();
	// 组件
	private JTable table = null;
	private LimpidButton find = new LimpidButton("","picture/查询.png");
	private LimpidButton update = new LimpidButton("","picture/更新.png");

	private List<RepositoryVO> list = null;
	
	private JPanel thetablepanel = new JPanel();
	private JScrollPane jScrollPane = new JScrollPane();

	public static final int LABEL_W = 80;
	public static final int LABEL_H = 40;
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

	public SeeRepositoryPanel() {
		// TODO Auto-generated constructor stub
		super();

		// 按钮
		find.setBounds(START_X*2, 10, LABEL_W, LABEL_H-10);
		add(find);
		update.setBounds(find.getX() + find.getWidth() + COMPONENT_GAP_Y * 4, find.getY(), LABEL_W, LABEL_H-10);
		add(update);
		
		thetablepanel.setBounds(30, find.getY() + find.getHeight() + COMPONENT_GAP_Y, Area_W + LABEL_W+10, Area_H + LABEL_H+10);
		thetablepanel.setOpaque(false);
		add(thetablepanel);

		addListener();

	}

	private void addListener() {
		find.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (isFirstEnsure) {
					List<RepositoryVO> LIST = transferring.getRepositoryInfo();
					list = LIST;
					initTabel(LIST);
					isFirstEnsure = false;
				}
			}
		});
		update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
//				tableModel.setRowCount(0);// 清除原有行
				List<RepositoryVO> LIST2 = transferring.getRepositoryInfo();
//				if (LIST2.size() > list.size()) {
//					for (int i = list.size(); i < LIST2.size(); i++) {
//						String[] arr = new String[7];
//						arr[0] = LIST2.get(i).getdeliveryid();
//						arr[1] = LIST2.get(i).getinrepositorydate();
//						arr[2] = LIST2.get(i).getarrivalid();
//						AreaCodeType area = LIST2.get(i).getareaCode();
//						String AREA = null;
//						switch (area) {
//						case PLANEAREA:
//							AREA = "航运区";
//							break;
//						case TRAINAREA:
//							AREA = "铁运区";
//							break;
//						case TRUCKAREA:
//							AREA = "汽运区";
//							break;
//						case MOTOAREA:
//							AREA = "机动区";
//							break;
//						}
//						arr[3] = AREA;
//						arr[4] = LIST2.get(i).getrowid();
//						arr[5] = LIST2.get(i).getshelfid();
//						arr[6] = LIST2.get(i).getposid();
//						// 添加数据到表格
//						tableModel.addRow(arr);
//					}
//				}
//				else {
					thetablepanel.remove(jScrollPane);
					initTabel(LIST2);
//				}
			}
		});
	}

	private void initTabel(List<RepositoryVO> list) {
		// 设置列表
		Object[] names = { "快递编号", "中转中心编号","入库日期", "目的地", "区号", "排号", "架号", "位号" };

		int size = list.size();
		Object[][] datas = new Object[size][8];
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
			datas[i] = new Object[] { list.get(i).getdeliveryid(),list.get(i).gettransitionid(), list.get(i).getinrepositorydate(),
					list.get(i).getarrivalid(), AREA, list.get(i).getrowid(), list.get(i).getshelfid(),
					list.get(i).getposid() };
		}
		DefaultTableModel model = new DefaultTableModel(datas, names) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		this.table = new JTable(model);
		int rowH = 20;
		this.table.setRowHeight(rowH);
		// 添加列表
		
		jScrollPane.setBounds(10, 0, Area_W + LABEL_W, Area_H + LABEL_H);
		jScrollPane.setViewportView(table);
		jScrollPane.getViewport().setOpaque(false);
		jScrollPane.setOpaque(false);
		table.setOpaque(false);
		thetablepanel.add(jScrollPane);
	}
}
