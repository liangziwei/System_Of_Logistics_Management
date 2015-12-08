package ui.deliveryui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import businessLogic.businessLogicController.deliveryController.ReceiptController;
import businessLogicService.deliveryBLService.ReceiptBLService;
import constant.LabelName;
import constant.VerifyResult;
import ui.baseui.DatePanel;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;
import vo.deliveryVO.ReceiptVO;
import vo.deliveryVO.VerifyMessage;

@SuppressWarnings("serial")
public class ReceiptPanel extends DetailPanel{
	
	private ReceiptBLService receipt = new ReceiptController();
	
	private JLabel nameLabel = new JLabel("收件人姓名");
	
	private JTextField nameText = new JTextField();
	
	private JLabel idLabel = new JLabel("收件编号");
	
	private JTextField idText = new JTextField();
	
	private JLabel dateLabel = new JLabel("收件日期");

	private DatePanel date = new DatePanel();
	
	private JLabel state = new JLabel();
	
	private LimpidButton ok = new LimpidButton("","picture/确定.png");
	
	private LimpidButton cancel = new LimpidButton("","picture/取消.png");
	
	private static final int LABEL_W = 100;
	
	private static final int LABEL_H = 30;
	
	/**
	 * 每行信息之间的间隔
	 */
	private static final int LINE_GAP = 60;
	
	private static final int TEXT_W = LABEL_W << 1;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int START_X = (DETAIL_PANEL_W - LABEL_W - TEXT_W) >> 3;
	
	private static final int START_Y = START_X;
	
	private static final int BUTTON_W = LABEL_W-20;
	
	private static final int BUTTON_H = LABEL_H;
	
	private static final Font WORD_FONT = new Font("宋体", Font.PLAIN, 18);
	
	private boolean isFirstEnsure = true;
	
	public ReceiptPanel() {
		//名字标签
		this.nameLabel.setBounds(START_X, START_Y, LABEL_W, LABEL_H);
		this.nameLabel.setFont(WORD_FONT);
		//名字文本框
		this.nameText.setBounds(START_X + LABEL_W + LINE_GAP, START_Y, TEXT_W, TEXT_H);
		this.nameText.setFont(WORD_FONT);
		this.nameText.setOpaque(false);
		//收件编号标签
		this.idLabel.setBounds(START_X, START_Y + LABEL_H + LINE_GAP, LABEL_W, LABEL_H);
		this.idLabel.setFont(WORD_FONT);
		//收件编号文本框
		this.idText.setBounds(this.nameText.getX(), this.idLabel.getY(), TEXT_W, TEXT_H);
		this.idText.setFont(WORD_FONT);
		this.idText.setOpaque(false);
		//收件日期标签
		this.dateLabel.setBounds(START_X, this.idLabel.getY() + LABEL_H + LINE_GAP,
				LABEL_W , LABEL_H);
		this.dateLabel.setFont(WORD_FONT);
		//收件日期面板
		this.date.setPanelBound(this.nameText.getX(), this.idLabel.getY() + LABEL_H + LINE_GAP,
				TEXT_W << 1, TEXT_H);
		this.date.setDate();
		this.date.setOpaque(false);
		//确定按钮
		this.ok.setBounds(this.date.getX() + TEXT_W, this.date.getY() + LABEL_H + LINE_GAP,
				BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
//		this.ok.setIcon(new ImageIcon("picture/确定.png"));
//		this.ok.setBorderPainted(false);
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + BUTTON_W + LINE_GAP, this.ok.getY(), BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		this.cancel.setVisible(false);
//		this.cancel.setIcon(new ImageIcon("picture/取消.png"));
//		this.cancel.setBorderPainted(false);
		//错误提示
		this.state.setBounds(this.idLabel.getX(),
				this.dateLabel.getY() + (LABEL_H << 1), TEXT_W + LABEL_W, TEXT_H);
		this.state.setFont(WORD_FONT);
		//添加事件监听
		this.addListener();
		//将组件添加到主面板
		this.addComponents();
	}
	
	private void addComponents() {
		this.setLayout(null);
		this.add(this.nameLabel);
		this.add(this.nameText);
		this.add(this.idLabel);
		this.add(this.idText);
		this.add(this.dateLabel);
		this.add(this.date);
		this.add(this.ok);
		this.add(this.cancel);
		this.add(this.state);
	}
	
	private void addListener() {
		
		//确定按钮
		this.ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//验证收件信息是否合法
				VerifyMessage msg = receipt.verifyReceiptInfo
						(new ReceiptVO(idText.getText(), nameText.getText(), date.getDate()));
				//消除之前的错误标记
				nameLabel.setForeground(Color.BLACK);
				idLabel.setForeground(Color.BLACK);
				state.setText("");
				//验证之后的操作
				if(msg.getResult() == VerifyResult.FAIL)
					verifyFailOperation(msg);
				else 
					verifySuccessOperation();
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
				enableComponents();
				//消除提示信息
				state.setText("");
			}
		});
	}
	
	private void verifySuccessOperation() {
		//如果是第一次点击确认
		if(isFirstEnsure) {
			this.isFirstEnsure = false;
			//使组件不可编辑
			this.disableComponents();
			//询问用户是否确定保存
			this.state.setForeground(Color.RED);
			this.state.setText("请再次确认信息，需要修改请按取消");
			//使取消按钮可见
			this.cancel.setVisible(true);
		}else {
			//保存收件信息
			boolean result = receipt.saveReceiptInfo
					(new ReceiptVO(idText.getText(), nameText.getText(), date.getDate()));
			
			//更新数据库中的快递时间历史记录
			receipt.updateTimeRecord(nameText.getText(), date.getDate(), idText.getText());
			if(result) {
				state.setForeground(Color.BLUE);
				state.setText("收件信息保存成功");
			}
			else {
				state.setForeground(Color.RED);
				state.setText("失败，请确认信息输入是否正确");
			}
			//使组件可编辑
			this.enableComponents();
			//清空信息
			this.nameText.setText("");
			this.idText.setText("");
			//设置状态为第一次点击确认按钮
			this.isFirstEnsure = true;
			//设置取消按钮不可见
			this.cancel.setVisible(false);
		}
	}
	
	private void verifyFailOperation(VerifyMessage msg) {
		//使标签变红，提示错误位置
		if(msg.getLabel() == LabelName.RECEIVER_NAME) {
			nameLabel.setForeground(Color.RED);
		}
		else if(msg.getLabel() == LabelName.GOODS_ID) {
			idLabel.setForeground(Color.RED);
		}
		//提示修改建议
		state.setForeground(Color.RED);
		state.setText(msg.getErrorMsg());
	}
	
	private void disableComponents() {
		this.nameText.setEditable(false);
		this.idText.setEditable(false);
	}
	
	private void enableComponents() {
		this.nameText.setEditable(true);
		this.idText.setEditable(true);
	}
}
