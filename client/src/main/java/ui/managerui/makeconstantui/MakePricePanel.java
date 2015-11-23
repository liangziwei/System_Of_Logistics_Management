package ui.managerui.makeconstantui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ui.baseui.DetailPanel;

@SuppressWarnings("serial")
public class MakePricePanel extends DetailPanel{

	private JTable price = null;
	
	private JScrollPane container = new JScrollPane();
	
	private JButton ok = new JButton("确定");
	
	private JButton cancel = new JButton("取消");
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 15);
	
	private static final int BUTTON_W = 80;
	
	private static final int BUTTON_H = 39;
	
	private static final int TABLE_W = DETAIL_PANEL_W * 3 >> 2;
	
	private static final int TABLE_X = (DETAIL_PANEL_W - TABLE_W) >> 1;
	
	private static final int TABLE_Y = TABLE_X >> 1;
	
	public MakePricePanel() {
		//初始化价格表格
		this.initPriceTable();
		//初始化按钮
		this.initButtons();
	}
	
	private void initPriceTable() {
		//列名
		Object[] names = new Object[] {
				"类型", "价格"
		};
		//数据
		Object[][] datas = new Object[][] {
			{"木箱包装费(元)", ""},
			{"纸箱包装费(元)", ""},
			{"快递袋包装费(元)", ""},
			{"其他包装费(元)", ""},
			{"飞机每公里每吨(元)", ""},
			{"汽车每公里每吨(元)", ""},
			{"火车每公里每吨(元)", ""}
		};
		this.price = new JTable(datas, names);
		this.price.setRowHeight(32);
		this.price.setFont(WORD_FONT);
		//列表容器
		this.container.setBounds(TABLE_X, TABLE_Y, TABLE_W, 247);
		this.container.setViewportView(this.price);
		
		this.add(this.container);
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
