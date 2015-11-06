package ui.deliveryui.orderInfo;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.deliveryui.OrderInputPanel;

@SuppressWarnings("serial")
public class GoodsInfoPanel extends JPanel{

	private JLabel numLabel = new JLabel("原件数");
	
	private JLabel weightLabel = new JLabel("实际重量");
	
	private JLabel volumeLabel = new JLabel("体积");
	
	private JLabel nameLabel = new JLabel("物品名称");
	
	private JTextField numText = new JTextField();
	
	private JTextField weightText = new JTextField();
	
	private JTextField volumnText = new JTextField();
	
	private JTextField nameText = new JTextField();
	
	public GoodsInfoPanel() {
		//主面板
		this.setLayout(null);
		//设置组件边界与大小
		this.setComponentBound();
		//设置文字样式
		this.setWordFont(OrderInputPanel.WORD_FONT);
		//设置 文本框默认值
		this.setDefaultValue();
		//将组件添加到主面板
		this.addComponent();
	}
	
	public void setWordFont(Font font) {
		//标签
		this.numLabel.setFont(font);
		this.nameLabel.setFont(font);
		this.volumeLabel.setFont(font);
		this.weightLabel.setFont(font);
		//文本框
		this.numText.setFont(font);
		this.nameText.setFont(font);
		this.volumnText.setFont(font);
		this.weightText.setFont(font);
	}
	
	private void setDefaultValue() {
		//原件数
		this.numText.setText("1");
	}
	
	private void setComponentBound() {
		int lw = OrderInputPanel.LABEL_W;			//标签的宽度
		int lh = OrderInputPanel.LABEL_H;			//标签的高度
		int tw = OrderInputPanel.TEXT_W;			//文本框的宽度
		int th = OrderInputPanel.TEXT_H;			//文本框的高度
		int gap = OrderInputPanel.COMPONENT_GAP;	//组件之间的距离
		//标签
		this.numLabel.setBounds(0, 0, lw, lh);
		this.weightLabel.setBounds(0, lh + gap, lw, lh);
		this.volumeLabel.setBounds(0, (lh + gap) << 1, lw, lh);
		this.nameLabel.setBounds(0, (lh + gap) * 3, lw, lh);
		//文本框
		this.numText.setBounds(this.numLabel.getX() + lw + gap, this.numLabel.getY() , tw, th);
		this.weightText.setBounds(this.numText.getX(), this.weightLabel.getY() , tw, th);
		this.volumnText.setBounds(this.numText.getX(), this.volumeLabel.getY() , tw, th);
		this.nameText.setBounds(this.numText.getX(), this.nameLabel.getY() , tw, th);
	}

	private void addComponent() {
		//将组件添加到面板
		this.add(this.nameLabel);
		this.add(this.numLabel);
		this.add(this.weightLabel);
		this.add(this.volumeLabel);
		this.add(this.numText);
		this.add(this.nameText);
		this.add(this.weightText);
		this.add(this.volumnText);
	}
	
	public String getNumber() {
		return this.numText.getText();
	}
	
	public String getWeight() {
		return this.weightText.getText();
	}
	
	public String getVolumn() {
		return this.volumnText.getText();
	}
	
	public String getGoodsName() {
		return this.nameText.getText();
	}
	
	/**
	 * 界面展示中组件的行数
	 */
	public int getUILineNum() {
		return 4;
	}

	public JLabel getNumLabel() {
		return numLabel;
	}

	public JLabel getWeightLabel() {
		return weightLabel;
	}

	public JLabel getVolumeLabel() {
		return volumeLabel;
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}
	
	public void disableComponents() {
		this.numText.setEditable(false);
		this.weightText.setEditable(false);
		this.volumnText.setEditable(false);
		this.nameText.setEditable(false);
	}
	
	public void enableComponents() {
		this.numText.setEditable(true);
		this.weightText.setEditable(true);
		this.volumnText.setEditable(true);
		this.nameText.setEditable(true);
	}
	
	public void setLabelBlack() {
		this.numLabel.setForeground(Color.BLACK);
		this.weightLabel.setForeground(Color.BLACK);
		this.volumeLabel.setForeground(Color.BLACK);
		this.nameLabel.setForeground(Color.BLACK);
	}
}
