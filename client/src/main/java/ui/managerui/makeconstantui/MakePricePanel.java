package ui.managerui.makeconstantui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import businessLogic.businessLogicController.managerController.MakeConstantController;
import businessLogic.businessLogicModel.util.CommonLogic;
import businessLogicService.managerBLService.MakeConstantBLService;
import po.constant.PackPrice;
import po.constant.TransitPrice;
import ui.baseui.DetailPanel;
import ui.baseui.LimpidButton;

@SuppressWarnings("serial")
public class MakePricePanel extends DetailPanel{
	
	private MakeConstantBLService makePrice = new MakeConstantController();
	
	private JTable price = null;
	
	private JScrollPane container = new JScrollPane();
	
	private LimpidButton ok = new LimpidButton("","picture/确定.png");
	
	private JLabel tip = new JLabel();
	
	private static Font WORD_FONT = new Font("宋体", Font.PLAIN, 15);
	
	private static final int BUTTON_W = 140;
	
	private static final int BUTTON_H = 42;
	
	private static final int LABEL_W = BUTTON_W;
	
	private static final int LABEL_H = BUTTON_H;
	
	private static final int TABLE_W = DETAIL_PANEL_W * 3 >> 2;
	
	private static final int TABLE_X = (DETAIL_PANEL_W - TABLE_W) >> 1;
	
	private static final int TABLE_Y = TABLE_X >> 1;
	
	public MakePricePanel() {
		//初始化价格表格
		this.initPriceTable();
		//初始化按钮
		this.initButtons();
		//提示标签
		this.tip.setBounds(this.container.getX(), this.ok.getY(), LABEL_W << 1, LABEL_H);
		this.tip.setFont(WORD_FONT);
		this.add(this.tip);
	}
	
	private void initPriceTable() {
		//列名
		Object[] names = new Object[] {
				"类型", "价格"
		};
		//数据
		PackPrice pack = this.makePrice.getPackPrice();  //快递包装费
		TransitPrice transit = this.makePrice.getTransitPrice();
		Object[][] datas = new Object[][] {
			{"木箱包装费(元)", pack.getWooden() + ""},
			{"纸箱包装费(元)", pack.getCarton() + ""},
			{"快递袋包装费(元)", pack.getCourierBag() + ""},
			{"其他包装费(元)", pack.getOther() + ""},
			{"飞机每公里每吨(元)", transit.getAir() + ""},
			{"汽车每公里每吨(元)", transit.getRailway() + ""},
			{"火车每公里每吨(元)", transit.getRoad() + ""}
		};
		this.price = new JTable(datas, names);
		this.price.setRowHeight(32);
		this.price.setFont(WORD_FONT);
		//列表容器
		this.container.setBounds(TABLE_X, TABLE_Y, TABLE_W, 247);
		this.container.setViewportView(this.price);
		
		this.add(this.container);
	}
	
	private void initButtons() {
		//确定按钮
		this.ok.setBounds(this.container.getX() + (TABLE_W >> 1) - (BUTTON_W >> 1), 
				this.container.getY() + this.container.getHeight() + (BUTTON_H * 3 >> 1), BUTTON_W, BUTTON_H);
		this.ok.setFont(WORD_FONT);
		//将按钮添加到面板
		this.add(this.ok);
		//添加事件监听
		this.addListener();
	}
	
	private void addListener() {
		//确定按钮
		this.ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//验证包装 输入是否合法
				int rowNum = price.getRowCount();
				boolean isValidate = true;
				for(int i = 0; i < rowNum; i++) {
					if(!CommonLogic.isDouble((String)price.getValueAt(i, 1)))
						isValidate = false;
				}
				//如果合法
				if(isValidate) {
					//保存快递包装价格常量
					savePackPrice();
					//保存运输 价格常量
					saveTranstiPrice();
					//提示
					tip.setForeground(Color.BLUE);
					tip.setText("修改成功");
				}
				else {
					tip.setForeground(Color.RED);
					tip.setText("输入中含有非数字");
				}
				//刷新面板
				repaint();
			}
		});
	}
	
	/**
	 *将对价格常量的修改保存
	 */
	private void savePackPrice() {
		String carton = (String)price.getValueAt(1, 1);
		String wooden = (String)price.getValueAt(0, 1);
		String courier = (String)price.getValueAt(2, 1);
		String other = (String)price.getValueAt(3, 1);
		this.makePrice.setPackPrice(new PackPrice(Double.parseDouble(carton),
				Double.parseDouble(wooden), Double.parseDouble(courier),
				Double.parseDouble(other)));
	}
	
	/**
	 * 将对运输价格常量的修改保存
	 */
	private void saveTranstiPrice() {
		String air = (String)price.getValueAt(4, 1);
		String railway = (String)price.getValueAt(6, 1);
		String road = (String)price.getValueAt(5, 1);
		this.makePrice.setTransitPrice(new TransitPrice(Double.parseDouble(air),
				Double.parseDouble(railway), Double.parseDouble(road)));
	}
}
