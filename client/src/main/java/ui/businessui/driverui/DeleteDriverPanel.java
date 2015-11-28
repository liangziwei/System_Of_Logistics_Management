package ui.businessui.driverui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import businessLogic.businessLogicController.businessController.DriverController;
import businessLogic.businessLogicModel.util.CommonLogic;
import ui.baseui.DetailPanel;
import vo.businessVO.DriverVO;

public class DeleteDriverPanel extends DetailPanel {
	private DriverController driverCon=new DriverController();
	private DriverVO driverVO;
	
	private JLabel driverid=new JLabel("司机编号");
	private JLabel name=new JLabel("   姓名");
	private JLabel birthday=new JLabel("出生日期");
	private JLabel idNumber=new JLabel("身份证号");
	private JLabel phoneNumber=new JLabel("手机号");
	private JLabel gender=new JLabel("性别");
	private JLabel drivingDeadline=new JLabel("行驶证期限");
	
	private JLabel result=new JLabel();
	
	private JTextField driveridText=new JTextField();
	private JTextField nameText=new JTextField();
	private JTextField birthdayText=new JTextField();
	private JTextField idNumberText=new JTextField();
	private JTextField phoneNumberText=new JTextField();
	private JTextField genderText=new JTextField();
	private JTextField drivingDeadlineText=new JTextField();
	
	private JButton query = new JButton("查询");
	
	private JButton ok = new JButton("确定");
	
	private JButton cancel = new JButton("取消");
	
	private static final int LABEL_W = 140;
	
	private static final int LABEL_H = 25;

	private static final int LINE_GAP = 18;
	
