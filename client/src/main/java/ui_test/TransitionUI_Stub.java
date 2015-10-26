package ui_test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TransitionUI_Stub {
	public static final JPanel Transition_PANEL = new JPanel();
	
	public static final JButton OK = new JButton("OK");

	public static final JButton CANCEL = new JButton("CANCEL");
	
	public TransitionUI_Stub() {
		// TODO Auto-generated constructor stub
		show();
	}
	public static void show() {
		Transition_PANEL.setVisible(true);
		Transition_PANEL.setLayout(new BoxLayout(Transition_PANEL, BoxLayout.Y_AXIS));
		
		
		OK.setSize(50, 30);
		
		CANCEL.setSize(50, 30);

		CANCEL.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				MainUI_Stub.MAIN_FRAME.setTitle("MAIN_FRAME");
				MainUI_Stub.MAIN_PANEL.setVisible(true);
				TransitionUI_Stub.Transition_PANEL.setVisible(false);
			}
		});
		
		Transition_PANEL.add(CANCEL);
		Transition_PANEL.add(OK);
		MainUI_Stub.MAIN_FRAME.setTitle("TRANSITION");
		MainUI_Stub.MAIN_FRAME.add(Transition_PANEL);
		
	}
	
	
}
