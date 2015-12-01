package ui.financeui.settlementui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ui.baseui.DatePanel;
import vo.businessVO.ReceivableVO;

@SuppressWarnings("serial")
public class ReceivablePanel extends JPanel{
	
	private JLabel dateLabel = new JLabel("收款日期");
	
	private DatePanel dateText = new DatePanel();
	
	private JLabel nameLabel = new JLabel("收款快递员");
	
	private JTextField nameText = new JTextField();
	
	private JLabel itemLabel = new JLabel("收款项");
	
	private JTextArea itemText = new JTextArea();
	
	private JScrollPane itemContainer = new JScrollPane();
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 12);

	public ReceivablePanel(ReceivableVO receivable, int x, int y, int w, int h) {
		//初始化组件
		int idNum = receivable.getDeliveryid().size();
		int labelW = w / 5;
		int textW = labelW * 3;	
		int dateX = labelW >> 1;
		int dateY = 0;
		int labelH = dateX;
		int textH = labelH;
		int ltGap = labelW >> 1;	//标签与文本框的距离
		//日期标签
		this.dateLabel.setBounds(dateX, dateY, labelW, labelH);
		this.dateLabel.setFont(WORD_FONT);
		//日期文本框
		this.dateText.setPanelBound(this.dateLabel.getX() + labelW + ltGap, this.dateLabel.getY(),
				textW, textH);
		this.dateText.setFont(WORD_FONT);
		this.dateText.setDate();
		//收款快递员标签
		this.nameLabel.setBounds(this.dateLabel.getX(), this.dateLabel.getY() + labelH + ltGap,
				labelW, labelH);
		this.nameLabel.setFont(WORD_FONT);
		//收款快递员文本框
		this.nameText.setBounds(this.dateText.getX(), this.nameLabel.getY(), textW, textH);
		this.nameText.setFont(WORD_FONT);
		this.nameText.setText(receivable.getCourier());
		this.nameText.setEditable(false);
		//收款项标签
		this.itemLabel.setBounds(this.nameLabel.getX(), this.nameLabel.getY() + labelH + ltGap,
				labelW, labelH);
		this.itemLabel.setFont(WORD_FONT);
		//收款项文本框
		this.itemContainer.setBounds(this.nameText.getX(), this.itemLabel.getY(), textW, textH * 3);
		this.itemText.setPreferredSize(new Dimension(textW - 5, idNum * 20));
		this.itemText.setFont(WORD_FONT);
		String text = "";
		for(int i = 0; i < idNum; i++) {
			text = text + "订单条形码号" + (i + 1) + ": " + receivable.getDeliveryid().get(i) + "\n";
		}
		text = text + "总金额为： " + receivable.getMoney() + "\n";
		this.itemText.setText(text);
		this.itemText.setEditable(false);
		this.itemContainer.setViewportView(this.itemText);
		//将组件添加到面板
		this.setBounds(x, y, w, h);
		this.setLayout(null);
		this.add(this.dateLabel);
		this.add(this.dateText);
		this.add(this.nameLabel);
		this.add(this.nameText);
		this.add(this.itemLabel);
		this.add(this.itemContainer);
	}
}
