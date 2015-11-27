package ui.financeui.settlementui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 输入营业厅编号的面板
 */
@SuppressWarnings("serial")
public class BusinessIdPanel extends JPanel{

	private JLabel idLabel = new JLabel("营业厅编号");
	
	private JTextField idText = new JTextField();
	
	private JButton ok = new JButton("确定");
	
	private JButton cancel = new JButton("取消");
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 15);
	
	public BusinessIdPanel(int x, int y, int w, int h) {
		//计算常量
		int labelW = w / 9;
		int labelH = h >> 1;
		int textW = labelW << 1;
		int startX = labelW;
		int startY = h / 3;
		int textH = labelH;
		int buttonW = labelW;
		int buttonH = labelH;
		
		//营业厅编号标签
		this.idLabel.setBounds(startX, startY, labelW, labelH);
		this.idLabel.setFont(WORD_FONT);
		//营业厅编号文本框
		this.idText.setBounds(this.idLabel.getX() + labelW + (startX >> 1), this.idLabel.getY(), textW, textH);
		this.idText.setFont(WORD_FONT);
		//确定按钮
		this.ok.setBounds(this.idText.getX() + textW + startX, this.idText.getY(), buttonW, buttonH);
		this.ok.setFont(WORD_FONT);
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + buttonW + startX, this.ok.getY(), buttonW, buttonH);
		this.cancel.setFont(WORD_FONT);
		
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
	
	public String getId() {
		return this.idText.getText();
	}
}
