package ui.deliveryui.orderInfo;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.deliveryui.OrderInputPanel;

@SuppressWarnings("serial")
public class GoodsInfoPanel extends JPanel{

	private JLabel numLabel = new JLabel("原件数（个）");
	
	private JLabel weightLabel = new JLabel("重量（KG）");
	
	private JLabel volumnLabel = new JLabel("体积（cm^3）");
	
	private JLabel nameLabel = new JLabel("物品名称");
	
	private JLabel priceLabel = new JLabel("运费（元）");
	
	private JTextField numText = new JTextField();
	
	private JTextField weightText = new JTextField();
	
	private JTextField volumnText = new JTextField();
	
	private JTextField nameText = new JTextField();
	
	private JTextField priceText = new JTextField();
	
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
		//将输入框设置为透明
		this.setOpaque();
	}
	
	public void setWordFont(Font font) {
		//标签
		this.numLabel.setFont(font);
		this.nameLabel.setFont(font);
		this.volumnLabel.setFont(font);
		this.weightLabel.setFont(font);
		this.priceLabel.setFont(font);
		//文本框
		this.numText.setFont(font);
		this.nameText.setFont(font);
		this.volumnText.setFont(font);
		this.weightText.setFont(font);
		this.priceText.setFont(font);
	}
	
	public void clearInfo() {
		this.numText.setText("1");
		this.nameText.setText("");
		this.volumnText.setText("");
		this.weightText.setText("");
		this.priceText.setText("");
	}
	
	private void setOpaque() {
		this.numText.setOpaque(false);
		this.nameText.setOpaque(false);
		this.volumnText.setOpaque(false);
		this.weightText.setOpaque(false);
		this.priceText.setOpaque(false);
	}
	
	private void setDefaultValue() {
		//原件数
		this.numText.setText("1");
		//设置价格为不可编辑
		this.priceText.setEditable(false);
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
		this.volumnLabel.setBounds(0, (lh + gap) << 1, lw, lh);
		this.nameLabel.setBounds(0, (lh + gap) * 3, lw, lh);
		this.priceLabel.setBounds(0, (lh + gap) << 2, lw, lh);
		//文本框
		this.numText.setBounds(this.numLabel.getX() + lw + gap, this.numLabel.getY() , tw, th);
		this.weightText.setBounds(this.numText.getX(), this.weightLabel.getY() , tw, th);
		this.volumnText.setBounds(this.numText.getX(), this.volumnLabel.getY() , tw, th);
		this.nameText.setBounds(this.numText.getX(), this.nameLabel.getY() , tw, th);
		this.priceText.setBounds(this.numText.getX(), this.priceLabel.getY(), tw, th);
	}

	private void addComponent() {
		//将组件添加到面板
		this.setBackground(null);
		this.setOpaque(false);
		this.add(this.nameLabel);
		this.add(this.numLabel);
		this.add(this.weightLabel);
		this.add(this.volumnLabel);
		this.add(this.priceLabel);
		this.add(this.numText);
		this.add(this.nameText);
		this.add(this.weightText);
		this.add(this.volumnText);
		this.add(this.priceText);
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
	
	public String getPrice() {
		return this.priceText.getText();
	}
	
	/**
	 * 界面展示中组件的行数
	 */
	public int getUILineNum() {
		return 5;
	}

	public JLabel getNumLabel() {
		return numLabel;
	}

	public JLabel getWeightLabel() {
		return weightLabel;
	}

	public JLabel getVolumeLabel() {
		return volumnLabel;
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}
	
	public JLabel getPriceLabel() {
		return priceLabel;
	}

	public void setPriceText(String s) {
		this.priceText.setText(s);;
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
		this.volumnLabel.setForeground(Color.BLACK);
		this.nameLabel.setForeground(Color.BLACK);
		this.priceLabel.setForeground(Color.BLACK);
	}
	
	/**
	 * 设置物品信息
	 */
	public void setGoodsInfo(String number, String weight, String volumn,
			String name, String price) {
		this.setOpaque(false);
		this.numText.setText(number);
		this.weightText.setText(weight);
		this.volumnText.setText(volumn);
		this.nameText.setText(name);
		this.priceText.setText(price);
	}
}
