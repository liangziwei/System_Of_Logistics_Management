package ui.financeui.statisticsui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import businessLogic.businessLogicModel.util.CommonLogic;
import ui.baseui.DatePanel;

@SuppressWarnings("serial")
public class DateInputPanel extends JPanel{
	
	private JLabel startDateL = new JLabel("开始日期");
	
	private DatePanel startDateT = new DatePanel();
	
	private JLabel endDateL = new JLabel("结束日期");
	
	private DatePanel endDateT = new DatePanel();
	
	private JLabel tip = new JLabel();
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 13);
	
	public DateInputPanel(int x, int y, int w, int h) {
		//计算常量
		int labelW = w / 10;
		int labelH = h >> 2;
		int textW = labelW * 3;
		int textH = labelH;
		int dateX = (w - (labelW + textW << 1)) >> 2;
		int dateY = dateX ;
		//主面板
		this.setLayout(null);
		this.setBounds(x, y, w, h);
		//开始日期标签
		this.startDateL.setBounds(dateX, dateY, labelW, labelH);
		this.startDateL.setFont(WORD_FONT);
		//开始日期文本框
		this.startDateT.setPanelBound(this.startDateL.getX() + labelW + (dateX >> 1), this.startDateL.getY(),
				textW, textH);
		this.startDateT.setFont(WORD_FONT);
		this.startDateT.setOpaque(false);
		//结束日期标签
		this.endDateL.setBounds(this.startDateT.getX() + textW + (dateX >> 1), this.startDateL.getY(),
				labelW, labelH);
		this.endDateL.setFont(WORD_FONT);
		//结束日期文本框
		this.endDateT.setPanelBound(this.endDateL.getX() + labelW + (dateX >> 1), this.endDateL.getY(),
				textW, textH);
		this.endDateT.setFont(WORD_FONT);
		this.endDateT.setOpaque(false);
		//提示标签
		this.tip.setBounds(5, this.getHeight() - labelH, labelW << 1, labelH);
		this.tip.setFont(WORD_FONT);
		this.tip.setForeground(Color.RED);
		//将组件添加到面板
		this.setLayout(null);
		this.add(this.startDateL);
		this.add(this.startDateT);
		this.add(this.endDateL);
		this.add(this.endDateT);
		this.add(this.tip);
	}
	
	public void clearInfo() {
		this.startDateT.clearInfo();
		this.endDateT.clearInfo();
	}
	
	public String getStartDate() {
		return this.startDateT.getDate();
	}
	
	public String getEndDate() {
		return this.endDateT.getDate();
	}
	
	public boolean verifyInput(String start, String end) {
		//验证输入的日期是否合法
		if(!CommonLogic.isDate(start) || !CommonLogic.isDate(end)) {
			this.tip.setText("日期不存在");
			this.repaint();
			return false;
		}
		tip.setText("");
		this.repaint();
		return true;
	}
}
