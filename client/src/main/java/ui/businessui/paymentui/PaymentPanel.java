package ui.businessui.paymentui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ui.DateChooser;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;
import vo.businessVO.ReceivableVO;
import businessLogic.businessLogicController.businessController.PaymentController;
import businessLogic.businessLogicModel.util.CommonLogic;

@SuppressWarnings("serial")
public class PaymentPanel extends DetailPanel{
	
	private PaymentController paymentCon=new PaymentController();
	private ReceivableVO receivableVO;
	
	private DateChooser dateChoose=DateChooser.getInstance();
	
	private JLabel date=new JLabel("收款日期");
	private JLabel money=new JLabel("收款金额");
	private JLabel courier=new JLabel("收款快递员");//快递员
	private JLabel deliveryid=new JLabel("订单条形码号");
	
	private JLabel result=new JLabel();
	
	private JTextField dateText=new JTextField();
	private JTextField moneyText=new JTextField();
	private JTextField courierText=new JTextField();//快递员
	private JTextArea deliveryidText=new JTextArea();
	
	private LimpidButton ok = new LimpidButton("","picture/确定.png");
	
	private LimpidButton cancel = new LimpidButton("","picture/取消.png");
	
	private static final int LABEL_W = 120;
	
	private static final int LABEL_H = 25;

	private static final int LINE_GAP = 18;
	
	private static final int TEXT_W = LABEL_W *3;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int START_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W) / 3;
	
	private static final int START_Y = START_X>>1;
	
	private static final int BUTTON_W = LABEL_W-40;
	
	private static final int BUTTON_H = LABEL_H+5;
	
	private static final Font WORD_FONT = new Font("宋体", Font.PLAIN, 18);
	
	private boolean isFirstEnsure = true;
	
	private boolean isOver=false;
	
	
	private String businessID="025001";
	public PaymentPanel(){
		this.date.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.date.setFont(WORD_FONT);	
		this.dateText.setBounds(START_X + LABEL_W + LINE_GAP, START_Y, TEXT_W, TEXT_H);
		this.dateText.setFont(WORD_FONT);
		dateChoose.register(dateText);
		this.dateText.setOpaque(false);
		
		this.money.setBounds(START_X, START_Y + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.money.setFont(WORD_FONT);
		this.moneyText.setBounds(this.dateText.getX(), this.money.getY(), TEXT_W, TEXT_H);
		this.moneyText.setFont(WORD_FONT);
		this.moneyText.setOpaque(false);
		
		this.courier.setBounds(START_X, this.money.getY() + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.courier.setFont(WORD_FONT);
		this.courierText.setBounds(this.dateText.getX(), this.courier.getY(), TEXT_W, TEXT_H);
		this.courierText.setFont(WORD_FONT);
		this.courierText.setOpaque(false);
		
		this.deliveryid.setBounds(START_X, this.courier.getY() + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.deliveryid.setFont(WORD_FONT);
		this.deliveryidText.setBounds(this.dateText.getX(), this.deliveryid.getY(), TEXT_W, TEXT_H<<2);
		this.deliveryidText.setFont(WORD_FONT);
//		this.deliveryidText.setOpaque(false);
		
		this.result.setBounds(this.deliveryid.getX()+ LINE_GAP , this.deliveryid.getY() + LABEL_H*6+ LINE_GAP,
				TEXT_W, TEXT_H);
		this.setFont(WORD_FONT);
		this.result.setText("");
		
		
		this.ok.setBounds(this.deliveryid.getX() + TEXT_W, this.deliveryid.getY() + LABEL_H*6+ LINE_GAP,
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
						String moneyStr=moneyText.getText();
						String courierStr=courierText.getText();
						String deliveryidStr=deliveryidText.getText();
						ArrayList<String> deliveryList=new ArrayList<String>();
						String [] str=deliveryidStr.split("\n");
						for(String s:str){
//							System.out.println(s);
							deliveryList.add(s);
						}
						receivableVO=new ReceivableVO(dateStr,Double.parseDouble(moneyStr),courierStr,deliveryList,businessID);
						
						if(paymentCon.addPayentForm(receivableVO)){
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
		this.add(money);
		this.add(moneyText);
		this.add(courier);
		this.add(courierText);
		this.add(deliveryid);
		this.add(deliveryidText);
		this.add(result);
		this.add(ok);
		this.add(cancel);
	}
	
	private boolean isCorrect(){
		
		String dateStr=dateText.getText();
		String moneyStr=moneyText.getText();
		String deliveryidStr=deliveryidText.getText();
		String [] str=deliveryidStr.split("\n");
		if(!CommonLogic.isDate(dateStr)){
			dateText.setText("");
			return false;
		}else if(!CommonLogic.isDouble(moneyStr)){
			moneyText.setText("");
			return false;
		}
			
		for(String s:str){
		  if(!s.matches("\\d{10}")){
			deliveryidText.setText("");
			return false;
		  }
		}  
		
		return true;
	}
	
	private void disablePanel(){
		this.dateText.setEditable(false);
		this.moneyText.setEditable(false);
		this.courierText.setEditable(false);
		this.deliveryidText.setEditable(false);
	}
	
	private void enablePanel(){
		this.dateText.setEditable(true);
		this.moneyText.setEditable(true);
		this.courierText.setEditable(true);
		this.deliveryidText.setEditable(true);
	}
	
	private void setBlack(){
		this.dateText.setText("");
		this.moneyText.setText("");
		this.courierText.setText("");
		this.deliveryidText.setText("");
	}
}
