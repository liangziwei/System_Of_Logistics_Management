package ui.financeui.statisticsui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ui.baseui.DetailPanel;

@SuppressWarnings("serial")
public class RunningPanel extends DetailPanel{
	
	private JLabel costLabel = new JLabel("总支出");
	
	private JTextField costText = new JTextField();
	
	private JLabel earningsLabel = new JLabel("总收益");
	
	private JTextField earningsText = new JTextField();
	
	private JLabel profitLabel = new JLabel("总利润");
	
	private JTextField profitText = new JTextField();
	
	private JButton ok = new JButton("确定");
	
	private JButton cancel = new JButton("取消");
	
	private static final int LABEL_W = 60;
	
	private static final int LABEL_H = 32;
	
	private static final int TEXT_W = LABEL_W << 1;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int BUTTON_W = LABEL_W;
	
	private static final int BUTTON_H = LABEL_H;
	
	private static final int COST_LABEL_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W) / 3;
	
	private static final int COST_LABEL_Y = COST_LABEL_X;
	
	public RunningPanel() {
		//总支出标签
		this.costLabel.setBounds(COST_LABEL_X, COST_LABEL_Y, LABEL_W, LABEL_H);
		//总支出文本框
		//总收入标签
		//总收入文本框
		//总利润标签
		//总利润文本框
		//确定按钮
		//取消按钮
	}
}
