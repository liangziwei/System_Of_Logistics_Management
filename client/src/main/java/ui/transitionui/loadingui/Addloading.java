package ui.transitionui.loadingui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import constant.LoadingType;

public class Addloading extends JPanel {
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JComboBox comboBox;
	/**
	 * Create the panel.
	 */
	public Addloading() {
//		setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(185, 43, 809, 535);
		Loading.contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("装运编号");
		lblNewLabel.setBounds(22, 23, 52, 16);
		panel_2.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(117, 17, 469, 28);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("到达地");
		label.setBounds(22, 99, 52, 16);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("装运方式");
		label_1.setBounds(441, 85, 71, 30);
		panel_2.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(117, 93, 237, 28);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBounds(552, 88, 89, 27);
		comboBox.setModel(new DefaultComboBoxModel(LoadingType.values()));
		panel_2.add(comboBox);
		
		JLabel label_2 = new JLabel("车辆代号");
		label_2.setBounds(22, 168, 52, 16);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("监装员");
		label_3.setBounds(22, 237, 52, 16);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("押运员");
		label_4.setBounds(419, 237, 52, 16);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("本次装箱全部订单条形码号：");
		label_5.setBounds(22, 310, 249, 16);
		panel_2.add(label_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(117, 162, 469, 28);
		textField_2.setColumns(10);
		panel_2.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(117, 231, 184, 28);
		textField_3.setColumns(10);
		panel_2.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(508, 231, 174, 28);
		textField_4.setColumns(10);
		panel_2.add(textField_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 345, 396, 77);
		panel_2.add(scrollPane);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane.setViewportView(textArea_1);
		
		JLabel label_6 = new JLabel("运费");
		label_6.setBounds(441, 371, 52, 16);
		panel_2.add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(508, 365, 174, 28);
		textField_5.setBackground(Color.LIGHT_GRAY);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		panel_2.add(textField_5);
		
		JButton button_3 = new JButton("确定");
		button_3.setBounds(430, 472, 102, 29);
		panel_2.add(button_3);
		button_3.addActionListener(new sure());
		
		JButton button_4 = new JButton("取消");
		button_4.setBounds(577, 472, 102, 29);
		panel_2.add(button_4);
	
	}
	class sure implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String nm = textField.getText().trim();
			String nm1 = textField_1.getText().trim();
			LoadingType nm2 =  (LoadingType) comboBox.getSelectedItem();
			String nm3 = textField_2.getText().trim();
			String nm4 = textField_3.getText().trim();
			String nm5 = textField_4.getText().trim();
			LoadingPanel loadingPanel =new LoadingPanel(nm, nm1, nm2, nm3, nm4, nm5, "500");
			loadingPanel.setVisible(true);
		}
		
	}
}
