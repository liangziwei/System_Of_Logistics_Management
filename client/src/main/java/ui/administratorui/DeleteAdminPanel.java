package ui.administratorui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import businessLogic.businessLogicController.administratorController.AdministratorController;
import constant.Authority;
import constant.UserType;
import ui.baseui.DetailPanel;
import vo.administratorVO.AdministratorVO;

public class DeleteAdminPanel extends DetailPanel {
	private AdministratorController adminCon=new AdministratorController();
	private AdministratorVO adminVO;
	
	private JLabel type=new JLabel("账户类型");
	private JLabel name=new JLabel("姓名");
	private JLabel id=new JLabel("账号");
	private JLabel password=new JLabel("密码");
	private JLabel limit=new JLabel("权限");
	
	private JLabel result=new JLabel();
	
	private JComboBox typeBox=new JComboBox();
	private JTextField nameText=new JTextField();
	private JTextField idText=new JTextField();
	private JTextField passwordText=new JTextField();
	private JComboBox limitBox = new JComboBox();
	
	private JButton query = new JButton("");
	
	private JButton ok = new JButton("");
	
	private JButton cancel = new JButton("");
	
	private static final int LABEL_W = 130;
	
	private static final int LABEL_H = 30;

	private static final int LINE_GAP = 18;
	
	private static final int TEXT_W = LABEL_W *2;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int START_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W) / 3;
	
	private static final int START_Y = START_X;
	
	private static final int BUTTON_W = LABEL_W-50;
	
	private static final int BUTTON_H = LABEL_H;
	
	private static final Font WORD_FONT = new Font("宋体", Font.PLAIN, 18);
	
	private boolean isFirstEnsure = true;
	private boolean isOver=false;
	
	public DeleteAdminPanel(){
		
		this.id.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.id.setFont(WORD_FONT);
		this.idText.setBounds(this.id.getX() + LABEL_W + LINE_GAP, this.id.getY(), TEXT_W, TEXT_H);
		this.idText.setFont(WORD_FONT);
		this.idText.setOpaque(false);
		
		this.password.setBounds(START_X, this.id.getY() + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.password.setFont(WORD_FONT);
		this.passwordText.setBounds(this.id.getX() + LABEL_W + LINE_GAP, this.password.getY(), TEXT_W, TEXT_H);
		this.passwordText.setFont(WORD_FONT);
		this.passwordText.setOpaque(false);
		
		
		this.type.setBounds(START_X, this.password.getY()+ LABEL_H + (LINE_GAP<<1), LABEL_W, LABEL_H);
		this.type.setFont(WORD_FONT);
		this.type.setOpaque(false);
		this.typeBox.setModel(new DefaultComboBoxModel(new String[] {"快递员", "营业厅业务员","中转中心业务员","仓库管理员","财务人员","总经理","系统管理员"}));
		this.typeBox.setBounds(START_X + LABEL_W + LINE_GAP, this.type.getY(), LABEL_W+LINE_GAP, TEXT_H);
		this.typeBox.setFont(WORD_FONT);
		this.typeBox.setOpaque(false);
		
		this.name.setBounds(this.typeBox.getX()+LABEL_W+(LINE_GAP<<1), this.type.getY(), LABEL_W>>1, LABEL_H);
		this.name.setFont(WORD_FONT);
		this.name.setOpaque(false);
		this.nameText.setBounds(this.name.getX()+LABEL_W/2, this.name.getY(), TEXT_W/3, TEXT_H);
		this.nameText.setFont(WORD_FONT);
		this.nameText.setOpaque(false);
		
		
		this.limit.setBounds(START_X, this.type.getY() + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.limit.setFont(WORD_FONT);
		this.limitBox.setModel(new DefaultComboBoxModel(new String[] {"高", "低"}));
		this.limitBox.setBounds(this.limit.getX()+ LABEL_W +LINE_GAP, this.limit.getY(), TEXT_W>>2, TEXT_H);
		this.limitBox.setFont(WORD_FONT);
		this.limitBox.setOpaque(false);
		
		this.query.setBounds(START_X+TEXT_W+ LABEL_W + LINE_GAP,START_Y,BUTTON_W,BUTTON_H);
		this.query.setFont(WORD_FONT);
		this.query.setIcon(new ImageIcon("picture/查询.png"));
		
		this.result.setBounds(this.limit.getX() + LINE_GAP, this.limit.getY() + LABEL_H*4+ LINE_GAP,TEXT_W, BUTTON_H);
//		this.result.setFont(WORD_FONT);
		this.ok.setBounds(this.limit.getX() + TEXT_W, this.limit.getY() + LABEL_H*4+ LINE_GAP,BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		this.ok.setIcon(new ImageIcon("picture/确定.png"));
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + BUTTON_W + LINE_GAP, this.ok.getY(), BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		this.cancel.setIcon(new ImageIcon("picture/取消.png"));
//		this.cancel.setVisible(false);
		
		this.disablePanel();
		this.visible(false);
		this.addListener();
		this.addComponents();
		
	}
	
	private void addListener(){

		this.query.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String userid=idText.getText();
				if(isCorrect()){
					
				  adminVO=adminCon.findUser(userid);
				  if(!adminVO.isWrong()){
					visible(true);
					passwordText.setText(adminVO.getPassword());
					nameText.setText(adminVO.getName());
					typeBox.setSelectedItem(adminVO.getType().toString());
					limitBox.setSelectedItem(adminVO.getLimit().toString());		
					result.setText("");
				  }else{
					visible(false);
					result.setForeground(Color.RED);
					result.setText("输入的司机编号不存在");
				  }
				
				}else{
					visible(false);
					result.setForeground(Color.RED);
					result.setText("输入格式错误 ");
				}
				repaint();
			}
		});

		this.ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String userid=idText.getText();
				if(adminCon.deleteUser(userid)){
					ok.setVisible(false);
					cancel.setVisible(false);
					result.setForeground(Color.GREEN);
					result.setText("删除成功");
				}else{
					ok.setVisible(false);
					cancel.setVisible(false);
					result.setText("删除失败");
				}
				repaint();
			}
		});
		
		//取消按钮
		this.cancel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//设置取消按钮不可见
				visible(false);
				result.setText("");
				repaint();
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
		this.add(result);
		this.add(ok);
		this.add(cancel);
	}
	
