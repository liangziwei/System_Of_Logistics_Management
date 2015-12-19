package ui.deliveryui.orderInfo;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constant.City;
import constant.ClientType;
import ui.deliveryui.OrderInputPanel;

@SuppressWarnings("serial")
public class ClientInfoPanel extends JPanel{
	
	private JLabel identity;
	
	private JLabel nameLabel = new JLabel("姓名");
	
	private JLabel addressLabel = new JLabel("住址");
	
	private JLabel companyLabel = new JLabel("单位");
	
	private JLabel phoneLabel = new JLabel("电话");
	
	private JLabel mobileLabel = new JLabel("手机");
	
	private JTextField nameText = new JTextField();
	
	private JTextField addressText = new JTextField();
	
	private JTextField companyText = new JTextField();
	
	private JTextField phoneText = new JTextField();
	
	private JTextField mobileText = new JTextField();
	
	private JComboBox<String> cityText = new JComboBox<String>();
	
	public ClientInfoPanel(ClientType clientType) {
		//主面板
		this.setLayout(null);
		//客户身份
		if(clientType == ClientType.SENDER) {
			identity = new JLabel("寄件人信息");
		}else {
			identity = new JLabel("收件人信息");
		}
		//设置组件大小与边界
		this.setComponentBound();
		//设置字体样式
		this.setWordFont(OrderInputPanel.WORD_FONT);
		//设置文本框默认值
		this.setDefaultValue();
		//将组件添加到面板
		this.addComponent();
		//设置输入框为透明
		this.setOpaque();
	}
	
	public void clearInfo() {
		this.nameText.setText("");
		this.addressText.setText("");
		this.companyText.setText("可不填");
		this.phoneText.setText("可不填");
		this.mobileText.setText("");
	}
	
	private void setOpaque() {
		this.nameText.setOpaque(false);
		this.addressText.setOpaque(false);
		this.companyText.setOpaque(false);
		this.phoneText.setOpaque(false);
		this.mobileText.setOpaque(false);
	}
	
	
	private void setWordFont(Font font) {
		//标签
		this.identity.setFont(font);
		this.nameLabel.setFont(font);
		this.addressLabel.setFont(font);
		this.companyLabel.setFont(font);
		this.phoneLabel.setFont(font);
		this.mobileLabel.setFont(font);
		//文本框
		this.nameText.setFont(font);
		this.addressText.setFont(font);
		this.companyText.setFont(font);
		this.phoneText.setFont(font);
		this.mobileText.setFont(font);
	}
	
	private void setDefaultValue() {
		//地址
		this.cityText.addItem("南京");
		this.cityText.addItem("北京");
		this.cityText.addItem("上海");
		this.cityText.addItem("广州");
		//单位
		this.companyText.setForeground(Color.GRAY);
		this.companyText.setText("可不填");
		//电话
		this.phoneText.setForeground(Color.GRAY);
		this.phoneText.setText("可不填");
	}
	
	private void setComponentBound() {
		int lw = OrderInputPanel.LABEL_W;			//标签的宽度
		int lh = OrderInputPanel.LABEL_H;			//标签的高度
		int tw = OrderInputPanel.TEXT_W;			//文本框的宽度
		int th = OrderInputPanel.TEXT_H;			//文本框的高度
		int gap = OrderInputPanel.COMPONENT_GAP;	//组件之间的距离
		//标签
		this.identity.setBounds(0, 0, lw, lh);
		this.nameLabel.setBounds(0, lh + gap, lw, lh);
		this.addressLabel.setBounds(0, (lh + gap) << 1, lw, lh);
		this.companyLabel.setBounds(0, (lh + gap) * 3, lw, lh);
		this.phoneLabel.setBounds(0, (lh + gap) << 2, lw, lh);
		this.mobileLabel.setBounds(0, (lh + gap) * 5, lw, lh);
		//文本框
		int textX = this.nameLabel.getX() + lw + gap;
		this.nameText.setBounds(textX, this.nameLabel.getY(), tw, th);
		
		int cityW = tw / 3;
		int addrW = tw - cityW;
		this.cityText.setBounds(textX, this.addressLabel.getY(), cityW, th);
		this.addressText.setBounds(textX + cityW, this.addressLabel.getY(), addrW, th);
		
		this.companyText.setBounds(textX, this.companyLabel.getY(), tw, th);
		this.phoneText.setBounds(textX, this.phoneLabel.getY(), tw, th);
		this.mobileText.setBounds(textX, this.mobileLabel.getY(), tw, th);
	}
	
