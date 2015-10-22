package ui_stub;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class LogisticsUI_Stub {

	public static final JPanel LOGISTICS_PANEL = new JPanel();
	
	public static final JButton OK = new JButton("OK");

	public static final JButton CANCEL = new JButton("CANCEL");
	
	public LogisticsUI_Stub() {
		show();
	}
	
	public static void show() {
		SenderUI_Stub.SENDER_PANEL.setVisible(false);
		
		LOGISTICS_PANEL.setVisible(true);
		LOGISTICS_PANEL.setLayout(new BoxLayout(LOGISTICS_PANEL, BoxLayout.Y_AXIS));
		
		OK.setSize(50, 30);
		CANCEL.setSize(50, 30);
		
		LOGISTICS_PANEL.add(OK);
		LOGISTICS_PANEL.add(CANCEL);
		
		OK.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				MainUI_Stub.MAIN_FRAME.setTitle("SENDER");
				LOGISTICS_PANEL.setVisible(false);
				SenderUI_Stub.SENDER_PANEL.setVisible(true);
			}
		});
		
		CANCEL.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MainUI_Stub.MAIN_FRAME.setTitle("SENDER");
				LOGISTICS_PANEL.setVisible(false);
				SenderUI_Stub.SENDER_PANEL.setVisible(true);
			}
		});
		
		MainUI_Stub.MAIN_FRAME.setTitle("LOGISTICS");
		MainUI_Stub.MAIN_FRAME.add(LOGISTICS_PANEL);
	}
}
