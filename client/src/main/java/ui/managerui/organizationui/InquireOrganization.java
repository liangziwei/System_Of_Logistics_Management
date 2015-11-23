package ui.managerui.organizationui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ui.baseui.DetailPanel;

@SuppressWarnings("serial")
public class InquireOrganization extends DetailPanel{

	private JLabel idLabel = new JLabel("机构编号");
	
	private JTextField idText = new JTextField();
	
	private JButton ok = new JButton("确定");
	
	private JButton cancel = new JButton("取消");
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 12);
	
	private static final int LABEL_W = 72;
	
	private static final int LABEL_H = 36;
	
	private static final int TEXT_W = LABEL_W * 3;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int BUTTON_W = LABEL_W;
	
	private static final int BUTTON_H = LABEL_H;
	
	private static final int START_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W - (BUTTON_W << 1)) / 5;
	
	private static final int START_Y = START_X;
	
	public InquireOrganization() {
		//机构编号标签
		this.idLabel.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.idLabel.setFont(WORD_FONT);
		//机构编号文本框
		this.idText.setBounds(this.idLabel.getX() + LABEL_W + (START_X >> 1),
				this.idLabel.getY(), TEXT_W, TEXT_H);
		this.idText.setFont(WORD_FONT);
		//确定按钮
		this.ok.setBounds(this.idText.getX() + TEXT_W + START_X,
				this.idText.getY(), BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + BUTTON_W + (START_X >> 1),
				this.ok.getY(), BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		//将组件添加到面板
		this.add(this.idLabel);
		this.add(this.idText);
		this.add(this.ok);
		this.add(this.cancel);
	}
}
