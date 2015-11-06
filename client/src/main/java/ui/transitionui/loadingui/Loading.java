package ui.transitionui.loadingui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class Loading extends JFrame {

	public static JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loading frame = new Loading();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Loading() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		super.setResizable(false);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 5, 989, 26);
		panel_1.setBackground(Color.GRAY);
		contentPane.add(panel_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBackground(Color.YELLOW);
		textPane.setText("                    画扇物流系统                    ");
		panel_1.add(textPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 43, 168, 763);
		panel.setBackground(Color.CYAN);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(6, 6, 156, 82);
		textPane_1.setBackground(Color.DARK_GRAY);
		textPane_1.setText("                                  \n\n\n\n");
		panel.add(textPane_1);
		
		JButton btnNewButton = new JButton("装车信息管理");
		btnNewButton.setBounds(16, 100, 127, 29);
		panel.add(btnNewButton);
		
		JButton button = new JButton("添加装车单");
		button.setBounds(16, 133, 94, 29);
		panel.add(button);
		button.addActionListener(new addloading());
		
		JButton button_1 = new JButton("修改装车单");
		button_1.setBounds(16, 166, 94, 29);
		panel.add(button_1);
		
		JButton button_2 = new JButton("查询装车单");
		button_2.setBounds(16, 199, 94, 29);
		panel.add(button_2);
		
		JButton btnNewButton_1 = new JButton("中转货物      ");
		btnNewButton_1.setBounds(16, 232, 120, 29);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("接收货物      ");
		btnNewButton_2.setBounds(16, 265, 120, 29);
		panel.add(btnNewButton_2);
		
		JButton btnTuiChu = new JButton("退出");
		btnTuiChu.setBounds(16, 319, 75, 29);
		panel.add(btnTuiChu);
		
		
	}
	class addloading implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
//			setVisible(false);
			Addloading addpanel1 = new Addloading();
			addpanel1.setVisible(true);
		}
		
	}
}

