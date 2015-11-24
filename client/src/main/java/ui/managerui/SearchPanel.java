package ui.managerui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SearchPanel extends JPanel{

	private JLabel idLabel = null;
	
	private JTextField idText = new JTextField();
	
	private JButton ok = new JButton("确定");
	
	private JButton cancel = new JButton("取消");
	
	public SearchPanel(String labelText, Font wordFont, int x, int y, int w, int h) {
		this.idLabel = new JLabel(labelText);
		//计算常量
		int labelW = w / 9;
		int labelH = h >> 1;
		int textW = w / 3;
		int textH = labelH;
		int buttonW = labelW;
		int buttonH = labelH;
		int startX = w / 9;
		int startY = h / 6;
		//机构编号标签
		this.idLabel.setBounds(startX, startY, labelW, labelH);
		this.idLabel.setFont(wordFont);
		//机构编号文本框
		this.idText.setBounds(this.idLabel.getX() + labelW + (startX >> 2),
				this.idLabel.getY(), textW, textH);
		this.idText.setFont(wordFont);
		//确定按钮
		this.ok.setBounds(this.idText.getX() + textW + (startX >> 1),
				this.idText.getY(), buttonW, buttonH);
		this.ok.setFont(wordFont);
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + buttonW + (startX >> 1),
				this.ok.getY(), buttonW, buttonH);
		this.cancel.setFont(wordFont);
		//将组件添加到面板
		this.setLayout(null);
		this.setBounds(x, y, w, h);
		this.add(this.idLabel);
		this.add(this.idText);
		this.add(this.ok);
		this.add(this.cancel);
	}
	
	public JButton getOk() {
		return this.ok;
	}
	
	public JButton getCancel() {
		return this.cancel;
	}
}
