package UI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import network.RMI;

public class ServerFrame extends JFrame {
	/**
	 * 服务器界面宽度
	 */
	public static final int FRAME_W = 300;

	/**
	 * 服务器界面高度
	 */
	public static final int FRAME_H = 500;
	
	//组件
	private JPanel mainpanel = new JPanel();
	private JLabel note = new JLabel("",JLabel.CENTER);
	public JButton connect = new JButton("连接");
	
	private Font TEXT_FONT = new Font("宋体", Font.PLAIN, 20);
	
	public ServerFrame() {
		// 主界面设置
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(FRAME_W, FRAME_H);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setFrameAtCenter(this);
		//背景图片的路径。（相对路径或者绝对路径。本例图片放于"java项目名"的文件下）  
        String path = "Picture/background.jpg";  
        // 背景图片  
        ImageIcon background = new ImageIcon(path);  
        // 把背景图片显示在一个标签里面  
        JLabel label = new JLabel(background);  
        // 把标签的大小位置设置为图片刚好填充整个面板  
        label.setBounds(0, 0, this.getWidth(), this.getHeight());  
        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明  
        JPanel imagePanel = (JPanel) this.getContentPane();  
        imagePanel.setOpaque(false);  
        // 把背景图片添加到分层窗格的最底层作为背景  
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
        //设置可见  
        setVisible(true); 
		init();
		addActionListener();
		this.repaint();
		
	}
	private void setFrameAtCenter(JFrame frame) {
		Toolkit kit=Toolkit.getDefaultToolkit();
	    Dimension screenSize=kit.getScreenSize();
	    int screenWidth=(int) screenSize.getWidth();
	    int screenHeight=(int) screenSize.getHeight();
	    frame.setLocation(screenWidth-frame.getWidth()>>1,
	    		(screenHeight-frame.getHeight()>>1)-32);
	}
	
	private void addActionListener(){
		connect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					try {
						RMI.initRMI();
						setnote("连接成功");
						connect.setEnabled(false);
					}catch (AlreadyBoundException | RemoteException e3) {
						// TODO: handle exception
						e3.printStackTrace();
						setnote("连接出错，请稍后重新连接");
					}
			}
		});
	}
	
	private void init(){
		mainpanel.setBounds(50, 50, 200, 400);
		mainpanel.setLayout(null);
		mainpanel.setOpaque(false);
		this.add(mainpanel);
		note.setBounds(30, 50, 150, 150);
		note.setFont(TEXT_FONT);
		mainpanel.add(note);
		connect.setBounds(50,note.getY()+note.getHeight()+50,110,50);
		connect.setFont(TEXT_FONT);
		mainpanel.add(connect);
	}
	
	public void setnote(String msg) {
		this.note.setText("<html>"+msg+"<html>");
		this.repaint();
	}
}
