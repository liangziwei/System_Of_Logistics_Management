package ui.managerui.staffui;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vo.managerVO.StaffVO;

@SuppressWarnings("serial")
public class StaffInfoPanel extends JPanel{

	private JLabel nameLabel = new JLabel("姓名");
	
	private JTextField nameText = new JTextField();
	
	private JLabel genderLabel = new JLabel("性别");
	
	private JComboBox<String> genderText = new JComboBox<String>();
	
	private JLabel idLabel = new JLabel("编号");
	
	private JTextField idText = new JTextField();
	
	private JLabel posLabel = new JLabel("职位");
	
	private JComboBox<String> posText = new JComboBox<String>();
	
	private JLabel birthLabel = new JLabel("出生日期");
	
	private JTextField birthText = new JTextField();
	
	private JLabel salaryLabel = new JLabel("薪水");
	
	private JComboBox<String> salaryType = new JComboBox<String>();
	
	private JTextField salaryText = new JTextField();
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 12);
	
	/**
	 *人员类型与薪水类型的映射表(integer为添加到JComboBox的下标) 
	 */
	private static Map<Integer, Integer> SALARY_TYPE_MAP = new HashMap<Integer, Integer>();
	
	static {
		//快递员-提成
		SALARY_TYPE_MAP.put(0, 2);
		//司机-计次
		SALARY_TYPE_MAP.put(5, 1);
		//其他-按月
		SALARY_TYPE_MAP.put(1, 0);
		SALARY_TYPE_MAP.put(2, 0);
		SALARY_TYPE_MAP.put(3, 0);
		SALARY_TYPE_MAP.put(4, 0);
	}
	
	private static final int LABEL_W = 60;
	
	private static final int LABEL_H = 32;
	
	private static final int TEXT_W = LABEL_W * 3;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int START_X = (750 - LABEL_W - TEXT_W) / 3;
	
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
		this.nameText.setOpaque(false);
		//性别标签
		this.genderLabel.setBounds(this.nameLabel.getX(),
				this.nameText.getY() + gap, LABEL_W, LABEL_H);
		this.genderLabel.setFont(WORD_FONT);
		//性别文本框
		this.genderText.setBounds(this.nameText.getX(), this.genderLabel.getY(), TEXT_W, TEXT_H);
		this.genderText.setFont(WORD_FONT);
		this.genderText.addItem("男");
		this.genderText.addItem("女");
		this.genderText.setOpaque(false);
		//编号标签
		this.idLabel.setBounds(this.genderLabel.getX(),
				this.genderLabel.getY() + gap, LABEL_W, LABEL_H);
		this.idLabel.setFont(WORD_FONT);
		//编号文本框
		this.idText.setBounds(this.genderText.getX(), this.idLabel.getY(), TEXT_W, TEXT_H);
		this.idText.setFont(WORD_FONT);
		this.idText.setOpaque(false);
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
		this.posText.addItem("司机");
		//出生日期标签
		this.birthLabel.setBounds(this.posLabel.getX(), this.posLabel.getY() + gap, LABEL_W, LABEL_H);
		this.birthLabel.setFont(WORD_FONT);
		//出生日期文本框
		this.birthText.setBounds(this.posText.getX(), this.birthLabel.getY(), TEXT_W, TEXT_H);
		this.birthText.setFont(WORD_FONT);
		this.birthText.setOpaque(false);
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
		this.salaryText.setOpaque(false);
		//将组件添加到面板
		this.setLayout(null);
		this.setOpaque(false);
		
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
		
		//增加职位文本框的监听，根据职位的变化带来薪水支付方式的编号
		this.posText.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				int select = posText.getSelectedIndex();
				salaryType.setSelectedIndex(SALARY_TYPE_MAP.get(select));
			}
		});
	}
	
	public JPanel getStaffInfoPanel(StaffVO staffVO) {
		this.nameText.setText(staffVO.getName());
		this.genderText.setSelectedItem(staffVO.getGender());
		this.idText.setText(staffVO.getId());
		this.posText.setSelectedItem(staffVO.getPosition());
		this.birthText.setText(staffVO.getBirthday());
		this.salaryType.setSelectedItem(staffVO.getType());
		this.salaryText.setText(staffVO.getSalary());
		
		return this;
	}
	
	public StaffVO createVO() {
		return new StaffVO(nameText.getText(), idText.getText(),
				(String)posText.getSelectedItem(), (String)genderText.getSelectedItem(),
				birthText.getText(), salaryText.getText(), (String)salaryType.getSelectedItem(),
				false, false);
	}
	
	public JTextField getNameText() {
		return nameText;
	}

	public JTextField getBirthText() {
		return birthText;
	}

	public JTextField getIdText() {
		return idText;
	}

	public JTextField getSalaryText() {
		return salaryText;
	}
	
}
