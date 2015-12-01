package ui.financeui.statisticsui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import businessLogic.businessLogicController.financeController.StatisticsController;
import businessLogicService.financeBLService.StatisticsBLSevice;
import ui.baseui.DetailPanel;
import ui.financeui.settlementui.ReceivablePanel;
import vo.businessVO.ReceivableVO;

@SuppressWarnings("serial")
public class RunPanel extends DetailPanel{
	
	private StatisticsBLSevice statistics = new StatisticsController();

	private DateInputPanel dateInput = null;
	
	private JTable table = null;
	
	private JButton ok = new JButton("确定");
	
	private JButton cancel = new JButton("取消");
	
	private List<ReceivableVO> list = null;
	
	private ReceivablePanel panel = null;
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 12);
	
	private static final int DATE_W = DETAIL_PANEL_W - 30;
	
	private static final int DATE_H = DETAIL_PANEL_H >> 2;
	
	private static final int TABLE_W = DATE_W >> 1 ;
	
	private static final int TABLE_H = DETAIL_PANEL_H - (DATE_H << 1) + 13;
	
	private static final int RECEIVABLE_W = TABLE_W;
	
	private static final int RECEIVABLE_H = TABLE_H;
	
	private static final int BUTTON_W = DATE_H >> 1;
	
	private static final int BUTTON_H = (BUTTON_W / 3 << 1) - 10;
	
	public RunPanel() {
		//日期面板
		this.dateInput = new DateInputPanel(5, 5, DATE_W - 20, DATE_H);
		this.add(this.dateInput);
		//确定按钮
		int buttonX = this.dateInput.getX() + (this.dateInput.getWidth() >> 1) + (BUTTON_W << 1);
		this.ok.setBounds(buttonX, DATE_H + 5, BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		this.add(this.ok);
		//取消按钮
		this.cancel.setBounds(buttonX + (BUTTON_W << 1), this.ok.getY(), BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		this.add(this.cancel);
		//添加按钮事件监听
		this.addButtonListener();
	}
	
	private void addButtonListener() {
		//确定按钮
		this.ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//查找收款单列表
				list = statistics.getReceivableList(dateInput.getStartDate(), dateInput.getEndDate());
				//显示收款单列表
				initTable(list);
			}
		});
		//取消按钮
		this.cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//清空用户输入
				dateInput.clearInfo();
			}
		});
	}
	
	private void initTable(List<ReceivableVO> list) {
		//列名
		Object[] names = {
				"收款单列表","日期","收款金额"
		};
		//列的内容
		int size = list.size();
		int rowNum = size < 12 ? 12 : size;
		Object[][] datas = new Object[rowNum][3];
		for(int i = 0; i < size; i++) {
			datas[i] = new Object[] {
					"收款单列表"+ (i + 1),list.get(i).getDate(),list.get(i).getMoney()
			};
		}
		//收款单列表
		this.table = new JTable(datas, names);
		int rowH = 20;
		this.table.setRowHeight(rowH);
		//将表格添加到主面板
		JScrollPane container = new JScrollPane();
		container.setBounds(DATE_H >> 1, 5 + DATE_H, TABLE_W - (DATE_H >> 1), TABLE_H);
		container.setViewportView(this.table);
		this.add(container);
		//添加表格监听
		this.addTableListener();
	}
	
	private void addTableListener() {
		this.table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				showReceivable(list.get(table.getSelectedRow()));
			}
			
		});
	}
	
	private void showReceivable(ReceivableVO receivable) {
		int x = TABLE_W;
		int y = this.ok.getY() + (BUTTON_H << 1);
		if(this.panel != null) this.panel.setVisible(false);
		this.panel = new ReceivablePanel(receivable, x, y,
				RECEIVABLE_W, RECEIVABLE_H);
		this.add(panel);
		this.revalidate();
		this.repaint();
	}
}
