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
	
	private static Image BACKGOUND = new ImageIcon("picture/network/connect.jpg").getImage();

	public ConnectPanel() {
		this.setBounds(0, 0, 300, 200);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(BACKGOUND, 0, 0, this.getWidth(), this.getHeight(), null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("宋体", Font.PLAIN, 15));
		g.drawString("网络连接失败", 40, 50);
		g.drawString("请检查网络连接", 40, 90);
		g.drawString("正在尝试第" + this.connectNum + "次连接...", 40, 130);
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
