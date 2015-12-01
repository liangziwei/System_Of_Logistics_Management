package ui.financeui.accountui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businessLogic.businessLogicController.financeController.AccountController;
import businessLogic.businessLogicModel.util.CommonLogic;
import businessLogicService.financeBLService.AccountBLService;
import ui.baseui.DetailPanel;
import vo.financeVO.AccountVO;

@SuppressWarnings("serial")
public class AddAccountPanel extends DetailPanel{
	
	private AccountBLService account = new AccountController();

	private JLabel nameLabel = new JLabel("账户名称");
	
	private JTextField nameText = new JTextField();
	
	private JLabel moneyLabel = new JLabel("账户金额");
	
	private JTextField moneyText = new JTextField();
	
	private JButton ok = new JButton("");
	
	private JButton cancel = new JButton("取消");
	
	private JLabel tip = new JLabel();
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 20);
	
	private static final int LABEL_W = 100;
	
	private static final int LABEL_H = 40;
	
	private static final int TEXT_W = LABEL_W * 3;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int BUTTON_W = 80;
	
	private static final int BUTTON_H = 30;
	
	private static final int START_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W) / 3;
	
	private static final int START_Y = START_X;
	
	public AddAccountPanel() {
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
		//账户金额标签
		this.moneyLabel.setBounds(this.nameLabel.getX(), this.nameLabel.getY() + LABEL_H + (START_Y >> 1),
				LABEL_W, LABEL_H);
		this.moneyLabel.setFont(WORD_FONT);
		//账户金额文本框
		this.moneyText.setBounds(this.nameText.getX(), this.moneyLabel.getY(), TEXT_W, TEXT_H);
		this.moneyText.setFont(WORD_FONT);
		this.moneyText.setOpaque(false);
		//确定按钮
		this.ok.setBounds(this.moneyText.getX() + (TEXT_W >> 1), this.moneyText.getY() + TEXT_H + (START_Y >> 1),
				BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		this.ok.setIcon(new ImageIcon("picture/确定.png"));
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + (BUTTON_W * 3 >> 1), this.ok.getY(),
				BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		//提示标签
		this.tip.setBounds(this.moneyLabel.getX(), this.ok.getY(), TEXT_W, TEXT_H);
		this.tip.setFont(WORD_FONT);
		//将按钮添加到面板
		this.setLayout(null);
		this.add(this.nameLabel);
		this.add(this.nameText);
		this.add(this.moneyLabel);
		this.add(this.moneyText);
		this.add(this.ok);
		this.add(this.cancel);
		this.add(this.tip);
	}
	
	public JPanel getAccountInfo(int x, int y, int w, int h, AccountVO vo) {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(x, y, w, h);
		panel.add(this.nameLabel);
		this.nameText.setText(vo.getName());
		panel.add(this.nameText);
		panel.add(this.moneyLabel);
		this.moneyText.setText(new Double(vo.getBalance()).toString());
		panel.add(this.moneyText);
		return panel;
	}
	
	private void addListener() {
		//确定按钮
		this.ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameText.getText();
				String money = moneyText.getText();
				tip.setForeground(Color.RED);
				//验证用户填写的信息
				if(CommonLogic.isNull(name) || CommonLogic.isNull(money)) {
					tip.setText("请把信息填写完整");
					repaint();
					return ;
				}
				if(!CommonLogic.isNumber(money)) {
					tip.setText("账户金额应该为数字");
					repaint();
					return ;
				}
				//保存账户信息
				boolean save = account.addAccount(new AccountVO(name, Double.parseDouble(money)));
				if(save) {
					tip.setForeground(Color.BLUE);
					tip.setText("账户信息保存成功");
				}
				else {
					tip.setForeground(Color.RED);
					tip.setText("账户信息保存失败");
				}
				//刷新面板
				repaint();
			}
		});
		//取消按钮
		this.cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//清空用户填写数据
				clearInfo();
			}
		});
	}
	
	private void clearInfo() {
		this.nameText.setText("");
		this.moneyText.setText("");
		this.tip.setText("");
		this.repaint();
	}
}
