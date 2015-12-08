package ui.businessui.receiveandsendui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import businessLogic.businessLogicController.businessController.ReceiveAndSendController;
import businessLogic.businessLogicModel.util.CommonLogic;
import constant.CargoState;
import ui.DateChooser;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;
import vo.businessVO.ArrivalFormVO;

public class ArrivalPanel extends DetailPanel {

	private ReceiveAndSendController receAndSendCon=new ReceiveAndSendController();
	private ArrivalFormVO arrivalVO;
	
	private DateChooser dateChoose=DateChooser.getInstance();
	
	private JLabel date=new JLabel("到达日期");
	private JLabel transitNumber=new JLabel("中转单编号");
	private JLabel departPlace=new JLabel("出发地");
	private JLabel state=new JLabel("货物到达状态");
	
	private JLabel result=new JLabel();
	
	private JTextField dateText=new JTextField();
	private JTextField transitNumberText=new JTextField();
	private JTextField departPlaceText=new JTextField();
	private JComboBox stateBox = new JComboBox();
	
	private LimpidButton ok = new LimpidButton("","picture/确定.png");
	
	private LimpidButton cancel = new LimpidButton("","picture/取消.png");
	
	private static final int LABEL_W = 120;
	
	private static final int LABEL_H = 25;

	private static final int LINE_GAP = 18;
	
	private static final int TEXT_W = LABEL_W *3;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int START_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W) / 3;
	
	private static final int START_Y = START_X;
	
	private static final int BUTTON_W = LABEL_W-40;
	
	private static final int BUTTON_H = LABEL_H+5;
	
	private static final Font WORD_FONT = new Font("宋体", Font.PLAIN, 18);
	
	private boolean isFirstEnsure = true;
	private boolean isOver=false;
	
	public ArrivalPanel(){
		this.date.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.date.setFont(WORD_FONT);	
		this.dateText.setBounds(START_X + LABEL_W + LINE_GAP, START_Y, TEXT_W, TEXT_H);
		this.dateText.setFont(WORD_FONT);
		dateChoose.register(dateText);
		this.dateText.setOpaque(false);
		
		this.transitNumber.setBounds(START_X, START_Y + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.transitNumber.setFont(WORD_FONT);
		this.transitNumberText.setBounds(this.dateText.getX(), this.transitNumber.getY(), TEXT_W, TEXT_H);
		this.transitNumberText.setFont(WORD_FONT);
		this.transitNumberText.setOpaque(false);
		
		this.departPlace.setBounds(START_X, this.transitNumber.getY() + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.departPlace.setFont(WORD_FONT);
		this.departPlaceText.setBounds(this.dateText.getX(), this.departPlace.getY(), TEXT_W, TEXT_H);
		this.departPlaceText.setFont(WORD_FONT);
		this.departPlaceText.setOpaque(false);
		
		this.state.setBounds(START_X, this.departPlace.getY() + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.state.setFont(WORD_FONT);
		this.stateBox.setBounds(this.dateText.getX(), this.state.getY(), LABEL_W, TEXT_H);
		this.stateBox.setModel(new DefaultComboBoxModel(new String[] {"完整", "损坏", "丢失"}));
		this.stateBox.setFont(WORD_FONT);
		this.stateBox.setOpaque(false);
		
		this.result.setBounds(this.state.getX()+ LINE_GAP , this.state.getY() + LABEL_H*5+ LINE_GAP,
				TEXT_W, TEXT_H);
		this.setFont(WORD_FONT);
		this.result.setText("");
		
		this.ok.setBounds(this.state.getX() + TEXT_W, this.state.getY() + LABEL_H*5+ LINE_GAP,
				BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + BUTTON_W + LINE_GAP, this.ok.getY(), BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		this.cancel.setVisible(false);
		
		
		this.addListener();
		this.addComponents();
		
	}
	
	private void addListener(){

		this.ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(isFirstEnsure){
					if(isCorrect()){
						   result.setForeground(Color.BLUE);
						   result.setText("请确认信息输入无误，确认后点击提交");
						   ok.setText("提交");
						   disablePanel();
						   isFirstEnsure=false;
					}else{
						   result.setForeground(Color.RED);
						   disablePanel();
						   result.setText("信息输入格式有错误，请重新输入");
					}
					cancel.setVisible(true);
				}else{
					if(isOver){
						result.setText("");
						setBlack();
						enablePanel();
						isFirstEnsure=true;	
						isOver=false;
						
					}else{
						String dateStr=dateText.getText();
						String transitNumberStr=transitNumberText.getText();
						String departPlaceStr=departPlaceText.getText();
						String stateStr=(String)stateBox.getSelectedItem();
						System.out.println(stateStr);
						CargoState cargoState;
						if(stateStr.equals("完整")){
							cargoState=CargoState.完整;
						}else if(stateStr.equals("损坏")){
							cargoState=CargoState.损坏;
						}else{
							cargoState=CargoState.丢失;
						}
						arrivalVO=new ArrivalFormVO(dateStr,transitNumberStr,departPlaceStr,cargoState);
						
						if(receAndSendCon.addReceiveFrom(arrivalVO)){
							result.setForeground(Color.GREEN);
							result.setText("保存成功！");
							ok.setText("确认");
							cancel.setVisible(false);
							isOver=true;
						}else{
							result.setForeground(Color.RED);
							result.setText("信息有误，保存失败");
						}						
					}
					
				}
				repaint();
			}
		});
		
		//取消按钮
		this.cancel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(ok.getText().equals("提交")){
					ok.setText("确定");
					cancel.setVisible(false);
					enablePanel();
					isFirstEnsure = true;
					result.setText("");
				}else{
				  cancel.setVisible(false);
				
				  //设置状态为第一次点击确定按钮
				  isFirstEnsure = true;
				  //使组件可编辑
				  enablePanel();
				  //消除提示信息
				  result.setText("");
				  
				}
				repaint();
			}
		});
	}
	
	private void addComponents(){
		this.add(date);
		this.add(dateText);
		this.add(transitNumber);
		this.add(transitNumberText);
		this.add(departPlace);
		this.add(departPlaceText);
		this.add(state);
		this.add(stateBox);
		this.add(result);
		this.add(ok);
		this.add(cancel);
	}
	
private boolean isCorrect(){
		
		String dateStr=dateText.getText();
		String transitNumberStr=transitNumberText.getText();
		
		if(!CommonLogic.isDate(dateStr)){
			dateText.setText("");
			return false;
		}else if(!transitNumberStr.matches("\\d{11}")){
			transitNumberText.setText("");
			return false;
		}
		
		return true;
	}
	
	private void disablePanel(){
		this.dateText.setEditable(false);
		this.transitNumberText.setEditable(false);
		this.departPlaceText.setEditable(false);
		this.stateBox.setEditable(false);
	}
	
	private void enablePanel(){
		this.dateText.setEditable(true);
		this.transitNumberText.setEditable(true);
		this.departPlaceText.setEditable(true);
		this.stateBox.setEditable(true);
	}
	
	private void setBlack(){
		this.dateText.setText("");
		this.transitNumberText.setText("");
		this.departPlaceText.setText("");
	}
}
