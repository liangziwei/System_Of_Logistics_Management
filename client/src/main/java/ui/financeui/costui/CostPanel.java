package ui.financeui.costui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import businessLogic.businessLogicController.financeController.AccountController;
import businessLogic.businessLogicController.financeController.CostController;
import businessLogic.businessLogicController.transitionController.TransferringController;
import businessLogic.businessLogicModel.util.CommonLogic;
import businessLogicService.financeBLService.AccountBLService;
import businessLogicService.financeBLService.CostBLService;
import businessLogicService.transitionBLService.TransferringBLService;
import ui.DateChooser;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;
import vo.financeVO.AccountVO;
import vo.financeVO.PaymentVO;
import vo.transitionVO.TransferringVO;

@SuppressWarnings("serial")
public class CostPanel extends DetailPanel{
	
	private CostBLService cost = new CostController();

	private JLabel dateLabel = new JLabel("付款日期");
	
	private JTextField dateText = new JTextField();
	
	private DateChooser dateChooser = DateChooser.getInstance();
	
	private JLabel moneyLabel = new JLabel("付款金额");
	
	private JTextField moneyText = new JTextField();
	
	private JLabel nameLabel = new JLabel("付款人");
	
	private JTextField nameText = new JTextField();
	
	private JLabel accountLabel = new JLabel("付款账户");
	
	private JTextField accountText = new JTextField();
	
	private JLabel itemLabel = new JLabel("条目");
	
	private JComboBox<String> itemText = new JComboBox<String>();
	
	private JLabel noteLabel = new JLabel("租金年份");
	
	private JTextField noteText;
	
	private LimpidButton ok = new LimpidButton("","picture/确定.png");
	
	private LimpidButton cancel = new LimpidButton("","picture/取消.png");
	
	private JLabel tip = new JLabel();
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 12);
	
	/**
	 * 成员变量itemText不同的选项序号与对应备注名称之间的映射表
	 */
	private static Map<Integer, String> ITEM_MAP = new HashMap<Integer, String>();
	
	static {
		ITEM_MAP.put(0, "租金年份");
		ITEM_MAP.put(1, "运单号");
		ITEM_MAP.put(2, "月份");
		ITEM_MAP.put(3, "备注");
	}
	
	/**
	 *不同付款内容与对应的输入文本框之间的映射表 
	 */
	private Map<Integer, NoteText> textMap = new HashMap<Integer, NoteText>();
	
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
		this.dateText.setBounds(this.dateLabel.getX() + LABEL_W + LT_GAP, this.dateLabel.getY(), TEXT_W, TEXT_H);
		this.dateText.setFont(WORD_FONT);
		this.dateText.setOpaque(false);
		this.dateChooser.register(this.dateText);
		//付款金额标签
		this.moneyLabel.setBounds(this.dateLabel.getX(), this.dateLabel.getY() + gap, LABEL_W, LABEL_H);
		this.moneyLabel.setFont(WORD_FONT);
		//付款金额文本框
		this.moneyText.setBounds(this.dateText.getX(), this.moneyLabel.getY(), TEXT_W, TEXT_H);
		this.moneyText.setFont(WORD_FONT);
		this.moneyText.setOpaque(false);
		//付款人标签
		this.nameLabel.setBounds(this.moneyLabel.getX(), this.moneyLabel.getY() + gap, LABEL_W, LABEL_H);
		this.nameLabel.setFont(WORD_FONT);
		//付款人文本框
		this.nameText.setBounds(this.moneyText.getX(), this.nameLabel.getY(), TEXT_W, TEXT_H);
		this.nameText.setFont(WORD_FONT);
		this.nameText.setOpaque(false);
		//付款账户标签
		this.accountLabel.setBounds(this.nameLabel.getX(), this.nameLabel.getY() + gap, LABEL_W, LABEL_H);
		this.accountLabel.setFont(WORD_FONT);
		//付款账户文本框
		this.accountText.setBounds(this.nameText.getX(), this.accountLabel.getY(), TEXT_W, TEXT_H);
		this.accountText.setFont(WORD_FONT);
		this.accountText.setOpaque(false);
		//条目标签
		this.itemLabel.setBounds(this.accountLabel.getX(), this.accountLabel.getY() + gap, LABEL_W, LABEL_H);
		this.itemLabel.setFont(WORD_FONT);
		//条目文本框
		this.itemText.setBounds(this.accountText.getX(), this.itemLabel.getY(), TEXT_W, TEXT_H);
		this.itemText.setFont(WORD_FONT);
		this.itemText.setOpaque(false);
		//备注标签
		this.noteLabel.setBounds(this.itemLabel.getX(), this.itemLabel.getY() + gap, LABEL_W, LABEL_H);
		this.noteLabel.setFont(WORD_FONT);
		//备注文本框映射表
		this.textMap.put(0, new YearText());
		this.textMap.put(1, new TransitText());
		this.textMap.put(2, new MonthText());
		this.textMap.put(3, new RemarkText());
		//备注文本框
		this.noteText = this.textMap.get(0);
		this.setNoteTextUI();
		//确定按钮
		this.ok.setBounds(this.noteText.getX() + (TEXT_W >> 1), this.noteText.getY() + TEXT_H + gap
				, BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + (BUTTON_W * 3 >> 1), this.ok.getY(), BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		//提示标签
		this.tip.setBounds(this.noteLabel.getX(), this.ok.getY(), TEXT_W, TEXT_H);
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
		return new PaymentVO(this.dateText.getText(), Double.parseDouble(this.moneyText.getText()),
				this.nameText.getText(), this.accountText.getText(), 
				(String)this.itemText.getSelectedItem(), this.noteText.getText(), false, false);
	}
	
	private void addItem() {
		//这里添加顺序不能改变，因为映射表ITEM_MAP和textMap根据它们的先后关系来添加映射关系
		this.itemText.addItem("租金（按年收）");
		this.itemText.addItem("运费（按次计算）");
		this.itemText.addItem("人员工资（按月统计）");
		this.itemText.addItem("奖励（一次性）");
	}
	
	private void clearInfo() {
		this.nameText.setText("");
		this.dateText.setText("");
		this.moneyText.setText("");
		this.accountText.setText("");
		this.noteText.setText("");
	}
	
	private void addListener() {
		//确定按钮
		this.ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//验证输入
				tip.setForeground(Color.RED);
				if(!verifyInput()) return ;
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
					tip.setText("保存失败");
				}
				repaint();
			}
		});
		//取消按钮
		this.cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tip.setText("");
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
				noteLabel.setText(ITEM_MAP.get(selected));
				//设置备注文本框
				noteText = textMap.get(selected);
			}
		});
	}
	
	private boolean verifyInput() {
		//验证输入日期是否合法
		if(!CommonLogic.isDate(this.dateText.getText())) {
			tip.setText("输入的日期不存在");
			return false;
		}
		//验证输入是否完整
		if(CommonLogic.isNull(this.dateText.getText()) || CommonLogic.isNull(this.moneyText.getText())
				|| CommonLogic.isNull(this.nameText.getText()) || CommonLogic.isNull(this.accountText.getText())) {
			tip.setText("请把信息填写完整");
			return false;
		}
		//验证输入付款金额是否为数字
		if(!CommonLogic.isDouble(this.moneyText.getText())) {
			tip.setText("付款金额应该为数字");
			return false;
		}
		//验证付款账户是否存在
		AccountBLService account = new AccountController();
		AccountVO vo = account.findAccount(this.accountText.getText());
		if(vo == null) {
			tip.setText("该账户不存在");
			return false;
		}
		//对不同的备注框进行不同的数据验证
		int select = this.itemText.getSelectedIndex();
		NoteText text = this.textMap.get(select);
		return text.setTipForInput(this.tip, text.getText());
		
	}
	
	/**
	 *设置备注文本框的边界，字体格式和是否透明
	 */
	private void setNoteTextUI() {
		if(this.noteText == null) return ;
		
		this.noteText.setBounds(this.itemText.getX(), this.noteLabel.getY(), TEXT_W, TEXT_H);
		this.noteText.setFont(WORD_FONT);
		this.noteText.setOpaque(false);
	}
}

