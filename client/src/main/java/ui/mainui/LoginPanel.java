package ui.mainui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ui.administratorui.AdministratorPanel;
import ui.baseui.LimpidButton;
import ui.businessui.BusinessPanel;
import ui.deliveryui.DeliveryPanel;
import ui.financeui.FinancePanel;
import ui.managerui.ManagerPanel;
import ui.repositoryui.RepositoryPanel;
import ui.transitionui.TransitionPanel;
import ui.viewcontroller.ViewController;
import businessLogic.businessLogicController.administratorController.LoginBL;

@SuppressWarnings("serial")
public class LoginPanel extends JPanel{
	
	private static boolean DEBUG = true;
	
	private ViewController viewController;
	private LoginBL login;
	
	private JLabel idLabel = new JLabel("账号");
	
	private JLabel pwLabel = new JLabel("密码");
	
	private JLabel hint=new JLabel();//错误提示
	
	private JTextField idField= new JTextField();
	
	private JPasswordField pwField = new JPasswordField();
	
	private LimpidButton ok = new LimpidButton("","picture/确定.png");
	
	private LimpidButton cancel = new LimpidButton("","picture/取消.png");
	
	private Font TEXT_FONT = new Font("宋体", Font.PLAIN, 20);
	
	private static Map<Character, String> USER_TABLE = new HashMap<Character, String>();
	
	static {
		USER_TABLE.put('B', DeliveryPanel.class.getName());
		USER_TABLE.put('C', BusinessPanel.class.getName());
		USER_TABLE.put('D', ManagerPanel.class.getName());
		USER_TABLE.put('E', TransitionPanel.class.getName());
		USER_TABLE.put('F', RepositoryPanel.class.getName());
		USER_TABLE.put('G', FinancePanel.class.getName());
		USER_TABLE.put('H', AdministratorPanel.class.getName());
	}
	
	private static final int LABEL_W = 100;
	
	private static final int LABEL_H = 40;
	
	private static final int TEXT_W = LABEL_W * 3;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int BUTTON_W = 80;
	
	private static final int BUTTON_H = 30;
	
	/**
	 * 标签与标签的距离
	 */
	private static final int LABEL_GAP = 40;
	
	/**
	 * 标签与文本框的距离
	 */
	private static final int LT_GAP = LABEL_GAP;
	
	/**
	 * 文本框与按钮的距离
	 */
	private static final int TB_GAP = LT_GAP * 3;
	
	/**
	 *按钮与按钮的距离 
	 */
	private static final int BUTTON_GAP = LABEL_GAP;
	
	private static final int IDLABEL_X = (ExpressFrame.FRAME_W - LABEL_W - TEXT_W - LT_GAP) >> 1;
	
	private static final int IDLABEL_Y = (ExpressFrame.FRAME_H - (LABEL_H << 1) - LABEL_GAP - TB_GAP - BUTTON_H) >> 1;
	