	private void addComponent() {
		//将组件添加到面板
		this.setBackground(null);
		this.setOpaque(false);
		this.add(this.identity);
		this.add(this.nameLabel);
		this.add(this.nameText);
		this.add(this.addressLabel);
		this.add(this.cityText);
		this.add(this.addressText);
		this.add(this.companyLabel);
		this.add(this.companyText);
		this.add(this.phoneLabel);
		this.add(this.phoneText);
		this.add(this.mobileLabel);
		this.add(this.mobileText);
	}
	
	public String getClientName() {
		return this.nameText.getText();
	}
	
	public String getAddress() {
		return this.addressText.getText();
	}
	
	public String getCompany() {
		return this.companyText.getText();
	}
	
	public String getPhoneNumber() {
		return this.phoneText.getText();
	}
	
	public String getMobilbeNumber() {
		return this.mobileText.getText();
	}
	
	public City getCity() {
		String city = (String)this.cityText.getSelectedItem();
		switch(city) {
		case "南京":
			return City.NAN_JING;
		case "北京":
			return City.BEI_JING;
		case "上海":
			return City.SHANG_HAI;
		case "广州":
			return City.GUANG_ZHOU;
		default:
			return City.NAN_JING;
		}
	}
	
	/**
	 * 界面展示中组件的行数
	 */
	public int getUILineNum() {
		return 6;
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}

	public JLabel getAddressLabel() {
		return addressLabel;
	}

	public JLabel getCompanyLabel() {
		return companyLabel;
	}

	public JLabel getPhoneLabel() {
		return phoneLabel;
	}

	public JLabel getMobileLabel() {
		return mobileLabel;
	}
	
	public void disableComponents() {
		this.nameText.setEditable(false);
		this.addressText.setEditable(false);
		this.companyText.setEditable(false);
		this.phoneText.setEditable(false);
		this.mobileText.setEditable(false);
		this.cityText.setEnabled(false);
	}
	
	public void enableComponents() {
		this.nameText.setEditable(true);
		this.addressText.setEditable(true);
		this.companyText.setEditable(true);
		this.phoneText.setEditable(true);
		this.mobileText.setEditable(true);
		this.cityText.setEnabled(true);
	}
	
	public void setLabelBlack() {
		this.nameLabel.setForeground(Color.BLACK);;
		this.addressLabel.setForeground(Color.BLACK);
		this.companyLabel.setForeground(Color.BLACK);
		this.companyLabel.setForeground(Color.BLACK);
		this.mobileLabel.setForeground(Color.BLACK);
	}
	
	/**
	 * 设置客户信息
	 */
	public void setClientInfo(String name, String address, String company,
			String phone, String mobile, City city) {
		this.setOpaque(false);
		this.nameText.setText(name);
		this.addressText.setText(address);
		this.companyText.setText(company);
		this.phoneText.setText(phone);
		this.mobileText.setText(mobile);
		switch(city) {
		case NAN_JING:
			this.cityText.setSelectedItem("南京");
			break;
		case BEI_JING:
			this.cityText.setSelectedItem("北京");
			break;
		case SHANG_HAI:
			this.cityText.setSelectedItem("上海");
			break;
		case GUANG_ZHOU:
			this.cityText.setSelectedItem("广州");
			break;
		default:
			this.cityText.setSelectedItem("南京");
			break;
		}
	}
}
