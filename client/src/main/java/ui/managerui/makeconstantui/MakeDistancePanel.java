package ui.managerui.makeconstantui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ui.baseui.DetailPanel;

@SuppressWarnings("serial")
public class MakeDistancePanel extends DetailPanel{

	private JTable distance = null;
	
	private JScrollPane container = new JScrollPane();
	
	private JButton ok = new JButton("确定");
	
	private JButton cancel = new JButton("取消");
	
	private static Font WORD_FONT  = new Font("宋体", Font.PLAIN, 18);
	
	private static final int TABLE_W = DETAIL_PANEL_W * 3 >> 2;
	
	private static final int BUTTON_W = 80;
	
	private static final int BUTTON_H = 42;
	
	private static final int START_X = (DETAIL_PANEL_W - TABLE_W) >> 1;
	
	private static final int START_Y = START_X >> 1;
	
	public MakeDistancePanel() {
		//初始化城市距离表
		this.initTable();
		//初始化按钮
		this.initButtons();
	}
	
	private void initTable() {
		
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
		this.distance.setRowHeight(32);
		this.distance.setFont(WORD_FONT);
		//表格容器
		this.container.setBounds(START_X, START_Y, TABLE_W, 215);
		this.add(this.container);
		this.container.setViewportView(this.distance);
	}
	
	private void initButtons() {
		//确定按钮
		this.ok.setBounds(this.container.getX() + (TABLE_W >> 1), 
				this.container.getY() + this.container.getHeight() + (BUTTON_H * 3 >> 1), BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + (BUTTON_W << 1), this.ok.getY(), BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		//将按钮添加到面板
		this.add(this.ok);
		this.add(this.cancel);
	}
}