	//背景图片
	private static Image BACKGROUND = new ImageIcon("picture/login.png").getImage();
	
	
	public LoginPanel(ViewController viewController) {
		this.viewController = viewController;
		this.login=new LoginBL();
		
		this.repaint();
		//面板
		this.setLayout(null);
		this.setBounds(0, 0, ExpressFrame.FRAME_W, ExpressFrame.FRAME_H);
		//账号标签
		this.idLabel.setBounds(IDLABEL_X , IDLABEL_Y, LABEL_W, LABEL_H);
		this.idLabel.setFont(TEXT_FONT);
		//账号文本框
	    idField.setBounds(IDLABEL_X + LABEL_W + LT_GAP, IDLABEL_Y, TEXT_W, TEXT_H);
		idField.setFont(TEXT_FONT);
		idField.setOpaque(false);
		//密码标签
		this.pwLabel.setBounds(IDLABEL_X, IDLABEL_Y + LABEL_H + LABEL_GAP, LABEL_W, LABEL_H);
		this.pwLabel.setFont(TEXT_FONT);
		//密码文本框
		pwField.setBounds(idField.getX(), this.pwLabel.getY(), TEXT_W, TEXT_H);
		pwField.setFont(TEXT_FONT);
		pwField.setOpaque(false);
		
		//错误提示
		this.hint.setBounds(idLabel.getX()+20, pwField.getY() + TB_GAP, 180, BUTTON_H);
		this.hint.setFont(TEXT_FONT);
		//确定按钮
		this.ok.setBounds(pwField.getX() + (TEXT_W >> 1), pwField.getY() + TB_GAP, BUTTON_W, BUTTON_H);
		this.ok.setFont(TEXT_FONT);
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + BUTTON_W + BUTTON_GAP, this.ok.getY(), BUTTON_W, BUTTON_H);
		this.cancel.setFont(TEXT_FONT);
		//把组件添加到面板
		this.add(this.idLabel);
		this.add(idField);
		this.add(this.pwLabel);
		this.add(pwField);
		this.add(hint);
		this.add(this.ok);
		this.add(this.cancel);
		//增加时间监听
		this.addListener();
	}
	
	private void addListener() {
		
		this.ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(DEBUG) {
					String id = idField.getText();
					id=id.toUpperCase();
					//设置当前页面不可见
					setVisible(false);
					viewController.switchView(USER_TABLE.get(id.charAt(0)));
					return ;
				}
				
				//跳转页面
				String id = idField.getText();
				id=id.toUpperCase();
				setVisible(false);
				viewController.switchView(USER_TABLE.get(id.charAt(0)));
//				if(id == null ||(!id.matches("[B-H][0-9]{9}")&&!id.equalsIgnoreCase("admin"))) {
//					hint.setForeground(Color.RED);
//					hint.setText("账号輸入格式错误");
//				}else{
//				    
//					String password=pwField.getText();
//					if(login.login(id, password)){
//						//设置当前页面不可见
//						setVisible(false);
//						//跳转到相应用户的界面
//						hint.setText("");
//						if(id.equalsIgnoreCase("admin")){
//							id="H"+id;
//						}
//						viewController.switchView(USER_TABLE.get(id.charAt(0)));
//					}else{
//						hint.setForeground(Color.RED);
//						hint.setText("账号或密码输入错误");
//					}
//				}
//				LoginBL login = new LoginBL();
//				//设置当前页面不可见
//				setVisible(false);
//				viewController.switchView(USER_TABLE.get(id.charAt(0)));
//				if(id == null ||!id.matches("[B-H][0-9]{9}")) {
//					hint.setForeground(Color.RED);
//					hint.setText("账号輸入格式错误");
//				}else{
//				    
//					String password=pwField.getText();
//					if(login.login(id, password)){
//						//设置当前页面不可见
//						setVisible(false);
//						//跳转到相应用户的界面
//						hint.setText("");
//						viewController.switchView(USER_TABLE.get(id.charAt(0)));
//					}else{
//						hint.setForeground(Color.RED);
//						hint.setText("账号或密码输入错误");
//					}
//				}
				
				if(id == null ||(!id.matches("[B-H][0-9]{9}")&&!id.equalsIgnoreCase("admin"))) {
					hint.setForeground(Color.RED);
					hint.setText("账号輸入格式错误");
				}else{
				    
					String password=pwField.getText();
					if(login.login(id, password)){
						//设置当前页面不可见
						setVisible(false);
						//跳转到相应用户的界面
						hint.setText("");
						if(id.equalsIgnoreCase("admin")){
							id="H"+id;
						}
						viewController.switchView(USER_TABLE.get(id.charAt(0)));
					}else{
						hint.setForeground(Color.RED);
						hint.setText("账号或密码输入错误");
					}
				}
			}
		});
		
		this.cancel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//设置当前页面不可见
				setVisible(false);
				//回到开始界面
				viewController.switchView(ExpressPanel.class.getName());
			}
		});
		
		idField.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					ok.doClick();
				}
			}
		});
		
		pwField.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					ok.doClick();
				}
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(BACKGROUND, 0, 0, this.getWidth(), this.getHeight(), null);
	}
}
