package ui.businessui.receiveandsendui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import ui.DateChooser;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;
import vo.businessVO.SendFormVO;
import businessLogic.businessLogicController.businessController.ReceiveAndSendController;
import businessLogic.businessLogicModel.util.CommonLogic;
import businessLogicService.businessBLService.ReceiveAndSendBLService;

@SuppressWarnings("serial")
public class SendPanel extends DetailPanel {

	private ReceiveAndSendBLService receAndSendCon=new ReceiveAndSendController();
	private SendFormVO sendVO;
	
	private DateChooser dateChoose=DateChooser.getInstance();
	
	private JLabel date=new JLabel("到达日期");	
	private JLabel businessid=new JLabel("营业厅编号");
	private JLabel deliveryid=new JLabel("订单条形码号");
	private JLabel sender=new JLabel("派送员");
	private JLabel result=new JLabel();
	
	private JTextField dateText=new JTextField("");
	private JTextField businessidText=new JTextField("");
	private JTextField deliveryidText=new JTextField("");
	private JTextField senderText=new JTextField("");
	
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
	
	public SendPanel(){
		this.date.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.date.setFont(WORD_FONT);	
		this.dateText.setBounds(START_X + LABEL_W + LINE_GAP, START_Y, TEXT_W, TEXT_H);
		this.dateText.setFont(WORD_FONT);
		dateChoose.register(dateText);
		this.dateText.setOpaque(false);
		
		this.businessid.setBounds(START_X, START_Y + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.businessid.setFont(WORD_FONT);
		this.businessidText.setBounds(this.dateText.getX(), this.businessid.getY(), TEXT_W, TEXT_H);
		this.businessidText.setFont(WORD_FONT);
		this.businessidText.setOpaque(false);
		
		this.deliveryid.setBounds(START_X, this.businessid.getY() + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.deliveryid.setFont(WORD_FONT);
		this.deliveryidText.setBounds(this.dateText.getX(), this.deliveryid.getY(), TEXT_W, TEXT_H);
		this.deliveryidText.setFont(WORD_FONT);
		this.deliveryidText.setOpaque(false);
		
		this.sender.setBounds(START_X, this.deliveryid.getY() + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.sender.setFont(WORD_FONT);
		this.senderText.setBounds(this.dateText.getX(), this.sender.getY(), TEXT_W, TEXT_H);
		this.senderText.setFont(WORD_FONT);
		this.senderText.setOpaque(false);
		
		
		this.result.setBounds(this.sender.getX() + LINE_GAP, this.sender.getY() + LABEL_H*6+ LINE_GAP,
				TEXT_W, BUTTON_H);
		this.result.setText("");
		
		this.ok.setBounds(this.sender.getX() + TEXT_W, this.sender.getY() + LABEL_H*6+ LINE_GAP,
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
						String senderStr=senderText.getText();
						String deliveryidStr=deliveryidText.getText();
						String businessidStr=businessidText.getText();
						
						sendVO=new SendFormVO(dateStr,deliveryidStr,senderStr);
						sendVO.setBusinessID(businessidStr);
						if(receAndSendCon.addSendFrom(sendVO)){
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
				//设置取消按钮不可见
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
		this.add(businessid);
		this.add(businessidText);
		this.add(deliveryid);
		this.add(deliveryidText);
		this.add(sender);
		this.add(senderText);
		this.add(result);
		this.add(ok);
		this.add(cancel);
	}
	
	private boolean isCorrect(){
		
		String dateStr=dateText.getText();
		String businessStr=businessidText.getText();
		String deliveryidStr=deliveryidText.getText();
		String senderStr=senderText.getText();
		
		if(!CommonLogic.isDate(dateStr)){
			dateText.setText("");
			return false;
		}else if(!businessStr.matches("\\d{6}")){
			businessidText.setText("");
			return false;
		}else if(!deliveryidStr.matches("\\d{10}")){
			deliveryidText.setText("");
			return false;
		}else if(senderStr.length()<1){
			return false;
		}
		
		return true;
	}
	
	private void disablePanel(){
		this.dateText.setEditable(false);
		this.senderText.setEditable(false);
		this.businessidText.setEditable(false);
		this.deliveryidText.setEditable(false);
	}
	
	private void enablePanel(){
		this.dateText.setEditable(true);
		this.senderText.setEditable(true);
		this.businessidText.setEditable(true);
		this.deliveryidText.setEditable(true);
	}
	
	private void setBlack(){
		this.dateText.setText("");
		this.senderText.setText("");
		this.businessidText.setText("");
		this.deliveryidText.setText("");
	}
}

