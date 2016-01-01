package ui.managerui.staffui;

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

import businessLogic.businessLogicController.managerController.OrganizationManagementController;
import businessLogic.businessLogicController.managerController.StaffManagementController;
import businessLogic.businessLogicModel.util.CommonLogic;
import businessLogicService.managerBLService.OrganizationManagementBLService;
import businessLogicService.managerBLService.StaffManagementBLService;
import ui.DateChooser;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;
import vo.managerVO.OrganizationVO;
import vo.managerVO.StaffVO;

@SuppressWarnings("serial")
public class AddStaff extends DetailPanel{
	
	private StaffManagementBLService staff = new StaffManagementController();

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
	
	private LimpidButton ok = new LimpidButton("","picture/确定.png");
	
	private LimpidButton cancel = new LimpidButton("","picture/取消.png");
	
	private JLabel tip = new JLabel();
	
	private DateChooser dateChooser = DateChooser.getInstance();
	
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
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 12);
	
	private static final int LABEL_W = 60;
	
	private static final int LABEL_H = 32;
	
	private static final int TEXT_W = LABEL_W * 3;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int BUTTON_W = 80;
	
	private static final int BUTTON_H = 30;
	
	private static final int START_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W) / 3;
	
	private static final int START_Y = START_X >> 2;
	
	public AddStaff() {
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
		this.setOpaque(false);
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
		this.posText.setOpaque(false);
		//出生日期标签
		this.birthLabel.setBounds(this.posLabel.getX(), this.posLabel.getY() + gap, LABEL_W, LABEL_H);
		this.birthLabel.setFont(WORD_FONT);
		//出生日期文本框
		this.birthText.setBounds(this.posText.getX(), this.birthLabel.getY(), TEXT_W, TEXT_H);
		this.birthText.setFont(WORD_FONT);
		this.birthText.setOpaque(false);
		this.dateChooser.register(this.birthText);
		//薪水标签
		this.salaryLabel.setBounds(this.birthLabel.getX(), this.birthLabel.getY() + gap, LABEL_W, LABEL_H);
		this.salaryLabel.setFont(WORD_FONT);
		//薪水类型
		this.salaryType.setBounds(this.birthText.getX(), this.salaryLabel.getY(), TEXT_W >> 1, TEXT_H);
		this.salaryType.setFont(WORD_FONT);
		this.salaryType.addItem("按月");
		this.salaryType.addItem("计次");
		this.salaryType.addItem("提成");
		this.salaryType.setSelectedIndex(2);
		//薪水文本框
		this.salaryText.setBounds(this.salaryType.getX() + this.salaryType.getWidth(),
				this.salaryType.getY(), TEXT_W >> 1, TEXT_H);
		this.salaryText.setFont(WORD_FONT);
		this.salaryText.setOpaque(false);
		//确定按钮
		this.ok.setBounds(this.salaryText.getX(),
				this.salaryText.getY() + TEXT_H + START_Y, BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + (BUTTON_W << 1), this.ok.getY(), BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		//提示标签
		this.tip.setBounds(this.salaryLabel.getX(), this.ok.getY(), TEXT_W, LABEL_H);
		this.tip.setFont(WORD_FONT);
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
		this.add(this.ok);
		this.add(this.cancel);
		this.add(this.tip);
		//添加事件监听
		this.addListener();
	}
	
	private void addListener() {
		//确定按钮
		this.ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//输入验证
				tip.setForeground(Color.RED);
				if(!verifyInput(idText, nameText, birthText, salaryText, tip, false)) return ;
				//保存输入
				boolean result = staff.addStaff(new StaffVO(nameText.getText(), idText.getText(),
						(String)posText.getSelectedItem(), (String)genderText.getSelectedItem(),
						birthText.getText(), salaryText.getText(), (String)salaryType.getSelectedItem(),
						false, false));
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
				//清空用户输入的信息
				clearInfo();
				//刷新面板
				repaint();
			}
		});
		//人员类型下拉框
		this.posText.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				//根据人员类型选择不同的薪水类型
				int position = posText.getSelectedIndex();
				salaryType.setSelectedIndex(SALARY_TYPE_MAP.get(position));
			}
		});;
	}
	
	private void clearInfo() {
		this.nameText.setText("");
		this.idText.setText("");
		this.birthText.setText("");;
		this.salaryText.setText("");
	}
	
	public boolean verifyInput(JTextField idText, JTextField nameText,
			JTextField birthText, JTextField salaryText, JLabel tip, boolean isModify) {
		//验证输入是否完整
		String id = idText.getText();
		if(CommonLogic.isNull(nameText.getText()) || CommonLogic.isNull(id)
				|| CommonLogic.isNull(birthText.getText()) || CommonLogic.isNull(salaryText.getText())) {
			tip.setText("请把信息填写完整");
			return false;
		}
		//验证人员编号是否为9位数字
		if(!CommonLogic.isNumber(id) || id.length() != 9) {
			tip.setText("人员编号应为9位数字");
			return false;
		}
		//验证人员对应的机构是否存在
		String temp = null;
		try {
			temp = id.substring(0, 6);
		}catch(IndexOutOfBoundsException e) {
			tip.setText("人员编号前6位对应的机构不存在");
			return false;
		}
		OrganizationManagementBLService org = new OrganizationManagementController();
		OrganizationVO orgVO = org.findOrganization(temp);
		
		if(orgVO == null) {
			tip.setText("人员编号前6位对应的机构不存在");
			return false;
		}
		//验证该人员编号是否已经存在
		StaffVO vo = this.staff.findStaff(id);
		if(vo != null) {
			tip.setText("该人员编号已存在");
			return false;
		}
		//验证日期是否符合格式
		if(!CommonLogic.isDate(birthText.getText())) {
			tip.setText("该日期不存在");
			return false;
		}
		//验证薪水是否为数字
		if(!CommonLogic.isDouble(salaryText.getText())) {
			tip.setText("薪水应该为数字");
			return false;
		}
		return true;
	}
}
