package ui.financeui.costui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import businessLogic.businessLogicController.financeController.CostController;
import businessLogic.businessLogicModel.util.CommonLogic;
import businessLogicService.financeBLService.CostBLService;
import ui.baseui.DatePanel;
import ui.baseui.DetailPanel;
import vo.financeVO.PaymentVO;

@SuppressWarnings("serial")
public class CostPanel extends DetailPanel{
	
	private CostBLService cost = new CostController();

	private JLabel dateLabel = new JLabel("付款日期");
	
	private DatePanel dateText = new DatePanel();
	
	private JLabel moneyLabel = new JLabel("付款金额");
	
	private JTextField moneyText = new JTextField();
	
	private JLabel nameLabel = new JLabel("付款人");
	
	private JTextField nameText = new JTextField();
	
	private JLabel accountLabel = new JLabel("付款账户");
	
	private JTextField accountText = new JTextField();
	
	private JLabel itemLabel = new JLabel("条目");
	
	private JComboBox<String> itemText = new JComboBox<String>();
	
	private JLabel noteLabel = new JLabel("租金年份");
	
	private JTextField noteText = new JTextField();
	
	private JButton ok = new JButton("确定");
	
	private JButton cancel = new JButton("取消");
	
	private JLabel tip = new JLabel();
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 12);
	
	private static final int LABEL_W = 60;
	
	private static final int LABEL_H = 35;
	
	private static final int TEXT_W = LABEL_W * 3;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int BUTTON_W = 80;
	
	private static final int BUTTON_H = 30;
	
	/**
	 * 标签与文本框之间的距离
	 */
	private static final int LT_GAP = 96;
	
	private static final int START_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W - LT_GAP) >> 1;
	
	private static final int START_Y = (DETAIL_PANEL_H - (LABEL_H << 3) - BUTTON_H) / 9;
	
	public CostPanel() {
		//初始化界面
		this.initUI();
		//增加下拉框选项
		this.addItem();
		//增加事件监听
		this.addListener();
	}
	
	private void initUI() {
		int gap = LABEL_H + START_Y;
		//付款日期标签
		this.dateLabel.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.dateLabel.setFont(WORD_FONT);
		//付款日期文本框
		this.dateText.setPanelBound(this.dateLabel.getX() + LABEL_W + LT_GAP, this.dateLabel.getY(), TEXT_W, TEXT_H);
		this.dateText.setFont(WORD_FONT);
		//付款金额标签
		this.moneyLabel.setBounds(this.dateLabel.getX(), this.dateLabel.getY() + gap, LABEL_W, LABEL_H);
		this.moneyLabel.setFont(WORD_FONT);
		//付款金额文本框
		this.moneyText.setBounds(this.dateText.getX(), this.moneyLabel.getY(), TEXT_W, TEXT_H);
		this.moneyText.setFont(WORD_FONT);
		//付款人标签
		this.nameLabel.setBounds(this.moneyLabel.getX(), this.moneyLabel.getY() + gap, LABEL_W, LABEL_H);
		this.nameLabel.setFont(WORD_FONT);
		//付款人文本框
		this.nameText.setBounds(this.moneyText.getX(), this.nameLabel.getY(), TEXT_W, TEXT_H);
		this.nameText.setFont(WORD_FONT);
		//付款账户标签
		this.accountLabel.setBounds(this.nameLabel.getX(), this.nameLabel.getY() + gap, LABEL_W, LABEL_H);
		this.accountLabel.setFont(WORD_FONT);
		//付款账户文本框
		this.accountText.setBounds(this.nameText.getX(), this.accountLabel.getY(), TEXT_W, TEXT_H);
		this.accountText.setFont(WORD_FONT);
		//条目标签
		this.itemLabel.setBounds(this.accountLabel.getX(), this.accountLabel.getY() + gap, LABEL_W, LABEL_H);
		this.itemLabel.setFont(WORD_FONT);
		//条目文本框
		this.itemText.setBounds(this.accountText.getX(), this.itemLabel.getY(), TEXT_W, TEXT_H);
		this.itemText.setFont(WORD_FONT);
		//备注标签
		this.noteLabel.setBounds(this.itemLabel.getX(), this.itemLabel.getY() + gap, LABEL_W, LABEL_H);
		this.noteLabel.setFont(WORD_FONT);
		//备注文本框
		this.noteText.setBounds(this.itemText.getX(), this.noteLabel.getY(), TEXT_W, TEXT_H);
		this.noteText.setFont(WORD_FONT);
		//确定按钮
		this.ok.setBounds(this.noteText.getX() + (TEXT_W >> 1), this.noteText.getY() + TEXT_H + gap
				, BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + (BUTTON_W * 3 >> 1), this.ok.getY(), BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		//提示标签
		this.tip.setBounds(this.noteLabel.getX(), this.ok.getY(), LABEL_W, LABEL_H);
		this.tip.setFont(WORD_FONT);
		//将按钮添加到面板
		this.setLayout(null);
		this.add(this.dateLabel);
		this.add(this.dateText);
		this.add(this.moneyLabel);
		this.add(this.moneyText);
		this.add(this.nameLabel);
		this.add(this.nameText);
		this.add(this.accountLabel);
		this.add(this.accountText);
		this.add(this.itemLabel);
		this.add(this.itemText);
		this.add(this.noteLabel);
		this.add(this.noteText);
		this.add(this.ok);
		this.add(this.cancel);
		this.add(this.tip);
	}
	
	private PaymentVO createPayment() {
		return new PaymentVO(this.dateText.getDate(), Double.parseDouble(this.moneyText.getText()),
				this.nameText.getText(), this.accountText.getText(), 
				(String)this.itemText.getSelectedItem(), this.noteText.getText(), false, false);
	}
	
	private void addItem() {
		this.itemText.addItem("租金（按年收）");
		this.itemText.addItem("运费（按次计算）");
		this.itemText.addItem("人员工资（按月统计）");
		this.itemText.addItem("奖励（一次性）");
	}
	
	private void clearInfo() {
		this.nameText.setText("");
		this.dateText.clearInfo();
		this.moneyText.setText("");
		this.accountText.setText("");
		this.noteText.setText("");
	}
	
	private void addListener() {
		//确定按钮
		this.ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//验证输入是否完整 TODO 进行更进一步的信息验证
				tip.setForeground(Color.RED);
				if(!isComplete()) {
					tip.setText("请把信息填写完整");
					return ;
				}
				//保存信息
				boolean result = cost.addPayment(createPayment());
				//如果保存成功
				if(result) {
					//清空用户所填信息
					clearInfo();
					//提示保存成功
					tip.setForeground(Color.BLUE);
					tip.setText("保存成功");
				}
				else {
					tip.setForeground(Color.RED);
					tip.setText("保存失败，请重试");
				}
				repaint();
			}
		});
		//取消按钮
		this.cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//清空用户输入的信息
				clearInfo();
				//刷新面板
				repaint();
			}
		});
		//付款条目
		itemText.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				int selected = itemText.getSelectedIndex();
				switch(selected) {
				case 0:
					noteLabel.setText("租金年份");
					break;
				case 1:
					noteLabel.setText("运单号");
					break;
				case 2:
					noteLabel.setText("月份");
					break;
				case 3:
					noteLabel.setText("备注");
					break;
				default:
					noteLabel.setText("租金年份");
					break;
				}
			}
		});
	}
	
	private boolean isComplete() {
		return !(CommonLogic.isNull(this.dateText.getDate()) || CommonLogic.isNull(this.moneyText.getText())
				|| CommonLogic.isNull(this.nameText.getText()) || CommonLogic.isNull(this.accountText.getText())
				|| CommonLogic.isNull(this.noteText.getText()));
	}
}
