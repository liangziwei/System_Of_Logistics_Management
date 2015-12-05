package ui.financeui.accountui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import businessLogic.businessLogicController.financeController.AccountController;
import businessLogicService.financeBLService.AccountBLService;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;
import vo.financeVO.AccountVO;

@SuppressWarnings("serial")
public class DeleteAccountPanel extends DetailPanel{
	
	private AccountBLService account = new AccountController();

	private JLabel nameLabel = new JLabel("账户名称");
	
	private JTextField nameText = new JTextField();
	
	private LimpidButton ok = new LimpidButton("","picture/确定.png");
	
	private JSeparator line = new JSeparator();
	
	private JLabel tip = new JLabel();
	
	private LimpidButton delete = new LimpidButton("","picture/删除.png");
	
	private LimpidButton cancel = new LimpidButton("","picture/取消.png");
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 20);
	
	private static final int LABEL_W = 100;
	
	private static final int LABEL_H = 30;
	
	private static final int TEXT_W = LABEL_W * 3;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int BUTTON_W = 80;
	
	private static final int BUTTON_H = LABEL_H;
	
	private static final int START_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W - (BUTTON_W << 1)) / 3;
	
	private static final int START_Y = START_X >> 2;
	
	public DeleteAccountPanel() {
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
		//确定按钮
		this.ok.setBounds(this.nameText.getX() + TEXT_W + START_X, this.nameText.getY(),
				BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		//删除按钮
		this.delete.setBounds(this.nameText.getX() + TEXT_W + (START_X >> 1), this.nameText.getY(),
				BUTTON_W, BUTTON_H);
		this.delete.setFont(WORD_FONT);
		this.delete.setVisible(false);
		//取消按钮
		this.cancel.setBounds(this.delete.getX() + (BUTTON_W * 3 >> 1), this.delete.getY(),
				BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		this.cancel.setVisible(false);
		//提示标签
		this.tip.setBounds(START_X >> 2, this.nameLabel.getY() + LABEL_H,
				TEXT_W, TEXT_H);
		this.tip.setFont(WORD_FONT);
		tip.setForeground(Color.RED);
		//分割线
		this.line.setBounds(0, this.tip.getY() + TEXT_H, DETAIL_PANEL_W, 5);
		//将按钮添加到面板
		this.setLayout(null);
		this.add(this.nameLabel);
		this.add(this.nameText);
		this.add(this.ok);
		this.add(this.tip);
		this.add(this.line);
		this.add(this.delete);
		this.add(this.cancel);
	}
	
	private void addListener() {
		//确定按钮
		this.ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//查找账户信息
				AccountVO vo = account.findAccount(nameText.getText());
				//如果找不到
				if(vo == null) {
					tip.setText("该账户不存在");
					repaint();
					return ;
				}
				//询问用户是否确认删除
				tip.setText("确认删除吗");
				//隐藏确认按钮
				ok.setVisible(false);
				//使账户名称输入框不可编辑
				nameText.setEditable(false);
				//展示删除和取消按钮
				delete.setVisible(true);
				cancel.setVisible(true);
				//展示账户信息
				AccountInfoPanel panel = new AccountInfoPanel(0, tip.getY() + TEXT_H,
							DETAIL_PANEL_W, DETAIL_PANEL_H - LABEL_H * 3, vo);
				add(panel);
				//刷新面板
				repaint();
			}
		});
		//取消按钮
		this.cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				returnToSearch();
				tip.setText("");
			}
		});
		//删除按钮
		this.delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//删除账户信息
				boolean result = account.deleteAccount(nameText.getText());
				if(result) {
					tip.setText("删除成功");
				}
				else {
					tip.setText("删除失败");
				}
				//返回搜索界面
				returnToSearch();
				//刷新面板
				repaint();
			}
		});
	}
	
	//返回搜索账户界面
	private void returnToSearch() {
		//隐藏删除和取消按钮
		delete.setVisible(false);
		cancel.setVisible(false);
		//使账户名称输入框可编辑
		nameText.setEditable(true);
		nameText.setText("");
		//展现确认按钮
		ok.setVisible(true);
		//刷新面板
		repaint();
	}
}
