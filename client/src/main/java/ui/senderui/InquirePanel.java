package ui.senderui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businessLogicService.senderBLService.InquireBLService;
import constant.City;
import stub.businessLogicImpl_stub.senderBLImpl_stub.InquireBLImpl_Stub;
import ui.mainui.ExpressFrame;
import ui.mainui.ExpressPanel;
import ui.viewcontroller.ViewController;
import vo.senderVO.LogisticsVO;

@SuppressWarnings("serial")
public class InquirePanel extends JPanel{
	
	private ViewController viewController;
	
	private InquireBLService inquireService = new InquireBLImpl_Stub();
	
	/**
	 * 是否显示物流信息
	 */
	private boolean isShow = false;
	
	private LogisticsVO logisticsInfo;
	
	private JTextField search = new JTextField();
	
	private JLabel orderLabel = new JLabel("订单条形码号");
	
	private JButton ok = new JButton("查询");
	
	private JButton cancel = new JButton("取消");
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 15);
	
	private static final int LABEL_W = 150;
	
	private static final int LABEL_H = 40;
	
	private static final int TEXT_W = LABEL_W;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int BUTTON_W = 72;
	
	private static final int BUTTON_H = LABEL_H;
	
	
	private static final int COMPONENT_GAP = (ExpressFrame.FRAME_W - LABEL_W - TEXT_W - (BUTTON_W << 1)) / 5;
	
	/**
	 *组件与组件的距离 
	 */
	private static final int ORDER_X = COMPONENT_GAP;
	
	private static final int ORDER_Y = COMPONENT_GAP; 	
	 
	public InquirePanel(ViewController viewController) {
		this.viewController = viewController;
		//面板
		this.setLayout(null);
		this.setBounds(0, 0, ExpressFrame.FRAME_W, ExpressFrame.FRAME_H);
		//订单条形码号标签
		this.orderLabel.setBounds(ORDER_X, ORDER_Y, LABEL_W, LABEL_H);
		this.orderLabel.setFont(WORD_FONT);
		//订单条形码号文本框
		this.search.setBounds(this.orderLabel.getX() + LABEL_W , this.orderLabel.getY(),
				TEXT_W + COMPONENT_GAP, TEXT_H);
		this.search.setFont(WORD_FONT);
		//确定按钮
		this.ok.setBounds(this.search.getX() + TEXT_W + (COMPONENT_GAP << 1),
				          this.search.getY(),
				          BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		//取消按钮
		this.cancel.setBounds(this.ok.getX() + BUTTON_W + COMPONENT_GAP, this.ok.getY(),
				BUTTON_W, BUTTON_H);
		this.cancel.setFont(WORD_FONT);
		//把组件添加到面板
		this.add(this.orderLabel);
		this.add(this.search);
		this.add(this.ok);
		this.add(this.cancel);
		//添加事件监听
		this.addListener(this.ok, this.cancel);
	}
	
	private void addListener(JButton ok, JButton cancel) {
		
		ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//检查订单条形码号是否有效
				String id = search.getText();
				if(id.length() != 10) {
					//TODO 提示输入不是10位数字
					return ;
				}
				for (int i = 0; i < 10; i++) {
					if(id.charAt(i) > '9' || id.charAt(i) < '0') {
						//TODO 提示输入不是10位数字
						return ;
					}
				}
				//检查是否存在该条形码号对应的订单
				logisticsInfo = inquireService.getLogInfoById(id);
				if(logisticsInfo == null) {
					//TODO 提示输入的订单条形码号不存在
					return ;
				}
				//显示物流信息
				isShow = true;
				repaint();
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//设当前页面不可见
				setVisible(false);
				//回到开始页面
				viewController.switchView(ExpressPanel.class.getName());
			}
		});
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(!isShow) return ;
		//TODO 绘制物流轨迹
		List<City> trace = this.logisticsInfo.getTrace();
		trace.size();
		int x = 100;
		int y = 200;
		for(int i = 0; i < trace.size(); i++) {
			g.fillRect(x + i * 100, y + i * 70, 40, 40);
			g.drawString(trace.get(i) + "", x + i * 100 + 40 + 40, y + i * 70 + 20);
		}
		for(int i = 0; i < trace.size() - 1; i++) {
			g.drawLine(x + i * 100 + 40, y + i * 70 + 40,
					x + (i + 1) * 140 - 40, y + (i + 1) * (70 + 40) - 40);
		}
	}
}
