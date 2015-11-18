package ui.mainui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.deliveryui.DeliveryPanel;
import ui.financeui.FinancePanel;
import ui.viewcontroller.ViewController;

@SuppressWarnings("serial")
public class LoginPanel extends JPanel{
	
	private ViewController viewController;
	
	private JLabel idLabel = new JLabel("账号");
	
	private JLabel pwLabel = new JLabel("密码");
	
	private JTextField idField= new JTextField();
	
	private JTextField pwField = new JTextField();
	
	private JButton ok = new JButton("确定");
	
	private JButton cancel = new JButton("取消");
	
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
	
	private Font TEXT_FONT = new Font("宋体", Font.PLAIN, 20);
		 
	public LoginPanel(ViewController viewController) {
		this.viewController = viewController;
		//面板
		this.setLayout(null);
		this.setBounds(0, 0, ExpressFrame.FRAME_W, ExpressFrame.FRAME_H);
		//账号标签
		this.idLabel.setBounds(IDLABEL_X , IDLABEL_Y, LABEL_W, LABEL_H);
		this.idLabel.setFont(TEXT_FONT);
		//账号文本框
	    idField.setBounds(IDLABEL_X + LABEL_W + LT_GAP, IDLABEL_Y, TEXT_W, TEXT_H);
		idField.setFont(TEXT_FONT);
		//密码标签
		this.pwLabel.setBounds(IDLABEL_X, IDLABEL_Y + LABEL_H + LABEL_GAP, LABEL_W, LABEL_H);
		this.pwLabel.setFont(TEXT_FONT);
		//密码文本框
		pwField.setBounds(idField.getX(), this.pwLabel.getY(), TEXT_W, TEXT_H);
		pwField.setFont(TEXT_FONT);
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
		this.add(this.ok);
		this.add(this.cancel);
		//增加时间监听
		this.addListener();
	}
	
	private void addListener() {
		
		this.ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//验证账号密码的正确性
				//如果正确，将账号和密码文本框内容清空，跳转页面
				//如果错误，提示错误信息
				
				//TODO 测试代码
				//跳转页面
				String id = idField.getText();
				if(id == null || id.equals("")) return;
				//设置当前页面不可见
				setVisible(false);
				switch(id.charAt(0)) {
				case 'B':
					viewController.switchView(DeliveryPanel.class.getName());
					break;
				case 'C':
					break;
				case 'D':
					break;
				case 'E':
					break;
				case 'F':
					break;
				case 'G':
					viewController.switchView(FinancePanel.class.getName());
					break;
				case 'H':
					break;
				default:
					break;
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
	}
}
