package ui.financeui.statisticsui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import businessLogic.businessLogicController.financeController.StatisticsController;
import businessLogicService.financeBLService.StatisticsBLSevice;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;
import vo.financeVO.CostBenefitVO;

@SuppressWarnings("serial")
public class ProfitPanel extends DetailPanel{
	
	private StatisticsBLSevice statistics = new StatisticsController();
	
	private DateInputPanel dateInput = null;

	private JLabel costLabel = new JLabel("总支出");
	
	private JTextField costText = new JTextField();
	
	private JLabel earningsLabel = new JLabel("总收益");
	
	private JTextField earningsText = new JTextField();
	
	private JLabel profitLabel = new JLabel("总利润");
	
	private JTextField profitText = new JTextField();
	
	private LimpidButton ok = new LimpidButton("","picture/确定.png");
	
	private LimpidButton cancel = new LimpidButton("","picture/取消.png");
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 15);
	
	private static final int LABEL_W = 72;
	
	private static final int LABEL_H = 48;
	
	private static final int TEXT_W = LABEL_W * 3;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int PANEL_W = DETAIL_PANEL_W;
	
	private static final int PANEL_H = DETAIL_PANEL_H >> 2;
	
	private static final int BUTTON_W = 80;
	
	private static final int BUTTON_H = 30;
	
	private static final int COST_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W) / 3; 
	
	private static final int COST_Y = PANEL_H + (COST_X >> 1);
	
	public ProfitPanel() {
		//日期输入面板
		this.dateInput = new DateInputPanel(5, 5, PANEL_W - 10, PANEL_H);
		//确定按钮
		this.ok.setBounds(this.dateInput.getX() + (PANEL_W >> 1), this.dateInput.getHeight() + 5,
				BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + (BUTTON_W << 1), this.ok.getY(), BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		//总支出标签
		this.costLabel.setBounds(COST_X, COST_Y, LABEL_W, LABEL_H);
		this.costLabel.setFont(WORD_FONT);
		//总支出文本框
		this.costText.setBounds(this.costLabel.getX() + LABEL_W + (COST_X >> 1), this.costLabel.getY(),
				TEXT_W, TEXT_H);
		this.costText.setFont(WORD_FONT);
		this.costText.setOpaque(false);
		//总收益标签
		this.earningsLabel.setBounds(this.costLabel.getX(), this.costLabel.getY() + LABEL_H + (COST_X >> 2),
				LABEL_W, LABEL_H);
		this.earningsLabel.setFont(WORD_FONT);
		//总收益文本框
		this.earningsText.setBounds(this.costText.getX(), this.earningsLabel.getY(), TEXT_W, TEXT_H);
		this.earningsText.setFont(WORD_FONT);
		this.earningsText.setOpaque(false);
		//总利润标签
		this.profitLabel.setBounds(this.earningsLabel.getX(), this.earningsLabel.getY() + LABEL_H + (COST_X >> 2),
				LABEL_W, LABEL_H);
		this.profitLabel.setFont(WORD_FONT);
		//总利润文本框
		this.profitText.setBounds(this.earningsText.getX(), this.profitLabel.getY(), TEXT_W, TEXT_H);
		this.profitText.setFont(WORD_FONT);
		this.profitText.setOpaque(false);
		//将组件添加到面板
		this.add(this.dateInput);
		this.add(this.ok);
		this.add(this.cancel);
		this.add(this.costLabel);
		this.add(this.costText);
		this.add(this.earningsLabel);
		this.add(this.earningsText);
		this.add(this.profitLabel);
		this.add(this.profitText);
		//添加事件监听
		this.addListener();
	}
	
	private void addListener() {
		//确定按钮
		this.ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String startDate = dateInput.getStartDate();
				String endDate = dateInput.getEndDate();
				if(!dateInput.verifyInput(startDate, endDate)) return ;
				//获得成本收益表值对象
				CostBenefitVO vo = statistics.getCostBenefit(dateInput.getStartDate(), dateInput.getEndDate());
				//显示成本收益表
				showCostBenefit(vo);
			}
		});
		//取消按钮
		this.cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//清空用户输入
				dateInput.clearInfo();
				//清空成本与收益信息
				clearCostBenfit();
			}
		});
	}
	
	private void showCostBenefit(CostBenefitVO vo) {
		this.costText.setText(new Double(vo.getTotalPayment()).toString());
		this.earningsText.setText(new Double(vo.getTotalIncome()).toString());
		this.profitText.setText(new Double(vo.getTotalProfit()).toString());
		this.repaint();
	}
	
	//清空成本与收益信息
	private void clearCostBenfit() {
		this.costText.setText("");
		this.earningsText.setText("");
		this.profitText.setText("");
		this.repaint();
	}
}
