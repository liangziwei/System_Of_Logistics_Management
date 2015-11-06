package ui.transitionui.loadingui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import constant.LoadingType;

public class LoadingPanel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;


	/**
	 * Create the frame.
	 */
	public LoadingPanel(String textfield,String textfield1,LoadingType textfield2,String textfield3,
			String textfield4,String textfield5,String textfield6) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("装运编号");
		label.setBounds(16, 17, 77, 27);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setText(textfield);
		textField.setBounds(85, 17, 277, 28);
		textField.setEditable(false);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("到达地");
		label_1.setBounds(16, 54, 77, 27);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setText(textfield1);
		textField_1.setBounds(85, 56, 277, 28);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		
		contentPane.add(textField_1);
		
		JLabel label_2 = new JLabel("装运方式");
		label_2.setBounds(16, 93, 77, 27);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		if(textfield2.equals(LoadingType.PLANE)){
			textField_2.setText("飞机");			
		}
		else if (textfield2.equals(LoadingType.TRAIN)) {
			textField_2.setText("火车");	
		}
		else {
			textField_2.setText("卡车");	
		}
		textField_2.setBounds(85, 93, 277, 28);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		JLabel label_3 = new JLabel("车辆代号");
		label_3.setBounds(16, 132, 77, 27);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("监装员");
		label_4.setBounds(16, 171, 77, 27);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("押运员");
		label_5.setBounds(16, 210, 77, 27);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("本次装箱全部订单条形码号");
		label_6.setBounds(16, 240, 174, 27);
		contentPane.add(label_6);
		
		textField_3 = new JTextField();
		textField_3.setText(textfield3);
		textField_3.setBounds(85, 132, 277, 28);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText(textfield4);
		textField_4.setBounds(85, 171, 277, 28);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText(textfield5);
		textField_5.setBounds(85, 210, 277, 28);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		contentPane.add(textField_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 263, 378, 104);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JLabel label_7 = new JLabel("运费");
		label_7.setBounds(16, 379, 77, 27);
		contentPane.add(label_7);
		
		textField_6 = new JTextField();
		textField_6.setText(textfield6);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(85, 379, 277, 28);
		contentPane.add(textField_6);
		
		JButton button = new JButton("确定");
		button.setBounds(222, 424, 90, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.setBounds(321, 424, 90, 29);
		contentPane.add(button_1);
		button_1.addActionListener(new cancle());
	}
	class cancle implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setVisible(false);
//			loading loading =new loading();
//			loading.setVisible(true);
		}
		
	}
	
	
}

