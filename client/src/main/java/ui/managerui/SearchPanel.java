package ui.managerui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.baseui.LimpidButton;

@SuppressWarnings("serial")
public class SearchPanel extends JPanel{

	private JLabel idLabel = null;
	
	private JTextField idText = new JTextField();
	
	private JLabel text = new JLabel();
	
	private LimpidButton ok = new LimpidButton("","picture/确定.png");
	
	private LimpidButton cancel = new LimpidButton("","picture/取消.png");
	
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
		this.idText.setOpaque(false);
		//确定按钮
		this.ok.setBounds(this.idText.getX() + textW + (startX >> 1),
				this.idText.getY(), buttonW, buttonH);
		this.ok.setFont(wordFont);
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + buttonW + (startX >> 1),
				this.ok.getY(), buttonW, buttonH);
		this.cancel.setFont(wordFont);
		//信息标签
		this.text.setBounds(0, (int)(labelH * 1.2), labelW << 1, labelH);
		//将组件添加到面板
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(x, y, w, h);
		this.add(this.idLabel);
		this.add(this.idText);
		this.add(this.ok);
		this.add(this.cancel);
		this.add(this.text);
	}
	
	public void setText(String text, Font font, Color foreground) {
		this.text.setFont(font);
		this.text.setForeground(foreground);
		this.text.setText(text);
		this.repaint();
	}
	
	public void removeText() {
		this.text.setText("");
		this.repaint();
	}
	
	public JButton getOk() {
		return this.ok;
	}
	
	public JButton getCancel() {
		return this.cancel;
	}
	
	public JLabel getIDLabel() {
		return this.idLabel;
	}

	public String getIdText() {
		return idText.getText();
	}
	
	public void clearIdText() {
		this.idText.setText("");
	}
}
