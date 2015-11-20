package ui.financeui.statisticsui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ui.baseui.DatePanel;
import ui.baseui.DetailPanel;

@SuppressWarnings("serial")
public class StatisticPanel extends DetailPanel{
	
	private JLabel costLabel = new JLabel("总支出");
	
	private JTextField costText = new JTextField();
	
	private JLabel earningsLabel = new JLabel("总收益");
	
	private JTextField earningsText = new JTextField();
	
	private JLabel profitLabel = new JLabel("总利润");
	
	private JTextField profitText = new JTextField();

	private JButton ok = new JButton("确定");
	
	private JButton cancel = new JButton("取消");
	
	private JLabel startDateL = new JLabel("开始日期");
	
	private DatePanel startDateT = new DatePanel();
	
	private JLabel endDateL = new JLabel("结束日期");
	
	private DatePanel endDateT = new DatePanel();
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 20);
	
	private static final int LABEL_W = 60;
	
	private static final int LABEL_H = 32;
	
	private static final int TEXT_W = LABEL_W << 1;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int BUTTON_W = LABEL_W;
	
	private static final int BUTTON_H = LABEL_H;
	
	private static final int START_DATE_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W) / 3;
	
	private static final int START_DATE_Y = START_DATE_X;
	
	public StatisticPanel() {
		//开始日期标签
		this.startDateL.setBounds(START_DATE_X, START_DATE_Y, LABEL_W, LABEL_H);
		this.startDateL.setFont(WORD_FONT);
		//开始日期文本框
		this.startDateT.setBounds(this.startDateL.getX() + LABEL_W + (START_DATE_X << 1), this.startDateL.getY(),
				TEXT_W, TEXT_H);
		this.startDateT.setFont(WORD_FONT);
		//结束日期标签
		this.endDateL.setBounds(this.startDateL.getX(), this.startDateL.getY() + LABEL_H + START_DATE_Y,
				LABEL_W, LABEL_H);
		this.endDateL.setFont(WORD_FONT);
		//结束日期文本框
		this.endDateT.setBounds(this.startDateT.getX(), this.endDateL.getY(), TEXT_W, TEXT_H);
		this.endDateT.setFont(WORD_FONT);
		//确定按钮
		this.ok.setBounds(this.endDateT.getX() + (TEXT_W >> 1), this.endDateT.getY() + TEXT_H + START_DATE_Y,
				BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + (BUTTON_W * 3 >> 1), this.ok.getY(), BUTTON_W, BUTTON_H);
		//将组件添加到面板
		this.setLayout(null);
		this.add(this.startDateL);
		this.add(this.startDateT);
		this.add(this.endDateL);
		this.add(this.endDateT);
		this.add(this.ok);
		this.add(this.cancel);
	}
}
