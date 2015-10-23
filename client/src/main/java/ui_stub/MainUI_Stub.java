package ui_stub;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainUI_Stub {

	public static final JFrame MAIN_FRAME = new JFrame();
	
	public static final JPanel MAIN_PANEL = new JPanel();
	
	public static final JTextField ID = new JTextField();
	
	public static final JTextField PASSWORD = new JTextField();
	
	public static final JButton OK = new JButton("OK");
	
	public static final JButton CANCEL = new JButton("CANCEL");
	
	public MainUI_Stub() {
		MAIN_FRAME.setVisible(true);
		MAIN_FRAME.setTitle("MAIN_FRAME");
		MAIN_FRAME.setSize(600, 450);
		MAIN_FRAME.setLocation(200, 150);
		MAIN_FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MAIN_PANEL.setLayout(new BoxLayout(MAIN_PANEL, BoxLayout.Y_AXIS));
		MAIN_PANEL.setSize(600, 450);
		
		ID.setSize(200, 50);
		PASSWORD.setSize(200, 50);
		
		OK.setSize(50, 30);
		CANCEL.setSize(50, 30);
		
		OK.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				char id = ID.getText().charAt(0);
				MAIN_PANEL.setVisible(false);
				switch(id) {
				case '1':
					new SenderUI_Stub();
					break;
				case '2':
					new BusinessUI_Stub();
					break;
				case '3':
					new DeliveryUI_Stub();
					break;
				case '4':
					new FinanceUI_Stub();
					break;
				case '5':
					break;
				case '6':
					break;
				case '7':
					break;					
				case '8':
					break;
				default:
					new SenderUI_Stub();
				}
			}
		});
		
		MAIN_PANEL.add(ID);
		MAIN_PANEL.add(PASSWORD);
		MAIN_PANEL.add(OK);
		MAIN_PANEL.add(CANCEL);
		
		MAIN_FRAME.add(MAIN_PANEL);
	}
	
	public static void main(String[] args) {
		new MainUI_Stub();
	}
}
