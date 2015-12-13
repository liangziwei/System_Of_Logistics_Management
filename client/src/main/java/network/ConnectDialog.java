package network;

import javax.swing.JDialog;

/**
 *网络异常后进行重连的提示窗口
 */
@SuppressWarnings("serial")
public class ConnectDialog extends JDialog{
	
	public ConnectDialog(ConnectPanel panel) {
		this.setSize(300, 200);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		this.setTitle("网络正在重连");
		this.setLocationRelativeTo(null);
		
		this.add(panel);
	}
	
}
