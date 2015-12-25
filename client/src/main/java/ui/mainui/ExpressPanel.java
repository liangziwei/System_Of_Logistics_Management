package ui.mainui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.baseui.LimpidButton;
import ui.senderui.InquirePanel;
import ui.viewcontroller.ViewController;

@SuppressWarnings("serial")
public class ExpressPanel extends JPanel{
	
	private ViewController controller;
	
	private LimpidButton login = new LimpidButton("","picture/用户登录.png");

	private LimpidButton logistics = new LimpidButton("","picture/物流信息查询.png");

	public static final int BUTTON_W = 300;

	public static final int BUTTON_H = 60;

	public static final int BUTTON_GAP = 80;

	public static final int LOGIN_X = (ExpressFrame.FRAME_W - BUTTON_W) >> 1;

	public static final int LOGIN_Y = (ExpressFrame.FRAME_H - (BUTTON_H << 1) - BUTTON_GAP) >> 1;

	public static final int LOGISTICS_X = LOGIN_X;

	public static final int LOGISTICS_Y = LOGIN_Y + BUTTON_H + BUTTON_GAP;
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 20);
	
	private static Image BACKGROUND = new ImageIcon("picture/background.jpg").getImage();
	
	public ExpressPanel(ViewController controller) {
		this.controller = controller;
		this.repaint();
		//初始化组件
		this.initUI();
	}
	
	private void initUI() {
		//主面板
		this.setBounds(0, 0, ExpressFrame.FRAME_W, ExpressFrame.FRAME_H);
		this.setLayout(null);
		//登录按钮
		this.login.setSize(BUTTON_W, BUTTON_H);
		this.login.setLocation(LOGIN_X, LOGIN_Y);
		this.login.setFont(WORD_FONT);
		//物流信息查询按钮
		this.logistics.setSize(BUTTON_W, BUTTON_H);
		this.logistics.setLocation(LOGISTICS_X, LOGISTICS_Y);
		this.logistics.setFont(WORD_FONT);
		//增加时间监听
		this.addListener(this.login, this.logistics);
		//增加组件到容器
		this.add(this.login);
		this.add(this.logistics);
		this.requestFocus();
		setClose();
		this.repaint();
	}
	
	private void addListener(JButton login, JButton logistics) {

		login.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//设当前页面不可见
				setVisible(false);
				//跳转到登录界面
				controller.switchView(LoginPanel.class.getName());
			}
		});

		logistics.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//设当前页面不可见
				setVisible(false);
				//跳转到查询物流信息界面
				controller.switchView(InquirePanel.class.getName());
			}
		});
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(BACKGROUND, 0, 0, this.getWidth(), this.getHeight(), null);
	}
	
	public void setClose() {

		//最小化按钮
		JButton minButton=new JButton("-");
		minButton.setBounds(ExpressFrame.FRAME_W-70, 0, 30, 30);
		minButton.addActionListener(new ActionListener(){
		@Override
		    public void actionPerformed(ActionEvent e) {
				ExpressFrame.getInstance().setExtendedState(JFrame.ICONIFIED);
		   }
		});	
		
		 //关闭按钮
		 JButton closeButton = new JButton("X");
//		 closeButton.setIcon(new ImageIcon("img/closeButton.png"));
		 closeButton.setBounds(ExpressFrame.FRAME_W-30, 0, 30, 30);
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
