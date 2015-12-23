package ui.businessui.vehicleui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;
import vo.businessVO.VehicleVO;
import businessLogic.businessLogicController.businessController.VehicleController;
import businessLogicService.businessBLService.VehicleBLService;

@SuppressWarnings("serial")
public class FindVehiclePanel extends DetailPanel{
	private VehicleBLService vehicleCon=new VehicleController();
	private VehicleVO vehicleVO;
	
	private JLabel vehicleid=new JLabel("车辆代号");
	private JLabel number=new JLabel("车牌号");
	private JLabel age=new JLabel("服役时间(年)");
	
	private JLabel result=new JLabel();
	
	private JTextField vehicleidText=new JTextField("");
	private JTextField numberText=new JTextField("");
	private JTextField ageText=new JTextField("");
	
	private LimpidButton query = new LimpidButton("","picture/查询.png");
	
	private LimpidButton ok = new LimpidButton("","picture/确定.png");
	
	
	private static final int LABEL_W = 150;
	
	private static final int LABEL_H = 30;

	private static final int LINE_GAP = 18;
	
	private static final int TEXT_W = LABEL_W *2;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int START_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W) / 3;
	
	private static final int START_Y = START_X;
	
	private static final int BUTTON_W = LABEL_W-70;
	
	private static final int BUTTON_H = LABEL_H ;
	
	private static final Font WORD_FONT = new Font("宋体", Font.PLAIN, 18);
	
	
	public FindVehiclePanel(){
		this.vehicleid.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.vehicleid.setFont(WORD_FONT);	
		this.vehicleidText.setBounds(START_X + LABEL_W + LINE_GAP, START_Y, TEXT_W, TEXT_H);
		this.vehicleidText.setFont(WORD_FONT);
		this.vehicleidText.setOpaque(false);
		
		this.number.setBounds(START_X, START_Y + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.number.setFont(WORD_FONT);
		this.numberText.setBounds(this.vehicleidText.getX(), this.number.getY(), TEXT_W, TEXT_H);
		this.numberText.setFont(WORD_FONT);
		this.numberText.setOpaque(false);
		
		this.age.setBounds(START_X, this.number.getY() + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.age.setFont(WORD_FONT);
		this.ageText.setBounds(this.vehicleidText.getX(), this.age.getY(), TEXT_W>>2, TEXT_H);
		this.ageText.setFont(WORD_FONT);
		this.ageText.setOpaque(false);
		
		this.query.setBounds(START_X+TEXT_W+ LABEL_W + LINE_GAP,START_Y,BUTTON_W,BUTTON_H);
		this.query.setFont(WORD_FONT);
		
		this.result.setBounds(this.age.getX() + LINE_GAP, this.age.getY() + LABEL_H*5+ LINE_GAP,
				TEXT_W, TEXT_H);
		this.result.setFont(WORD_FONT);
		this.result.setText("");
		
//		this.ok.setBounds(this.age.getX() + TEXT_W, this.age.getY() + LABEL_H*6+ LINE_GAP,
//				BUTTON_W, BUTTON_H);
//		this.ok.setFont(WORD_FONT);
//		//取消按钮
//		this.cancel.setBounds(this.ok.getX() + BUTTON_W + LINE_GAP, this.ok.getY(), BUTTON_W, BUTTON_H);
//		this.cancel.setFont(WORD_FONT);
//		this.cancel.setVisible(false);
		
		this.disablePanel();
		this.visible(false);
		this.addListener();
		this.addComponents();
		
	}
	
	private void addListener(){

		this.query.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String vehicleid=vehicleidText.getText();
				if(isCorrect()){
					
				  vehicleVO=vehicleCon.findVehicle(vehicleid);
				  if(!vehicleVO.isWrong()){
					visible(true);
					numberText.setText(vehicleVO.getNumber());
					ageText.setText(vehicleVO.getAge());
					result.setText("");
				  }else{
					visible(false);
					result.setForeground(Color.RED);
					result.setText("输入的车辆代号不存在");
				  }
				
				}else{
					visible(false);
					result.setForeground(Color.RED);
					result.setText("输入格式错误 ");
				}
				repaint();
			}
		});
		
		
	}
	
	private void addComponents(){
		this.add(vehicleid);
		this.add(vehicleidText);
		this.add(number);
		this.add(numberText);
		this.add(age);
		this.add(ageText);
		this.add(query);
		this.add(result);
//		this.add(ok);
//		this.add(cancel);
	}
	
	private boolean isCorrect(){
		
		String vehicleidStr=vehicleidText.getText();
		
		if(!vehicleidStr.matches("\\d{9}")){
			vehicleidText.setText("");
			return false;
		}
		
		return true;
	}
	
	private void visible(boolean isVisible){
		number.setVisible(isVisible);
		age.setVisible(isVisible);
		
		numberText.setVisible(isVisible);
		ageText.setVisible(isVisible);
		ok.setVisible(isVisible);
		
	}
	
	private void disablePanel(){
		this.numberText.setEditable(false);
		this.ageText.setEditable(false);
	}
	
//	private void enablePanel(){
//		this.vehicleidText.setEditable(true);
//		this.numberText.setEditable(true);
//		this.ageText.setEditable(true);
//	}
	
//	private void setBlack(){
//		this.vehicleidText.setText("");
//		this.numberText.setText("");
//		this.ageText.setText("");
//	}
	
}
