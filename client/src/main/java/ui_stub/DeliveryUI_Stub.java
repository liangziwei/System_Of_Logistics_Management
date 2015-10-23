package ui_stub;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class DeliveryUI_Stub {

	public static final JPanel DELIVERY_PANEL = new JPanel();

//	public static final JTextField ID = new JTextField();

	public static final JButton OK = new JButton("OK");

	public static final JButton CANCEL = new JButton("CANCEL");

	public DeliveryUI_Stub() {
		show();
	}

	public static void show() {
		DELIVERY_PANEL.setVisible(true);
		DELIVERY_PANEL.setLayout(new BoxLayout(DELIVERY_PANEL, BoxLayout.Y_AXIS));

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
				DeliveryUI_Stub.DELIVERY_PANEL.setVisible(false);
			}
		});


//		BUSINESS_PANEL.add(ID);
		DELIVERY_PANEL.add(OK);
		DELIVERY_PANEL.add(CANCEL);

		MainUI_Stub.MAIN_FRAME.setTitle("DELIVERY");
		MainUI_Stub.MAIN_FRAME.add(DELIVERY_PANEL);
	}
}
