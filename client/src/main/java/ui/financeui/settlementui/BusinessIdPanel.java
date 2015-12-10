package ui.financeui.settlementui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.baseui.LimpidButton;

/**
 * 输入营业厅编号的面板
 */
@SuppressWarnings("serial")
public class BusinessIdPanel extends JPanel{

	private JLabel idLabel = new JLabel("营业厅编号");
	
	private JTextField idText = new JTextField();
	
	private LimpidButton ok = new LimpidButton("","picture/确定.png");
	
	private JLabel tip = new JLabel();
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 13);
	
	public BusinessIdPanel(int x, int y, int w, int h) {
		//计算常量
		int labelW = w / 9;
		int labelH = h >> 1;
		int textW = labelW << 1;
		int startX = labelW;
		int startY = h / 3;
		int textH = labelH;
		
		//营业厅编号标签
		this.idLabel.setBounds(startX, startY, labelW, labelH);
		this.idLabel.setFont(WORD_FONT);
		//营业厅编号文本框
		this.idText.setBounds(this.idLabel.getX() + labelW + (startX >> 1), this.idLabel.getY(), textW, textH);
		this.idText.setFont(WORD_FONT);
		this.idText.setOpaque(false);
		//确定按钮
		this.ok.setBounds(this.idText.getX() + textW + startX, this.idText.getY(), 80, 30);
		this.ok.setFont(WORD_FONT);
		//提示标签
		this.tip.setBounds(0, h >> 1, textW, labelH);
		this.tip.setFont(WORD_FONT);
		this.tip.setForeground(Color.RED);
		
		//将组件添加到面板
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(x, y, w, h);
		this.add(this.idLabel);
		this.add(this.idText);
		this.add(this.ok);
		this.add(this.tip);
	}
	
	public void setTip(String text) {
		this.tip.setText(text);
		this.repaint();
	}
	
	public void removeTip() {
		this.tip.setText("");
		this.repaint();
	}
	
	public JButton getOk() {
		return this.ok;
	}
	
	public String getId() {
		return this.idText.getText();
	}
}
