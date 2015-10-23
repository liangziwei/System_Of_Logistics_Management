package ui_test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SenderUI_Stub {
	
	public static final JPanel SENDER_PANEL = new JPanel();
	
	public static final JTextField ID = new JTextField();
	
	public static final JButton OK = new JButton("OK");

	public static final JButton CANCEL = new JButton("CANCEL");

	public SenderUI_Stub() {
		show();
	}
	
	public static void show() {
		SENDER_PANEL.setVisible(true);
		SENDER_PANEL.setLayout(new BoxLayout(SENDER_PANEL, BoxLayout.Y_AXIS));
		
		ID.setSize(200, 50);
		
		OK.setSize(50, 30);
		
		OK.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				char id = ID.getText().charAt(0);
				if(id == '1') {
					new LogisticsUI_Stub();
				}
			}
		});
		
		CANCEL.setSize(50, 30);
		
		CANCEL.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				MainUI_Stub.MAIN_FRAME.setTitle("MAIN_FRAME");
				MainUI_Stub.MAIN_PANEL.setVisible(true);
				SenderUI_Stub.SENDER_PANEL.setVisible(false);
			}
		});
		
		
		SENDER_PANEL.add(ID);
		SENDER_PANEL.add(OK);
		SENDER_PANEL.add(CANCEL);
		
		MainUI_Stub.MAIN_FRAME.setTitle("SENDER");
		MainUI_Stub.MAIN_FRAME.add(SENDER_PANEL);
	
	
}
}