	private static final int TEXT_W = LABEL_W *2;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int START_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W) / 3;
	
	private static final int START_Y = START_X;
	
	private static final int BUTTON_W = LABEL_W;
	
	private static final int BUTTON_H = LABEL_H;
	
	private static final Font WORD_FONT = new Font("宋体", Font.PLAIN, 18);
	
	private boolean isFirstEnsure = true;
	private boolean isOver=false;
	
	public DeleteDriverPanel(){
		this.driverid.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.driverid.setFont(WORD_FONT);	
		this.driveridText.setBounds(START_X + LABEL_W + LINE_GAP, START_Y, TEXT_W, TEXT_H);
		this.driveridText.setFont(WORD_FONT);
		
		this.name.setBounds(START_X, START_Y + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.name.setFont(WORD_FONT);
		this.nameText.setBounds(this.driveridText.getX(), this.name.getY(), TEXT_W>>2, TEXT_H);
		this.nameText.setFont(WORD_FONT);
		
		this.gender.setBounds(START_X+(TEXT_W>>2)+ LABEL_W + (LINE_GAP<<2), this.name.getY() , LABEL_W>>1, LABEL_H);
		this.gender.setFont(WORD_FONT);
		this.genderText.setBounds(this.gender.getX()+ (LABEL_W>>1) + LINE_GAP, this.gender.getY(), TEXT_W>>2, TEXT_H);
		this.genderText.setFont(WORD_FONT);
		
		this.idNumber.setBounds(START_X, this.name.getY() + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.idNumber.setFont(WORD_FONT);
		this.idNumberText.setBounds(this.driveridText.getX(), this.idNumber.getY(), TEXT_W, TEXT_H);
		this.idNumberText.setFont(WORD_FONT);
		
		this.birthday.setBounds(START_X, this.idNumber.getY() + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.birthday.setFont(WORD_FONT);
		this.birthdayText.setBounds(this.driveridText.getX(), this.birthday.getY(), TEXT_W>>2, TEXT_H);
		this.birthdayText.setFont(WORD_FONT);
		
		this.drivingDeadline.setBounds(START_X+(TEXT_W>>2)+ LABEL_W + (LINE_GAP<<1), this.birthday.getY() , LABEL_W, LABEL_H);
		this.drivingDeadline.setFont(WORD_FONT);
		this.drivingDeadlineText.setBounds(this.drivingDeadline.getX()+ LABEL_W -LINE_GAP, this.drivingDeadline.getY(), TEXT_W>>2, TEXT_H);
		this.drivingDeadlineText.setFont(WORD_FONT);
		
		this.phoneNumber.setBounds(START_X, this.birthday.getY() + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.phoneNumber.setFont(WORD_FONT);
		this.phoneNumberText.setBounds(this.driveridText.getX(), this.phoneNumber.getY(), TEXT_W, TEXT_H);
		this.phoneNumberText.setFont(WORD_FONT);
		
		this.query.setBounds(START_X+TEXT_W+ LABEL_W + LINE_GAP,START_Y,BUTTON_W>>1,BUTTON_H);
		this.query.setFont(WORD_FONT);
		
		this.result.setBounds(this.phoneNumber.getX() +LINE_GAP, this.phoneNumber.getY() + LABEL_H*4+ LINE_GAP,TEXT_W, BUTTON_H);
//		this.result.setFont(WORD_FONT);
		this.ok.setBounds(this.phoneNumber.getX() + TEXT_W, this.phoneNumber.getY() + LABEL_H*4+ LINE_GAP,BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + BUTTON_W + LINE_GAP, this.ok.getY(), BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
//		this.cancel.setVisible(false);
		
		this.disablePanel();
		this.visible(false);
		this.addListener();
		this.addComponents();
		
	}
	
	private void addListener(){

		this.query.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String driverid=driveridText.getText();
				if(isCorrect()){
					
				  driverVO=driverCon.findDriver(driverid);
				  if(!driverVO.isWrong()){
					visible(true);
					nameText.setText(driverVO.getName());
					birthdayText.setText(driverVO.getBirthday());
					idNumberText.setText(driverVO.getIdNumber());
					phoneNumberText.setText(driverVO.getPhoneNumber());
					genderText.setText(driverVO.getGender());
					drivingDeadlineText.setText(driverVO.getDrivingDeadline());
					
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
				String driverid=driveridText.getText();
				if(driverCon.deleteDriver(driverid)){
					ok.setVisible(false);
					cancel.setVisible(false);
					result.setForeground(Color.BLUE);
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
		this.add(driverid);
		this.add(driveridText);
		this.add(name);
		this.add(nameText);
		this.add(birthday);
		this.add(birthdayText);
		this.add(idNumber);
		this.add(idNumberText);
		this.add(phoneNumber);
		this.add(phoneNumberText);
		this.add(gender);
		this.add(genderText);
		this.add(drivingDeadline);
		this.add(drivingDeadlineText);
		this.add(query);
		this.add(result);
		this.add(ok);
		this.add(cancel);
	}
	
	private boolean isCorrect(){
		
		String driveridStr=driveridText.getText();
		String nameStr=nameText.getText();
		String birthdayStr=birthdayText.getText();
		String idNumber=idNumberText.getText();
		String phoneStr=phoneNumberText.getText();
		String genderStr=genderText.getText();
		String drivingDeadlineStr=drivingDeadlineText.getText();
		
		
		if(driveridStr.length()!=9||!CommonLogic.isNumber(driveridStr)){
			driveridText.setText("");
			return false;
		}
		
		return true;
	}
	
	private void visible(boolean isVisible){
		
		this.name.setVisible(isVisible);
		this.birthday.setVisible(isVisible);
		this.idNumber.setVisible(isVisible);
		this.phoneNumber.setVisible(isVisible);
		this.gender.setVisible(isVisible);
		this.drivingDeadline.setVisible(isVisible);
		this.nameText.setVisible(isVisible);
		this.birthdayText.setVisible(isVisible);
		this.idNumberText.setVisible(isVisible);
		this.phoneNumberText.setVisible(isVisible);
		this.genderText.setVisible(isVisible);
		this.drivingDeadlineText.setVisible(isVisible);
		ok.setVisible(isVisible);
		cancel.setVisible(isVisible);
	}
	
	private void disablePanel(){
//		this.driveridText.setEditable(false);
		this.nameText.setEditable(false);
		this.birthdayText.setEditable(false);
		this.idNumberText.setEditable(false);
		this.phoneNumberText.setEditable(false);
		this.genderText.setEditable(false);
		this.drivingDeadlineText.setEditable(false);
	}
	
	private void enablePanel(){
		this.driveridText.setEditable(true);
		this.nameText.setEditable(true);
		this.birthdayText.setEditable(true);
		this.idNumberText.setEditable(true);
		this.phoneNumberText.setEditable(true);
		this.genderText.setEditable(true);
		this.drivingDeadlineText.setEditable(true);
	}
	
	private void setBlack(){
		this.driveridText.setText("");
		this.nameText.setText("");
		this.birthdayText.setText("");
		this.idNumberText.setText("");
		this.phoneNumberText.setText("");
		this.genderText.setText("");
		this.drivingDeadlineText.setText("");
	}
}
