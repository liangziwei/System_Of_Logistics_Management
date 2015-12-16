package ui.senderui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businessLogic.businessLogicController.senderController.InquireController;
import businessLogicService.senderBLService.InquireBLService;
import constant.City;
import ui.baseui.LimpidButton;
import ui.mainui.ExpressFrame;
import ui.mainui.ExpressPanel;
import ui.viewcontroller.ViewController;
import vo.senderVO.LogisticsVO;

@SuppressWarnings("serial")
public class InquirePanel extends JPanel{
	
	private ViewController viewController;
	
	private InquireBLService inquireService = new InquireController();
	
	private boolean isShow = false;	//是否显示物流信息
	
	private LogisticsVO logisticsInfo;
	
	private JTextField search = new JTextField();
	
	private JLabel orderLabel = new JLabel("订单条形码号");
	
	private LimpidButton ok = new LimpidButton("","picture/查询.png");
	
	private LimpidButton cancel = new LimpidButton("","picture/取消.png");
	
	private static Image NAN_JING = new ImageIcon("picture/city/nan_jing.png").getImage();
	
	private static Image BEI_JING = new ImageIcon("picture/city/bei_jing.png").getImage();
	
	private static Image SHANG_HAI = new ImageIcon("picture/city/shang_hai.png").getImage();
	
	private static Image GUANG_ZHOU = new ImageIcon("picture/city/guang_zhou.png").getImage();
	
	private static Map<City, Image> CITY_IMG_MAP = new HashMap<City, Image>();
	
	static {
		CITY_IMG_MAP.put(City.NAN_JING, NAN_JING);
		CITY_IMG_MAP.put(City.BEI_JING, BEI_JING);
		CITY_IMG_MAP.put(City.SHANG_HAI, SHANG_HAI);
		CITY_IMG_MAP.put(City.GUANG_ZHOU, GUANG_ZHOU);
	}
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 15);
	
	private static final int LABEL_W = 150;
	
	private static final int LABEL_H = 30;
	
	private static final int TEXT_W = LABEL_W;
	
	private static final int TEXT_H = LABEL_H;
	
	private static final int BUTTON_W = 80;
	
	private static final int BUTTON_H = LABEL_H;
	
	private static final int COMPONENT_GAP = (ExpressFrame.FRAME_W - LABEL_W - TEXT_W - (BUTTON_W << 1)) / 5;
	
	private static Image BACKGROUND = new ImageIcon("picture/background.jpg").getImage();
	
	private static final int ORDER_X = COMPONENT_GAP;	//组件与组件的距离 
	
	private static final int ORDER_Y = COMPONENT_GAP; 	
	 
	public InquirePanel(ViewController viewController) {
		this.viewController = viewController;
		
		//面板
		this.setLayout(null);
		this.setBounds(0, 0, ExpressFrame.FRAME_W, ExpressFrame.FRAME_H);
		//订单条形码号标签
		this.orderLabel.setBounds(ORDER_X+60, ORDER_Y, LABEL_W, LABEL_H);
		this.orderLabel.setFont(WORD_FONT);
		//订单条形码号文本框
		this.search.setBounds(this.orderLabel.getX() + LABEL_W , this.orderLabel.getY(),
				TEXT_W + COMPONENT_GAP, TEXT_H);
		this.search.setFont(WORD_FONT);
		this.search.setOpaque(false);
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
		
		LogisticsVO vo = this.inquireService.getLogInfoById(this.search.getText());
		//TODO 检测
		List<City> trace =vo.getTrace();
		trace.add(City.NAN_JING);
		trace.add(City.BEI_JING);
		trace.add(City.SHANG_HAI);
		trace.add(City.GUANG_ZHOU);
		//绘制物流轨迹
		int size = trace.size();
		int startX = 100;	//第一张图片X坐标
		int startY = 200;	//第一张图片Y坐标
		int yGap = 30;		//图片之间在Y轴上的距离
		int xGap = 210;		//图片之间在X轴上的距离
		Image img = null;
		for(int i = 0; i < size; i++) {
			img = CITY_IMG_MAP.get(trace.get(i));
			int imgW = img.getWidth(null);		
			int imgH = img.getHeight(null);		
			g.drawImage(CITY_IMG_MAP.get(trace.get(i)),
					startX + i * xGap, startY + yGap * i,
					imgW, imgH, null);
		}
		//绘制图片之间的连线
		g.setColor(Color.WHITE);
		int x1 , x2 , y1, y2, w, h;
		for(int i = 0; i < size - 1; i++) {
			img = CITY_IMG_MAP.get(trace.get(i));
			w = img.getWidth(null);
			h = img.getHeight(null);
			x1 = startX + w + i * xGap;
			y1 = startY + (h >> 1) + i * yGap;
			x2 = x1 + xGap - w;
			y2 = y1 + yGap;
			g.drawLine(x1, y1, x2, y2);
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(BACKGROUND, 0, 0, this.getWidth(), this.getHeight(), null);
	}
}
