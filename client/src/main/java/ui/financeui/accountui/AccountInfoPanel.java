package ui.financeui.accountui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vo.financeVO.AccountVO;

@SuppressWarnings("serial")
public class AccountInfoPanel extends JPanel{
	
	private JLabel nameLabel = new JLabel("账户名称");
	
	private JTextField nameText = new JTextField();
	
	private JLabel moneyLabel = new JLabel("账户金额");
	
	private JTextField moneyText = new JTextField();
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 20);

	public AccountInfoPanel(int x, int y, int w, int h) {
		//初始化常量
		int labelW = w >> 3;
		int labelH = labelW >> 1;
		int textW = labelW * 3;
		int textH = labelH;
		int startX = labelW;
		int startY = startX;
		//账户名称标签
		this.nameLabel.setBounds(startX, startY, labelW, labelH);
		this.nameLabel.setFont(WORD_FONT);
		//账户名称文本框
		this.nameText.setBounds(labelW + (startX * 3 >> 1), this.nameLabel.getY(), textW, textH);
		this.nameText.setFont(WORD_FONT);
		//账户金额标签
		this.moneyLabel.setBounds(this.nameLabel.getX(), this.nameLabel.getY() + labelH + startY,
				labelW, labelH);
		this.moneyLabel.setFont(WORD_FONT);
		//账户金额文本框
		this.moneyText.setBounds(this.nameText.getX(), this.moneyLabel.getY(), textW, textH);
		this.moneyText.setFont(WORD_FONT);
		//主面板
		this.setLayout(null);
		this.setBounds(x, y, w, h);
		this.add(this.nameLabel);
		this.add(this.nameText);
		this.add(this.moneyLabel);
		this.add(this.moneyText);
	}
	
	public AccountInfoPanel(int x, int y, int w, int h, AccountVO vo) {
		this(x, y, w, h);
		this.nameText.setText(vo.getName());
		this.moneyText.setText(new Double(vo.getBalance()).toString());
	}

	public void disableMoneyText() {
		this.moneyText.setEditable(false);
	}
	
	public String getAccountName() {
		return this.nameText.getText();
	}
}
