package network;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *网络异常后进行重连的面板 
 */
@SuppressWarnings("serial")
public class ConnectPanel extends JPanel{
	
	/**
	 * 当前已重连的次数
	 */
	int connectNum = 0;
	
	private static Image BACKGOUND = new ImageIcon("picture/network/connect.png").getImage();

	public ConnectPanel() {
		this.setBounds(0, 0, 400, 250);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(BACKGOUND, 0, 0, this.getWidth(), this.getHeight(), null);
		g.setColor(Color.RED);
		g.setFont(new Font("宋体", Font.PLAIN, 28));
		g.drawString(this.connectNum + "", 190, 145);
	}
	
	/**
	 *设置当前重连的次数 
	 */
	public void setNumber(int i) {
		this.connectNum = i;
	}
	
	/**
	 *获得当前重连的次数 
	 */
	public int getNumber() {
		return this.connectNum;
	}
}