/**
 * 以下各种文本框的父类，抽象出一个数据验证的方法，用于多态
 * 方法的参数：
 * tip 用于界面提示的标签，
 * input 用户在文本框上的输入
 */
@SuppressWarnings("serial")
abstract class NoteText extends JTextField {
	public abstract boolean setTipForInput(JLabel tip, String input);
}

/**
 *年份输入文本框，用于记录租金年份 
 */
@SuppressWarnings("serial")
class YearText extends NoteText {

	@Override
	public boolean setTipForInput(JLabel tip, String input) {
		if(!CommonLogic.isYear(input)) {
			tip.setText("年份应该为4为数字");
			return false;
		}
		return true;
	}	
}

/**
 *月份输入文本框，用于记录发送人员工资月份
 */
@SuppressWarnings("serial")
class MonthText extends NoteText {

	@Override
	public boolean setTipForInput(JLabel tip, String input) {
		if(!CommonLogic.isMonth(input)) {
			tip.setText("月份输入错误");
			return false;
		}
		return true;
	}
	
}

/**
 *运单号输入文本框，用于记录运费的运单号
 */
@SuppressWarnings("serial")
class TransitText extends NoteText {

	@Override
	public boolean setTipForInput(JLabel tip, String input) {
		TransferringBLService t = new TransferringController();
		TransferringVO vo = t.findTransferringFormBL(input);
		if(vo == null) {
			tip.setText("该运单号不存在");
			return false;
		}
		return true;
	}
	
}

/**
 *备注输入文本框，用于记录奖励的原因
 */
@SuppressWarnings("serial")
class RemarkText extends NoteText {

	@Override
	public boolean setTipForInput(JLabel tip, String input) {
		if(CommonLogic.isNull(input)) {
			tip.setText("备注不能为空");
			return false;
		}
		return true;
	}
	
}

