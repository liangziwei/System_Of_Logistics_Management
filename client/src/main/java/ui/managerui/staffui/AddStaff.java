package ui.managerui.staffui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ui.baseui.DatePanel;
import ui.baseui.DetailPanel;

@SuppressWarnings("serial")
public class AddStaff extends DetailPanel{

	private JLabel nameLabel = new JLabel("姓名");
	
	private JTextField nameText = new JTextField();
	
	private JLabel idLabel = new JLabel("编号");
	
	private JTextField idText = new JTextField();
	
	private JLabel posLabel = new JLabel("职位");
	
	private JComboBox<String> posText = new JComboBox<String>();
	
	private JLabel birthLabel = new JLabel("出生日期");
	
	private DatePanel birthText = new DatePanel();
	
	private JLabel salaryLabel = new JLabel("薪水");
	
	private JComboBox<String> salaryType = new JComboBox<String>();
	
	private JTextField salaryText = new JTextField();
	
	private JButton ok = new JButton("确定");
	
	private JButton cancel = new JButton("取消");
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 12);
	
	private static final int LABEL_W = 60;
	
	private static final int LABEL_H = 32;
	
	private static final int TEXT_W = LABEL_W * 3;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int BUTTON_W = 60;
	
	private static final int BUTTON_H = 36;
	
	private static final int START_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W) / 3;
	
	private static final int START_Y = START_X >> 2;
	
	public AddStaff() {
		int gap = LABEL_H + START_Y;
		//姓名标签
		this.nameLabel.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.nameLabel.setFont(WORD_FONT);
		//姓名文本框
		this.nameText.setBounds(this.nameLabel.getX() + LABEL_W + (START_X >> 1),
				this.nameLabel.getY(), TEXT_W, TEXT_H);
		this.nameText.setFont(WORD_FONT);
		//编号标签
		this.idLabel.setBounds(this.nameLabel.getX(),
				this.nameText.getY() + gap, LABEL_W, LABEL_H);
		this.idLabel.setFont(WORD_FONT);
		//编号文本框
		this.idText.setBounds(this.nameText.getX(), this.idLabel.getY(), TEXT_W, TEXT_H);
		this.idText.setFont(WORD_FONT);
		//职位标签
		this.posLabel.setBounds(this.idLabel.getX(), this.idLabel.getY() + gap, LABEL_W, LABEL_H);
		this.posLabel.setFont(WORD_FONT);
		//职位文本框
		this.posText.setBounds(this.idText.getX(), this.posLabel.getY(), TEXT_W, TEXT_H);
		this.posText.setFont(WORD_FONT);
		this.posText.addItem("快递员");
		this.posText.addItem("营业厅业务员");
		this.posText.addItem("中转中心业务员");
		this.posText.addItem("中转中心库存管理人员");
		this.posText.addItem("财务人员");
		//出生日期标签
		this.birthLabel.setBounds(this.posLabel.getX(), this.posLabel.getY() + gap, LABEL_W, LABEL_H);
		this.birthLabel.setFont(WORD_FONT);
		//出生日期文本框
		this.birthText.setPanelBound(this.posText.getX(), this.birthLabel.getY(), TEXT_W, TEXT_H);
		this.birthText.setFont(WORD_FONT);
		//薪水标签
		this.salaryLabel.setBounds(this.birthLabel.getX(), this.birthLabel.getY() + gap, LABEL_W, LABEL_H);
		this.salaryLabel.setFont(WORD_FONT);
		//薪水类型
		this.salaryType.setBounds(this.birthText.getX(), this.salaryLabel.getY(), TEXT_W >> 1, TEXT_H);
		this.salaryType.setFont(WORD_FONT);
		this.salaryType.addItem("按月");
		this.salaryType.addItem("计次");
		this.salaryType.addItem("提成");
		//薪水文本框
		this.salaryText.setBounds(this.salaryType.getX() + this.salaryType.getWidth(),
				this.salaryType.getY(), TEXT_W >> 1, TEXT_H);
		this.salaryText.setFont(WORD_FONT);
		//确定按钮
		this.ok.setBounds(this.salaryText.getX(),
				this.salaryText.getY() + TEXT_H + START_Y, BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + (BUTTON_W << 1), this.ok.getY(), BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		//将组件添加到面板
		this.add(this.nameLabel);
		this.add(this.nameText);
		this.add(this.idLabel);
		this.add(this.idText);
		this.add(this.posLabel);
		this.add(this.posText);
		this.add(this.birthLabel);
		this.add(this.birthText);
		this.add(this.salaryLabel);
		this.add(this.salaryType);
		this.add(this.salaryText);
		this.add(this.ok);
		this.add(this.cancel);
	}
}
