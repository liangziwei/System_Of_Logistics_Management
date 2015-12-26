package ui.baseui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.mainui.ExpressFrame;

@SuppressWarnings("serial")
public class TitlePanel extends JPanel{

	/**
	 * 标题面板宽度
	 */
	protected static final int TITLE_PANEL_W = ExpressFrame.FRAME_W;
	
	/**
	 * 标题面板高度
	 */
	protected static final int TITLE_PANEL_H = 100;
	
	public TitlePanel() {
		setClose();
		this.repaint();
		this.setBounds(0, 0, TITLE_PANEL_W, TITLE_PANEL_H);
		this.setLayout(null);
	}

	
	public void setClose() {

		//最小化按钮
		JButton minButton=new JButton("");
		minButton.setBounds(ExpressFrame.FRAME_W-85, 0, 40, 30);
		minButton.setIcon(new ImageIcon("picture/FrameButton/minMain.png"));
		minButton.addActionListener(new ActionListener(){
			@Override
			  public void actionPerformed(ActionEvent e) {
				ExpressFrame.getInstance().setExtendedState(JFrame.ICONIFIED);
			  }
		});
		
		
		 //关闭按钮
		 JButton closeButton = new JButton("");
		 closeButton.setIcon(new ImageIcon("picture/FrameButton/closeMain.png"));
		 closeButton.setBounds(ExpressFrame.FRAME_W-45, 0, 40, 30);
		 closeButton.addActionListener(new ActionListener() {
		  @Override
		  public void actionPerformed(ActionEvent e) {
		  System.exit(0);
		  }
		 });
		 this.add(closeButton);
		 this.add(minButton);  

		 }
}
