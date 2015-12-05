package ui.baseui;


import javax.swing.JPanel;

import ui.mainui.ExpressFrame;
import ui.viewcontroller.ViewController;

@SuppressWarnings("serial")
public class UserPanel extends JPanel{
	
	protected ViewController viewController;
	
	protected TitlePanel title = new TitlePanel();

	protected TaskPanel task = new TaskPanel();
	
	protected DetailPanel detail = new DetailPanel();
	
	public UserPanel(ViewController viewController) {
		this.viewController = viewController;
		//主面板
		this.setBounds(0, 0, ExpressFrame.FRAME_W, ExpressFrame.FRAME_H);
		this.setLayout(null);
		//将其他面板添加到主面板
		this.add(this.title);
		this.add(this.task);
		this.add(this.detail);
	}
	

}
