package ui.repositoryui.outRep;

import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import businessLogic.businessLogicController.repositoryController.OutRepositoryController;
import businessLogic.businessLogicModel.util.CommonLogic;
import businessLogicService.repositoryBLService.OutRepositoryBLService;
import constant.AreaCodeType;
import constant.LoadingType;
import ui.DateChooser;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;
import ui.transitionui.loadingui.AddLoadingPanel;
import vo.businessVO.ReceivableVO;
import vo.repositoryVO.RepositoryVO;
import vo.transitionVO.TransferringVO;

public class SeeTransferringListPanel extends DetailPanel{
	private OutRepositoryBLService outRepositoryBLService = new OutRepositoryController();
	
	private DateChooser dateChoose=DateChooser.getInstance();
	//组件
	private JTable table = null;
	private JLabel time = new JLabel("查询时间");
	private JTextField timeyear = new JTextField();
	private JTextField timemonth = new JTextField();
	private JTextField timeday = new JTextField();
	private JLabel apart1 = new JLabel("-");
	private JLabel apart2 = new JLabel("-");
	private LimpidButton find = new LimpidButton("","picture/查询.png");

	private LimpidButton cancle = new LimpidButton("","picture/取消.png");


//	private JTextField timemonth = new JTextField();
//	private JTextField timeday = new JTextField();
//	private JLabel apart1 = new JLabel("-");
//	private JLabel apart2 = new JLabel("-");

	private JScrollPane jScrollPane = new JScrollPane();
	
	private JLabel state = new JLabel("", JLabel.CENTER);
	private JPanel transfer = new JPanel();
	private List<TransferringVO> list =null;
	
	private static final int DATE_W = DETAIL_PANEL_W - 30;
	private static final int DATE_H = DETAIL_PANEL_H >> 2;
	private static final int TABLE_W = DATE_W >> 1 ;	
	private static final int TABLE_H = DETAIL_PANEL_H - DATE_H;
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
	
	public SeeTransferringListPanel() {
		// TODO Auto-generated constructor stub
		super();
		
		//组件
		time.setBounds(50, 10, LABEL_W, LABEL_H);
		this.add(time);
		find.setBounds(timeday.getX()+timeday.getWidth()+COMPONENT_GAP_X+10, timeday.getY(), LABEL_W+20, LABEL_H);
		timeyear.setBounds(time.getX()+time.getWidth()+COMPONENT_GAP_X, time.getY(), (TEXT_W/2)*3, TEXT_H);
		timeyear.setOpaque(false);
		dateChoose.register(timeyear);
		this.add(timeyear);

		find.setBounds(timeyear.getX()+timeyear.getWidth()+COMPONENT_GAP_X+30, timeyear.getY(), LABEL_W+20, LABEL_H);
		find.setBounds(timeyear.getX()+timeyear.getWidth()+COMPONENT_GAP_X+30, timeyear.getY(), LABEL_W+20, LABEL_H);
		this.add(find);
		cancle.setBounds(find.getX()+find.getWidth()+COMPONENT_GAP_X+10, find.getY(), LABEL_W+20, LABEL_H);
		this.add(cancle);
		state.setBounds(time.getX(), time.getY()+time.getHeight(), AddLoadingPanel.DETAIL_PANEL_W, LABEL_H);
		state.setForeground(Color.red);
		this.add(state);
		
		addListenern();
	}
	
	private void addListenern(){
		find.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String thedate = getdate();
				if (thedate.equals("empty")) {
					showState("查询日期不能为空");
				}
				else if (thedate.equals("WrongTime")) {
					showState("查询时间错误错误");
				}

				else {
					showState("");
					List<TransferringVO> LIST = outRepositoryBLService.GetTransferringInfo(thedate);
					if (LIST ==null) {
						showState("无该时间相关中转单");
					}
					else {
						list = LIST;
						initTabel(LIST);
					}
				}
			}
		});
		
		cancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				timeyear.setText("");
//				timemonth.setText("");
//				timeday.setText("");
			}
		});
	}
	
	private void initTabel(List<TransferringVO> list) {
		// 设置列表
		Object[] names = { "中转单编号", "运费", "运送方式" };

		int size = list.size();
		Object[][] datas = new Object[size][3];
		for (int i = 0; i < size; i++) {
			LoadingType area = list.get(i).getway();
			String WAY = null;
			switch (area) {
			case PLANE:
				WAY = "飞机";
				break;
			case TRAIN:
				WAY = "火车";
				break;
			case TRUCK:
				WAY = "汽车";
				break;
			}
			datas[i] = new Object[] { list.get(i).gettransferringid(),list.get(i).getfare(),WAY };
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

		jScrollPane.setBounds(5, state.getY()+state.getHeight(), TABLE_W-40, TABLE_H);
		jScrollPane.setViewportView(table);
		add(jScrollPane);
		//添加表格监听
		this.addTableListener();
	}
	private void addTableListener() {
		this.table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				showTransferring(list.get(table.getSelectedRow()));
			}
			
		});
	}
	private void showTransferring(TransferringVO transferringVO) {
		int x = table.getX()+table.getWidth();
		int y = state.getY()+state.getHeight();
		if(this.transfer != null) this.transfer.setVisible(false);
		this.transfer = new TransferPanel(transferringVO,x,y,(LABEL_W+COMPONENT_GAP_X)*4,TABLE_H);
//		if(this.transfer != null) this.transfer.setVisible(false);
//		this.transfer.setBounds(find.getX(),state.getY()+state.getHeight(),(LABEL_W+COMPONENT_GAP_X)*4,LABEL_H);
//		this.transfer.setLayout(null);
		transfer.setOpaque(false);
		this.add(transfer);
		this.revalidate();
		this.repaint();
	}
	
	private String getdate(){
		if (timeyear.getText().equals("")) {
			return "empty";
		}
		if (!CommonLogic.isDate(timeyear.getText().trim())) {
			return "WrongTime";
		}
		String timedate = timeyear.getText().trim();
		return timedate;
		
	}
	
	private void showState(String msg) {
		this.state.setText(msg);
		this.repaint();
	}
}
