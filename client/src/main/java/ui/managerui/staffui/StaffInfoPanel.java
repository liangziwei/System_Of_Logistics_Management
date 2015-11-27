package ui.managerui.staffui;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.baseui.DatePanel;
import ui.baseui.DetailPanel;
import vo.managerVO.StaffVO;

@SuppressWarnings("serial")
public class StaffInfoPanel extends DetailPanel{

	private JLabel nameLabel = new JLabel("姓名");
	
	private JTextField nameText = new JTextField();
	
	private JLabel genderLabel = new JLabel("性别");
	
	private JComboBox<String> genderText = new JComboBox<String>();
	
	private JLabel idLabel = new JLabel("编号");
	
	private JTextField idText = new JTextField();
	
	private JLabel posLabel = new JLabel("职位");
	
	private JComboBox<String> posText = new JComboBox<String>();
	
	private JLabel birthLabel = new JLabel("出生日期");
	
	private DatePanel birthText = new DatePanel();
	
	private JLabel salaryLabel = new JLabel("薪水");
	
	private JComboBox<String> salaryType = new JComboBox<String>();
	
	private JTextField salaryText = new JTextField();
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 12);
	
	private static final int LABEL_W = 60;
	
	private static final int LABEL_H = 32;
	
	private static final int TEXT_W = LABEL_W * 3;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int START_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W) / 3;
	
	private static final int START_Y = START_X >> 2;
	
	public StaffInfoPanel() {
		//标签与标签之间的距离
		int gap = LABEL_H + START_Y - 12;
		//姓名标签
		this.nameLabel.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.nameLabel.setFont(WORD_FONT);
		//姓名文本框
		this.nameText.setBounds(this.nameLabel.getX() + LABEL_W + (START_X >> 1),
				this.nameLabel.getY(), TEXT_W, TEXT_H);
		this.nameText.setFont(WORD_FONT);
		//性别标签
		this.genderLabel.setBounds(this.nameLabel.getX(),
				this.nameText.getY() + gap, LABEL_W, LABEL_H);
		this.genderLabel.setFont(WORD_FONT);
		//性别文本框
		this.genderText.setBounds(this.nameText.getX(), this.genderLabel.getY(), TEXT_W, TEXT_H);
		this.genderText.setFont(WORD_FONT);
		this.genderText.addItem("男");
		this.genderText.addItem("女");
		//编号标签
		this.idLabel.setBounds(this.genderLabel.getX(),
				this.genderLabel.getY() + gap, LABEL_W, LABEL_H);
		this.idLabel.setFont(WORD_FONT);
		//编号文本框
		this.idText.setBounds(this.genderText.getX(), this.idLabel.getY(), TEXT_W, TEXT_H);
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
		//将组件添加到面板
		this.add(this.nameLabel);
		this.add(this.nameText);
		this.add(this.genderLabel);
		this.add(this.genderText);
		this.add(this.idLabel);
		this.add(this.idText);
		this.add(this.posLabel);
		this.add(this.posText);
		this.add(this.birthLabel);
		this.add(this.birthText);
		this.add(this.salaryLabel);
		this.add(this.salaryType);
		this.add(this.salaryText);
	}
	
	public JPanel getStaffInfoPanel(StaffVO staffVO) {
		this.nameText.setText(staffVO.getName());
		this.genderText.setSelectedItem(staffVO.getGender());
		this.idText.setText(staffVO.getId());
		this.posText.setSelectedItem(staffVO.getPosition());
		this.birthText.setDate(staffVO.getBirthday());
		this.salaryType.setSelectedItem(staffVO.getType());
		this.salaryText.setText(staffVO.getSalary());
		return this;
	}
	
	public StaffVO createVO() {
		return new StaffVO(nameText.getText(), idText.getText(),
				(String)posText.getSelectedItem(), (String)genderText.getSelectedItem(),
				birthText.getDate(), salaryText.getText(), (String)salaryType.getSelectedItem(),
				false, false);
	}
}
