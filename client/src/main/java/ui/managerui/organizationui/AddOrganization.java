package ui.managerui.organizationui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ui.baseui.DetailPanel;

@SuppressWarnings("serial")
public class AddOrganization extends DetailPanel{

	private JLabel typeLabel = new JLabel("机构类型");
	
	private JComboBox<String> typeText = new JComboBox<String> ();
	
	private JLabel idLabel = new JLabel("机构编号");
	
	private JTextField idText = new JTextField();
	
	private JLabel nameLabel = new JLabel("机构名称");
	
	private JTextField nameText = new JTextField();
	
	private JButton ok = new JButton("确定");
	
	private JButton cancel = new JButton("取消");
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 15);
	
	private static final int LABEL_W = 80;
	
	private static final int LABEL_H = 42;
	
	private static final int TEXT_W = LABEL_W * 3;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int BUTTON_W = 72;
	
	private static final int BUTTON_H = 32;
	
	private static final int START_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W) / 3;
	
	private static final int START_Y = START_X >> 1;
	
	public AddOrganization() {
		//机构编号标签
		this.idLabel.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.idLabel.setFont(WORD_FONT);
		//机构编号文本框
		this.idText.setBounds(this.idLabel.getX() + LABEL_W + (START_X >> 1),
				this.idLabel.getY(), TEXT_W, TEXT_H);
		this.idText.setFont(WORD_FONT);
		//机构类型标签
		this.typeLabel.setBounds(this.idLabel.getX(),
				this.idLabel.getY() + LABEL_H + (START_Y >> 1), LABEL_W, LABEL_H);
		this.typeLabel.setFont(WORD_FONT);
		//机构类型文本框
		this.typeText.setBounds(this.idText.getX(), this.typeLabel.getY(), TEXT_W, TEXT_H);
		this.typeText.setFont(WORD_FONT);
		this.typeText.addItem("营业厅");
		this.typeText.addItem("中转中心");
		this.typeText.addItem("总部");
		//机构名称标签
		this.nameLabel.setBounds(this.typeLabel.getX(),
				this.typeLabel.getY() + LABEL_H + (START_Y >> 1), LABEL_W, LABEL_W);
		this.nameLabel.setFont(WORD_FONT);
		//机构名称文本框
		this.nameText.setBounds(this.typeText.getX(), this.nameLabel.getY(), TEXT_W, TEXT_H);
		this.nameText.setFont(WORD_FONT);
		//确定按钮
		this.ok.setBounds(this.nameText.getX() + (TEXT_W >> 1),
				this.nameText.getY() + (TEXT_H << 1), BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + (BUTTON_W << 1), this.ok.getY(), BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		//将组件添加到面板
		this.add(this.idLabel);
		this.add(this.idText);
		this.add(this.typeLabel);
		this.add(this.typeText);
		this.add(this.nameLabel);
		this.add(this.nameText);
		this.add(this.ok);
		this.add(this.cancel);
	}
	
}
