package ui.financeui.accountui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import businessLogic.businessLogicController.financeController.AccountController;
import businessLogicService.financeBLService.AccountBLService;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;
import vo.financeVO.AccountVO;

@SuppressWarnings("serial")
public class InquireAccountPanel extends DetailPanel{
	
	private AccountBLService account = new AccountController();

	private JLabel nameLabel = new JLabel("账户名称");
	
	private JTextField nameText = new JTextField();
	
	private JSeparator line = new JSeparator();
	
	private LimpidButton ok = new LimpidButton("","picture/查询.png");
	
	private LimpidButton cancel = new LimpidButton("","picture/取消.png");
	
	private JLabel tip = new JLabel();
	
	private AccountInfoPanel panel;
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 20);
	
	private static final int LABEL_W = 100;
	
	private static final int LABEL_H = 30;
	
	private static final int TEXT_W = LABEL_W << 1;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int BUTTON_W = 80;
	
	private static final int BUTTON_H = LABEL_H;
	
	private static final int START_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W - (BUTTON_W << 1)) / 3;
	
	private static final int START_Y = START_X >> 2;
	
	public InquireAccountPanel() {
		//初始化界面
		this.initUI();
		//增加事件监听
		this.addListener();
	}
	
	private void initUI() {
		//账户名称标签
		this.nameLabel.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.nameLabel.setFont(WORD_FONT);
		//账户名称文本框
		this.nameText.setBounds(LABEL_W + (START_X * 3 >> 1), this.nameLabel.getY(), TEXT_W, TEXT_H);
		this.nameText.setFont(WORD_FONT);
		this.nameText.setOpaque(false);
		//确定按钮
		this.ok.setBounds(this.nameText.getX() + TEXT_W + (START_X >> 1), this.nameText.getY(),
				BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + (BUTTON_W * 3 >> 1), this.ok.getY(),
				BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		//提示标签
		this.tip.setBounds(START_X >> 2, this.nameLabel.getY() + LABEL_H,
				TEXT_W, TEXT_H);
		this.tip.setFont(WORD_FONT);
		//分割线
		this.line.setBounds(0, this.tip.getY() + TEXT_H, DETAIL_PANEL_W, 5);
		//将按钮添加到面板
		this.setLayout(null);
		this.add(this.line);
		this.add(this.nameLabel);
		this.add(this.nameText);
		this.add(this.ok);
		this.add(this.cancel);
		this.add(this.tip);
	}
	
	private void addListener() {
		//确定按钮
		this.ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//查找账户信息
				AccountVO vo = account.findAccount(nameText.getText());
				//如果没有找到账户信息
				if(vo == null) {
					tip.setForeground(Color.RED);
					tip.setText("该账户不存在");
				}
				else {
					tip.setText("");
					if(panel != null) panel.setVisible(false);
					panel = new AccountInfoPanel(0, tip.getY() + TEXT_H,
							DETAIL_PANEL_W, DETAIL_PANEL_H - LABEL_H * 3, vo);
					add(panel);
				}
				repaint();
			}
		});
		//取消按钮
		this.cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//消除用户输入
				nameText.setText("");
				tip.setText("");
			}
		});
	}
}
