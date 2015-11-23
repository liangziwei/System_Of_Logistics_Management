package ui.administratorui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ui.baseui.DetailPanel;

public class AdminDetailPanel extends DetailPanel{
	
	private JLabel type=new JLabel("账户类型");
	private JLabel name=new JLabel("姓名");
	private JLabel id=new JLabel("账号");
	private JLabel password=new JLabel("密码");
	private JLabel limit=new JLabel("权限");
	
	private JComboBox typeBox=new JComboBox();
	private JTextField nameText=new JTextField();
	private JTextField idText=new JTextField();
	private JTextField passwordText=new JTextField();
	private JComboBox limitBox = new JComboBox();
	
	private JButton query = new JButton("查询");
	
	private JButton ok = new JButton("确定");
	
	private JButton cancel = new JButton("取消");
	
	private static final int LABEL_W = 130;
	
	private static final int LABEL_H = 25;

	private static final int LINE_GAP = 18;
	
	private static final int TEXT_W = LABEL_W *2;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int START_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W) / 3;
	
	private static final int START_Y = START_X;
	
	private static final int BUTTON_W = LABEL_W+10;
	
	private static final int BUTTON_H = LABEL_H;
	
	private static final Font WORD_FONT = new Font("宋体", Font.PLAIN, 18);
	
	private boolean isFirstEnsure = true;
	
	
	public AdminDetailPanel(){
		
		this.id.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.id.setFont(WORD_FONT);
		this.idText.setBounds(this.id.getX() + LABEL_W + LINE_GAP, this.id.getY(), TEXT_W, TEXT_H);
		this.idText.setFont(WORD_FONT);
		
		this.password.setBounds(START_X, this.id.getY() + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.password.setFont(WORD_FONT);
		this.passwordText.setBounds(this.id.getX() + LABEL_W + LINE_GAP, this.password.getY(), TEXT_W, TEXT_H);
		this.passwordText.setFont(WORD_FONT);
		
		
		this.type.setBounds(START_X, this.password.getY()+ LABEL_H + (LINE_GAP<<1), LABEL_W, LABEL_H);
		this.type.setFont(WORD_FONT);	
		this.typeBox.setModel(new DefaultComboBoxModel(new String[] {"快递员", "营业厅业务员","中转中心业务员","仓库管理员","财务人员","总经理","系统管理员"}));
		this.typeBox.setBounds(START_X + LABEL_W + LINE_GAP, this.type.getY(), LABEL_W+LINE_GAP, TEXT_H);
		this.typeBox.setFont(WORD_FONT);
		
		this.name.setBounds(this.typeBox.getX()+LABEL_W+(LINE_GAP<<1), this.type.getY(), LABEL_W>>1, LABEL_H);
		this.name.setFont(WORD_FONT);
		this.nameText.setBounds(this.name.getX()+LABEL_W/2, this.name.getY(), TEXT_W/3, TEXT_H);
		this.nameText.setFont(WORD_FONT);
		
		
		this.limit.setBounds(START_X, this.type.getY() + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.limit.setFont(WORD_FONT);
		this.limitBox.setModel(new DefaultComboBoxModel(new String[] {"高", "低"}));
		this.limitBox.setBounds(this.limit.getX()+ LABEL_W +LINE_GAP, this.limit.getY(), TEXT_W>>2, TEXT_H);
		this.limitBox.setFont(WORD_FONT);
		
		this.query.setBounds(START_X+TEXT_W+ LABEL_W + LINE_GAP,START_Y,BUTTON_W>>1,BUTTON_H);
		this.query.setFont(WORD_FONT);
		this.ok.setBounds(this.limit.getX() + TEXT_W, this.limit.getY() + LABEL_H*4+ LINE_GAP,BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + BUTTON_W + LINE_GAP, this.ok.getY(), BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		this.cancel.setVisible(false);
		
		
		this.addListener();
		this.addComponents();
		
	}
	
	private void addListener(){

		this.query.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//验证收件信息是否合法
				
			}
		});
		
		this.ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//验证收件信息是否合法
				
			}
		});
		
		//取消按钮
		this.cancel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//设置取消按钮不可见
				cancel.setVisible(false);
				//设置状态为第一次点击确定按钮
				isFirstEnsure = true;
				//使组件可编辑
				//消除提示信息
			}
		});
	}
	
	private void addComponents(){
		this.add(type);
		this.add(typeBox);
		this.add(name);
		this.add(nameText);
		this.add(id);
		this.add(idText);
		this.add(password);
		this.add(passwordText);
		this.add(limit);
		this.add(limitBox);
		this.add(query);
		this.add(ok);
		this.add(cancel);
	}
}
