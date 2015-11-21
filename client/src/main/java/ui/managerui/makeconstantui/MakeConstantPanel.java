package ui.managerui.makeconstantui;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ui.baseui.DetailPanel;

@SuppressWarnings("serial")
public class MakeConstantPanel extends DetailPanel{

	private JTable distance = null;
	
	private JScrollPane container = new JScrollPane();
	
	private JButton ok = new JButton("确定");
	
	private JButton cancel = new JButton("取消");
	
	private static final int TABLE_W = DETAIL_PANEL_W * 3 >> 2;
	
	private static final int TABLE_H = DETAIL_PANEL_H >> 1;
	
	private static final int BUTTON_W = 0;
	
	private static final int BUTTON_H = 0;
	
	private static final int START_X = (DETAIL_PANEL_W - TABLE_W) >> 1;
	
	private static final int START_Y = START_X >> 1;
	
	public MakeConstantPanel() {
		//初始化城市距离表
		this.initTable();
		//初始化按钮
		this.initButtons();
	}
	
	private void initTable() {
		//表格容器
		this.container.setBounds(START_X, START_Y, TABLE_W, TABLE_H);
		this.add(this.container);
		//城市距离表格
		Object[] names = new Object[] {
				"出发地", "到达地", "城市距离"
		};
		Object[][] datas = new Object[][] {
			{"南京", "北京", ""},
			{"南京", "上海", ""},
			{"南京", "广州", ""},
			{"北京", "上海", ""},
			{"北京", "广州", ""},
			{"上海", "广州", ""}
		};
		this.distance = new JTable(datas ,names);
		this.container.setViewportView(this.distance);
	}
	
	private void initButtons() {
		
	}
}
