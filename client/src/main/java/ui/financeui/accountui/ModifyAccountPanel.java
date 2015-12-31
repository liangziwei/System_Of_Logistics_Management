package ui.financeui.accountui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import businessLogic.businessLogicController.financeController.AccountController;
import businessLogic.businessLogicModel.util.CommonLogic;
import businessLogicService.financeBLService.AccountBLService;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;
import vo.financeVO.AccountVO;

@SuppressWarnings("serial")
public class ModifyAccountPanel extends DetailPanel{
	
	private AccountBLService account = new AccountController();
	
	private AccountInfoPanel panel = null;

	private JLabel nameLabel = new JLabel("账户名称");
	
	private JTextField nameText = new JTextField();
	
	private LimpidButton ok = new LimpidButton("","picture/确定.png");
	
	private JSeparator line = new JSeparator();
	
	private LimpidButton modify = new LimpidButton("","picture/修改.png");
	
	private LimpidButton cancel = new LimpidButton("","picture/取消.png");
	
	private JLabel tip = new JLabel();
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 20);
	
	private static final int LABEL_W = 100;
	
	private static final int LABEL_H = 30;
	
	private static final int TEXT_W = LABEL_W * 3;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int BUTTON_W = 80;
	
	private static final int BUTTON_H = 30;
	
	private static final int START_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W - (BUTTON_W << 1)) / 3;
	
	private static final int START_Y = START_X >> 2;
	
	public ModifyAccountPanel() {
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
		this.ok.setBounds(this.nameText.getX() + TEXT_W + START_X, this.nameText.getY(),
				BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		//修改按钮
		this.modify.setBounds(this.nameText.getX() + TEXT_W + (START_X >> 1), this.nameText.getY(),
				BUTTON_W, BUTTON_H);
		this.modify.setFont(WORD_FONT);
		this.modify.setVisible(false);
		//取消按钮
		this.cancel.setBounds(this.modify.getX() + (BUTTON_W * 3 >> 1), this.modify.getY(),
				BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		this.cancel.setVisible(false);
		//提示标签
		this.tip.setBounds(START_X >> 2, this.nameLabel.getY() + LABEL_H,
				TEXT_W, TEXT_H);
		this.tip.setFont(WORD_FONT);
		this.tip.setForeground(Color.RED);
		//分割线
		this.line.setBounds(0, this.tip.getY() + TEXT_H, DETAIL_PANEL_W, 5);
		//将按钮添加到面板
		this.setLayout(null);
		this.add(this.nameLabel);
		this.add(this.nameText);
		this.add(this.ok);
		this.add(this.tip);
		this.add(this.line);
		this.add(this.modify);
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
				tip.setText("确认修改吗");
				//隐藏确认按钮
				ok.setVisible(false);
				//使账户名称输入框不可编辑
				nameText.setEditable(false);
				//展示删除和取消按钮
				modify.setVisible(true);
				cancel.setVisible(true);
				//展示账户信息
				if(panel != null) panel.setVisible(false);
				panel = new AccountInfoPanel(0, tip.getY() + TEXT_H,
							DETAIL_PANEL_W, DETAIL_PANEL_H - LABEL_H * 3, vo);
				add(panel);
				//使金额文本框不可编辑
				panel.disableMoneyText();
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
		//修改按钮
		this.modify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = panel.getAccountName();
				//查看修改后的名称是否已经存在
				AccountVO vo = account.findAccount(name);
				if(vo != null) {
					setTip("该账户名称已经存在");
					return ;
				}
				//修改账户信息
				if(CommonLogic.isNull(name)) {
					setTip("账户名称不能为空");
					return ;
				}
				boolean result = account.modifyAccount(nameText.getText(), name);
				if(result) {
					tip.setText("修改成功");
				}
				else {
					tip.setText("修改失败");
				}
				//返回搜索界面
				returnToSearch();
			}
		});
	}
	
	//返回搜索账户界面
	private void returnToSearch() {
		//隐藏删除和取消按钮
		modify.setVisible(false);
		cancel.setVisible(false);
		//使账户名称输入框可编辑
		nameText.setEditable(true);
		nameText.setText("");
		//展现确认按钮
		ok.setVisible(true);
		//刷新面板
		repaint();
	}
	
	/**
	 *设置提示信息 
	 */
	private void setTip(String text) {
		tip.setText(text);
		repaint();
	}
}
