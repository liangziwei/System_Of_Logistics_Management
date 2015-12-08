package ui.deliveryui.orderInfo;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constant.DeliveryType;
import constant.PackageType;
import ui.baseui.DatePanel;
import ui.deliveryui.OrderInputPanel;

@SuppressWarnings("serial")
public class OtherInfoPanel extends JPanel{

	private JLabel typeLabel = new JLabel("快递类型");
	
	private JLabel packageLabel = new JLabel("包装类型");
	
	private JLabel idLabel = new JLabel("订单条形码号");
	
	private JLabel dateLabel = new JLabel("日期");
	
	private JLabel timeLabel = new JLabel("预估时间");
	
	private JComboBox<String> typeText = new JComboBox<String>();
	
	private JComboBox<String> packageText = new JComboBox<String>();
	
	private JTextField idText = new JTextField();
	
	private JTextField timeText = new JTextField();
	
	private DatePanel dateText = new DatePanel();
	
	public OtherInfoPanel() {
		//主面板
		this.setLayout(null);
		//设置组件大小与边界
		this.setComponentBound();
		//设置字体样式
		this.setWordFont(OrderInputPanel.WORD_FONT);
		//添加文本框选项
		this.addComboItem();
		//将组件添加到面板
		this.addComponent();
	}
	
	public void clearInfo() {
		this.idText.setText("");
		this.typeText.setSelectedItem("经济快递");
		this.packageText.setSelectedItem("快递袋");
		this.timeText.setText("");
	}
	
	private void setWordFont(Font font) {
		//标签
		this.idLabel.setFont(font);
		this.typeLabel.setFont(font);
		this.packageLabel.setFont(font);
		this.dateLabel.setFont(font);
		this.timeLabel.setFont(font);
		//文本框
		this.idText.setFont(font);
		this.idText.setOpaque(false);
		this.typeText.setFont(font);
		this.typeText.setOpaque(false);
		this.packageText.setFont(font);
		this.packageText.setOpaque(false);
		this.dateText.setFont(font);
		this.dateText.setOpaque(false);
		this.timeText.setFont(font);
		this.timeText.setOpaque(false);
		//设置时间文本框不可编辑
		this.timeText.setEditable(false);
	}
	
	private void addComponent() {
		this.setBackground(null);
		this.setOpaque(false);
		this.add(this.typeLabel);
		this.add(this.typeText);
		this.add(this.packageLabel);
		this.add(this.packageText);
		this.add(this.idLabel);
		this.add(this.idText);
		this.add(this.dateLabel);
		this.add(this.dateText);
		this.add(this.timeLabel);
		this.add(this.timeText);
	}
	
	private void addComboItem() {
		//快递类型
		this.typeText.addItem("经济快递");
		this.typeText.addItem("普通快递");
		this.typeText.addItem("特快");
		//包装类型
		this.packageText.addItem("快递袋");
		this.packageText.addItem("木箱");
		this.packageText.addItem("纸箱");
		this.packageText.addItem("其他");
	}
	
	private void setComponentBound() {
		int lw = OrderInputPanel.LABEL_W;			//标签的宽度
		int lh = OrderInputPanel.LABEL_H;			//标签的高度
		int tw = OrderInputPanel.TEXT_W;			//文本框的宽度
		int th = OrderInputPanel.TEXT_H;			//文本框的高度
		int gap = OrderInputPanel.COMPONENT_GAP;	//组件之间的距离
		//标签
		this.idLabel.setBounds(0, 0, lw, lh);
		this.typeLabel.setBounds(0, this.idLabel.getY() + lh + gap,
				lw, lh);
		this.packageLabel.setBounds(0, this.typeLabel.getY() + lh + gap,
				lw, lh);
		this.dateLabel.setBounds(0, this.packageLabel.getY() + lh + gap,
				lw, lh);
		this.timeLabel.setBounds(0, this.dateLabel.getY() + lh + gap,
				lw, lh);
		//文本框
		this.idText.setBounds(this.idLabel.getX() + lw + gap,
				this.idLabel.getY(), tw, th);
		this.typeText.setBounds(this.idText.getX(), this.idText.getY() + th + gap,
				tw, th);
		this.packageText.setBounds(this.idText.getX(), this.typeText.getY() + th + gap,
				tw, th);
		this.dateText.setPanelBound(this.idText.getX(), this.packageText.getY() + th + gap,
				tw, th);
		this.timeText.setBounds(this.idText.getX(), this.timeLabel.getY(), tw, th);
	}
	
	public DeliveryType getDeliveryType() {
		String type = (String) this.typeText.getSelectedItem();
		switch(type) {
		case "经济快递":
			return DeliveryType.ECONOMIC;
		case "普通快递":
			return DeliveryType.NORMAL;
		case "特快":
			return DeliveryType.FAST;
		default:
			return DeliveryType.ECONOMIC;
		}
	}
	
	public PackageType getPackageType() {
		String type = (String) this.packageText.getSelectedItem();
		switch(type) {
		case "快递袋":
			return PackageType.COURIER_BAG;
		case "木箱":
			return PackageType.WOODEN;
		case "纸箱":
			return PackageType.CARTON;
		case "其他":
			return PackageType.OTHER;
		default:
			return PackageType.COURIER_BAG;
		}
	}
	
	public String getID() {
		return this.idText.getText();
	}
	
	public String getDate() {
		return this.dateText.getDate();
	}
	
	public String getTime() {
		return this.timeText.getText();
	}
	
	/**
	 * 界面展示中组件的行数
	 */
	public int getUILineNum() {
		return 5;
	}

	public JLabel getIdLabel() {
		return idLabel;
	}

	public JLabel getDateLabel() {
		return dateLabel;
	}
	
	public DatePanel getDatePanel() {
		return this.dateText;
	}
	
	public JLabel getTimeLabel() {
		return timeLabel;
	}

	public void setTimeText(String s) {
		this.timeText.setText(s);;
	}

	public void disableComponents() {
		this.typeText.setEnabled(false);;
		this.packageText.setEnabled(false);
		this.idText.setEditable(false);
	}
	
	public void enableComponents() {
		this.typeText.setEnabled(true);;
		this.packageText.setEnabled(true);
		this.idText.setEditable(true);
	}
	
	public void setLabelBlack() {
		this.idLabel.setForeground(Color.BLACK);
		this.typeLabel.setForeground(Color.BLACK);
		this.packageLabel.setForeground(Color.BLACK);
		this.timeLabel.setForeground(Color.BLACK);
	}
	
	/**
	 * 设置物品的其他信息
	 */
	public void setOtherInfo(String id, DeliveryType deliveryType, PackageType packageType,
		String date, String time) {
		this.idText.setText(id);
		this.typeText.setSelectedItem(deliveryType);
		this.packageText.setSelectedItem(packageType);
		this.dateText.setDate(date);
		this.timeText.setText(time);
	}
}