private boolean isCorrect(){
		
		String typeStr=(String)typeBox.getSelectedItem();
		String nameStr=nameText.getText();
		String idStr=idText.getText();
		String passwordStr=passwordText.getText();
		String limitStr=(String)limitBox.getSelectedItem();
		
//		if(idStr.length()!=9&&!CommonLogic.isNumber(driveridStr)){
//			driveridText.setText("");
//			return false;
//		}else if(birthdayStr.length()!=10){
//			birthdayText.setText("");
//			return false;
//		}else if(!CommonLogic.isNumber(drivingDeadlineStr)){
//			drivingDeadlineText.setText("");
//			return false;
//		}else if(idNumber.length()!=18){
//			idNumberText.setText("");
//			return false;
//		}else if(!CommonLogic.isNumber(phoneStr)){
//			phoneNumberText.setText("");
//			return false;
//		}
		
		return true;
	}

private void visible(boolean isVisible){
	
	this.name.setVisible(isVisible);
	this.type.setVisible(isVisible);
	this.password.setVisible(isVisible);
	this.limit.setVisible(isVisible);
	this.nameText.setVisible(isVisible);
	this.typeBox.setVisible(isVisible);
	this.passwordText.setVisible(isVisible);
	this.limitBox.setVisible(isVisible);
	ok.setVisible(isVisible);
	cancel.setVisible(isVisible);
	
}
	
	private void disablePanel(){
		this.typeBox.setEditable(false);
		this.nameText.setEditable(false);
		this.passwordText.setEditable(false);
		this.limitBox.setEditable(false);
	}
	
	private void enablePanel(){
		this.typeBox.setEditable(true);
		this.nameText.setEditable(true);
		this.passwordText.setEditable(true);
		this.limitBox.setEditable(true);
	}
	
	private void setBlack(){
		this.nameText.setText("");
		this.idText.setText("");
		this.passwordText.setText("");
	}
}
