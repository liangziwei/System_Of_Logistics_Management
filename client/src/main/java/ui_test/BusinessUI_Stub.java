package ui_test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BusinessUI_Stub {

	public static final JPanel BUSINESS_PANEL = new JPanel();

//	public static final JTextField ID = new JTextField();

	public static final JButton OK = new JButton("OK");

	public static final JButton CANCEL = new JButton("CANCEL");

	public BusinessUI_Stub() {
		show();
	}

	public static void show() {
		BUSINESS_PANEL.setVisible(true);
		BUSINESS_PANEL.setLayout(new BoxLayout(BUSINESS_PANEL, BoxLayout.Y_AXIS));

//		ID.setSize(200, 50);

		OK.setSize(50, 30);

//		OK.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//				char id = ID.getText().charAt(0);
//				if(id == '2') {
//					new LogisticsUI_Stub();
//				}
//			}
//		});

		CANCEL.setSize(50, 30);

		CANCEL.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				MainUI_Stub.MAIN_FRAME.setTitle("MAIN_FRAME");
				MainUI_Stub.MAIN_PANEL.setVisible(true);
				BusinessUI_Stub.BUSINESS_PANEL.setVisible(false);
			}
		});


//		BUSINESS_PANEL.add(ID);
		BUSINESS_PANEL.add(OK);
		BUSINESS_PANEL.add(CANCEL);

		MainUI_Stub.MAIN_FRAME.setTitle("BUSINESS");
		MainUI_Stub.MAIN_FRAME.add(BUSINESS_PANEL);
	}
}
